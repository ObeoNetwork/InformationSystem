/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.changelogs;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.gen.common.tests.AbstractGenerationTest;
import org.obeonetwork.dsl.database.liquibasegen.ChangeLogBuilder;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseGenerator;
import org.w3c.dom.Document;

import com.google.common.base.Charsets;

public class AbstractLiquibaseTest extends AbstractGenerationTest {

	@Override
	protected void doGenerate(Comparison comparison, File targetFolder) throws IOException {
		LiquibaseGenerator generator = new LiquibaseGenerator();
		generator.setIdPrefixProvider(() -> "test");
		generator.doGenerate(new BasicMonitor(), comparison, targetFolder.toPath());

	}

	@Override
	protected void compareFolders(File targetFolder, File expectationFolder) {

		try {
			Optional<Path> optResultFile = Files.walk(targetFolder.toPath())
					.filter(p -> ChangeLogBuilder.FILE_NAME.equals(p.getFileName().toString())).findFirst();
			if (!optResultFile.isPresent()) {
				fail("Not changelog file found");
			}
			Path resultFile = optResultFile.get();
			Path extectedFile = expectationFolder.toPath().resolve(ChangeLogBuilder.FILE_NAME);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			dbf.setCoalescing(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document expectedDoc = db.parse(extectedFile.toFile());
			expectedDoc.normalizeDocument();

			Document resultDoc = db.parse(resultFile.toFile());
			resultDoc.normalizeDocument();

			if (!expectedDoc.isEqualNode(resultDoc)) {
				String resultFileContent = readFile(resultFile.toFile());
				// Prints content to easily compare file
				System.out.println(resultFileContent);
				fail("Non identical XML");
			}

		} catch (

		Exception e1) {
			e1.printStackTrace();
			fail(e1.getMessage());
		}

	}

	protected List<String> readLines(Path path) {
		try {
			return Files.readAllLines(path, Charsets.UTF_8);
		} catch (IOException e) {
			fail("Error reading file : " + path);
		}
		return null;
	}

	@Override
	protected String getExpectedResultBundleId() {
		return "org.obeonetwork.dsl.database.liquibasegen.test";
	}

	@Override
	protected String getExpectedResultFileExt() {
		return "xml";
	}

}
