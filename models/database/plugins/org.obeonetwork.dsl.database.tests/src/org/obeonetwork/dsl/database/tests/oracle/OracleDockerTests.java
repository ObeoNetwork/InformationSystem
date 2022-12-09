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
package org.obeonetwork.dsl.database.tests.oracle;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

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
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

@RunWith(Parameterized.class)
public class OracleDockerTests extends AbstractDockerTests {
	
	private static final String JDBC_ORACLE_URL_PATTERN = "jdbc:oracle:thin:@%1$s:%2$s:%3$s";
	private static final String ORACLE_HOST_DEFAULT = "localhost";
	private static final String ORACLE_PORT_DEFAULT = "1521";
	private static final String ORACLE_SID = "xe";
	
	private static final String ORACLE_NORTHWIND_USER = "NORTHWIND";
	private static final String ORACLE_NORTHWIND_USER_PASSWORD = "northwind";
	private static final String ORACLE_DATABASE_MODEL_REFERENCE_PATH = "resources/oracle_outputRef.database";
	
	private static final String ORACLE_SYSTEM_USER = "SYSTEM";
	private static final String ORACLE_SYSTEM_USER_PASSWORD = "oracleserver";
	
	private static final String ORACLE_ALTER_SESSION_SET = "ALTER SESSION SET container=xepdb1";
	private static final String ORACLE_CREATE_NORTHWIND_USER_STATEMENT = "CREATE USER NORTHWIND IDENTIFIED BY northwind";
	private static final String ORACLE_GRANT_CONNECTION_RIGHT_TO_USER_NORTHWIND = "GRANT CONNECT, RESOURCE, DBA TO NORTHWIND";
	private static final int ORACLE_DROP_NON_EXISTING_TABLE_ERROR_CODE = 942;
	private static final int ORACLE_CREATE_EXISTING_USER_ERROR_CODE = 1920;
	
	private static final String ORACLE_DATABASE_INIT_FILE_PATH = "resources/Oracle_Northwind_Init.sql";
	private static final String ORACLE_DATABASE_DROP_FILE_PATH = "resources/Oracle_Northwind_DropTables.sql";
	
	private static DataSource systemDataSource;
	
	public OracleDockerTests(String containerImage) {
		super(containerImage); 
	}
	
	@Parameters( name = "{0}")
	public static Collection<String> OracleVersions() {
		return Arrays.asList(	
								"oracle/database:11.2.0.2-xe",
								"container-registry.oracle.com/database/express:21.3.0-xe"
							);
	}
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException {
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName,
				"-p", ORACLE_PORT_DEFAULT+":"+ORACLE_PORT_DEFAULT, 
				"-p", 8080+":"+8080,
				"-e", "ORACLE_PWD="+ORACLE_SYSTEM_USER_PASSWORD, 
				"--shm-size=1gb",
				"-d", containerImage);

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
	
	
	private static void executeMultipleStatementWithSilentCatches(DataSource dataSource, String... requests) throws SQLException, DataSourceException {
		for (String request : requests) {
			executeStatementWithSilentCatches(dataSource, request);
		}
	}
	
	/**
	 * Executes sql with a sql statement. Catches silently SQLException with:
	 * <ul>
	 * <li>the error code <b>942</b> which is thrown when a sql statement is executed on a
	 * table or view that does not exist, that you do not have access to, or that
	 * belongs to another schema and you didn't reference the table by the schema
	 * name.</li>
	 * <li>the error code <b>1920</b> which is thrown when attempting to create a user that
	 * already exists or attempting to assign a role that has already been
	 * assigned.</li>
	 * </ul>
	 * 
	 * @param dataSource The {@link DataSource} used to get the jdbc connection
	 * @param request   The sql request to execute
	 * @throws SQLException Any SQLException error but 942 error code
	 * @throws DataSourceException In case of error
	 */
	private static void executeStatementWithSilentCatches(DataSource dataSource, String request) throws SQLException, DataSourceException {
		try {
			TestUtils.executeStatement(dataSource, request);
		} catch (SQLException e) {
			switch (e.getErrorCode()) {
				case ORACLE_DROP_NON_EXISTING_TABLE_ERROR_CODE:
				case ORACLE_CREATE_EXISTING_USER_ERROR_CODE:
					// Do nothing
					break;
				default:
					throw e;
			}
		}
	}
	
