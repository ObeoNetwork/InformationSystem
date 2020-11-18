/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;

public class MariaDBDatabaseBuilder extends MySQLDataBaseBuilder {
	
	private static final String TYPES_LIBRARY_MARIADB_PATHMAP = "pathmap://NativeDBTypes/MariaDB-10.2";
	
	private static final String TYPES_LIBRARY_MARIADB_FILENAME = "MariaDB-10.2.typeslibrary";

	public MariaDBDatabaseBuilder(DataSource source, ProgressListener progressListener, Queries queries)
			throws SQLException {
		super(source, progressListener, queries);
	}
	
	@Override
	protected String getTypesLibraryUriPathmap() {
		return TYPES_LIBRARY_MARIADB_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TYPES_LIBRARY_MARIADB_FILENAME;
	}

}
