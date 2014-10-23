package org.obeonetwork.dsl.database.reverse.utils;

import java.util.ArrayList;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.TableContainer;

public class MultiDataBaseQueries extends Queries {
	
	private ArrayList<DataBase> dataBases = new ArrayList<DataBase>();
	
	public void registerDatabase(DataBase dataBase) {
		dataBases.add(dataBase);
	}
	
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
