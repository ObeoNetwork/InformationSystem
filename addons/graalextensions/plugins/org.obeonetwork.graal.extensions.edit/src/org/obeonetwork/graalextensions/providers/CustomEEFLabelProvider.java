/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.utils.EEFLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.table.metamodel.table.DLine;
import org.eclipse.swt.graphics.Image;

/**
 * Custom class used to provide the right label and image when plugging EEF properties views on a Viewpoint table
 * @author sthibaudeau
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
