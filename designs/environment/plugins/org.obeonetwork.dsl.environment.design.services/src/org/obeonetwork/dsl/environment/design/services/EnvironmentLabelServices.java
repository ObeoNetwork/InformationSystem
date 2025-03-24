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
package org.obeonetwork.dsl.environment.design.services;

import static java.util.stream.Collectors.joining;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.util.EnvironmentSwitch;

public class EnvironmentLabelServices extends EnvironmentSwitch<String> {

	public String getEnvironmentLabel(ObeoDSMObject object) {
		return doSwitch(object);
	}
	
	public String getEnvironmentQualifiedName(ObeoDSMObject object) {
		// We previously used "instanceof Namespace" but since soa.System now inherits from Namespace
		// we have to consider pure Namespace instances only 
		EObject eContainer = object.eContainer();
		if (eContainer != null && EnvironmentPackage.Literals.NAMESPACE.equals(eContainer.eClass())) {
			return getEnvironmentQualifiedName((Namespace)eContainer) + ":" + getEnvironmentLabel(object);
		} else {
			return getEnvironmentLabel(object);
		}
	}
	
	@Override
	public String caseNamespace(Namespace object) {
		String name = object.getName();
		return name != null ? name : "";
	}
	

	@Override
	public String caseAttribute(Attribute attribute) {
		StringBuilder label = new StringBuilder();
		
		// Name
		if (attribute.getName() != null) {
			label.append(attribute.getName());
		}
		
		label.append(" : ");
		
		// Type
		if (attribute.getType() != null && attribute.getType().getName() != null) {
			label.append(attribute.getType().getName());
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
			
			label += object.getAssociatedTypes().stream()
			.map(StructuredType::getName)
			.collect(joining(","));
		}
		return label;
	}

}

