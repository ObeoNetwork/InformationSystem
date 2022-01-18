/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.obeonetwork.dsl.soa.gen.swagger";

    // The shared instance
    private static Activator plugin;
	
    /**
     * The constructor
     */
    public Activator() {
    	
    }
    
    public void start(BundleContext context) throws Exception {
    	super.start(context);
    	plugin = this;
    }

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
