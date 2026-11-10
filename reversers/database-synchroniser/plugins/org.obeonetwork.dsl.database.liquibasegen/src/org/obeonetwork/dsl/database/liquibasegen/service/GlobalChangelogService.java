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

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;

import liquibase.changelog.ChangeLogInclude;
import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.exception.LiquibaseException;
import liquibase.parser.ChangeLogParserFactory;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.serializer.core.xml.XMLChangeLogSerializer;

/**
 * Provides changelog operations independently of the user interface.
 */
public final class GlobalChangelogService {

	private GlobalChangelogService() {
	}

	/**
	 * Finds changelogs in the timestamped directories immediately below the changelogs
	 * directory. The current changelog copy at the root is excluded.
	 *
	 * @param changelogsDirectory the directory containing the generation history
	 * @return an immutable list of paths relative to the changelogs directory, ordered
	 *         by increasing generation timestamp
	 * @throws IOException if the changelogs directory cannot be listed or a generation
	 *                     cannot be inspected
	 */
	public static List<Path> findChangelogs(Path changelogsDirectory) throws IOException {
		List<Path> changelogs = new ArrayList<>();
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(changelogsDirectory)) {
			for (Path entry : entries) {
				if (!isGenerationTimestamp(entry.getFileName().toString())
						|| !Files.readAttributes(entry, BasicFileAttributes.class).isDirectory()) {
					continue;
				}
				Path changelog = entry.resolve(ChangelogConstants.CHANGELOG_FILE_NAME);
				try {
					if (Files.readAttributes(changelog, BasicFileAttributes.class).isRegularFile()) {
						changelogs.add(changelogsDirectory.relativize(changelog));
					}
				} catch (NoSuchFileException e) {
					// A generation without a changelog is not a candidate.
				}
			}
		} catch (DirectoryIteratorException e) {
			throw e.getCause();
		}
		changelogs.sort(Comparator.comparing(changelog -> LocalDateTime.parse(changelog.getParent().toString(),
				ChangelogConstants.GENERATION_TIMESTAMP_FORMAT)));
		return List.copyOf(changelogs);
	}

	/**
	 * Creates or replaces the global changelog with relative inclusions of the
	 * selected histories, ordered by generation timestamp. IDs must be unique across
	 * the selected files, regardless of author. Sources are never modified.
	 *
	 * @param changelogsDirectory the directory containing the generation history
	 * @param selectedChangelogs relative paths returned by {@link #findChangelogs(Path)}
	 * @return the path of the generated global changelog
	 * @throws IOException if the selection is empty or invalid, an ID is repeated,
	 *                     or a file cannot be read or written
	 */
	public static Path createGlobalChangelog(Path changelogsDirectory, List<Path> selectedChangelogs) throws IOException {
		if (selectedChangelogs.isEmpty()) {
			throw new IOException("No changelog selected.");
		}
		List<Path> changelogs = new ArrayList<>(selectedChangelogs);
		changelogs.sort(Comparator.comparing(changelog -> LocalDateTime.parse(changelog.getParent().toString(),
				ChangelogConstants.GENERATION_TIMESTAMP_FORMAT)));

		FileSystemResourceAccessor accessor = new FileSystemResourceAccessor(changelogsDirectory.toFile());
		Map<String, Path> ids = new HashMap<>();
		List<ChangeLogInclude> includes = new ArrayList<>();
		for (Path changelog : changelogs) {
			checkChangelogIds(accessor, changelog, ids);
			ChangeLogInclude include = new ChangeLogInclude();
			include.setFile(changelog.toString().replace('\\', '/'));
			include.setRelativeToChangelogFile(true);
			includes.add(include);
		}

		Path globalPath = changelogsDirectory.resolve(ChangelogConstants.GLOBAL_CHANGELOG_FILE_NAME);
		writeGlobalChangelog(includes, globalPath);
		return globalPath;
	}

	/**
	 * Reads one changelog with the Liquibase parser, including XML schema validation,
	 * and records each changeSet ID with its selected source path in
	 * {@code ids}, which accumulates IDs across the selected files. IDs must be
	 * nonblank and unique regardless of author or source file, as required by ISD.
	 * This is stricter than Liquibase's path, ID and author identity.
	 *
	 * @throws IOException if Liquibase cannot read or validate the changelog,
	 *                     or an ID is blank or already recorded. The map may already
	 *                     contain IDs from this file when the check fails.
	 */
	private static void checkChangelogIds(FileSystemResourceAccessor accessor, Path changelog,
			Map<String, Path> ids) throws IOException {
		DatabaseChangeLog parsedChangelog;
		String changelogPath = changelog.toString().replace('\\', '/');
		try {
			parsedChangelog = ChangeLogParserFactory.getInstance().getParser(changelogPath, accessor)
					.parse(changelogPath, new ChangeLogParameters(), accessor);
		} catch (LiquibaseException e) {
			throw new IOException("Unable to read changelog '" + changelog + "': " + e.getMessage(), e);
		}
		for (ChangeSet changeSet : parsedChangelog.getChangeSets()) {
			String id = changeSet.getId();
			if (id.isBlank()) {
				throw new IOException("Missing changeSet ID in changelog '" + changelog + "'.");
			}
			Path previousChangelog = ids.putIfAbsent(id, changelog);
			if (previousChangelog != null) {
				throw new IOException("Duplicate changeSet ID '" + id + "' in '" + previousChangelog + "' and '" + changelog + "'.");
			}
		}
	}

	/**
	 * Serializes the inclusions with Liquibase to a temporary XML file alongside the
	 * destination before replacing the previous global changelog. Replacement is
	 * atomic when supported by the file system, with a regular replacement as a
	 * fallback. Cleanup of the temporary file is attempted even if writing or moving fails.
	 * Call only after all selected changelogs have passed validation.
	 */
	private static void writeGlobalChangelog(List<ChangeLogInclude> includes, Path globalPath) throws IOException {
		Path temporaryPath = Files.createTempFile(globalPath.getParent(), ".global-changelog-", ".xml");
		try {
			try (OutputStream output = Files.newOutputStream(temporaryPath)) {
				new XMLChangeLogSerializer().write(includes, output);
			}
			try {
				Files.move(temporaryPath, globalPath, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
			} catch (AtomicMoveNotSupportedException e) {
				Files.move(temporaryPath, globalPath, StandardCopyOption.REPLACE_EXISTING);
			}
		} finally {
			Files.deleteIfExists(temporaryPath);
		}
	}

	private static boolean isGenerationTimestamp(String name) {
		try {
			LocalDateTime.parse(name, ChangelogConstants.GENERATION_TIMESTAMP_FORMAT);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
