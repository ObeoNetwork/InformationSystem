/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Servlet;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.obeonetwork.dsl.soa.gen.swagger.preview.webserver.SwaggerPreviewHttpServlet;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.soa.gen.swagger.preview"; //$NON-NLS-1$
	
	public static final String STATIC_RESOURCES_ALIAS = "/"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		SwaggerPreviewHttpServlet staticResourcesHttpServlet = new SwaggerPreviewHttpServlet();
		Dictionary<String, Object> staticResourcesServletProperties = new Hashtable<>();
		staticResourcesServletProperties.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, STATIC_RESOURCES_ALIAS);
		context.registerService(Servlet.class, staticResourcesHttpServlet, staticResourcesServletProperties);		
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

}
