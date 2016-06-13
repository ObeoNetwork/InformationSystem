package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
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
	
	private static final String TYPES_LIBRARY_SQLSERVER_PATHMAP = "pathmap://NativeDBTypes/SQLServer-2008";
	
	private static final String TYPES_LIBRARY_SQLSERVER_FILENAME = "SQLServer-2008.typeslibrary";
	
	public SQLServerDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		super(source, progressListener, queries);
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

		buildColumnConstraint(metaData, owner, column);
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
		return viewQuery;
	}

//	private void buildSequence(TableContainer owner, AbstractTable table, Column column, Identity identity) {		
//		Sequence sequence = CreationUtils.createSequence(owner, table.getName() + "_seq", identity.increment, 0, Integer.MAX_VALUE, identity.start);		
//    	column.setSequence(sequence);
//	}
	
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
