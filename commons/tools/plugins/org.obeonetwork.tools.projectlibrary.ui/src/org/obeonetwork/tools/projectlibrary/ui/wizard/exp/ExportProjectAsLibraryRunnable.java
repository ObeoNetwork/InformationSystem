/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.tools.projectlibrary.exp.ProjectLibraryExporter;
import org.obeonetwork.tools.projectlibrary.imp.IConfirmationRunnable;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.tools.projectlibrary.imp.ProjectLibraryImporter;

public class ExportProjectAsLibraryRunnable implements IRunnableWithProgress {
	
	private boolean result;
	private Set<ModelingProject> selectedReferencingProjects = new HashSet<>();
	private ExportProjectAsLibraryWizardModel model;
	private Shell shell;
	
	public ExportProjectAsLibraryRunnable(ExportProjectAsLibraryWizardModel model, Set<ModelingProject> selectedReferencingProjects, Shell shell) {
		this.model = model;
		this.selectedReferencingProjects = selectedReferencingProjects;
		this.shell = shell;
	}

	public void run(IProgressMonitor monitor) {
		File targetDir = new File(model.getExportDirectory());
		File targetFile = new File(targetDir, model.getMarFileName());
		
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Generating MAR file", 2);
		
    	ProjectLibraryExporter exporter = new ProjectLibraryExporter();
		try {
			exporter.export(model.getSelectedModelingProject(),
					model.getProjectId(),
					model.getVersion(),
					model.getComment(),
					targetFile,
					subMonitor.split(1));
			
			refreshExportedFile(targetFile, subMonitor.split(1));
			
			for(ModelingProject referencingProject : selectedReferencingProjects) {
				SubMonitor subSubMonitor = SubMonitor.convert(monitor, "Importing MAR file for referencing project", 2);
				
				ProjectLibraryImporter importer = new ProjectLibraryImporter();
				try {
					importer.importIntoProject(referencingProject, targetFile, new IConfirmationRunnable() {
						
						@Override
						public boolean askForConfirmation(String message) {
							final AtomicBoolean res = new AtomicBoolean(true);
							Display.getDefault().syncExec(() -> res.set(MessageDialog.openConfirm(shell, "Import project as library", message))); 
							return res.get();
						}
					}, subMonitor.newChild(1), true);
				} catch (LibraryImportException e) {
					Display.getDefault().syncExec(() -> MessageDialog.openError(this.shell, "Import project as library", e.getMessage())); 
					result = false;
				}
				
				Session referencingSession = referencingProject.getSession();
				if(referencingSession == null) {
					final Option<URI> optionalUri = referencingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
					referencingSession = SessionManager.INSTANCE.getSession(optionalUri.get(), new NullProgressMonitor());
					referencingSession.open(new NullProgressMonitor());
				}
				String referencedProjectURI = "platform:/resource/" + model.getProjectId();
				for(Resource semanticResource : referencingSession.getSemanticResources()) {
					String resourceUri = semanticResource.getURI().toPlatformString(true);
					if(resourceUri != null && resourceUri.startsWith(referencedProjectURI)) {
						referencingSession.removeSemanticResource(semanticResource, null, false);
					}
				}
				
				subSubMonitor.done();
			}
			
			result = true;
		} catch (LibraryImportException e) {
			MessageDialog.openError(this.shell, "Export project as library", "An error occured while exporting project.\n\nError : " + e.getCause());
			result = false;
		}
		
		subMonitor.done();
    }
	
	public boolean getResult() {
		return result;
	}
	
	private void refreshExportedFile(File exportedFile, IProgressMonitor monitor) {
		IWorkspace workspace= ResourcesPlugin.getWorkspace(); 
		IPath location= Path.fromOSString(exportedFile.getAbsolutePath()); 
		IFile iFile= workspace.getRoot().getFileForLocation(location);
		if (iFile != null) {
			IContainer container = iFile.getParent();
			try {
				container.refreshLocal(IResource.DEPTH_ONE, monitor);
			} catch (CoreException e) {
				// Do nothing
			}
		}
	}
}
