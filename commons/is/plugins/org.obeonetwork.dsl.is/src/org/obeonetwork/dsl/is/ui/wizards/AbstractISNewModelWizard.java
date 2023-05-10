/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.ui.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.tools.api.views.modelexplorerview.IModelExplorerView;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.obeonetwork.dsl.is.util.SiriusSessionUtils;
import org.obeonetwork.utils.common.SessionUtils;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

import fr.obeo.dsl.viewpoint.collab.ui.internal.views.ResourcesFolderItemImpl;

@SuppressWarnings("restriction")
abstract public class AbstractISNewModelWizard extends Wizard implements INewWizard {

	protected String windowTitle;
	protected ImageDescriptor imageDescriptor;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	protected NewModelCreationPage modelCreationPage;
	
	private Resource createdResource;
	
	private Collection<DRepresentation> createdRepresentations = new ArrayList<>();
	
	public AbstractISNewModelWizard(String windowTitle, ImageDescriptor imageDescriptor) {
		setWindowTitle(windowTitle);
		this.imageDescriptor = imageDescriptor;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setDefaultPageImageDescriptor(imageDescriptor);
	}

	@Override
	public boolean performFinish() {
		try {
			getContainer().run(false, false, (monitor) -> {
				ModelingProject targetModelingProject = getTargetModelingProject();
				Object targetContainer = getTargetContainer();
				String targetResourceName = getTargetResourceName();
				if (isDataValid(targetModelingProject, targetContainer, targetResourceName, monitor)) {
					Collection<EObject> initialObjects = createInitialObjects();
					createdResource = createResource(targetModelingProject, targetContainer, targetResourceName, initialObjects, monitor);
					if (createdResource != null) {
						setSelectionInActivePart(createdResource);						
					}
					
					if (targetModelingProject != null) {
						// Activate viewpoints
						activateViewpoints(targetModelingProject.getSession(), monitor);
						// Init representations
						initRepresentations(targetModelingProject.getSession(), initialObjects, monitor);
					}
				}
			});
		} catch (Exception e) {
			// TODO Report error
			e.printStackTrace();
			return false;
		}
		return getCreatedResource() != null;
	}
	
	private void activateViewpoints(final Session session, IProgressMonitor monitor) {
		if (session != null) {
			Collection<URI> viewpointsURIs = getViewpointsURIToBeActivated();
			for (URI viewpointURI : viewpointsURIs) {
				SiriusUIUtils.activateViewpoint(session, viewpointURI, monitor);
			}
		}
	}
	
	protected String extractNameFromTargetResourceName(String fileExtension) {
		String targetResourceName = this.getTargetResourceName();
		String rootPrefixName = targetResourceName.substring(0, targetResourceName.length() - fileExtension.length());
		return rootPrefixName;
	}
	
	protected void initRepresentations(final Session session, Collection<EObject> initialObjects, IProgressMonitor monitor) {
		if (session != null) {
			Map<EClassifier, Collection<String>> mapDescIDs = getRepresentationDescriptionsIDToBeCreated();
			if (!mapDescIDs.isEmpty()) {
				for (EObject object : initialObjects) {
					Collection<String> descIDs = mapDescIDs.get(object.eClass());
					for (String descID : descIDs) {
						RepresentationDescription desc = SessionUtils.getRepresentationDescription(session, object, descID);
						if (desc != null) {
							// Get name for the representation
							String representationName = getRepresentationName(desc, object);
							// and create representation
							DRepresentation newRepresentation = SiriusUIUtils.createRepresentation(session, desc, representationName, object, monitor);
							if (newRepresentation != null) {
								createdRepresentations.add(newRepresentation);
							}
						}
					}
					// Open representations
					for (DRepresentation createdRepresentation : createdRepresentations) {
						if (shouldOpenRepresentation(createdRepresentation)) {
							openRepresentation(session, createdRepresentation, monitor);
						}
					}
				}				
			}
		}
	}
	
	protected void openRepresentation(final Session session, DRepresentation representation,  IProgressMonitor monitor) {
		DialectUIManager.INSTANCE.openEditor(session, representation, monitor);
	}
	
	protected boolean isDataValid(ModelingProject targetModelingProject, Object targetContainer, String targetResourceName, IProgressMonitor monitor) {
		if (targetContainer instanceof IProject) {
			// We have to check the case of a resource creation at the root of
			// a modeling project which has not been loaded yet
			// If the modeling project is a shared one, it would mean the resource should be create
			// in remote root CDOResourceFolder
			// We have to load the session to make sure
			if (targetModelingProject != null && targetModelingProject.getSession() == null) {
				// Project is a modeling project but has not been loaded yet
				boolean loaded = SiriusSessionUtils.loadModelingProject(targetModelingProject.getProject(), true, getShell());
				if (!loaded) {
					return false;
				}
				CDOResourceFolder remoteRootFolder = SiriusSessionUtils.getRemoteRootFolder(targetModelingProject.getSession());
				if (remoteRootFolder != null  && SiriusSessionUtils.remoteResourceAlreadyExistsInFolder(remoteRootFolder, targetResourceName)) {
					MessageDialog.openError(getShell(), getWizardTitle(), "A resource with this name already exists");
					modelCreationPage.validatePage();
					return false;
				}
			}
		}
		
		return true;
	}
	
