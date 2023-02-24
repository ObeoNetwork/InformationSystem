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
package org.obeonetwork.dsl.cinematic.toolkits.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

public class ToolkitsProvider {

	public static Collection<URI> getProvidedToolkits() {
		Collection<URI> providedURIs = new ArrayList<URI>();
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint("org.obeonetwork.dsl.cinematic.providedToolkit").getExtensions();
		for (IExtension extension : extensions) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				String providedURIAsString = configurationElement.getAttribute("uri");
				providedURIs.add(URI.createURI(providedURIAsString));
			}
		}
		return providedURIs;
	}
}
