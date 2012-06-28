/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.service.label;

import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.util.EntitySwitch;

public class EntityLabelSwitch extends EntitySwitch<String> {

	@Override
	public String caseAttribute(Attribute attribute) {
		// Name
		StringBuilder label = new StringBuilder(attribute.getName()).append(" : ");
		// Type
		if (attribute.getType() != null) {
			label.append(attribute.getType().getName());
		}
		// Multiplicity
		label.append("[").append(attribute.getMultiplicity()).append("]");
		
		return label.toString();
	}
	
}
