/*******************************************************************************
 * Copyright (c) 2014, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.source;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_5;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_102;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_11G;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_9;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;

public class DataSource {
	
	private static Map<String, String> jdbcDrivers = null;
	
	private static final String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String JDBC_H2_DRIVER = "org.h2.Driver";
	private static final String JDBC_ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	private static final String JDBC_POSTGRES_DRIVER = "org.postgresql.Driver";
	private static final String JDBC_SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private String databaseName;
	private String schemaName;
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;
	private String vendor;
	
	public DataSource(String databaseName, String schemaName) {
		super();
		this.databaseName = databaseName;
		this.schemaName = schemaName;
	}
	
	private Map<String, String> getJdbcDrivers() {
		if (jdbcDrivers == null) {
			jdbcDrivers = new HashMap<String, String>();
			jdbcDrivers.put(DB_MYSQL_5, JDBC_MYSQL_DRIVER);
			jdbcDrivers.put(DB_MARIADB_102, JDBC_MARIADB_DRIVER);
			jdbcDrivers.put(DB_ORACLE_11G, JDBC_ORACLE_DRIVER);
			jdbcDrivers.put(DB_H2_13, JDBC_H2_DRIVER);
			jdbcDrivers.put(DB_POSTGRES_9, JDBC_POSTGRES_DRIVER);
			jdbcDrivers.put(DB_SQLSERVER_2008, JDBC_SQLSERVER_DRIVER);
		}
		return jdbcDrivers;
	}
	
	public Connection getConnection() throws DataSourceException {
		Connection connection = null;
		try {
			Class.forName(getJdbcDriverClassName());
			return DriverManager.getConnection(getJdbcUrl(), getJdbcUsername(), getJdbcPassword());
		} catch(Exception ex) {
			JdbcUtils.closeConnection(connection);
			connection = null;
			throw new DataSourceException("Unable to connect to database", ex);
		}
	}
	
	public String getJdbcDriverClassName() {
		return getJdbcDrivers().get(getVendor());
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	public String getJdbcUsername() {
		return jdbcUsername;
	}
	
	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}
	
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
	public String getSchemaName() {
		return schemaName;
	}
	
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	@Override
	public String toString() {		
		return "Infos : "+getDatabaseName()+" - "+getJdbcUrl()+" - "+getSchemaName();
	}
}
