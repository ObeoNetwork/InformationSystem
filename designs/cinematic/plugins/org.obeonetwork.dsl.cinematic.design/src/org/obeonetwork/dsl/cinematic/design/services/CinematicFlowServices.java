/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * Services to use the flows
 * 
 * @author jdupont
 * 
 */
public class CinematicFlowServices {

	/**
	 * Retrieve the view container associate to flow
	 * 
	 * @param context
	 *            the context. In this case should be a flow
	 * @return the list of view Container associate to the flow
	 */
	private List<ViewContainer> getViewContainerAssociate(EObject context) {
		List<ViewContainer> viewContainers = new ArrayList<ViewContainer>();
		if (context instanceof Flow) {
			Flow flow = (Flow) context;
			// Retrieve the flow's states
			EList<FlowState> states = flow.getStates();
			List<ViewState> viewStates = new ArrayList<ViewState>();
			// Retrieve the View state type in the states list
			for (FlowState state : states) {
				if (state instanceof ViewState) {
					viewStates.add((ViewState) state);
				}
			}
			// Retrieve all viewContainers contained in the view State
			for (ViewState viewState : viewStates) {
				viewContainers.addAll(viewState.getViewContainers());
			}
		}
		return viewContainers;
	}

	/**
	 * Retrieve the view container associate to flow and the hierarchy of
	 * viewContainer associate to flow (view Container's parents).
	 * 
	 * @param context
	 *            the context
	 * @return the list of viewContainer associate to flow
	 */
	public List<ViewContainer> getViewContainerAssociateAndAncestors(
			EObject context) {
		List<ViewContainer> viewContainersAncestors = new ArrayList<ViewContainer>();
		if (context instanceof Flow) {
			// Retrieve the viewContainer associate directly to flow
			List<ViewContainer> viewContainers = getViewContainerAssociate(context);
			viewContainersAncestors.addAll(viewContainers);
			for (ViewContainer viewContainer : viewContainers) {
				EObject objectContainer = viewContainer.eContainer();
				while (objectContainer.eContainer() != null) {
					if (objectContainer instanceof ViewContainer) {
						viewContainersAncestors
								.add((ViewContainer) objectContainer);
					}
					objectContainer = objectContainer.eContainer();
				}
			}
		}
		return viewContainersAncestors;
	}
}
