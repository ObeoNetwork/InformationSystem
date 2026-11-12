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
import org.eclipse.core.resources.IFolder;
import org.obeonetwork.dsl.database.liquibasegen.ChangelogConstants;

/**
 * Recognizes a changelog history folder at {@code liquibase/<type>/<name>}, regardless of
 * the project or history folder name. Only the workspace hierarchy is inspected,
 * so evaluating the menu does not scan files or require existing histories.
 */
public class ChangelogFolderPropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!"isChangelogFolder".equals(property) || !(receiver instanceof IFolder folder)
				|| !(folder.getParent() instanceof IFolder dbTypeFolder)) {
			return false;
		}
		IContainer liquibaseFolder = dbTypeFolder.getParent();
		return liquibaseFolder instanceof IFolder
				&& ChangelogConstants.LIQUIBASE_FOLDER_NAME.equals(liquibaseFolder.getName());
	}
}
