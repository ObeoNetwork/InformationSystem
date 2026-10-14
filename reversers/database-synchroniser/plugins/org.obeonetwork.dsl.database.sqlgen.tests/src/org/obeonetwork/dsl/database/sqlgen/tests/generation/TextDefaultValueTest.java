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
package org.obeonetwork.dsl.database.sqlgen.tests.generation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.database.sqlgen.services.DefaultValueServices;

public class TextDefaultValueTest {

    @Test
    public void quotesLogicalValuesOnce() {
        assertEquals("'John'", DefaultValueServices.formatTextDefaultValue("John"));
        assertEquals("'D''Obeo'", DefaultValueServices.formatTextDefaultValue("D'Obeo"));
        assertEquals("'  John  '", DefaultValueServices.formatTextDefaultValue("  John  "));
    }

    @Test
    public void preservesLegacyLiteralsAndComputedDefaults() {
        for (String value : new String[] { "'John'", "'D''Obeo'", "N'D''Obeo'", "('D''Obeo')",
                "GETDATE()", "CONCAT('D', 'Obeo')", "(getdate())", "NULL", "CURRENT_USER" }) {
            assertEquals(value, DefaultValueServices.formatTextDefaultValue(value));
        }
    }

    @Test
    public void formatsTextColumnsAndLeavesOtherTypesUntouched() {
        Column column = DatabaseFactory.eINSTANCE.createColumn();
        TypeInstance type = TypesLibraryFactory.eINSTANCE.createTypeInstance();
        NativeType nativeType = TypesLibraryFactory.eINSTANCE.createNativeType();
        NativeType logicalType = TypesLibraryFactory.eINSTANCE.createNativeType();
        logicalType.setName("Texte");
        nativeType.setMapsTo(logicalType);
        type.setNativeType(nativeType);
        column.setType(type);
        column.setDefaultValue("D'Obeo");
        DefaultValueServices services = new DefaultValueServices();
        assertEquals("'D''Obeo'", services.toSQLDefaultValue(column));
        assertEquals("D'Obeo", column.getDefaultValue());
        logicalType.setName("Date");
        column.setDefaultValue("(getdate())");
        assertEquals("(getdate())", services.toSQLDefaultValue(column));
    }

    @Test
    public void handlesMissingDefaults() {
        assertEquals("", DefaultValueServices.formatTextDefaultValue(null));
        assertEquals("", DefaultValueServices.formatTextDefaultValue(""));
    }
}
