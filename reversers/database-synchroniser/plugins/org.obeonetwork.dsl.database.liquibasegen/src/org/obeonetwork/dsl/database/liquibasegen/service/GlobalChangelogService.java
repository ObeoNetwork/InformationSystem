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
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;

/**
 * Provides changelog operations independently of the user interface.
 */
public final class GlobalChangelogService {

	private GlobalChangelogService() {
	}

	/**
	 * Finds changelogs in the timestamped directories immediately below a database
	 * directory. The current changelog copy at the root is excluded.
	 *
	 * @param databasePath the directory containing the generation history
	 * @return an immutable list of paths relative to the database directory, ordered
	 *         by increasing generation timestamp
	 * @throws IOException if the database directory cannot be listed or a generation
	 *                     cannot be inspected
	 */
	public static List<Path> findChangelogs(Path databasePath) throws IOException {
		List<Path> changelogs = new ArrayList<>();
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(databasePath)) {
			for (Path entry : entries) {
				if (!isGenerationTimestamp(entry.getFileName().toString())
						|| !Files.readAttributes(entry, BasicFileAttributes.class).isDirectory()) {
					continue;
				}
				Path changelog = entry.resolve(ChangelogConstants.CHANGELOG_FILE_NAME);
				try {
					if (Files.readAttributes(changelog, BasicFileAttributes.class).isRegularFile()) {
						changelogs.add(databasePath.relativize(changelog));
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

	private static boolean isGenerationTimestamp(String name) {
		try {
			LocalDateTime.parse(name, ChangelogConstants.GENERATION_TIMESTAMP_FORMAT);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
