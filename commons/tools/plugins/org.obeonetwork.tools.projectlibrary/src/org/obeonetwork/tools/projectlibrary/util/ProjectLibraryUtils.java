/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.point.IResourceCopier;
import org.obeonetwork.tools.projectlibrary.extension.point.ResourceCopierFactory;

/**
 * Utilities around Project libraries
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryUtils {
	
	private IdUtils idUtils = null;
	
	public boolean removeResources(Session session, Collection<Resource> resources) {
		if (session instanceof DAnalysisSession) {
			final DAnalysisSession analysisSession = (DAnalysisSession)session;
			analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(analysisSession.getTransactionalEditingDomain()) {
				
				@Override
				protected void doExecute() {
					removeResourcesFromSession(analysisSession, resources);
				}
			});
		}
		
		return true;
	}
	
	private void removeResourcesFromSession(DAnalysisSession analysisSession, Collection<Resource> resources) {
		for (Resource resource : resources) {
			if (analysisSession.getSemanticResources().contains(resource)) {
				analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RemoveSemanticResourceCommand(analysisSession, resource, new NullProgressMonitor(), false));
			} else if (analysisSession.getAllSessionResources().contains(resource)) {
				analysisSession.removeAnalysis(resource);
			}
		}
		Collection<Resource> resources2 = new ArrayList<>(resources);
		for (Resource resource : resources2) {
			try {
				resource.delete(null);
			} catch (IOException e) {
//				 TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

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
	 * Returns the settings that could not be restored after an import
	 * 
	 * @return
	 */
	public Collection<Setting> getRestorableReferences(Collection<Setting> externalReferences, Collection<Resource> deletedResources , Session newSession) {
		idUtils = new IdUtils(newSession);
		
		Collection<Setting> restorable = new ArrayList<>();
		
		for (Setting reference : externalReferences) {
			// Each setting can reference objects to restore but also objects that will still be here
			// we check the containing resource to be sure
			Object referencedObjects = reference.get(false);
			if (referencedObjects instanceof List)	{
				for (Object referencedObject : (List<?>)referencedObjects) {
					if (referencedObject instanceof EObject) {
						if (deletedResources.contains(((EObject)referencedObject).eResource())) {
							// The referenced object will be removed
							// lets see if we can restore it
//							if (idUtils.getCorrespondingObject(referencedObject))
							
							restorable.add(reference);
						}
					}
				}
			}
		}
		
		return restorable;
	}
	
	/**
	 * Returns the list of resources corresponding to a previously imported project
	 * @param session
	 * @param projectToRemove
	 * @return
	 */
	public Collection<Resource> getResourcesFromManifest(ModelingProject modelingProject, MManifest projectToRemove) {
		IResourceCopier resourceCopier = ResourceCopierFactory.getInstance().getResourceCopier(modelingProject.getSession());
		return resourceCopier.getResourcesForImportedProject(modelingProject, projectToRemove);
	}
	
	

}
