/*******************************************************************************
 * Copyright (c) 2017 Obeo.
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
package org.obeonetwork.is.designer.interpreter.aql;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.eclipse.acceleo.query.parser.AstResult;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.QueryEvaluation;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.obeonetwork.is.designer.interpreter.api.IEvaluationResult;
import org.obeonetwork.is.designer.interpreter.api.IInterpreter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * An AQL interpreter used for tests.
 *
 * @author sbegaudeau
 */
public class AQLInterpreter implements IInterpreter {

    /**
     * The prefix used by AQL expressions.
     */
    private static final String AQL_PREFIX = "aql:"; //$NON-NLS-1$

    /**
     * The cache of the expressions parsed.
     */
    private LoadingCache<String, AstResult> parsedExpressions;

    /**
     * The query environment.
     */
    private IQueryEnvironment queryEnvironment;

    /**
     * The constructor.
     */
    public AQLInterpreter() {
        this.queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
        this.queryEnvironment.registerEPackage(EcorePackage.eINSTANCE);
        this.queryEnvironment.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class);
        this.initExpressionsCache();
    }

    /**
     * The constructor.
     * 
     * @param queryEnvironment
     *            The environment to use to run the queries
     */
    public AQLInterpreter(IQueryEnvironment queryEnvironment) {
        this.queryEnvironment = queryEnvironment;
        this.initExpressionsCache();
    }

    /**
     * Initializes the cache of the expressions.
     */
    private void initExpressionsCache() {
        final IQueryBuilderEngine builder = QueryParsing.newBuilder(queryEnvironment);
        final int maxCacheSize = 500;
        this.parsedExpressions = CacheBuilder.newBuilder().maximumSize(maxCacheSize).build(new CacheLoader<String, AstResult>() {
            @Override
            public AstResult load(String key) throws Exception {
                return builder.build(key);
            }

        });
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.common.interpreter.api.IInterpreter#evaluateExpression(java.util.Map,
     *      java.lang.String)
     */
    @Override
    public IEvaluationResult evaluateExpression(Map<String, Object> variables, String expressionBody) {
        String expression = expressionBody;
        if (expression.startsWith(AQL_PREFIX)) {
            expression = expression.substring(AQL_PREFIX.length());
        }

        try {
            AstResult build = parsedExpressions.get(expression);
            IQueryEvaluationEngine evaluationEngine = QueryEvaluation.newEngine(queryEnvironment);
            final EvaluationResult evalResult = evaluationEngine.eval(build, variables);

            final BasicDiagnostic diagnostic = new BasicDiagnostic();
            if (Diagnostic.OK != build.getDiagnostic().getSeverity()) {
                diagnostic.merge(build.getDiagnostic());
            }
            if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
                diagnostic.merge(evalResult.getDiagnostic());
            }

            return org.obeonetwork.is.designer.interpreter.api.EvaluationResult.of(evalResult.getResult(), diagnostic);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

}
