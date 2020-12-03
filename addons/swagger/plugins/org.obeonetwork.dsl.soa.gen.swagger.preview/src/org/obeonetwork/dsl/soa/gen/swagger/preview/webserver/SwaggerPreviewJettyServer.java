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
package org.obeonetwork.dsl.soa.gen.swagger.preview.webserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.equinox.http.jetty.JettyConfigurator;
import org.eclipse.equinox.http.jetty.JettyConstants;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.soa.gen.swagger.preview.Activator;
import org.osgi.framework.Bundle;

import com.google.common.io.Files;

public class SwaggerPreviewJettyServer {

	private static final String SERVER_ID = "org.obeonetwork.dsl.soa.gen.swagger.preview.webserver.SwaggerPreviewJettyServer";
	
	private static SwaggerPreviewJettyServer INSTANCE = null;
	
	private static final int HTTP_PORT = 8082;
	
	private boolean running = false;
	
	private Map<String, File> swaggerFiles = new HashMap<String, File>();
	
	private Map<String, File> swaggerUiDistFiles = new HashMap<String, File>();
	
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
		
		loadSwaggerUiDistFiles();
		
		return this;
	}
	
	private void loadSwaggerUiDistFiles() throws IOException {
		Bundle bundle = Activator.getDefault().getBundle();

		URL swaggerUiDistJarUrl = bundle.findEntries("/", "swagger-ui-dist-*.jar", true).nextElement();

		byte[] buffer = new byte[2048];

		try(BufferedInputStream bufferedInputStream = new BufferedInputStream(swaggerUiDistJarUrl.openStream());
			ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream)) {

			ZipEntry zipEntry = zipInputStream.getNextEntry();
			while(zipEntry != null) {
				if(!zipEntry.isDirectory() && zipEntry.getName().matches(".*/swagger-ui-dist/[0-9]+\\.[0-9]+\\.[0-9]+/.*")) {
					String fileName = new File(zipEntry.getName()).getName();

					File outputFile = File.createTempFile(Files.getNameWithoutExtension(fileName), "." + Files.getFileExtension(fileName));
					outputFile.deleteOnExit();

					try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
							BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, buffer.length)) {

						int length = zipInputStream.read(buffer);
						while (length > 0) {
							bufferedOutputStream.write(buffer, 0, length);
							length = zipInputStream.read(buffer);
						}
					}
					swaggerUiDistFiles.put(fileName, outputFile);
				}
				zipEntry = zipInputStream.getNextEntry();
			}
		}
	}
	
	public File getSwaggerUiDistFile(String fileName) {
		return swaggerUiDistFiles.get(fileName);
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
		String stringUrl = "http://localhost:" + HTTP_PORT + "/index.html?url=" + swaggerFileName;
		URL url = new URL(stringUrl.replaceAll(" ", "%20"));
		return url;
	}
	
}
