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
package org.obeonetwork.dsl.statemachine.design.ui.extension.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.dsl.statemachine.StateMachine;

/**
 * Property tester used to display delete statemachine command on StateMachine instances only
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class IsStateMachinePropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if ("isStateMachine".equals(property)) {
			if (receiver instanceof StateMachine) {
				return true;
			}
		}
		return false;
	}

}
