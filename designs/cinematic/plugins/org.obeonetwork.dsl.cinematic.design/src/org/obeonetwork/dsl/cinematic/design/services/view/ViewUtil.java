/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;

public class ViewUtil {

	/**
	 * Return list of viewContainer present in its ownedElements.
	 * 
	 * @param context the ViewContainer
	 * @return list of ViewContainer
	 */
	public static List<ViewContainer> getViewContainers(ViewContainer context) {
		List<ViewContainer> viewContainers = new ArrayList<ViewContainer>();
		for (AbstractViewElement ownedElement : context.getOwnedElements()) {
			if (ownedElement instanceof ViewContainerReference) {
				viewContainers.add(((ViewContainerReference) ownedElement).getViewContainer());
			}
		}
		return viewContainers;
	}
	
	/**
	 * Get a {@link ViewEvent} with a type corresponding to the provided {@link WidgetEventType}
	 * in a provided {@link AbstractViewElement} or create it in the {@link AbstractViewElement} 
	 * and return it if it does not exist.
	 * @param viewElement an {@link AbstractViewElement}
	 * @param eventType a {@link WidgetEventType}
	 * @return a {@link ViewEvent}
	 */
	public static ViewEvent getOrCreateViewEvent(AbstractViewElement viewElement, WidgetEventType eventType) {
		 
		Optional<ViewEvent> optionalViewEvent = viewElement.getEvents()
				.stream()
				.filter(viewEvent -> viewEvent.getType() == eventType)
				.findAny(); 
		
		if (optionalViewEvent.isPresent()) {
			return optionalViewEvent.get();
		} else {
			// Creating the new ViewEvent, and adding it in viewElement
			ViewEvent event = ViewFactory.eINSTANCE.createViewEvent();
			event.setName(viewElement.getName()+"_"+eventType.getName());
			event.setType(eventType);
			viewElement.getEvents().add(event);
			
			return event;
		}
						
	}
	
}
