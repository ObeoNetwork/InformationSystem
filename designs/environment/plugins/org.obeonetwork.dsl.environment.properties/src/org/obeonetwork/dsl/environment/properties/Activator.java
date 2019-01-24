/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.environment.properties";
	
	/**
	 * The path to the edit image.
	 */
	public static final String EDIT_ICON_PATH = "icons/full16/Edit_16x16.gif";
	
	/**
	 * The path to the add image.
	 */
	public static final String ADD_ICON_PATH = "icons/full16/Add_16x16.gif";
	
	/**
	 * The path to the remove image.
	 */
	public static final String REMOVE_ICON_PATH = "icons/full16/Delete_16x16.gif";
	
	/**
	 * The path to the arrow up image.
	 */
	public static final String UP_ICON_PATH = "icons/full16/ArrowUp_16x16.gif";
	
	/**
	 * The path to the arrow down image.
	 */
	public static final String DOWN_ICON_PATH = "icons/full16/ArrowDown_16x16.gif";

	// The shared instance
	private static Activator plugin;

	private static Set<Viewpoint> viewpoints;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance()
				.registerFromPlugin(PLUGIN_ID + "/description/environment-properties.odesign"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (viewpoints != null) {
			for (final Viewpoint viewpoint : viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}
			viewpoints.clear();
			viewpoints = null;
		}
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
}
