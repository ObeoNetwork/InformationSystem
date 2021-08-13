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
package org.obeonetwork.dsl.cinematic.view.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.provider.LayoutItemProvider;

public class LayoutItemProviderSpec extends LayoutItemProvider {

	public LayoutItemProviderSpec(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Layout layout = (Layout)object;
		String viewElementName = "Virtual";
		if(layout.getViewElement() != null) {
			viewElementName = layout.getViewElement().getName();
		}
		return getString("_UI_Layout_type") + " " + viewElementName + " (" + 
		layout.getX() + ", " + layout.getY() + ", " + layout.getWidth() + ", " + layout.getHeight() + ")";
	}

}
