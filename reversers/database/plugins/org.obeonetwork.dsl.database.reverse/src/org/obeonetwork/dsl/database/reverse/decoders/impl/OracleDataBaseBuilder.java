package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.math.BigInteger;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
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
	private HashMap<String, OracleConstraint> cacheConstraints = null;
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
	protected void buildColumnConstraint(DatabaseMetaData metaData,
			TableContainer owner, Column column) {
		Schema schema = (Schema)owner;
		String key = schema.getName() + column.getOwner().getName() + column.getName();
		if (cacheConstraints == null) {
			cacheConstraints = new HashMap<String, OracleConstraint>();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				PreparedStatement psmt = metaData.getConnection().prepareStatement(
						" SELECT dc.constraint_name, dc.search_condition, dcc.table_name, dcc.column_name " 
								+ " FROM all_constraints dc, all_cons_columns dcc " + " where dc.owner=?"
								+ " AND dcc.owner=?" + " AND constraint_type='C'" + " AND substr(dc.constraint_name,1,3) <> 'SYS'" + " AND dc.owner=dcc.owner"
								+ " AND dc.constraint_name=dcc.constraint_name" + " ORDER BY dc.constraint_name");
				psmt.setString(1, schema.getName());
				psmt.setString(2, schema.getName());
				rs = psmt.executeQuery();
				while (rs.next()) {					
					String name = rs.getString(1);
					//do not reference recyclebin internal name
					if(name.startsWith("BIN$")){
						name="";
					}
					String expression = rs.getString(2);
					String tableName = rs.getString(3);
					String columnName = rs.getString(4);
					if(!expression.endsWith("IS NOT NULL")){
						OracleConstraint oracleConstraint = new OracleConstraint(tableName, name, expression);
						cacheConstraints.put(schema.getName() + tableName + columnName, oracleConstraint);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		if (cacheConstraints.containsKey(key)) {
			OracleConstraint oracleConstraint = cacheConstraints.get(key);
			AbstractTable table = queries.getTable(owner, oracleConstraint.tableName);
			Constraint constraint = CreationUtils.createConstraint((Table)table, oracleConstraint.name);
			constraint.setExpression(oracleConstraint.expression);	
		}
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
	
	@Override
	protected Boolean isInAscendingOrder(DatabaseMetaData metaData, String order, Table table, Index index, String indexColumnName) {
		Boolean asc =  super.isInAscendingOrder(metaData, order, table, index, indexColumnName);
		if (asc == null) {
			String query =	"SELECT descend" + 
							" FROM user_ind_columns" +   
							" WHERE table_name = ? AND index_name = ? AND column_name = ?";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				pstmt.setString(1, table.getName());
				pstmt.setString(2, index.getName());
				pstmt.setString(3, indexColumnName);
				rs = pstmt.executeQuery();
				while (rs.next()) {					
					String ord = rs.getString(1);
					if ("ASC".equals(ord)) {
						return Boolean.TRUE;
					} else if ("DESC".equals(ord)) {
						return Boolean.FALSE;
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		return asc;
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
				rs = pstmt.executeQuery();
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
				ex.printStackTrace();
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
        		// TODO : get Cycle flag with CYCLE_FLAG column
        		// TODO get cache value
                PreparedStatement psmt = metaData.getConnection().prepareStatement(
                                "SELECT SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE, LAST_NUMBER, CYCLE_FLAG, CACHE_SIZE " +
                                "FROM user_sequences");                
                rs = psmt.executeQuery();
                while( rs.next() ) {
                	String name = rs.getString(1);
                	int increment = rs.getInt(2);
                	int minValue = rs.getInt(3);
                	BigInteger maxValueAsBigInt = new BigInteger(rs.getString(4));
                	BigInteger maxIntValue = new BigInteger(Integer.toString(Integer.MAX_VALUE));
                	Integer maxValue = null;
                	if (maxValueAsBigInt.compareTo(maxIntValue) < 0) {                		
                		maxValue = maxValueAsBigInt.intValue();
                	}
                	int start = rs.getInt(5);
                	String cycleAsString = rs.getString(6);
                	boolean cycle = "Y".equals(cycleAsString);
                	Integer cacheSize  = rs.getInt(7);
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
	
	private String getCommentsOnTable(DatabaseMetaData metaData, String tableName) {
		if (cacheTableComments == null) {
			cacheTableComments = new HashMap<String, String>();

			// Retrieve comments using a query
			String query = "select TABLE_NAME, COMMENTS from USER_TAB_COMMENTS";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {					
					String table = rs.getString(1);
					String comments = rs.getString(2);
					if (table != null) {
						cacheTableComments.put(table, comments);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		return cacheTableComments.get(tableName);
	}
	
	private class OracleConstraint {
		OracleConstraint(String tableName, String name, String expression) {
			this.tableName = tableName;
			this.name = name;
			this.expression = expression;
		}

		String tableName;
		String name;
		String expression;
	}

}
