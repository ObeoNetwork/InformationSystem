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
package org.obeonetwork.dsl.database.liquibasegen.handlers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Container;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.service.GlobalChangelogService;
import org.obeonetwork.dsl.database.liquibasegen.ui.GlobalChangelogSelectionWizard;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

/**
 * Merge changelog into a global changelog file
 *
 */
@SuppressWarnings("restriction")
public class GlobalChangelogHandler extends AbstractHandler {

	private Shell shell;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		shell = HandlerUtil.getActiveShell(event);

		Container databaseFolder = EventHelper.uwrapSingleSelection(event, Container.class);

		if (databaseFolder == null) {
			return null;
		}

		try {
			openChangelogSelectionWizard(databaseFolder);
		} catch (IOException e) {
			throw new ExecutionException(e.getMessage(), e);
		}

		return null;
	}

	private void openChangelogSelectionWizard(Container databaseFolder) throws IOException {
		Path databasePath = Paths.get(databaseFolder.getLocation().toOSString());
		List<String> changelogs = GlobalChangelogService.findChangelogs(databasePath).stream()
				.map(Path::toString).toList();
		WizardDialog dialog = new WizardDialog(shell,
				new GlobalChangelogSelectionWizard(changelogs, databasePath.toString()));
		dialog.create();
		dialog.open();
	}

}
