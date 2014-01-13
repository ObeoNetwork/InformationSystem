/*******************************************************************************
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.design.services.util.DeleteUtils;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

/**
 * Utilities services concerning Tasks and TasksGroups
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class TaskUtils {
	
	/**
	 * Static instance to be used when calling services from another class 
	 */
	public static TaskUtils instance = new TaskUtils();
	
	/**
	 * Deletes a whole System including its own Tasks, TasksGroups and SubSystems
	 * @param system System to delete
	 */
	public void deleteSystem(System system) {
		// Delete all tasks and groups
		deleteChildrenTasksAndTasksGroups(system);
		
		// Delete all subsystems
		List<System> subSystems = new ArrayList<System>(system.getSubSystems());
		for (System subSystem : subSystems) {
			deleteSystem(subSystem);
		}
		DeleteUtils.delete(system);
	}
	
	/**
	 * Deletes a whole TasksGroup including its own Tasks and sub-groups
	 * @param group
	 */
	public void deleteTasksGroup(TasksGroup group) {
		deleteChildrenTasksAndTasksGroups(group);
		DeleteUtils.delete(group);
	}
	
	/**
	 * Deletes the children tasks and groups in a TasksContainer
	 * @param container
	 */
	public void deleteChildrenTasksAndTasksGroups(TasksContainer container) {
		// Deletion of sub-groups
		List<TasksGroup> childrenGroups = new ArrayList<TasksGroup>(container.getOwnedGroups()); 
		for (TasksGroup childGroup : childrenGroups) {
			deleteChildrenTasksAndTasksGroups(childGroup);
		}
		// Deletion of tasks
		List<Task> childrenTasks = new ArrayList<Task>(container.getOwnedTasks());
		for (Task childTask : childrenTasks) {
			deleteTask(childTask);
		}
	}
	
	/**
	 * Deletes a task and all its attached TaskReference instances
	 * @param task Task to be deleted
	 */
	public void deleteTask(Task task) {
		Session session = SessionManager.INSTANCE.getSession(task);
		ModelAccessor modelAccessor = session.getModelAccessor();
		
		// Deletion of all TaskReference instances associated with the task
		deleteTaskReferences(task, session, modelAccessor);
		DeleteUtils.delete(task, session, modelAccessor);
	}
	
	/**
	 * Computes a name from a list of abstract tasks
	 * @param abstractTasks List of abstract tasks for which we want a name
	 * @return The computed name depending on the main tasks
	 */
	public String computeNameFromTasks(List<AbstractTask> abstractTasks) {
		String name = "";
		
		List<Task> mainTasks = getMainTasks(abstractTasks); 
		for (Task task : mainTasks) {
			name += task.getName() + ";";
		}
		if (name.length() <= 1) {
			name = "";
		} else {
			name = name.substring(0, name.length() - 1);
		}
		
		return name;
	}
	
	/**
	 * Creates a "use" relationship between two Task instances
	 * @param usingTask Source Task instance of the relationship
	 * @param usedTask Target Task instance of the relationship
	 */
	public void createTaskUseTaskEdge(Task usingTask, Task usedTask) {
		// We check if the edge doesn't already exist
		if (!usingTask.getUses().contains(usedTask)) {
			
			// Add the "use" reference between the two tasks
			usingTask.getUses().add(usedTask);
			
			// Create a task reference towards usedTask on usingTask's actions plan
			TaskReference taskRef = GraalFactory.eINSTANCE.createTaskReference();
			taskRef.setTask(usedTask);
			usingTask.getNodes().add(taskRef);
		}
	}
	
	/**
	 * This service is used to remove the "use" relationship between 2 abstract tasks
	 * and remove the corresponding elements on the using task's Actions Plan when needed
	 * @param usingTask Source AbstractTask instance of the relationship
	 * @param usedTask Target AbstractTask instance of the relationship
	 */
	public void deleteTaskUseTaskEdge(AbstractTask usingTask, AbstractTask usedTask) {
		Session session = SessionManager.INSTANCE.getSession(usingTask);
		ModelAccessor modelAccessor = session.getModelAccessor();
		
		// Get all potentially concerned used Tasks
		List<Task> usedTasks = new ArrayList<Task>();
		if (usedTask instanceof Task) {
			usedTasks.add((Task)usedTask);
		} else {
			usedTasks.addAll(getAllUsedTasks((TasksGroup)usedTask));
		}

		// Check if the using "task" is a Task or a Group
		if (usingTask instanceof Task) {
			for (Task realUsedTask : usedTasks) {
				deleteUseRelationship((Task)usingTask, realUsedTask, session, modelAccessor);
			}
		} else {
			for (Task realUsedTask : usedTasks) {
				for (Task realUsingTask : getTasksFromGroupUsingTask((TasksGroup)usingTask, realUsedTask)) {
					deleteUseRelationship(realUsingTask, realUsedTask, session, modelAccessor);
				}				
			}
		}
	}
	
	/**
	 * Deletes all TaskReference instances pointing to a Task instance
	 * @param task Pointed Task instance
	 */
	private void deleteTaskReferences(Task task, Session session, ModelAccessor modelAccessor) {
		List<TaskReference> taskRefs = new ArrayList<TaskReference>(task.getReferencedBy());
		for (TaskReference taskRef : taskRefs) {
			deleteTaskReference(taskRef, session, modelAccessor);
		}
	}

	/**
	 * Returns the TaskReference instance pointing to the provided task
	 * this TaskReference must be contained directly or not by the the provided Activity
	 * @param activity Activity containing the TaskReference directly or not
	 * @param referencedTask Task pointed by the searched TaskReferenced
	 * @return TaskReference pointing towards the provided Task
	 */
	private TaskReference getReferenceOn(Activity activity, Task referencedTask) {
		TaskReference taskRef = getReferenceOnTask(activity.getNodes(), referencedTask);
		if (taskRef == null) {
			for (Activity subActivity : activity.getSubActivities()) {
				taskRef = getReferenceOnTask(subActivity.getNodes(), referencedTask);
				if (taskRef != null) {
					return taskRef;
				}
			}
		} else {
			return taskRef;
		}
		return null;
	}
	
	/**
	 * Scans the provided activity nodes to find if they contain a TaskReference instance
	 * pointing towards the provided Task
	 * @param nodes Collection of activity nodes
	 * @param referencedTask Task pointed by the searched TaskReference
	 * @return
	 */
	private TaskReference getReferenceOnTask(Collection<Node> nodes, Task referencedTask) {
		for (Node node : nodes) {
			if (node instanceof TaskReference) {
				TaskReference ref = (TaskReference)node;
				if (ref.getTask() == referencedTask) {
					return ref;
				}
			}
		}
		return null;
	}
	
	/**
	 * Deletes an "use" relationship between two tasks
	 * Deletes also TaskReferences instances when needed
	 * @param usingTask Source task of the "use" relationship
	 * @param usedTask Target task of the "use" relationship
	 */
	private void deleteUseRelationship(Task usingTask, Task usedTask, Session session, ModelAccessor modelAccessor) {
		// Delete "use" relationship
		usingTask.getUses().remove(usedTask);
		
		// Retrieve the TaskReference pointing to usedTask
		TaskReference taskRef = getReferenceOn(usingTask, usedTask);

		// Delete the corresponding TaskReference on the UsingTask's Actions plan
		if (taskRef != null) {
			deleteTaskReference(taskRef, session, modelAccessor);
		}
	}
	
	/**
	 * Deletes a TaskReference instance and its transitions
	 * @param taskRef TaskReference to be deleted
	 */
	private void deleteTaskReference(TaskReference taskRef, Session session, ModelAccessor modelAccessor) {
		// Delete transitions from and to this TaskRef
		deleteTransitions(taskRef.getIncomingTransitions(), session, modelAccessor);
		deleteTransitions(taskRef.getOutgoingTransitions(), session, modelAccessor);
		
		// Delete the TaskReference
		DeleteUtils.delete(taskRef, session, modelAccessor);
	}
	
	/**
	 * Deletes a collection of transitions
	 * @param transitions Transitions to be deleted
	 */
	private void deleteTransitions(Collection<Transition> transitions, Session session, ModelAccessor modelAccessor) {
		Collection<Transition> lTransitions = new ArrayList<Transition>(transitions);
		for (Transition transition : lTransitions) {
			DeleteUtils.delete(transition, session, modelAccessor);
		}
	}
	
	/**
	 * Gets the Task in a group pointing toward the provided task with a "use" relationship
	 * @param usingGroup Group containing the pointing Task instances
	 * @param usedTask Pointed task
	 * @return Set of pointing Task instances
	 */
	private Set<Task> getTasksFromGroupUsingTask(TasksGroup usingGroup, Task usedTask) {
		Set<Task> usingTasks = new HashSet<Task>();
		
		for (Task usingTask : usedTask.getUsedBy()) {
			if (usingGroup.getOwnedTasks().contains(usingTask)) {
				usingTasks.add(usingTask);
			} else {
				for (TasksGroup childGroup : usingGroup.getOwnedGroups()) {
					usingTasks.addAll(getTasksFromGroupUsingTask(childGroup, usedTask));
				}
			}
		}
		
		return usingTasks;
	}
	
	/**
	 * Gets all Task instances in a group which are the target of a "use" relationship
	 * @param group Containing group
	 * @return Set of pointed Task instances
	 */
	private Set<Task> getAllUsedTasks(TasksGroup group) {
		Set<Task> allTasks = new HashSet<Task>();
		for (Task task : group.getOwnedTasks()) {
			if (task.getUsedBy().size() > 0) {
				allTasks.add(task);
			}
		}
		for (TasksGroup childGroup : group.getOwnedGroups()) {
			allTasks.addAll(getAllUsedTasks(childGroup));
		}
		return allTasks;
	}
	
	/**
	 * Gets the main tasks from a list of abstract tasks 
	 * @param abstractTasks List of abstract tasks to be considered
	 * @return the main tasks from the list, considering the "use" relationships between tasks
	 */
	private List<Task> getMainTasks(List<AbstractTask> abstractTasks) {
		List<Task> mainTasks = new ArrayList<Task>();
		
		// We have to consider every task in groups or not
		List<Task> tasks = new ArrayList<Task>();
		for (AbstractTask abstractTask : abstractTasks) {
			if (abstractTask instanceof Task) {
				tasks.add((Task)abstractTask);
			} else {
				tasks.addAll(getAllEnclosedTasks((TasksGroup)abstractTask));
			}
		}
		
		// Get all tasks in the group
		for (Task task : tasks) {
			boolean usedByInnerTask = false;
			for (Task usingTask : task.getUsedBy()) {
				if (tasks.contains(usingTask)) {
					usedByInnerTask = true;
					break;
				}
			}
			if (usedByInnerTask == false) {
				mainTasks.add(task);
			}
		}
		return mainTasks;
	}
	
	/**
	 * Returns all tasks inclosed in a group, including tasks of its subgroups
	 * @param group TasksGroup instance
	 * @return List of all tasks contained directly or not in the group
	 */
	private List<Task> getAllEnclosedTasks(TasksGroup group) {
		List<Task> tasks = new ArrayList<Task>(group.getOwnedTasks());
		for (TasksGroup childGroup : group.getOwnedGroups()) {
			tasks.addAll(getAllEnclosedTasks(childGroup));
		}
		return tasks;
	}
	
	/**
	 * Returns the next available ID for a TasksGroup of the specified System
	 * @param system System containing the tasks
	 * @return next available ID
	 */
	public String getNextAvailableTasksGroupId(System system) {
		return getNextAvailableId(system, GraalPackage.Literals.TASKS_GROUP, "G");
	}
	
	/**
	 * Returns the next available ID for a Task of the specified System
	 * @param system System containing the tasks
	 * @return next available ID
	 */
	public String getNextAvailableTaskId(System system) {
		return getNextAvailableId(system, GraalPackage.Literals.TASK, "T");
	}
	
	/**
	 * Returns the closest System
	 * i.e the object itself if it is a System
	 * or the System containing the object if it is a TasksGroup
	 * @param tasksContainer Container
	 * @return the closest System
	 */
	public System getClosestSystem(TasksContainer tasksContainer) {
		System system = null;
		if (tasksContainer instanceof System) {
			system = (System)tasksContainer;
		} else if (tasksContainer instanceof TasksGroup) {
			system = ((TasksGroup)tasksContainer).getContainingSystem();
		}
		return system;
	}
	
	/**
	 * Returns the next id for the specified type using the specified prefix
	 * @param system System to consider
	 * @param type Type of objects wanted
	 * @param prefix Prefix used for IDs
	 * @return the next available ID
	 */
	private String getNextAvailableId(System system, EClassifier type, String prefix) {
		Pattern ptn = Pattern.compile("^" + prefix + "([0-9]*)$");
		int max = 0;
		for (Iterator<EObject> it = system.eAllContents(); it.hasNext();) {
			EObject eObject = it.next();
			if (type.isInstance(eObject)) {
				String id = ((AbstractTask)eObject).getId();
				if (id != null) {
					Matcher m = ptn.matcher(id);
					if (m.matches()) {
						int numId = Integer.parseInt(m.group(1));
						if (numId > max) {
							max = numId;
						}
					}
				}
			}
		}
		return prefix + (max + 1);
	}
}
