/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.command.impl;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.command.DeleteUserStoriesCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DeleteUserStoriesHandler extends AbstractHandler implements DeleteUserStoriesCommand {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if (activePart instanceof UserStoriesView) {
			UserStoriesView view = (UserStoriesView) activePart;
			
			boolean openConfirm = MessageDialog.openConfirm(view.getSite().getShell(),
					"Delete User Stories",
					"Delete the selected user stories ?");
			if (openConfirm == true) {
				EditingDomain editingDomain = view.getEditingDomain();
				if (editingDomain != null) {
					List<UserStory> selectedStories = view.getSelectedStories();
					editingDomain.getCommandStack().execute(DeleteCommand.create(editingDomain, selectedStories));
					view.refresh();
				}
			}
		}
		return null;
	}

}
