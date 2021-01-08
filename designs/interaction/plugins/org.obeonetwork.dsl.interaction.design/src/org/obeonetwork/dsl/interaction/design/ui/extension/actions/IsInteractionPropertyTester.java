/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.design.ui.extension.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.dsl.interaction.Interaction;

/**
 * Property tester used to display delete interaction command on Interaction instances only
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class IsInteractionPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if ("isInteraction".equals(property)) {
			if (receiver instanceof Interaction) {
				return true;
			}
		}
		return false;
	}

}
