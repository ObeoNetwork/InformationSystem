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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GlobalChangelogServiceTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	/**
	 * Ensures discovery returns only direct timestamped histories in chronological
	 * order, excluding root copies, backups, nested files and incomplete histories.
	 */
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

	/**
	 * Ensures an empty history is a normal result, so the caller can distinguish it
	 * from a failure to access the changelogs directory.
	 */
	@Test
	public void returnsEmptyListForEmptyDirectory() throws IOException {
		assertTrue(GlobalChangelogService.findChangelogs(temporaryFolder.newFolder().toPath()).isEmpty());
	}

	/**
	 * Ensures a missing directory is reported as an error rather than silently
	 * appearing to contain no history.
	 */
	@Test(expected = IOException.class)
	public void reportsMissingDirectory() throws IOException {
		GlobalChangelogService.findChangelogs(temporaryFolder.getRoot().toPath().resolve("missing"));
	}

	/**
	 * Protects global changelog assembly: only selected histories are included, in
	 * chronological order with relative paths, without copying or changing their
	 * contents. An unselected history must not affect duplicate-ID validation.
	 */
	@Test
	public void createsOrderedRelativeIncludesForSelectedHistories() throws Exception {
		Path directory = temporaryFolder.newFolder("changelogs with spaces").toPath();
		Path first = createXmlChangelog(directory, "2026-11-10-09-00-00", "first", "author");
		createXmlChangelog(directory, "2026-11-10-10-00-00", "first", "author");
		Path last = createXmlChangelog(directory, "2026-11-10-11-00-00", "last", "author");
		Path global = directory.resolve(ChangelogConstants.GLOBAL_CHANGELOG_FILE_NAME);
		Files.writeString(global, "previous global changelog");
		String firstContents = Files.readString(directory.resolve(first));

		assertEquals(global, GlobalChangelogService.createGlobalChangelog(directory, List.of(last, first)));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		factory.setNamespaceAware(true);
		Document document = factory.newDocumentBuilder().parse(global.toFile());
		String namespace = "http://www.liquibase.org/xml/ns/dbchangelog";
		assertEquals("databaseChangeLog", document.getDocumentElement().getLocalName());
		assertEquals(namespace, document.getDocumentElement().getNamespaceURI());
		NodeList includes = document.getElementsByTagNameNS(namespace, "include");
		assertEquals(2, includes.getLength());
		assertEquals("2026-11-10-09-00-00/run.changelog.xml", ((Element) includes.item(0)).getAttribute("file"));
		assertEquals("2026-11-10-11-00-00/run.changelog.xml", ((Element) includes.item(1)).getAttribute("file"));
		assertEquals("true", ((Element) includes.item(0)).getAttribute("relativeToChangelogFile"));
		assertEquals("true", ((Element) includes.item(1)).getAttribute("relativeToChangelogFile"));
		assertEquals(0, document.getElementsByTagNameNS(namespace, "changeSet").getLength());
		assertEquals(firstContents, Files.readString(directory.resolve(first)));
	}

	/**
	 * Enforces ISD's ID-only uniqueness rule even when authors differ, identifies
	 * the conflicting files and preserves the previous global changelog on failure.
	 */
	@Test
	public void rejectsDuplicateIdsWithoutReplacingPreviousGlobalChangelog() throws IOException {
		Path directory = temporaryFolder.newFolder().toPath();
		Path first = createXmlChangelog(directory, "2026-11-10-09-00-00", "duplicate", "firstAuthor");
		Path last = createXmlChangelog(directory, "2026-11-10-11-00-00", "duplicate", "otherAuthor");
		Path global = directory.resolve(ChangelogConstants.GLOBAL_CHANGELOG_FILE_NAME);
		Files.writeString(global, "previous global changelog");

		IOException error = assertThrows(IOException.class,
				() -> GlobalChangelogService.createGlobalChangelog(directory, List.of(first, last)));
		assertTrue(error.getMessage().contains("duplicate"));
		assertTrue(error.getMessage().contains(first.toString()));
		assertTrue(error.getMessage().contains(last.toString()));
		assertEquals("previous global changelog", Files.readString(global));
	}

	private Path createXmlChangelog(Path directory, String generation, String id, String author) throws IOException {
		createChangelog(directory, generation);
		Path changelog = Path.of(generation, ChangelogConstants.CHANGELOG_FILE_NAME);
		Files.writeString(directory.resolve(changelog), """
				<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
				    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-latest.xsd">
				    <changeSet id="%s" author="%s"><empty/></changeSet>
				</databaseChangeLog>
				""".formatted(id, author));
		return changelog;
	}

	private void createChangelog(Path directory, String generation) throws IOException {
		Path generationDirectory = Files.createDirectories(directory.resolve(generation));
		Files.writeString(generationDirectory.resolve(ChangelogConstants.CHANGELOG_FILE_NAME), "changelog contents");
	}
}