	private void executeSQLFromFile(DataSource dataSource, String filePath)
			throws IOException, SQLException, DataSourceException {
		File file = new File(filePath);
		byte[] bytes;
		bytes = Files.readAllBytes(file.toPath());
		String sql = new String(bytes);
		String[] requests = sql.split(";");
		executeMultipleStatementWithSilentCatches(dataSource, requests);
	}
	
	@Test
	public void testImportOracle() throws InterruptedException, SQLException, DataSourceException, IOException, LiquibaseException {
		
		// Wait for container initialization
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1?oracle.net.disableOob=true";
		
		if(this.containerImage.equals("oracle/database:11.2.0.2-xe")) {
			url = String.format(JDBC_ORACLE_URL_PATTERN, ORACLE_HOST_DEFAULT, ORACLE_PORT_DEFAULT, ORACLE_SID);
		}
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
			Thread.sleep(1000);
		
			
			try {
				database = TestUtils.openDatabaseConnection(url, ORACLE_SYSTEM_USER, ORACLE_SYSTEM_USER_PASSWORD);
			} catch (DatabaseException e) {
				// Do nothing
				// Database is probably not fully started yet
			}
			timeoutOccured = Duration.between(start, Instant.now()).toMillis() > 300000;
		}
		
		if (database == null) {
			fail("Unable to connect to database within " + 300000 +  " ms");
		}
		
		
		// Creates the Northwind user
		systemDataSource = new DataSource(ORACLE_SID, ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcUrl(url);
		systemDataSource.setJdbcUsername(ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcPassword(ORACLE_SYSTEM_USER_PASSWORD);
		systemDataSource.setVendor(DatabaseConstants.DB_ORACLE_21C);
		
		if(!this.containerImage.equals("oracle/database:11.2.0.2-xe")) {
			// Ignore this query for versions before Oracle 12
			executeMultipleStatementWithSilentCatches(systemDataSource, ORACLE_ALTER_SESSION_SET);
		}
		
		executeMultipleStatementWithSilentCatches(systemDataSource, ORACLE_CREATE_NORTHWIND_USER_STATEMENT, ORACLE_GRANT_CONNECTION_RIGHT_TO_USER_NORTHWIND);
		
		// Creates a datasource with the northwind user for future statement execution
		DataSource northwindDataSource = new DataSource(ORACLE_SID, ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcUrl(url);
		northwindDataSource.setJdbcUsername(ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcPassword(ORACLE_NORTHWIND_USER_PASSWORD);
		northwindDataSource.setVendor(DatabaseConstants.DB_ORACLE_21C);
		
		this.executeSQLFromFile(northwindDataSource, ORACLE_DATABASE_DROP_FILE_PATH);
		
		if(this.containerImage.equals("oracle/database:11.2.0.2-xe")) {
			this.executeSQLFromFile(northwindDataSource, "resources/Oracle_Northwind_Init_for_Oracle_11.sql");
		}
		else {
			this.executeSQLFromFile(northwindDataSource, ORACLE_DATABASE_INIT_FILE_PATH);
		}
		
		// Run the test
		
		DataSource dataSource = new DataSource(ORACLE_SID, ORACLE_NORTHWIND_USER);
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(ORACLE_NORTHWIND_USER);
		dataSource.setJdbcPassword(ORACLE_NORTHWIND_USER_PASSWORD);
		dataSource.setVendor(DatabaseConstants.DB_ORACLE_21C);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(ORACLE_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.ORACLE_PATHMAP);
		
		TestUtils.checkEquality(database, databaseRef);
	}

}
