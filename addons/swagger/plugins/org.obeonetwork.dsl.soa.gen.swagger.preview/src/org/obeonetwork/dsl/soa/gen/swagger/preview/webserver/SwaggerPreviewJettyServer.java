/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview.webserver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.equinox.http.jetty.JettyConfigurator;
import org.eclipse.equinox.http.jetty.JettyConstants;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;

public class SwaggerPreviewJettyServer {

	private static final String SERVER_ID = "org.obeonetwork.dsl.soa.gen.swagger.preview.webserver.SwaggerPreviewJettyServer";
	
	private static SwaggerPreviewJettyServer INSTANCE = null;
	
	private static int HTTP_PORT = 8082;
	
	private boolean running = false;
	
	private Map<String, File> swaggerFiles = new HashMap<String, File>();
	
	private SwaggerPreviewJettyServer() {
		
	}
	
	public static SwaggerPreviewJettyServer instance() {
		if(INSTANCE == null) {
			INSTANCE = new SwaggerPreviewJettyServer();
		}
		return INSTANCE;
	}

	public SwaggerPreviewJettyServer start() throws Exception {
		
		if(!running) {
			Dictionary<String, Object> settings = new Hashtable<>();
			settings.put(JettyConstants.HTTP_PORT, HTTP_PORT);
			JettyConfigurator.startServer(SERVER_ID, settings);
			running = true;
			
			PlatformUI.getWorkbench().addWorkbenchListener(new IWorkbenchListener() {

				@Override
				public boolean preShutdown(IWorkbench workbench, boolean forced) {
					try {
						SwaggerPreviewJettyServer.instance().stop();
					} catch (Exception e) {

					}
					return true;
				}

				@Override
				public void postShutdown(IWorkbench workbench) {
					// NOP
				}
			});
		}
		
		return this;
	}
	
	public void stop() throws Exception {
		if(running) {
			JettyConfigurator.stopServer(SERVER_ID);
			running = false;
		}
	}
	
	public void putSwaggerFile(String swaggerFileName, File swaggerFile) {
		swaggerFiles.put(swaggerFileName, swaggerFile);
	}
	
	public File getSwaggerFile(String swaggerFileName) {
		return swaggerFiles.get(swaggerFileName);
	}
	
	public URL getUrlForFile(String swaggerFileName) throws MalformedURLException {
		return new URL("http://localhost:" + HTTP_PORT
				+ "/index.html?url=" + swaggerFileName);
	}
	
}
