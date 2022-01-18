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
package org.obeonetwork.tools.projectlibrary.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.extension.point.AbstractImportHandler;
import org.obeonetwork.tools.projectlibrary.extension.point.ImportHandlerFactory;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;

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
	 * @param session
	 * @param resourcesToDelete
	 * @param projectToRemove
	 * @return
	 */
	public boolean removeImportedProjectAndResources(ModelingProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove) throws LibraryImportException {
		AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(project.getSession());
		
		boolean removed = importHandler.removeImportedProjectAndResources(project, resourcesToDelete, projectToRemove);
		if (removed == true) {
			// Remove the manifest from the imported manifests
			new ManifestServices().removeImportedManifestFromSession(project.getSession(), projectToRemove);
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
	 * @param session
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromManifest(ModelingProject modelingProject, MManifest projectToRemove) {
		AbstractImportHandler importHandler = ImportHandlerFactory.getInstance().getImportHandler(modelingProject.getSession());
		return importHandler.getResourcesForImportedProject(modelingProject, projectToRemove);
	}
	
}
