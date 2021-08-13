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
package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.design.services.flows.WidgetEventTypeAndAbstractViewElement;
import org.obeonetwork.dsl.cinematic.flow.Flow;


/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class FlowstateEventLabelProvider extends LabelProvider {
	private AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new  ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public Image getImage(Object element) {
		if (element instanceof WidgetEventTypeAndAbstractViewElement) {
			element = ((WidgetEventTypeAndAbstractViewElement) element).getWidgetEventType();
		}
		
		return labelProvider.getImage(element);
	
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Flow) {
			return "Flow Events";
		}
		
		if (element instanceof NamedElement) {
			return ((NamedElement) element).getName();
		}
		
		if (element instanceof WidgetEventTypeAndAbstractViewElement) {
			return ((WidgetEventTypeAndAbstractViewElement) element).getWidgetEventType().getName();
		}
		
		return super.getText(element);
	}
}
