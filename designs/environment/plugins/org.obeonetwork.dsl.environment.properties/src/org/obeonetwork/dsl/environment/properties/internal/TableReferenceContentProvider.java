/*******************************************************************************
 * Copyright (c) 2019 Obeo.
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.environment.Annotation;

/**
 * The content provider for the table of the table widget.
 * 
 * @author gcoutable
 */
public class TableReferenceContentProvider implements IStructuredContentProvider {

	/**
	 * The EReference.
	 */
	private EReference eReference;

	/**
	 * The constructor.
	 *
	 * @param eReference
	 *            The EReference
	 */
	public TableReferenceContentProvider(EReference eReference) {
		this.eReference = eReference;
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
		if (inputElement instanceof EObject && ((EObject) inputElement).eClass().getEAllStructuralFeatures().contains(this.eReference)) {
			EObject eObject = (EObject) inputElement;
			Object values = eObject.eGet(eReference);
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
