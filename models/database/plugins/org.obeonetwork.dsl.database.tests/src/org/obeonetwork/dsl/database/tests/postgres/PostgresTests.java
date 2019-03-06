package org.obeonetwork.dsl.database.tests.postgres;

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

public class PostgresTests extends AbstractTests {
	
	private static final String POSTGRES_DATABASE_MODEL_REFERENCE_PATH = "resources/postgres_outputRef.database";
	
	private static final String JDBC_POSTGRES_URL_PATTERN = "jdbc:postgresql://%1$s:%2$s/%3$s";
	
	private static final String POSTGRES_HOST_DEFAULT = "127.0.0.1";
	
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	
	private static final String POSTGRES_PASSWORD_DEFAULT = "postgres";

	@BeforeClass
	public static void setUpBeforeClass() throws DatabaseException {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		database = TestUtils.openDatabaseConnection(url, POSTGRES_USERNAME_DEFAULT, POSTGRES_PASSWORD_DEFAULT);
	}
	
	@Test
	public void testImportPostgres() {
		String url = String.format(JDBC_POSTGRES_URL_PATTERN, POSTGRES_HOST_DEFAULT, POSTGRES_PORT_DEFAULT, DATABASE_NAME_DEFAULT, true);
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "public");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(POSTGRES_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(POSTGRES_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_POSTGRES_9);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(POSTGRES_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.POSTGRES_PATHMAP);
		
		TestUtils.checkEquality(database, databaseRef);
	}

}
