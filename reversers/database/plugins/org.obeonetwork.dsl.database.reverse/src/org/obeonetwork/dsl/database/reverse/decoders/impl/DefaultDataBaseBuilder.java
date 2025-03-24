/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.decoders.AbstractDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

public class DefaultDataBaseBuilder extends AbstractDataBaseBuilder {
	
	private final static String MODEL_ID_PREFIX = "modelId[";
	private final static String MODEL_ID_SUFFIX = "]-";
	protected String schemaName = null;

	public DefaultDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		super(source, progressListener, queries);
		this.schemaName = tableContainer.getName();
	}

	@Override
	public void buildTables() {
		ResultSet rs = null;
		try {
			String[] types = { "TABLE", "VIEW" };
			rs = metaData.getTables(null, schemaName, "%", types);
			
			int nbRows=0;
			if(ResultSet.TYPE_FORWARD_ONLY==rs.getType()){				
				while (rs.next()) {
					nbRows++;
				}
				JdbcUtils.closeResultSet(rs);
				rs = metaData.getTables(null, schemaName, "%", types);
			}else{
				rs.last();
				nbRows = rs.getRow();
				rs.beforeFirst();	
			}			
			progressListener.start(nbRows+2);			
			
			while (rs.next()) {
				buildTable(progressListener, metaData, tableContainer, nativeTypesLibrary, rs);
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
	}
	
	protected void buildTable(ProgressListener progressListener, DatabaseMetaData metaData,
			TableContainer owner, NativeTypesLibrary nativeTypesLibrary,
			ResultSet rs) throws SQLException {
		String tableName = rs.getString(3);
		String message = "Discovering table: " + owner.getName() + "."+ tableName;
		progressListener.progressTo(1, message);
		String tableType = rs.getString(4);
		AbstractTable table = null;

		if ("TABLE".equals(tableType)) {
			table = CreationUtils.createTable(owner, tableName);
		} else if ("VIEW".equals(tableType)) {
			table = CreationUtils.createView(owner, tableName);
			((View)table).setQuery(getViewQuery(metaData, tableName));
		}

		String tableComments = getRealComments(getTableComments(metaData, rs,
				owner.getName(), tableName));
		if (tableComments == null || tableComments.length() == 0) {
			table.setComments(null);
		} else {
			table.setComments(tableComments);
		}

		if (table instanceof Table) {
			buildColumns(metaData, owner, nativeTypesLibrary, table);
			Table t = (Table) table;
			buildPrimaryKeys(metaData, t);
			buildIndexes(metaData, t);
		}
	}
	
	protected void buildIndexes(DatabaseMetaData metaData, Table table) {
		Map<Object, Object> indices = new HashMap<Object, Object>();
		ResultSet rs = null;
		try {
			rs = metaData.getIndexInfo(null, schemaName, table.getName(),
					false, false);
			while (rs.next()) {
				int indexType = rs.getInt(7);
				if (indexType != 0) {
					String indexName = rs.getString(6);
					String indexQualifier = rs.getString(5);
					boolean unique = !(rs.getBoolean(4));
					String indexColumnName = rs.getString(9);
					String order = rs.getString(10);
					Boolean inAscendingOrder = queries.isInAscendingOrder(order);
					buildIndexAndColumn(table, indexName, indexQualifier, unique, indexColumnName, inAscendingOrder, indices);
				}
			}
		} catch (Exception ex) {
			// Try with a method specific to the database
			buildIndexesSpecific(metaData, table);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
	}

	protected void buildIndexesSpecific(DatabaseMetaData metaData, Table table) {
		// Do nothing, should be overriden
	}
	
	protected void buildIndexAndColumn(Table table, String indexName, String indexQualifier, boolean unique, String indexColumnName, Boolean inAscendingOrder, Map<Object, Object> indices) {
		Index index = (Index) indices.get(indexName);
		if (index == null) {
			// Create index
			index = CreationUtils.createIndex(table, indexName);
			index.setQualifier(indexQualifier);
			index.setUnique(unique);
			indices.put(indexName, index);
		}
		
		// Create column
		Column indexColumn = queries.getColumn(table, indexColumnName);
		if (indexColumn != null) {
			IndexElement element = CreationUtils.createIndexElement(index);
			element.setColumn(indexColumn);
			if (inAscendingOrder == null) {
				element.setAsc(true);
			} else {
				element.setAsc(inAscendingOrder);
			}
		} else {
			System.err.println("indexColumn not found -> table="
					+ table.getName() + "; indexName=" + indexName
					+ "; indexColumnName=" + indexColumnName
					+ "; indexColumn=" + indexColumn + "; qualifier="
					+ indexQualifier);
		}
	}
	
	protected ResultSet executeQuery(PreparedStatement pstmt) throws SQLException {
		return pstmt.executeQuery();
	}
	
	protected String getColumnComments(DatabaseMetaData metaData, ResultSet rs, String schemaName, String tableName, String columnName) throws SQLException {
		return rs.getString(12);
	}
	
	protected void buildPrimaryKeys(DatabaseMetaData metaData, Table table) {
		PrimaryKey primaryKey = null;
		ResultSet rs = null;
		try {
			rs = metaData.getPrimaryKeys(null, schemaName,
					table.getName());
			while (rs.next()) {
				if (primaryKey == null) {
					String primaryKeyName = rs.getString(6);
					primaryKey = CreationUtils.createPrimaryKey(table,
							primaryKeyName);
				}
				buildPrimaryKey(table, rs, primaryKey);
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
	}
	
	protected void buildPrimaryKey(AbstractTable table, ResultSet rs,
			PrimaryKey primaryKey) throws SQLException {
		
		String columnName = rs.getString(4);
		Column column = queries.getColumn(table, columnName);

		primaryKey.getColumns().add(column);

		column.setPrimaryKey(primaryKey);
	}
	
	protected void buildColumns(DatabaseMetaData metaData, TableContainer owner, NativeTypesLibrary nativeTypesLibrary, AbstractTable table) {
		ResultSet rs = null;
		try {
			rs = metaData.getColumns(null, schemaName, table.getName(), "%");
			while (rs.next()) {
				buildColumn(metaData, owner, nativeTypesLibrary, table, rs);
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
		if (table instanceof Table) {
			buildColumnConstraints(metaData, owner, (Table)table);			
		}
	}
	
	/**
	 * Used to handle specific types, default implementation does nothing
	 */
	protected TypeInstance specificCreateTypeInstance(NativeTypesLibrary nativeTypesLibrary, String columnType, int columnSize, int decimalDigits) {
		return null;
	}
	
	protected void buildColumn(DatabaseMetaData metaData, TableContainer owner, NativeTypesLibrary nativeTypesLibrary, AbstractTable table, ResultSet rs) throws SQLException {
		if (table instanceof View) {
			return;
		}
		
		String columnName = rs.getString(4);
		Column column = CreationUtils.createColumn(table, columnName);
		
		// TODO optimize search
		String columnType = rs.getString(6);
		int columnSize = rs.getInt(7);
		int decimalDigits = rs.getInt(9);
		
		TypeInstance typeInstance = specificCreateTypeInstance(nativeTypesLibrary, columnType, columnSize, decimalDigits);
		
		if (typeInstance == null) {
			typeInstance = createTypeInstance(nativeTypesLibrary, columnType, columnSize,
					decimalDigits);
		}
		column.setType(typeInstance);

		String defaultValue = rs.getString(13);
		if (defaultValue == null || defaultValue.length() == 0) {
			defaultValue = "";
		}
		// Remove the type of the textual value if present
		// Not sure this is specific to Postgres only but it shouldn't impact the other database types
		final Pattern p = Pattern.compile("^('.*')::[^']*$");
		Matcher matcher = p.matcher(defaultValue);
		if(matcher.find()) {
			defaultValue = matcher.group(1);
		}

		column.setDefaultValue(defaultValue.trim());
		if (rs.getMetaData().getColumnCount() >= 23) {
			column.setAutoincrement("YES".equals(rs.getString(23)));
		}

		String columnComments = getRealComments(getColumnComments(metaData, rs, owner.getName(), table.getName(), columnName));
		if (columnComments == null || columnComments.length() == 0) {
			column.setComments(null);
		} else {
			column.setComments(columnComments);
		}

		String isNullableValue = rs.getString(18);
		boolean isNullable = false;
		// Fix Oracle compatibility
		if (isNullableValue.equals("YES")) {
			isNullable = true;
		} else if (isNullableValue.equals("NO")) {
			isNullable = false;
		} else {
			isNullable = rs.getBoolean(18);
		}

		column.setNullable(isNullable);
	}

	protected TypeInstance createTypeInstance(
			NativeTypesLibrary nativeTypesLibrary, String columnType,
			int columnSize, int decimalDigits) {
		return CreationUtils.createTypeInstance(nativeTypesLibrary, columnType, columnSize, decimalDigits);
	}

	protected void buildColumnConstraints(DatabaseMetaData metaData, TableContainer owner, Table table) {

	}

	protected static String getRealComments(String comments) {
		String megaId = getModelId(comments);
		if (comments != null && megaId != null) {
			String megaToken = MODEL_ID_PREFIX + megaId + MODEL_ID_SUFFIX;
			if (comments.contains(megaToken)) {
				int start = comments.indexOf(megaToken);
				String s = comments.substring(0, start);
				s += comments.substring(start + megaToken.length());
				return s;
			}
		}
		return comments;
	}
	
	protected static String getModelId(String comments) {
		if (comments != null && comments.contains(MODEL_ID_PREFIX)) {
			int start = comments.indexOf(MODEL_ID_PREFIX)
					+ MODEL_ID_PREFIX.length();
			String s = comments.substring(start);
			String megaId = s.substring(0, s.indexOf(MODEL_ID_SUFFIX));
			return megaId;
		} else {
			return null;
		}
	}
	
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		return null;
	}
	
	protected String getTableComments(DatabaseMetaData metaData, ResultSet rs, String schemaName, String tableName) throws SQLException {
		return rs.getString(5);
	}

	@Override
	public void buildForeignKeys() {
		ArrayList<AbstractTable> tables = new ArrayList<AbstractTable>();
		tables.addAll(tableContainer.getTables());
		for(AbstractTable table: tables){
			if(table instanceof Table){
				buildForeignKeys((Table) table);
			}
		}
	}
	
	protected void buildForeignKeys(Table table) {
		Map foreignKeys = new HashMap();
		ResultSet rs = null;
		try {
			rs = metaData.getImportedKeys(null, schemaName,
					table.getName());
			while (rs.next()) {
				String pkSchemaName = rs.getString(2);
				String pkTableName = rs.getString(3);
				String fkName = rs.getString(12);
				String pkName = rs.getString(13);
				String foreignKeyId = tableContainer.getName() + "::" + table.getName()
						+ "::" + fkName;
				ForeignKey foreignKey = (ForeignKey) foreignKeys
						.get(foreignKeyId);
				if (foreignKey == null) {
					foreignKey = CreationUtils.createForeignKey(table);
					foreignKey.setName(fkName);
					foreignKeys.put(foreignKeyId, foreignKey);
				}
				int keySeq = rs.getInt(9);
				ForeignKeyElement foreignKeyElement = CreationUtils
						.createForeignKeyElement(keySeq, foreignKey);
				foreignKey.getElements().add(foreignKeyElement);

				String pkColumnName = rs.getString(4);
				Column pkColumn = queries.getColumn(tableContainer,
						pkTableName, pkColumnName);
				if (pkColumn != null) {
					foreignKeyElement.setPkColumn(pkColumn);
				} else {
					AbstractTable pkTable = queries.getTable(pkTableName);
					if (pkTable == null) {
						
						pkTable = CreationUtils.createTable(tableContainer,
								pkTableName);
						pkColumn = CreationUtils.createColumn(pkTable,
								pkColumnName);
					}else{
						pkColumn = queries.getColumn(pkTable, pkColumnName);
					}					
					foreignKeyElement.setPkColumn(pkColumn);
				}

				String fkSchemaName = rs.getString(6);
				String fkTableName = rs.getString(7);				
				String fkColumnName = rs.getString(8);
				Column fkColumn = queries.getColumn(tableContainer,
						fkTableName, fkColumnName);
				foreignKeyElement.setFkColumn(fkColumn);				
				
				//Set target table
				if(foreignKey.getTarget()==null){
					Table targetTable = (Table) pkColumn.getOwner();
					foreignKey.setTarget(targetTable);
				}
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeResultSet(rs);
		}
	}

	@Override
	protected String getTypesLibraryUriPathmap() {
		return null;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return null;
	}
}
