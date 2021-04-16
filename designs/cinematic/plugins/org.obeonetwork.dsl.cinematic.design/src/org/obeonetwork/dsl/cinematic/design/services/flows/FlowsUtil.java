/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.design.services.CinematicEcoreServices;
import org.obeonetwork.dsl.cinematic.design.services.view.ViewUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

public class FlowsUtil {
	
	public static Collection<Event> getAssociatedEvents(Flow flow) {
		Collection<Event> events = new HashSet<Event>();
		
		events.addAll(flow.getEvents());
		for (Flow subflow : getSubflows(flow)) {
			events.addAll(subflow.getEvents());
		}
		for (AbstractViewElement element : getAssociatedAbstractViewElements(flow)) {
			events.addAll(element.getEvents());
		}
		
		return events;
	}
	
	public static Collection<WidgetEventTypeAndAbstractViewElement> getPossibleWidgetEvents(Flow flow) {
		Collection<WidgetEventTypeAndAbstractViewElement> eventTypes = new HashSet<WidgetEventTypeAndAbstractViewElement>();
		
		for (AbstractViewElement element : getAssociatedAbstractViewElements(flow)) {
			if (element.getWidget() != null) {
				for (WidgetEventType widgetEventType : element.getWidget().getPossibleEvents()) {					
					eventTypes.add(new WidgetEventTypeAndAbstractViewElement(widgetEventType, element));
				}
			}
		}
		
		return eventTypes;
	}
	
	public static Collection<AbstractViewElement> getAssociatedAbstractViewElements(Flow flow) {
		Collection<AbstractViewElement> elements = new HashSet<AbstractViewElement>();
		
		// The associated view elements are those contained or referenced
		// via referenced view containers
		for (ViewState viewState : getViewStates(flow)) {
			elements.addAll(viewState.getViewContainers());
			for (ViewContainer viewContainer : viewState.getViewContainers()) {
				elements.addAll(ViewUtil.getAssociatedAbstractViewElements(viewContainer));
			}
		}
		
		return elements;
	}
	
	
	public static Collection<ViewState> getViewStates(Flow flow) {
		Collection<ViewState> viewStates = new ArrayList<ViewState>();
		for (FlowState state : flow.getStates()) {
			if (state instanceof ViewState) {
				viewStates.add((ViewState)state);
			}
		}
		return viewStates;
	}
	
	public static Collection<Flow> getSubflows(Flow flow) {
		Collection<Flow> flows = new ArrayList<Flow>();
		for (FlowState state : flow.getStates()) {
			if (state instanceof SubflowState) {
				Flow subflow = ((SubflowState)state).getSubflow();
				if (subflow != null) {
					flows.add(subflow);
				}
			}
		}
		return flows;
	}
	
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
	 * Return the on size.
	 * @param context the Transition.
	 * @return The on size
	 */
	public Integer getOnSize(Transition context){
		return context.getOn().size();
	}
	
	/**
	 * Return the viewContainers contained in the states of the context.
	 * @param context the Flow
	 * @return list of ViewContainer
	 */
	public List<ViewContainer> getStatesViewContainers(Flow context){
		List<ViewContainer> statesViewContainers = new ArrayList<ViewContainer>();
		for (FlowState flowState : context.getStates()){
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
	
	/**
	 * Return all flows and ancestors.
	 * @param context
	 * @param flows the flows
	 * @return flows and ancestors
	 */
	public List<EObject> getFlowsAndAncestors(EObject context, List<Flow> flows) {
		List<EObject> containers = new ArrayList<EObject>(flows);
		for (Flow flow : flows) {
			EObject flowContainer = flow.eContainer();
			while (flowContainer != null && !containers.contains(flowContainer)){
				containers.add(flowContainer);			
				flowContainer = flowContainer.eContainer();
			}			
		}
		return containers;
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

	public List<EObject> getFlowsAndContainer(EObject context, List<Flow> flows) {
		List<EObject> containers = new ArrayList<EObject>(flows);
		for (Flow flow : flows) {
			if (flow.eContainer() instanceof AbstractPackage) {
				containers.add((AbstractPackage) flow.eContainer());
			}
		}
		return containers;
	}
	
	/**
	 * Get all packages and subpackages starting from the specified AbstractPackage parameter
	 * @param abstractPackage an {@link AbstractPackage}
	 * @return a Collection containing all of {@link AbstractPackage}s
	 */
	public static Collection<AbstractPackage> getAllPackagesFromRoot(AbstractPackage abstractPackage) {
		Collection<AbstractPackage> packageList = new ArrayList<>();		
		packageList.add(abstractPackage); 
		
		packageList.addAll(
			abstractPackage.getSubPackages().stream() 
				.map(FlowsUtil::getAllPackagesFromRoot) // collection of collection of sub packages
				.flatMap(Collection::stream) // flatten to a single collection of packages
				.collect(Collectors.toList()) 
		);
		
		return packageList;
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
	
	/**
	 * Return all the {@link ViewState} from a root {@link AbstractPackage}
	 * @param abstractPackage, an {@link AbstractPackage}, such as a {@link CinematicRoot}
	 * @return a Collection of {@link ViewState}
	 */
	public static Collection<ViewState> getAllViewStateInPackage(AbstractPackage abstractPackage) {
			
		return getAllPackagesFromRoot(abstractPackage) 
				.stream() // Stream<AbstractPackage>		
				.flatMap(ap -> ap.getFlows().stream()) // Stream<Flow>
				.flatMap(flow -> flow.getStates().stream()) // Stream<FlowState>
				.filter(ViewState.class::isInstance)
				.map(ViewState.class::cast) // Stream<ViewState>
				.collect(Collectors.toList()); // Collection<ViewState>
	}
	

}
