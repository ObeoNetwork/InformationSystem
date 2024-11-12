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
package org.obeonetwork.is.designer.acceleo.aql.business.api;

/**
 * An utility class which trims expressions by removing prefix/suffixes while
 * maintaining index positions.
 * 
 * @author cedric
 */
public class ExpressionTrimmer {

    /**
     * This represents the prefix of an Acceleo 3 expression.
     * 
     */
    private static final String ACCELEO_EXPRESSION_PREFIX = "["; //$NON-NLS-1$

    /**
     * This represents the suffix of an Acceleo 3 expression.
     * 
     */
    private static final String ACCELEO_EXPRESSION_SUFFIX = "/]"; //$NON-NLS-1$

    private int removedFromStart;

    private int removedFromEnd;

    private String expression;

    /**
     * Create a new trimmer with the given expression and a position within this
     * expression.
     * 
     * @param anyExpression
     *            the original expression which might contains prefixes or
     *            suffixes.
     */
    public ExpressionTrimmer(String anyExpression) {
        this.expression = anyExpression;
        trim();
    }

    private void trim() {
        if (expression != null) {
            if (expression.startsWith(AQLConstants.AQL_PREFIX)) {
                expression = expression.substring(AQLConstants.AQL_PREFIX.length());
                removedFromStart += AQLConstants.AQL_PREFIX.length();
            }
            if (expression.startsWith(ACCELEO_EXPRESSION_PREFIX)) {
                expression = expression.substring(ACCELEO_EXPRESSION_PREFIX.length());
                removedFromStart += ACCELEO_EXPRESSION_PREFIX.length();
            }
            if (expression.endsWith(ACCELEO_EXPRESSION_SUFFIX)) {
                expression = expression.substring(0, expression.length() - ACCELEO_EXPRESSION_SUFFIX.length());
                removedFromEnd += ACCELEO_EXPRESSION_SUFFIX.length();

            }
        }
    }

    /**
     * return true if the cursor position given is within the AQL expression.
     * false if it is part of the suffix/prefixes.
     * 
     * @param position
     *            : the cursor position.
     * @return true if the cursor position given is within the AQL expression.
     *         false if it was part of the suffix/prefixes.
     */
    public boolean positionIsWithinAQL(int position) {
        return position - removedFromStart <= expression.length() - removedFromEnd;
    }

    /**
     * Return the cursor position after removing the prefix/suffixes. It might
     * return -1 if the cursor position before trimming was not within the
     * expression.
     * 
     * @param positionWithinExpression
     *            a cursor position within the global expression.
     * @return the cursor position afeter removing the prefix/suffixes. -1 when
     *         the original position was not within the expression.
     */
    public int getPositionWithinAQL(int positionWithinExpression) {
        if (positionIsWithinAQL(positionWithinExpression)) {
            return positionWithinExpression - removedFromStart;
        }
        return -1;
    }

    /**
     * The expression with no suffix/prefix.
     * 
     * @return The expression with no suffix/prefix.
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Return the cursor position within the global expression from a position
     * within the AQL expression.
     * 
     * @param cursorOffset
     *            a cursor position valid within the AQL expression.
     * @return the corresponding cursor offset within the non-trimmed
     *         expression.
     */
    public int getPositionInExpression(int cursorOffset) {
        return cursorOffset + removedFromStart;
    }

}
