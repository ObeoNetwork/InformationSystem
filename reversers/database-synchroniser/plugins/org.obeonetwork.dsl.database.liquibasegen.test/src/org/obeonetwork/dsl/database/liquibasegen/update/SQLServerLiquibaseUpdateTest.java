/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.update;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Obeo
 *         
 */
@RunWith(Parameterized.class)
public class SQLServerLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest{
	
	/**
	 * 
	 * Requires a MS SQL server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test.
	 * A database named test must be created too.
	 * <code>docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=P4sS-w0rd" --host localhost -p 1433:1433 -d mcr.microsoft.com/mssql/server:2022-latest</code>
	 * Within the container create database with commands:
	 * <code>/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P 'P4sS-w0rd'</code>
	 * <code>create database test; go</code>
	 * @param fileName
	 */
	public SQLServerLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:sqlserver://localhost:1433;databaseName=test;encrypt=true;trustServerCertificate=true";
		username = "sa";
		password = "P4sS-w0rd";
	}

	@Parameters
	public static List<String> parameters() {
		return Arrays.asList(	"update/update-mssql/00-add-schema/run.changelog.xml",
								"update/update-mssql/01-create-table/run.changelog.xml",
								"update/update-mssql/02-primary-key/run.changelog.xml",
								"update/update-mssql/03-foreign-key/run.changelog.xml",
								"update/update-mssql/04-sequence/run.changelog.xml",
								"update/update-mssql/05-index/run.changelog.xml");
	}
	
	@Before
	public void removeSchema() throws Exception {
		//Delete a schema used in test in MSSQL database if existing before running  tests.
		//Since liquibase.dropAll() doesn't drop all schemas.
		applyChangeLog("update/update-clean-utils/run.mssql.schema.clean.changelog.xml") ;
	}
}
