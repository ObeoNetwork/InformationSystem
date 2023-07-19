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
package org.obeonetwork.graal.design.services.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Class used to display messages to the user
 * @author Obeo
 *
 */
public class MessageServices {

	/**
	 * Display the provided message as an information to the user
	 * @param context Parameter needed so the method can be called by Acceleo
	 * @param title Title of the dialog
	 * @param message Message displayed inside the dialog
	 * @return the unmodified "context" parameter
	 */
	public EObject displayInfo(EObject context, String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, message);
		return context;
	}
}
