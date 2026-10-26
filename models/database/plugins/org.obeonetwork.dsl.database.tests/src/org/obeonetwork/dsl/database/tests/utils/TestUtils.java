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
package org.obeonetwork.dsl.database.tests.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryResourceFactoryImpl;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.OSGiResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;

public final class TestUtils {
	
	private TestUtils() {
	}
	
	public static void executeStatement(DataSource dataSource, String request) throws SQLException, DataSourceException{
		try (Connection connection = dataSource.getConnection()) {
			try (Statement statement = connection.createStatement()) {
				statement.execute(request);
			}
		}
	}
	
	/**
	 * Open a database connection using the url and the database credentials.
	 * We suppose the database already exists or the given url uses the parameter to create the database if it does not exist.
	 * 
	 * @param url The url used to open the connection to the database
	 * @param username The username
	 * @param password The password
	 * @return The created connection
	 * @throws DatabaseException In case of error
	 */
	public static Database openDatabaseConnection(String url, String username, String password) throws DatabaseException {
		return DatabaseFactory.getInstance().openDatabase(url, username, password, null, new OSGiResourceAccessor(DatabaseReverserPlugin.getDefault().getBundle()));
	}
	
	/**
	 * Open a database connection using the url, the database credentials and the qualified name of the driver.
	 * We suppose the database already exists or the given url uses the parameter to create the database if it does not exist.
	 * 
	 * @param url The url used to open the connection to the database
	 * @param username The username
	 * @param password The password
	 * @param driver The qualified name of the driver to use
	 * @return The created connection
	 * @throws DatabaseException In case of error
	 */
	public static Database openDatabaseConnectionWithDriver(String url, String username, String password, String driver) throws DatabaseException {
		return DatabaseFactory.getInstance().openDatabase(url, username, password, driver, null, null, null, new OSGiResourceAccessor(DatabaseReverserPlugin.getDefault().getBundle()));
	}
	
	/**
	 * Creates a {@link Liquibase} object from a changelog file path. Then apply
	 * changesets contained in the changelog to the given database.
	 * 
	 * @param changelogFilePath The changelog file path
	 * @param database          The database to apply changesets
	 * @return The created {@link Liquibase} object
	 * @throws LiquibaseException in case of error
	 */
	public static Liquibase createAndInitializeLiquibase(String changelogFilePath, Database database) throws LiquibaseException {
		FileSystemResourceAccessor resourceAccessor = new FileSystemResourceAccessor(".");
		Liquibase liquibase = new Liquibase(changelogFilePath, resourceAccessor, database);
		liquibase.dropAll();
		liquibase.update("");
		return liquibase;
	}
	
