/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.gen.common.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.DataBaseCompareUtil;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.osgi.framework.Bundle;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

abstract public class AbstractGenerationTest {

	private static final String INPUT = "input/";
	private static final String INPUT_FILENAME_1 = "1-input.database";
	private static final String INPUT_FILENAME_2 = "2-input.database";
	private static final String COMMON_BUNDLE_ID = "org.obeonetwork.dsl.database.gen.common.tests";
	private static final String MODEL_INPUT_FOLDER = "/" + COMMON_BUNDLE_ID + "/" + INPUT;

	@Rule
	public TemporaryFolder tmp = new TemporaryFolder();
	private File targetFolder;
	private File rootFolder;
	private File expectedFolder;

	@Before
	public void setUp() throws IOException {
		rootFolder = tmp.newFolder();

		targetFolder = rootFolder.toPath().resolve("result").toFile();
		targetFolder.mkdirs();

		expectedFolder = rootFolder.toPath().resolve("expected").toFile();
		expectedFolder.mkdirs();
	}

	public File getRootFolder() {
		return rootFolder;
	}

	public File getExpectedFolder() {
		return expectedFolder;
	}

	public File getTargetFolder() {
		return targetFolder;
	}

	private TableContainer loadTableContainerFromFile(String folderName, String filename) {
		URI uri = URI.createPlatformPluginURI(MODEL_INPUT_FOLDER + folderName + "/" + filename, true);
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof TableContainer) {
				return (TableContainer) eObject;
			}
		}
		return null;
	}

	public void assertGenerationEquals(String inputFolderName, boolean createSchemaIfNoneExist) {
		// Ease fixing failing tests.
		System.out.println("Test on folder " + inputFolderName);
		
		TableContainer source = getSourceModel(inputFolderName);
		TableContainer target = getSourceTarget(inputFolderName);
		String expectationsFolderPath = INPUT + inputFolderName + "/expected";
		
		File expectationsFolder = createExpectationsFolder(expectationsFolderPath);
		try {
			Comparison comparison = DatabaseCompareService.compare(source, target);
			doGenerate(comparison, targetFolder, createSchemaIfNoneExist);
		} catch (Exception e) {
			fail("Comparison failed with an exception : " + e.getMessage());
		}

		compareFolders(targetFolder, expectationsFolder);
	}
	
	public void assertGenerationEquals(String inputFolderName) {
		assertGenerationEquals(inputFolderName, false);
	}
	
	public void assertGenerationFromScratchEquals(String folder, String fileName, String expectedFolderName) throws Exception {
		assertGenerationFromScratchEquals(folder, fileName, expectedFolderName, false);
	}

	public void assertGenerationFromScratchEquals(String folder, String fileName, String expectedFolderName, boolean createSchemaIfNoneExist) throws Exception {
		String expectationsFolderPath = INPUT + folder + "/" + expectedFolderName;
		File expectationsFolder = createExpectationsFolder(expectationsFolderPath);

		TableContainer rootContainer = loadTableContainerFromFile(folder, fileName);

		Comparison comparison = DataBaseCompareUtil.buildFromScratchComparison(rootContainer);
		doGenerate(comparison, targetFolder, createSchemaIfNoneExist);
		compareFolders(targetFolder, expectationsFolder);
	}
	
	private TableContainer getSourceModel(String inputFolderName) {
		return loadTableContainerFromFile(inputFolderName, INPUT_FILENAME_1);
	}

	private TableContainer getSourceTarget(String inputFolderName) {
		return loadTableContainerFromFile(inputFolderName, INPUT_FILENAME_2);
	}
	
	protected abstract void doGenerate(Comparison comparison, File targetFolder) throws IOException;
	
	protected abstract void doGenerate(Comparison comparisonModel, File targetFolder, boolean createSchemaIfNoneExist) throws IOException ;

	protected abstract void compareFolders(File targetFolder, File expectationFolder);

	private File createExpectationsFolder(String expectationsFolderPath) {
		File expectationsFolder = expectedFolder;

		Bundle bundle = Platform.getBundle(getExpectedResultBundleId());
		Enumeration<URL> sqlEntries = bundle.findEntries(expectationsFolderPath, "*." + getExpectedResultFileExt(),
				false);
		if (sqlEntries != null) {
			while (sqlEntries.hasMoreElements()) {
				URL entry = sqlEntries.nextElement();
				File expectedFile = getFileFromURL(entry);
				try {
					// Copy file into expectations folder
					Files.copy(expectedFile, new File(expectationsFolder.getPath() + "/" + expectedFile.getName()));
				} catch (IOException e) {
					fail("Unable to copy expected file into temp folder : " + e.getMessage());
				}
			}
		}
		return expectationsFolder;
	}

	private File getFileFromURL(URL fileURL) {
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return file;
	}

	protected String convertCRLFtoCR(String content) {
		return content.replaceAll("\r", "");
	}

	protected String readFile(File file) {
		try {
			return Files.toString(file, Charsets.UTF_8);
		} catch (IOException e) {
			fail("Error reading file : " + file.getAbsolutePath());
		}
		return null;
	}
	
	protected abstract String getExpectedResultBundleId();

	protected abstract String getExpectedResultFileExt();

}
