/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.gen.common.tests.AbstractGenerationTest;

import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.exception.ChangeLogParseException;
import liquibase.parser.core.xml.XMLChangeLogSAXParser;
import liquibase.resource.FileSystemResourceAccessor;

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

			DatabaseChangeLog resultChangeLog = parse(resultFile);
			DatabaseChangeLog expectedChangeLog = parse(extectedFile);

			List<ChangeSet> expectedChangeSets = expectedChangeLog.getChangeSets();
			List<ChangeSet> resultChangeSets = resultChangeLog.getChangeSets();
			assertEquals(expectedChangeSets.size(), resultChangeSets.size());
			int i = 0;
			for (ChangeSet cs : expectedChangeSets) {
				assertEquals(cs, resultChangeSets.get(i));
				i++;
			}
			assertEquals(expectedChangeLog, resultChangeLog);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail(e1.getMessage());
		}

	}

	private DatabaseChangeLog parse(Path file) throws ChangeLogParseException {
		ChangeLogParameters changeLogParameters = new ChangeLogParameters();
		FileSystemResourceAccessor resourceAccessor = new FileSystemResourceAccessor(file.getParent().toFile());
		XMLChangeLogSAXParser parser = new XMLChangeLogSAXParser();

		return parser.parse(file.getFileName().toString(), changeLogParameters, resourceAccessor);
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
