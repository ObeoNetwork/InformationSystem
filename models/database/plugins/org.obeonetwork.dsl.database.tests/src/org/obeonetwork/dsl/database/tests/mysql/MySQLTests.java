package org.obeonetwork.dsl.database.tests.mysql;

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

public class MySQLTests extends AbstractTests {
	
	private static final String JDBC_MYSQL_URL_PATTERN = "jdbc:mysql://%1$s:%2$s/%3$s?createDatabaseIfNotExist=%4$s";
	
	private static final Object MYSQL_HOST_DEFAULT = "127.0.0.1";
	
	private static final Object MYSQL_PORT_DEFAULT = "3306";
	
	private static final String MYSQL_USERNAME_DEFAULT = "root";
	
	private static final String MYSQL_PASSWORD_DEFAULT = "root";
	
	private static final String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	private static final String MYSQL_DATABASE_MODEL_REFERENCE_PATH = "resources/mysql_outputRef.database";
	
	@BeforeClass
	public static void setupBeforeClass() throws DatabaseException {
		String url = String.format(JDBC_MYSQL_URL_PATTERN, MYSQL_HOST_DEFAULT, MYSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		database = TestUtils.openDatabaseConnectionWithDriver(url, MYSQL_USERNAME_DEFAULT, MYSQL_PASSWORD_DEFAULT, JDBC_MYSQL_DRIVER);
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
