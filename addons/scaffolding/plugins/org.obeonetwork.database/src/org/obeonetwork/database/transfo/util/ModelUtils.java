/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.transfo.util;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.PrimitiveType;

import org.obeonetwork.database.Activator;

public class ModelUtils {
	
	public static Map<String, EObject> loadReferences(ResourceSet resourceSet, Iterable<EObject> references) {
		HashMap<String, EObject> index = new HashMap<String, EObject>();
		for (EObject eObject : references) {
			index.putAll(loadReferences(resourceSet, eObject));
		}
		return index;
	}
	
	public static Map<String, EObject> loadReferences(ResourceSet resourceSet, Resource resource) {
		HashMap<String, EObject> index = new HashMap<String, EObject>();
		for (EObject root : resource.getContents()) {
			index.putAll(loadReferences(resourceSet, root));
		}
		return index;
	}
	
	public static Map<String, EObject> loadReferences(ResourceSet resourceSet, EObject object) {
		HashMap<String, EObject> index = new HashMap<String, EObject>();
		Iterator<EObject> it = object.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			String key = getKey(child);
			if (key != null) {
				index.put(key, child);
			}
		}
		return index;
	}
	
	public static String getKey(EObject object) {
		String prefix = object.eClass().getName() + "_";
		
		// Special case for Entity, index by physicalName
		if(object instanceof Entity){
			Entity entity = (Entity) object;
			String physicalName = AnnotationHelper.getPhysicalName(entity);
			if (physicalName == null) {
				physicalName = LabelProvider.getNameFeatureValue(entity);
			}
			if (physicalName != null) {
				return prefix + physicalName;				
			}
		}
		
		// Retrieve the value of the name feature
		EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
		if (nameFeature != null) {
			Object value = object.eGet(nameFeature);
			if (value != null && value instanceof String) {
				// Special case for Primitive types do not use prefix
				if (object instanceof PrimitiveType) {
					return (String)value;
				}
				return prefix + (String)value;
			}
		}
		return null;
	}
	
	public static ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet;
	}

	public static void saveResource(Resource resource) {
		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			resource.save(options);
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

	public static void unloadResources(ResourceSet resourceSet) {
		if (resourceSet != null) {
			for (Resource resource : resourceSet.getResources()) {
				resource.unload();
			}
		}
	}

	public static Resource loadModel(ResourceSet resourceSet, URI modelURI) {
		final Resource modelResource = resourceSet.createResource(modelURI);
		try {
			modelResource.load(Collections.emptyMap());
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
		return modelResource;
	}

}
