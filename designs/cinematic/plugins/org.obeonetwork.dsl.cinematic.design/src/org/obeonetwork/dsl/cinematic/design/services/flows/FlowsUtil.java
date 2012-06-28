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
package org.obeonetwork.dsl.cinematic.design.services.flows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.design.services.CinematicEcoreServices;
import org.obeonetwork.dsl.cinematic.design.services.view.ViewUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
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
}
