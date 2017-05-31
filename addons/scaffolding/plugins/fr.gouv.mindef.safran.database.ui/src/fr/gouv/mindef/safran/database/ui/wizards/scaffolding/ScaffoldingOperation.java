/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.statushandlers.StatusManager;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Namespace;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldFactory;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.transfo.Transformation;
import fr.gouv.mindef.safran.database.transfo.impl.EntityToMLD;
import fr.gouv.mindef.safran.database.transfo.impl.MLDToEntity;
import fr.gouv.mindef.safran.database.transfo.impl.MLDToMPD;
import fr.gouv.mindef.safran.database.transfo.impl.MPDToMLD;
import fr.gouv.mindef.safran.database.ui.Activator;

/**
 * Operation which creates or updates a scaffold model and then launches the transformation
 * @author sthibaudeau
 *
 */
public class ScaffoldingOperation extends WorkspaceModifyOperation {
	private static final String SCAFFOLD_FOLDER = "scaffold";

	private boolean success = false;
	
	private Session session = null;
	
	private ScaffoldInfo scaffoldInfo;
	private ScaffoldType scaffoldType;
	
	public ScaffoldingOperation(ScaffoldType scaffoldType, EObject startingObject, EObject endingObject, Iterable<EObject> additionalObjects) {
		super();
		this.scaffoldInfo = getScaffoldInfo(scaffoldType, startingObject, endingObject, additionalObjects);
		this.scaffoldType = scaffoldType;
		this.session = SessionManager.INSTANCE.getSession(startingObject);
	}
	
	public ScaffoldingOperation(ScaffoldInfo scaffoldInfo,
			ScaffoldType scaffoldType) {
		super();
		this.scaffoldInfo = scaffoldInfo;
		this.scaffoldType = scaffoldType;
		this.session = SessionManager.INSTANCE.getSession(scaffoldInfo);
	}
	
	private ScaffoldInfo getScaffoldInfo(ScaffoldType scaffoldType, EObject startingObject, EObject endingObject, Iterable<EObject> additionalObjects) {
		ScaffoldInfo scaffoldInfo = ScaffoldFactory.eINSTANCE.createScaffoldInfo();
		scaffoldInfo.setLeftObject(startingObject);
		scaffoldInfo.setRightObject(endingObject);
		for (EObject object : additionalObjects) {
			scaffoldInfo.addAdditionalObjectsForTransformation(object, scaffoldType);
		}
		return scaffoldInfo;
	}
	
	private IProject getEnclosingProject() {
		Resource airdResource = session.getSessionResource();
		String platformString = airdResource.getURI().toPlatformString(true);
		IResource file = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		if (file != null) {
			return file.getProject();
		}
		return null;
	}
	
	private String getLabel(EObject object) {
		if (object instanceof NamedElement) {
			return ((NamedElement) object).getName();
		}
		if (object instanceof Root) {
			String name = ((Root) object).getName();
			if (name == null || name.trim().isEmpty()) {
				return "Entities";
			}
			return name;
		}
		if (object instanceof Namespace) {
			return ((Namespace) object).getName();
		}
		return null;
	}
	
	private String getScaffoldFolderName(IProject project) {
		// Create scaffold folder if needed
		String scaffoldFolderName = SCAFFOLD_FOLDER;
		
		boolean folderExists = false;
		IResource scaffoldFolder = null;
		while (folderExists == false && !scaffoldFolderName.endsWith("__________")) {
			scaffoldFolder = project.findMember(scaffoldFolderName);
			if (scaffoldFolder == null) {
				// Create the folder
				scaffoldFolder = project.getFolder(scaffoldFolderName);
				try {
					((IFolder)scaffoldFolder).create(true, true, new NullProgressMonitor());
					if (scaffoldFolder.exists()) {
						return scaffoldFolderName;
					} else {
						scaffoldFolderName += '_';
					}
				} catch (CoreException e) {
					// Unable to create folder, let's try with another name
					scaffoldFolderName += '_';
				}
			} else if (!(scaffoldFolder instanceof IContainer)) {
				// Select another name for the folder
				scaffoldFolderName += '_';
			} else {
				return scaffoldFolderName;
			}
		}
		
		return null;
	}
	
	private String getScaffoldModelName() {
		EObject startingObject = scaffoldInfo.getStartingObjectForTransformation(scaffoldType);
		EObject endingObject = scaffoldInfo.getEndingObjectForTransformation(scaffoldType);
		
		String sourceLabel = getLabel(startingObject);
		String targetLabel = getLabel(endingObject);
		return scaffoldType.getName() + "_" + sourceLabel + "_" + targetLabel;
	}
	
