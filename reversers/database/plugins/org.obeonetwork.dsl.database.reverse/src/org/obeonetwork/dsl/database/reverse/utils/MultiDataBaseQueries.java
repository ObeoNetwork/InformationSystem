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
package org.obeonetwork.dsl.database.reverse.utils;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.TableContainer;

public class MultiDataBaseQueries extends Queries {
	
	public AbstractTable getTable(String tableName) {	
		for(DataBase database:dataBases){
			for(Schema schema:database.getSchemas()) {
				AbstractTable table = getTable(schema, tableName);
				if(table!=null){
					return table;
				}
			}
			AbstractTable table = getTable(database, tableName);
			if(table!=null){
				return table;
			}
		}
		return null;
	}
	
	public AbstractTable getTable(TableContainer owner, String tableName) {
		for (AbstractTable table : owner.getTables()) {			
			if (table.getName() != null && table.getName().equals(tableName)) {
				return table;
			}
		}
		return null;
	}
	
	public Column getColumn(TableContainer owner, String tableName, String columnName) {
		AbstractTable table = getTable(owner, tableName);
		if (table != null) {
			return getColumn(table, columnName);
		} else {
			return null;
		}
	}

}
