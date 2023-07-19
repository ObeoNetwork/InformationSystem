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
package org.obeonetwork.graal.design.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.graal.TasksContainer;

/**
 * Content provider for tree viewers
 * Display TasksGroup and Task instances as a tree 
 * @author Obeo
 *
 */
public class TasksContentProvider implements ITreeContentProvider {

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getElements(Object inputElement) {
		return new Object[]{((RootElement)inputElement).getRoot()};
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TasksContainer) {
			TasksContainer container = (TasksContainer)parentElement;
			return container.getTasks().toArray();
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return (element instanceof TasksContainer) && !((TasksContainer)element).getTasks().isEmpty();
	}

}
