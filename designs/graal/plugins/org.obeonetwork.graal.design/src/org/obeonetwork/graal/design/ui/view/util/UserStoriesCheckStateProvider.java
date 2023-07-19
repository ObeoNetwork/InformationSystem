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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.UserStory;

/**
 * @author Obeo
 *
 */
public class UserStoriesCheckStateProvider implements ICheckStateProvider {

	private CheckboxTreeViewer viewer;

	public UserStoriesCheckStateProvider(CheckboxTreeViewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ICheckStateProvider#isChecked(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean isChecked(Object element) {
		if (element instanceof UserStory) {
			UserStory story = (UserStory) element;
			if (viewer.getInput() instanceof Collection<?>) {
				Collection<EObject> selection = (Collection<EObject>) viewer.getInput();
				for (EObject eObject : selection) {
					if (eObject instanceof GraalObject) {
						if (((GraalObject)eObject).isConcernedByUserStory(story)) {
							return true;
						}
					}
				}

			} else {
				if (viewer.getInput() instanceof GraalObject) {
					return ((GraalObject)viewer.getInput()).isConcernedByUserStory(story);
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ICheckStateProvider#isGrayed(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean isGrayed(Object element) {
		if (element instanceof UserStory) {
			UserStory story = (UserStory) element;
			if (viewer.getInput() instanceof Collection<?>) {
				Collection<EObject> selection = (Collection<EObject>) viewer.getInput();
				for (EObject eObject : selection) {
					if (eObject instanceof GraalObject) {
						if (!((GraalObject)eObject).isConcernedByUserStory(story)) {
							return true;
						}
					}
				}
			} 
		}
		return false;
	}

}
