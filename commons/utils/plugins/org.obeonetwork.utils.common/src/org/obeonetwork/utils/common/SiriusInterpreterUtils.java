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
package org.obeonetwork.utils.common;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;

public class SiriusInterpreterUtils {
	
	/**
	 * Evaluate the given expression ignoring any exception. An empty list is returned if the evaluation fails.
	 * 
	 * @param interpreter
	 * @param context
	 * @param expression
	 * @return
	 */
	public static List<EObject> evaluateToEObjectList(IInterpreter interpreter, EObject context, String expression) {
		List<EObject> list = null;
		try {
			list = EObjectUtils.toEObjectList(interpreter.evaluate(context, expression));
		} catch (EvaluationException e) {
			e.printStackTrace();
			// Safely do nothing
		}
		
		return list;
	}

	/**
	 * Evaluate the given expression ignoring any exception. null is returned if the evaluation fails.
	 * 
	 * @param interpreter
	 * @param context
	 * @param expression
	 * @return
	 */
	public static EObject evaluateToEObject(IInterpreter interpreter, EObject context, String expression) {
		EObject result = null;
		try {
			result = interpreter.evaluateEObject(context, expression);
		} catch (EvaluationException e) {
			e.printStackTrace();
			// Safely do nothing
		}
		
		return result;
	}
	
	public static boolean evaluateToBoolean(IInterpreter interpreter, EObject context, String expression, boolean defaultValue) {
		boolean b = defaultValue;
        try {
        	b = interpreter.evaluateBoolean(context, expression);
		} catch (EvaluationException e) {
			e.printStackTrace();
			// Bad luck
		}
        return b;
	}

}
