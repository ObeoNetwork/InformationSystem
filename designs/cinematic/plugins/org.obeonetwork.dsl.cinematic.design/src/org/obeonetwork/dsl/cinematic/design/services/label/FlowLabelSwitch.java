/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.util.FlowSwitch;


public class FlowLabelSwitch extends FlowSwitch<String> {
	@Override
	public String caseTransition(Transition transition) {
		String label = "";
		if (transition.getOn().isEmpty() == false) {
			int nbOfEvents = transition.getOn().size();
			for (int i = 0; i < nbOfEvents; i++) {
				label += transition.getOn().get(i).getName();
				if (i < nbOfEvents - 1) {
					label += ",";
				}
			}
		}
		
		return label;
	}
	
	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}

	@Override
	public String caseFlowEvent(FlowEvent object) {		
		return String.format("%s", object.getName());		
	}

}
