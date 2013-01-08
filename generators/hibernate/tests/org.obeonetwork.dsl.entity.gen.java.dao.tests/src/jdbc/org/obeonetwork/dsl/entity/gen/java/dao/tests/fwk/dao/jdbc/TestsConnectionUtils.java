package org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.obeonetwork.fwk.dao.exception.DaoException;

/**
 * Utility class to find a Database connection
 */
public class TestsConnectionUtils {

	/**
	 * Prefix key used inside properties file
	 */
	private static final String APP_NAME = "org.obeonetwork.dsl.entity.gen.java.dao.tests";
	private static final String KEY_PREFIX = APP_NAME + ".dao.jdbc";
	
	/**
	 * Properties file
	 */
	private final static String FILE_DAO_MAPPING = "dao";
	private static ResourceBundle bundle = ResourceBundle.getBundle(FILE_DAO_MAPPING);

	private static TestsConnectionUtils instance;
	private DataSource dataSource = null;

	/** 
	 * Lock to manage concurrency access
	 */
	private static Boolean initializationLock = new Boolean(true);


	/**
	 * Initialise the connection.
	 * @return a singleton 
	 	 * @throws DaoException 
	 */
	public static TestsConnectionUtils getInstance() throws DaoException {
		if (instance == null) {
			synchronized (initializationLock) {
				if (initializationLock.equals(Boolean.TRUE)) {
					instance = new TestsConnectionUtils();
					initializationLock = new Boolean(false);
				}
			}
		}
		return instance;
	}

	/**
	 * Give a connection to the database.
	 * @return 
	 	 * @throws DaoException 
	 */
	public Connection getConnection() throws DaoException {
		return getConnectionJDBC();
	}
	
	// ----    Privates methods ----
	
	/**
	 * This constructor is private to conform singleton pattern 
	 	 * @throws DaoException 
	 */
	private TestsConnectionUtils() throws DaoException {
		initConnectionJDBC();
	}
	
	/**
	 * Initialisation throw JNDI (with a container).
	 * The JNDI key search is java:comp/env/jdbc/ + APP_NAME 
	 	 * @throws DaoException 
	 */
	private void initConnectionJNDI() throws DaoException {
		try {
			Context initialContext;
			initialContext = new InitialContext();
			if (initialContext == null) {
				throw new DaoException("getPooledConnection: Cannot get Initial Context");
			}
			String dsKey = bundle.getString(KEY_PREFIX + ".dataSource");
			dataSource = (DataSource) initialContext.lookup( dsKey );

			if (dataSource == null) {
				throw new DaoException("Init: Cannot lookup datasource");
			}
		} catch (NamingException e) {
			throw new DaoException("Init: Cannot get connection " + e);
		}
	}
	
	/**
	 * Initialisation throw JDBC.<br/>
	 * Specify KEY_PREFIX + .driver inside properties file.<br/>
	 * Exemple : org.obeonetwork.sample.dao.jdbc.driver=com.mysql.jdbc.Driver 
	 	 * @throws DaoException 
	 */
	private void initConnectionJDBC() throws DaoException {
		try {
			// Driver
			// DriverManager.setLogWriter(new PrintWriter(System.out));
			String driverName = bundle.getString(KEY_PREFIX + ".driver");
			Class.forName(driverName);
				
		} catch (ClassNotFoundException e) {
			throw new DaoException("Init: Cannot init jdbc driver class " + e);
		}
	}
	
	/**
	 * Use JNDI and its container to create a connection. 
	 * The pool strategy depends on DataSource implementation.
	 * @return 
	 	 * @throws DaoException 
	 */
	private Connection getConnectionJNDI() throws DaoException {
		try {
			Connection connection = dataSource.getConnection();
			return connection;
		
		} catch (SQLException e) {
			throw new DaoException("Cannot get connection from datasource." + e);
		}
	}

	/**
	 * Use direct JDBC API to create the connection.
	 * @return 
	 	 * @throws DaoException 
	 */
	private Connection getConnectionJDBC() throws DaoException {
		String url 		= bundle.getString(KEY_PREFIX + ".url");
		String login 	= bundle.getString(KEY_PREFIX + ".login");
		String password = bundle.getString(KEY_PREFIX + ".password");
		try {			
			Connection connection = DriverManager.getConnection(url, login, password);
			return connection;
		} catch (SQLException e) {
			throw new DaoException("Cannot get connection from DriverManager." + e);
		}
	}
}
