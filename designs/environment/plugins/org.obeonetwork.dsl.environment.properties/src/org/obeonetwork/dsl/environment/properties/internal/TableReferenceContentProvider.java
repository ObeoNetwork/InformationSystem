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
package org.obeonetwork.dsl.environment.properties.internal;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.properties.ui.eef.widget.TableController;

/**
 * The content provider for the table of the table widget.
 * 
 * @author gcoutable
 */
public class TableReferenceContentProvider implements IStructuredContentProvider {

	/**
	 * The EReference.
	 */
	private TableController tableController;

	/**
	 * The constructor.
	 *
	 * @param controller
	 *            The EReference
	 */
	public TableReferenceContentProvider(TableController controller) {
		this.tableController = controller;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EObject && ((EObject) inputElement).eClass().getEAllStructuralFeatures().contains(this.tableController.getReference())) {
			EObject eObject = (EObject) inputElement;
			Object values = eObject.eGet(tableController.getReference());
			if (values instanceof Collection<?>) {
				Collection<?> collections = (Collection<?>) values;
				return collections.stream().filter(Annotation.class::isInstance).toArray();
			}
		}
		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// do nothing
	}

}
