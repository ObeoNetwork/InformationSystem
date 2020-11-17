/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design.services;

import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.util.SoaSwitch;

public class SOALabelService extends SoaSwitch<String> {
	
	/**
	 * Computes the label for an object from SOA meta-model
	 * @param context Object for which we want to compute a label
	 * @return computed label
	 */
	public String computeSoaLabel(ObeoDSMObject context) {
		return doSwitch(context);
	}
	
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
