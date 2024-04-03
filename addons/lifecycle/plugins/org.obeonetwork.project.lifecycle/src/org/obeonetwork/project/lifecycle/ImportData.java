/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.project.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;

public class ImportData {
	private Session sourceSession;
	private List<EClass> rootEClasses;
	
	private Collection<EObject> sourceRoots;
	private Collection<DRepresentationDescriptor> sourceRepresentationDescriptors;
	
	private Map<EObject, EObject> sourceToCopyMap = null;
	private Map<EObject, EObject> copyToSourceMap = null;
	
	public ImportData(Session sourceSession, List<EClass> rootEClasses) {
		this.sourceSession = sourceSession;
		this.rootEClasses = rootEClasses;
		
		initializeData();
	}
	
	private void initializeData() {
		sourceRoots = new ArrayList<EObject>();
		for (Resource resource : sourceSession.getSemanticResources()) {
			for (EObject root : resource.getContents()) {
				if (ImporterUtil.isOfAnyClass(root, rootEClasses)) {
					sourceRoots.add(root);
				}
			}
		}
		
		Collection<EObject> sourceElements = ImporterUtil.getAllElementsWithChildren(sourceRoots);
		sourceRepresentationDescriptors = ImporterUtil.getRelatedRepresentationDescriptors(sourceSession, sourceElements);
	}
	
	private void initializeCopyElements() {
		
		Collection<EObject> sourceEObjects = new ArrayList<EObject>();
		sourceEObjects.addAll(sourceRoots);
		sourceEObjects.addAll(sourceRepresentationDescriptors);
		for(DRepresentationDescriptor dRepresentationDescriptor : sourceRepresentationDescriptors) {
			sourceEObjects.add(dRepresentationDescriptor.getRepresentation());
		}
		
		Copier copier = new Copier();
	    copier.copyAll(sourceEObjects);
	    copier.copyReferences();
	    
	    // Build the copy to source map
	    copyToSourceMap = new HashMap<EObject, EObject>();
	    for (EObject sourceEObject : sourceEObjects) {
	    	copyToSourceMap.put(copier.get(sourceEObject), sourceEObject);
		}
	    
	    // Save the copier as the source to copy map
	    sourceToCopyMap = copier;
		
	}

	public Collection<EObject> getSourceRoots() {
		return sourceRoots;
	}

	public Collection<DRepresentationDescriptor> getSourceRepresentationDescriptors() {
		return sourceRepresentationDescriptors;
	}

	public EObject getCopyEObject(EObject sourceEObject) {
		if(sourceToCopyMap == null) {
			initializeCopyElements();
		}
		return sourceToCopyMap.get(sourceEObject);
	}
	
	public EObject getSourceEObject(EObject copyEObject) {
		if(copyToSourceMap == null) {
			initializeCopyElements();
		}
		return copyToSourceMap.get(copyEObject);
	}
	
	public Collection<EObject> getCopyEObjects() {
		if(sourceToCopyMap == null) {
			initializeCopyElements();
		}
		return sourceToCopyMap.values();
	}
}
