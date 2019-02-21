/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.imports;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_5;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_102;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_11G;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_9;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.obeonetwork.dsl.database.reverse.source.DataSource;

public class DatabaseInfos {

	public static final String PORT_ORACLE_11G = "1521";
	public static final String PORT_MYSQL_5 = "3306";
	public static final String PORT_MARIADB_102 = "3306";
	public static final String PORT_H2_13 = "9092";
	public static final String PORT_POSTGRES_9 = "5432";
	public static final String PORT_SQLSERVER_2008 = "1433";
	
	private String vendor = DB_MYSQL_5;
	private String host = "";
	private String port = PORT_MYSQL_5;
	private String database = "";
	private String schema = "";
	private String user = "";
	private String password = "";
	private String url = "";
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public DatabaseInfos() {
	}
	
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource(getDatabase(), getSchema());

		dataSource.setJdbcUrl(getUrl());
		dataSource.setJdbcUsername(getUser());
		dataSource.setJdbcPassword(getPassword());
		dataSource.setVendor(getVendor());
		return dataSource;
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	public void computeUrl() {
		if (DB_MYSQL_5.equals(vendor)) {
			String newUrl = "jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getDatabase();
			setUrl(newUrl);
		} else if (DB_MARIADB_102.equals(vendor)) {
			String newUrl = "jdbc:mariadb://" + getHost() + ":" + getPort() + "/" + getDatabase();
			setUrl(newUrl);
		} else if (DB_ORACLE_11G.equals(vendor)) {
			String newUrl = "jdbc:oracle:thin:" + getUser() + "/" + getPassword() + "@//" + getHost() + ":" + getPort() + "/" + getDatabase();
			setUrl(newUrl);
		} else if (DB_H2_13.equals(vendor)) {
			String newUrl = "jdbc:h2:" + getDatabase();
			setUrl(newUrl);
		} else if (DB_POSTGRES_9.equals(vendor)) {
			String newUrl = "jdbc:postgresql://" + getHost() + ":" + getPort() + "/" + getDatabase();
			setUrl(newUrl);
		} else if (DB_SQLSERVER_2008.equals(vendor)) {
			String newUrl = "jdbc:sqlserver://" + getHost() + ":" + getPort() + ";databaseName=" + getDatabase();
			setUrl(newUrl);
		}
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		if (this.vendor != null && this.vendor.equals(vendor)) {
			// Value did not change
			return;
		}
		if (DB_MYSQL_5.equals(vendor) && DB_ORACLE_11G.equals(vendor)) {
			// Wrong value
			return;
		}
		if (DB_MYSQL_5.equals(vendor)) {
			setPort(PORT_MYSQL_5);
		} else if (DB_MARIADB_102.equals(vendor)) {
			setPort(PORT_MARIADB_102);
		} else if (DB_ORACLE_11G.equals(vendor)) {
			setPort(PORT_ORACLE_11G);
		} else if (DB_H2_13.equals(vendor)) {
			setPort(PORT_H2_13);
		} else if (DB_POSTGRES_9.equals(vendor)) {
			setPort(PORT_POSTGRES_9);
		} else if (DB_SQLSERVER_2008.equals(vendor)) {
			setPort(PORT_SQLSERVER_2008);
		}
		propertyChangeSupport.firePropertyChange("vendor", this.vendor, this.vendor = vendor);
		computeUrl();
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		if ((this.host == null && host != null)
			|| (this.host != null && !this.host.equals(host))) {
			propertyChangeSupport.firePropertyChange("host", this.host, this.host = host);
			computeUrl();
		}
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		if ((this.port == null && port != null)
				|| (this.port != null && !this.port.equals(port))) {
				propertyChangeSupport.firePropertyChange("port", this.port, this.port = port);
				computeUrl();
		}
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		if ((this.database == null && database != null)
				|| (this.database != null && !this.database.equals(database))) {
				propertyChangeSupport.firePropertyChange("database", this.database, this.database = database);
				computeUrl();
		}
	}
	
	public String getSchema() {
		return schema;
	}
	
	public void setSchema(String schema) {
		if ((this.schema == null && schema != null)
				|| (this.schema != null && !this.schema.equals(schema))) {
				propertyChangeSupport.firePropertyChange("schema", this.schema, this.schema = schema);
				computeUrl();
		}
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		if ((this.user == null && user != null)
				|| (this.user != null && !this.user.equals(user))) {
				propertyChangeSupport.firePropertyChange("user", this.user, this.user = user);
				if (DB_ORACLE_11G.equals(vendor)) {
					computeUrl();
				}
		}
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if ((this.password == null && password != null)
				|| (this.password != null && !this.password.equals(password))) {
				propertyChangeSupport.firePropertyChange("password", this.password, this.password = password);
				if (DB_ORACLE_11G.equals(vendor)) {
					computeUrl();
				}
		}
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		propertyChangeSupport.firePropertyChange("url", this.url, this.url = url);
	}
	
}
