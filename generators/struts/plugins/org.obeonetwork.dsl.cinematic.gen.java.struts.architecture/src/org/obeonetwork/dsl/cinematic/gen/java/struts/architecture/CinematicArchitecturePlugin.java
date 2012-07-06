/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class CinematicArchitecturePlugin extends Plugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.cinematic.gen.java.struts.architecture";
	public static final String STRUTS_PROPERTIES = "/struts.properties";
	public static final String ORG_OBEONETWORK_DSL_CINEMATIC_GEN_JAVA_STRUTS_ARCHITECTURE_COMMON_DEFAULT_PROPERTIES = "/org/obeonetwork/dsl/cinematic/gen/java/struts/architecture/common/default.properties";

	/**
	 * The shared instance.
	 */
	private static CinematicArchitecturePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public CinematicArchitecturePlugin() {
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static CinematicArchitecturePlugin getDefault() {
		return plugin;
	}

}
