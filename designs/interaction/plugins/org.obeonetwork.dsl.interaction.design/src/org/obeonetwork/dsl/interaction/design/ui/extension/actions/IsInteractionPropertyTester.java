package org.obeonetwork.dsl.interaction.design.ui.extension.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.dsl.interaction.Interaction;

/**
 * Property tester used to display delete interaction command on Interaction instances only
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class IsInteractionPropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if ("isInteraction".equals(property)) {
			if (receiver instanceof Interaction) {
				return true;
			}
		}
		return false;
	}

}
