/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.is.ui.wizards.newproject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.obeonetwork.is.ui.wizards.Activator;

/**
 * This wizard is used to create an empty IS project
 */

public class NewProjectWizard extends Wizard implements INewWizard {
	private static final String PLACEHOLDER_PROJECT_PREFIX = "###PROJECT_PREFIX###"; //$NON-NLS-1$
	private static final String PLACEHOLDER_PROJECT_NAME = "###PROJECT_NAME###"; //$NON-NLS-1$
	private static final String PLACEHOLDER_PROJECT_FULL_NAME = "###FULL_PROJECT_NAME###"; //$NON-NLS-1$
	
	private static final String ZIP_PROJECT = "org.obeonetwork.newproject"; //$NON-NLS-1$
	private static final String ZIP_LOCATION = "zips/" + ZIP_PROJECT + ".zip"; //$NON-NLS-1$ //$NON-NLS-2$
	
	private NewProjectWizardPage page;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public NewProjectWizard() {
		super();
		setWindowTitle(Messages.wizard_wizard_title);
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new NewProjectWizardPage();
		addPage(page);
	}
	
	/**
	 * Checks if the wizard can finish early
	 */
	public boolean canFinish() {
		if (page.getProjectName() == null || "".equals(page.getProjectName().trim())
				|| page.getProjectPrefix() == null || "".equals(page.getProjectPrefix().trim())) {
			return false;
		}
		return super.canFinish();
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String projectFullName = page.getProjectFullName();
		final String projectName = page.getProjectName();
		final String projectPrefix = page.getProjectPrefix();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectName, projectPrefix, projectFullName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), Messages.wizard_error_message, realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(String projectName, String projectPrefix, String projectFullName, IProgressMonitor monitor) throws CoreException {
		unzipProject(projectFullName, monitor);
		replacePlaceholders(projectName, projectPrefix, projectFullName, monitor);
	}
	
	/*
	 * Replace the placeholders with the real project name
	 */
	private void replacePlaceholders(String projectName, String projectPrefix, String projectFullName, IProgressMonitor monitor){
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectFullName);
		replacePlaceholder(project, "models/model.properties", PLACEHOLDER_PROJECT_PREFIX, projectPrefix, monitor); //$NON-NLS-1$
		replacePlaceholder(project, "models/model.properties", PLACEHOLDER_PROJECT_NAME, projectName, monitor); //$NON-NLS-1$
				
		replacePlaceholder(project, ".settings/org.eclipse.wst.common.component", PLACEHOLDER_PROJECT_NAME, projectName, monitor); //$NON-NLS-1$
		replacePlaceholder(project, ".settings/org.eclipse.wst.common.component", PLACEHOLDER_PROJECT_FULL_NAME, projectFullName, monitor); //$NON-NLS-1$
		
		replacePlaceholder(project, ".project", PLACEHOLDER_PROJECT_FULL_NAME, projectFullName, monitor); //$NON-NLS-1$
	}
	
	private void replacePlaceholder(IProject project, String filename, String placeholder, String value, IProgressMonitor monitor) {
		IFile file = project.getFile(filename);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			String oldLine;
			StringBuffer newContent = new StringBuffer();
			while( (oldLine = reader.readLine()) != null) {
				newContent.append(oldLine.replaceAll(placeholder, value));
				newContent.append(System.getProperty("line.separator")); //$NON-NLS-1$
			}
			ByteArrayInputStream in = new ByteArrayInputStream(newContent.toString().getBytes());
			file.setContents(in, true, true, monitor);
		} catch (CoreException e) {
			log(e);
		} catch (IOException e) {
			log(e);
		}
	}
	
	private void unzipProject(String projectFullName, IProgressMonitor monitor) {
		String bundleName = Activator.PLUGIN_ID;
		
		URL interpreterZipUrl = FileLocator.find(Platform.getBundle(bundleName), new Path(ZIP_LOCATION), null);
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectFullName);
		
		if (project.exists()) {
			return;
		}
		
		try {
			// We make sure that the project is created from this point forward.
			project.create(monitor);
			project.open(monitor);
			project.refreshLocal(IFile.DEPTH_INFINITE, monitor);
			
			ZipInputStream zipFileStream = new ZipInputStream(interpreterZipUrl.openStream());
			ZipEntry zipEntry = zipFileStream.getNextEntry();
			
			// We derive a regexedProjectName so that the dots don't end up being
			//  interpreted as the dot operator in the regular expression language.
			String regexedProjectName = ZIP_PROJECT.replaceAll("\\.", "\\."); //$NON-NLS-1$ //$NON-NLS-2$
			
			while (zipEntry != null) {
				// We will construct the new file but we will strip off the project
				//  directory from the beginning of the path because we have already
				//  created the destination project for this zip.
				File file = new File(project.getLocation().toString(), zipEntry.getName().replaceFirst("^"+regexedProjectName+"/", ""));   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

				if (false == zipEntry.isDirectory()) {

					/*
					 * Copy files (and make sure parent directory exist)
					 */
					File parentFile = file.getParentFile();
					if (null != parentFile && false == parentFile.exists()) {
						parentFile.mkdirs();
					}

					OutputStream os = null;

					try {
						os = new FileOutputStream(file);

						byte[] buffer = new byte[102400];
						while (true) {
							int len = zipFileStream.read(buffer);
							if (zipFileStream.available() == 0)
								break;
							os.write(buffer, 0, len);
						}
					} finally {
						if (null != os) {
							os.close();
						}
					}
				}
				
				zipFileStream.closeEntry();
				zipEntry = zipFileStream.getNextEntry();
			}
			
			project.close(monitor);
			project.open(monitor);
			project.refreshLocal(IFile.DEPTH_INFINITE, monitor);
			
			// Close and re-open the project to force eclipse to re-evaluate
			//  any natures that this project has.
			project.close(monitor);
			project.open(monitor);
		} catch (IOException e) {
			log(e);
		} catch (CoreException e) {
			log(e);
		}
	}
	
	protected void log(Exception e) {
		if (e instanceof CoreException) {
			Activator.getDefault().getLog().log(((CoreException)e).getStatus());
		} else {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(),IStatus.ERROR, e.getMessage(),e));
		}
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}