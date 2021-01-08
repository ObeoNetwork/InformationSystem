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
package org.obeonetwork.graal.design.services.usability;

import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.NamedElement;
import org.obeonetwork.graal.Operator;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.util.GraalSwitch;

/**
 * Utilities services to compute labels for Graal elements
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class DisplayLabelServices extends GraalSwitch<String>{

	private static final String PLUS = "+";
	private static final String STAR = "*";
	private static final String NO_SPECIFIED_LABEL = "Need to be overriden";
	
	/**
	 * Computes the label for any Graal element
	 * Uses the generated GraalSwith class to do this
	 * @param context Element for whiwh we want a label to be computed
	 * @return computed label
	 */
	public String computeGraalLabel(ObeoDSMObject context) {
		return doSwitch(context);
	}

	@Override
	public String caseNamedElement(NamedElement object) {
		return object.getName();
	}

	@Override
	public String caseOperator(Operator object) {
		return object.getKind().toString().toUpperCase();
	}

	@Override
	public String caseTransition(Transition object) {
		if (object.getGuard() != null && !"".equals(object.getGuard())) {
			return "[" + object.getGuard() + "]";
		}
		return "";
	}

	@Override
	public String caseLoop(Loop object) {
		Integer lower = object.getLowerBound();
		Integer upper = object.getUpperBound(); 
		if (lower == 0 && upper == -1) {
			return STAR;
		} else if (lower == 1 && upper == -1) {
			return PLUS;
		} else if (lower == upper) {
			return lower.toString();
		}
		return lower.toString() + ".." + upper.toString();
	}
	
	@Override
	public String caseTaskReference(TaskReference object) {
		return doSwitch(object.getTask());
	}

	@Override
	public String caseObeoDSMObject(ObeoDSMObject object) {
		return NO_SPECIFIED_LABEL;
	}
}
