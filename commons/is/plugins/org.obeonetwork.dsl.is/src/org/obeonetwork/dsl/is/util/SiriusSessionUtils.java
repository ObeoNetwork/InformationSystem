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
package org.obeonetwork.dsl.is.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.URIQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.tools.api.command.ui.NoUICallback;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SiriusSessionUtils {

	static public Session getSession(IProject project) {
		Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
        Session session = modelingProject.some() ? modelingProject.get().getSession() : null;
		return session;
	}
	
	static public CDOResourceFolder getRemoteRootFolder(Session session) {
		if (session != null) {
        	
        	// Get first root folder on CDO, there should be only one
        	for (Resource referencedSessionResource : session.getReferencedSessionResources()) {
        		if (referencedSessionResource instanceof CDOResource) {
        			CDOResourceFolder rootFolder = ((CDOResource) referencedSessionResource).getFolder();
        			if (rootFolder != null) {
        				return rootFolder;
        			}
        		}
        	}
        }
        return null;
	}
	
	static public List<CDOResourceFolder> getFoldersForModelingProject(IProject project) {
		List<CDOResourceFolder> folders = new ArrayList<>();
		
		Session session = getSession(project);
		CDOResourceFolder rootFolder = getRemoteRootFolder(session);
		if (rootFolder != null) {
			for (CDOResourceNode node : rootFolder.getNodes()) {
				if (node instanceof CDOResourceFolder) {
					folders.add((CDOResourceFolder)node);
				}
			}
		}
		return folders;
	}
	
	/**
	 * Checks if a session is a shared project by checking whether the main analysis is a CDO resource or not
	 * @param session
	 * @return
	 */
	static public boolean isSharedModelingProjectSession(Session session) {
		for (Resource sessionResource : session.getAllSessionResources()) {
			if (isRemoteResource(sessionResource)) {
				return true;
			}
		}
		return false;
	}
	
	static public boolean isRemoteResource(Resource resource) {
		if (resource != null) {
			URI uri = resource.getURI();
			return uri != null && new URIQuery(uri).isCDOURI();
		}
		return false;
	}
	
	/**
	 * 
	 * @param project
	 * @param askUserBeforeLoading
	 * @param shell
	 * @return Boolean indicating if project was actually loaded
	 */
	static public boolean loadModelingProject(IProject project, boolean askUserBeforeLoading, Shell shell) {
		// Check if project is a modeling project and has been loaded
		if (ModelingProject.hasModelingProjectNature(project) && getSession(project) == null) {

			// Ask user if he wants to load the project
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					boolean doLoading = MessageDialog.openQuestion(shell, "Load modeling project", "Project has not been loaded yet. Do you want to load it now ?");
					
					if (doLoading) {
						BusyIndicator.showWhile(shell.getDisplay(), new Runnable() {
							
							@Override
							public void run() {
								// Get AIRD URI 
								ModelingProject modelingProject = ModelingProject.asModelingProject(project).get();
								Option<URI> optionMainAirdURI = modelingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
								if (optionMainAirdURI.some()) {
									URI airdURI = optionMainAirdURI.get();
									SessionManager.INSTANCE.openSession(airdURI, new NullProgressMonitor(), new NoUICallback(), true);
								}
							}
						});
					}
				}
			});
		}
		return !(ModelingProject.hasModelingProjectNature(project) && getSession(project) == null);
	}
	
	static public boolean resourceAlreadyExists(Object container, String resourceName) {
		if (resourceName == null || resourceName.isEmpty()) {
			return false;
		}
		if (container instanceof IProject) {
			// Several cases here :
			// - non modeling project => same test as for a container
			// - modeling project, non shared => same test as for a container
			// - shared modeling project => we have to check contents of the root remote folder (which is not visible in the tree)
			// We try to get a remote root folder, it we don't get any it could mean that the project is not shared
			// or that the session has not yet been loaded
			// This last case will be cover by the wizard performFinish() method
			IProject project = (IProject)container;
			Session session = getSession(project);
			CDOResourceFolder remoteRootFolder = getRemoteRootFolder(session);
			if (remoteRootFolder != null) {
				return remoteResourceAlreadyExistsInFolder(remoteRootFolder, resourceName);
			} else {
				return localResourceAlreadyExistsInContainer(project, resourceName);
			}
		} else if (container instanceof IContainer) {
			return localResourceAlreadyExistsInContainer((IContainer)container, resourceName);
		} else if (container instanceof CDOResourceFolder) {
			return remoteResourceAlreadyExistsInFolder((CDOResourceFolder) container, resourceName);
		}
		return false;
	}
	
	static public boolean remoteResourceAlreadyExistsInFolder(CDOResourceFolder folder, String resourceName) {
		return folder.getNode(resourceName) != null;
	}
	
	static public boolean localResourceAlreadyExistsInContainer(IContainer container, String resourceName) {
		IResource member = container.findMember(resourceName);
		return member != null && member.exists();
	}
	
	static public Resource createResource(ModelingProject modelingProject, CDOResourceFolder folder, String resourceName, Collection<EObject> rootObjects, IProgressMonitor monitor) {
		Session session = modelingProject.getSession();
		CDOResource resource = folder.addResource(resourceName);
		session.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				resource.getContents().addAll(rootObjects.stream().filter(eObject -> eObject.eContainer() == null).collect(Collectors.toList()));
				session.addSemanticResource(resource.getURI(), monitor);
			}
		});
		session.save(monitor);
		return resource;
	}
	
	static public Resource createResource(ModelingProject modelingProject, IContainer container, String resourceName, Collection<EObject> rootObjects, IProgressMonitor monitor) {
		IFile file = container.getFile(new Path(resourceName));
		if (file != null) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Session session = modelingProject.getSession();
			Resource resource = session.getTransactionalEditingDomain().getResourceSet().createResource(uri);
			session.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
				@Override
				protected void doExecute() {					
					resource.getContents().addAll(rootObjects.stream().filter(eObject -> eObject.eContainer() == null).collect(Collectors.toList()));
					session.addSemanticResource(uri, monitor);
				}
			});
			session.save(monitor);
			return resource;
		}
		return null;
	}
	
	static public Resource createResource(IContainer container, String resourceName, Collection<EObject> rootObjects, IProgressMonitor monitor) {
		IFile file = container.getFile(new Path(resourceName));
		if (file != null) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = new ResourceSetImpl().createResource(uri);
			resource.getContents().addAll(rootObjects.stream().filter(eObject -> eObject.eContainer() == null).collect(Collectors.toList()));
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			try {
				resource.save(options);
			} catch (IOException e) {
				// Do nothing
			}
			return resource;
		}
		return null;
	}
	
}
