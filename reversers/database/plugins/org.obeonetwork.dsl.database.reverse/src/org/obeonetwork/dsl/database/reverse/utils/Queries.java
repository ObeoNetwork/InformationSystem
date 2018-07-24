/*******************************************************************************
 * Copyright (c) 2014, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.utils;

import java.util.ArrayList;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;

public abstract class Queries {
	
	protected ArrayList<DataBase> dataBases = new ArrayList<DataBase>();
	
	public void registerDatabase(DataBase dataBase) {
		dataBases.add(dataBase);
	}
	
	public abstract AbstractTable getTable(String tableName);
	
	public abstract AbstractTable getTable(TableContainer owner, String tableName);
	
	public abstract Column getColumn(TableContainer owner, String tableName, String columnName);
	
	public Column getColumn(AbstractTable abstractTable, String columnName) {
		if (abstractTable instanceof Table) {
			Table table = (Table)abstractTable;
			for (Column column : table.getColumns()) {
				if (column.getName().equals(columnName)) {
					return column;
				}
			}
		}
		return null;
	}
	
	public Boolean isInAscendingOrder(String order) {
		if ("A".equals(order)) {
			return Boolean.TRUE;
		}
		if ("D".equals(order)) {
			return Boolean.FALSE;
		}
		return null;
	}

}
