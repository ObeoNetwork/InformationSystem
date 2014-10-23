package org.obeonetwork.dsl.database.reverse.decoders;

import org.obeonetwork.dsl.database.DataBase;


public interface DataBaseBuilder {
	
	void buildTables();
	
	void buildForeignKeys();
	
	void post();
	
	DataBase getDataBase();
	
}
