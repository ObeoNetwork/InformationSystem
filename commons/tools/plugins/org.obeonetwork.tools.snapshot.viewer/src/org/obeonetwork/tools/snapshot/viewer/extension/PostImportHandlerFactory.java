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
package org.obeonetwork.tools.snapshot.viewer.extension;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.obeonetwork.tools.snapshot.viewer.Activator;

public class PostImportHandlerFactory {
	
	public static final String EXTENSION_POINT_ID_POST_IMPORT_HANDLER = "org.obeonetwork.tools.snapshot.viewer.postImport";

	private static Collection<IPostImportHandler> handlers = null;

	private PostImportHandlerFactory() {
		// Singleton, use getInstance() to access the factory
	}
	
	private static PostImportHandlerFactory factory = null;
	public static PostImportHandlerFactory getInstance() {
		if (factory == null) {
			factory = new PostImportHandlerFactory();
		}
		return factory;
	}
	
	public Collection<IPostImportHandler> getPostImportHandlers() {
		// Ensure handlers have been retrieved from plugins
		retrieveHandlersFromExtensions();
				
		return handlers;
	}
	
	private void retrieveHandlersFromExtensions() {
		if (handlers == null) {
			handlers = new ArrayList<IPostImportHandler>();
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement[] config = extensionRegistry.getConfigurationElementsFor(EXTENSION_POINT_ID_POST_IMPORT_HANDLER);
			for (IConfigurationElement configElement : config) {
				try {
					Object o = configElement.createExecutableExtension("class");
					handlers.add((IPostImportHandler)o);
				} catch (CoreException e) {
					// Unable to instantiate class => log a warning
					Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Unable to create post import handler", e));
				}
			}
		}
	}
}