	protected Resource createResource(ModelingProject targetModelingProject, Object targetContainer, String targetResourceName, Collection<EObject> initialObjects, IProgressMonitor monitor) {
		if (targetModelingProject != null && targetContainer instanceof IFolder) {
			// Local file in modeling project
			return SiriusSessionUtils.createResource(targetModelingProject, (IFolder)targetContainer, targetResourceName, initialObjects, monitor);
		} else if (targetModelingProject != null && targetContainer instanceof CDOResourceFolder) {
			// Remote modeling project
			return SiriusSessionUtils.createResource(targetModelingProject, (CDOResourceFolder)targetContainer, targetResourceName, initialObjects, monitor);
		} else if (targetModelingProject == null && targetContainer instanceof IContainer) {
			// Local file in non modeling project
			return SiriusSessionUtils.createResource((IContainer)targetContainer, targetResourceName, initialObjects, monitor);
		} else if (targetModelingProject != null && targetContainer instanceof IProject) {
			// New resource at the root of a modeling project
			if (SiriusSessionUtils.isSharedModelingProjectSession(targetModelingProject.getSession())) {
				CDOResourceFolder remoteRootFolder = SiriusSessionUtils.getRemoteRootFolder(targetModelingProject.getSession());
				if (remoteRootFolder != null) {
					return SiriusSessionUtils.createResource(targetModelingProject, remoteRootFolder, targetResourceName, initialObjects, monitor);
				}
			} else {
				return SiriusSessionUtils.createResource(targetModelingProject, (IProject)targetContainer, targetResourceName, initialObjects, monitor);
			}
		}
		return null;
	}
	
	private void setSelectionInActivePart(Resource resource) {
		IWorkbenchPart activePart = getModelExplorerPart();
		if (resource != null && activePart != null) {
			
			if (resource instanceof CDOResource) {
				TreeSelection treeSelection = buildTreeSelection(resource);
				activePart.getSite().getSelectionProvider().setSelection(treeSelection);
			} else {
				URI uri = resource.getURI();
				if (uri.isPlatformResource()) {
					String platformString = uri.toPlatformString(true);
					IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
					if (member instanceof IFile) {
						TreeSelection treeSelection = buildTreeSelection((IFile)member);
						activePart.getSite().getSelectionProvider().setSelection(treeSelection);
					}
				}
			}
		}
	}
	
	private TreeSelection buildTreeSelection(Object object) {
		List<Object> segments = null;
		if (object instanceof CDOResource) {
			segments = getTreeSegments((CDOResource)object);
			// Reverse the segments
			Collections.reverse(segments);
			segments = wrapForCNF(segments);
		} else if (object instanceof IFile) {
			segments = getTreeSegments((IFile)object);
			// Reverse the segments
			Collections.reverse(segments);
		}
		
		return new TreeSelection(new TreePath(segments.toArray()));
	}
	
	private List<Object> wrapForCNF(List<Object> segments) {
		List<Object> wrappedSegments = new ArrayList<>();
		
		Object previousSegment = null;
		Session session = null;
		for (Object segment : segments) {
			if (segment instanceof IProject) {
				session = SiriusSessionUtils.getSession((IProject)segment);
			}
			if (segment instanceof CDOResourceFolder) {
				previousSegment = new ResourcesFolderItemImpl(session, (CDOResourceFolder)segment, previousSegment);
			} else {
				previousSegment = segment;
			}
			wrappedSegments.add(previousSegment);
		}
		
		return wrappedSegments;
	}
	
	/**
	 * Return all segments for a CDOResource, first segment is the resource itself
	 * then its direct container, then the container of the container and so on
	 * @param resource
	 * @return
	 */
	private List<Object> getTreeSegments(CDOResourceNode resource) {
		List<Object> segments = new ArrayList<>();
		
		if (resource != null) {
			segments.add(resource);
			Object parent = modelCreationPage.getContentProvider().getParent(resource);
			if (parent instanceof CDOResourceNode) {
				segments.addAll(getTreeSegments((CDOResourceNode)parent));
			} else if (parent != null) {
				segments.add(parent);
			}
		}
		
		return segments;
	}
	
	/**
	 * Return all segments for a IResource, first segment is the resource itself
	 * then its direct container, then the container of the container and so on
	 * @param resource
	 * @return
	 */
	private List<Object> getTreeSegments(IResource resource) {
		List<Object> segments = new ArrayList<>();
		if (resource != null) {
			segments.add(resource);
			segments.addAll(getTreeSegments(resource.getParent()));
		}
		return segments;
	}
	
	private IWorkbenchPart getModelExplorerPart() {
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		IViewPart modelExplorerView = page.findView(IModelExplorerView.ID);
		if(modelExplorerView != null) {
			return modelExplorerView;
		}
		
		return null;
	}

	abstract protected Collection<EObject> createInitialObjects();
	
	abstract protected String getWizardTitle();
	
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Collections.emptyList();
	}
	
	/**
	 * Returns a map containing a list of representation description IDs to create for a EClassifier
	 * @return
	 */
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		return Collections.emptyMap();
	}
	
	/**
	 * Returns the name for a new representation 
	 * @param representationDescription
	 * @param object
	 * @return
	 */
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		return null;
	}
	
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		return false;
	}
	
	protected ModelingProject getTargetModelingProject() {
		NewModelWizardData data = modelCreationPage.getData();
		return  data.getTargetModelingProject();
	}
	
	protected String getProjectName() {
		return getTargetModelingProject().getProject().getName();
	}
	
	private Object getTargetContainer() {
		NewModelWizardData data = modelCreationPage.getData();
		return  data.getTargetContainer();
	}
	
	private String getTargetResourceName() {
		NewModelWizardData data = modelCreationPage.getData();
		return data.getTargetResourceName();
	}

	public Resource getCreatedResource() {
		return createdResource;
	}
}
