/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.framework.Version;

/**
 * 
 * Builds SQL queries for Postgres according to the server's version.
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class PostGresStatementBuilder {
	
	private Connection connection;
	private Version version;
	
	/**
	 * Instantiate the builder and fetches the version of the postgres database 
	 * with the provided {@link Connection}.
	 * @param connection a {@link Connection}
	 */
	public PostGresStatementBuilder(Connection connection) {
		this.connection = connection;
		this.version = getPostgreServerVersion();
	}
		
	/**
	 * Performs an SQL query on the DB to get its version number.
	 * Note that if the server version cannot be queried, the {@link PostGresStatementBuilder} 
	 * will arbitrarily consider it as a Postgres 12.2 server. 
	 * @return a {@link Version}
	 */
	public Version getPostgreServerVersion() {
		ResultSet rs = null;		
		try {
			PreparedStatement pstmt = connection.prepareStatement("SHOW SERVER_VERSION;");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String versionString = rs.getString(1);
				try {
					return Version.parseVersion(versionString);	
				} catch (IllegalArgumentException e) {
					// The version cannot be parsed: we extract a part of it from the String.
					
					Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)*");
					Matcher matcher = pattern.matcher(versionString);
					if (matcher.find()) {
						return Version.parseVersion(matcher.group(0));
					}
				}
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		// No version can be found: we return the last one.
		return Version.parseVersion("13.2");
	}
	
	/**
	 * Builds a {@link PreparedStatement} that fetches all the sequences from the provided schema name.
	 * @param schemaName a {@link String}, name of the schema.
	 * @return a {@link PreparedStatement} corresponding to the server's version.
	 */
	public PreparedStatement buildSequenceStatement(String schemaName) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
				"SELECT s.SEQUENCE_NAME, s.INCREMENT, s.MINIMUM_VALUE, s.MAXIMUM_VALUE, s.START_VALUE, s.CYCLE_OPTION , pg_catalog.obj_description(c.oid) " +
				"FROM INFORMATION_SCHEMA.SEQUENCES s " +
				"LEFT JOIN PG_CATALOG.pg_class c " +
				"ON c.relname = s.SEQUENCE_NAME " +
				"AND c.relkind = 'S' " +
				"WHERE s.SEQUENCE_SCHEMA = ?"+
				"ORDER BY s.SEQUENCE_NAME ASC");
			
			statement.setString(1, schemaName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statement;
	}
	
	/**
	 * Builds a {@link PreparedStatement} that fetches the cache value for the given sequence.
	 * @param schemaName a {@link String}, name of the schema.
	 * @param sequenceName a {@link String}, name of the sequence.
	 * @return a {@link PreparedStatement} corresponding to the server's version.
	 */
	public PreparedStatement buildSequenceCacheValueStatement(String schemaName, String sequenceName) {
		PreparedStatement statement = null;
		try {
			if (version.getMajor() <= 9) {
				statement = connection.prepareStatement("SELECT CACHE_VALUE FROM "+schemaName+"."+sequenceName);
				
			} else {
				statement = connection.prepareStatement(
					"SELECT cache_size "
					+ "FROM pg_catalog.pg_sequences " 
					+ "WHERE sequencename = ?");
				
				statement.setString(1, sequenceName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;		
	}
	
	/**
	 * Builds a {@link PreparedStatement} that fetches the constraint related to the columns of the given table.
	 * @param schemaName a {@link String}, name of the schema.
	 * @param tableName a {@link String}, name of the table. 
	 * @return a {@link PreparedStatement} corresponding to the server's version.
	 */
	public PreparedStatement buildColumnConstraintStatement(String schemaName, String tableName) {
		PreparedStatement statement = null;
		
		try {
			if (version.getMajor() >= 12) {
				// source: {@link https://dba.stackexchange.com/questions/36979/retrieving-all-pk-and-fk}
				statement = connection.prepareStatement(
					"SELECT tc.constraint_name, pg_get_constraintdef(oid) " + 
					"FROM pg_constraint pgc " + 
					"LEFT JOIN information_schema.table_constraints tc " + 
					"ON pgc.conname = tc.constraint_name " + 
					"WHERE tc.table_schema = ? " + 
					"AND tc.table_name = ? " + 
					"AND tc.constraint_type = 'CHECK' " + 
					"AND tc.constraint_name NOT LIKE '%_not_null' ");
			} else {
				statement = connection.prepareStatement(
					"SELECT tc.constraint_name, pgc.consrc " +
					"FROM information_schema.table_constraints tc " +
					"LEFT JOIN pg_catalog.pg_constraint pgc " +							
					"ON pgc.conname = tc.constraint_name " +
					"WHERE tc.table_schema = ? and tc.table_name = ? and tc.constraint_type = 'CHECK' and tc.constraint_name not like '%_not_null'");
			}
			statement.setString(1, schemaName);
			statement.setString(2, tableName);		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return statement;
		
	}
}
