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

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.BeforeClass;
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
 * This test class is parameterized using the method {@link PostgresTests#data()}.
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
	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH = "resources/postgres/postgres_outputRef.database";	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH_10 = "resources/postgres/postgres_outputRef_10.database";

	private static final String JDBC_POSTGRES_URL_PATTERN = "jdbc:postgresql://%1$s:%2$s/%3$s";
	
	private static final String POSTGRES_HOST_DEFAULT = "0.0.0.0";
	
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";
	
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";

	@BeforeClass
	public static void setUpBeforeClass() throws DatabaseException {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		database = TestUtils.openDatabaseConnection(url, POSTGRES_USERNAME_DEFAULT, POSTGRES_PASSWORD_DEFAULT);
	}
	
	@Test
	public void testImportPostgres() throws IOException {
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
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.POSTGRES_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}
	
	/**
	 * The main difference with {@link #testImportPostgres()} test is that postgres 10 sequence have a {@link Integer#MAX_VALUE} limit, instead of {@link BigInteger#MAX_VALUE}
	 * @throws IOException
	 */
	@Test
	public void testImportPostgres_10() throws IOException {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "public");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(POSTGRES_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(POSTGRES_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_POSTGRES_9);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH_10, TypesLibraryUtil.POSTGRES_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}	

	
}
