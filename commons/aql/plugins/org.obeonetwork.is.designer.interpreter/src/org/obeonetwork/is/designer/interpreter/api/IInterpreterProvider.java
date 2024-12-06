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

/**
 * This class is used to create a new instance of an interpreter and determine if it can handle a given expression.
 *
 * @author sbegaudeau
 */
public interface IInterpreterProvider {
	/**
	 * Indicates if the {@link IInterpreter} that can be created by this provider can handle the given expression.
	 *
	 * @param expression
	 *            The expression
	 * @return <code>true</code> if the {@link IInterpreter} that can be created can handle the given expression,
	 *         <code>false</code> otherwise
	 */
	boolean canHandle(String expression);

	/**
	 * Creates a new instance of the interpreter.
	 * 
	 * @return A new instance of the interpreter
	 */
	IInterpreter createInterpreter();
}
