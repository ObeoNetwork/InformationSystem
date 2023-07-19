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
package org.obeonetwork.graal.design.ui.view.util;

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;

/**
 * @author Obeo
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
