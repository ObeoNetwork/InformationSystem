package org.obeonetwork.dsl.database.reverse.factories;

import java.sql.SQLException;

import org.obeonetwork.dsl.database.reverse.decoders.DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.DefaultDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.H2DataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.MySQLDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.OracleDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.PostGresDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.decoders.impl.SQLServerDataBaseBuilder;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import static org.obeonetwork.dsl.database.reverse.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.reverse.DatabaseConstants.DB_MYSQL_5;
import static org.obeonetwork.dsl.database.reverse.DatabaseConstants.DB_ORACLE_11G;
import static org.obeonetwork.dsl.database.reverse.DatabaseConstants.DB_POSTGRES_9;
import static org.obeonetwork.dsl.database.reverse.DatabaseConstants.DB_SQLSERVER_2008;

public class DataBaseBuilderFactory {
	
	private DataSource dataSource;
	
	public DataBaseBuilderFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataBaseBuilder createDataBaseBuilder(Queries queries, ProgressListener progressListener) throws SQLException {
		if(DB_MYSQL_5.equals(dataSource.getVendor())){
			return new MySQLDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_ORACLE_11G.equals(dataSource.getVendor())){
			return new OracleDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_H2_13.equals(dataSource.getVendor())){
			return new H2DataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_POSTGRES_9.equals(dataSource.getVendor())){
			return new PostGresDataBaseBuilder(dataSource, progressListener, queries);
		} else if(DB_SQLSERVER_2008.equals(dataSource.getVendor())){
			return new SQLServerDataBaseBuilder(dataSource, progressListener, queries);
		} else {
			return new DefaultDataBaseBuilder(dataSource, progressListener, queries);
		}
	}

}
