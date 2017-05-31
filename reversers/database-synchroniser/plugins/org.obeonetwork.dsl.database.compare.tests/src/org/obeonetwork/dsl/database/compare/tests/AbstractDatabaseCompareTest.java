/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.tests;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Assert;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.obeonetwork.dsl.database.compare.tests.gen.main.Generate;

public class AbstractDatabaseCompareTest {

	private static final String MODELS_FOLDER = "org.obeonetwork.dsl.database.compare.tests/models/";
	private static final String INPUT_DATABASE_1 = "/1-input.database";
	private static final String INPUT_DATABASE_2 = "/2-input.database";
	private static final String EXPECTED_COMPARISON = "/3-expected-comparison.xmi";
	
	public void testDatabaseCompare(String folder) {
		TableContainer tableContainer1 = (TableContainer)loadRootObject(folder, INPUT_DATABASE_1, TableContainer.class);
		TableContainer tableContainer2 = (TableContainer)loadRootObject(folder, INPUT_DATABASE_2, TableContainer.class);
		//Comparison expectedSnapshot = (Comparison)loadRootObject(folder, EXPECTED_COMPARISON, Comparison.class);
		
		Comparison actualSnapshot = null;
		try {
			actualSnapshot = DatabaseCompareService.compare(tableContainer1, tableContainer2);
		} catch (Exception e) {
			Assert.fail("Exception during comparison : " + e.getMessage());
		}
		// FIXME STH - Assert was made on subElements of the Diff model
		// check if something like that should be made
//		assertEquals(expectedSnapshot.getDiff().getOwnedElements().get(0), actualSnapshot.getDifferences()getOwnedElements().get(0));
		//assertEquals(expectedSnapshot, actualSnapshot);
		
		try {
			Generate generate = new Generate(actualSnapshot, new File("models/" + folder), new ArrayList<Object>());
			generate.doGenerate(new BasicMonitor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private EObject loadRootObject(String folder, String filename, Class<?> expectedClass) {
		String pathName = MODELS_FOLDER + folder + filename;
		EObject object = getRootObject(URI.createPlatformPluginURI(pathName, true), expectedClass);
		if (object == null) {
			Assert.fail("Unable to open model : " + pathName);
		}
		return object;
	}
	
	private EObject getRootObject(URI modelURI, Class<?> expectedClass) {
		ResourceSet set = getResourceSet();
		Resource resource = set.getResource(modelURI, true);
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject object = it.next();
			if (expectedClass.isInstance(object)) {
				return object;
			}
		}
		return null;
	}
	
	private void assertEquals(EObject expected, EObject actual) {
		try {
			String expectedSerialized = serialize(expected);
			String actualSerialized = serialize(actual);
			
			Assert.assertEquals("Models are different",
					removeUselessElementsForComparison(expectedSerialized),
					removeUselessElementsForComparison(actualSerialized)
					);
		} catch (IOException e) {
			Assert.fail("Unable to serialize model (ModelUtils) : " + e.getMessage());
		}
	}
	
	private String removeUselessElementsForComparison(String msg) {
		String result = msg.replaceAll("href=\"platform:/.*/(1|2)-input\\.database", "href=\"platform:/path/to/$1-input.database");
		result = result.replaceAll("<diffModel href=\"[^\"]*\"/>", "<diffModel href=\"path/to/diffmodel\"/>");
		result = result.replaceAll(" requires=\"[^\"]*\"", "");
		result = result.replaceAll(" requiredBy=\"[^\"]*\"", "");
		return result;
	}
	
	private ResourceSet resourceSet = null;
	private ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}
	
	protected String serialize(EObject root) throws IOException {
		if (root == null)
			return "";

		// Copies the root to avoid modifying it
		final EObject copyRoot = EcoreUtil.copy(root);
		attachResource(URI.createFileURI("resource.xml"), copyRoot); //$NON-NLS-1$

		final StringWriter writer = new StringWriter();
		final Map<String, String> options = new HashMap<String, String>();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty("file.encoding"));
		// Should not throw ClassCast since uri calls for an xml resource
		((XMLResource)copyRoot.eResource()).save(writer, options);
		final String result = writer.toString();
		writer.flush();
		return result;
	}
	
	protected Resource attachResource(URI resourceURI, EObject root) {
		final Resource newResource = createResource(resourceURI);
		newResource.getContents().add(root);
		return newResource;
	}
	
	protected Resource createResource(URI modelURI) {
		return createResource(modelURI, new ResourceSetImpl());
	}

	/**
	 * This will create a {@link Resource} given the model extension it is intended for and a ResourceSet.
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The {@link Resource} given the model extension it is intended for.
	 */
	protected Resource createResource(URI modelURI, ResourceSet resourceSet) {
		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}

		// First search the resource set for our resource factory
		Resource.Factory.Registry registry = resourceSet.getResourceFactoryRegistry();
		Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory == null) {
			// then the global registry
			registry = Resource.Factory.Registry.INSTANCE;
			resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, new XMIResourceFactoryImpl());
			}
		}

		return resourceSet.createResource(modelURI);
	}
}

