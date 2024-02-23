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
package org.obeonetwork.utils.common.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.utils.common.ui"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

    public static void logError(String message) {
        IStatus status = new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), message);
    	plugin.getLog().log(status);
    }

    public static void logWarning(String message) {
        IStatus status = new Status(IStatus.WARNING, plugin.getBundle().getSymbolicName(), message);
    	plugin.getLog().log(status);
    }

    public static void logInfo(String message) {
        IStatus status = new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(), message);
    	plugin.getLog().log(status);
    }

	public static void logError(String message, Throwable e) {
        IStatus status = new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(), message, e);
    	plugin.getLog().log(status);
	}

}
