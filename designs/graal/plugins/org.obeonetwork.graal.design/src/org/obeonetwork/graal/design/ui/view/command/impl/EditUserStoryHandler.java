/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.command.impl;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.design.ui.dialog.UserStoryDialog;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.command.EditUserStoryCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EditUserStoryHandler extends AbstractHandler implements EditUserStoryCommand {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if (activePart instanceof UserStoriesView) {
			UserStoriesView view = (UserStoriesView) activePart;
			EditingDomain editingDomain = view.getEditingDomain();
			if (editingDomain != null) {
				UserStory userStory = view.getSelectedStories().get(0);
				UserStoryDialog dialog = new UserStoryDialog(HandlerUtil.getActiveShell(event), userStory);
				int open = dialog.open();
				if (open == Window.OK) {
					CompoundCommand cc = new CompoundCommand();
					cc.append(SetCommand.create(editingDomain, userStory, GraalPackage.eINSTANCE.getNamedElement_Name(), dialog.getName()));
					cc.append(SetCommand.create(editingDomain, userStory, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(), dialog.getDescription()));
					editingDomain.getCommandStack().execute(cc);
					view.refresh();
				}
			}
		}
		return null;
	}

}
