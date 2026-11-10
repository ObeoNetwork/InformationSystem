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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.service.GlobalChangelogService;
import org.obeonetwork.dsl.database.liquibasegen.ui.GlobalChangelogSelectionWizard;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

/**
 * Create a global changelog including selected generation histories
 *
 */
@SuppressWarnings("restriction")
public class GlobalChangelogHandler extends AbstractHandler {

	private Shell shell;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		shell = HandlerUtil.getActiveShell(event);

		Container changelogsFolder = EventHelper.uwrapSingleSelection(event, Container.class);

		if (changelogsFolder == null) {
			return null;
		}

		try {
			openChangelogSelectionWizard(changelogsFolder);
		} catch (IOException | CoreException e) {
			throw new ExecutionException(e.getMessage(), e);
		}

		return null;
	}

	private void openChangelogSelectionWizard(Container changelogsFolder) throws IOException, CoreException {
		Path changelogsDirectory = Paths.get(changelogsFolder.getLocation().toOSString());
		List<String> changelogs = GlobalChangelogService.findChangelogs(changelogsDirectory).stream()
				.map(Path::toString).toList();
		WizardDialog dialog = new WizardDialog(shell,
				new GlobalChangelogSelectionWizard(changelogs, changelogsDirectory.toString()));
		dialog.create();
		if (dialog.open() == Window.OK) {
			changelogsFolder.refreshLocal(IResource.DEPTH_ONE, null);
		}
	}

}
