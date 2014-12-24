/*******************************************************************************
 * Copyright (c) 2014 Obeo.
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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.TypesDefinition;

import fr.obeo.dsl.viewpoint.DSemanticDiagram;

public class TypesServices {
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestors(Namespace namespace, DSemanticDiagram diagram, String typeName) {
		Collection<EObject> result = new HashSet<EObject>();
		Collection<StructuredType> selectableTypes = getAllSelectableExternalStructuredTypes(namespace, diagram, typeName);
		result.addAll(selectableTypes);
		for (StructuredType selectableType : selectableTypes) {
			result.addAll(ModelServices.getAncestors(selectableType));
		}
		
		return result;
	}
	
	public Collection<StructuredType> getAllSelectableExternalStructuredTypes(Namespace namespace, DSemanticDiagram diagram, String typeName) {
		Collection<StructuredType> notReferencedTypes = getAllNotReferencedStructuredTypes(namespace, diagram);
		
		// Remove already displayed types
		Set<StructuredType> types = DesignServices.getDisplayedStructuredTypes(diagram);
		notReferencedTypes.removeAll(types);
		
		Collection<StructuredType> selectableTypes = new ArrayList<StructuredType>();
		// Keep only types of the specified typeName
		for (StructuredType structuredType : notReferencedTypes) {
			if (typeName == null || typeName.isEmpty() || typeName.equals(structuredType.eClass().getName())) {
				selectableTypes.add(structuredType);
			}
		}
		
		return selectableTypes;
	}
	
	public Collection<StructuredType> getAllNotReferencedStructuredTypes(Namespace namespace, DSemanticDiagram diagram) {
		Collection<StructuredType> notReferencedTypes = getAllStructuredTypes(namespace, null);
		
		// We have to remove from this list
		// the types contained in the current namespace
		notReferencedTypes.removeAll(namespace.getTypes());
		// the referenced types
		notReferencedTypes.removeAll(getAllReferencedStructuredTypes(namespace, diagram));
		
		return notReferencedTypes;
	}
	
	public Collection<StructuredType> getAllReferencedStructuredTypes(Namespace namespace, DSemanticDiagram diagram) {
		Set<StructuredType> types = DesignServices.getDisplayedStructuredTypes(diagram);
		types.retainAll(namespace.getTypes());
		
		Collection<StructuredType> referencedTypes = new HashSet<StructuredType>();
		
		for (StructuredType existingType : types) {
			referencedTypes.add(existingType.getSupertype());
			for (Reference reference : existingType.getOwnedReferences()) {
				referencedTypes.add(reference.getReferencedType());
			}
		}
		
		referencedTypes.removeAll(namespace.getTypes());
		
		return referencedTypes;
	}
	
	public Collection<StructuredType> getAllStructuredTypes(EObject context, String typeName) {
		Collection<StructuredType> types = new ArrayList<StructuredType>();
		
		Collection<Resource> resources = ModelServices.getAllResources(context);
		for (Resource resource : resources) {
			for (EObject object : resource.getContents()) {
				if (object instanceof ObeoDSMObject) {
					types.addAll(internalGetAllChildrenStructuredTypes((ObeoDSMObject)object, typeName));
				}
			}
		}
		return types;
	}
	
	private Collection<StructuredType> internalGetAllChildrenStructuredTypes(ObeoDSMObject parent, String typeName) {
		Collection<StructuredType> types = new ArrayList<StructuredType>();
		
		TreeIterator<EObject> eAllContents = parent.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof StructuredType) {
				// If the type is not specified we do not check on the type
				if (typeName == null || typeName.isEmpty() || typeName.equals(eObject.eClass().getName())) {
					types.add((StructuredType)eObject);
				}
			}
		}
		return types;
	}

	public PrimitiveType getStringPrimitiveType(EObject object){
		PrimitiveType primitiveType = getPrimitiveType(object, "String");
		return primitiveType;
	}
	
	private PrimitiveType getPrimitiveType(EObject context, String name){		
		Collection<Resource> resources = ModelServices.getAllResources(context);
		for (Resource resource : resources) {
			for (EObject object : resource.getContents()) {
				if (object instanceof Environment || object instanceof TypesDefinition) {
					// Types must exist below an environment or types definition					
					TreeIterator<?> iterator = object.eAllContents();
					while(iterator.hasNext()){
						Object o = iterator.next();
						if (o instanceof PrimitiveType) {
							PrimitiveType type = (PrimitiveType)o;
							if (name.equalsIgnoreCase(type.getName())) {
								return type;
							}
						}
					}
				}
			}
		}
		return null;
	}

}
