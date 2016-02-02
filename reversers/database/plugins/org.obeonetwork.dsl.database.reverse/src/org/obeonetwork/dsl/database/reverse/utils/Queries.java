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
	
	public static Column getColumn(AbstractTable abstractTable, String columnName) {
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
	
	public static Boolean isInAscendingOrder(String order) {
		if ("A".equals(order)) {
			return Boolean.TRUE;
		}
		if ("D".equals(order)) {
			return Boolean.FALSE;
		}
		return null;
	}

}
