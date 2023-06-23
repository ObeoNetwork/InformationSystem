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
import java.util.HashSet;
import java.util.Map;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.obeonetwork.dsl.cinematic.design.services.flows.WidgetEventTypeAndAbstractViewElement;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public class FlowstateEventCheckstateListener implements ICheckStateListener{

	private Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidget;
	private Collection<FlowEvent> flowEvents;	
	
	public FlowstateEventCheckstateListener(Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidget,  
			Collection<FlowEvent> flowEventsCollection) {
		this.viewElementWidget = viewElementWidget;
		this.flowEvents = flowEventsCollection;
	}

	@Override
	public void checkStateChanged(CheckStateChangedEvent event) {
		// checked event
		if (event.getChecked()) {
			
			if (event.getElement() instanceof FlowEvent) {
				if (! flowEvents.contains(event.getElement())) {
					flowEvents.add((FlowEvent) event.getElement());
				}
			} 
			
			if (event.getElement() instanceof WidgetEventTypeAndAbstractViewElement) {
				AbstractViewElement abstractViewElement = ((WidgetEventTypeAndAbstractViewElement) event.getElement()).getAbstractViewElement();
				WidgetEventType widgetEventType = ((WidgetEventTypeAndAbstractViewElement) event.getElement()).getWidgetEventType();
				addViewEvent(abstractViewElement, widgetEventType);			
			}
			
		} else { // unchecked event
			if (event.getElement() instanceof FlowEvent) {
				if (flowEvents.contains(event.getElement())) {
					flowEvents.remove((FlowEvent) event.getElement());
				}
			}
			
			if (event.getElement() instanceof WidgetEventTypeAndAbstractViewElement) {
				AbstractViewElement abstractViewElement = ((WidgetEventTypeAndAbstractViewElement) event.getElement()).getAbstractViewElement();
				WidgetEventType widgetEventType = ((WidgetEventTypeAndAbstractViewElement) event.getElement()).getWidgetEventType();
				removeViewEvent(abstractViewElement, widgetEventType);						
			}			
		}			
	}
	
	/**
	 * Remove a {@link WidgetEventType} from the {@link Transition} 
	 * @param abstractViewElement an {@link AbstractViewElement} which contains a {@link ViewEvent} referring to the current {@link WidgetEventType}
	 * @param eventType the {@link WidgetEventType}
	 */
	private void removeViewEvent(AbstractViewElement abstractViewElement, WidgetEventType eventType) {			
		if (viewElementWidget.containsKey(abstractViewElement)) {
			Collection<WidgetEventType> eventTypes = viewElementWidget.get(abstractViewElement);
			if (eventTypes.contains(eventType)) {
				eventTypes.remove(eventType);
			}	
		} 						
	}

	/**
	 * Adds a {@link WidgetEventType} to the {@link Transition}
	 * @param abstractViewElement the {@link AbstractViewElement} that will contain a {@link ViewEvent} referring to the current {@link WidgetEventType}
	 * @param eventType the {@link WidgetEventType}
	 */
	private void addViewEvent(AbstractViewElement abstractViewElement, WidgetEventType eventType) {
		Collection<WidgetEventType> eventTypes;
		
		if (viewElementWidget.containsKey(abstractViewElement)) {
			eventTypes = viewElementWidget.get(abstractViewElement);
		} else {
			eventTypes = new HashSet<WidgetEventType>();
			viewElementWidget.put(abstractViewElement, eventTypes);
		}			
		
		if (!eventTypes.contains(eventType)) {
			eventTypes.add(eventType);
		}
	}

	
}
