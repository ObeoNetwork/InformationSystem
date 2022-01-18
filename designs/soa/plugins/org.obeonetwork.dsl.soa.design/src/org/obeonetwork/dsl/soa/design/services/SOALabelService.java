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
package org.obeonetwork.dsl.soa.design.services;

import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.util.SoaSwitch;

public class SOALabelService extends SoaSwitch<String> {
	
	/**
	 * Computes the label for an object from SOA meta-model
	 * @param context Object for which we want to compute a label
	 * @return computed label
	 */
	public String getSoaLabel(ObeoDSMObject context) {
		return doSwitch(context);
	}
	
	@Override
	public String caseParameter(Parameter parameter) {
		return getParameterLabel(parameter, false);
	}

	public String getParameterLabelWithMetaType(Parameter parameter) {
		return getParameterLabel(parameter, true);
	}

	private String getParameterLabel(Parameter parameter, boolean withMetaType) {
		// Name
		StringBuilder label = new StringBuilder(parameter.getName());
		
		label.append(" : ");
		
		// Type
		if(parameter.getType() != null) {
			label.append(parameter.getType().getName());
		}
		
		// Meta Type
		if(withMetaType && parameter.getType() != null && !(parameter.getType() instanceof PrimitiveType)) {
			label.append(" ");
			label.append(parameter.getType().eClass().getName());
		}
		
		// Multiplicity
		label.append("[").append(parameter.getMultiplicity()).append("]");
		
		return label.toString();
	}
	
}
