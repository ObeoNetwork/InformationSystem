/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.wizards.imports;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER;

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
	
	private String vendor = DB_MYSQL;
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
		switch (vendor == null ? "" : vendor) {
		case DB_MYSQL -> setUrl("jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getDatabase());
		case DB_MARIADB -> setUrl("jdbc:mariadb://" + getHost() + ":" + getPort() + "/" + getDatabase());
		case DB_ORACLE -> setUrl("jdbc:oracle:thin:" + getUser() + "/" + getPassword() + "@//" + getHost() + ":" + getPort() + "/" + getDatabase());
		case DB_H2 -> setUrl("jdbc:h2:" + getDatabase());
		case DB_POSTGRES -> setUrl("jdbc:postgresql://" + getHost() + ":" + getPort() + "/" + getDatabase());
		case DB_SQLSERVER -> setUrl("jdbc:sqlserver://" + getHost() + ":" + getPort() + ";databaseName=" + getDatabase());
		default -> {
			// Keep the current URL when the vendor is unknown or unspecified.
		}
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
		switch (vendor == null ? "" : vendor) {
		case DB_MYSQL -> setPort(PORT_MYSQL_5);
		case DB_MARIADB -> setPort(PORT_MARIADB_102);
		case DB_ORACLE -> setPort(PORT_ORACLE_11G);
		case DB_H2 -> setPort(PORT_H2_13);
		case DB_POSTGRES -> setPort(PORT_POSTGRES_9);
		case DB_SQLSERVER -> setPort(PORT_SQLSERVER_2008);
		default -> {
			// Keep the current port when the vendor is unknown or unspecified.
		}
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
				if (DB_ORACLE.equals(vendor)) {
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
				if (DB_ORACLE.equals(vendor)) {
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
