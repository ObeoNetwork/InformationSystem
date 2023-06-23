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
package org.obeonetwork.is.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;

/**
 * {@link PropertyTester} for asserting that a {@link Reference} is bidirectionnal with two multiplicities.
 * 
 * @author Thibault Béziers la Fosse <a href="mailto:thibault.beziers-la-fosse@obeo.fr">thibault.beziers-la-fosse@obeo.fr</a>
 *
 */
public class ReferencePropertyTester extends PropertyTester {

	private static final String IS_MULTIPLE = "isMultiple";
	
	/**
	 * Checks that a {@link Reference} and its opposite have both a multiplicity 0..* or 1..* 
	 * 
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_MULTIPLE.equals(property)) {
			Reference reference = (Reference) ((DSemanticDecorator) receiver).getTarget();
			if (reference.getOppositeOf() != null) {
				return isMultiple(reference) && isMultiple(reference.getOppositeOf());
			}
		}
		
		return false;
	}
	
	/**
	 * Checks that a {@link Reference} has a 0..* or 1..* multiplicity.
	 * @param reference a {@link Reference}
	 * @return <code>true</code> if it does.
	 */
	private boolean isMultiple(Reference reference) {
		return MultiplicityKind.ONE_STAR_LITERAL.equals(reference.getMultiplicity()) || 
				MultiplicityKind.ZERO_STAR_LITERAL.equals(reference.getMultiplicity());
	}

}
