/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.cinematic.gen.html.ui.popupMenus;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.osgi.framework.Bundle;

import fr.gouv.mindef.safran.cinematic.gen.html.ui.Activator;
import fr.gouv.mindef.safran.cinematic.gen.html.ui.common.GenerateAll;
import fr.gouv.mindef.safran.cinematic.gen.html.ui.dialogs.SpecificWorkspaceResourceDialog;

/**
 * Html code generation.
 */
public class AcceleoGenerateHtmlAction extends ActionDelegate implements IActionDelegate {
	
	/**
	 * Selected model files.
	 */
	protected List<IFile> files;

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			files = ((IStructuredSelection) selection).toList();
		}
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction)
	 * @generated NOT
	 */
	public void run(IAction action) {
		if (files != null) {
			IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					try {
						Iterator<IFile> filesIt = files.iterator();
						while (filesIt.hasNext()) {
							IFile model = (IFile)filesIt.next();
							URI modelURI = URI.createPlatformResourceURI(model.getFullPath().toString(), true);
							try {
							  
							    FolderSelectionRunnable runnable = new FolderSelectionRunnable();
							    PlatformUI.getWorkbench().getDisplay().syncExec(runnable);
							    
							    IResource selectedResource = runnable.getSelectedResource();
							    if (selectedResource != null && selectedResource instanceof IContainer) {							    	
							    	GenerateAll generator = new GenerateAll(modelURI, (IContainer)selectedResource, getArguments());
							    	generator.doGenerate(monitor);
							 
							    	Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
							    	URL fileURL = FileLocator.find(bundle, new Path("bootstrap/bootstrap.zip"), null);
							    	
							    	File file = selectedResource.getLocation().toFile();
							    	unzip(fileURL, file);
							    	selectedResource.refreshLocal(IResource.DEPTH_INFINITE, monitor);
							    }
							    
							} catch (IOException e) {
								IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
								Activator.getDefault().getLog().log(status);
							} finally {
								model.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
							}
						}
					} catch (CoreException e) {
						IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
						Activator.getDefault().getLog().log(status);
					}
				}
			};
			try {
				PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
			} catch (InvocationTargetException e) {
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status);
			} catch (InterruptedException e) {
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status);
			}
		}
	}

	/**
	 * Computes the arguments of the generator.
	 * 
	 * @return the arguments
	 * @generated
	 */
	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}
	
	/**
	 * Unzip a file given its url into a folder
	 * @param zipURL URL of the zip file
	 * @param folder Folder where to unzip
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void unzip(URL zipURL, File folder) throws FileNotFoundException, IOException{

		ZipInputStream zis = new ZipInputStream(zipURL.openStream());

		ZipEntry ze = null;
		try {
			while((ze = zis.getNextEntry()) != null){

				File f = new File(folder.getCanonicalPath(), ze.getName());
				if (ze.isDirectory()) {
					f.mkdirs();
					continue;
				}
				f.getParentFile().mkdirs();
				OutputStream fos = new BufferedOutputStream(
						new FileOutputStream(f));
				try {
					try {
						final byte[] buf = new byte[8192];
						int bytesRead;
						while (-1 != (bytesRead = zis.read(buf)))
							fos.write(buf, 0, bytesRead);
					}
					finally {
						fos.close();
					}
				}
				catch (final IOException ioe) {
					f.delete();
					throw ioe;
				}
			}
		}
		finally {
			zis.close();
		}
	}
	
	private class FolderSelectionRunnable implements Runnable {

		private IResource selectedResource = null;

		public void run() {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			
			ViewerFilter filter = new ViewerFilter() {
				
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof IFolder) {
						return !(((IFolder) element).getName().startsWith("."));
					}
					return true;
				}
			};

			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			filters.add(filter);
			selectedResource = SpecificWorkspaceResourceDialog.openFolderOrFileSelection(shell,
					"Safr@an",
					"Select an existing folder or specify a new one",
					new Path(root.getRawLocation().toOSString()),
					filters);
		}

		public IResource getSelectedResource() {
			return selectedResource;
		}
	}

}