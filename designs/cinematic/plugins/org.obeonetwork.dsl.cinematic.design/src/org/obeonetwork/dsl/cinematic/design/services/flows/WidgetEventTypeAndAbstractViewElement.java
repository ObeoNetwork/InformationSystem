/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services.flows;

import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;

public class WidgetEventTypeAndAbstractViewElement {

	private WidgetEventType widgetEventType;
	private AbstractViewElement abstractViewElement;
	
	public WidgetEventTypeAndAbstractViewElement(
			WidgetEventType widgetEventType,
			AbstractViewElement abstractViewElement) {
		super();
		this.widgetEventType = widgetEventType;
		this.abstractViewElement = abstractViewElement;
	}
	public WidgetEventType getWidgetEventType() {
		return widgetEventType;
	}
	public void setWidgetEventType(WidgetEventType widgetEventType) {
		this.widgetEventType = widgetEventType;
	}
	public AbstractViewElement getAbstractViewElement() {
		return abstractViewElement;
	}
	public void setAbstractViewElement(AbstractViewElement abstractViewElement) {
		this.abstractViewElement = abstractViewElement;
	}
	
}
