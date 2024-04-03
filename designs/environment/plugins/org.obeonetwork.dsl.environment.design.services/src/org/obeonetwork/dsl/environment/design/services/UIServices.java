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
package org.obeonetwork.dsl.environment.design.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class UIServices {

	private static final String ERROR = "ERROR";
	private static final String WARNING = "WARNING";
	private static final String INFO = "INFO";
	
	public EObject displayWarningDropNamespaceOnChild(EObject context) {
		return displayWarning(context, "Drop namespace", "A namespace can not be dropped onto itself or one of its children.");
	}

	public EObject displayInfo(EObject context, String title, String message) {
		return displayMessage(context, INFO, title, message);
	}
	
	public EObject displayWarning(EObject context, String title, String message) {
		return displayMessage(context, WARNING, title, message);
	}
	
	public EObject displayError(EObject context, String title, String message) {
		return displayMessage(context, ERROR, title, message);
	}
	
	public EObject displayMessage(EObject context, String severity, String title, String message) {
		if (INFO.equals(severity)) {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message);
		} else if (WARNING.equals(severity)) {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), title, message);
		} else if (ERROR.equals(severity)) {
			MessageDialog.openError(Display.getDefault().getActiveShell(), title, message);
		}
		return context;
	}
}
