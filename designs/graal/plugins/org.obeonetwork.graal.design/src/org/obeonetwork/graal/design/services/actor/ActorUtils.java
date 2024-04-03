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
package org.obeonetwork.graal.design.services.actor;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;

/**
 * Utilities services concerning Actors
 * @author Obeo
 *
 */
public class ActorUtils {
	
	/**
	 * Get the list of actors that should be visually connected to a task or group
	 * The list depends on inherited actors and already visible tasks on diagram 
	 * @param abstractTask The AbstractTask for which we want the actors list
	 * @param tasksOnDiagram List of visible tasks on diagram
	 * @return List of Actors
	 */
	public Collection<Actor> getVisibleLinksToActors(AbstractTask abstractTask, List<Task> tasksOnDiagram) {
		if (abstractTask instanceof Task) {
			return getVisibleLinksToActorsFromTask((Task)abstractTask, tasksOnDiagram);
		} else if (abstractTask instanceof TasksGroup) {
			return ((TasksGroup)abstractTask).getRelatedActors();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get the list of actors that should be visually connected to a task
	 * The list depends on inherited actors and already visible tasks on diagram 
	 * @param task The task for which we want the actors list
	 * @param tasksOnDiagram List of visible tasks on diagram
	 * @return List of Actors
	 */
	private Collection<Actor> getVisibleLinksToActorsFromTask(Task task, final List<Task> tasksOnDiagram) {
		if (task.getActors().isEmpty()) {
			// Get using tasks that are displayed on diagram
			List<Task> usingTasksOnDiagram = task.getUsedBy().stream().filter(t -> tasksOnDiagram.contains(t)).collect(toList());
			
			// Filter the related actors to keep those not already associated with a displayed using task
			List<Actor> relatedActors = new ArrayList<Actor>(task.getRelatedActors());
			usingTasksOnDiagram.stream()
			.flatMap(usingTask -> usingTask.getRelatedActors().stream())
			.forEach(actor -> relatedActors.remove(actor));
			// If some of the actors are not linked to displayed tasks
			// we then have to display the whole actors list to prevent from misunderstanding
			if (! relatedActors.isEmpty()) {
				return task.getRelatedActors();
			} else {
				return Collections.emptyList();
			}
		} else {
			return task.getActors();
		}
	}
	
	/**
	 * Returns the visible actors for an object
	 * Delegates to the service corresponding to the object's type
	 * @param object
	 * @return
	 */
	public List<Actor> getVisibleActors(GraalObject object) {
		if (object instanceof System) {
			return ((System)object).getRelatedActors();
		} else if (object instanceof TasksGroup) {
			return ((TasksGroup)object).getRelatedActors();
		} else if (object instanceof UseCase) {
			return getVisibleActorsForUseCase((UseCase)object);
		}
		return null;
	}
	
	/**
	 * Returns the visible actors for a use case
	 * @param useCase
	 * @return
	 */
	private List<Actor> getVisibleActorsForUseCase(UseCase useCase) {
		List<Actor> actors = new ArrayList<Actor>();
		
		for (AbstractTask abstractTask : useCase.getTasks()) {
			if (abstractTask instanceof Task) {
				actors.addAll(((Task)abstractTask).getRelatedActors());
			} else if (abstractTask instanceof TasksGroup) {
				actors.addAll(((TasksGroup)abstractTask).getRelatedActors());
			}
		}
		return actors;
	}
	
	/**
	 * Returns the visible actors for a tasks group
	 * @param group
	 * @return
	 */
	public Set<Actor> getVisibleActors(TasksGroup group) {
		HashMap<Task, Set<Actor>> cache = new HashMap<Task, Set<Actor>>();
		Set<Actor> actors = new LinkedHashSet<Actor>();
		List<Actor> actorsLeft = getAllActorsInContext(group);
		for (AbstractTask abstractTask : group.getTasks()) {
			actors.addAll(internalGetVisibleActors(abstractTask, cache, actorsLeft));
		}
		return actors;
	}
	
	/**
	 * Returns the visible actors for a task
	 * @param task
	 * @return
	 */
	public Set<Actor> getVisibleActors(Task task) {
		HashMap<Task, Set<Actor>> cache = new HashMap<Task, Set<Actor>>();
		Set<Actor> actors = new LinkedHashSet<Actor>();
		List<Actor> actorsLeft = getAllActorsInContext(task);
		actors.addAll(internalGetVisibleActors(task, cache, actorsLeft));
		return actors;
	}
	
	/**
	 * Returns the visible actors for a use case
	 * @param useCase
	 * @return
	 */
	public Set<Actor> getVisibleActors(UseCase	useCase) {
		HashMap<Task, Set<Actor>> cache = new HashMap<Task, Set<Actor>>();
		Set<Actor> actors = new LinkedHashSet<Actor>();
		List<Actor> actorsLeft = getAllActorsInContext(useCase);
		for (AbstractTask abstractTask : useCase.getTasks()) {
			actors.addAll(internalGetVisibleActors(abstractTask, cache, actorsLeft));
		}
		return actors;
	}
	
	/**
	 * Returns the visible actors for a system
	 * @param system
	 * @return
	 */
	public Set<Actor> getVisibleActors(System system) {
		HashMap<Task, Set<Actor>> cache = new HashMap<Task, Set<Actor>>();
		Set<Actor> actors = new LinkedHashSet<Actor>();
		List<Actor> actorsLeft = getAllActorsInContext(system);
		for (AbstractTask abstractTask : system.getTasks()) {
			actors.addAll(internalGetVisibleActors(abstractTask, cache, actorsLeft));
		}
		return actors;
	}

	/**
	 * Collect the visible actors for a task, using an internal cache
	 * @param abstractTask
	 * @param cache Map to store already calculated links between Tasks and Actors
	 * @param actorsLeft List of actors not yet in the final list (used to improve performance)
	 * @return
	 */
	private Set<Actor> internalGetVisibleActors(AbstractTask abstractTask, Map<Task, Set<Actor>> cache, List<Actor> actorsLeft) {
		if (!actorsLeft.isEmpty()) {
			if (abstractTask instanceof Task) {
				Task task = (Task)abstractTask;
				
				if (cache.containsKey(task)) {
					return cache.get(task);
				} else {
					Set<Actor> actors = new LinkedHashSet<Actor>();
					cache.put(task, actors);
					if (task.getActors().isEmpty()) {
						for (Task usingTask : task.getUsedBy()) {
							if (!cache.containsKey(usingTask) && !actorsLeft.isEmpty()) {
								actors.addAll(internalGetVisibleActors(usingTask, cache, actorsLeft));
							}
						}
					} else {
						actors.addAll(task.getActors());
						actorsLeft.removeAll(actors);
					}
					cache.put(task, actors);
					return actors;
				}
			} else if (abstractTask instanceof TasksGroup) {
				Set<Actor> actors = new LinkedHashSet<Actor>();
				TasksGroup group = (TasksGroup)abstractTask;
				for (AbstractTask subTask : group.getTasks()) {
					if (!actorsLeft.isEmpty()) {
						actors.addAll(internalGetVisibleActors(subTask, cache, actorsLeft));
					}
				}
				return actors;
			}
		}
		return new LinkedHashSet<Actor>();
	}
	
	private List<Actor> getAllActorsInContext(EObject object) {
		System system = getParentSystem(object);
		if (system != null) {
			return new ArrayList<Actor>(system.getActors());
		}
		return null;
	}
	
	private System getParentSystem(EObject object) {
		if (object instanceof System) {
			return (System)object;
		} else if (object.eContainer() != null) {
			return getParentSystem(object.eContainer());
		}
		return null;
	}
}
