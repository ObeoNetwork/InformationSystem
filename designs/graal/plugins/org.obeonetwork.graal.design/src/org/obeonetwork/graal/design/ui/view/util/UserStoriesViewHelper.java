/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.util;

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class UserStoriesViewHelper {
	
	
	public static UserStoriesView getView() {
		if (PlatformUI.getWorkbench() != null 
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null 
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			IViewReference[] viewReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
			for (IViewReference iViewReference : viewReferences) {
				if (iViewReference.getId().equals(UserStoriesView.ID)) {
					return (UserStoriesView) iViewReference.getPart(false);
				}
			}
		}
		return null;
	}

}
