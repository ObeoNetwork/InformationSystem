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
package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.math.BigInteger;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

public class PostGresDataBaseBuilder extends DefaultDataBaseBuilder {

	private static final String TYPES_LIBRARY_POSTGRES_PATHMAP = "pathmap://NativeDBTypes/Postgres-9";

	private static final String TYPES_LIBRARY_POSTGRES_FILENAME = "Postgres-9.typeslibrary";
	
	private HashMap<String, Collection<PostgreSQLConstraint>> cacheConstraints = null;

	public PostGresDataBaseBuilder(DataSource source,
			ProgressListener progressListener, Queries queries)
			throws SQLException {
		super(source, progressListener, queries);
		this.setSchemaName(source.getSchemaName());
	}

	@Override
	protected String getTypesLibraryUriPathmap() {
		return TYPES_LIBRARY_POSTGRES_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TYPES_LIBRARY_POSTGRES_FILENAME;
	}

	@Override
	protected TypeInstance createTypeInstance(
			NativeTypesLibrary nativeTypesLibrary, String columnType,
			int columnSize, int decimalDigits) {
		String bkpColumnType = columnType;
		if (columnSize > 0) {
			columnType += "(%n";
		}
		if (decimalDigits > 0) {
			columnType += ",%p";
		}
		columnType += ")";
		NativeType nativeType = nativeTypesLibrary.findTypeByName(columnType);
		if (nativeType == null) {
			columnType = bkpColumnType;
		}
		return super.createTypeInstance(nativeTypesLibrary, columnType,
				columnSize, decimalDigits);
	}

	@Override
	public void buildTables() {
		super.buildTables();
		buildSequences(tableContainer);
	}

	private void buildSequences(TableContainer owner) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			PreparedStatement psmt = metaData
					.getConnection()
					.prepareStatement(
						"SELECT s.SEQUENCE_NAME, s.INCREMENT, s.MINIMUM_VALUE, s.MAXIMUM_VALUE, s.START_VALUE, s.CYCLE_OPTION , pg_catalog.obj_description(c.oid) " +
						"FROM INFORMATION_SCHEMA.SEQUENCES s " +
						"LEFT JOIN PG_CATALOG.pg_class c " +
						"ON c.relname = s.SEQUENCE_NAME " +
						"AND c.relkind = 'S' " +
						"WHERE s.SEQUENCE_SCHEMA = '"+ schemaName + "'");
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				int increment = rs.getInt(2);
				int minValue = rs.getInt(3);
				BigInteger maxValueAsBigInt = new BigInteger(rs.getString(4));
				BigInteger maxIntValue = new BigInteger(
						Integer.toString(Integer.MAX_VALUE));
				Integer maxValue = null;
				if (maxValueAsBigInt.compareTo(maxIntValue) < 0) {
					maxValue = maxValueAsBigInt.intValue();
				} else {
					maxValue = -1;
				}
				int start = rs.getInt(5);
				String cycleAsString = rs.getString(6);
				boolean cycle = "YES".equals(cycleAsString);
				
				String comment = rs.getString(7);
				
				// Retrieve CACHE value
				Integer cacheValue = null;
				PreparedStatement psmtCache = metaData.getConnection().prepareStatement("SELECT CACHE_VALUE FROM " + schemaName + "." + name);
				ResultSet rsCache = psmtCache.executeQuery();
				if (rsCache.next()) {
					cacheValue = rsCache.getInt(1);
				}
				
				Sequence sequence = CreationUtils.createSequence(owner, name,
						increment, minValue, maxValue, start, cycle, cacheValue);
				sequence.setComments(comment);
				// Look for a table that could correspond to the sequence
				if (name.endsWith("_seq")) {
					String tableName = name.substring(0,
							name.length() - "_seq".length());
					AbstractTable abstractTable = queries.getTable(tableName);
					if (abstractTable != null && abstractTable instanceof Table) {
						Table table = (Table) abstractTable;
						if (table.getPrimaryKey() != null
								&& table.getPrimaryKey().getColumns().size() == 1) {
							Column column = table.getPrimaryKey().getColumns()
									.get(0);
							column.setSequence(sequence);
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}

	}

	@Override
	protected void buildColumnConstraint(DatabaseMetaData metaData,
			TableContainer owner, Column column) {
		Table table = column.getOwner();
		String key = table.getName().toUpperCase();
		
		// we add all constraints for a table at the same time
		if (cacheConstraints == null) {
			cacheConstraints = new HashMap<String, Collection<PostgreSQLConstraint>>();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				PreparedStatement psmt = metaData.getConnection().prepareStatement(
						"SELECT tc.constraint_name, pgc.consrc	, tc.table_name " +
								"FROM information_schema.table_constraints tc " +
								"LEFT JOIN pg_catalog.pg_constraint pgc " + 
								"ON pgc.conname = tc.constraint_name " +
								"WHERE tc.table_schema = ? and tc.constraint_type = 'CHECK' and tc.constraint_name not like '%_not_null'");
				
				psmt.setString(1, schemaName);
				rs = psmt.executeQuery();
				while (rs.next()) {					
					String name = rs.getString(1);
					String expression = rs.getString(2);
					String tableName = rs.getString(3);
					String key2 = tableName.toUpperCase();
					Collection<PostgreSQLConstraint> constraints = cacheConstraints.get(key2);
					if (constraints == null) {
						constraints = new ArrayList<PostgreSQLConstraint>();
					}
					constraints.add(new PostgreSQLConstraint(tableName, name, expression));
					cacheConstraints.put(key2, constraints);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		if (cacheConstraints.containsKey(key)) {
			for (PostgreSQLConstraint pgConstraint : cacheConstraints.get(key)) {
				Constraint constraint = CreationUtils.createConstraint(table, pgConstraint.name);
				constraint.setExpression(pgConstraint.expression);					
			}
			// We remove from the cache or the constraints would be added for every column in the table
			cacheConstraints.remove(key);
		}
	}
	
	public void setSchemaName(String schemaName) {
		if (schemaName.isEmpty() || schemaName == null) {
			this.schemaName = "public";
		}
	}
	
	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String viewFullName = viewName;
			if (schemaName != null && !schemaName.trim().isEmpty()) {
				viewFullName = schemaName + "." + viewName;
			}
			String query =	"select pg_get_viewdef('" + viewFullName + "', true)";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					viewQuery = rs.getString(1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		
		return viewQuery;
	}
	
	private class PostgreSQLConstraint {
		PostgreSQLConstraint(String tableName, String name, String expression) {
			this.tableName = tableName;
			this.name = name;
			this.expression = expression;
		}

		String tableName;
		String name;
		String expression;
	}
}
