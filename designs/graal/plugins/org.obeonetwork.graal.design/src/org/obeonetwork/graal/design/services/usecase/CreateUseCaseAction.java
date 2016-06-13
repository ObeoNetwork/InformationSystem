/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.usecase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.design.services.task.TaskUtils;

import org.eclipse.sirius.diagram.AbstractDNode;

/**
 * Class used to create a new Use case from selected asks or tasksGroups
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class CreateUseCaseAction {
	
	/**
	 * Checks if the use case creation can be done
	 * @param context EObject needed so the method can be called by Acceleo
	 * @param selections Graphical elements selected by the user before invoking the action
	 * @return True
	 */
	public boolean canExecuteCreateUseCaseAction(EObject context, Collection<? extends EObject> selections) {
		// The action can be executed even if no task has been selected
		return true;
	}

	/**
	 * creates a new use case from selected Task and TasksGroup instances
	 * @param context EObject needed so the method can be called by Acceleo
	 * @param selections Graphical elements selected by the user before invoking the action
	 * @return unmodified "context" parameter
	 */
	public EObject executeCreateUseCaseAction(EObject context, Collection<? extends EObject> selections) {
		
		// Filter the selections to retrieve only the Tasks
		List<AbstractTask> tasks = extractTasks(selections);
		String suggestedName = "UC - " + TaskUtils.instance.computeNameFromTasks(tasks);
		
		InputDialog enterNameDialog = new InputDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
														"Creating an use case",
														"Enter a name for the Use Case",
														suggestedName,
														null);
		enterNameDialog.open();
		int returnCode = enterNameDialog.getReturnCode();
		
		if (returnCode == InputDialog.OK && tasks.size() > 0) {

			// Get the containing System
			System system = tasks.get(0).getContainingSystem();
			
			// Create a new Use Case
			UseCase useCase = GraalFactory.eINSTANCE.createUseCase();
			Date createdOn = new Date();
			useCase.setCreatedOn(createdOn);
			useCase.setModifiedOn(createdOn);
			useCase.getTasks().addAll(tasks);
			useCase.setName(enterNameDialog.getValue());
			system.getUseCases().add(useCase);
			return useCase;
		}
		
		return null;
	}

	/**
	 * Extracts Task and TasksGroup instance from a collection of selected graphical elements
	 * @param selections Graphical elements selected by the user
	 * @return List of Task and TasksGroup instances pointed by the graphical elements
	 */
	private List<AbstractTask> extractTasks(Collection<? extends EObject> selections) {
		List<AbstractTask> tasks = new ArrayList<AbstractTask>();
		for (EObject selection : selections) {
			if (selection instanceof AbstractDNode) {
				EObject target = ((AbstractDNode)selection).getTarget();
				if (target instanceof AbstractTask) {
					tasks.add((AbstractTask)target);
				}
			}
		}
		return tasks;
	}
}
