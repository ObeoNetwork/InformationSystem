package org.obeonetwork.dsl.database.tests.oracle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public class OracleTests {
	
	private static final String ORACLE_SYSTEM_USER_PASSWORD = "oracleserver";

	private static final String ORACLE_SYSTEM_USER = "SYSTEM";

	private static final String JDBC_ORACLE_URL_PATTERN = "jdbc:oracle:thin:@%1$s:%2$s:%3$s";
	
	private static final Object ORACLE_HOST_DEFAULT = "127.0.0.1";
	
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
	
	@BeforeClass
	public static void setUpBeforeClass() throws SQLException, DataSourceException {
		// Creates the Northwind user
		String url = String.format(JDBC_ORACLE_URL_PATTERN, ORACLE_HOST_DEFAULT, ORACLE_PORT_DEFAULT, ORACLE_SID);
		systemDataSource = new DataSource(ORACLE_SID, ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcUrl(url);
		systemDataSource.setJdbcUsername(ORACLE_SYSTEM_USER);
		systemDataSource.setJdbcPassword(ORACLE_SYSTEM_USER_PASSWORD);
		systemDataSource.setVendor(DatabaseConstants.DB_ORACLE_11G);
		executeMultipleStatementWithSilentCatches(systemDataSource, ORACLE_CREATE_NORTHWIND_USER_STATEMENT, ORACLE_GRANT_CONNECTION_RIGHT_TO_USER_NORTHWIND);
		
		// Creates a datasource with the northwind user for future statement execution
		northwindDataSource = new DataSource(ORACLE_SID, ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcUrl(url);
		northwindDataSource.setJdbcUsername(ORACLE_NORTHWIND_USER);
		northwindDataSource.setJdbcPassword(ORACLE_NORTHWIND_USER_PASSWORD);
		northwindDataSource.setVendor(DatabaseConstants.DB_ORACLE_11G);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws SQLException, DataSourceException {
		if (systemDataSource != null) {
			executeStatementWithSilentCatches(systemDataSource, ORACLE_DROP_NORTHWIND_USER_STATEMENT);
		}
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
		dataSource.setVendor(DatabaseConstants.DB_ORACLE_11G);
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = TestUtils.loadModel(ORACLE_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.ORACLE_PATHMAP);
		
		TestUtils.checkEquality(database, databaseRef);
	}
}
