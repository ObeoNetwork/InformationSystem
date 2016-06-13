/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.command.impl.tester;

import org.obeonetwork.graal.design.ui.view.UserStoriesView;


/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class AddUserStoryTester extends AbstractUserStoryTester {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		UserStoriesView view = getUserStoriesView();
		if (view != null) {
			return view.getEditingDomain() != null;
		}
		return false;
	}

}
