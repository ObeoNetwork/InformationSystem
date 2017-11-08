/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;

public class ImportData {
	private ModelingProject sourceProject;
	private ModelingProject targetProject;
	
	private Session sourceSession;
	private Session targetSession;
	
	private Collection<Resource> sourceSemanticResources;
	private Collection<Resource> sourceGraphicalResources;
	
	private Collection<EObject> sourceSemanticRoots;
	private Collection<EObject> sourceGraphicalRoots;
	
	private Map<EObject, EObject> sourceToCopyMap = null;
	private Map<EObject, EObject> copyToSourceMap = null;
	
	public ImportData(ModelingProject sourceProject, ModelingProject targetProject) {
		this.sourceProject = sourceProject;
		this.sourceSession = sourceProject.getSession();
		this.targetProject = targetProject;
		this.targetSession = targetProject.getSession();
		
		initializeData();
	}
	
	private void initializeData() {
		sourceSemanticResources = new ArrayList<>();
		for (Resource resource : sourceSession.getSemanticResources()) {
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin() // Not in plugin
				&& (uri.scheme() == null || !"pathmap".equals(uri.scheme())) // Not a pathmap
				&& !resource.getContents().get(0).eClass().isInstance(EcoreFactory.eINSTANCE.getEPackage()) // Not a DSL
				) {
				sourceSemanticResources.add(resource);
			}
		}
		
		sourceGraphicalResources = new ArrayList<>();
		sourceGraphicalResources.add(sourceSession.getSessionResource());
		for (Resource resource : sourceSession.getReferencedSessionResources()) {
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin() // Not in plugin
				&& (uri.scheme() == null || !"pathmap".equals(uri.scheme())) // Not a pathmap
				&& !resource.getContents().get(0).eClass().isInstance(EcoreFactory.eINSTANCE.getEPackage()) // Not a DSL
				) {
				sourceGraphicalResources.add(resource);
			}
		}
		
		
		sourceSemanticRoots = new ArrayList<EObject>();
		sourceGraphicalRoots = new ArrayList<EObject>();
		for (Resource resource : sourceSession.getSemanticResources()) {
			// don't copy resources coming from plugins
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin()
					&& (uri.scheme() == null || !"pathmap".equals(uri.scheme()))) {
				sourceSemanticRoots.addAll(resource.getContents());				
			}
		}
		for (Resource resource : sourceSession.getReferencedSessionResources()) {
			// don't copy resources coming from plugins
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin()
					&& (uri.scheme() == null || !"pathmap".equals(uri.scheme()))) {
				sourceGraphicalRoots.addAll(resource.getContents());				
			}
		}
		sourceGraphicalRoots.addAll(sourceSession.getSessionResource().getContents());
	}
	
	private void initializeCopyElements() {
		Collection<EObject> allObjects = new ArrayList<>();
		allObjects.addAll(sourceSemanticRoots);
		allObjects.addAll(sourceGraphicalRoots);
		
		Copier copier = new Copier();
	    copier.copyAll(allObjects);
	    copier.copyReferences();
	    
	    // Build the copy to source map
	    copyToSourceMap = new HashMap<EObject, EObject>();
	    for (EObject sourceRoot : sourceSemanticRoots) {
	    	copyToSourceMap.put(copier.get(sourceRoot), sourceRoot);
		}
	    
	    // Save the copier as the source to copy map
	    sourceToCopyMap = copier;
		
	}

	
	public Collection<Resource> getSourceSemanticResources() {
		return sourceSemanticResources;
	}
	
	public Collection<Resource> getSourceGraphicalResources() {
		return sourceGraphicalResources;
	}

	public Collection<EObject> getSourceSemanticRoots() {
		return sourceSemanticRoots;
	}

	public Collection<EObject> getSourceGraphicalRoots() {
		return sourceGraphicalRoots;
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
	
	public ModelingProject getSourceProject() {
		return sourceProject;
	}

	public ModelingProject getTargetProject() {
		return targetProject;
	}

	public Session getSourceSession() {
		return sourceSession;
	}

	public Session getTargetSession() {
		return targetSession;
	}
	
	
}