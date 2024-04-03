/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;

public class PropertyGenUtil {

	public static boolean isRequired(Property property) {
		return property.getMultiplicity() == MultiplicityKind.ONE_LITERAL || property.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL;
	}
	
	public static boolean isMany(Property property) {
		return property.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL || property.getMultiplicity() == MultiplicityKind.ZERO_STAR_LITERAL;
	}

	public static int getLowerBound(Property property) {
		if(property.getMultiplicity() == MultiplicityKind.ONE_LITERAL || property.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL) {
			return 1;
		}
		return 0;
	}
	
	public static Type getType(Property property) {
		Type propertyType = null;
		if(property instanceof Attribute) {
			propertyType = ((Attribute) property).getType();
		} else if(property instanceof Reference) {
			propertyType = ((Reference) property).getReferencedType();
		}
		return propertyType;
	}
	
}
