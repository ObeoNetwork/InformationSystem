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
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.util.ViewSwitch;

public class ViewLabelSwitch extends ViewSwitch<String> {
	
	@Override
	public String caseLayout(Layout layout) {
		if(layout.getViewElement() != null) {
			return caseNamedElement(layout.getViewElement());
		}
		return null;
	}

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}
	
}
