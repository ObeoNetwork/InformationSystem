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
package org.obeonetwork.graal.design.services.group;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.design.services.util.DeleteUtils;

import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagramElement;

/**
 * Class used to ungroup a group i.e. extract all the tasks in a group and remove the group
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class UngroupAction {
	
	/**
	 * Checks if the ungroup action can be executed
	 * @param context Object needed so the method can be called by Acceleo
	 * @param selections Graphical elements selected by the user before launching the action
	 * @return true if one and only one TasksGroup has been selected
	 */
	public boolean canExecuteUngroupAction(EObject context, Collection<? extends EObject> selections) {
		// The action can be executed only if one and only one 
		// TasksGroup has been selected
		int nbOfGroups = 0;
		for (EObject selection : selections) {
			if (selection instanceof AbstractDNode) {
				EObject target = ((AbstractDNode)selection).getTarget();
				if (target instanceof TasksGroup) {
					if (nbOfGroups >= 1) {
						return false;
					}
					nbOfGroups += 1;
				}
			}
		}
		return (nbOfGroups == 1); 
	}

	/**
	 * Executes the ungrouping action
	 * @param context Object needed so the method can be called by Acceleo. It is returned unchanged
	 * @param selections Graphical elements selected by the user before launching the action
	 * @return The first parameter without any change
	 */
	public EObject executeUngroupAction(EObject context, Collection<? extends EObject> selections) {
		
		TasksGroup group = extractTasksGroup(selections);
		
		// Keep attachment to use case
		UseCase useCase = group.getUseCase();
		if (useCase != null) {
			for (AbstractTask abstractTask : group.getTasks()) {
				useCase.getTasks().add(abstractTask);
			}
		}
		
		TasksContainer container = (TasksContainer)group.eContainer();
		container.getTasks().addAll(group.getTasks());
		
		// Delete without EcoreUtil.delete()
		DeleteUtils.delete(group);
		
		return context;
	}

	/**
	 * Extracts the first TasksGroup instance from a list of selected graphical elements
	 * @param selections Graphical elements selected by the user before launching the action
	 * @return The first TasksGroup instance pointed by the graphical elements
	 */
	private TasksGroup extractTasksGroup(Collection<? extends EObject> selections) {
		for (EObject selection : selections) {
			if (selection instanceof DDiagramElement) {
				EObject target = ((DDiagramElement)selection).getTarget();
				if (target instanceof TasksGroup) {
					return (TasksGroup)target;
				}
			}
		}
		return null;
	}
}
