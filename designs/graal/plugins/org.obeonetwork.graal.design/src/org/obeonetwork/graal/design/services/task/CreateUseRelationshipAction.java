/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.task;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.design.ui.dialog.CreateUseRelationshipDialog;

/**
 * Class used to create a "Use" relationship between two AbstractTasks i.e between
 * - a Task and a Task
 * - a Task and a TasksGroup
 * - a TasksGroup and a Task
 * - a TasksGroup and a TasksGroup
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class CreateUseRelationshipAction {
	
	/**
	 * Creates the use relationship
	 * if TasksContainer are involved, a dialog opens up so that the user can choose the Tasks involved in the relationship
	 * @param context Object needed so the method can be called by Acceleo. It is returned unchanged
	 * @param sourceObject Source of the "use" relationship
	 * @param targetObject Target of the "use" relationship
	 * @return The first parameter without any change
	 */
	public EObject executeCreateUseRelationshipAction(EObject context, EObject sourceObject, EObject targetObject) {
		if (sourceObject instanceof Task && targetObject instanceof Task) {
			TaskUtils.instance.createTaskUseTaskEdge((Task)sourceObject, (Task)targetObject);
		} else {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			CreateUseRelationshipDialog dialog = new CreateUseRelationshipDialog(shell, sourceObject, targetObject);
			if (dialog.open() == IDialogConstants.OK_ID) {
				List<Task> sourceTasks = dialog.getSelectedTasksAsSource();
				List<Task> targetTasks = dialog.getSelectedTasksAsTarget();
				
				for (Task source : sourceTasks) {
					for (Task target : targetTasks) {
						TaskUtils.instance.createTaskUseTaskEdge(source, target);
					}
				}
			}
		}
		return context;
	}
}
