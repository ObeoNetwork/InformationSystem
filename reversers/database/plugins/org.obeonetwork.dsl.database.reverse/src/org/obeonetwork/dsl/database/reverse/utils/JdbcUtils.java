package org.obeonetwork.dsl.database.reverse.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Utility class providing methods to make easier the use of JDBC.  
 * 
 */
public abstract class JdbcUtils {

	/**
	 * Method used to correctly close a connection.
	 *  
	 * @param connection the JDBC connection
	 */
	public static void closeConnection(Connection connection) {
		try {
			if( connection!=null ) {
				connection.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method used to correctly close a statement.
	 * 
	 * @param stmt the JDNC statement
	 */
	public static void closeStatement(Statement stmt) {
		try {
			if( stmt!=null ) {
				stmt.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method used to correctly close a result set.
	 * 
	 * @param rs the JDBC result set
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if( rs!=null ) {
				rs.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
