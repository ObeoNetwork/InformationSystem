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
package org.obeonetwork.dsl.requirement.parts.forms;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.utils.EEFLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

import org.eclipse.sirius.table.metamodel.table.DLine;

/**
 * Custom class used to provide the right label and image when plugging EEF properties views on a Viewpoint table
 * @author Obeo
 *
 */
public class CustomEEFLabelProvider extends EEFLabelProvider {

	@Override
	public Image getImage(Object element) {
		 Object unwrappedElement = unwrap(element);
		if (unwrappedElement instanceof DLine) {
			return super.getImage(((DLine)unwrappedElement).getTarget());
		}
		return super.getImage(unwrappedElement);
	}

	@Override
	public String getText(Object element) {
		Object unwrappedElement = unwrap(element);
		if (unwrappedElement instanceof DLine) {
			return super.getText(((DLine)unwrappedElement).getTarget());
		}
		return super.getText(unwrappedElement);
	}
	
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return unwrap(((IStructuredSelection)element).getFirstElement());
		}
		if (element instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)element).getAdapter(EObject.class);
			if (eObject != null) {
				return eObject;
			}
		}
		return element;
	}
	
}
