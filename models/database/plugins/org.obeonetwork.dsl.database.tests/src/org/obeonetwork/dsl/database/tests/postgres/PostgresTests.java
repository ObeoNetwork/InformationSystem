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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

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
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

/**
 * Test class for reverse engineering of PostgreSQL Databases to models.
 * It runs docker containers for each version to test.
 * This test class is parameterized using the method {@link PostgresTests#postgreSQLVersions()}.
 * It requires to have Docker installed on the running machine.
 * The method annotated with {@link Before} launches the container, then the {@link Test} reverse engineer the postgreSQL Database.
 * Finally the method annotated with {@link After} stops and remove the PostgreSQL Docker container.
 * Note that these tests have been developed on a Windows-based computer, and unexpected behaviors could happen on other operating systems.
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
@RunWith(Parameterized.class)
public class PostgresTests extends AbstractTests {
	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH = "resources/postgres/";	
	private static final String JDBC_POSTGRES_URL_PATTERN = "jdbc:postgresql://%1$s:%2$s/%3$s";
	private static final String POSTGRES_HOST_DEFAULT = "localhost";
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";
	
	private final String containerName; 
	private final String containerImage;
	

	/**
	 * The {@link String} parameter is provided through the {@link Parameterized} JUnit Runner. 
	 */
	public PostgresTests(String containerImage) {		
		this.containerImage = containerImage;
		this.containerName = containerImage.replace(":", "_"); // container name cannot contain the ':' character, often used in Docker images. 
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
	@Override
	public void setUpBeforeTest() throws LiquibaseException {
	}
	
	@Test
	public void testImportPostgres() throws IOException, LiquibaseException {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
        database = TestUtils.openDatabaseConnection(url, POSTGRES_USERNAME_DEFAULT, POSTGRES_PASSWORD_DEFAULT);
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
				
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "public");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(POSTGRES_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(POSTGRES_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_POSTGRES_9);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);			
		String modelRefURI = String.format("%s%s.database", POSTGRES_DATABASE_MODEL_REFERENCE_PATH, containerName);
		
		if (new File(modelRefURI).exists())	{
			DataBase databaseRef = TestUtils.loadModel(modelRefURI, TypesLibraryUtil.POSTGRES_PATHMAP);	
			Assert.assertEquals(database.getName(), databaseRef.getName());
			TestUtils.checkEquality(database, databaseRef);
		} else {
			// No reference model have been provided for the testing. 
			// We instead save the model produced, 
			// that should be verified by the tester and used as a reference later.
			TestUtils.saveModel(database, modelRefURI); 
		}			
	}
	

	@Before
	public void testWithPostgresVersion() {
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, "-p", POSTGRES_PORT_DEFAULT+":"+POSTGRES_PORT_DEFAULT, 
				"-e", "POSTGRES_PASSWORD="+POSTGRES_PASSWORD_DEFAULT, 
				"-e", "POSTGRES_DB="+DATABASE_NAME_DEFAULT, "-d", containerImage);

		try {
			Process process = builder.start();
			StringBuilder output = new StringBuilder();

	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	        }

	        int exitVal = process.waitFor();
            System.out.println(output);
            Thread.sleep(5000); 
            
            // wait for container to boot if created at the moment. 
            // a better implementation would check the output log until the containers tells its ready
            
	        if (exitVal != 0) {
	        	throw new Exception("Could not initialize docker image: exit code: "+exitVal);
	        }

		} catch (Exception e) {
			Assert.fail(e.toString());
		}		
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("docker", "kill", containerName); // shut down the container
		builder.command("docker", "rm", "-f", containerName); // removes it from docker
		Process process = builder.start();
		process.waitFor();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws DatabaseException {
		// We do not clear the database since we kill the container instead		
	}
}
