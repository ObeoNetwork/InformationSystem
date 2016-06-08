package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.math.BigInteger;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class PostGresDataBaseBuilder extends DefaultDataBaseBuilder {

	private static final String TYPES_LIBRARY_POSTGRES_PATHMAP = "pathmap://NativeDBTypes/Postgres-9";

	private static final String TYPES_LIBRARY_POSTGRES_FILENAME = "Postgres-9.typeslibrary";

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
								"SELECT SEQUENCE_NAME, INCREMENT, MINIMUM_VALUE, MAXIMUM_VALUE, START_VALUE, CYCLE_OPTION "
										+ "FROM INFORMATION_SCHEMA.SEQUENCES WHERE SEQUENCE_SCHEMA = '"
									+ schemaName + "'");
			
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
				
				// Retrieve CACHE value
				Integer cacheValue = null;
				PreparedStatement psmtCache = metaData.getConnection().prepareStatement("SELECT CACHE_VALUE FROM " + schemaName + "." + name);
				ResultSet rsCache = psmtCache.executeQuery();
				if (rsCache.next()) {
					cacheValue = rsCache.getInt(1);
				}
				
				Sequence sequence = CreationUtils.createSequence(owner, name,
						increment, minValue, maxValue, start, cycle, cacheValue);
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

	
	public void setSchemaName(String schemaName) {
		if (schemaName.isEmpty() || schemaName == null) {
			this.schemaName = "public";
		}
	}
	
	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String query =	"select pg_get_viewdef('" + viewName + "', true)";
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
}
