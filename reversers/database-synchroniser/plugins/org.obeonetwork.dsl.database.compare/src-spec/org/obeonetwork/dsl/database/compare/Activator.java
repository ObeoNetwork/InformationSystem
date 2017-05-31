/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	private static final String KEY_CASCADING_DIFFERENCES_FILTER = "org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.CascadingDifferencesFilter";

	private static final String KEY_DISABLED_FILTERS = "org.eclipse.emf.compare.rcp.ui.filters.disabled";

	private static final String EMF_COMPARE_RCP_UI_PREFS_ID = "org.eclipse.emf.compare.rcp.ui";

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.database.compare";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// Disable "Cascading differences" filter by default
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(EMF_COMPARE_RCP_UI_PREFS_ID);
		
		// Get current value
		String disabledFilters = node.get(KEY_DISABLED_FILTERS, null);
		
		if (disabledFilters == null || disabledFilters.trim().isEmpty()) {
			// Filters are empty
			disabledFilters = KEY_CASCADING_DIFFERENCES_FILTER; 
			node.put(KEY_DISABLED_FILTERS, disabledFilters);
		} else {
			// Test if cascading differences filter is already disabled
			if (!disabledFilters.contains(KEY_CASCADING_DIFFERENCES_FILTER)) {
				// Add filter
				disabledFilters = disabledFilters + ";" + KEY_CASCADING_DIFFERENCES_FILTER;
				node.put(KEY_DISABLED_FILTERS, disabledFilters);
				
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public void logInfo(String msg) {
		log(IStatus.INFO, msg);
	}
	
	public void logWarning(String msg) {
		log(IStatus.WARNING, msg);
	}
	
	public void logError(String msg) {
		log(IStatus.ERROR, msg);
	}
	
	public void log(int severity, String message) {
		getLog().log(new Status(severity, Activator.PLUGIN_ID, message));
	}
}
