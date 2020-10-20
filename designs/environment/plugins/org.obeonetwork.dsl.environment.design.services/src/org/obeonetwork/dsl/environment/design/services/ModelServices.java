/*******************************************************************************
 * Copyright (c) 2015, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
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

	public static List<EObject> getAncestors(EObject object) {
		if (object.eContainer() != null) {
			List<EObject> ancestors = getAncestors(object.eContainer());
			ancestors.add(object.eContainer());
			return ancestors;
		} else {
			return new ArrayList<EObject>();
		}
	}
	
	public static <T extends EObject> T getContainerOrSelf(EObject eObject, Class<T> type) {
		EObject container = eObject;
		T matchingContainer = null;
		while(container != null && matchingContainer == null) {
			if(type.isInstance(container)) {
				matchingContainer = type.cast(container);
			}
			container = container.eContainer();
		}

		return matchingContainer;
	}
	
	public static <T extends EObject> T setNullableInteger(T eObject, EAttribute attribute, String value) {
		if(value == null || value.trim().isEmpty()) {
			eObject.eSet(attribute, null);
		} else {
			eObject.eSet(attribute, Integer.parseInt(value));
		}
		
		return eObject;
	}
	
}