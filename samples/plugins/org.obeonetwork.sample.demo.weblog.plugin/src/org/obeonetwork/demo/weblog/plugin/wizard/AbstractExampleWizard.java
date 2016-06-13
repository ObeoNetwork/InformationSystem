/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.obeonetwork.demo.weblog.plugin.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;


/**
 * <p>
 * This abstract example wizard simply unzips a number of zips
 *  into the workspace as projects. It does not offer any
 *  pages but can be added as a new wizard to the new wizards
 *  dialog through the org.eclipse.ui.newWizards extension point.
 * </p>
 * <p>
 * Clients should subclass this class and override the <code>getProjectDescriptor()</code>
 *  method to provide the location of the project zips that
 *  should be unzipped into the workspace. Note that any projects
 *  that are already in the workspace will <i>not</i> be overwritten
 *  because the user could have made changes to them that would
 *  be lost.
 * </p>
 * <p>
 * It is highly recommended when registering subclasses to the
 *  new wizards extension point that the wizard declaration should
 *  have canFinishEarly = true and hasPages = false. Any label
 *  and icon can be freely given to the wizard to suit the needs
 *  of the client.
 * </p>
 */
public abstract class AbstractExampleWizard extends Wizard
											implements INewWizard {
	
	/**
	 * A descriptor class that describes where to find the zipped
	 *  contents of a project and what that project should be named
	 *  when unzipped into the workspace.
	 */
	public static class ProjectDescriptor {
		private String bundleName;
		private String zipLocation;
		private String projectName;
		
		/**
		 * Construct a descriptor that points to a zip file located
		 *  in a particular bundle at the given location within that
		 *  bundle. Also provided is the project name for which the
		 *  zip is the contents. Note that this project name should
		 *  be the same as is in the contents not some alternative name.
		 *  
		 * @param bundleName The bundle in the runtime that contains the
		 *  zipped up project contents.
		 * @param zipLocation The location within the bundle where the
		 *  zip file is located.
		 * @param projectName The project name in the workspace that
		 *  will be created to house the project contents.
		 */
		public ProjectDescriptor(String bundleName, String zipLocation, String projectName) {
			super();
			this.bundleName = bundleName;
			this.zipLocation = zipLocation;
			this.projectName = projectName;
		}

		public String getBundleName() {
			return bundleName;
		}
		
		public String getProjectName() {
			return projectName;
		}
		
		public String getZipLocation() {
			return zipLocation;
		}
	}

	public boolean performFinish() {
		final Collection projectDescriptors = getProjectDescriptors();
		
		try {
			getContainer().run(true, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
					
					WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
						protected void execute(IProgressMonitor m)
						
							throws CoreException, InvocationTargetException, InterruptedException {
							m.beginTask("Unzipping Projects", projectDescriptors.size());
							
							for (Iterator i = projectDescriptors.iterator(); i.hasNext();) {
								unzipProject((ProjectDescriptor)i.next(), m);
								m.worked(1);
							}
						}
					};
					op.run(monitor);
				}
			});
		} catch (InvocationTargetException e) {
			log(e);
		} catch (InterruptedException e) {
			// We cannot be interrupted, just proceed as normal.
		}

		return true;
	}
	
	protected abstract void log(Exception e);

	/**
	 * The subclass provides the specific project descriptors for the
	 *  projects that should be unzipped into the workspace. Note that
	 *  any projects that already exist in the workspace will not be
	 *  overwritten as they may contain changes made by the user.
	 *  
	 * @return The collection of project descriptors that should be
	 *  unzipped into the workspace.
	 */
	protected abstract Collection getProjectDescriptors();
	
	private void unzipProject(ProjectDescriptor descriptor, IProgressMonitor monitor) {
		String bundleName = descriptor.getBundleName();
		String zipLocation = descriptor.getZipLocation();
		String projectName = descriptor.getProjectName();
		
		URL interpreterZipUrl = FileLocator.find(Platform.getBundle(bundleName), new Path(zipLocation), null);
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		
		if (project.exists()) {
			return;
		}
		
		try {
			// We make sure that the project is created from this point forward.
			project.create(monitor);
			
			ZipInputStream zipFileStream = new ZipInputStream(interpreterZipUrl.openStream());
			ZipEntry zipEntry = zipFileStream.getNextEntry();
			
			// We derive a regexedProjectName so that the dots don't end up being
			//  interpreted as the dot operator in the regular expression language.
			String regexedProjectName = projectName.replaceAll("\\.", "\\."); //$NON-NLS-1$ //$NON-NLS-2$
			
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

					// TODO Figure out why it was necessary to try to convert the encoding in the zip file
					/*Path path = new Path(file.getPath());
					if (path.getFileExtension().equals("java")) { //$NON-NLS-1$
						InputStreamReader is = null;
						OutputStreamWriter os = null;

						try {
							is = new InputStreamReader(zipFileStream, "ISO-8859-1"); //$NON-NLS-1$
							os = new OutputStreamWriter(new FileOutputStream(file),
								ResourcesPlugin.getEncoding());
							char[] buffer = new char[102400];
							while (true) {
								int len = is.read(buffer);
								if (zipFileStream.available() == 0)
									break;
								os.write(buffer, 0, len);
							}
						} finally {
							if (null != os) {
								os.close();
							}
						}
					} else {*/
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
					//}
				}
				
				zipFileStream.closeEntry();
				zipEntry = zipFileStream.getNextEntry();
			}
			
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

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// No code is necessary.
	}
}
