/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import java.util.HashSet;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;

public class MySQLDataBaseBuilder extends DefaultDataBaseBuilder {
	
	private static final String TYPES_LIBRARY_MYSQL_PATHMAP = "pathmap://NativeDBTypes/MySQL-5";
	
	private static final String TYPES_LIBRARY_MYSQL_FILENAME = "MySQL-5.typeslibrary";
	
	public MySQLDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		super(source, progressListener, queries);
	}
	
	@Override
	public void post() {
		removeIndexForFK(tableContainer);
	}
		
	@Override
	protected String getTypesLibraryUriPathmap() {
		return TYPES_LIBRARY_MYSQL_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TYPES_LIBRARY_MYSQL_FILENAME;
	}
	
	@Override
	protected String getTableComments(DatabaseMetaData metaData, ResultSet rs,
			String schemaName, String tableName) throws SQLException {
		String comments = super.getTableComments(metaData, rs, schemaName, tableName);
		if (comments == null || comments.length() == 0) {
			comments = getCommentsOnTable(metaData, tableName);
		}
		return comments;
	}
	
	private String getCommentsOnTable(DatabaseMetaData metaData, String tableName) {
		String query = "SHOW TABLE STATUS LIKE ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = metaData.getConnection().prepareStatement(query);
			pstmt.setString(1, tableName);
			rs = executeQuery(pstmt);
			while (rs.next()) {					
				return rs.getString("Comment");
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}
		return null;
	}
	
	private void removeIndexForFK(TableContainer owner) {
		HashSet<String> fkNames = new HashSet<String>();
		for (AbstractTable table : owner.getTables()) {
			if (table instanceof Table) {
				for (ForeignKey foreignKey : ((Table) table).getForeignKeys()) {
					fkNames.add(foreignKey.getName());
				}
			}
		}
		for (AbstractTable t : owner.getTables()) {
			if (t instanceof Table) {
				Table table = (Table) t;
				ArrayList<Index> indices = new ArrayList<Index>();
				if (table.getIndexes().size() > 0) {
					for (Index index : table.getIndexes()) {
						if (!fkNames.contains(index.getName())) {
							indices.add(index);
						}else{							
							for(IndexElement indexElt : index.getElements()){
								indexElt.getColumn().getIndexElements().remove(indexElt);
							}
						}
					}
					table.getIndexes().clear();
					table.getIndexes().addAll(indices);
				}
			}
		}
	}

	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String showView = null;
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String query =	"SHOW CREATE VIEW " + viewName ;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = executeQuery(pstmt);
				while (rs.next()) {					
					showView = rs.getString(2);
				}
			} catch (Exception ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		
		if (showView != null) {
			String marker = "`" + viewName + "` AS ";
			int indexOf = showView.indexOf(marker);
			if (indexOf > -1) {
				viewQuery = showView.substring(indexOf + marker.length());
			}
		}
		
		return viewQuery;
	}
}
