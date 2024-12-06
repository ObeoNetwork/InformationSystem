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
 * The factory used to create the {@link IVariableManager}.
 *
 * @author sbegaudeau
 */
public class VariableManagerFactory {
	/**
	 * Returns a new instance of the {@link IVariableManager}.
	 *
	 * @return A new instance of the {@link IVariableManager}
	 */
	public IVariableManager createVariableManager() {
		return new VariableManager();
	}
}
