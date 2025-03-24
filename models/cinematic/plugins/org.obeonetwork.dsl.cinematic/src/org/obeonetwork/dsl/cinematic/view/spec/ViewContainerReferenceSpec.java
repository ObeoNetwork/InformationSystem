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
package org.obeonetwork.dsl.cinematic.view.spec;

import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl;

public class ViewContainerReferenceSpec extends ViewContainerReferenceImpl {

	public ViewContainerReferenceSpec() {
		super();
		setViewStyle(ViewFactory.eINSTANCE.createViewStyle());
	}

	@Override
	public Widget getWidget() {
		return getViewContainer().getWidget();
	}
	
}
