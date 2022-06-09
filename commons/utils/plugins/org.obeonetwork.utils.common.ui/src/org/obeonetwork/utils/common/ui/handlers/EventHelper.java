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
package org.obeonetwork.utils.common.ui.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class EventHelper {
	
	public static <T> T uwrapSingleSelection(ExecutionEvent event, Class<T> type) throws ExecutionException {
		T selectedElement = null;
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

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

	public static <T> List<T> uwrapMultipleSelection(ExecutionEvent event, Class<T> type) throws ExecutionException {
		List<T> selectedElements = new ArrayList<>();
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

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
