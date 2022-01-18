/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.ui.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.tools.projectlibrary.ui.Activator;
import org.obeonetwork.tools.projectlibrary.util.ProjectLibraryUtils;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RemoveLibraryHandler extends AbstractHandler {
	
	private static final Image LIBRARY = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/mar.png").createImage();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		ModelingProject modelingProject = getModelingProjectFromSelection(selection);
		
		if (modelingProject != null) {
			Shell shell = HandlerUtil.getActiveShell(event);
			
			ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell, new LabelProvider() {
				@Override
				public String getText(Object element) {
					if (element instanceof MManifest) {
						MManifest manifest = (MManifest)element;
						return manifest.getProjectId() + " - " + manifest.getVersion(); 
					}
					return super.getText(element);
				}
				
				@Override
				public Image getImage(Object element) {
					if (element instanceof MManifest) {
						return LIBRARY;
					}
					return super.getImage(element);
				}
			});
			dlg.setTitle("Remove an imported project library");
			dlg.setMessage("Select a project library (* = any string, ? = any char):");
			dlg.setMultipleSelection(false);
			dlg.setElements(new ManifestServices().getImportedManifests(modelingProject.getSession()).toArray());
			
			if (dlg.open() == Window.OK) {
				Object selectedObject = dlg.getFirstResult();
				if (selectedObject instanceof MManifest) {
					MManifest projectToRemove = (MManifest)selectedObject;
					ProjectLibraryUtils util = new ProjectLibraryUtils();
					
					Collection<Resource> resourcesToDelete = util.getResourcesFromManifest(modelingProject, projectToRemove);
					Collection<Setting> externalRefs = util.getExternalReferences(modelingProject.getSession(), resourcesToDelete);
					boolean confirm = false;
					if (!externalRefs.isEmpty()) {
						confirm = MessageDialog.openConfirm(shell, "Remove project library", "Some elements in the project reference this library.\nDo you still want to remove the library ?");
					} else {
						confirm = true;
					}
					
					if (confirm == true) {
						// Remove the resources and the imported manifest
						try {
							util.removeImportedProjectAndResources(modelingProject, resourcesToDelete, projectToRemove);
						} catch (LibraryImportException e) {
							MessageDialog.openError(shell, "Remove project library", e.getMessage());
						}
					}
				}
			}
		}
		
		return null;
	}
	
	private ModelingProject getModelingProjectFromSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			// Selection should contain only one element
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IProject) {
				Option<ModelingProject> asModelingProject = ModelingProject.asModelingProject((IProject)firstElement);
				if (asModelingProject.some()) {
					return asModelingProject.get();
				}
			}
		}
		return null;
	}
}
