package org.obeonetwork.dsl.environment.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ModelServices {
	
	public static Collection<Resource> getAllResources(EObject any) {
		Resource eResource = any.eResource();
		if (eResource != null) {
			ResourceSet resourceSet = eResource.getResourceSet();
			if (resourceSet != null) {
				return resourceSet.getResources();
			}
		}
		return Collections.emptyList();
	}

	public static Collection<EObject> getAncestors(EObject object) {
		if (object.eContainer() != null) {
			Collection<EObject> ancestors = getAncestors(object.eContainer());
			ancestors.add(object.eContainer());
			return ancestors;
		} else {
			return new ArrayList<EObject>();
		}
	}
	
}