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
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;

public class ComponentGenUtil {

	public static String getName(Component component) {
		return (isNullOrWhite(component.getName()))? "UnnamedComponent" : component.getName();
	}

	public static Collection<Type> getExposedTypes(Component component) {
		Set<Type> exposedTypes = new HashSet<>();
		
		component.getProvidedServices().stream()
		.map(service -> service.getOwnedInterface())
		.filter(itf -> itf != null)
		.flatMap(itf -> itf.getOwnedOperations().stream())
		.filter(o -> o.getExposition() == ExpositionKind.REST)
		.flatMap(operation -> OperationGenUtil.getOwnedParameters(operation).stream())
		.forEach(parameter -> collectExposedTypes(exposedTypes, parameter.getType()));
		
		return exposedTypes;
	}

	private static void collectExposedTypes(Set<Type> exposedTypes, Type type) {
		
		if(type == null) {
			return;
		}
		
		// Filter out primitive types
		if(type instanceof PrimitiveType) {
			return;
		}
		
		// Recursion stop condition
		if(exposedTypes.contains(type)) {
			return;
		}
		
		exposedTypes.add(type);
		
		if(type instanceof StructuredType) {
			StructuredType structuredType = (StructuredType) type;
			structuredType.getAttributes().forEach(attribute -> collectExposedTypes(exposedTypes, attribute.getType()));
			structuredType.getReferences().forEach(reference -> collectExposedTypes(exposedTypes, reference.getReferencedType()));			
			//structuredType.getAssociatedTypes().forEach(associatedType -> collectExposedTypes(exposedTypes, associatedType));
			collectExposedTypes(exposedTypes, structuredType.getSupertype());
		}
		
	}
	
}
