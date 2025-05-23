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
package org.obeonetwork.dsl.statemachine.design.ui.extension.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.dsl.statemachine.StateMachine;

/**
 * Property tester used to display delete statemachine command on StateMachine instances only
 * @author Obeo
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
