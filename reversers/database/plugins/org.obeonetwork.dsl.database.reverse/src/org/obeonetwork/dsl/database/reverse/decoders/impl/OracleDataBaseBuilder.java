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

import java.math.BigInteger;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

public class OracleDataBaseBuilder extends DefaultDataBaseBuilder {

	private static final String TYPES_LIBRARY_ORACLE_PATHMAP = "pathmap://NativeDBTypes/Oracle-11g";
	
	private static final String TYPES_LIBRARY_ORACLE_FILENAME = "Oracle-11g.typeslibrary";
	
	private Map<String, String> cacheColumnComments = null;
	private Map<String, String> cacheTableComments = null;
	
	public OracleDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		super(source, progressListener, queries);
	}

	@Override
	public void buildTables() {
		super.buildTables();
		buildSequences(metaData, tableContainer);
	}
	
	@Override
	protected String getTypesLibraryUriPathmap() {
		return TYPES_LIBRARY_ORACLE_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TYPES_LIBRARY_ORACLE_FILENAME;
	}
	
	@Override
	protected TypeInstance createTypeInstance(
			NativeTypesLibrary nativeTypesLibrary, String columnType,
			int columnSize, int decimalDigits) {
		TypeInstance typeInstance = super.createTypeInstance(nativeTypesLibrary, columnType, columnSize,
				decimalDigits);
		if ("NUMBER".equals(columnType) && columnSize == 0 && decimalDigits == -127) {
			typeInstance.setLength(38);
			typeInstance.setPrecision(0);
		}
		return typeInstance;
	}
	
	@Override
	protected void buildPrimaryKeys(DatabaseMetaData metaData, Table table) {
		PrimaryKey primaryKey = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = metaData.getConnection().prepareStatement(
					" SELECT cons.constraint_name, cols.column_name, cols.position "
							+ " FROM all_constraints cons, all_cons_columns cols "
							+ " WHERE cons.owner=? "
							+ " AND cons.table_name=? "
							+ " AND cons.constraint_type = 'P' "
							+ " AND cols.constraint_name = cons.constraint_name "
							+ " AND cols.owner = cons.owner "
							+ " AND cols.table_name = cons.table_name "
							+ " ORDER BY cols.position ");
			pstmt.setString(1, table.getOwner().getName().toUpperCase());
			pstmt.setString(2, table.getName().toUpperCase());
			rs = executeQuery(pstmt);
			while (rs.next()) {
				if (primaryKey == null) {
					String primaryKeyName = rs.getString(1);
					primaryKey = CreationUtils.createPrimaryKey(table, primaryKeyName);
				}
				
				if (primaryKey != null) {
					String columnName = rs.getString(2);
					Column column = queries.getColumn(table, columnName);
					primaryKey.getColumns().add(column);
					column.setPrimaryKey(primaryKey);
				}
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}
		// Fall through in case the specific code failed to retrieve PK
		if (primaryKey == null) {
			super.buildPrimaryKeys(metaData, table);			
		}
	}
	
	@Override
	protected void buildColumnConstraints(DatabaseMetaData metaData, TableContainer owner, Table table) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = metaData.getConnection().prepareStatement(
					" SELECT constraint_name, search_condition" 
							+ " FROM all_constraints"
							+ " where owner=?"
							+ " AND table_name=?"
							+ " AND constraint_type='C'"
							+ " AND substr(constraint_name,1,3) <> 'SYS'");
			pstmt.setString(1, owner.getName().toUpperCase());
			pstmt.setString(2, table.getName().toUpperCase());
			rs = executeQuery(pstmt);
			while (rs.next()) {					
				String name = rs.getString(1);
				//do not reference recyclebin internal name
				if(name.startsWith("BIN$")){
					name="";
				}
				String expression = rs.getString(2);
				if(!expression.endsWith("IS NOT NULL")){
					Constraint constraint = CreationUtils.createConstraint(table, name);
					constraint.setExpression(expression);
				}
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}
	}

	private static final Pattern TIMESTAMP_PTN = Pattern.compile("^TIMESTAMP\\([0-9]*\\)$");
	private static final Pattern INTERVAL_DAY_TO_SECOND_PTN = Pattern.compile("^INTERVAL DAY\\([0-9]*\\) TO SECOND\\([0-9]*\\)$");
	private static final Pattern INTERVAL_YEAR_TO_MONTH_PTN = Pattern.compile("^INTERVAL YEAR\\([0-9]*\\) TO MONTH$");
	private static final Pattern TIMESTAMP_WITH_LOCAL_TZ_PTN = Pattern.compile("^TIMESTAMP\\([0-9]*\\) WITH LOCAL TIME ZONE$");
	private static final Pattern TIMESTAMP_WITH_TZ_PTN = Pattern.compile("^TIMESTAMP\\([0-9]*\\) WITH TIME ZONE$");
	
	@Override
	protected TypeInstance specificCreateTypeInstance(NativeTypesLibrary nativeTypesLibrary, String columnType, int columnSize, int decimalDigits) {
		// Handle Oracle specific types

		// TIMESTAMP
		if (TIMESTAMP_PTN.matcher(columnType).matches()) {
			return createTypeInstance(nativeTypesLibrary, "TIMESTAMP", decimalDigits, 0);
		}
		
		// INTERVAL DAY TO SECOND
		if (INTERVAL_DAY_TO_SECOND_PTN.matcher(columnType).matches()) {
			return createTypeInstance(nativeTypesLibrary, "INTERVAL DAY(%n) TO SECOND", columnSize, decimalDigits);
		}
		
		// INTERVAL YEAR TO MONTH
		if (INTERVAL_YEAR_TO_MONTH_PTN.matcher(columnType).matches()) {
			return createTypeInstance(nativeTypesLibrary, "INTERVAL YEAR(%n) TO MONTH", columnSize, decimalDigits);
		}
		
		// TIMESTAMP WITH LOCAL TIME ZONE
		if (TIMESTAMP_WITH_LOCAL_TZ_PTN.matcher(columnType).matches()) {
			return createTypeInstance(nativeTypesLibrary, "TIMESTAMP(%n) WITH LOCAL TIME ZONE", decimalDigits, decimalDigits);
		}		
		
		// TIMESTAMP WITH TIME ZONE
		if (TIMESTAMP_WITH_TZ_PTN.matcher(columnType).matches()) {
			return createTypeInstance(nativeTypesLibrary, "TIMESTAMP(%n) WITH TIME ZONE", decimalDigits, decimalDigits);
		}
		
		return null;
	}
	
	@Override
	protected String getColumnComments(DatabaseMetaData metaData, ResultSet rs,
			String schemaName, String tableName, String columnName)
			throws SQLException {
		String comments =  super.getColumnComments(metaData, rs, schemaName, tableName, columnName);
		if (comments == null) {
			comments = getCommentsOnColumn(metaData, tableName, columnName);
		}
		return comments;
	}
	
	@Override
	protected String getTableComments(DatabaseMetaData metaData, ResultSet rs,
			String schemaName, String tableName) throws SQLException {
		String comments = super.getTableComments(metaData, rs, schemaName, tableName);
		if (comments == null) {
			comments = getCommentsOnTable(metaData, tableName);
		}
		return comments;
	}
	
	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String query =	"SELECT text" + 
					" FROM all_views" +   
					" WHERE view_name = ?";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				pstmt.setString(1, viewName);
				rs = executeQuery(pstmt);
				while (rs.next()) {					
					viewQuery =  rs.getString(1);
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
	
	private String getCommentsOnColumn(DatabaseMetaData metaData, String tableName, String columnName) {
		if (cacheColumnComments == null) {
			cacheColumnComments = new HashMap<String, String>();

			// Retrieve comments using a query
			String query = "select TABLE_NAME, COLUMN_NAME, COMMENTS from USER_COL_COMMENTS";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = executeQuery(pstmt);
				while (rs.next()) {					
					String table = rs.getString(1);
					String column = rs.getString(2);
					String comments = rs.getString(3);
					if (table != null || column != null) {
						String key = table + "::" + column;
						cacheColumnComments.put(key, comments);
					}
				}
			} catch (Exception ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		return cacheColumnComments.get(tableName + "::" + columnName);
	}
	
	private void buildSequences(DatabaseMetaData metaData, TableContainer owner){
		ResultSet rs=null;
        PreparedStatement pstmt=null;
        try {
                PreparedStatement psmt = metaData.getConnection().prepareStatement(
                                "SELECT SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE, LAST_NUMBER, CYCLE_FLAG, CACHE_SIZE " +
                                "FROM user_sequences");                
                rs = psmt.executeQuery();
                while( rs.next() ) {
                	String name = rs.getString(1);
                	BigInteger increment = getBigIntValueForColumn(rs, 2);
                	BigInteger minValue = getBigIntValueForColumn(rs, 3);
                	BigInteger maxValue = getBigIntValueForColumn(rs, 4);
                	BigInteger start = getBigIntValueForColumn(rs, 5);
                	String cycleAsString = rs.getString(6);
                	boolean cycle = "Y".equals(cycleAsString);
                	BigInteger cacheSize = getBigIntValueForColumn(rs, 7);
                	Sequence sequence = CreationUtils.createSequence(owner, name, increment, minValue, maxValue, start, cycle, cacheSize);
                	// Look for a table that could correspond to the sequence
                	if (name.endsWith("_SEQ")) {
                		String tableName = name.substring(0, name.length() - "_SEQ".length());
                		AbstractTable abstractTable = queries.getTable(tableName);
                		if (abstractTable != null && abstractTable instanceof Table) {
                			Table table = (Table)abstractTable;
                			if (table.getPrimaryKey() != null && table.getPrimaryKey().getColumns().size() == 1) {
                				Column column = table.getPrimaryKey().getColumns().get(0);
                				column.setSequence(sequence);
                			}
                		}
                	}
                }
        } catch(Exception ex) {
                DatabaseReverserPlugin.logError("Error while importing database", ex);
        } finally {
                JdbcUtils.closeStatement(pstmt);
                JdbcUtils.closeResultSet(rs);
        }

	}
	
	private String getCommentsOnTable(DatabaseMetaData metaData, String tableName) {
		if (cacheTableComments == null) {
			cacheTableComments = new HashMap<String, String>();

			// Retrieve comments using a query
			String query = "select TABLE_NAME, COMMENTS from USER_TAB_COMMENTS";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = executeQuery(pstmt);
				while (rs.next()) {					
					String table = rs.getString(1);
					String comments = rs.getString(2);
					if (table != null) {
						cacheTableComments.put(table, comments);
					}
				}
			} catch (Exception ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		return cacheTableComments.get(tableName);
	}
	
	@Override
	protected void buildIndexesSpecific(DatabaseMetaData metaData, Table table) {
		Map<Object, Object> indices = new HashMap<Object, Object>();
		ResultSet rs = null;
		try {
			rs = getIndexesFromOracleSysTables(schemaName, table);
			while (rs.next()) {
				String indexTypeAsString = rs.getString(2);
				if (indexTypeAsString.equals("NORMAL")) {
					String indexName = rs.getString(1);
					boolean unique = isOracleIndexUnique(rs.getString(3));
					String indexColumnName = rs.getString(4);
					String order = rs.getString(5);
					Boolean inAscendingOrder = isOracleIndexInAscendingOrder(order);
					buildIndexAndColumn(table, indexName, null, unique, indexColumnName, inAscendingOrder, indices);
				}
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logWarning("Error while retrieving index information from Oracle", ex);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
	}
	
	private boolean isOracleIndexUnique(String uniqueString) {
		if ("UNIQUE".equals(uniqueString)) {
			return true;
		} else if ("NONUNIQUE".equals(uniqueString)) {
			return false;
		} return false;
	}
	
	private boolean isOracleIndexInAscendingOrder(String order) {
		if ("ASC".equals(order)) {
			return true;
		} else if ("DESC".equals(order)) {
			return false;
		}
		return true;
	}

	protected ResultSet getIndexesFromOracleSysTables(String schemaName, Table table) {
		ResultSet result = null;
		String query = 	"select i.index_name, i.index_type, i.uniqueness, " +
						" c.column_name, c.descend " +
						" from all_indexes i, all_ind_columns c " +
						" where i.table_owner = ? " +
						" and i.table_name = ? " +
						" and c.table_owner = i.table_owner " +
						" and c.table_name = i.table_name " + 
						" and c.index_name = i.index_name";
		PreparedStatement stmt = null;
		try {
			stmt = metaData.getConnection().prepareStatement(query);
			stmt.setString(1, schemaName);
			stmt.setString(2, table.getName());
			result = executeQuery(stmt);
		} catch (SQLException e) {
			// Do nothing, exception will be handled in calling code
		}
		return result;
	}
}
