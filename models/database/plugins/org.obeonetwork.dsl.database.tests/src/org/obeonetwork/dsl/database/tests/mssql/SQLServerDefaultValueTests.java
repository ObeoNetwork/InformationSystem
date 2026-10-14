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
package org.obeonetwork.dsl.database.tests.mssql;

import static org.junit.Assert.assertEquals;

import java.sql.Types;

import org.junit.Test;
import org.obeonetwork.dsl.database.reverse.utils.SQLServerDefaultValue;

/**
 * Checks three aspects of importing SQL Server text defaults: decoding SQL string
 * literals, preserving expressions and defaults of other JDBC types, and retaining
 * meaningful characters such as spaces, parentheses and apostrophes inside the text.
 * These cases guard the conversion to model values, rather than define an exhaustive
 * SQL parser test suite.
 */
public class SQLServerDefaultValueTests {

    @Test
    public void readsTextLiteralsAsModelValues() {
        assertEquals("John", SQLServerDefaultValue.toModelValue("('John')"));
        assertEquals("D'Obeo", SQLServerDefaultValue.toModelValue("('D''Obeo')"));
        assertEquals("D'Obeo", SQLServerDefaultValue.toModelValue("((N'D''Obeo'))"));
        assertEquals("'quoted'", SQLServerDefaultValue.toModelValue("('''quoted''')"));
    }

    @Test
    public void preservesSpacesAndParenthesesInsideTheValue() {
        assertEquals("  John  ", SQLServerDefaultValue.toModelValue(" ( '  John  ' ) "));
        assertEquals("(John)", SQLServerDefaultValue.toModelValue("('(John)')"));
        assertEquals("first\nsecond", SQLServerDefaultValue.toModelValue("('first\nsecond')"));
    }

    @Test
    public void preservesExpressionsAndNonTextValues() {
        for (String value : new String[] { "(NULL)", "((0.0000))", "(getdate())",
                "(CONVERT(varchar(30), getdate()))", "('D''Obeo' + ' John')", "NEXT VALUE FOR seq" }) {
            assertEquals(value, SQLServerDefaultValue.toModelValue(value));
        }
    }

    @Test
    public void preservesValuesThatAreNotCompleteSqlLiterals() {
        for (String value : new String[] { "D'Obeo", "('John') + ('Doe')", "('John'))", "('John)" }) {
            assertEquals(value, SQLServerDefaultValue.toModelValue(value));
        }
    }

    @Test
    public void decodesOnlyTextColumnDefaults() {
        assertEquals("D'Obeo", SQLServerDefaultValue.toModelValue("('D''Obeo')", Types.VARCHAR));
        assertEquals("D'Obeo", SQLServerDefaultValue.toModelValue("(N'D''Obeo')", Types.NVARCHAR));
        assertEquals("('2026-10-14')", SQLServerDefaultValue.toModelValue("('2026-10-14')", Types.DATE));
        assertEquals("('123')", SQLServerDefaultValue.toModelValue("('123')", Types.INTEGER));
    }

    @Test
    public void handlesMissingAndEmptyDefaults() {
        assertEquals("", SQLServerDefaultValue.toModelValue(null));
        assertEquals("", SQLServerDefaultValue.toModelValue(""));
        assertEquals("", SQLServerDefaultValue.toModelValue("('')"));
    }
}
