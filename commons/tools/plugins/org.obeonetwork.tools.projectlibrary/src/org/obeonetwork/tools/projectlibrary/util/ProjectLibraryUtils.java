/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.extension.point.IResourceCopier;
import org.obeonetwork.tools.projectlibrary.extension.point.ResourceCopierFactory;
import org.obeonetwork.tools.projectlibrary.imp.ProjectLibraryImporter;

/**
 * Utilities around Project libraries
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryUtils {
	
	public void restoreReferences(Collection<RestorableReference> restorableReferences, Session targetSession) {
		IdUtils idUtils = new IdUtils(targetSession);
		
		TransactionalEditingDomain ted = targetSession.getTransactionalEditingDomain();
		
		if (ted != null) {
			for (RestorableReference restorableReference : restorableReferences) {
				EObject targetObject = idUtils.getCorrespondingObject(restorableReference.getTargetKey());
				EObject sourceObject = restorableReference.getSourceObject();
				EStructuralFeature referencingFeature = restorableReference.getReferencingFeature();
				
				if (targetObject != null && referencingFeature.isChangeable()) {
					SetCommand cmd = null;
					if (referencingFeature.isMany() && restorableReference.getPosition() != null) {
						// Multi valued feature
						int position = restorableReference.getPosition().intValue();
						cmd = new SetCommand(ted, sourceObject, referencingFeature, targetObject, position);
					} else {
						// Mono valued feature
						cmd = new SetCommand(ted, sourceObject, referencingFeature, targetObject);
					}
					if (cmd != null) {
						ted.getCommandStack().execute(cmd);
					}
				}
			}
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @param resourcesToDelete
	 * @param projectToRemove
	 * @return
	 */
	public boolean removeImportedProjectAndResources(ModelingProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove) {
		// Remove the resources
		boolean removed = removeResources(project.getSession(), resourcesToDelete);
		if (removed == true) {
			// Remove the manifest from the imported manifests
			new ManifestServices().removeImportedManifestFromSession(project.getSession(), projectToRemove);
		}
		
		// Clean empty folders
		IFolder librariesFolder = project.getProject().getFolder(ProjectLibraryImporter.IMPORT_FOLDER_NAME);
		if (librariesFolder != null) {
			IFolder projectFolder = librariesFolder.getFolder(new ManifestServices().getLibraryProjectName(projectToRemove));
			// TODO ProgressMonitor
			try {
				projectFolder.delete(true, new NullProgressMonitor());
			} catch (CoreException e) {
				// Do nothing
			}
		}
		
		return removed;
	}
	
	private boolean removeResources(Session session, Collection<Resource> resources) {
		if (session instanceof DAnalysisSession) {
			final DAnalysisSession analysisSession = (DAnalysisSession)session;
			analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(analysisSession.getTransactionalEditingDomain()) {
				
				@Override
				protected void doExecute() {
					removeResourcesFromSession(analysisSession, resources);
				}
			});
		}
		
		return true;
	}
	
	private void removeResourcesFromSession(DAnalysisSession analysisSession, Collection<Resource> resources) {
		for (Resource resource : resources) {
			if (analysisSession.getSemanticResources().contains(resource)) {
				analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RemoveSemanticResourceCommand(analysisSession, resource, new NullProgressMonitor(), false));
			} else if (analysisSession.getAllSessionResources().contains(resource)) {
				analysisSession.removeAnalysis(resource);
			}
		}
		for (Resource resource : resources) {
			for (EObject rootObject : new ArrayList<>(resource.getContents())) {
				SiriusUtil.delete(rootObject, analysisSession);
			}
			try {
				resource.delete(null);
			} catch (IOException e) {
//				 TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Returns external references to objects in the collection of resources
	 * @param session
	 * @param resources
	 * @return
	 */
	public Collection<Setting> getExternalReferences(Session session, Collection<Resource> resources) {
		ECrossReferenceAdapter xReferencer = session.getSemanticCrossReferencer();
		
		Collection<Setting> externalReferences = new ArrayList<>(); 
		
		for (Resource resource : resources) {
			TreeIterator<EObject> it = resource.getAllContents();
			while (it.hasNext()) {
				EObject object = it.next();
				
				Collection<Setting> inverseReferences = xReferencer.getInverseReferences(object);
				
				// Filter the references to keep only external references
				// and ignore the mainAnalysis.getReferencedAnalysis() feature too
				for (Setting setting : inverseReferences) {
					if (!resources.contains(setting.getEObject().eResource())) {
						if (!setting.getEStructuralFeature().equals(ViewpointPackage.Literals.DANALYSIS__REFERENCED_ANALYSIS)) {
							externalReferences.add(setting);							
						}
					}
				}
			}
		}
		return externalReferences;
	}
	
	/**
	 * Returns the external references that could not be restored after an import
	 * @param externalReferences External references
	 * @param deletedResources Resources that will be deleted
	 * @param newSession New session
	 * @return
	 */
	public Collection<RestorableReference> getRestorableReferences(Collection<Setting> externalReferences, Collection<Resource> deletedResources , Session newSession) {
		IdUtils idUtils = new IdUtils(newSession);
		
		Collection<RestorableReference> restorable = new ArrayList<>();
		
		for (Setting setting : externalReferences) {
			// Each setting can reference objects to restore but also objects that will still be here
			// we check the containing resource to be sure
			Object referencedObjects = setting.get(false);
			RestorableReference restorableReference = null;
			if (referencedObjects instanceof List)	{
				for (Object referencedObject : (List<?>)referencedObjects) {
					if (referencedObject instanceof EObject) {
						restorableReference = getRestorableReference(setting, (EObject)referencedObject, deletedResources, idUtils);
					}
				}
			} else if (referencedObjects instanceof EObject) {
				restorableReference = getRestorableReference(setting, (EObject)referencedObjects, deletedResources, idUtils);
			}
			if (restorableReference != null) {
				restorable.add(restorableReference);
			}
		}
		
		return restorable;
	}
	
	private RestorableReference getRestorableReference(Setting setting, EObject referencedEObject, Collection<Resource> deletedResources, IdUtils idUtils) {
		if (deletedResources.contains(referencedEObject.eResource())) {
			// The referenced object will be removed
			// lets see if we can restore it
			if (idUtils.getCorrespondingObject(referencedEObject) != null) {
				
				EStructuralFeature feature = setting.getEStructuralFeature();
				
				Integer position = null;
				// if feature is multivalued we have to keep the position
				if (feature.isMany()) {
					Object value = setting.getEObject().eGet(feature);
					if (value instanceof List) {
						position = ((List<?>)value).indexOf(referencedEObject);
					}
				}
				
				return new RestorableReference(setting.getEObject(), feature, idUtils.getKey(referencedEObject), position);
			}
		}
		return null;
	}
	
	/**
	 * Returns the list of resources corresponding to a previously imported project
	 * @param session
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromManifest(ModelingProject modelingProject, MManifest projectToRemove) {
		IResourceCopier resourceCopier = ResourceCopierFactory.getInstance().getResourceCopier(modelingProject.getSession());
		return resourceCopier.getResourcesForImportedProject(modelingProject, projectToRemove);
	}
	
	

}
