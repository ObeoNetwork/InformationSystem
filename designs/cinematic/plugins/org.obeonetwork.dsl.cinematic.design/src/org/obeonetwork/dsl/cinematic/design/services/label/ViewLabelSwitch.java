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
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.util.ViewSwitch;

public class ViewLabelSwitch extends ViewSwitch<String> {
	
	
	
	@Override
	public String caseViewEvent(ViewEvent viewEvent) {
		String label = caseNamedElement(viewEvent);
		if (label == null) {
			label = "";
		}
//		if (viewEvent.getType() != null) {
//			label += " : " + viewEvent.getType().getName();
//		}
//		
		return label;
	}
	
	@Override
	public String caseViewContainer(ViewContainer viewContainer) {
		String label = caseNamedElement(viewContainer);
		if (label != null && !label.trim().equals("")) {
			label += "";
		}
//		if (viewContainer.getWidget() != null) {
//			label += ": " + viewContainer.getWidget().getName();
//		} else {
//			// We add the type of ViewContainer i.e. the EClass's name
//			label += ": " + viewContainer.eClass().getName();
//		}
		return label;
	}
	
	@Override
	public String caseViewElement(ViewElement viewElement) {
		String label = caseNamedElement(viewElement);
		if (label != null && !label.trim().equals("")) {
			label += "";
		}
//		if (viewElement.getWidget() != null) {
//			label += ": " + viewElement.getWidget().getName();
//		}
		return label;
	}

	@Override
	public String caseViewContainerReference(ViewContainerReference viewContainerReference) {
		String label = caseNamedElement(viewContainerReference);
		if (label != null && !label.trim().equals("")) {
			label += "";
		}
//		if (viewContainerReference.getViewContainer() != null) {
//			label += ": " + viewContainerReference.getViewContainer().getName();
//		}
		return label;
	}

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}
	
}
