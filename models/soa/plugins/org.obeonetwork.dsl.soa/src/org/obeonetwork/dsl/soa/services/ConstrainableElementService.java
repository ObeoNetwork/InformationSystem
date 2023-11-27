/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Parameter;

public class ConstrainableElementService {

	public static Type getType(ConstrainableElement element) {
		if(element instanceof Attribute) {
			return ((Attribute) element).getType();
		}
		if(element instanceof Reference) {
			return ((Reference) element).getReferencedType();
		}
		if(element instanceof Parameter) {
			return ((Parameter) element).getType();
		}
		return null;
	}
	
}
