/*******************************************************************************
 * Copyright (c) 2015, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.util.EnvironmentSwitch;

public class EnvironmentLabelServices extends EnvironmentSwitch<String> {

	public String getEnvironmentLabel(ObeoDSMObject object) {
		return doSwitch(object);
	}
	
	public String getEnvironmentQualifiedName(ObeoDSMObject object) {
		if (object.eContainer() instanceof Namespace) {
			return getEnvironmentQualifiedName((Namespace)object.eContainer()) + ":" + getEnvironmentLabel(object);
		} else {
			return getEnvironmentLabel(object);
		}
	}
	
	@Override
	public String caseNamespace(Namespace object) {
		return object.getName();
	}
	

	@Override
	public String caseAttribute(Attribute attribute) {
		// Name
		String name = attribute.getName();
		if (name == null) {
			name = "";
		}
		StringBuilder label = new StringBuilder(name).append(" : ");
		// Type
		if (attribute.getType() != null) {
			String typeName = attribute.getType().getName();
			if (typeName == null) {
				typeName = "";
			}
			label.append(typeName);
		}
		// Multiplicity
		label.append("[").append(attribute.getMultiplicity()).append("]");
		
		return label.toString();
	}
	
	@Override
	public String caseStructuredType(StructuredType object) {
		String label = object.getName();
		if (!object.getAssociatedTypes().isEmpty()) {
			label += " > ";
			for (StructuredType associatedType : object.getAssociatedTypes()) {
				label += associatedType.getName() + ",";
			}
			// Remove last ','
			if (label.endsWith(",")) {
				label = label.replaceFirst(",$", "");
			}
		}
		return label;
	}
}
