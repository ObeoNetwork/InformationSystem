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
package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.Collection;
import java.util.Map;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.obeonetwork.dsl.cinematic.design.services.view.ViewUtil;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public class FlowstateEventButtonListener implements Listener {
	
	private Transition transition;
	private Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap;
	private Collection<FlowEvent> flowEventsCollection;
	
	
	public FlowstateEventButtonListener(Transition transition,
			Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap,
			Collection<FlowEvent> flowEventsCollection) {
		this.transition = transition;
		this.viewElementWidgetMap = viewElementWidgetMap;
		this.flowEventsCollection = flowEventsCollection;
	}


	@Override
	public void handleEvent(Event event) {
		transition.getOn().clear();			
		transition.getOn().addAll(flowEventsCollection);			
		viewElementWidgetMap.forEach((abstractViewElement,widgetEventTypes) -> {			
			widgetEventTypes.forEach(type -> {
				transition.getOn().add(ViewUtil.getOrCreateViewEvent(abstractViewElement, type));
			});
			
			addViewContainerToSourceViewState(transition, abstractViewElement);
		});		
	}

	/**
	 * Adds a {@link ViewContainer} to the source {@link ViewState} of a {@link Transition}.
	 * If the {@link AbstractViewElement} provided is a {@link ViewElement}, it adds its container instead.
	 * @param transition a {@link Transition}
	 * @param abstractViewElement an {@link AbstractViewElement}
	 */
	private void addViewContainerToSourceViewState(Transition transition, AbstractViewElement abstractViewElement) {
		if (transition.getFrom() instanceof ViewState) {
			ViewState state = (ViewState) transition.getFrom();
			ViewContainer container = null;
			if (abstractViewElement instanceof ViewContainer) {
				container = (ViewContainer) abstractViewElement;
			} 
			
			if (abstractViewElement instanceof ViewElement) {
				container = (ViewContainer) abstractViewElement.eContainer();
			}
			
			if (! state.getViewContainers().contains(container) && container != null) {
				state.getViewContainers().add(container);
			}
		}
	}

}
