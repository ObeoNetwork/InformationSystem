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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;

/**
 * Utilities objects and their identifiers
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class IdUtils {

	private static final String DATABASE_DATABASEELEMENT_ID = "techID";
	private static final String TECHNICALID_IDENTIFIABLE_ID = "technicalid";
	private static final String DATABASE_DATABASEELEMENT = "org.obeonetwork.dsl.database.DatabaseElement";
	private static final String TECHNICALID_IDENTIFIABLE = "org.obeonetwork.dsl.technicalid.Identifiable";
	private Session session;
	private Map<String, EObject> cache = new HashMap<String, EObject>();
	private Collection<Notifier> computedObjects = new ArrayList<Notifier>();
	
	public IdUtils(Session session) {
		this.session = session;
		this.computedObjects = new ArrayList<>();
	}
	
	public EObject getCorrespondingObject(String key) {
		// Look into cache
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			// Compute and store result in cache
			EObject foundObject = getCorrespondingObjectFromResources(key);
			cache.put(key, foundObject);
			return foundObject;
		}		
	}
	
	public EObject getCorrespondingObject(EObject sourceObject) {
		String key = getKey(sourceObject);
		return getCorrespondingObject(key);
	}
	
	private EObject getCorrespondingObjectFromResources(String searchKey) {
		// We have to analyse the session to find a corresponding object
		ResourceSet set = session.getTransactionalEditingDomain().getResourceSet();
		List<Resource> resources = new ArrayList<>(set.getResources());
		for (Resource resource : resources) {
			// Do not consider AIRD resources and resources from plugins
			if (resource.getURI().isPlatformResource()
					&& (resource.getURI().fileExtension() == null
					|| !resource.getURI().fileExtension().equals("aird"))) {
				// if a resource has been totally analysed do not analyse it again
				TreeIterator<EObject> it = resource.getAllContents();
				while (it.hasNext()) {
					EObject next = it.next();
					// Check if object has been analysed
					if (!computedObjects.contains(next)) {
						String key = getKey(next);
						cache.put(key, next);
						computedObjects.add(next);
						if (searchKey.equals(key)) {
							return next;
						}
					}
				}
			}
		}
		return null;
	}
	
	public String getKey(EObject object) {
		return object.eClass().getName() + "#" + getId(object);
	}
	
	private String getFeatureValueAsString(EObject object, String eClassName, String eAttributeName) {
		EClass eClass = object.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(eAttributeName);
		if (eStructuralFeature != null) {
			// Check whether it is not a synonym from another EClass
			EObject containingEClass = eStructuralFeature.eContainer();
			if (containingEClass instanceof EClass) {
				if (eClassName.equals(((EClass) containingEClass).getInstanceClassName())) {
					Object value = object.eGet(eStructuralFeature);
					if (value instanceof String) {
						return (String)value;
					}
				}
			}
		}
		return null;
	}
	
	private String getId(EObject object) {
		// Retrieve the ID to be used to retrieve an object
		String id = null;
		
		id = getFeatureValueAsString(object, TECHNICALID_IDENTIFIABLE, TECHNICALID_IDENTIFIABLE_ID);
		if (id == null) {
			id = getFeatureValueAsString(object, DATABASE_DATABASEELEMENT, DATABASE_DATABASEELEMENT_ID);
		}
		if (id == null) {
			id = EcoreUtil.getID(object);
		}
		return id;
	}
}
