package org.obeonetwork.dsl.database.tests.mysql;

import static org.junit.Assert.fail;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.docker.common.DockerUtils;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.api.model.Ports.Binding;

import liquibase.exception.DatabaseException;

public class MySQLTests extends AbstractTests {
	
	private static final String JDBC_MYSQL_URL_PATTERN = "jdbc:mysql://%1$s:%2$s/%3$s?createDatabaseIfNotExist=%4$s";
	
//	private static final Object MYSQL_HOST_DEFAULT = "127.0.0.1";
	private static final Object MYSQL_HOST_DEFAULT = "192.168.99.100";
	
	private static final Object MYSQL_PORT_DEFAULT = "3306";
	
	private static final String MYSQL_USERNAME_DEFAULT = "test";
	
	private static final String MYSQL_PASSWORD_DEFAULT = "test";
	
	private static final String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	private static final String MYSQL_DATABASE_MODEL_REFERENCE_PATH = "resources/mysql_outputRef.database";
	
	private static DockerUtils docker = null;

	private static String containerID;
	
	@BeforeClass
	public static void setupBeforeClass() throws DatabaseException {
		// Create and start container
		docker = new DockerUtils("tcp://192.168.99.100:2376", true);
		
		containerID = createMySQLContainer("mysqltest_junit");
		docker.startContainer(containerID);
		
		listContainers(docker.getContainers(false));
		
		String url = String.format(JDBC_MYSQL_URL_PATTERN, MYSQL_HOST_DEFAULT, MYSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
		
			
			try {
				database = TestUtils.openDatabaseConnectionWithDriver(url, MYSQL_USERNAME_DEFAULT, MYSQL_PASSWORD_DEFAULT, JDBC_MYSQL_DRIVER);
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
	
	@AfterClass
	public static void tearDownAfterClass() throws DatabaseException {
		AbstractTests.tearDownAfterClass();
		
		// Stop and remove container
		docker.stopContainer(containerID);
		docker.removeContainer(containerID);
	}
	
	private static void listContainers(List<Container> containers) {
		for (Container container : containers) {
			System.out.println("ID=" + container.getId());
			System.out.println("Names=" + StringUtils.join(Arrays.asList(container.getNames()), ","));
		}
	}
	
	private static 	String createMySQLContainer(String containerName) {
		ExposedPort tcp3306 = ExposedPort.tcp(3306);
		
		Ports portBindings = new Ports();
        portBindings.bind(tcp3306, Binding.bindPort(tcp3306.getPort()));
        
		CreateContainerResponse exec = docker.createContainerCmd("mysql:5.7")
				.withName(containerName)
				.withImage("mysql:5.7")
				.withAttachStdin(Boolean.FALSE)
				.withAttachStdout(Boolean.FALSE)
				.withAttachStderr(Boolean.FALSE)
				.withEnv("MYSQL_ROOT_PASSWORD=root",
						"MYSQL_DATABASE=northwind",
						"MYSQL_USER=test",
						"MYSQL_PASSWORD=test")
				.withExposedPorts(tcp3306)
				.withHostConfig(HostConfig.newHostConfig().
						withPortBindings(portBindings)
				)
	            .exec();
		return exec.getId();
	}
	
	@Test
	public void testImportMySQL() {
		String url = String.format(JDBC_MYSQL_URL_PATTERN, MYSQL_HOST_DEFAULT, MYSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, DATABASE_NAME_DEFAULT);
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MYSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MYSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_MYSQL_5);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MYSQL_DATABASE_MODEL_REFERENCE_PATH,
				TypesLibraryUtil.MYSQL_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}
	

	
}
