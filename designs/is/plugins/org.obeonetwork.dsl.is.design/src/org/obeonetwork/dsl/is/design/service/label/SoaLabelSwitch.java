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

import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.util.SoaSwitch;

public class SoaLabelSwitch extends SoaSwitch<String> {
	
	@Override
	public String caseParameter(Parameter parameter) {
		// Name
		StringBuilder label = new StringBuilder(parameter.getName()).append(" : ");
		// Type
		if (parameter.getType() != null) {
			label.append(parameter.getType().getName());
		}
		// Multiplicity
		label.append("[");
		label.append(parameter.getMultiplicity());
		label.append("]");
		
		return label.toString();
	}
}
