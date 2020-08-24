/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.graal.m2doc.services;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.graal.Transition;

public class TransitionServices {

	// @formatter:off
	@Documentation(
			comment = "{m:myTransition.getLabel()}",
		    value = "Returns a textual representation of the transition.",
		    examples = {
		    		@Example(
		    				expression = "{m:myTransition.getLabel()}", 
		    				result = "insert 'source ---[guard]---> target'.")
		    }
		)
	// @formatter:on	
	public String getLabel(Transition transition) {
		UserStoryElementServices nodeServices = new UserStoryElementServices();
		String result = "";
		result += nodeServices.getLabel(transition.getSource());
		result += " ---";
		if (transition.getGuard() != null && !transition.getGuard().isEmpty()) {
			result += "[";
			result += transition.getGuard();
			result += "]";
		}
		result += "---> ";
		result += nodeServices.getLabel(transition.getTarget());
		return result;
	}

}
