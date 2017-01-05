/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.design.selection;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.design.provider.CategoriesTreeContentProvider;
import org.obeonetwork.dsl.requirement.design.provider.RequirementLabelProvider;

/**
 * Dialog used to select a category within the whole Sirius session
 * Categories can be hidden.
 * @author sthibaudeau
 *
 */
public class CategorySelectionDialog extends ElementTreeSelectionDialog {

	public CategorySelectionDialog(Shell shell, String title, String message, Category... hiddenCategories) {
		this(shell, title, message, Arrays.asList(hiddenCategories));
	}
	
	public CategorySelectionDialog(Shell shell, String title, String message, Collection<Category> hiddenCategories) {
		super(shell, new RequirementLabelProvider(), new CategoriesTreeContentProvider(hiddenCategories));
		setTitle(title);
		setMessage(message);
		setAllowMultiple(false);
		setHelpAvailable(false);
	}

}
