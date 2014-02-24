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
package org.obeonetwork.graal.design.services.use;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;

/**
 * Services to retrieve elements used to draw "Use" relationships
 * between tasks, tasksgroups and systems
 * @author sthibaudeau
 *
 */
public class UseReferencesServices {
	
	/**
	 * Retrieves the tasks, groups and systems used from a container
	 * to know which nodes should be linked by "use" references
	 * @param container System or TasksGroup
	 * @return list of linked elements
	 */
	public Set<EObject> getUsedSystemsAndTasksAndGroups(TasksContainer container) {
		Set<EObject> usedSystemsAndTasksAndGroups = getUsedSystemsAndTasksAndGroups((TasksContainer)container.eContainer(), container);
		usedSystemsAndTasksAndGroups.remove(container);
		return usedSystemsAndTasksAndGroups;
	}
	
	/**
	 * Retrieves the tasks, groups and systems used from a task
	 * to know which nodes should be linked by "use" references
	 * @param task Using task
	 * @return list of linked elements
	 */
	public Set<EObject> getUsedSystemsAndTasksAndGroups(Task task) {
		Set<EObject> usedSystemsAndTasksAndGroups = getUsedSystemsAndTasksAndGroups((TasksContainer)task.eContainer(), task);
		usedSystemsAndTasksAndGroups.remove(task);
		return usedSystemsAndTasksAndGroups;
	}
	
	/**
	 * Retrieves the tasks, groups and systems used from a container
	 * to know which nodes should be linked by "use" references
	 * @param context TasksContainer used to compute which elements would be visible
	 * @param container System or TasksGroup
	 * @return list of linked elements
	 */
	private Set<EObject> getUsedSystemsAndTasksAndGroups(TasksContainer context, TasksContainer container) {
		Set<EObject> usedElements = new LinkedHashSet<EObject>();
		for (Task childTask : container.getOwnedTasks()) {
			usedElements.addAll(getUsedSystemsAndTasksAndGroups(context, childTask));
		}
		for (TasksGroup childGroup : container.getOwnedGroups()) {
			usedElements.addAll(getUsedSystemsAndTasksAndGroups(context, childGroup));
		}
		return usedElements;
	}

	/**
	 * Retrieves the tasks, groups and systems used from a task
	 * to know which nodes should be linked by "use" references
	 * @param context TasksContainer used to compute which elements would be visible
	 * @param task Using task
	 * @return list of linked elements
	 */
	private Set<EObject> getUsedSystemsAndTasksAndGroups(TasksContainer context, Task task) {
		Set<EObject> usedElements = new LinkedHashSet<EObject>();
		for (Task usedTask : task.getUses()) {
			// First, check if the used task is contained by the context
			if (EcoreUtil.isAncestor(context, task)) {
				// In the same context
				
				// Check if the used task is directly contained by the specified container
				if (context.equals(usedTask.eContainer())) {
					usedElements.add(usedTask);
				} else {
					usedElements.add(usedTask);
					// We have to find the container directly contained by the context
					boolean found = false;
					EObject container = usedTask.eContainer();
					while (!found && container != null) {
						if (context.equals(container.eContainer())) {
							usedElements.add(container);
							found = true;
						}
						container = container.eContainer();
					}
				}
			} else {
				// Not in the same context
				//usedElements.add(usedTask);
			}
		}
		return usedElements;
	}
	
}
