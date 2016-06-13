/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.decoration;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.swt.graphics.Color;
import org.obeonetwork.graal.UserStory;

/**
 * Decorator for edges to display User Story information
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class UserStoryEdgeDecorator extends AbstractUserStoryDecorator {

	private Color normalColor = null;
	protected NotificationListener notificationListener = new NotificationListener() {
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		public void notifyChanged(Notification notification) {
			// on each notification, just refresh the decorator.
			refresh();
		}
	};
	
	protected UserStoryEdgeDecorator(IDecoratorTarget target) {
		super(target);
		// Store the normal color so we can set it back when the user story is deactivated
		normalColor = getTargetEditPart().getFigure().getForegroundColor();
	}
	
	/**
	 * Refresh the decorator
	 * this method is called from the parent's refresh() method
	 */
	@Override
	public void doRefresh() {
		removeDecoration();
		if (isConcernedByActiveUserStory()) {
			setDecoration(getDecoratorTarget().addDecoration(new Figure(), new UserStoryEdgeLocator(), false));
			UserStory userStory = getActiveUserStories().get(0);
			getTargetEditPart().getFigure().setForegroundColor(pickColor(userStory));
		} else {
			getTargetEditPart().getFigure().setForegroundColor(normalColor);
		}
	}
	
	/**
	 * Locator used to refresh the edge when needed
	 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
	 *
	 */
	private class UserStoryEdgeLocator implements Locator {
	
		public void relocate(IFigure target) {
			if (isConcernedByActiveUserStory()) {
				UserStory userStory = getActiveUserStories().get(0);
				getTargetEditPart().getFigure().setForegroundColor(pickColor(userStory));
			} else {
				getTargetEditPart().getFigure().setForegroundColor(normalColor);
			}
		}
	}
}
