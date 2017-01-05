/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
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

import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.design.ui.dialog.UserStoryDialog;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.command.AddUserStoryCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class AddUserStoryHandler extends AbstractHandler implements AddUserStoryCommand {

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
				UserStoryDialog dialog = new UserStoryDialog(HandlerUtil.getActiveShell(event));
				int open = dialog.open();
				if (open == Window.OK) {
					UserStory story = GraalFactory.eINSTANCE.createUserStory();
					story.setName(dialog.getName());
					story.setDescription(dialog.getDescription());
					Date createdOn = new Date();
					story.setCreatedOn(createdOn);
					story.setModifiedOn(createdOn);
					EObject eObject = EcoreUtil.getRootContainer(view.getInput().get(0));
					if (eObject instanceof org.obeonetwork.graal.System) {
						editingDomain.getCommandStack().execute(AddCommand.create(editingDomain, eObject, GraalPackage.eINSTANCE.getSystem_UserStories(), story));
						view.refresh();
					}
				}
			}
		}
		return null;
	}

}
