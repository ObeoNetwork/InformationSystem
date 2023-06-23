/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public abstract class AbstractDataBaseBuilder implements DataBaseBuilder {
	
	protected Queries queries;
	
	protected NativeTypesLibrary nativeTypesLibrary;
	
	protected ProgressListener progressListener;
	
	protected DatabaseMetaData metaData;
	
	private DataBase dataBase;
	
	private Connection connection;
	
	protected TableContainer tableContainer;
	
	public AbstractDataBaseBuilder(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		initialize(source, progressListener, queries);
	}
	
	public DataBase getDataBase() {
		return dataBase;
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}
	
	private void initialize(DataSource source, ProgressListener progressListener, Queries queries) throws SQLException {
		connection = null;
		try {
			connection = source.getConnection();
		} catch (DataSourceException e) {
			throw new SQLException("Unable to connect to database", e.getCause());
		}
		if (connection != null) {	
			try {
				this.metaData = connection.getMetaData();	
			} catch (SQLException e) {
				JdbcUtils.closeConnection(connection);
				throw e;
			}
		}
		
		this.progressListener = progressListener;
		if (this.progressListener == null) {
			this.progressListener = new ProgressListener() {
				
				@Override
				public void start(int numberOfSteps) {					
				}
				
				@Override
				public void progressTo(int step, String message) {					
				}
				
				@Override
				public void end(String message) {					
				}
			};
		}
		
		this.queries = queries;
		dataBase = buildDataBase(source.getDatabaseName());
		queries.registerDatabase(dataBase);
		tableContainer = dataBase;
		if (isSet(source.getSchemaName())) {
			tableContainer = buildSchema(source.getSchemaName(), (DataBase) tableContainer);
		}
		setUsedLibraries();
	}
	
	protected DataBase buildDataBase(String databaseName) {
		return CreationUtils.createDatabase(databaseName);
	}
	
	protected Schema buildSchema(String schemaName, DataBase parent) {
		Schema schema = CreationUtils.createSchema(schemaName);
		parent.getSchemas().add(schema);
		return schema;
	}
	
	protected void setUsedLibraries() {
		ResourceSet resourceSet = new ResourceSetImpl();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			registerResourceFactoryForTypesLibrary(resourceSet);
			registerUriMapForTypesLibrary();
		}
		String typesURI = getTypesLibraryUriPathmap();
		if (isSet(typesURI)) {
			Resource resource = resourceSet.getResource(URI.createURI(typesURI), true);
			if (resource != null) {
				nativeTypesLibrary = (NativeTypesLibrary) resource.getContents().get(0);
				dataBase.getUsedLibraries().add(nativeTypesLibrary);
			}
		}
	}
	
	protected BigInteger getBigIntValueForColumn(ResultSet rs, int columnId) {
		BigInteger result = null;
		try {
			BigDecimal inc = rs.getBigDecimal(columnId);
			result = inc.toBigInteger();
		} catch (Exception e) {
			// Do nothing.
		}
		return result;
	}
	
	protected abstract String getTypesLibraryUriPathmap();
	
	protected abstract String getTypesLibraryFileName();
	
	private void registerResourceFactoryForTypesLibrary(ResourceSet resourceSet) {
		resourceSet
			.getResourceFactoryRegistry()
			.getExtensionToFactoryMap()
			.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TypesLibraryPackage.eNS_URI, TypesLibraryPackage.eINSTANCE);
	}
	
	private void registerUriMapForTypesLibrary() {
		String typesFileName = getTypesLibraryFileName();
		if (isSet(typesFileName)) {
			String typesURI = getTypesLibraryUriPathmap();
			if (isSet(typesURI)) {
				URL typesUrl = TypesLibraryUtil.class.getClassLoader().getResource(typesFileName);
				URIConverter.URI_MAP.put(URI.createURI(typesURI), URI.createURI(typesUrl.toString()));
			}
		}
	}
	
	protected static boolean isSet(String value) {
		return value != null && value.length() > 0;
	}
	
	@Override
	public void buildTables() {
		progressListener.progressTo(1, "Building all tables");		
	}
	
	@Override
	public void buildForeignKeys() {
		progressListener.progressTo(1, "Building all foreign keys");		
	}

	@Override
	public void post() {
		progressListener.progressTo(1, "Post process the database model.");
	}
	
}
