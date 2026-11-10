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

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.statushandlers.StatusManager;
import org.obeonetwork.dsl.database.liquibasegen.Activator;
import org.obeonetwork.dsl.database.liquibasegen.service.GlobalChangelogService;

/**
 * Coordinates changelog selection and global changelog generation.
 */
public class GlobalChangelogSelectionWizard extends Wizard {

	private final GlobalChangelogSelectionPage selectionPage;
	private final Path changelogsDirectory;

	/**
	 * @param changelogs history paths relative to the changelogs directory, in
	 *                   chronological order
	 * @param changelogsDirectory the directory containing the histories and the global
	 *                           changelog
	 */
	public GlobalChangelogSelectionWizard(List<Path> changelogs, Path changelogsDirectory) {
		setWindowTitle("Create global changelog");
		selectionPage = new GlobalChangelogSelectionPage(changelogs);
		this.changelogsDirectory = changelogsDirectory;
	}

	@Override
	public void addPages() {
		addPage(selectionPage);
	}

	@Override
	public boolean performFinish() {
		selectionPage.setErrorMessage(null);
		try {
			GlobalChangelogService.createGlobalChangelog(changelogsDirectory, selectionPage.getSelectedChangelogs());
			return true;
		} catch (IOException e) {
			selectionPage.setErrorMessage(e.getMessage());
			StatusManager.getManager().handle(new Status(IStatus.ERROR,
					Activator.PLUGIN_ID, e.getMessage(), e), StatusManager.LOG);
			return false;
		}
	}
}
