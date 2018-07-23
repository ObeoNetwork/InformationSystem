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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
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

public class SQLServerDataBaseBuilder extends DefaultDataBaseBuilder {
	
	private static final Pattern VIEW_QUERY_PATTERN = Pattern.compile("create view .* as (.*)");
	
	private static final String TYPES_LIBRARY_SQLSERVER_PATHMAP = "pathmap://NativeDBTypes/SQLServer-2008";
	
	private static final String TYPES_LIBRARY_SQLSERVER_FILENAME = "SQLServer-2008.typeslibrary";
	
	public SQLServerDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		super(source, progressListener, queries);
	}
	
	@Override
	public void buildTables() {
		super.buildTables();
		buildSequences(metaData, tableContainer);
	}
	
	@Override
	protected String getTypesLibraryUriPathmap() {
		return TYPES_LIBRARY_SQLSERVER_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TYPES_LIBRARY_SQLSERVER_FILENAME;
	}
	
	@Override
	protected void buildColumn(DatabaseMetaData metaData, TableContainer owner, NativeTypesLibrary nativeTypesLibrary, AbstractTable table, ResultSet rs) throws SQLException {
		String columnName = rs.getString(4);
		Column column = CreationUtils.createColumn(table, columnName);

		String columnType = rs.getString(6);
				
		int indexIdentity = columnType.indexOf("identity");
		Identity identity = null;
		if (indexIdentity != -1) {
			identity = getIdentity(columnType);
			columnType = columnType.substring(0, indexIdentity).trim();
		}
		
		int columnSize = rs.getInt(7);
		int decimalDigits = rs.getInt(9);
		TypeInstance typeInstance = createTypeInstance(nativeTypesLibrary, columnType, columnSize,
				decimalDigits);
		column.setType(typeInstance);
		
		if (identity != null) {
			//buildSequence(owner, table, column, identity);
			column.setAutoincrement(true);
		}
		
		String defaultValue = rs.getString(13);
		if (defaultValue == null || defaultValue.length() == 0) {
			defaultValue = "";
		}
		column.setDefaultValue(defaultValue.trim());

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
	
	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String query =	"SELECT VIEW_DEFINITION FROM INFORMATION_SCHEMA.VIEWS WHERE TABLE_NAME = ?";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				pstmt.setString(1, viewName);
				rs = pstmt.executeQuery();
				while (rs.next()) {	
					viewQuery =  rs.getString(1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		
		if (viewQuery != null) {
			Matcher matcher = VIEW_QUERY_PATTERN.matcher(viewQuery);
			if (matcher.matches()) {
				// Remove the'create view xxx as ' prefix
				viewQuery = matcher.group(1);
			}
		}
		
		return viewQuery;
	}
	
	private void buildSequences(DatabaseMetaData metaData, TableContainer owner){
		ResultSet rs=null;
        PreparedStatement pstmt=null;
        try {
			String query =	"SELECT			CAST(seq.name AS NVARCHAR(128)), " +
							"				CAST(seq.increment AS NVARCHAR(128)), " +
							"				CAST(seq.minimum_value AS NVARCHAR(128)), " +
							"				CAST(seq.maximum_value AS NVARCHAR(128)), " +
							"				CAST(seq.start_value AS NVARCHAR(128)), " +
							"				CAST(seq.is_cycling AS NVARCHAR(128)), " +
							"				CAST(seq.cache_size AS NVARCHAR(128)) " +
							"FROM			sys.sequences AS seq " +
							"INNER JOIN		sys.schemas AS sch " +
							"ON				seq.schema_id = sch.schema_id " +
							"WHERE			sch.name = ?";
            pstmt = metaData.getConnection().prepareStatement(query);             
            pstmt.setString(1, schemaName);
            rs = pstmt.executeQuery();
            while( rs.next() ) {
            	String name = rs.getString(1);
            	BigInteger increment = getBigIntValueForColumn(rs, 2);
            	
            	BigInteger minValue = getBigIntValueForColumn(rs, 3);
            	BigInteger maxValue = getBigIntValueForColumn(rs, 4);
            	
            	BigInteger start = getBigIntValueForColumn(rs, 5);
            	
            	boolean cycle = rs.getBoolean(6);
            	BigInteger cacheSize  = getBigIntValueForColumn(rs, 7);
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
                ex.printStackTrace();
        } finally {
                JdbcUtils.closeStatement(pstmt);
                JdbcUtils.closeResultSet(rs);
        }

	}
	
	private static Identity getIdentity(String columnType) {
		Identity identity = new Identity();
		int startSeq = columnType.indexOf("(");
		if (startSeq != -1) {
			startSeq += 1;
			int endSeq = columnType.indexOf(")");
			if (startSeq != -1) {
				String[] seq = columnType.substring(startSeq, endSeq).split(",");
				if (seq.length == 2) {
					try {
						identity.start = Integer.parseInt(seq[0]);
					} catch(NumberFormatException e) {
						identity.start = -1;
					}
					identity.increment = Integer.parseInt(seq[1]);
				}
			}
		}
		return identity;
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
		return super.createTypeInstance(nativeTypesLibrary, columnType, columnSize, decimalDigits);
	}
	
	private static class Identity {
		public int start = 1;
		public int increment = 1;
	}

}
