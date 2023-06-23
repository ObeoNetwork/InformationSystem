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

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.obeonetwork.dsl.cinematic.design.services.flows.WidgetEventTypeAndAbstractViewElement;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;

/**
 * 
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class FlowstateEventCheckstateProvider implements ICheckStateProvider {
	private Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap;
	private Collection<FlowEvent> flowEventsCollection;	
	
	public FlowstateEventCheckstateProvider(Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap,
			Collection<FlowEvent> flowEventsCollection) {
		this.viewElementWidgetMap = viewElementWidgetMap;
		this.flowEventsCollection = flowEventsCollection;
	}

	@Override
	public boolean isGrayed(Object element) {
		return element instanceof Flow || element instanceof AbstractViewElement;		
	}
	
	@Override
	public boolean isChecked(Object element) {
		if (element instanceof WidgetEventTypeAndAbstractViewElement) {
			AbstractViewElement abstractViewElement = ((WidgetEventTypeAndAbstractViewElement) element).getAbstractViewElement();
			WidgetEventType eventType = ((WidgetEventTypeAndAbstractViewElement) element).getWidgetEventType();
	
			if (viewElementWidgetMap.containsKey(abstractViewElement)) { // a ViewEvent of an AbstractViewElement is referred by the Transition
				if (viewElementWidgetMap.get(abstractViewElement).contains(eventType)) { // we check if this event is present in the map, in case it has been unchecked by the user.
					return true;
				}
			}
			return false;
		} else if (element instanceof FlowEvent) {
			return flowEventsCollection.contains(element);
		} else {
			// we always display grayed checkboxes.
			return isGrayed(element);	
		}
	}
}
