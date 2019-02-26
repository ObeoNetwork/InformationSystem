package org.obeonetwork.dsl.database.tests.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryResourceFactoryImpl;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.osgi.OSGiResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;

public final class TestUtils {
	
	private TestUtils() {
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

	public static void checkEquality(DataBase database, DataBase databaseRef) {
		assertEquals("The number of schemas is different.", databaseRef.getSchemas().size(),
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
			boolean result = super.haveEqualFeature(eObject1, eObject2, feature);
			assertTrue("The " + feature.getClass().getInterfaces()[0].getSimpleName() + " '" + feature.getName()
					+ "' on " + getName(eObject1) + " is different", result);
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
