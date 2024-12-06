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

import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

/**
 * The evaluation result.
 *
 * @author sbegaudeau
 */
public interface IEvaluationResult {
    /**
     * The value returned by the expression.
     *
     * @return The value returned by the expression
     */
    Object getValue();

    /**
     * Coerces the value as a collection of EObject if possible.
     * 
     * @return a collection of {@link EObject}, which will be empty if the raw
     *         value could not be coerced.
     */
    Collection<EObject> asEObjects();

    /**
     * Coerces the value as a string.
     * 
     * @return a string representation of the value, which will be empty if the
     *         raw value could not be coerced meaningfully.
     */
    String asString();

    /**
     * The diagnostic of the evaluation.
     * 
     * @return The diagnostic
     */
    Diagnostic getDiagnostic();

    /**
     * Tests of the evaluation was a success, i.e. it produced an actual (non-
     * <code>null</code>) result and no warnings or errors.
     * 
     * @return <code>true</code> iff the evaluation was a success.
     */
    boolean success();

}
