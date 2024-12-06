/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.designer.interpreter.api;

import java.util.Map;

/**
 * Common interface of all the interpreters used by the EEF runtime.
 *
 * @author sbegaudeau
 */
public interface IInterpreter {
	/**
	 * Evaluates the expression with the given body and parameters.
	 *
	 * @param variables
	 *            The variables used to evaluate the expression
	 * @param expressionBody
	 *            The body of the expression
	 * @return The result of the evaluation
	 * @throws EvaluationException
	 *             In case of error during the evaluation
	 */
	IEvaluationResult evaluateExpression(Map<String, Object> variables, String expressionBody);
}
