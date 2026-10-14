/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.h2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.After;
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
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

/**
 * Test class for reverse engineering of H2 Databases to models.
 * It runs docker containers for each version to test.
 * This test class is parameterized using the method {@link H2DockerTests#h2versions()}.
 * It requires to have Docker installed on the running machine.
 * The method annotated with {@link Before} launches the container, then the {@link Test} reverse engineer the H2 Database.
 * Finally the method annotated with {@link After} stops and remove the H2 Docker container.
 * Note that these tests have been developed on a Windows-based computer, and unexpected behaviors could happen on other operating systems.
 * 
 * @author Obeo
 *
 */
@RunWith(Parameterized.class)
public class H2DockerTests extends AbstractDockerTests {
	
	private static final Object H2_PORT_DEFAULT = "1521";
	private static final Object H2_WEBPORT_DEFAULT = "81";
	private static final String H2_HOST_DEFAULT = "localhost";
	private static final String H2_USERNAME_DEFAULT = "sa";
	private static final String H2_DB_NAME = "test";
	private static final String JDBC_H2_URL_PATTERN = "jdbc:h2:tcp://%1$s:%2$s/%3$s";
	
	private Database h2Database;
	private Path databaseDirectory;
	private boolean containerStarted;
	
	/**
	 * The {@link String} parameter is provided through the {@link Parameterized} JUnit Runner. 
	 */
	public H2DockerTests(String containerImage) {
		super(containerImage);
	}
		
	/**
	 * {@link https://hub.docker.com/repository/docker/thibaultblf/h2}
	 * @return
	 */
	@Parameters( name = "{0}")
	public static Collection<String> h2versions() {
		return Arrays.asList(   "thibaultblf/h2:1.4.200",
								"thibaultblf/h2:1.4.199",
								"thibaultblf/h2:1.4.198",
								"thibaultblf/h2:1.4.197",
								"thibaultblf/h2:1.4.196",								
								"thibaultblf/h2:1.3.176"
							);
	}

	@Test
	public void testImportH2() throws IOException, LiquibaseException {
		String url = String.format(JDBC_H2_URL_PATTERN, H2_HOST_DEFAULT, H2_PORT_DEFAULT, H2_DB_NAME);
		
        h2Database = TestUtils.openDatabaseConnection(url, H2_USERNAME_DEFAULT, "");
		TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", h2Database);
				
		DataSource dataSource = new DataSource("h2", "PUBLIC");
		dataSource.setJdbcUsername(H2_USERNAME_DEFAULT);
		//dataSource.setJdbcUrl("jdbc:h2:tcp://localhost:1521/test");
		dataSource.setJdbcUrl(url);
		dataSource.setVendor(DatabaseConstants.DB_H2_24);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);			
		String modelRefURI = "resources/"+containerName+"/h2_outputRef.database";
		
		if (new File(modelRefURI).exists())	{
			DataBase databaseRef = TestUtils.loadModel(modelRefURI, TypesLibraryUtil.H2_PATHMAP);	
			H2Tests.prepareH2RefModel(databaseRef, database); // H2 DB have randomly generated UUID parameters. We clean this randomness for performing the comparison.
			TestUtils.checkEquality(database, databaseRef);
		} else {
			// No reference model have been provided for the testing. 
			// We instead save the model produced, 
			// that should be verified by the tester and used as a reference later.
			TestUtils.saveModel(database, modelRefURI); 
		}			
	}
	

	@Before
	public void testWithH2Version() throws IOException, InterruptedException {
		databaseDirectory = Files.createTempDirectory("isd-h2-");
		ProcessBuilder builder = new ProcessBuilder("docker", "run", "--name", containerName,
				"-p", H2_PORT_DEFAULT + ":" + H2_PORT_DEFAULT,
				"-p", H2_WEBPORT_DEFAULT + ":" + H2_WEBPORT_DEFAULT,
				"-v", databaseDirectory.toAbsolutePath() + ":/opt/h2-data", "-d", containerImage);
		runAndWaitContainerCreation(builder);
		containerStarted = true;

		// Create an empty database with this image's H2 version before connecting over TCP.
		// Recent H2 servers refuse remote creation by default.
		runDockerCommand(new ProcessBuilder("docker", "exec", containerName, "/bin/sh", "-c",
				"java -cp /opt/h2/bin/h2*.jar org.h2.tools.Shell "
				+ "-url jdbc:h2:/opt/h2-data/test -user sa -password '' -sql 'SELECT 1'"));
	}

	private void runDockerCommand(ProcessBuilder builder) throws IOException, InterruptedException {
		builder.redirectErrorStream(true);
		Process process = builder.start();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		int exitCode = process.waitFor();
		if (exitCode != 0) {
			throw new IOException("Docker command failed with exit code " + exitCode);
		}
	}

	@Override
	@After
	public void tearDown() throws IOException, InterruptedException {
		try {
			if (h2Database != null) {
				h2Database.close();
				h2Database = null;
			}
		} catch (DatabaseException e) {
			throw new IOException("Could not close the H2 database", e);
		} finally {
			if (containerStarted) {
				runDockerCommand(new ProcessBuilder("docker", "rm", "-f", containerName));
				containerStarted = false;
			}
			// Delete only this test's temporary directory after the container has been removed.
			if (databaseDirectory != null) {
				try (Stream<Path> paths = Files.walk(databaseDirectory)) {
					for (Path path : paths.sorted(Comparator.reverseOrder()).toList()) {
						Files.delete(path);
					}
				}
				databaseDirectory = null;
			}
		}
	}
}
