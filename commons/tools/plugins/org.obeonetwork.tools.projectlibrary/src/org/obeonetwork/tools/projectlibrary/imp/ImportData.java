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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.resource.ResourceDescriptor;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.obeonetwork.tools.projectlibrary.extension.point.IResourceCopier;

public class ImportData {
	private static final String SIRIUS_ENVIRONMENT_SCHEME = "environment";
	
	private String libraryProjectName;
	
	private IResourceCopier resourceCopier;
	
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
	
	public ImportData(String libraryProjectName, ModelingProject sourceProject, ModelingProject targetProject) {
		this.libraryProjectName = libraryProjectName;
		this.resourceCopier = resourceCopier;
		this.sourceProject = sourceProject;
		this.sourceSession = sourceProject.getSession();
		this.targetProject = targetProject;
		this.targetSession = targetProject.getSession();
		
		initializeData();
	}
	
	private void initializeData() {
		sourceSemanticResources = new ArrayList<>();
		sourceSemanticRoots = new ArrayList<EObject>();
		for (Resource resource : sourceSession.getSemanticResources()) {
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin() // Not in plugin
				&& !SIRIUS_ENVIRONMENT_SCHEME.equals(uri.scheme()) // Sirius internal resource
				&& (uri.scheme() == null || !"pathmap".equals(uri.scheme())) // Not a pathmap
				&& !resource.getContents().get(0).eClass().isInstance(EcoreFactory.eINSTANCE.getEPackage()) // Not a DSL
				) {
				sourceSemanticResources.add(resource);
				sourceSemanticRoots.addAll(resource.getContents());
			}
		}
		
		sourceGraphicalResources = new ArrayList<>();
		sourceGraphicalRoots = new ArrayList<EObject>();
		sourceGraphicalResources.add(sourceSession.getSessionResource());
		sourceGraphicalRoots.addAll(sourceSession.getSessionResource().getContents());
		for (Resource resource : sourceSession.getReferencedSessionResources()) {
			URI uri = resource.getURI();
			if (!uri.isPlatformPlugin() // Not in plugin
				&& !SIRIUS_ENVIRONMENT_SCHEME.equals(uri.scheme()) // Sirius internal resource
				&& (uri.scheme() == null || !"pathmap".equals(uri.scheme())) // Not a pathmap
				&& !resource.getContents().get(0).eClass().isInstance(EcoreFactory.eINSTANCE.getEPackage()) // Not a DSL
				) {
				sourceGraphicalResources.add(resource);
				sourceGraphicalRoots.addAll(resource.getContents());				
			}
		}
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
		
	    // Update URI in ResourceDescriptor
	    updateResourceDescriptors();
	}

	/**
	 * Change ResourceDescriptors URIs as they probably point to soon to be deleted files
	 */
	@SuppressWarnings("unchecked")
	private void updateResourceDescriptors() {
		ResourceSet sourceResourceSet = sourceSession.getTransactionalEditingDomain().getResourceSet();
		
		for (EObject o : sourceToCopyMap.values()) {
			for (EAttribute attribute : o.eClass().getEAllAttributes()) {
				if (attribute.getEAttributeType().getInstanceClass().isAssignableFrom(ResourceDescriptor.class)) {
					if (ViewpointPackage.Literals.DREPRESENTATION_DESCRIPTOR__REP_PATH.equals(attribute)) {
						// URI points to a DRepresentation using the uid of the representation
						ResourceDescriptor currentValue = (ResourceDescriptor)o.eGet(attribute);
						URI representationURI = currentValue.getResourceURI();
						// We have to change only the resource URI and keep the fragment
						URI targetRepresentationURI = resourceCopier.getTargetResourceURI(this, representationURI.trimFragment());
						targetRepresentationURI = targetRepresentationURI.appendFragment(representationURI.fragment());
						o.eSet(attribute, new ResourceDescriptor(targetRepresentationURI));
					} else {
						// Retrieve current value
						if (attribute.getUpperBound() > 1 || attribute.getUpperBound() == -1) {
							// List of ResourceDescriptor instances
							List<ResourceDescriptor> currentValues = (List<ResourceDescriptor>)o.eGet(attribute);
							List<ResourceDescriptor> newValues = new ArrayList<>();
							for (ResourceDescriptor resourceDescriptor : currentValues) {
								newValues.add(convertResourceDescriptor(resourceDescriptor, sourceResourceSet));
							}
							o.eSet(attribute, newValues);
						} else {
							// Unique ResourceDescriptor
							ResourceDescriptor currentValue = (ResourceDescriptor)o.eGet(attribute);
							o.eSet(attribute, convertResourceDescriptor(currentValue, sourceResourceSet));
						}
					}
				}
			}
		}
	}
	
	private ResourceDescriptor convertResourceDescriptor(ResourceDescriptor descriptor, ResourceSet resourceSet) {
		ResourceDescriptor newDescriptor = null;
		URI resourceURI = descriptor.getResourceURI();
		if (resourceURI.hasFragment()) {
			// ResourceDescriptor points to an EObject
			EObject sourceObject = resourceSet.getEObject(resourceURI, true);
			EObject targetObject = sourceToCopyMap.get(sourceObject);
			if (targetObject != null) {
				newDescriptor = new ResourceDescriptor(EcoreUtil.getURI(targetObject));	
			}
		} else {
			// ResourceDescriptor points to an URI
			URI targetResourceURI = resourceCopier.getTargetResourceURI(this, resourceURI);
			if (targetResourceURI != null) {
				newDescriptor = new ResourceDescriptor(targetResourceURI);
			}
		}
		
		return newDescriptor;
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

	public String getLibraryProjectName() {
		return libraryProjectName;
	}

	public IResourceCopier getResourceCopier() {
		return resourceCopier;
	}

	public void setResourceCopier(IResourceCopier resourceCopier) {
		this.resourceCopier = resourceCopier;
	}
	
}