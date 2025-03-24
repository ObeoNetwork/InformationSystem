/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.compare.viewer.filters;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

import com.google.common.base.Predicate;

public class SQLDifferencesFilter extends AbstractDifferenceFilter {
	
	/**
	 * The predicate use by this filter when it is selected.
	 */
	private static final Predicate<? super EObject> PREDICATE_WHEN_SELECTED = new Predicate<EObject>() {
		public boolean apply(EObject input) {	
			if (input instanceof TreeNode) {
				TreeNode node = (TreeNode) input;
				EObject data = node.getData();
				
				// We want to display a database rename
				if (data instanceof AttributeChange) {
					if (DatabasePackage.eINSTANCE.getNamedElement_Name() == ((AttributeChange) data).getAttribute()) {
						if (node.getParent() != null && node.getParent().getParent() == null) {
							// The node is just contained by the root node
							return false;
						}
					}
				}
				
				return !(data instanceof DBDiff)
						&& !(data instanceof Match);
			}
			return false;
		}
	};

	/**
	 * The predicate use by this filter when it is unselected.
	 */
	private static final Predicate<? super EObject> PREDICATE_WHEN_UNSELECTED = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			if (input instanceof TreeNode) {
				TreeNode node = (TreeNode) input;
				return node.getData() instanceof DBDiff;
			}
			return false;
		}
	};
	
	public SQLDifferencesFilter() {
	}

	@Override
	public Predicate<? super EObject> getPredicateWhenSelected() {
		return PREDICATE_WHEN_SELECTED;
	}

	@Override
	public Predicate<? super EObject> getPredicateWhenUnselected() {
		return PREDICATE_WHEN_UNSELECTED;
	}

	@Override
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return scope != null && scope.getNsURIs().stream().anyMatch("http://www.obeonetwork.org/dsl/database/1.0"::equals);
	}

}
