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
package org.obeonetwork.dsl.environment.design.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class VersionService {

	/**
	 * This service opens a dialog asking the user if he really want to increment the feature 'version' of the given {@link context}.
	 * If the answer is affirmative the incremented 'version' is returned, otherwise the original 'version' is returned.
	 * 
	 * If the given {@link context} is not a {@link Task} or a {@link Requirement}, 0 is returned and no dialog is opened.
	 * 
	 */
	public int incrementVersion(EObject context) {

		if(!hasVersion(context)) {
			return 0;
		}
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		boolean increment = MessageDialog.openQuestion(shell, "Increment version number",
				"Are you really sure you want to increment the version number ?\n"
						+ "Version number should be incremented only on major modifications.");
		if (increment == true) {
			int newVersion = getVersion(context) + 1;
			return newVersion;
		}

		return getVersion(context);
	}
	
	protected boolean hasVersion(EObject object) {
		return "Task".equals(object.eClass().getName()) || "Requirement".equals(object.eClass().getName());
	}
	
	protected int getVersion(EObject object) {
		EStructuralFeature versionFeature = object.eClass().getEStructuralFeature("version");
		return (int) object.eGet(versionFeature);
	}
}
