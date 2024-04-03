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

import org.obeonetwork.graal.design.ui.view.UserStoriesView;


/**
 * @author Obeo
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
