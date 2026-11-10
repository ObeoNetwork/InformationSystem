/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;

public class GlobalChangelogServiceTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void findsHistoriesInChronologicalOrder() throws IOException {
		Path directory = temporaryFolder.newFolder().toPath();
		createChangelog(directory, "2026-11-10-11-00-00");
		createChangelog(directory, "2026-11-09-10-00-00");
		createChangelog(directory, "2026-11-10-09-00-00");
		Files.writeString(directory.resolve(ChangelogConstants.CHANGELOG_FILE_NAME), "latest generation copy");
		Files.writeString(directory.resolve("global_run.changelog.xml"), "global changelog");
		createChangelog(directory, "backup");
		createChangelog(directory, "backup/2026-11-10-10-00-00");
		createChangelog(directory, "2026-02-30-10-00-00");
		Files.createDirectories(directory.resolve("2026-11-10-12-00-00"));

		assertEquals(List.of(Path.of("2026-11-09-10-00-00", "run.changelog.xml"),
				Path.of("2026-11-10-09-00-00", "run.changelog.xml"),
				Path.of("2026-11-10-11-00-00", "run.changelog.xml")), GlobalChangelogService.findChangelogs(directory));
	}

	@Test
	public void returnsEmptyListForEmptyDirectory() throws IOException {
		assertTrue(GlobalChangelogService.findChangelogs(temporaryFolder.newFolder().toPath()).isEmpty());
	}

	@Test(expected = IOException.class)
	public void reportsMissingDirectory() throws IOException {
		GlobalChangelogService.findChangelogs(temporaryFolder.getRoot().toPath().resolve("missing"));
	}

	private void createChangelog(Path directory, String generation) throws IOException {
		Path generationDirectory = Files.createDirectories(directory.resolve(generation));
		Files.writeString(generationDirectory.resolve(ChangelogConstants.CHANGELOG_FILE_NAME), "changelog contents");
	}
}
