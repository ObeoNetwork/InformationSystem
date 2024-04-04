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
package org.obeonetwork.database.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {


	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.database.ui"; //$NON-NLS-1$
	
	public static final String SQL_FILE_IMAGE = "sql_file"; //$NON-NLS-1$
	public static final String LIQUIBASE_FILE_IMAGE = "LiquibaseGen"; //$NON-NLS-1$
	public static final String LIQUIBASE_FILE_DISABLED_IMAGE = "LiquibaseGen_disabled"; //$NON-NLS-1$
	public static final String SQL_FILE_DISABLED_IMAGE = "sql_file_disabled"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(SQL_FILE_IMAGE, getImageDescriptor("icons/SqlFile.gif")); //$NON-NLS-1$
		reg.put(LIQUIBASE_FILE_IMAGE, getImageDescriptor("icons/LiquibaseGen.png")); //$NON-NLS-1$
		reg.put(LIQUIBASE_FILE_DISABLED_IMAGE, getImageDescriptor("icons/DisabledLiquibaseGen.png")); //$NON-NLS-1$
		reg.put(SQL_FILE_DISABLED_IMAGE, getImageDescriptor("icons/SqlFileDisabled.gif")); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Creates an error status
	 * 
	 * @param message
	 *            the error message
	 * @return a {@link IStatus}
	 */
	public static IStatus createErrorStatus(String message) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message);
	}

	public static IStatus createWarningStatus(String message) {
		return new Status(IStatus.WARNING, PLUGIN_ID, message);
	}

	/**
	 * Creates an error status
	 * 
	 * @param message
	 *            the error message
	 * @param e
	 *            a throwable
	 * @return a {@link IStatus}
	 */
	public static IStatus createErrorStatus(String message, Throwable e) {
		Throwable cause = e.getCause();
		if (cause != null && !cause.equals(e)) {
			MultiStatus multiStatus = new MultiStatus(PLUGIN_ID, IStatus.ERROR, message, e);
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, cause.getMessage(), cause));
			return multiStatus;
		} else {
			return new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		}
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
