package org.obeonetwork.dsl.database.reverse.source;

public class DataSource {
	
	private String databaseName;
	private String schemaName;
	private String jdbcDriverClassName;
	private String jdbcUrl;
	private String jdbcUsername;
	
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	private String jdbcPassword;
	private String vendor;
	
	public DataSource(String databaseName, String schemaName) {
		super();
		this.databaseName = databaseName;
		this.schemaName = schemaName;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getJdbcDriverClassName() {
		return jdbcDriverClassName;
	}
	public void setJdbcDriverClassName(String jdbcDriverClassName) {
		this.jdbcDriverClassName = jdbcDriverClassName;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getJdbcUsername() {
		return jdbcUsername;
	}
	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	@Override
	public String toString() {		
		return "Infos : "+getDatabaseName()+" - "+getJdbcUrl()+" - "+getSchemaName();
	}
	
	
}
