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
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.TreeRoot;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.extensionpoint.BoundableElementChildrenContributionsManager;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class DBoundElementContentProvider implements ITreeContentProvider {

	public DBoundElementContentProvider() {
		super();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof TreeRoot) {
			return new Object[] { ((TreeRoot) inputElement).getElement() };
		}
		return null;
	}

	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof DBoundElement) {
			DBoundElement boundElement = (DBoundElement) parentElement;
			if (boundElement.getChildren().isEmpty()) {
				List<DBoundElement> children = new ArrayList<DBoundElement>();
				EObject[] delegatedChildren = getDelegatedChildren(boundElement.getTarget());
				for (EObject object : delegatedChildren) {
					DBoundElement childBoundElement = BindingdialectFactory.eINSTANCE.createDBoundElement();
//					bindingEditor.getBoundElements().add(childBoundElement);
					childBoundElement.setParent(boundElement);
					childBoundElement.setTarget(object);
					children.add(childBoundElement);
				}
				boundElement.getChildren().clear();
				boundElement.getChildren().addAll(children);
			}
			return boundElement.getChildren().toArray();
		}
		return null;
	}

	private EObject[] getDelegatedChildren(EObject object) {
		return BoundableElementChildrenContributionsManager.getChildren(object);
	}

	public Object getParent(Object element) {
		if (element instanceof DBoundElement) {
			return ((DBoundElement) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);
		return (children != null && children.length > 0);
	}

}
