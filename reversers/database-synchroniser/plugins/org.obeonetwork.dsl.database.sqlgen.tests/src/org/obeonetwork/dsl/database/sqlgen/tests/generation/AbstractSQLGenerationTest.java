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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.gen.common.tests.AbstractGenerationTest;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

abstract public class AbstractSQLGenerationTest extends AbstractGenerationTest {

	private static final String EXPECTED_RESULT_BUNDLE_ID = "org.obeonetwork.dsl.database.sqlgen.tests";

	@Override
	protected void doGenerate(Comparison comparison, File targetFolder) throws IOException {
		DatabaseGen generator = new DatabaseGen(comparison, targetFolder, Collections.emptyList());
		generator.doGenerate(new BasicMonitor());
	}

	protected void compareFolders(File targetfolder, File expectationsFolder) {
		List<File> generatedFiles = getGeneratedFilesSortedByName(targetfolder);
		List<String> generatedFilesNames = getFileNames(generatedFiles);
		List<File> expectedFiles = getGeneratedFilesSortedByName(expectationsFolder);
		List<String> expectedFilesNames = getFileNames(expectedFiles);

		// Check if expected files were not generated
		if (!generatedFilesNames.containsAll(expectedFilesNames)) {
			fail("Some files have not been generated : "
					+ getMissingFilesNames(generatedFilesNames, expectedFilesNames));
		}
		// Check if more files have been generated than expected
		if (!expectedFilesNames.containsAll(generatedFilesNames)) {
			fail("Some files should not have been generated : "
					+ getMissingFilesNames(expectedFilesNames, generatedFilesNames));
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

	@Override
	protected String getExpectedResultBundleId() {
		return EXPECTED_RESULT_BUNDLE_ID;
	}

	@Override
	protected String getExpectedResultFileExt() {
		return "sql";
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

	private String readFile(File file) {
		try {
			return Files.toString(file, Charsets.UTF_8);
		} catch (IOException e) {
			fail("Error reading file : " + file.getAbsolutePath());
		}
		return null;
	}
}
