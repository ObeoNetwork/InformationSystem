/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.mssql;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractDockerTests;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

@RunWith(Parameterized.class)
public class SqlServerDockerTests extends AbstractDockerTests {
	
	private static final String MSSQL_USERNAME_DEFAULT = "sa";
	private static final String MSSQL_PASSWORD_DEFAULT = "Sqls3rv3r";
	private static final String JDBC_MSSQL_URL_PATTERN = "jdbc:sqlserver://%1$s:%2$s;databaseName=%3$s;encrypt=false";
	private static final String MSSQL_HOST_DEFAULT = "localhost";
	private static final String MSSQL_PORT_DEFAULT = "1433";
	private static final String MSSQL_CREATE_DATABASE_STATEMENT = "IF (db_id(N'%1$s') IS NULL) "
			+ "BEGIN "
			+ "CREATE DATABASE %1$s "
			+ "END;";
	private static final String MSSQL_DATABASE_MODEL_REFERENCE_PATH = "resources/mssql_outputRef.database";

	public SqlServerDockerTests(String containerImage) {
		super(containerImage);
	}
	
	@Parameters( name = "{0}")
	public static Collection<String> SqlServerVersions() {
		return Arrays.asList(	
								"mcr.microsoft.com/mssql/server:2022-latest"
							);
	}
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException, InterruptedException {
		
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, 
				"-p", MSSQL_PORT_DEFAULT+":"+MSSQL_PORT_DEFAULT, 
				"-e", "ACCEPT_EULA=Y", 
//				"-e", "MSSQL_PID="+MSSQL_USERNAME_DEFAULT,
				"-e", "SA_PASSWORD="+MSSQL_PASSWORD_DEFAULT,
				"-d", containerImage);
		
		runAndWaitContainerCreation(builder);
		
		String url = String.format("jdbc:sqlserver://%1$s:%2$s;encrypt=false", MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT);
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
			Thread.sleep(1000);
			
			try {
				database = TestUtils.openDatabaseConnection(url, MSSQL_USERNAME_DEFAULT, MSSQL_PASSWORD_DEFAULT);
			} catch (DatabaseException e) {
				// Do nothing
				// Database is probably not fully started yet
			}
			timeoutOccured = Duration.between(start, Instant.now()).toMillis() > 60000;
		}
		
		if (database == null) {
			fail("Unable to connect to database within " + 60000 +  " ms");
		}
	}
	
	@Test
	public void testImportMsSQL() throws SQLException, DataSourceException, InterruptedException, LiquibaseException {
		
		String url = String.format("jdbc:sqlserver://%1$s:%2$s;encrypt=false", MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT);
		
		// Init DB
		
		DataSource dataSource = new DataSource("", "");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MSSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MSSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_SQLSERVER_2008);
		
		TestUtils.executeStatement(dataSource, String.format(MSSQL_CREATE_DATABASE_STATEMENT, DATABASE_NAME_DEFAULT));
		
		String databaseUrl = String.format(JDBC_MSSQL_URL_PATTERN, MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		database = TestUtils.openDatabaseConnection(databaseUrl, MSSQL_USERNAME_DEFAULT, MSSQL_PASSWORD_DEFAULT);
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);

		// Run the test
		
		dataSource = new DataSource(DATABASE_NAME_DEFAULT, "dbo");
		dataSource.setJdbcUrl(databaseUrl);
		dataSource.setJdbcUsername(MSSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MSSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_SQLSERVER_2008);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MSSQL_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.SQLSERVER_PATHMAP);
		
		TestUtils.checkEquality(database, databaseRef);
	}
}
