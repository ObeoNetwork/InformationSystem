/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
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
