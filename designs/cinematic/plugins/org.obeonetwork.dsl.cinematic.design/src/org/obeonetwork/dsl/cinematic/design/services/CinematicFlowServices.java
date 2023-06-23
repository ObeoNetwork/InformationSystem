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
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.design.dialogs.event.FlowstateEventSelectionDialog;
import org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer.ViewContainerSelectionDialog;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.EObjectUtils;

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
	
	/**
	 * Checks if the given {@link ViewContainer} is contained in a {@link ViewContainer}
	 * @param container a {@link ViewContainer}
	 * @return <code>true</code> if contained in a {@link ViewContainer}
	 */
	public void openViewContainerSelectionDialog(ViewState viewState) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		ViewContainerSelectionDialog dialog = new ViewContainerSelectionDialog(shell, viewState);
		dialog.open();
	}
	
	public void openEventSelectionDialog(Transition transition) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		FlowstateEventSelectionDialog dialog = new FlowstateEventSelectionDialog(shell, transition);
		dialog.open();
	}
	
	public static boolean isSubViewContainer(ViewContainer container) {
		return container.eContainer() instanceof ViewContainer;
	}
	
	/**
	 * Checks if a transition targets a view state or is on the path towards a view state 
	 * @param transition a {@link Transition}
	 * @return <code>true</code> or <code>false</code>
	 */
	public static boolean isViewStateTransition(Transition transition) {
		FlowState from = transition.getFrom();
		FlowState to = transition.getTo();
		Session session = new EObjectQuery(transition).getSession();
		ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		
		Collection<FlowState> outgoingFlowStates = new HashSet<>();		
		collectTargetFlowStates(outgoingFlowStates, to, crossReferencer);
		
		Collection<FlowState> incomingFlowStates = new HashSet<>();
		collectSourceFlowStates(incomingFlowStates, from, crossReferencer);
		
		outgoingFlowStates.removeAll(incomingFlowStates);
		
		return outgoingFlowStates.stream().anyMatch(ViewState.class::isInstance);
	}
	
	/**
	 * Gathers all the {@link FlowState}s on a single {@link Transition} path
	 * @param sourceFlowStates a {@link Collection} of {@link FlowState}
	 * @param flowState a {@link FlowState} where the path ends
	 * @param crossReferencer a {@link CrossReferencer}
	 */
	private static void collectSourceFlowStates(Collection<FlowState> sourceFlowStates, FlowState flowState, ECrossReferenceAdapter crossReferencer) {
		if (!sourceFlowStates.contains(flowState)) {
			sourceFlowStates.add(flowState);	
			
			if (flowState instanceof ViewState) {
				return ;
			}
			
			// gets all the transition pointing towards the FlowState
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(flowState, FlowPackage.eINSTANCE.getTransition_To(), true);
			
			inverseReferences.stream()
				.map(Setting::getEObject)
				.filter(Transition.class::isInstance)
				.map(Transition.class::cast)
				.forEach(transition -> collectSourceFlowStates(sourceFlowStates, transition.getFrom(), crossReferencer));			
		}
	}
	
	/**
	 * Gets all the {@link FlowState}s that are on a {@link Transition} path 
	 * @param targetFlowStates a {@link Collection} of {@link FlowState}
	 * @param flowState {@link FlowState}
	 * @param crossReferencer a {@link CrossReferencer}
	 */
	private static void collectTargetFlowStates(Collection<FlowState> targetFlowStates, FlowState flowState, ECrossReferenceAdapter crossReferencer) {
		if (!targetFlowStates.contains(flowState)) {
			targetFlowStates.add(flowState);		
			
			if (flowState instanceof ViewState) {
				return ;
			}			

			// all the transitions starting from the FlowState
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(flowState, FlowPackage.eINSTANCE.getTransition_From(), true);
			
			inverseReferences.stream()
				.map(Setting::getEObject)
				.filter(Transition.class::isInstance)
				.map(Transition.class::cast)
				.forEach(transition -> {
					collectTargetFlowStates(targetFlowStates, transition.getTo(), crossReferencer);	
				});			
			
			// if the state is a SubFlow, checks if the SubFlow goes to a ViewState
			if (flowState instanceof SubflowState && ((SubflowState) flowState).getSubflow() != null) {				
				((SubflowState) flowState)
					.getSubflow()
					.getStates()
					.stream()
					.filter(InitialState.class::isInstance)
					.forEach(initialNode -> {
						collectTargetFlowStates(targetFlowStates, initialNode, crossReferencer);
					});
			}
		}	
	}
}
