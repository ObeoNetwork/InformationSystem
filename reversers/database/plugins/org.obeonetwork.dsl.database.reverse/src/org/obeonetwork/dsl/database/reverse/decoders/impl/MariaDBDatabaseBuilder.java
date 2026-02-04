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
import java.sql.ResultSet;
import java.sql.SQLException;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public class MariaDBDatabaseBuilder extends MySQLDataBaseBuilder {
	
	protected String TABLE_ID = "SYSTEM TABLE";
	
	public MariaDBDatabaseBuilder(DataSource source, ProgressListener progressListener, Queries queries)
			throws SQLException {
		super(source, progressListener, queries);
	}
	
	@Override
	protected String getTypesLibraryUriPathmap() {
		return TypesLibraryUtil.MARIADB_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TypesLibraryUtil.MARIADB_FILENAME;
	}
	
	@Override
	protected void buildTable(ProgressListener progressListener, DatabaseMetaData metaData,
			TableContainer owner, NativeTypesLibrary nativeTypesLibrary,
			ResultSet rs) throws SQLException {
		String tableName = rs.getString(3);
		String message = "Discovering table: " + owner.getName() + "."+ tableName;
		progressListener.progressTo(1, message);
		String tableType = rs.getString(4);
		AbstractTable table = null;

		if (!"SYSTEM TABLE".equals(tableType)) {
			if ( "TABLE".equals(tableType)) {
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
	}

}
