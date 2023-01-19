/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.mysql;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractDockerTests;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

@RunWith(Parameterized.class)
public class MySQLDockerTests extends AbstractDockerTests {
	
	private static final String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_MYSQL_URL_PATTERN = "jdbc:mysql://%1$s:%2$s/%3$s?createDatabaseIfNotExist=%4$s";
	private static final Object MYSQL_HOST_DEFAULT = "localhost";
	private static final String MYSQL_PORT_DEFAULT = "3306";
	private static final String MYSQL_USERNAME_DEFAULT = "test";
	private static final String MYSQL_PASSWORD_DEFAULT = "test";
	private static final String MYSQL_DATABASE_MODEL_REFERENCE_PATH = "resources/mysql_outputRef.database";

	public MySQLDockerTests(String containerImage) {
		super(containerImage);
	}
	
	@Parameters( name = "{0}")
	public static Collection<String> MySQLVersions() {
		return Arrays.asList(	
								"mysql:5.7",
								"mysql:8.0.30"
							);
	}
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException, InterruptedException {
		
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, 
				"-p", MYSQL_PORT_DEFAULT+":"+MYSQL_PORT_DEFAULT, 
				"-e", "MYSQL_ROOT_PASSWORD=root", 
				"-e", "MYSQL_DATABASE=northwind",
				"-e", "MYSQL_USER=test",
				"-e", "MYSQL_PASSWORD=test",
				"-d", containerImage);
		
		runAndWaitContainerCreation(builder);
		
		// Wait for container initialization

		String url = String.format(JDBC_MYSQL_URL_PATTERN, MYSQL_HOST_DEFAULT, MYSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
			Thread.sleep(1000);
			
			try {
				database = TestUtils.openDatabaseConnectionWithDriver(url, MYSQL_USERNAME_DEFAULT, MYSQL_PASSWORD_DEFAULT, JDBC_MYSQL_DRIVER);
			} catch (DatabaseException e) {
				// Do nothing
				// Database is probably not fully started yet
			}
			timeoutOccured = Duration.between(start, Instant.now()).toMillis() > 90000;
		}
		
		if (database == null) {
			fail("Unable to connect to database within " + 90000 +  " ms");
		}
		
	}
	
	@Test
	public void testImportMySQL() throws LiquibaseException {
		
		String url = String.format(JDBC_MYSQL_URL_PATTERN, MYSQL_HOST_DEFAULT, MYSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		// Init DB
		
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
		
		// Run the test
		
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, DATABASE_NAME_DEFAULT);
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MYSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MYSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_MYSQL_8);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MYSQL_DATABASE_MODEL_REFERENCE_PATH,
				TypesLibraryUtil.MYSQL_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}
	
}
