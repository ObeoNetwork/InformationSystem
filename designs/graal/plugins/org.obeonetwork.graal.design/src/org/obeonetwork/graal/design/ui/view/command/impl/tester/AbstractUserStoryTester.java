/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.command.impl.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.util.UserStoriesViewHelper;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AbstractUserStoryTester extends PropertyTester {

	protected UserStoriesView getUserStoriesView() {
		return UserStoriesViewHelper.getView();
	}

}
