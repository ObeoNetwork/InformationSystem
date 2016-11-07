package org.obeonetwork.database.m2doc.services.common;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

public abstract class AbstractTest {
	/**
	 * {@link ResourceSet} used to load test models.
	 */
	private ResourceSet resourceSet;

	public AbstractTest() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put("http://www.obeonetwork.org/dsl/database/1.0", DatabasePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put("http://www.obeonetwork.org/dsl/typeslibrary/1.0",
				TypesLibraryPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("database",
				new XMIResourceFactoryImpl());
	}

	/**
	 * Returns the resource set used to load test models.
	 * 
	 * @return
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Returns the DataBase in the specified resource's file name.
	 * 
	 * @param fileName
	 * @return
	 */
	public DataBase loadModel(String fileName) {
		Resource resource = resourceSet.getResource(URI.createURI(fileName), true);
		int i = 0;
		int s = resource.getContents().size();
		while (i < s && !(resource.getContents().get(i) instanceof DataBase)) {
			i++;
		}
		if (i < s) {
			return (DataBase) resource.getContents().get(i);
		} else {
			return null;
		}
	}

}
