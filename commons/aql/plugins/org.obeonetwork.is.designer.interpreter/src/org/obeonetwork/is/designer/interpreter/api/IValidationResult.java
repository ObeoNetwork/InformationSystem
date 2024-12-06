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

import org.eclipse.emf.common.util.Diagnostic;

/**
 * The result of the validation.
 *
 * @author sbegaudeau
 */
public interface IValidationResult {
	/**
	 * Returns the diagnostic.
	 * 
	 * @return The diagnostic
	 */
	Diagnostic getDiagonstic();
}