	public static DataBase loadModel(String databaseTestPluginRelativePath, String typesLibraryPathmapUri) {
		URI uri = URI.createFileURI(databaseTestPluginRelativePath);

		DatabaseResourceFactoryImpl databaseResourceFactory = new DatabaseResourceFactoryImpl();
		Resource resourceDatabase = databaseResourceFactory.createResource(uri);
		
		TypesLibraryResourceFactoryImpl typesLibraryresourceFactory = new TypesLibraryResourceFactoryImpl();
		Resource typeResource = typesLibraryresourceFactory.createResource(URI.createURI(typesLibraryPathmapUri));
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(resourceDatabase);
		rs.getResources().add(typeResource);

		try {
			
			Map<Object, Object> options = rs.getLoadOptions();
			options.put(DatabasePackage.eINSTANCE.getNsURI(), DatabasePackage.eINSTANCE);
			options.put(TypesLibraryPackage.eINSTANCE.getNsURI(), TypesLibraryPackage.eINSTANCE);
			
			resourceDatabase.load(options);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return (DataBase) resourceDatabase.getContents().get(0);
	}
	
	public static void saveModel(org.obeonetwork.dsl.database.DataBase model, String databaseTestPluginRelativePath) {
		URI uri = URI.createFileURI(databaseTestPluginRelativePath);

		DatabaseResourceFactoryImpl databaseResourceFactory = new DatabaseResourceFactoryImpl();
		Resource resourceDatabase = databaseResourceFactory.createResource(uri);
		resourceDatabase.getContents().add(model);
		
		ResourceSet rs = new ResourceSetImpl();
		
		rs.getResources().add(resourceDatabase);
		
		try {
			
			Map<Object, Object> options = rs.getLoadOptions();
			options.put(DatabasePackage.eINSTANCE.getNsURI(), DatabasePackage.eINSTANCE);
			options.put(TypesLibraryPackage.eINSTANCE.getNsURI(), TypesLibraryPackage.eINSTANCE);
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			
			resourceDatabase.save(options);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/** Creates a native UUID table and checks its model through the real JDBC reverser. */
	public static void checkUuidReverse(DataSource dataSource, String nativeTypeName, String typesLibraryPathmap) throws SQLException, DataSourceException {
		String tableName = "uuid_reverse_test";
		executeStatement(dataSource, "CREATE TABLE " + tableName + " (id " + nativeTypeName
				+ " NOT NULL, optional_uuid " + nativeTypeName + " NULL)");
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		assertNotNull("Reverse must produce a database model", database);

		Table uuidTable = null;
		TreeIterator<EObject> contents = database.eAllContents();
		while (contents.hasNext()) {
			EObject object = contents.next();
			if (object instanceof Table && tableName.equalsIgnoreCase(((Table) object).getName())) {
				assertNull("UUID test table must occur only once", uuidTable);
				uuidTable = (Table) object;
			}
		}
		assertNotNull("UUID test table must be imported", uuidTable);
		assertEquals("UUID test table must have two columns", 2, uuidTable.getColumns().size());
		for (String columnName : new String[] { "id", "optional_uuid" }) {
			Column column = uuidTable.getColumns().stream()
					.filter(candidate -> columnName.equalsIgnoreCase(candidate.getName()))
					.findFirst().orElse(null);
			assertNotNull("Missing UUID column " + columnName, column);
			assertEquals("Nullability of " + columnName, "optional_uuid".equals(columnName), column.isNullable());
			assertTrue("UUID column must have a TypeInstance", column.getType() instanceof TypeInstance);
			TypeInstance type = (TypeInstance) column.getType();
			NativeType nativeType = type.getNativeType();
			assertNotNull("Native UUID type must be found", nativeType);
			assertFalse("Native UUID type must resolve", nativeType.eIsProxy());
			assertTrue("Unexpected native UUID type " + nativeType.getName(),
					nativeTypeName.equalsIgnoreCase(nativeType.getName()));
			assertTypeLibrary(nativeType, typesLibraryPathmap);
			assertEquals("Native UUID type must not require a length", NativeTypeKind.SIMPLE, nativeType.getSpec());

			NativeType logicalType = nativeType.getMapsTo();
			assertNotNull("Native UUID type must map to a logical type", logicalType);
			assertFalse("Logical UUID type must resolve", logicalType.eIsProxy());
			assertEquals("UUID", logicalType.getName());
			assertEquals("Logical UUID type must not require a length", NativeTypeKind.SIMPLE, logicalType.getSpec());
			assertTypeLibrary(logicalType, TypesLibraryUtil.LOGICAL_PATHMAP);
			System.out.println("UUID reverse column " + column.getName() + ": type=" + nativeType.getName()
					+ ", length=" + type.getLength() + ", precision=" + type.getPrecision());
		}
	}

	/**
	 * Checks the containing library after resolving URI mappings, since a pathmap
	 * and a platform or file URI can identify the same resource.
	 */
	private static void assertTypeLibrary(NativeType type, String pathmap) {
		Resource resource = type.eResource();
		assertNotNull("UUID type must belong to a resource", resource);
		assertNotNull("UUID type library must belong to a resource set", resource.getResourceSet());
		var converter = resource.getResourceSet().getURIConverter();
		assertEquals("Unexpected UUID type library", converter.normalize(URI.createURI(pathmap)),
				converter.normalize(resource.getURI()));
	}

	public static void checkEquality(DataBase database, DataBase databaseRef) {
		assertEquals("The number of schemas is different. Expected", databaseRef.getSchemas().size(),
				database.getSchemas().size());
		assertEquals("The number of tables is different.", databaseRef.getTables().size(), database.getTables().size());
		assertEquals("The number of sequences is different.", databaseRef.getSequences().size(),
				database.getSequences().size());
		assertEquals("The number of used libraries is different.", databaseRef.getUsedLibraries().size(),
				database.getUsedLibraries().size());

		new TestEqualityHelper().equals(database, databaseRef);
	}

	private static class TestEqualityHelper extends EqualityHelper {

		private static final long serialVersionUID = 162942433075477374L;

		@Override
		protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2, EAttribute attribute) {
			// Ignore ids
			if (attribute == DatabasePackage.Literals.DATABASE_ELEMENT__ID
					|| attribute == DatabasePackage.Literals.DATABASE_ELEMENT__TECH_ID) {
				return true;
			}
			return super.haveEqualAttribute(eObject1, eObject2, attribute);
		}

		@Override
		protected boolean haveEqualFeature(EObject eObject1, EObject eObject2, EStructuralFeature feature) {
			boolean result = feature == TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID || super.haveEqualFeature(eObject1, eObject2, feature);
			assertTrue("The " + feature.getClass().getInterfaces()[0].getSimpleName() + " '" + feature.getName()
					+ "' on " + getName(eObject1) + " is different. Expected "+eObject2.eGet(feature)+" but was: "+eObject1.eGet(feature), result);
			return result;
		}

		private static String getName(EObject obj) {
			String result = obj.eClass().getName();
			if (obj instanceof NamedElement) {
				result += " '" + ((NamedElement) obj).getName() + "'";
			} else if (obj instanceof DatabaseElement) {
				result += " '" + ((DatabaseElement) obj).getID() + "'";
			} else {
				List<EAttribute> attributes = obj.eClass().getEAllAttributes();
				if (!attributes.isEmpty()) {
					for (EAttribute eAttribute : attributes) {
						Object value = ((InternalEObject) obj).eGet(eAttribute);
						if (value instanceof String) {
							result += eAttribute.getName() + ": '" + value + "'";
						}
					}
				} else {
					result += " '" + obj.toString() + "'";
				}
			}
			return result;
		}
	}
}
