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

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_24;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_9;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_121;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_21C;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_18;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2025;

public class DataBaseBuilderFactory {
	
	private DataSource dataSource;
	
	public DataBaseBuilderFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataBaseBuilder createDataBaseBuilder(Queries queries, ProgressListener progressListener) throws SQLException {
		if(DB_MYSQL_9.equals(dataSource.getVendor())){
			return new MySQLDataBaseBuilder(dataSource, progressListener, queries);
		} else if (DB_MARIADB_121.equals(dataSource.getVendor())) {
			return new MariaDBDatabaseBuilder(dataSource, progressListener, queries);
		} else if(DB_ORACLE_21C.equals(dataSource.getVendor())){
			return new OracleDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_H2_24.equals(dataSource.getVendor())){
			return new H2DataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_POSTGRES_18.equals(dataSource.getVendor())){
			return new PostGresDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_SQLSERVER_2025.equals(dataSource.getVendor())){
			return new SQLServerDataBaseBuilder(dataSource, progressListener, queries);
		} else {
			return new DefaultDataBaseBuilder(dataSource, progressListener, queries);
		}
	}

}
