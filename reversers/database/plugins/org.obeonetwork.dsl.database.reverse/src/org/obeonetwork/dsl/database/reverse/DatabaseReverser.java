/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.decoders.DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.factories.DataBaseBuilderFactory;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;

public class DatabaseReverser {
	
	public static DataBase reverse(DataSource source, Queries queries, ProgressListener progressListener) {
		
		DataBase dataBase = doReverse(source, queries, progressListener);
		if (progressListener != null) {
			progressListener.end("Database built successfully.");
		}
		return dataBase;
	}
	
	private static DataBase doReverse(DataSource source, Queries queries, ProgressListener progressListener) {
				
			DataBaseBuilderFactory factory = new DataBaseBuilderFactory(source);
			DataBaseBuilder builder = null;
			
			try {
				builder = factory.createDataBaseBuilder(queries, progressListener);
					
				builder.buildTables();
				builder.buildForeignKeys();
				builder.post();
				
				return builder.getDataBase(); 
			} catch(SQLException ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
			} finally {
				if (builder != null) {
					JdbcUtils.closeConnection(builder.getConnection());
				}	
			}
			
			return null;
		
	}

}
