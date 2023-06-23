/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.oracle;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.docker.common.DockerUtils;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.api.model.Ports.Binding;
import com.github.dockerjava.api.model.Volume;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;

public class OracleTests {
	
	private static final String DOCKER_DAEMON_URL = "tcp://192.168.99.100:2376";

	private static final int FIRST_CONNECTION_TIMEOUT = 120000;

	private static final String ORACLE_SYSTEM_USER_PASSWORD = "oracleserver";

	private static final String ORACLE_SYSTEM_USER = "SYSTEM";

	private static final String JDBC_ORACLE_URL_PATTERN = "jdbc:oracle:thin:@%1$s:%2$s:%3$s";
	
	private static final Object ORACLE_HOST_DEFAULT = "192.168.99.100";
	
	private static final Object ORACLE_PORT_DEFAULT = "1521";
	
	private static final String ORACLE_SID = "xe";
	
	private static final String ORACLE_DATABASE_MODEL_REFERENCE_PATH = "resources/oracle_outputRef.database";
	
	private static final String ORACLE_DATABASE_INIT_FILE_PATH = "resources/Oracle_Northwind_Init.sql";
	
	private static final String ORACLE_DATABASE_DROP_FILE_PATH = "resources/Oracle_Northwind_DropTables.sql";
	
	private static final int ORACLE_DROP_NON_EXISTING_TABLE_ERROR_CODE = 942;
	
	private static final int ORACLE_CREATE_EXISTING_USER_ERROR_CODE = 1920;
	
	private static final String ORACLE_CREATE_NORTHWIND_USER_STATEMENT = "CREATE USER NORTHWIND IDENTIFIED BY northwind";
	
	private static final String ORACLE_GRANT_CONNECTION_RIGHT_TO_USER_NORTHWIND = "GRANT CONNECT, RESOURCE, DBA TO NORTHWIND";
	
	private static final String ORACLE_DROP_NORTHWIND_USER_STATEMENT = "DROP USER NORTHWIND CASCADE";
	
	private static final String ORACLE_NORTHWIND_USER = "NORTHWIND";
	
	private static final String ORACLE_NORTHWIND_USER_PASSWORD = "northwind";

	private static DataSource systemDataSource;

	private static DataSource northwindDataSource;
	
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
	
	private static DockerUtils docker = null;

	private static String containerID;
	
	private static Image loadOracleImage() {
		// Check if image already exists
		List<Image> images = docker.getImages("oracle/database:11.2.0.2-xe");
		if (images.isEmpty()) {
			// Load image
			try {
				//docker.loadImage("D:/temp/docker/oracle11G-XE/oracle-xe-docker.tar");
				docker.loadImage(new URL("http://update.obeo.fr/livraisonsClients/Minist%c3%a8re%20de%20la%20d%c3%a9fense/Docker/oracle/oracle-xe-docker.tar"));
			} catch (IOException e) {
				fail("load oracle image failed : " + e.getMessage());
			}
			images = docker.getImages("oracle/database:11.2.0.2-xe");
		}
		return images.isEmpty() ? null : images.get(0); 
	}
	
	private static String createOracleContainer(String containerName) {
		Image image = loadOracleImage();
		if (image != null) {
			
//			docker run --name orcl --shm-size=1g -p 1521:1521 -p 8080:8080 -e ORACLE_PWD=oracleserver oracle/database:11.2.0.2-xe
			ExposedPort tcp1521 = ExposedPort.tcp(1521);
			ExposedPort tcp8080 = ExposedPort.tcp(8080);
			
			Ports portBindings = new Ports();
	        portBindings.bind(tcp1521, Binding.bindPort(tcp1521.getPort()));
	        portBindings.bind(tcp8080, Binding.bindPort(tcp8080.getPort()));
	        
			CreateContainerResponse exec = docker.createContainerCmd("oracle/database:11.2.0.2-xe")
					.withName(containerName)
					.withImage("oracle/database:11.2.0.2-xe")
					.withAttachStdin(Boolean.FALSE)
					.withAttachStdout(Boolean.FALSE)
					.withAttachStderr(Boolean.FALSE)
					.withEnv("ORACLE_PWD=oracleserver")
//					.withVolumes(new Volume("oradata:/u01/app/oracle/oradata"))
					.withExposedPorts(tcp1521)
					.withHostConfig(HostConfig.newHostConfig()
							.withShmSize( 1073741824L /*FileUtils.ONE_GB*/)
							.withPortBindings(portBindings)
							.withBinds(new Bind("oradata", new Volume("/u01/app/oracle/oradata")))
					)
		            .exec();
			return exec.getId();
		}
		return null;
	}
	
	private static void initializeContainer() {
		// Create and start container
		docker = new DockerUtils(DOCKER_DAEMON_URL, true);
		
		containerID = createOracleContainer("oracletest_junit");
		docker.startContainer(containerID);
		
		boolean started = docker.waitUntilContainerIsStarted(containerID, FIRST_CONNECTION_TIMEOUT);
		
		System.out.println("started = " + started);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws SQLException, DataSourceException {
		initializeContainer();

		
		// Creates the Northwind user
		String url = String.format(JDBC_ORACLE_URL_PATTERN, ORACLE_HOST_DEFAULT, ORACLE_PORT_DEFAULT, ORACLE_SID);
		systemDataSource = new DataSource(ORACLE_SID, ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcUrl(url);
		systemDataSource.setJdbcUsername(ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcPassword(ORACLE_SYSTEM_USER_PASSWORD);
		systemDataSource.setVendor(DatabaseConstants.DB_ORACLE_21C);
		executeMultipleStatementWithSilentCatches(systemDataSource, ORACLE_CREATE_NORTHWIND_USER_STATEMENT, ORACLE_GRANT_CONNECTION_RIGHT_TO_USER_NORTHWIND);
		
		// Creates a datasource with the northwind user for future statement execution
		northwindDataSource = new DataSource(ORACLE_SID, ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcUrl(url);
		northwindDataSource.setJdbcUsername(ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcPassword(ORACLE_NORTHWIND_USER_PASSWORD);
		northwindDataSource.setVendor(DatabaseConstants.DB_ORACLE_21C);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws SQLException, DataSourceException {
		if (systemDataSource != null) {
			executeStatementWithSilentCatches(systemDataSource, ORACLE_DROP_NORTHWIND_USER_STATEMENT);
		}
		
		// Stop and remove container
		docker.stopContainer(containerID);
		docker.removeContainer(containerID);
	}
	
	@Before
	public void setUpBeforeTest() throws IOException, SQLException, DataSourceException {
		this.executeSQLFromFile(northwindDataSource, ORACLE_DATABASE_DROP_FILE_PATH);
		this.executeSQLFromFile(northwindDataSource, ORACLE_DATABASE_INIT_FILE_PATH);
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
	public void testImportOracle() {
		String url = String.format(JDBC_ORACLE_URL_PATTERN, ORACLE_HOST_DEFAULT, ORACLE_PORT_DEFAULT, ORACLE_SID);
		
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
