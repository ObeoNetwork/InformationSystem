/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.utils;

import java.sql.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Converts SQL Server string literals to model values without changing expressions. */
public final class SQLServerDefaultValue {

    private static final Pattern STRING_LITERAL = Pattern.compile("[nN]?'((?:[^']|'')*)'");

    private SQLServerDefaultValue() {
    }

    public static String toModelValue(String sqlValue, int jdbcType) {
        switch (jdbcType) {
        case Types.CHAR:
        case Types.VARCHAR:
        case Types.LONGVARCHAR:
        case Types.NCHAR:
        case Types.NVARCHAR:
        case Types.LONGNVARCHAR:
        case Types.CLOB:
        case Types.NCLOB:
            return toModelValue(sqlValue);
        default:
            return sqlValue == null ? "" : sqlValue.trim();
        }
    }

    public static String toModelValue(String sqlValue) {
        if (sqlValue == null) {
            return "";
        }
        String original = sqlValue.trim();
        String literal = original;
        while (literal.startsWith("(") && literal.endsWith(")")) {
            literal = literal.substring(1, literal.length() - 1).trim();
        }
        Matcher matcher = STRING_LITERAL.matcher(literal);
        if (matcher.matches()) {
            return matcher.group(1).replace("''", "'");
        }
        return original;
    }
}
