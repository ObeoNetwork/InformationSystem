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
package org.obeonetwork.tools.projectlibrary.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.extension.point.AbstractImportHandler;
import org.obeonetwork.tools.projectlibrary.extension.point.DefaultImportHandler;
import org.obeonetwork.tools.projectlibrary.extension.point.ImportHandlerFactory;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.utils.common.SessionUtils;

/**
 * Utilities around Project libraries
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryUtils {
	
	public void restoreReferences(Collection<ToBeRestoredReference> restorableReferences, Session targetSession) {
		IdUtils idUtils = new IdUtils(targetSession);
		
		TransactionalEditingDomain ted = targetSession.getTransactionalEditingDomain();
		
		if (ted != null) {
			for (ToBeRestoredReference restorableReference : restorableReferences) {
				EObject targetObject = idUtils.getCorrespondingObject(restorableReference.getTargetKey());
				EObject sourceObject = restorableReference.getSourceObject();
				EStructuralFeature referencingFeature = restorableReference.getReferencingFeature();
				
				if (targetObject != null && referencingFeature.isChangeable()) {
					RecordingCommand cmd = null;
					if (referencingFeature.isMany() && restorableReference.getPosition() != null) {
						// Multi valued feature
						int position = restorableReference.getPosition().intValue();
//						cmd = new SetCommand(ted, sourceObject, referencingFeature, targetObject, position);
						cmd = new RecordingCommand(ted) {
							@Override
							protected void doExecute() {
								Object eGet = sourceObject.eGet(referencingFeature);
								if (eGet instanceof List) {
									@SuppressWarnings("unchecked")
									List<Object> list = (List<Object>)eGet;
									list.remove(position);
									list.add(position, targetObject);
								}
							}
						};
					} else {
						// Mono valued feature
//						cmd = new SetCommand(ted, sourceObject, referencingFeature, targetObject);
						cmd = new RecordingCommand(ted) {
							@Override
							protected void doExecute() {
								sourceObject.eSet(referencingFeature, targetObject);
							}
						};
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
	 * @param project
	 * @param resourcesToDelete
	 * @param projectToRemove
	 * @param shouldDeleteResource
	 * @return
	 */
	public boolean removeImportedProjectAndResources(IProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove, boolean shouldDeleteResource) throws LibraryImportException {
		Optional<Session> session = SessionUtils.getSession(project);
		
		boolean removed = false;
		if(session.isPresent()) {
			AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(session.get());
			
			if(importHandler instanceof DefaultImportHandler) {
				removed = ((DefaultImportHandler)importHandler).removeImportedProjectAndResources(project, resourcesToDelete, projectToRemove, shouldDeleteResource);
			}
			else {
				removed = importHandler.removeImportedProjectAndResources(project, resourcesToDelete, projectToRemove);
			}
			
			if (removed == true) {
				// Remove the manifest from the imported manifests
				new ManifestServices().removeImportedManifestFromSession(session.get(), projectToRemove);
			}
		}
		
		return removed;
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
	public RestorableAndNonRestorableReferences getToBeRestoredReferences(Collection<Setting> externalReferences, Collection<Resource> deletedResources , Session newSession) {
		IdUtils idUtils = new IdUtils(newSession);
		
		RestorableAndNonRestorableReferences result = new RestorableAndNonRestorableReferences();
		
		for (Setting setting : externalReferences) {
			// Each setting can reference objects to restore but also objects that will still be here
			// we check the containing resource to be sure
			Object referencedObjects = setting.get(false);
			ToBeRestoredReference restorableReference = null;
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
				result.addReference(restorableReference);
			}
		}
		
		return result;
	}
	
	private ToBeRestoredReference getRestorableReference(Setting setting, EObject referencedEObject, Collection<Resource> deletedResources, IdUtils idUtils) {
		
		if (deletedResources.contains(referencedEObject.eResource())) {
			EStructuralFeature feature = setting.getEStructuralFeature();
			String key = idUtils.getKey(referencedEObject);			
			Integer position = null;
			// if feature is multivalued we have to keep the position
			if (feature.isMany()) {
				Object value = setting.getEObject().eGet(feature);
				if (value instanceof List) {
					position = ((List<?>)value).indexOf(referencedEObject);
				}
			}
			
			// The referenced object will be removed
			// lets see if we can restore it
			if (idUtils.getCorrespondingObject(referencedEObject) != null) {
				return new ToBeRestoredReference(setting.getEObject(), feature, key, position, true);
			} else {
				// non restorable reference
				return new ToBeRestoredReference(setting.getEObject(), feature, key, position, false);
			}
		}
		return null;
	}
	
	/**
	 * Returns the list of resources corresponding to a previously imported project
	 * @param modelingProject
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromManifest(IProject modelingProject, MManifest projectToRemove) {
		Optional<Session> session = SessionUtils.getSession(modelingProject);
		if(session.isPresent()) {
			AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(session.get());
			return importHandler.getResourcesForImportedProject(modelingProject, projectToRemove);
		}
		
		return new ArrayList<>();
	}
	
	/**
	 * Returns the list of resources corresponding to a previously imported project from the workspace.
	 * 
	 * @param session
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromWsManifest(Session session, MManifest projectToRemove) {
		DefaultImportHandler importHandler = (DefaultImportHandler) ImportHandlerFactory.getInstance().getImportHandler(session);
		return importHandler.getResourcesForImportedWsProject(session, projectToRemove);
	}
	
	/**
	 * Return the list of projects containing a resource which is referenced by {@link modelingProject}.
	 * 
	 * @param modelingProject
	 * @return the list of referenced projects
	 */
	public Set<ModelingProject> getReferencingProjects(ModelingProject modelingProject) {

		Set<ModelingProject> result = new HashSet<>();
		try {
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IProject[] projects = workspaceRoot.getProjects();
			List<IProject> workspaceProjects = Arrays.asList(projects);

			for (IProject wsProject : workspaceProjects) {
				if (wsProject != modelingProject.getProject()) {
					Option<ModelingProject> optionWsModelingProject = ModelingProject.asModelingProject(wsProject);
					if (optionWsModelingProject.some()) {
						ModelingProject wsModelingProject = optionWsModelingProject.get();
						Session session = wsModelingProject.getSession();
						if(session == null) {
							final Option<URI> optionalUri = wsModelingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
							session = SessionManager.INSTANCE.getSession(optionalUri.get(), new NullProgressMonitor());
							session.open(new NullProgressMonitor());
						}
						ResourceSet resourceSet = session.getTransactionalEditingDomain().getResourceSet();
						if (resourceSet != null) {
							for (Resource resource : resourceSet.getResources()) {
								try {
									if (resource.getURI().isPlatform()) {
										String uri = resource.getURI().toPlatformString(true);
										Path resourcePath = new Path(uri);
										IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(resourcePath);
										IProject resourceProject = resourceFile.getProject();

										if (resourceProject == modelingProject.getProject()) {
											result.add(wsModelingProject);
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Return the list of projects referenced by {@link modelingProject}.
	 * 
	 * @param modelingProject
	 * @return the list of referenced projects
	 */
	public Set<IProject> getReferencedProjects(ModelingProject modelingProject) {
		Set<IProject> result = new HashSet<>();
		try {
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IProject[] projects = workspaceRoot.getProjects();
			List<IProject> workspaceProjects = Arrays.asList(projects);

			Session session = modelingProject.getSession();
			if(session == null) {
				final Option<URI> optionalUri = modelingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
				session = SessionManager.INSTANCE.getSession(optionalUri.get(), new NullProgressMonitor());
				session.open(new NullProgressMonitor());
			}
			
			for (Resource res : session.getSemanticResources()) {
				if(res.getURI().isPlatformResource() && !modelingProject.getProject().getName().equals(res.getURI().segment(1))) {
					for (IProject wsProject : workspaceProjects) {
						if(wsProject.getName().equals(res.getURI().segment(1))) {
							result.add(wsProject);
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
