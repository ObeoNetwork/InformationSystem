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
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.TypesDefinition;

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
			referencedTypes.addAll(getAllReferencingStructuredTypes(existingType));
		}
		
		referencedTypes.removeAll(namespace.getTypes());
		
		return referencedTypes;
	}
	
	private Collection<StructuredType> getAllReferencingStructuredTypes(StructuredType referencedType) {
		Collection<StructuredType> referencingTypes = new HashSet<StructuredType>();
		
		Session session = new EObjectQuery(referencedType).getSession();
		Collection<Setting> inverseReferences = null;
		ECrossReferenceAdapter xReferencer = null;
		if (session != null) {
			xReferencer = session.getSemanticCrossReferencer();
		}
		
		if (xReferencer != null) {
			inverseReferences = xReferencer.getInverseReferences(referencedType);
		} else {
			if (referencedType.eResource() != null && referencedType.eResource().getResourceSet() != null) {
				inverseReferences = UsageCrossReferencer.find(referencedType, referencedType.eResource().getResourceSet());
			}
		}
		
		if (inverseReferences != null) {
			for (Setting setting : inverseReferences) {
				if (setting.getEObject() instanceof StructuredType && setting.getEStructuralFeature() == EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE) {
					referencingTypes.add((StructuredType)setting.getEObject());
				}else if (setting.getEObject() instanceof Reference && setting.getEStructuralFeature() == EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE) {
					referencingTypes.add(((Reference)setting.getEObject()).getContainingType());
				}
			}
		}
		
		return referencingTypes;
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
