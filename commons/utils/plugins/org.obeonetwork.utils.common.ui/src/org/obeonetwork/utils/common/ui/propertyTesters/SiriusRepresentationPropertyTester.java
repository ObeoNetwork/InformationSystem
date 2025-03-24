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
package org.obeonetwork.utils.common.ui.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

/**
 * {@link PropertyTester} for asserting that a {@link DRepresentation} is defined in a specific {@link RepresentationDescription}.
 * 
 * @author Obeo
 *
 */
public class SiriusRepresentationPropertyTester extends PropertyTester {

	private final static String PROP_DEFINITION_NAME = "definitionName";
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {		
		
		if (PROP_DEFINITION_NAME.equals(property)) {
			return testDefinitionName((DRepresentationElement) receiver, (String) expectedValue);
		}
		
		return false;
	}
	
	/**
	 * Gets the {@link RepresentationDescription} of a {@link DRepresentationElement} 
	 * and checks if its label corresponds to the expected value.
	 * @param dRepresentationElement a {@link DRepresentationElement}
	 * @param expectedValue a {@link String}
	 * @return <code>true</code> or <code>false</code>
	 * 
	 */
	private boolean testDefinitionName(DRepresentationElement dRepresentationElement, String expectedValue) {
		DRepresentation dRepresentation = SiriusUtil.findRepresentation(dRepresentationElement);
		
		if (dRepresentation != null ) {
			DRepresentationQuery dRepresentationQuery = new DRepresentationQuery(dRepresentation);
			
			if (dRepresentationQuery.getRepresentationDescriptor() != null 
					&& dRepresentationQuery.getRepresentationDescriptor().getDescription() != null
					&& dRepresentationQuery.getRepresentationDescriptor().getDescription().getName() != null) {
				
				return dRepresentationQuery.getRepresentationDescriptor().getDescription().getName().equals(expectedValue);
			}
		}
		
		return false;
	}

}
