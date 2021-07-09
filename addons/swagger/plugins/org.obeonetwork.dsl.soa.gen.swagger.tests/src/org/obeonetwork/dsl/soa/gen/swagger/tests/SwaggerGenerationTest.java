/*******************************************************************************
 **$
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.tests;

import static org.junit.Assert.assertTrue;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.TestHelper.assertFolderEquals;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.TestHelper.createSoaResourceSetFromBundleEntryPath;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.TestHelper.createTempFolderFromBundleEntryPath;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.TestHelper.createTemporaryOutputFolder;
import static org.obeonetwork.dsl.soa.gen.swagger.tests.TestHelper.findFirstComponent;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Test;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;

public class SwaggerGenerationTest {
	
	private static final String INPUT_FOLDER_PATH_FORMAT = "/data/export/%s/xmi";
	private static final String EXPECTED_FOLDER_PATH_FORMAT = "/data/export/%s/%s";
	private static final String OUTPUT_FOLDER_NAME_FORMAT = "swagger-gen-%s-%s";
	
	private void testExportInDir(String testId, MapperType outputFormat) {		
		String inputFolderPath = String.format(INPUT_FOLDER_PATH_FORMAT, testId);
		ResourceSet resourceSet = createSoaResourceSetFromBundleEntryPath(inputFolderPath);
		Component component = findFirstComponent(resourceSet);
		
		String expectedBundleEntryFolderPath = String.format(EXPECTED_FOLDER_PATH_FORMAT, testId, outputFormat.toString().toLowerCase());
		File expectedFolder = createTempFolderFromBundleEntryPath(expectedBundleEntryFolderPath);
		
		File outputFolder = createTemporaryOutputFolder(String.format(OUTPUT_FOLDER_NAME_FORMAT, testId, outputFormat.toString().toLowerCase()));
		
		SwaggerExporter swaggerExporter = new SwaggerExporter(component);
		swaggerExporter.setOutputFormat(outputFormat);
		int status = swaggerExporter.exportInDir(outputFolder);
		
		assertTrue("Swagger generation returned with error status code", status != IStatus.ERROR);
		
		assertFolderEquals("Swagger generation unexpected folder content.", outputFolder, expectedFolder); 
	}

	@Test
	public void testJsonExportInDirPetstore() {
		testExportInDir("petstore", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirPetstore() {
		testExportInDir("petstore", MapperType.YAML);
	}
	
	@Test
	public void testJsonExportInDirThetvdb() {
		testExportInDir("thetvdb", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirThetvdb() {
		testExportInDir("thetvdb", MapperType.YAML);
	}
	
	@Test
	public void testJsonExportInDirOdtsAdminWs() {
		testExportInDir("odts-admin-ws", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirOdtsAdminWs() {
		testExportInDir("odts-admin-ws", MapperType.YAML);
	}	
}
