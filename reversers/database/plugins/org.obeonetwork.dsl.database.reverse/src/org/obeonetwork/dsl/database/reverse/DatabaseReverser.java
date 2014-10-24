package org.obeonetwork.dsl.database.reverse;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.decoders.DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.factories.DataBaseBuilderFactory;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
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
			
			try {
				DataBaseBuilder builder = factory.createDataBaseBuilder(queries, progressListener);
					
				builder.buildTables();
				builder.buildForeignKeys();
				builder.post();
				
				return builder.getDataBase(); 
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		
	}

}
