package org.obeonetwork.dsl.database.reverse.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
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

	private void checkEquality(DataBase database, DataBase databaseRef) {
		assertTrue(database.getSchemas().size() == databaseRef.getSchemas().size());
		assertTrue(database.getTables().size() == databaseRef.getTables().size());
		assertTrue(database.getSequences().size() == databaseRef.getSequences().size());
		assertTrue(database.getUsedLibraries().size() == databaseRef.getUsedLibraries().size());

		EqualityHelper helper = new TestEqualityHelper();
		assertTrue(helper.equals(database, databaseRef));	
		
		List<EObject> eltsDatabase = Lists.newArrayList(database.eAllContents());
		List<EObject> eltsDatabaseRef = Lists.newArrayList(databaseRef.eAllContents());
		for (int i = 0; i < eltsDatabaseRef.size(); i++) {
			assertTrue(helper.equals(eltsDatabaseRef.get(i), eltsDatabase.get(i)));
		}
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
	}

}
