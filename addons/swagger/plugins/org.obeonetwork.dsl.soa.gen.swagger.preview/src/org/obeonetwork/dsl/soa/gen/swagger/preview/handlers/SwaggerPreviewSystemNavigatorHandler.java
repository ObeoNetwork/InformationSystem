/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview.handlers;

import java.net.URL;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class SwaggerPreviewSystemNavigatorHandler extends SwaggerPreviewAbstractHandler {

	@Override
	protected void openURL(URL url, String title) throws PartInitException {
		PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(url);
	}

}
