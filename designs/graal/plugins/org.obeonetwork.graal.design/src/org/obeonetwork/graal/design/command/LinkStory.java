/**
 * 
 */
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
public class LinkStory extends AbstractCommand {

	private UserStory story;
	private List<UserStoryElement> elements;
	
	/**
	 * @param story
	 * @param element
	 */
	public LinkStory(UserStory story, UserStoryElement element) {
		super();
		this.story = story;
		this.elements = new ArrayList<UserStoryElement>();
		elements.add(element);
	}

	/**
	 * @param story
	 * @param elements
	 */
	public LinkStory(UserStory story, List<UserStoryElement> elements) {
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
			((GraalObject)element).attachToUserStory(story);
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
			((GraalObject)element).detachFromUserStory(story);
		}
	}

}
