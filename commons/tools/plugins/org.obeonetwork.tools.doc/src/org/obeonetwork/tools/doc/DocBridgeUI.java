/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.doc;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class DocBridgeUI extends EclipsePlugin {

	private static final String ICONS_EXTENSION = ".gif"; //$NON-NLS-1$
	private static final String ICONS_FOLDER = "icons/"; //$NON-NLS-1$
	
	public static final String EDIT_ICON_ID = "Edit"; //$NON-NLS-1$

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.tools.doc"; //$NON-NLS-1$

	// The shared instance
	private static DocBridgeUI plugin;

	private ImageRegistry registry;

	/**
	 * The constructor
	 */
	public DocBridgeUI() {
		registry = new ImageRegistry();
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
		registry.dispose();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static DocBridgeUI getInstance() {
		return plugin;
	}

	/**
	 * Returns the Platform UI workbench.  
	 * <p> 
	 * This method exists as a convenience for plugin implementors.  The
	 * workbench can also be accessed by invoking <code>PlatformUI.getWorkbench()</code>.
	 * </p>
	 * @return IWorkbench the workbench for this plug-in
	 */
	public IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor(String imageID) {
		if (registry.get(imageID) == null) {
			Bundle bundle = Platform.getBundle(PLUGIN_ID);
			IPath path = new Path(ICONS_FOLDER + imageID + ICONS_EXTENSION);
			URL url = FileLocator.find(bundle, path, null);
			ImageDescriptor desc = ImageDescriptor.createFromURL(url);
			registry.put(imageID, desc);
		}
		return ImageDescriptor.createFromImage(registry.get(imageID));
	}
	
}
