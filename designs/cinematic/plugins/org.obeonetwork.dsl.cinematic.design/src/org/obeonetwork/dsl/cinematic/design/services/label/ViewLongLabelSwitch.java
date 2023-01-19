/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.util.ViewSwitch;

public class ViewLongLabelSwitch extends ViewSwitch<String> {
	
	@Override
	public String caseViewEvent(ViewEvent viewEvent) {
		String label = caseNamedElement(viewEvent);
		if (viewEvent.getType() != null) {
			label += " : " + viewEvent.getType().getName();
		}
		
		return label;
	}
	
	@Override
	public String caseLayout(Layout layout) {
		if(layout.getViewElement() != null) {
			return caseAbstractViewElement(layout.getViewElement());
		}
		return null;
	}
	
	/**
	 * Build a label such as: "abstractViewElement : widgetName".
	 * If the {@link AbstractViewElement} has no widget, it simply returns the abstract view element name.
	 */
	@Override
	public String caseAbstractViewElement(AbstractViewElement abstractViewElement) {
		StringBuffer longLabel = new StringBuffer();
		
		if(abstractViewElement.getName() != null) {
			longLabel.append(abstractViewElement.getName());
		}
		
		if(abstractViewElement.getWidget() != null) {
			longLabel.append(" : ").append(abstractViewElement.getWidget().getName());
		}
		
		return longLabel.toString();
	}

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}
	
}
