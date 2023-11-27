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
package org.obeonetwork.utils.common.ui.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public class SelectionHelper {

	public static <T> T uwrapSingleSelection(ISelection selection, Class<T> type) {
		T selectedElement = null;
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			Iterator<?> selectionIteratror = structuredSelection.iterator();
			if (selectionIteratror.hasNext()) {
				Object selectedObject = selectionIteratror.next();
				if (type.isInstance(selectedObject)) {
					selectedElement = type.cast(selectedObject);
				}				
			}
		}
		return selectedElement;
	}

	public static <T> List<T> uwrapMultipleSelection(ISelection selection, Class<T> type) {
		List<T> selectedElements = new ArrayList<>();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			Iterator<?> selectionIteratror = structuredSelection.iterator();
			while (selectionIteratror.hasNext()) {
				Object selectedObject = selectionIteratror.next();
				if (type.isInstance(selectedObject)) {
					selectedElements.add(type.cast(selectedObject));
				}				
			}
		}
		return selectedElements;
	}
	
}
