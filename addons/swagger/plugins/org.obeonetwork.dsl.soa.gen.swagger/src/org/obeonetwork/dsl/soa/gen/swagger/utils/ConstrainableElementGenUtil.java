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
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.PrimitiveTypeKind;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.services.ConstrainableElementService;

public class ConstrainableElementGenUtil {

	public static boolean isTextual(ConstrainableElement constrainableElement) {
		Type type = ConstrainableElementService.getType(constrainableElement);
		return type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveTypeKind.TEXT;
	}
	
}
