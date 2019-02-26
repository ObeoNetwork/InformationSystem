package org.obeonetwork.dsl.database.tests.mariadb;

import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;

public class MariaDBTests extends AbstractTests {
	
	private static final String MARIADB_DATABASE_MODEL_REFERENCE_PATH = "resources/mariadb_outputRef.database";

	private static final String MARIADB_PORT_DEFAULT = "3306";

	private static final String MARIADB_HOST_DEFAULT = "127.0.0.1";

	private static final String JDBC_MARIADB_URL_PATTERN = "jdbc:mariadb://%1$s:%2$s/%3$s?createDatabaseIfNotExist=%4$s";
	
	private static final String MARIADB_USERNAME_DEFAULT = "root";
	
	private static final String MARIADB_PASSWORD_DEFAULT = "root";

	@BeforeClass
	public static void setUpBeforeClass() throws DatabaseException {
		String url = String.format(JDBC_MARIADB_URL_PATTERN, MARIADB_HOST_DEFAULT, MARIADB_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		database = TestUtils.openDatabaseConnection(url, MARIADB_USERNAME_DEFAULT, MARIADB_PASSWORD_DEFAULT);
	}

	@Test
	public void testImportMariaDB() {
		String url = String.format(JDBC_MARIADB_URL_PATTERN, MARIADB_HOST_DEFAULT, MARIADB_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, DATABASE_NAME_DEFAULT);
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MARIADB_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MARIADB_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_MARIADB_102);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MARIADB_DATABASE_MODEL_REFERENCE_PATH,
				TypesLibraryUtil.MARIADB_PATHMAP);

		TestUtils.checkEquality(database, databaseRef);
	}
}
