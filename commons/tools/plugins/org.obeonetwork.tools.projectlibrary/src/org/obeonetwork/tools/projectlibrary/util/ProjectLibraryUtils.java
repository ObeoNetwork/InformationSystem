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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.extension.point.AbstractImportHandler;
import org.obeonetwork.tools.projectlibrary.extension.point.DefaultImportHandler;
import org.obeonetwork.tools.projectlibrary.extension.point.ImportHandlerFactory;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.utils.common.SessionUtils;

/**
 * Utilities around Project libraries
 * 
 * @author Obeo
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
					// Prepare specific additional behavior in case we are about to restored an
					// EReference that corresponds to environment::Reference.referencedType
					final List<Runnable> commandPostBehaviors = new ArrayList<>();
					if (restorableReference instanceof EReferenceReferenceReferencedTypeToRestoreWithOpposite) {
						final EReferenceReferenceReferencedTypeToRestoreWithOpposite restorableReferenceReferencedType = (EReferenceReferenceReferencedTypeToRestoreWithOpposite) restorableReference;
						final Reference source = (Reference) sourceObject;
						final StructuredType target = (StructuredType) targetObject;
						final Reference oppositeReferenceToRestore = restorableReferenceReferencedType
								.getOppositeReference();
						final Reference maybeAlreadyRestoredOppositeReference = (Reference) idUtils
								.getCorrespondingObject(idUtils.getKey(oppositeReferenceToRestore));
						final Reference restoredOppositeReference;
						if (maybeAlreadyRestoredOppositeReference == null) {
							final EcoreUtil.Copier copierWithoutCopyOfProxyUri = new EcoreUtil.Copier() {
								private static final long serialVersionUID = 1L;

								@Override
								protected void copyProxyURI(EObject eObject, EObject copyEObject) {
									// Suppress this copy because it breaks things, not sure why.
									// Maybe the copied element still exists in the ResourceSet at this point.
									// super.copyProxyURI(eObject, copyEObject);
								}

								@Override
								protected void copyReference(EReference eReference, EObject eObject,
										EObject copyEObject) {
									super.copyReference(eReference, eObject, copyEObject);
									// FIXME: won't we have issues with Reference.BindingRegistries or other
									// non-containment EReferences that had their value located in the resource of
									// the library?
								}
							};
							restoredOppositeReference = (Reference) copierWithoutCopyOfProxyUri
									.copy(oppositeReferenceToRestore);
							commandPostBehaviors.add(() -> {
								target.getOwnedReferences().add(restoredOppositeReference);
							});
						} else {
							restoredOppositeReference = maybeAlreadyRestoredOppositeReference;
						}
						commandPostBehaviors.add(() -> {
							restoredOppositeReference.setReferencedType((StructuredType) source.eContainer());
							restoredOppositeReference.setOppositeOf(source);
						});
					}

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
									List<Object> list = (List<Object>) eGet;
									list.remove(position);
									list.add(position, targetObject);
								}
								commandPostBehaviors.forEach(Runnable::run);
							}
						};
					} else {
						// Mono valued feature
//						cmd = new SetCommand(ted, sourceObject, referencingFeature, targetObject);
						cmd = new RecordingCommand(ted) {
							@Override
							protected void doExecute() {
								sourceObject.eSet(referencingFeature, targetObject);
								commandPostBehaviors.forEach(Runnable::run);
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
	public boolean removeImportedProjectAndResources(IProject project, Collection<Resource> resourcesToDelete,
			MManifest projectToRemove, boolean shouldDeleteResource) throws LibraryImportException {
		Optional<Session> session = SessionUtils.getSession(project);

		boolean removed = false;
		if (session.isPresent()) {
			AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(session.get());

			if (importHandler instanceof DefaultImportHandler) {
				removed = ((DefaultImportHandler) importHandler).removeImportedProjectAndResources(project,
						resourcesToDelete, projectToRemove, shouldDeleteResource);
			} else {
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
	 * 
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
						if (!setting.getEStructuralFeature()
								.equals(ViewpointPackage.Literals.DANALYSIS__REFERENCED_ANALYSIS)) {
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
	 * 
	 * @param externalReferences External references
	 * @param deletedResources   Resources that will be deleted
	 * @param newSession         New session
	 * @return
	 */
	public RestorableAndNonRestorableReferences getToBeRestoredReferences(Collection<Setting> externalReferences,
			Collection<Resource> deletedResources, Session newSession) {
		IdUtils idUtils = new IdUtils(newSession);

		RestorableAndNonRestorableReferences toBeRestoredReferences = new RestorableAndNonRestorableReferences();

		for (Setting setting : externalReferences) {
			// Each setting can reference objects to restore but also objects that will
			// still be here
			// we check the containing resource to be sure
			Object referencedObjects = setting.get(false);
			if (referencedObjects instanceof List) {
				for (Object referencedObject : (List<?>) referencedObjects) {
					if (referencedObject instanceof EObject) {
						ToBeRestoredReference restorableReference = 
								getRestorableReference(setting, (EObject) referencedObject, deletedResources, idUtils);
						if (restorableReference != null) {
							toBeRestoredReferences.addReference(restorableReference);
						}
					}
				}
			} else if (referencedObjects instanceof EObject) {
				ToBeRestoredReference restorableReference = 
						getRestorableReference(setting, (EObject) referencedObjects, deletedResources, idUtils);
				if (restorableReference != null) {
					toBeRestoredReferences.addReference(restorableReference);
				}
			}
		}

		return toBeRestoredReferences;
	}

	private ToBeRestoredReference getRestorableReference(Setting setting, EObject referencedEObject,
			Collection<Resource> deletedResources, IdUtils idUtils) {

		ToBeRestoredReference toBeRestoredReference = null;
		if (deletedResources.contains(referencedEObject.eResource())) {
			EStructuralFeature feature = setting.getEStructuralFeature();
			String key = idUtils.getKey(referencedEObject);
			Integer position = null;
			// If the feature is multivalued, keep the position of the element in the values list
			if (feature.isMany()) {
				Object value = setting.getEObject().eGet(feature);
				if (value instanceof List) {
					position = ((List<?>) value).indexOf(referencedEObject);
				}
			}

			// Manage the references regarding replaced objects, and keep track of the ones regarding removed objects.
			if (feature == EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE) {
				// In the case of a reference referencing a Structured Type in a replaced resource
				// we need to keep in cache the opposite reference (if there is one) to restore it
				// at the end of the import.
				if (idUtils.getCorrespondingObject(referencedEObject) != null) {
					Reference oppositeReference = ((Reference) setting.getEObject()).getOppositeOf();
					if (oppositeReference != null && deletedResources.contains(oppositeReference.eResource())) {
						toBeRestoredReference = new EReferenceReferenceReferencedTypeToRestoreWithOpposite(
								setting.getEObject(), feature, key, position, true, oppositeReference);
					} else {
						toBeRestoredReference = new ToBeRestoredReference(setting.getEObject(), feature, key, position, true);
					}
				}
			} else if (feature == EnvironmentPackage.Literals.REFERENCE__OPPOSITE_OF) {
				// This feature is entirely managed by the if case above.
				toBeRestoredReference = null;
			} else {
				// Any other reference is kept in cache either to warn the user if it can't be managed or to restore it
				// at the end of the import.
				boolean canBeRestored = idUtils.getCorrespondingObject(referencedEObject) != null;
				toBeRestoredReference = new ToBeRestoredReference(setting.getEObject(), feature, key, position, canBeRestored);
			}
			
		}
		return toBeRestoredReference;
	}

	/**
	 * Returns the list of resources corresponding to a previously imported project
	 * 
	 * @param modelingProject
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromManifest(IProject modelingProject, MManifest projectToRemove) {
		Optional<Session> session = SessionUtils.getSession(modelingProject);
		if (session.isPresent()) {
			AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(session.get());
			return importHandler.getResourcesForImportedProject(modelingProject, projectToRemove);
		}

		return new ArrayList<>();
	}

	/**
	 * Returns the list of resources corresponding to a previously imported project
	 * from the workspace.
	 * 
	 * @param session
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromWsManifest(Session session, MManifest projectToRemove) {
		DefaultImportHandler importHandler = (DefaultImportHandler) ImportHandlerFactory.getInstance()
				.getImportHandler(session);
		return importHandler.getResourcesForImportedWsProject(session, projectToRemove);
	}

	/**
	 * Return the list of projects containing a resource which is referenced by
	 * {@link modelingProject}.
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
						if (session == null) {
							final Option<URI> optionalUri = wsModelingProject
									.getMainRepresentationsFileURI(new NullProgressMonitor());
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
										IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot()
												.getFile(resourcePath);
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
		} catch (Exception e) {
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
			if (session == null) {
				final Option<URI> optionalUri = modelingProject
						.getMainRepresentationsFileURI(new NullProgressMonitor());
				session = SessionManager.INSTANCE.getSession(optionalUri.get(), new NullProgressMonitor());
				session.open(new NullProgressMonitor());
			}

			for (Resource res : session.getSemanticResources()) {
				if (res.getURI().isPlatformResource()
						&& !modelingProject.getProject().getName().equals(res.getURI().segment(1))) {
					for (IProject wsProject : workspaceProjects) {
						if (wsProject.getName().equals(res.getURI().segment(1))) {
							result.add(wsProject);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
