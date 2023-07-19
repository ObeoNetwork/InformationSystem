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
package org.obeonetwork.tools.projectlibrary.extension.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.tools.projectlibrary.Activator;

/**
 * Instantiate the right resource copier
 * @author Obeo
 *
 */
public class ImportHandlerFactory {
	
	public static final String EXTENSION_POINT_ID_IMPORT_HANDLER = "org.obeonetwork.tools.projectlibrary.importHandler";

	private static List<AbstractImportHandler> handlers = null;

	private ImportHandlerFactory() {
		// Singleton, use getInstance() to access the factory
	}
	
	private static ImportHandlerFactory factory = null;
	public static ImportHandlerFactory getInstance() {
		if (factory == null) {
			factory = new ImportHandlerFactory();
		}
		return factory;
	}
	
	public AbstractImportHandler getImportHandler(Session targetSession) {
		// Ensure handlers have been retrieved from plugins
		retrieveHandlersFromExtensions();
		
		// Loop on handlers to find the first one which is enabled
		for (AbstractImportHandler handler : handlers) {
			if (handler.isEnabled(targetSession)) {
				return handler;
			}
		}
		
		return null;
	}
	
	private void retrieveHandlersFromExtensions() {
		if (handlers == null) {
			handlers = new ArrayList<>();
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement[] config = extensionRegistry.getConfigurationElementsFor(EXTENSION_POINT_ID_IMPORT_HANDLER);
			for (IConfigurationElement configElement : config) {
				try {
					Object o = configElement.createExecutableExtension("class");
					handlers.add((AbstractImportHandler)o);
				} catch (CoreException e) {
					// Unable to instantiate class => log a warning
					Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Unable to create import handler", e));
				}
			}
			
			// Sort handlers
			Collections.sort(handlers, new Comparator<AbstractImportHandler>() {

				@Override
				public int compare(AbstractImportHandler o1, AbstractImportHandler o2) {
					if (o2 == null) {
						return 1;
					}
					if (o1 == null) {
						return -1;
					}
					if (o1.getPriority() == o2.getPriority()) {
						// sort by class name, just to be sure the order is always the same
						return o1.getClass().getName().compareTo(o2.getClass().getName());
					} else {
						return o1.getPriority() - o2.getPriority();
					}
				}
				
			});
		}
	}
}
