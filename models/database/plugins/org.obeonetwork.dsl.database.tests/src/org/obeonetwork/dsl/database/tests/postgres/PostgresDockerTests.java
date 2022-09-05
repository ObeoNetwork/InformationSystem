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
package org.obeonetwork.dsl.database.tests.postgres;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
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

/**
 * Test class for reverse engineering of PostgreSQL Databases to models.
 * It runs docker containers for each version to test.
 * This test class is parameterized using the method {@link PostgresDockerTests#postgreSQLVersions()}.
 * It requires to have Docker installed on the running machine.
 * The method annotated with {@link Before} launches the container, then the {@link Test} reverse engineer the postgreSQL Database.
 * Finally the method annotated with {@link After} stops and remove the PostgreSQL Docker container.
 * Note that these tests have been developed on a Windows-based computer, and unexpected behaviors could happen on other operating systems.
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
@RunWith(Parameterized.class)
public class PostgresDockerTests extends AbstractDockerTests {
	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH = "resources/postgres_outputRef.database";	
	private static final String JDBC_POSTGRES_URL_PATTERN = "jdbc:postgresql://%1$s:%2$s/%3$s";
	private static final String POSTGRES_HOST_DEFAULT = "localhost";
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";
	private static final String JDBC_POSTGRES_DRIVER = "org.postgresql.Driver";
	
	/**
	 * The {@link String} parameter is provided through the {@link Parameterized} JUnit Runner. 
	 */
	public PostgresDockerTests(String containerImage) {		
		super(containerImage);
	}
		
	/**
	 * {@link https://hub.docker.com/_/postgres}
	 * @return
	 */
	@Parameters( name = "{0}")
	public static Collection<String> postgreSQLVersions() {
		return Arrays.asList(	
								"postgres:9.6-alpine",
								"postgres:10.16-alpine",
								"postgres:11.11-alpine",
								"postgres:12.6-alpine",
								"postgres:12.7-alpine",
								"postgres:13.2-alpine",
								"postgres:14.3-alpine"
							);
	}
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException, InterruptedException {
		
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, "-p", POSTGRES_PORT_DEFAULT+":"+POSTGRES_PORT_DEFAULT, 
				"-e", "POSTGRES_PASSWORD="+POSTGRES_PASSWORD_DEFAULT, 
				"-e", "POSTGRES_DB="+DATABASE_NAME_DEFAULT, "-d", containerImage);
		
		runAndWaitContainerCreation(builder);
		
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
			Thread.sleep(1000);
			
			try {
				database = TestUtils.openDatabaseConnectionWithDriver(url, POSTGRES_USERNAME_DEFAULT, POSTGRES_PASSWORD_DEFAULT, JDBC_POSTGRES_DRIVER);
			} catch (DatabaseException e) {
				// Do nothing
				// Database is probably not fully started yet
			}
			timeoutOccured = Duration.between(start, Instant.now()).toMillis() > 30000;
		}
		
		if (database == null) {
			fail("Unable to connect to database within " + 30000 +  " ms");
		}
	}
	
	@Test
	public void testImportPostgres() throws IOException, LiquibaseException {
		
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		// Init DB
		
        database = TestUtils.openDatabaseConnection(url, POSTGRES_USERNAME_DEFAULT, POSTGRES_PASSWORD_DEFAULT);
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
				
		// Run the test
		
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "public");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(POSTGRES_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(POSTGRES_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_POSTGRES_14);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);			
		
		if(this.containerImage.equals("postgres:9.6-alpine")) {
			DataBase databaseRef = TestUtils.loadModel("resources/postgres/postgres_9.6-alpine.database", TypesLibraryUtil.POSTGRES_PATHMAP);	
			TestUtils.checkEquality(database, databaseRef);
		}
		else {
			DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.POSTGRES_PATHMAP);	
			TestUtils.checkEquality(database, databaseRef);
		}
	}
}
