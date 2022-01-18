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
package org.obeonetwork.dsl.soa.migration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.tools.migration.BasicMigrationHelper;
import org.obeonetwork.tools.migration.MigrationXMLHelper;


public class SoaMigrationHelper extends BasicMigrationHelper {
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		if ("ServiceDTO".equals(name)) {
			return EnvironmentPackage.Literals.DTO;
		}
		if ("Category".equals(name)) {
			return EnvironmentPackage.Literals.NAMESPACE;
		}
		return null;
	}

	@Override
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper) {
		if (type == EnvironmentPackage.Literals.REFERENCE) {
			// In old Environment metamodel, Reference.navigable was false by default
			// In new Environment metamodel, Reference.navigable is true by default
			EObject createdObject = parentHelper.originalCreateObject(eFactory, type);
			if (createdObject instanceof Reference) {
				((Reference)createdObject).setNavigable(false);
			}
			return createdObject;
		}
		if (type == EnvironmentPackage.Literals.DTO) {
			return parentHelper.originalCreateObject(EnvironmentFactory.eINSTANCE, type);
		}
		if (type == EnvironmentPackage.Literals.DATA_TYPE) {
			return parentHelper.originalCreateObject(EnvironmentFactory.eINSTANCE, EnvironmentPackage.Literals.PRIMITIVE_TYPE);
		}
		return null;
	}
	
	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position, MigrationXMLHelper parentHelper) {
		if (feature == SoaPackage.Literals.SERVICE__SYNCHRONIZATION) {
			if ("asynchrone".equals(value)) {
				parentHelper.originalSetValue(object, feature, "asynchronous", position);
				return true;
			}
			if ("synchone".equals(value)) {
				parentHelper.originalSetValue(object, feature, "synchronous", position);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		if (eClass == SoaPackage.Literals.SYSTEM) {
			if ("ownedDtoRegistry".equals(name)) {
				return EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
			}
			if ("ownedNamespaces".equals(name)) {
				return EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
			}
		}
		if (eClass == EnvironmentPackage.Literals.NAMESPACE) {
			if ("ownedCategories".equals(name)) {
				return EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
			}
		}
		if (eClass == EnvironmentPackage.Literals.ENUMERATION) {
			if ("fields".equals(name)) {
				return EnvironmentPackage.Literals.ENUMERATION__LITERALS;
			}
		}
		if (eClass == EnvironmentPackage.Literals.ATTRIBUTE) {
			if ("type".equals(name)) {
				return EnvironmentPackage.Literals.ATTRIBUTE__TYPE;
			}
		}
		if (eClass == EnvironmentPackage.Literals.REFERENCE) {
			if ("type".equals(name)) {
				return EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE;
			}
		}
		if (eClass == SoaPackage.Literals.PARAMETER) {
			if ("lower".equals(name)) {
				return null;
			}
			if ("upper".equals(name)) {
				return null;
			}
		}
		
		return found;
	}

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		
		// Remove old DTO Registry level
		for (EObject rootObject : resource.getContents()) {
			if (rootObject instanceof System) {
				System system = (System)rootObject;
				if (system.getOwnedNamespaces().size() == 1) {
					Namespace oldDtoRegistry = system.getOwnedNamespaces().get(0);
					removeDtoRegistry(oldDtoRegistry);
				}
			}
		}
	}
	
	private void removeDtoRegistry(Namespace dtoRegistry) {
		System system = (System)dtoRegistry.eContainer();
		
		if (!dtoRegistry.getOwnedNamespaces().isEmpty()) {
			// Store XMI IDs
			Map<EObject, String> eObjectToIds = new HashMap<EObject, String>();
			TreeIterator<EObject> eAllContents = dtoRegistry.eAllContents();
			while (eAllContents.hasNext()) {
				EObject child = eAllContents.next();
				String xmiId = child.eResource().getURIFragment(child);
				eObjectToIds.put(child, xmiId);
			}
			
			// Change parent of children
			Collection<Namespace> children = new ArrayList<Namespace>(dtoRegistry.getOwnedNamespaces());
			for (Namespace child : children) {
				system.getOwnedNamespaces().add(child);
			}
			
			// Restore XMI IDs
			for (Entry<EObject, String> eObjectToIdEntry : eObjectToIds.entrySet()) {
				EObject object = eObjectToIdEntry.getKey();
				String id = eObjectToIdEntry.getValue();
				((XMLResource)object.eResource()).setID(object, id);
			}
		}
		// Delete old DTO registry
		EcoreUtil.delete(dtoRegistry, false);
	}
	
	@Override
	public void handleUnknownFeaturesAnyAttribute(EObject owner, FeatureMap featureMap) {
		if (owner instanceof Parameter) {
			Parameter parameter = (Parameter)owner;
			// Convert "lower + upper" to "multiplicity"
			// Previous default values were lower = 1 and upper = 1
			Iterator<FeatureMap.Entry> iter = featureMap.iterator();
			int lower = 1;
			int upper = 1;
			while (iter.hasNext()) {
				final FeatureMap.Entry entry = iter.next();
				if ("lower".equals(entry.getEStructuralFeature().getName())) {
					lower = Integer.parseInt((String)entry.getValue());
				}
				if ("upper".equals(entry.getEStructuralFeature().getName())) {
					upper = Integer.parseInt((String)entry.getValue());
				}
			}
			
			// Convert now
			if (lower == 0) {
				// lower == 0
				if (upper < 0 || upper > 1) {
					parameter.setMultiplicity(MultiplicityKind.ZERO_STAR_LITERAL);
				} else {
					parameter.setMultiplicity(MultiplicityKind.ZERO_ONE_LITERAL);
				}
			} else {
				// lower == 1
				if (upper < 0 || upper > 1) {
					parameter.setMultiplicity(MultiplicityKind.ONE_STAR_LITERAL);
				} else {
					parameter.setMultiplicity(MultiplicityKind.ONE_LITERAL);
				}
			}
		}
	}
	
	@Override
	public boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		if (owner instanceof Parameter) {
			if ("lower".equals(eStructuralFeature.getName())) {
				return true;
			}
			if ("upper".equals(eStructuralFeature.getName())) {
				return true;
			}
		}
		return super.isADeletedFeature(owner, eStructuralFeature);
	}
}
