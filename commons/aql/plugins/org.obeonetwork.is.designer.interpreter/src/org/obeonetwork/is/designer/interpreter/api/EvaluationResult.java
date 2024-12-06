/*******************************************************************************
 * Copyright (c) 2015, 2018 Obeo.
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

/**
 * Default implementaiton of {@link IEvaluationResult}, suitable for most cases.
 * 
 * @author pcdavid
 */
public final class EvaluationResult implements IEvaluationResult {
    /**
     * The raw value resulting fromt the expression's evaluation, without any
     * coercion applied. May be <code>null</code> in case of evaluation error.
     */
    private final Object rawValue;

    /**
     * The status of the evaluation.
     */
    private final Diagnostic status;

    private EvaluationResult(Object rawValue, Diagnostic status) {
        this.rawValue = rawValue;
        this.status = status;
    }

    /**
     * Creates an evaluation result indicating a successful evaluation.
     * 
     * @param o
     *            the value produced by the evaluation.
     * @return an {@link EvaluationResult} inducating a successful evaluation
     *         which produced <code><o>/code>.
     */
    public static EvaluationResult of(Object o) {
        return of(o, Diagnostic.OK_INSTANCE);
    }

    /**
     * Creates an evaluation result with an associated diagnostic.
     * 
     * @param o
     *            the value produced by the evaluation.
     * @param diag
     *            the diagnostic describing the outcome of the evaluation.
     * @return an {@link EvaluationResult} inducating an evaluation which
     *         produced <code><o>/code>.
     */
    public static EvaluationResult of(Object o, Diagnostic diag) {
        return new EvaluationResult(o, diag);
    }

    /**
     * Creates an evaluation result for a computation which was canceled or
     * never actually executed.
     * 
     * @return an evaluation result for a computation which was canceled or
     *         never actually executed.
     */
    public static EvaluationResult noEvaluation() {
        return new EvaluationResult(null, Diagnostic.CANCEL_INSTANCE);
    }

    /**
     * Creates an evaluation result for a computation which did not produce a
     * meaningful value because of an error.
     * 
     * @param diag
     *            a description of the error.
     * @return an evaluation result for a computation which did not produce a
     *         meaningful value because of an error.
     */
    public static EvaluationResult withError(Diagnostic diag) {
        return new EvaluationResult(null, diag);
    }

    /**
     * Creates an evaluation result for a computation which did not produce a
     * meaningful value because of an error.
     * 
     * @param message
     *            a textual description of the error.
     * @return an evaluation result for a computation which did not produce a
     *         meaningful value because of an error.
     */
    public static EvaluationResult withError(String message) {
        return new EvaluationResult(null, new BasicDiagnostic(Diagnostic.ERROR, IInterpreter.class.getName(), 0, message, null));
    }

    @Override
    public Object getValue() {
        return rawValue;
    }

    @Override
    public Diagnostic getDiagnostic() {
        return status;
    }

    @Override
    public boolean success() {
        return Diagnostic.ERROR != status.getSeverity();
    }

    @Override
    public Collection<EObject> asEObjects() {
        final Collection<EObject> result;
        if (rawValue instanceof Collection<?>) {
            result = ((Collection<?>) rawValue).stream().filter(EObject.class::isInstance).map(EObject.class::cast).collect(Collectors.toList());
        } else if (rawValue instanceof EObject) {
            result = Collections.singleton((EObject) rawValue);
        } else if (rawValue != null && rawValue.getClass().isArray()) {
            result = Arrays.asList((Object[]) rawValue).stream().filter(EObject.class::isInstance).map(EObject.class::cast).collect(Collectors.toList());
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

    @Override
    public String asString() {
        if (rawValue != null) {
            return String.valueOf(rawValue);
        } else {
            return ""; //$NON-NLS-1$
        }
    }
}
