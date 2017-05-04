/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.tests.generation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.osgi.framework.Bundle;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

abstract public class AbstractSQLGenerationTest {
	
	private static final String INPUT = "input/";
	private static final String INPUT_FILENAME_1 = "1-input.database";
	private static final String INPUT_FILENAME_2 = "2-input.database";
	private static final String BUNDLE_ID = "org.obeonetwork.dsl.database.sqlgen.tests";
	private static final String INPUT_FOLDER = "/" + BUNDLE_ID + "/" + INPUT;
	
	public void assertGenerationEquals(String inputFolderName) {
		TableContainer source = loadTableContainerFromFile(inputFolderName, INPUT_FILENAME_1);
		TableContainer target = loadTableContainerFromFile(inputFolderName, INPUT_FILENAME_2);
		assertGenerationEquals(source, target, INPUT + inputFolderName + "/expectedSql");
	}


	public void assertGenerationEquals(TableContainer source, TableContainer target, String expectationsFolderPath) {
		File targetFolder = createTargetFolder();
		File expectationsFolder = createExpectationsFolder(expectationsFolderPath);
		try {
			// Compare
			Comparison comparison = DatabaseCompareService.compare(source, target);
			// and generate sql scripts based on the comparison
			DatabaseGen generator = new DatabaseGen(comparison, targetFolder, Collections.emptyList());
			generator.doGenerate(new BasicMonitor());
		} catch (Exception e) {
			deleteFile(targetFolder);
			deleteFile(expectationsFolder);
			fail("Comparison failed with an exception : " + e.getMessage());
		}
		
		compareFolders(targetFolder, expectationsFolder);
		
		// Delete targetFolder and expectationsFolder
		deleteFile(targetFolder);
		deleteFile(expectationsFolder);
	}
	
	private File createExpectationsFolder(String expectationsFolderPath) {
		File expectationsFolder = Files.createTempDir();
		
		// List sql files from bundle
		Bundle bundle = Platform.getBundle(BUNDLE_ID);
		Enumeration<URL> sqlEntries = bundle.findEntries(expectationsFolderPath, "*.sql", false);
		if (sqlEntries != null) {
			while (sqlEntries.hasMoreElements()) {
				URL sqlEntry = sqlEntries.nextElement();
				File sqlFile = getFileFromURL(sqlEntry);
				try {
					// Copy file into expectations folder 
					Files.copy(sqlFile, new File(expectationsFolder.getPath() + "/" + sqlFile.getName()));
				} catch (IOException e) {
					 fail("Unable to copy expected SQL file into temp folder : " + e.getMessage());
				}
			}
		}
		return expectationsFolder;
	}
	
	private void compareFolders(File targetfolder, File expectationsFolder) {
		List<File> generatedFiles = getGeneratedFilesSortedByName(targetfolder);
		List<String> generatedFilesNames = getFileNames(generatedFiles);
		List<File> expectedFiles = getGeneratedFilesSortedByName(expectationsFolder);
		List<String> expectedFilesNames = getFileNames(expectedFiles);
		
		// Check if expected files were not generated
		if (!generatedFilesNames.containsAll(expectedFilesNames)) {
			fail("Some files have not been generated : " + getMissingFilesNames(generatedFilesNames, expectedFilesNames));
		}
		// Check if more files have been generated than expected
		if (!expectedFilesNames.containsAll(generatedFilesNames)) {
			fail("Some files should not have been generated : " + getMissingFilesNames(expectedFilesNames, generatedFilesNames));
		}
		
		// Compare each file
		for (int i = 0; i < generatedFiles.size(); i++) {
			File generatedFile = generatedFiles.get(i);
			File expectedFile = expectedFiles.get(i);

			String generatedContent = convertCRLFtoCR(readFile(generatedFile));
			String expectedContent = convertCRLFtoCR(readFile(expectedFile));
			
			assertEquals("Generated content is different", expectedContent, generatedContent);
		}
	}
	
	private String convertCRLFtoCR(String content) {
		return content.replaceAll("\r", "");
	}
	
	private String getMissingFilesNames(List<String> allNames, List<String> shouldBeHereNames) {
		StringBuilder sb = new StringBuilder();
		for (String shouldBeHereName : shouldBeHereNames) {
			if (!allNames.contains(shouldBeHereName)) {
				sb.append(shouldBeHereName + ", ");
			}
		}
		return sb.toString();
	}
	
	private List<String> getFileNames(List<File> files) {
		List<String> filenames = new ArrayList<String>();
		for (File file : files) {
			filenames.add(file.getName());
		}
		return filenames;
	}
	
	private List<File> getGeneratedFilesSortedByName(File folder) {
		List<File> files = findSQLFilesInfolder(folder);
		Collections.sort(files, new Comparator<File>() {
			public int compare(File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
		});
		return files;
	}
	
	private List<File> findSQLFilesInfolder(File folder) {
		List<File> sqlFiles = new ArrayList<File>();
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				sqlFiles.addAll(findSQLFilesInfolder(file));
			} else if (file.getName().endsWith(".sql") && !file.getName().equals("all.sql")) {
				sqlFiles.add(file);
			}
		}
		return sqlFiles;
	}

	private File createTargetFolder() {
		File targetFolder = Files.createTempDir();
		if (targetFolder == null) {
			fail("Unable to create temporary target folder.");
		}
		return targetFolder;
	}
	
	/**
	 * Delete a file
	 * If the file is a folder, all its contents is deleted
	 * @param file
	 */
	private void deleteFile(File file) {
		if (file.isDirectory() ) {
			for (File child : file.listFiles()) {
				deleteFile(child);
			}
			file.delete();
		} else  {
			file.delete();
		}
	}
	
	private String readFile(File file) {
		try {
			return Files.toString(file, Charsets.UTF_8);
		} catch (IOException e) {
			fail("Error reading file : " + file.getAbsolutePath());
		}
		return null;
	}
	
	private TableContainer loadTableContainerFromFile(String folderName, String filename) {
		URI uri = URI.createPlatformPluginURI(INPUT_FOLDER + folderName + "/" + filename, true);
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof TableContainer) {
				return (TableContainer)eObject;
			}
		}
		return null;
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
}
