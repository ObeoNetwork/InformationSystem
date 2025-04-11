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

import java.sql.SQLException;

import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public class MariaDBDatabaseBuilder extends MySQLDataBaseBuilder {
	
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

}
