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
package org.obeonetwork.dsl.is.ui.wizards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.is.util.SiriusSessionUtils;

public class ProjectsAndFoldersContentProvider implements ITreeContentProvider {
	
	private Shell shell = null;

	private ProjectsAndFoldersLabelProvider labelProvider = new ProjectsAndFoldersLabelProvider();
	
	private Map<CDOResourceFolder, IProject> cacheFoldersProject = new HashMap<>();
	
	public ModelingProject getModelingProject(Object containerOrCDOFolder) {
		IProject project = null;
		if (containerOrCDOFolder instanceof IContainer) {
			project = ((IContainer)containerOrCDOFolder).getProject();	
		} else if (containerOrCDOFolder instanceof CDOResourceFolder) {
			project = getSharedModelingProject((CDOResourceFolder)containerOrCDOFolder);
		}
		if (project != null && ModelingProject.hasModelingProjectNature(project)) {
			return ModelingProject.asModelingProject(project).get();
		}
		return null;
	}
	
	public IProject getSharedModelingProject(CDOResourceFolder folder) {
		Object parent = getParent(folder);
		if (parent instanceof CDOResourceFolder) {
			return getSharedModelingProject((CDOResourceFolder)parent);
		} else if (parent instanceof IProject) {
			return (IProject)parent;
		}
		return null;
	}
	
	@Override
	public Object[] getChildren(Object element) {
        if (element instanceof IWorkspace) {
			IProject[] allProjects = ((IWorkspace) element).getRoot().getProjects();
			ArrayList<IProject> accessibleProjects = new ArrayList<>();
			for (IProject project : allProjects) {
				if (project.isOpen()) {
					accessibleProjects.add(project);
                }
            }
            return accessibleProjects.toArray();
        } else if (element instanceof IFolder) {
        	IFolder folder = (IFolder)element;
        	if (folder.isAccessible()) {
            	List<Object> children = new ArrayList<>();
            	// Local folders
            	children.addAll(getFolders(folder));
            	
            	return children.stream().distinct().sorted(new Comparator<Object>() {
        			@Override
        			public int compare(Object o1, Object o2) {
        				String l1 = labelProvider.getText(o1);
        				String l2 = labelProvider.getText(o2);
        				return l1.compareTo(l2);
        			}
        		}).toArray();
            }
        } else if (element instanceof IProject) {
        	IProject project = (IProject) element;
            if (project.isAccessible()) {
            	List<Object> children = new ArrayList<>();
            	
            	// Check if modeling project
            	if (ModelingProject.hasModelingProjectNature(project)) {
            		// Modeling project, we have to make sure the project is loaded
            		boolean loaded = SiriusSessionUtils.loadModelingProject(project, true, getShell());
            		if (loaded) {
            			Session session = SiriusSessionUtils.getSession(project);
            			if (SiriusSessionUtils.isSharedModelingProjectSession(session)) {
            				// CDO Folders
            				List<CDOResourceFolder> cdoFolders = SiriusSessionUtils.getFoldersForModelingProject(project);
                			// Put in cache
                			for (CDOResourceFolder cdoFolder : cdoFolders) {
                				cacheFoldersProject.put(cdoFolder, project);
                			}
                			children.addAll(cdoFolders);		
            			} else {
                        	// Local folders
                        	children.addAll(getFolders(project));            				
            			}
            		}
            	} else {
            		// Non modeling projects
                	// Local folders
                	children.addAll(getFolders(project));            		
            	}
            	
            	return children.stream().distinct().sorted(new Comparator<Object>() {
        			@Override
        			public int compare(Object o1, Object o2) {
        				String l1 = labelProvider.getText(o1);
        				String l2 = labelProvider.getText(o2);
        				return l1.compareTo(l2);
        			}
        		}).toArray();
            }
        } else if (element instanceof CDOResourceFolder) {
        	CDOResourceFolder folder = (CDOResourceFolder) element;
			return folder.getNodes().stream().filter(CDOResourceFolder.class::isInstance).toArray();
        }
        return new Object[0];
	}
	
	private List<IFolder> getFolders(IContainer container) {
		List<IFolder> folders = new ArrayList<>();
		try {
			for (IResource member : container.members()) {
                if (member instanceof IFolder) {
                	folders.add((IFolder)member);
                }
            }
        } catch (CoreException e) {
            // this should never happen because we call #isAccessible before invoking #members
        }
		return folders;
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
        Object[] elements = getChildren(inputElement);
        
        // Retrieve first level to be sure we can retrieve a shared modeling project from a CDO ResourceFolder
        if (inputElement instanceof IWorkspace) {
        	// elements contain projects
        	for (Object element : elements) {
				if (element instanceof IProject) {
					// Should be always true
					IProject project = (IProject)element;
					CDOResourceFolder remoteRootFolder = SiriusSessionUtils.getRemoteRootFolder(SiriusSessionUtils.getSession(project));
					if (remoteRootFolder != null && !cacheFoldersProject.containsKey(remoteRootFolder)) {
						cacheFoldersProject.put(remoteRootFolder, project);
					}
					List<CDOResourceFolder> folders = SiriusSessionUtils.getFoldersForModelingProject(project);
					for (CDOResourceFolder folder : folders) {
						cacheFoldersProject.put(folder, project);
					}
				}
			}
        }
        
		return elements;
	}

	@Override
	public Object getParent(Object element) {
        if (element instanceof IResource) {
			return ((IResource) element).getParent();
		} else if (element instanceof CDOResourceFolder) {
			// Check in cache if the folder is directly contained by a project
			CDOResourceFolder folder = (CDOResourceFolder) element;
			IProject project = cacheFoldersProject.get(folder);
			if (project != null) {
				return project;
			} else {
				return folder.getFolder();
			}
		}else if (element instanceof CDOResource) {
			// Check in cache if the parent folder is directly contained by a project
			CDOResource resource = (CDOResource) element;
			CDOResourceFolder folder = resource.getFolder();
			IProject project = cacheFoldersProject.get(folder);
			if (project != null) {
				return project;
			} else {
				return folder;
			}
		}
        return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			if (SiriusSessionUtils.getSession((IProject)element) == null) {
				// Project not yet loaded
				return true;
			}
		}
		return getChildren(element).length > 0;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}
	
}
