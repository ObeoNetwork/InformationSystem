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
package org.obeonetwork.dsl.database.liquibasegen.ui;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;

/**
 * Recognizes workspace resources supported by the Liquibase menu actions.
 */
public class ChangelogResourcePropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		return switch (property) {
			case "isChangelogFile" -> isChangelogFile(receiver);
			case "isChangelogFolder" -> isChangelogFolder(receiver);
			default -> false;
		};
	}

	private boolean isChangelogFile(Object receiver) {
		return receiver instanceof IFile file && file.getName().endsWith("changelog.xml");
	}

	/**
	 * Recognizes {@code liquibase/<dbType>/<name>} using only the workspace hierarchy.
	 * No files are inspected, so an empty history folder is also accepted.
	 */
	private boolean isChangelogFolder(Object receiver) {
		if (!(receiver instanceof IFolder folder)
				|| !(folder.getParent() instanceof IFolder dbTypeFolder)) {
			return false;
		}

		IContainer liquibaseFolder = dbTypeFolder.getParent();
		return liquibaseFolder instanceof IFolder
				&& ChangelogConstants.LIQUIBASE_FOLDER_NAME.equals(liquibaseFolder.getName());
	}
}
