/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
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

import liquibase.exception.LiquibaseException;

@RunWith(Parameterized.class)
public class PostgresTests extends AbstractTests {
	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH = "resources/postgres/postgres_outputRef.database";	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH_10 = "resources/postgres/postgres_outputRef_10.database";
	private static final String JDBC_POSTGRES_URL_PATTERN = "jdbc:postgresql://%1$s:%2$s/%3$s";
	private static final String POSTGRES_HOST_DEFAULT = "localhost";
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";
	
	private final String containerName;
	private final String containerImage;
	
	public PostgresTests(String containerImage) {		
		this.containerImage = containerImage;
		this.containerName = containerImage.replace(":", "_");
	}
	
	@Parameters( name = "{0}")
	public static Collection<String[]> data() {
		return Arrays.asList(new String[] {"postgres:9.6-alpine"}, 
							new String[] { "postgres:10.16-alpine"},
							new String[] { "postgres:11.11-alpine"},
							new String[] { "postgres:12.6-alpine"},
							new String[] { "postgres:13.2-alpine"} );
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
		DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.POSTGRES_PATHMAP);
		
		Assert.assertEquals(database.getName(), databaseRef.getName());
	}
	
	/**
	 * The main difference with {@link #testImportPostgres()} test is that postgres 10 sequence have a {@link Integer#MAX_VALUE} limit, instead of {@link BigInteger#MAX_VALUE}
	 * @throws IOException
	 */
	public void testImportPostgres_10() throws IOException {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);

		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "public");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(POSTGRES_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(POSTGRES_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_POSTGRES_9);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH_10, TypesLibraryUtil.POSTGRES_PATHMAP);

		final BigInteger bigInteger = BigInteger.ZERO;
		final BigInteger bigIntegerRef = BigInteger.ZERO;
		
		database.eAllContents().forEachRemaining(o -> bigInteger.add(BigInteger.ONE));
		databaseRef.eAllContents().forEachRemaining(o -> bigIntegerRef.add(BigInteger.ONE));
		
		Assert.assertEquals(bigInteger.byteValue(), bigIntegerRef.byteValue());
		
		//TestUtils.checkEquality(database, databaseRef);
	}	


	@Before
	public void testWithPostgresVersion() {
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage);			
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
            Thread.sleep(5000); // wait for container to boot if created at the moment. 
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
		builder.command("docker", "kill", containerName);
		builder.command("docker", "rm", "-f", containerName);
		Process process = builder.start();
		process.waitFor();
	}
	
}
