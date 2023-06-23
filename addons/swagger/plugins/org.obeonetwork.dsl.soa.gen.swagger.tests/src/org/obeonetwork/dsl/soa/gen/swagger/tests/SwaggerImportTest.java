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
package org.obeonetwork.dsl.soa.gen.swagger.tests;

import static org.junit.Assert.assertTrue;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.createSoaResourceSet;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.createSoaResourceSetFromBundleEntryPath;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.createSystem;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.createTempFolderFromBundleEntryPath;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.findFirstFile;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.SwaggerTestHelper.loadEnvironment;
import static org.obeonetwork.tools.tests.ObeoDSMTestHelper.assertObeoDSMEquals;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Test;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerImporter;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerExportUtil.MapperType;

public class SwaggerImportTest {
	
	private static final String INPUT_FOLDER_PATH_FORMAT = "/data/import/%s/%s";
	private static final String EXPECTED_FOLDER_PATH_FORMAT = "/data/import/%s/xmi";
	
	public void testImportFromFile(String testId, MapperType inputFormat) {
		String inputFolderPath = String.format(INPUT_FOLDER_PATH_FORMAT, testId, inputFormat.toString().toLowerCase());
		File inputFolder = createTempFolderFromBundleEntryPath(inputFolderPath);
		File inputFile = findFirstFile(inputFolder);
		
		ResourceSet destinationResourceSet = createSoaResourceSet();
		Environment environment = loadEnvironment(destinationResourceSet);
		System destinationSystem = createSystem(destinationResourceSet);
		
		SwaggerImporter swaggerImporter = new SwaggerImporter(destinationSystem, environment);
		int status = swaggerImporter.importFromFile(inputFile.getAbsolutePath(), "x-pagination");
		
		// save the model to file to ease understanding in case of error:
		
//		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//        Map<String, Object> m = reg.getExtensionToFactoryMap();
//        m.put("soa", new SoaResourceFactoryImpl());
//        Resource resource = destinationResourceSet.createResource(URI.createURI("model.soa"));
//        resource.getContents().add(destinationSystem);
//        try {
//			resource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
		String expectedBundleEntryFolderPath = String.format(EXPECTED_FOLDER_PATH_FORMAT, testId);
		ResourceSet expectedResourceSet = createSoaResourceSetFromBundleEntryPath(expectedBundleEntryFolderPath);
		System expectedSystem = expectedResourceSet.getResources().stream()
		.flatMap(res -> res.getContents().stream())
		.filter(root -> root instanceof org.obeonetwork.dsl.soa.System)
		.map(root -> (org.obeonetwork.dsl.soa.System)root)
		.findFirst().orElse(null);
		
		destinationSystem.setName(expectedSystem.getName());
    
		assertTrue("Swagger import returned with error status code", status != IStatus.ERROR);
		assertObeoDSMEquals("Imported model is different for file " + inputFile.getAbsolutePath(), expectedSystem, destinationSystem); 
	}

	@Test
	public void testJsonImportPetstore() {
		testImportFromFile("petstore", MapperType.JSON);
	}

	@Test
	public void testYamlImportPetstore() {
		testImportFromFile("petstore", MapperType.YAML);
	}

	@Test
	public void testJsonImportThetvdb() {
		testImportFromFile("thetvdb", MapperType.JSON);
	}

	@Test
	public void testYamlImportThetvdb() {
		testImportFromFile("thetvdb", MapperType.YAML);
	}
	
	@Test
	public void testJsonImportThetvdbExtensions() {
		testImportFromFile("thetvdb-extensions", MapperType.JSON);
	}

	@Test
	public void testYamlImportThetvdbExtensions() {
		testImportFromFile("thetvdb-extensions", MapperType.YAML);
	}

	@Test
	public void testJsonImportOdtsAdminWs() {
		testImportFromFile("odts-admin-ws", MapperType.JSON);
	}

	@Test
	public void testYamlImportOdtsAdminWs() {
		testImportFromFile("odts-admin-ws", MapperType.YAML);
	}

}
