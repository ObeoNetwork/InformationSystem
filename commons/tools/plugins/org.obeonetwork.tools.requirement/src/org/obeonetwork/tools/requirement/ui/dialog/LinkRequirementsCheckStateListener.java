/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement.ui.dialog;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

/**
 * Listens for the check changes in {@link LinkRequirementsDialog}. Updates the
 * rest of the tree accordingly, e.g. if a {@link Category} is checked then all
 * its contents are checked.
 * 
 * @author Florent Latombe
 *         <a href= "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
public class LinkRequirementsCheckStateListener implements ICheckStateListener {

	/**
	 * {@inheritDoc}
	 * <ul>
	 * <li>When a {@link Requirement} is:
	 * <ul>
	 * <li>Checked:
	 * <ul>
	 * <li>Check and gray all its containers in the tree.</li>
	 * </ul>
	 * </li>
	 * <li>Unchecked:
	 * <ul>
	 * <li>Uncheck and ungray all its containers in the tree which have no more
	 * children which are checked in the tree.</li>
	 * </ul>
	 * </li>
	 * </ul>
	 * </li>
	 * <li>When a {@link Category}, {@link Repository} or {@link Resource} is:
	 * <ul>
	 * <li>Checked:
	 * <ul>
	 * <li>Check all its children in the tree.</li>
	 * <li>Gray all its children which are also containers in the tree.</li>
	 * <li>Check all its parents in the tree.</li>
	 * </ul>
	 * </li>
	 * <li>Unchecked:
	 * <ul>
	 * <li>Uncheck all its children in the tree.</li>
	 * <li>Ungray all its childre which are also containers in the tree.</li>
	 * <li>Uncheck and ungray all its containers in the tree which have no more
	 * children which are checked in the tree.</li>
	 * </ul>
	 * </li>
	 * </ul>
	 * </li>
	 * </ul>
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		CheckboxTreeViewer checkboxTreeViewer = (CheckboxTreeViewer) event.getSource();
		Object changedElement = event.getElement();
		boolean newCheckedState = event.getChecked();

		if (changedElement instanceof Requirement) {
			updateViewerForLeafChange(checkboxTreeViewer, (Requirement) changedElement, newCheckedState);
		} else if (isOfContainerType(changedElement)) {
			updateViewerForContainerChange(checkboxTreeViewer, changedElement, newCheckedState);
		}
	}

	/**
	 * 
	 * @param treeViewer
	 *            the {@link TreeViewer}.
	 * @return the {@link ITreeContentProvider} of {@code treeViewer}.
	 */
	private static ITreeContentProvider getTreeContentProvider(TreeViewer treeViewer) {
		IContentProvider contentProvider = treeViewer.getContentProvider();
		if (contentProvider instanceof ITreeContentProvider) {
			return (ITreeContentProvider) contentProvider;
		}
		throw new IllegalStateException(
				"Expected " + treeViewer.toString() + " to have an " + ITreeContentProvider.class.getSimpleName()
						+ ". Found: " + contentProvider.getClass().getSimpleName());
	}

	/**
	 * Updates the viewer when a {@link Requirement} has been checked or
	 * unchecked.
	 * 
	 * @param checkboxTreeViewer
	 * @param changedRequirement
	 * @param newCheckedState
	 */
	private static void updateViewerForLeafChange(CheckboxTreeViewer checkboxTreeViewer, Requirement changedRequirement,
			boolean newCheckedState) {
		if (newCheckedState) {
			// Requirement was just checked. Check and gray its containers
			// in the tree.
			checkAndGrayAllParents(checkboxTreeViewer, changedRequirement);
		} else {
			// Requirement was just unchecked. Uncheck and ungray its parents if
			// they have no children that's checked.
			unCheckAndUnGrayAllAppropriateParents(checkboxTreeViewer, changedRequirement);
		}
	}

	/**
	 * Unchecks and ungrays all parents which have no more children that's
	 * checked.
	 * 
	 * @param checkboxTreeViewer
	 * @param element
	 */
	private static void unCheckAndUnGrayAllAppropriateParents(CheckboxTreeViewer checkboxTreeViewer, Object element) {
		ITreeContentProvider contentProvider = getTreeContentProvider(checkboxTreeViewer);
		Object parent = contentProvider.getParent(element);
		while (parent != null
				&& !anyCheckedInViewer(Arrays.asList(contentProvider.getChildren(parent)), checkboxTreeViewer)) {
			checkboxTreeViewer.setGrayChecked(parent, false);
			parent = contentProvider.getParent(parent);
		}
	}

	/**
	 * 
	 * @param elements
	 * @param checkboxTreeViewer
	 * @return true if any element of {@code elements} is checked in
	 *         {@code checkboxTreeViewer}.
	 */
	private static boolean anyCheckedInViewer(List<Object> elements, CheckboxTreeViewer checkboxTreeViewer) {
		List<Object> checkedElements = Arrays.asList(checkboxTreeViewer.getCheckedElements());
		for (Object element : elements) {
			if (checkedElements.contains(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks and grays all the parents in {@code checkboxTreeViewer} of
	 * {@code element}.
	 * 
	 * @param checkboxTreeViewer
	 * @param element
	 */
	private static void checkAndGrayAllParents(CheckboxTreeViewer checkboxTreeViewer, Object element) {
		ITreeContentProvider contentProvider = getTreeContentProvider(checkboxTreeViewer);
		Object parent = contentProvider.getParent(element);
		do {
			checkboxTreeViewer.setGrayChecked(parent, true);
			parent = contentProvider.getParent(parent);
		} while (parent != null);
	}

	/**
	 * Updates the viewer when a {@link Category}, {@link Repository} or
	 * {@link Resource} has been checked or unchecked.
	 * 
	 * @param checkboxTreeViewer
	 * @param changedCategory
	 * @param newCheckedState
	 */
	private static void updateViewerForContainerChange(CheckboxTreeViewer checkboxTreeViewer, Object changedContainer,
			boolean newCheckedState) {
		if (newCheckedState) {
			// Category has just been checked. Gray it, then check all its
			// Requirements, check and gray all its child categories and their
			// contents.
			checkboxTreeViewer.setGrayed(changedContainer, true);
			updateAllChildrenAndGrayWhenAppropriate(checkboxTreeViewer, changedContainer, true);
			checkAndGrayAllParents(checkboxTreeViewer, changedContainer);
		} else {
			// Category has just been unchecked. Ungray it, then uncheck and
			// ungray its parents if they have no more children that's checked.
			checkboxTreeViewer.setGrayed(changedContainer, false);
			updateAllChildrenAndGrayWhenAppropriate(checkboxTreeViewer, changedContainer, false);
			unCheckAndUnGrayAllAppropriateParents(checkboxTreeViewer, changedContainer);
		}
	}

	/**
	 * Checks all the children of {@code element} in {@code checkboxTreeViewer}.
	 * Grays those that may have children. Then apply this behavior on its
	 * grandchildren.
	 * 
	 * @param checkboxTreeViewer
	 * @param element
	 */
	private static void updateAllChildrenAndGrayWhenAppropriate(CheckboxTreeViewer checkboxTreeViewer, Object element,
			boolean newValue) {
		ITreeContentProvider contentProvider = getTreeContentProvider(checkboxTreeViewer);
		for (Object child : Arrays.asList(contentProvider.getChildren(element))) {
			checkboxTreeViewer.setChecked(child, newValue);
			if (isOfContainerType(child)) {
				checkboxTreeViewer.setGrayed(child, newValue);
				updateAllChildrenAndGrayWhenAppropriate(checkboxTreeViewer, child, newValue);
			}
		}
	}

	/**
	 * 
	 * @param element
	 * @return true if {@code element} is of a type which, in
	 *         {@link LinkRequirementsDialog}, may have children.
	 */
	private static boolean isOfContainerType(Object element) {
		return element instanceof Category || element instanceof Repository || element instanceof Resource;
	}

}
