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
package org.obeonetwork.dsl.database.liquibasegen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher.LiquibaseDefaultType;

import liquibase.change.core.AddDefaultValueChange;
import liquibase.database.Database;
import liquibase.database.core.H2Database;
import liquibase.database.core.MSSQLDatabase;
import liquibase.database.core.MariaDBDatabase;
import liquibase.database.core.MySQLDatabase;
import liquibase.database.core.OracleDatabase;
import liquibase.database.core.PostgresDatabase;
import liquibase.sql.Sql;
import liquibase.sqlgenerator.SqlGeneratorFactory;

public class TextDefaultValueGenerationTest {

    @Test
    public void escapesLogicalApostrophesForEveryDatabase() {
        String value = DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, "D'Obeo");
        assertEquals("D'Obeo", value);
        for (Database database : new Database[] { new MSSQLDatabase(), new PostgresDatabase(),
                new MariaDBDatabase(), new MySQLDatabase(), new OracleDatabase(), new H2Database() }) {
            AddDefaultValueChange change = new AddDefaultValueChange();
            change.setTableName("customers");
            change.setColumnName("last_name");
            change.setColumnDataType("varchar(50)");
            change.setDefaultValue(value);
            Sql[] statements = SqlGeneratorFactory.getInstance().generateSql(change.generateStatements(database), database);
            assertTrue(database.getShortName(), statements.length > 0);
            String sql = statements[0].toSql();
            assertTrue(sql, sql.contains("'D''Obeo'"));
            assertFalse(sql, sql.contains("D''''Obeo"));
        }
    }
}
