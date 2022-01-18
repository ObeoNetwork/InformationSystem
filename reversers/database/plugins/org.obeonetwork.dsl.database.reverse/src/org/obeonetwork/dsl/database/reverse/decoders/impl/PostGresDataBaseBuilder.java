/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.osgi.framework.Version;

public class PostGresDataBaseBuilder extends DefaultDataBaseBuilder {

	private static final String TYPES_LIBRARY_POSTGRES_PATHMAP = "pathmap://NativeDBTypes/Postgres-9";

	private static final String TYPES_LIBRARY_POSTGRES_FILENAME = "Postgres-9.typeslibrary";
	
	private Version version;

	private PostGresStatementBuilder builder;
	
	public PostGresDataBaseBuilder(DataSource source,
			ProgressListener progressListener, Queries queries)
			throws SQLException {
		super(source, progressListener, queries);
		this.setSchemaName(source.getSchemaName());
		builder = new PostGresStatementBuilder(metaData.getConnection());
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
			pstmt = builder.buildSequenceStatement(schemaName);
					
			rs = executeQuery(pstmt);
			while (rs.next()) {
				String name = rs.getString(1);
				BigInteger increment = getBigIntValueForColumn(rs, 2);
				BigInteger minValue = getBigIntValueForColumn(rs, 3);
				BigInteger maxValue = getBigIntValueForColumn(rs, 4); 
				BigInteger start = getBigIntValueForColumn(rs, 5);
				String cycleAsString = rs.getString(6);
				boolean cycle = "YES".equals(cycleAsString);
				
				String comment = rs.getString(7);
				
				// Retrieve CACHE value
				BigInteger cacheValue = null;
				PreparedStatement pstmtCache = builder.buildSequenceCacheValueStatement(schemaName, name);
							
				ResultSet rsCache = executeQuery(pstmtCache);
				if (rsCache.next()) {
					cacheValue = getBigIntValueForColumn(rsCache, 1);
				}
				JdbcUtils.closeStatement(pstmtCache);
				JdbcUtils.closeResultSet(rsCache);
				
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
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}

	}
	
	@Override
	protected void buildColumnConstraints(DatabaseMetaData metaData, TableContainer owner, Table table) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			pstmt = builder.buildColumnConstraintStatement(schemaName, table.getName());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {					
				String name = rs.getString(1);
				String expression = rs.getString(2);

				Constraint constraint = CreationUtils.createConstraint(table, name);
				constraint.setExpression(expression);
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
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
				rs = executeQuery(pstmt);
				while (rs.next()) {
					viewQuery = rs.getString(1);
				}
			} catch (Exception ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
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
