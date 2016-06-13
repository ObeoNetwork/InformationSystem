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
