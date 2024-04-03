/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
package org.obeonetwork.graal.design.ui.view.command.impl.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;
import org.obeonetwork.graal.design.ui.view.util.UserStoriesViewHelper;

/**
 * @author Obeo
 *
 */
public abstract class AbstractUserStoryTester extends PropertyTester {

	protected UserStoriesView getUserStoriesView() {
		return UserStoriesViewHelper.getView();
	}

}
