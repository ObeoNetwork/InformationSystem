package org.obeonetwork.dsl.database.tests.mariadb;

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
public class MariaDBDockerTests extends AbstractDockerTests {
	
	private static final String MARIADB_DATABASE_MODEL_REFERENCE_PATH = "resources/mariadb_outputRef.database";

	private static final String MARIADB_PORT_DEFAULT = "3306";
	private static final String MARIADB_HOST_DEFAULT = "localhost";
	private static final String JDBC_MARIADB_URL_PATTERN = "jdbc:mariadb://%1$s:%2$s/%3$s?createDatabaseIfNotExist=%4$s";
	private static final String MARIADB_USERNAME_DEFAULT = "test";
	private static final String MARIADB_PASSWORD_DEFAULT = "test";

	public MariaDBDockerTests(String containerImage) {
		super(containerImage);
	}
	
	@Parameters( name = "{0}")
	public static Collection<String> MariaDBVersions() {
		return Arrays.asList(	
								"mariadb/server:10.2",
								"mariadb:10.6"
							);
	}
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException, InterruptedException {
		
		ProcessBuilder builder = new ProcessBuilder();
		
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, 
				"-p", MARIADB_PORT_DEFAULT+":"+MARIADB_PORT_DEFAULT, 
				"-e", "MYSQL_ROOT_PASSWORD=root", 
				"-e", "MYSQL_DATABASE=northwind",
				"-e", "MYSQL_USER=test",
				"-e", "MYSQL_PASSWORD=test",
				"-d", containerImage);
		
		runAndWaitContainerCreation(builder);
		
		// Wait for container initialization
		
		String url = String.format(JDBC_MARIADB_URL_PATTERN, MARIADB_HOST_DEFAULT, MARIADB_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		Instant start = Instant.now();
		boolean timeoutOccured = false;
		while (database == null && timeoutOccured == false) {
			System.out.println(new Date());
			Thread.sleep(1000);
			
			try {
				database = TestUtils.openDatabaseConnection(url, MARIADB_USERNAME_DEFAULT, MARIADB_PASSWORD_DEFAULT);
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
	public void testImportMariaDB() throws LiquibaseException {
		
		String url = String.format(JDBC_MARIADB_URL_PATTERN, MARIADB_HOST_DEFAULT, MARIADB_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		
		// Init DB
		
		database = TestUtils.openDatabaseConnection(url, MARIADB_USERNAME_DEFAULT, MARIADB_PASSWORD_DEFAULT);
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
		
		// Run the test
		
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, DATABASE_NAME_DEFAULT);
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MARIADB_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MARIADB_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_MARIADB_106);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MARIADB_DATABASE_MODEL_REFERENCE_PATH,
				TypesLibraryUtil.MARIADB_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}
}
