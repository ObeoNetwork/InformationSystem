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
package org.obeonetwork.dsl.cinematic.design.services.view;

import java.util.ArrayList;
import java.util.Collection;

import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;

public class ViewUtil {
	public static Collection<AbstractViewElement> getAssociatedAbstractViewElements(ViewContainer container) {
		Collection<AbstractViewElement> elements = new ArrayList<AbstractViewElement>();
		
		// Add children
		for (AbstractViewElement child : container.getOwnedElements()) {
			if (child instanceof ViewElement) {
				elements.add(child);				
			} else if (child instanceof ViewContainer) {
				elements.add(child);
				elements.addAll(getAssociatedAbstractViewElements((ViewContainer)child));
			} else if (child instanceof ViewContainerReference) {
				ViewContainerReference vcr  = (ViewContainerReference)child;
				if (vcr.getViewContainer() != null) {
					ViewContainer refContainer = vcr.getViewContainer();
					elements.add(refContainer);
					elements.addAll(getAssociatedAbstractViewElements(refContainer));
				}
			}
		}
		
		return elements;
	}
	
}
