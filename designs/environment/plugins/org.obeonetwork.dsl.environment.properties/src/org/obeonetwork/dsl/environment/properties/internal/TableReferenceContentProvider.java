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
package org.obeonetwork.dsl.environment.properties.internal;

import java.util.Collection;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.environment.properties.ui.eef.widget.TableController;

/**
 * The content provider for the table of the table widget.
 * 
 * @author Obeo
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
			Predicate<Object> preconditionPredicate = this.tableController.getPreconditionPredicate();
			EObject eObject = (EObject) inputElement;
			Object values = eObject.eGet(tableController.getReference());
			if (values instanceof Collection<?>) {
				Collection<?> collections = (Collection<?>) values;
				if (preconditionPredicate != null) {
					return collections.stream().filter(preconditionPredicate).toArray();	
				} else {
					return collections.stream().toArray();					
				}
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
