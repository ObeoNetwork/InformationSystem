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
package org.obeonetwork.dsl.requirement.design.comparators;

import java.util.Comparator;

import org.obeonetwork.dsl.requirement.Category;

/**
 * Comparator used to compare Categories based on their labels.
 * A category's label is the concatenation of its id and name.
 * @author Obeo
 *
 */
public class CategoryComparator implements Comparator<Category> {
	
	public static CategoryComparator INSTANCE = new CategoryComparator();

	public int compare(Category cat1, Category cat2) {
		String label1 = getCategoryLabel(cat1);
		String label2 = getCategoryLabel(cat2);
		return label1.compareToIgnoreCase(label2);
	}

	private String getCategoryLabel(Category category) {
		if (category != null) {
			return category.getId() + " - " + category.getName();
		}
		return null;
	}
}