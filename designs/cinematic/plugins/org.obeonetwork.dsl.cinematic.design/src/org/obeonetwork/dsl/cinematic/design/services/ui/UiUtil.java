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
package org.obeonetwork.dsl.cinematic.design.services.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class UiUtil {
	public static Object getUserChoiceWithinList(String title, String message, Object[] elements, LabelProvider labelProvider) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				workbench.getActiveWorkbenchWindow().getShell(),
				labelProvider);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setBlockOnOpen(true);
		dialog.setElements(elements);
		dialog.open();
		Object[] results = dialog.getResult();
		if (results != null && results.length == 1) {
			return results[0];
		}
		return null;
	}
}