	private String getFilenameForScaffoldModel(String name, int count) {
		if (count == 0) {
			return name + ".scaffold";
		} else {
			return name + "_" + count + ".scaffold";
		}
	}
	
	private Resource createScaffoldResourceForLocalProject() {
		IProject project = getEnclosingProject();
		
		// Create scaffold folder
		String folder = getScaffoldFolderName(project);
		
		String name = getScaffoldModelName();
		
		// Define scaffold model filename
		IFile scaffoldModelFile = null;
		boolean nameOK = false;
		int count = 0;
		String path = null;
		while (nameOK == false) {
			path = folder + "/" + getFilenameForScaffoldModel(name, count);
			
			scaffoldModelFile = project.getFile(path);
			
			if (scaffoldModelFile.exists()) {
				count++;
			} else {
				nameOK = true;
			}
		}
		
		// Create the resource
		ResourceSet set = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(project.getName() + "/" + path, true);
		Resource resource = set.createResource(uri);
		resource.getContents().add(scaffoldInfo);
		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			// Do nothing
		}
		// Reload the new resource
		resource = session.getTransactionalEditingDomain().getResourceSet().getResource(uri, true);
		return resource;
	}
	
	private Resource createScaffoldResourceForSharedProject(CDOView cdoView) {
		CDOTransaction transaction = (CDOTransaction)cdoView;
		String name = getScaffoldModelName();
		int count = 0;
		while (count < 10) {
			String path = SCAFFOLD_FOLDER + "/" + getFilenameForScaffoldModel(name, count);
			// Create resource
			CDOResource resource = transaction.getOrCreateResource(path);
			// Check if it is empty
			if (resource.getContents().isEmpty()) {
				resource.getContents().add(scaffoldInfo);
				return resource;
			} else {
				// try with another name
				count++;
			}
		}
		return null;
	}
	
	private Resource createScaffoldResource() {
		Resource resource = null;
		
		EObject startingObject = scaffoldInfo.getStartingObjectForTransformation(scaffoldType);
		CDOObject startingObjectAsCdo = CDOUtil.getCDOObject(startingObject);
		CDOView cdoView = startingObjectAsCdo.cdoView();
		if (cdoView == null) {
			// Non shared project
			resource = createScaffoldResourceForLocalProject();
		} else {
			// Shared project
			resource = createScaffoldResourceForSharedProject(cdoView);
		}
		
		// Add as a semantic resource
		AddSemanticResourceCommand addSemanticResourceCmd = new AddSemanticResourceCommand(session, resource.getURI(), new NullProgressMonitor());
		session.getTransactionalEditingDomain().getCommandStack().execute(addSemanticResourceCmd);
		
		return resource;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		if (scaffoldInfo.eResource() == null) {
			// We have to create a scaffold model
			Resource scaffoldResource = createScaffoldResource();
			EObject newInfo = scaffoldResource.getContents().get(0);
			if (newInfo instanceof ScaffoldInfo) {
				scaffoldInfo = (ScaffoldInfo)newInfo;
			}
		}
		
		final Transformation transformation = createTransformation();
		try {
			RecordingCommand transformCommand = new RecordingCommand(session.getTransactionalEditingDomain(), "Scaffolding transformation") {
				@Override
				protected void doExecute() {
					success = transformation.transform(scaffoldInfo, scaffoldType);					
				}
			};
			session.getTransactionalEditingDomain().getCommandStack().execute(transformCommand);
		} catch (RuntimeException e) {
			logError("An error occured during the transformation", e);
			return;
		}
		
	}
	
	private Transformation createTransformation() {
		Transformation transformation = null;
		switch (scaffoldType) {
		case ENTITY_TO_MLD:
			transformation = new EntityToMLD();
			break;
		case MLD_TO_ENTITY:
			transformation = new MLDToEntity();
			break;
		case MLD_TO_MPD:
			transformation = new MLDToMPD();
			break;
		case MPD_TO_MLD:
			transformation = new MPDToMLD();
			break;
		}
		return transformation;
	}
	
	private void logError(String message, Exception e) {
		success = false;
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
		StatusManager.getManager().handle(status, StatusManager.LOG);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public ScaffoldInfo getScaffoldInfo() {
		return scaffoldInfo;
	}
}
