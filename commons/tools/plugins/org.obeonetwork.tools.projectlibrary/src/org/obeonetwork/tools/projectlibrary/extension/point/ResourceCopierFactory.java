/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author Stéphane Thibaudeau
 *
 */
public class ResourceCopierFactory {
	
	public static final String EXTENSION_POINT_ID_RESOURCE_COPIER = "org.obeonetwork.tools.projectlibrary.resourceCopier";

	private static List<IResourceCopier> copiers = null;

	private ResourceCopierFactory() {
		// Singleton, use getInstance() to access the factory
	}
	
	private static ResourceCopierFactory factory = null;
	public static ResourceCopierFactory getInstance() {
		if (factory == null) {
			factory = new ResourceCopierFactory();
		}
		return factory;
	}
	
	public IResourceCopier getResourceCopier(Session targetSession) {
		// Ensure copiers have been retrieved from plugins
		retrieveCopiersFromExtensions();
		
		// Loop on copiers to find the first one which is enabled
		for (IResourceCopier copier : copiers) {
			if (copier.isEnabled(targetSession)) {
				return copier;
			}
		}
		
		return null;
	}
	
	private void retrieveCopiersFromExtensions() {
		if (copiers == null) {
			copiers = new ArrayList<>();
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement[] config = extensionRegistry.getConfigurationElementsFor(EXTENSION_POINT_ID_RESOURCE_COPIER);
			for (IConfigurationElement configElement : config) {
				try {
					Object o = configElement.createExecutableExtension("class");
					copiers.add((IResourceCopier)o);
				} catch (CoreException e) {
					// Unable to instantiate class => log a warning
					Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Unable to create resource copier", e));
				}
			}
			
			// Sort copiers
			Collections.sort(copiers, new Comparator<IResourceCopier>() {

				@Override
				public int compare(IResourceCopier o1, IResourceCopier o2) {
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
