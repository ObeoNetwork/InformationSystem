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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.command.HighlightUserStoryCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * 
 */
public class HighlightUserStoryHandler extends AbstractHandler implements IElementUpdater, HighlightUserStoryCommand {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if (activePart instanceof UserStoriesView) {
			UserStoriesView view = (UserStoriesView) activePart;
			view.updateUserStoryHighlightment();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.commands.IElementUpdater#updateElement(org.eclipse.ui.menus.UIElement, java.util.Map)
	 */
	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		State state = service.getCommand(HighlightUserStoryCommand.COMMAND_ID).getState(HighlightUserStoryCommand.STATE_ID);
		element.setChecked((Boolean) state.getValue());
	}

}
