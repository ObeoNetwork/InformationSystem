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
package org.obeonetwork.dsl.database.liquibasegen;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * Constants shared by changelog generation and history discovery.
 */
public final class ChangelogConstants {

	/**
	 * Name of the changelog produced by a single generation.
	 */
	public static final String CHANGELOG_FILE_NAME = "run.changelog.xml"; //$NON-NLS-1$

	/**
	 * Formats and parses the timestamps used as generation directory names.
	 */
	public static final DateTimeFormatter GENERATION_TIMESTAMP_FORMAT = DateTimeFormatter
			.ofPattern("uuuu-MM-dd-HH-mm-ss").withResolverStyle(ResolverStyle.STRICT);

	private ChangelogConstants() {
	}
}
