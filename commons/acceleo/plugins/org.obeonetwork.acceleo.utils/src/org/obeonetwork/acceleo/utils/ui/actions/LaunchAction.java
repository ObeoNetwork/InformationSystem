/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.acceleo.utils.ui.actions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher;
import org.obeonetwork.acceleo.utils.properties.util.AcceleoGenerationPropertiesHelper;
import org.obeonetwork.acceleo.utils.ui.wizards.LaunchGenerationWizard;

public abstract class LaunchAction implements IObjectActionDelegate {

	private Shell shell;
	private IFile selectedFile;
	private AcceleoGenerationPropertiesHelper helper;

	/**
	 * Constructor for Action1.
	 */
	public LaunchAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		helper = new AcceleoGenerationPropertiesHelper(selectedFile);
		final LaunchGenerationWizard newWizard = new LaunchGenerationWizard(helper, selectedFile);
		WizardDialog dialog = new WizardDialog(shell, newWizard);
		int result = dialog.open();
		if (result == Window.OK) {
			try {
				PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
						new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
								try {
									monitor.beginTask("Generating code ...", 10);
									URI modelURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
									IProject project = newWizard.getGenerationTarget();
									File folder = project.getLocation().toFile();
									getLauncher().lauchGeneration(modelURI, folder, monitor);
									monitor.worked(8);
									helper.saveLastGenerationTarget(project.getName());
									monitor.worked(1);
									
									// Refresh the model for the properties file
									selectedFile.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
									monitor.worked(1);
									
									// Refresh the generated files since we are in a runnable with progress.
									project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
									monitor.worked(1);
								} catch (IOException e) {
									//TODO: Throw error
								} catch (CoreException e) {
									//TODO: Throw error
								}
								
							}
						});
			} catch (InvocationTargetException e) {
				//TODO: Throw error
			} catch (InterruptedException e) {
				//TODO: Throw error
			}
		}
	}

	public abstract AbstractGenerationLauncher getLauncher();

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selectedFile = (IFile) ((StructuredSelection)selection).getFirstElement();
	}

}
