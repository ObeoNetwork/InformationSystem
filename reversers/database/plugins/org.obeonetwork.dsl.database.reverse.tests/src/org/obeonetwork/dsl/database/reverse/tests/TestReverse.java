package org.obeonetwork.dsl.database.reverse.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryResourceFactoryImpl;

import com.google.common.collect.Lists;

public class TestReverse {

	@Test
	public void testMySQL() {
		
		DataSource dataSource = new DataSource("northwind", null);

		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/northwind");
		dataSource.setJdbcUsername("root");
		dataSource.setJdbcPassword(null);
		dataSource.setVendor("MySQL-5");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/mysql/outputRef.database", "pathmap://NativeDBTypes/MySQL-5");
		
		checkEquality(database, databaseRef);
		
	}
	
	@Test
	public void testOracle() {
		
		DataSource dataSource = new DataSource("XE", "NORTHWIND");

		dataSource.setJdbcUrl("jdbc:oracle:thin:northwind/northwind@//localhost:1521/XE");
		dataSource.setJdbcUsername("northwind");
		dataSource.setJdbcPassword("northwind");
		dataSource.setVendor("Oracle-11g");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/oracle/outputRef.database", "pathmap://NativeDBTypes/Oracle-11g");
		
		checkEquality(database, databaseRef);
		
	}
	
	@Test
	public void testH2Embedded() {
		
		String databaseLocation = getH2DatabaseLocation(this.getClass(), "input");
		
		DataSource dataSource = new DataSource(databaseLocation, "PUBLIC");

		dataSource.setJdbcUrl("jdbc:h2:" + databaseLocation);
		dataSource.setJdbcUsername("sa");
		dataSource.setVendor("H2-1.3");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/h2/outputRef.database", "pathmap://NativeDBTypes/H2-1.3");
		
		checkEquality(database, databaseRef);
		
	}
	
	@Test
	public void testH2Server() {
	
		String databaseLocation = getH2DatabaseLocation(this.getClass(), "input");
			
		DataSource dataSource = new DataSource(databaseLocation, "PUBLIC");

		dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/" + databaseLocation);
		dataSource.setJdbcUsername("sa");
		dataSource.setVendor("H2-1.3");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/h2/outputRef.database", "pathmap://NativeDBTypes/H2-1.3");
		
		checkEquality(database, databaseRef);
		
	}
	
	@Test
	public void testPostgres() {
	
		DataSource dataSource = new DataSource("postgres", "public");

		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setJdbcUsername("postgres");
		dataSource.setJdbcPassword("admin");
		dataSource.setVendor("Postgres-9");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/postgres/outputRef.database", "pathmap://NativeDBTypes/Postgres-9");
		
		checkEquality(database, databaseRef);
		
	}
	
	@Test
	public void testSQLServer() {
	
		DataSource dataSource = new DataSource("Northwind", "dbo");

		dataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=Northwind");
		dataSource.setJdbcUsername("testUser");
		dataSource.setJdbcPassword("test");
		dataSource.setVendor("SQLServer-2008");
		
		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);
		
		DataBase databaseRef = loadModel("resources/sqlserver/outputRef.database", "pathmap://NativeDBTypes/SQLServer-2008");
		
		checkEquality(database, databaseRef);
		
	}

	private static void checkEquality(DataBase database, DataBase databaseRef) {
		assertEquals("The number of schemas is different.", databaseRef.getSchemas().size(), database.getSchemas().size());
		assertEquals("The number of tables is different.", databaseRef.getTables().size(), database.getTables().size());
		assertEquals("The number of sequences is different.", databaseRef.getSequences().size(), database.getSequences().size());
		assertEquals("The number of used libraries is different.", databaseRef.getUsedLibraries().size(), database.getUsedLibraries().size());

		new TestEqualityHelper().equals(database, databaseRef);	
	}
	
	private static DataBase loadModel(String databaseTestPluginRelativePath, String typesLibraryPathmapUri) {
		URI uri = URI.createFileURI(databaseTestPluginRelativePath);

		DatabaseResourceFactoryImpl databaseResourceFactory = new DatabaseResourceFactoryImpl();
		Resource resourceDatabase = databaseResourceFactory.createResource(uri);
		
		TypesLibraryResourceFactoryImpl typesLibraryresourceFactory = new TypesLibraryResourceFactoryImpl();
		Resource typeResource = typesLibraryresourceFactory.createResource(URI.createURI(typesLibraryPathmapUri));
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(resourceDatabase);
		rs.getResources().add(typeResource);

		try {
			
			Map options = rs.getLoadOptions();
			options.put(DatabasePackage.eINSTANCE.getNsURI(), DatabasePackage.eINSTANCE);
			options.put(TypesLibraryPackage.eINSTANCE.getNsURI(), TypesLibraryPackage.eINSTANCE);
			
			resourceDatabase.load(options);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return (DataBase) resourceDatabase.getContents().get(0);
	}
	
	private static String getH2DatabaseLocation(Class testClass, String databaseName) {
		String databaseLocation = testClass.getClassLoader().getResource("h2/" + databaseName + ".h2.db").getPath();
		databaseLocation = databaseLocation.substring(1, databaseLocation.lastIndexOf("/"));
		return databaseLocation + "/" + databaseName;
	}
	
	private static class TestEqualityHelper extends EqualityHelper {
		
		@Override
		protected boolean haveEqualAttribute(EObject eObject1,
				EObject eObject2, EAttribute attribute) {
			// Ignore ids
			if (attribute == DatabasePackage.Literals.DATABASE_ELEMENT__ID
					|| attribute == DatabasePackage.Literals.DATABASE_ELEMENT__TECH_ID) {
				return true;
			}
			return super.haveEqualAttribute(eObject1, eObject2, attribute);
		}
		
		@Override
		protected boolean haveEqualFeature(EObject eObject1, EObject eObject2,
				EStructuralFeature feature) {
			boolean result = super.haveEqualFeature(eObject1, eObject2, feature);
			assertTrue("The " + feature.getClass().getInterfaces()[0].getSimpleName() + " '" + feature.getName() + "' on " + getName(eObject1)  + " is different", result);
			return result;
		}
		
		private static String getName(EObject obj) {
			String result = obj.eClass().getName();
			if (obj instanceof NamedElement) {
				result += " '" + ((NamedElement)obj).getName() + "'";
			} else if (obj instanceof DatabaseElement) {
				result += " '" + ((DatabaseElement)obj).getID() + "'";
			} else {
				List<EAttribute> attributes = obj.eClass().getEAllAttributes();
				if (!attributes.isEmpty()) {
					for (EAttribute eAttribute : attributes) {
						Object value = ((InternalEObject)obj).eGet(eAttribute);
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
