package org.obeonetwork.dsl.database.tests.mssql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;

public class SqlServerTests extends AbstractTests {
	
	private static final String MSSQL_USERNAME_DEFAULT = "sa";
	
	private static final String MSSQL_PASSWORD_DEFAULT = "Sqls3rv3r";

	private static final String JDBC_MSSQL_URL_PATTERN = "jdbc:sqlserver://%1$s:%2$s;databaseName=%3$s";
	
	private static final String MSSQL_HOST_DEFAULT = "127.0.0.1";
	
	private static final String MSSQL_PORT_DEFAULT = "1433";
	
	private static final String MSSQL_CREATE_DATABASE_STATEMENT = "IF (db_id(N'%1$s') IS NULL) "
			+ "BEGIN "
			+ "CREATE DATABASE %1$s "
			+ "END;";
	
	private static final String MSSQL_DATABASE_MODEL_REFERENCE_PATH = "resources/mssql_outputRef.database";
	
	@BeforeClass
	public static void setUpBeforeClass() throws DatabaseException, DataSourceException, SQLException {
		String url = String.format("jdbc:sqlserver://%1$s:%2$s", MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT);
		DataSource dataSource = new DataSource("", "");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MSSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MSSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_SQLSERVER_2008);
		
		try(Connection connection = dataSource.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format(MSSQL_CREATE_DATABASE_STATEMENT, DATABASE_NAME_DEFAULT));
			}
		}
		
		String databaseUrl = String.format(JDBC_MSSQL_URL_PATTERN, MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		database = TestUtils.openDatabaseConnection(databaseUrl, MSSQL_USERNAME_DEFAULT, MSSQL_PASSWORD_DEFAULT);
	}
	
	@Test
	public void testImportMsSQL() {
		String url = String.format(JDBC_MSSQL_URL_PATTERN, MSSQL_HOST_DEFAULT, MSSQL_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "dbo");
		dataSource.setJdbcUrl(url);
		dataSource.setJdbcUsername(MSSQL_USERNAME_DEFAULT);
		dataSource.setJdbcPassword(MSSQL_PASSWORD_DEFAULT);
		dataSource.setVendor(DatabaseConstants.DB_SQLSERVER_2008);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(MSSQL_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.SQLSERVER_PATHMAP);
		
		TestUtils.checkEquality(database, databaseRef);
	}

}
