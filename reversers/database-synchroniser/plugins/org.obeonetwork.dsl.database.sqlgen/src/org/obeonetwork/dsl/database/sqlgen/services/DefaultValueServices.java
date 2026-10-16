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
package org.obeonetwork.dsl.database.sqlgen.services;

import java.util.regex.Pattern;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

/** Formats logical text defaults while retaining existing SQL expressions. */
public class DefaultValueServices {

    // A quoted SQL literal with doubled apostrophes, e.g. 'John' or 'D''Obeo'.
    // SQL Server's N prefix denotes Unicode, e.g. N'John'; lowercase n is tolerated here.
    private static final Pattern SQL_LITERAL = Pattern.compile("[nN]?'(?:[^']|'')*'");

    // A function-call shape, including qualified names and multiline arguments.
    // Examples: GETDATE(), dbo.my_function('x'). This does not validate SQL syntax.
    private static final Pattern SQL_FUNCTION = Pattern.compile("(?s)[\\w.]+\\s*\\(.*\\)");

    public String toSQLDefaultValue(Column column) {
        String value = column.getDefaultValue();
        if (column.getType() instanceof TypeInstance) {
            NativeType type = ((TypeInstance) column.getType()).getNativeType();
            if (type != null && type.getMapsTo() != null && "Texte".equals(type.getMapsTo().getName())) {
                return formatTextDefaultValue(value);
            }
        }
        return value == null ? "" : value;
    }

    public static String formatTextDefaultValue(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        String trimmed = value.trim();
        // Preserve existing SQL forms instead of quoting them as text.
        // This includes literals, parenthesized expressions, function calls and SQL keywords:
        // NULL means no value, CURRENT_USER/SESSION_USER/SYSTEM_USER identify a user,
        // and CURRENT_TIMESTAMP supplies the current date and time.
        // This is a compatibility heuristic, not a complete SQL expression parser.
        if (SQL_LITERAL.matcher(trimmed).matches()
                || (trimmed.startsWith("(") && trimmed.endsWith(")"))
                || SQL_FUNCTION.matcher(trimmed).matches()
                || "NULL".equalsIgnoreCase(trimmed)
                || "CURRENT_USER".equalsIgnoreCase(trimmed)
                || "SESSION_USER".equalsIgnoreCase(trimmed)
                || "SYSTEM_USER".equalsIgnoreCase(trimmed)
                || "CURRENT_TIMESTAMP".equalsIgnoreCase(trimmed)) {
            return value;
        }
        return "'" + value.replace("'", "''") + "'";
    }
}
