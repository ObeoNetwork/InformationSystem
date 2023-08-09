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
package org.obeonetwork.dsl.cinematic.design.services.flows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.services.CinematicEcoreServices;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

public class FlowsUtil {
	
	public static List<Flow> getFlowsWithName(EObject context, String name) {
		List<Flow> flows = new ArrayList<Flow>();
		if (name == null || name.trim().equals("")) {
			return flows;
		}
		Collection<EObject> roots = CinematicEcoreServices.getAllRootsForCinematic(context);
		for (EObject root : roots) {
			for(TreeIterator<EObject> it = root.eAllContents(); it.hasNext();) {
				EObject current = it.next();
				if (current instanceof Flow) {
					Flow flow = (Flow) current;
					if (name.equalsIgnoreCase(flow.getName())) {
						flows.add(flow);
					}
				} else if (current instanceof AbstractPackage == false) {
					it.prune();
				}
			}
		}
		return flows;
	}
	
	/**
	 * Verify that subflow is not null.
	 * @param context the subflowState
	 * @return boolean true if subflow is not null, false otherwise
	 */
	public Boolean isSubFlowNotNull(SubflowState context){
		return context.getSubflow() != null;
	}
	
	/**
	 * Return the viewContainers referenced by the states of the given flow.
	 * 
	 * @param flow the Flow
	 * @return list of ViewContainer
	 */
	public List<ViewContainer> getStatesViewContainers(Flow flow){
		List<ViewContainer> statesViewContainers = new ArrayList<ViewContainer>();
		for (FlowState flowState : flow.getStates()){
			if (flowState instanceof ViewState){
				statesViewContainers.addAll(((ViewState) flowState).getViewContainers());
			}
		}
		return statesViewContainers;
	}
	
	/**
	 * Return the flows contained in the subflowStates of context.
	 * @param context the Flow.
	 * @return list of Flow
	 */
	public List<Flow> getSubFlowInSubflowStates(Flow context){
		List<Flow> subflowInSubflowStates = new ArrayList<Flow>();
		for (FlowState flowState : context.getStates()){
			if (flowState instanceof SubflowState){
				subflowInSubflowStates.add(((SubflowState)flowState).getSubflow());
			}
		}
		return subflowInSubflowStates;
	}
	
	public List<EObject> getViewContainersPossible(EObject context,
			List<ViewContainer> viewContainers) {
		List<EObject> viewContainersAncestors = new ArrayList<EObject>();
		// Add to the list, the ViewContainer Ancestors if they are not already
		// on the list.
		for (ViewContainer viewContainer : viewContainers) {
			viewContainersAncestors.add(viewContainer);
			EObject objectContainer = viewContainer.eContainer();
			while (objectContainer != null) {
				if (!viewContainersAncestors.contains(objectContainer)) {
					viewContainersAncestors.add(objectContainer);
				}
				objectContainer = objectContainer.eContainer();
			}
		}
		// Removing duplicates, if duplicates are present
		Set<EObject> set = new HashSet<EObject>();
		set.addAll(viewContainersAncestors);
		return new ArrayList<EObject>(set);
	}

	/**
	 * Return the Cinematic Root of the model
	 * @param object any {@link EObject}
	 * @return a {@link CinematicRoot}	 
	 * <pre> object belongs to the Cinematic metamodel </pre> 
	 */
	public static CinematicRoot getCinematicRoot(EObject object) {
		EObject container = EcoreUtil.getRootContainer(object);
		if (container instanceof CinematicRoot) {
			return (CinematicRoot) container;
		}
		return null;
	}
	
}
