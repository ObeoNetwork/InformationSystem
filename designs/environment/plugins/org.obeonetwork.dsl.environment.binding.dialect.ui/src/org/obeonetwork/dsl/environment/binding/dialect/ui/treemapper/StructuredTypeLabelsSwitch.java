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
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.util.EnvironmentSwitch;

public class StructuredTypeLabelsSwitch extends EnvironmentSwitch<String> {
	
	private static final String TYPE_NAME_PATTERN = "%1s : %2s";
	
	public String getLabel(EObject eObject) {
		return doSwitch(eObject);
	}
	
	@Override
	public String caseStructuredType(StructuredType object) {
		String typePattern = TYPE_NAME_PATTERN;
		return String.format(typePattern, object.getName(), object.eClass().getName());
	}
	
	@Override
	public String caseDTO(DTO object) {
		return object.getName() + " : DTO";
	}
	
	@Override
	public String caseAttribute(Attribute object) {
		String label = object.getName();
		if (object.getType() != null && object.getType().getName() != null) {
			label += " : " + object.getType().getName();
		}
		if (object.getMultiplicity() != null
				&& (object.getMultiplicity().equals(MultiplicityKind.ZERO_STAR_LITERAL)
					|| object.getMultiplicity().equals(MultiplicityKind.ONE_STAR_LITERAL))) {
			label += " [*]";
		}
		return label;
	}

	@Override
	public String caseReference(Reference object) {
		String label = object.getName();
		if (object.getReferencedType() != null && object.getReferencedType().getName() != null) {
			label += " : " + object.getReferencedType().getName();
		}
		if (object.getMultiplicity() != null
				&& (object.getMultiplicity().equals(MultiplicityKind.ZERO_STAR_LITERAL)
					|| object.getMultiplicity().equals(MultiplicityKind.ONE_STAR_LITERAL))) {
			label += " [*]";
		}
		return label;
	}

	@Override
	public String defaultCase(EObject object) {
		return "";
	}
}
