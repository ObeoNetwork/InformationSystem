/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.UserStoryElement;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class UnlinkStory extends AbstractCommand {

	private UserStory story;
	private List<UserStoryElement> elements;
	
	/**
	 * @param story
	 * @param element
	 */
	public UnlinkStory(UserStory story, UserStoryElement element) {
		super();
		this.story = story;
		this.elements = new ArrayList<UserStoryElement>();
		elements.add(element);
	}

	/**
	 * @param story
	 * @param elements
	 */
	public UnlinkStory(UserStory story, List<UserStoryElement> elements) {
		super();
		this.story = story;
		this.elements = elements;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		for (UserStoryElement element : elements) {
			((GraalObject)element).detachFromUserStory(story);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		execute();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		for (UserStoryElement element : elements) {
			((GraalObject)element).attachToUserStory(story);
		}
	}

}
