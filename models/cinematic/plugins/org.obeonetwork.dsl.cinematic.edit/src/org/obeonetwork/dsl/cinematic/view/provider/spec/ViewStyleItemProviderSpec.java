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
package org.obeonetwork.dsl.cinematic.view.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewStyle;
import org.obeonetwork.dsl.cinematic.view.provider.ViewStyleItemProvider;

public class ViewStyleItemProviderSpec extends ViewStyleItemProvider {

	public ViewStyleItemProviderSpec(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = "";
		
		ViewStyle viewStyle = (ViewStyle)object;
		if(viewStyle.eContainer() instanceof AbstractViewElement) {
			AbstractViewElement viewElement = (AbstractViewElement) viewStyle.eContainer();
			label = viewElement.getName();
		}
		return label == null || label.length() == 0 ?
			getString("_UI_ViewStyle_type") :
			getString("_UI_ViewStyle_type") + " " + label;
	}

	
}
