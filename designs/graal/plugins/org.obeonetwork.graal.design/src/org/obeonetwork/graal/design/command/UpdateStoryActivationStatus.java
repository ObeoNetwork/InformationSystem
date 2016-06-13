/**
 * 
 */
package org.obeonetwork.graal.design.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;
import org.obeonetwork.graal.design.services.configuration.UIConfigurationServices;

import org.eclipse.sirius.viewpoint.DAnalysis;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class UpdateStoryActivationStatus extends AbstractCommand {

	private UIConfiguration config;
	private UserStory story;
	private DAnalysis analysis;
	
	/**
	 * @param config
	 * @param story
	 */
	public UpdateStoryActivationStatus(DAnalysis analysis, UserStory story) {
		super();
		this.analysis = analysis;
		this.story = story;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		config = UIConfigurationServices.getUIConfiguration(analysis);
		return config != null;
	}



	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		if (config.getActiveUserStories().contains(story)) {
			config.getActiveUserStories().remove(story);
		} else {
			config.getActiveUserStories().clear();
			config.getActiveUserStories().add(story);
		}
		UIConfigurationServices.saveUIConfiguration(config, analysis);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		execute();
	}

}
