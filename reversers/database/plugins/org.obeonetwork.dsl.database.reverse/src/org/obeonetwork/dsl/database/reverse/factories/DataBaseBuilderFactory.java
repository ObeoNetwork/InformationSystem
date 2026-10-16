/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.factories;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.reverse.decoders.DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.DefaultDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.H2DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.MariaDBDatabaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.MySQLDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.OracleDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.PostGresDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.SQLServerDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER;

public class DataBaseBuilderFactory {
	
	private DataSource dataSource;
	
	public DataBaseBuilderFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataBaseBuilder createDataBaseBuilder(Queries queries, ProgressListener progressListener) throws SQLException {
		String vendor = dataSource.getVendor();
		return switch (vendor == null ? "" : vendor) {
		case DB_MYSQL -> new MySQLDataBaseBuilder(dataSource, progressListener, queries);
		case DB_MARIADB -> new MariaDBDatabaseBuilder(dataSource, progressListener, queries);
		case DB_ORACLE -> new OracleDataBaseBuilder(dataSource, progressListener, queries);
		case DB_H2 -> new H2DataBaseBuilder(dataSource, progressListener, queries);
		case DB_POSTGRES -> new PostGresDataBaseBuilder(dataSource, progressListener, queries);
		case DB_SQLSERVER -> new SQLServerDataBaseBuilder(dataSource, progressListener, queries);
		default -> new DefaultDataBaseBuilder(dataSource, progressListener, queries);
		};
	}

}
