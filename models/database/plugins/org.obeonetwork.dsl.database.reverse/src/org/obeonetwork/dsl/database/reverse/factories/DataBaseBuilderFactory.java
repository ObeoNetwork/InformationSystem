package org.obeonetwork.dsl.database.reverse.factories;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.reverse.decoders.DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.DefaultDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.MySQLDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.OracleDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;

public class DataBaseBuilderFactory {
	
	private static final String DB_ORACLE_11G = "Oracle-11g";
	private static final String DB_MYSQL_5 = "MySQL-5";
	
	private DataSource dataSource;
	
	public DataBaseBuilderFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataBaseBuilder createDataBaseBuilder(Queries queries, ProgressListener progressListener) throws SQLException {
		if(DB_MYSQL_5.equals(dataSource.getVendor())){
			return new MySQLDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_ORACLE_11G.equals(dataSource.getVendor())){
			return new OracleDataBaseBuilder(dataSource, progressListener, queries);
		}else {
			return new DefaultDataBaseBuilder(dataSource, progressListener, queries);
		}
	}

}
