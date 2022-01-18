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
package org.obeonetwork.graal.design.services.requirements;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;

/**
 * Utilities services concerning Requirements
 * 
 * @author jdupont
 * 
 */
public class RequirementsUtils {

	/**
	 * Return the linked Task if exist using the "asTask" service
	 * 
	 * @param context
	 *            the context on which is applied the service
	 * @return the related task, null otherwise
	 */
	public Task relatedTask(Requirement context) {
		for (EObject object : context.getReferencedObject()) {
			Task asTask = asTask(object);
			if (asTask != null) {
				return asTask;
			}
		}
		return null;
	}

	/**
	 * Try to interpret an object as a Task
	 * - return this if the object is a Task
	 * - Up the containing hierarchy to find a Task
	 * - null otherwise
	 * 
	 * @param context the context on which is applied the service
	 * @return a task if task is find null otherwise
	 */
	public Task asTask(EObject context) {
		if (context instanceof Task) {
			return (Task) context;
		}
		EObject container = context.eContainer();
		if (container != null) {
			return asTask(container);
		}
		return null;
	}

	/**
	 * Return the related Use case
	 * 
	 * @param context the context on which is applied the service
	 * @return useCase if useCase is found null otherwise
	 */
	public UseCase relatedUseCase(Requirement context) {
		for (EObject object : context.getReferencedObject()) {
			UseCase asUseCase = asUseCase(object);
			if (asUseCase != null) {
				return asUseCase;
			}
		}
		return null;
	}

	/**
	 * Try to interpret an object as an UseCase
	 * - return this if the object is a UseCase
	 * - return the UseCase associated to the group if the referencedObject can be interpreted as a group
	 * - return the UseCase associated to the task if the referencedObject can be interpreted as a task
	 * - null otherwise
	 * 
	 * @param context The context on which is applied the service
	 * @return the useCase, if a useCase is find, null otherwise
	 */
	public UseCase asUseCase(EObject context) {
		if (context instanceof UseCase) {
			return (UseCase) context;
		} else if (context instanceof TasksGroup) {
			return ((TasksGroup) context).getUseCase();
		} else {
			Task asTask = asTask(context);
			if (asTask != null) {
				return asTask.getUseCase();
			}
		}
		return null;
	}
}