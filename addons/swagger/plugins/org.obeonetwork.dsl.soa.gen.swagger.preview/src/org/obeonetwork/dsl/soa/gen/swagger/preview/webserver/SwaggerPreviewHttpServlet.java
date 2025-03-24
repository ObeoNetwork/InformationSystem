/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview.webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SwaggerPreviewHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String swaggerFileNameParameter = "";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
        	// Mime types handling
        	String requestURI = req.getRequestURI(); 
        	if(requestURI.endsWith(".html")) {
				resp.setContentType("text/html");
			} else if(requestURI.endsWith(".css")) {
				resp.setContentType("text/css");
			} else if(requestURI.endsWith(".js")) {
				resp.setContentType("application/javascript");
			} else if(requestURI.endsWith(".js.map")) {
				resp.setContentType("application/octet-stream");
			} else if(requestURI.endsWith(".yaml")) {
				resp.setHeader("Cache-Control", "no-store");
				resp.setHeader("Cache-Control", "max-age=0");
				resp.setContentType("application/yaml");
			} else if(requestURI.endsWith(".json")) {
				resp.setContentType("application/json");
				resp.setHeader("Cache-Control", "no-store");
				resp.setHeader("Cache-Control", "max-age=0");
			}
			
        	String resourceName = URLDecoder.decode(req.getRequestURI().substring(1), "UTF-8");
        	if(req.getParameter("url")!=null) {
        		swaggerFileNameParameter = req.getParameter("url");
        	}
        	File resourceFile = SwaggerPreviewJettyServer.instance().getSwaggerUiDistFile(resourceName);
        	if(resourceFile == null) {
        		resourceFile = SwaggerPreviewJettyServer.instance().getSwaggerFile(resourceName);
    			if(resourceFile != null) {
    				System.out.println();
            		System.out.println("Serving file " + resourceFile.getAbsolutePath());
    			}
        	}
			if(resourceFile != null) {
				Path pathToCopy;
				if (resourceFile.getAbsolutePath().matches(".*swagger-initializer.*\\.js")) {
					pathToCopy = changeDefaultURLInSwaggerInitializerJavascript(resourceFile.getAbsolutePath(),
							swaggerFileNameParameter);
				} else {
					pathToCopy = resourceFile.toPath();
				}
				
				Files.copy(pathToCopy, resp.getOutputStream());
			} else {
				resp.getWriter().write("404 not found");
			}
        	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	private static final String DEFAULT_SWAGGER_URL_IN_INITIALIZER = "https://petstore.swagger.io/v2/swagger.json";

	private static Path changeDefaultURLInSwaggerInitializerJavascript(String absolutePath, String swaggerFileName)
			throws IOException {
		File newTempFile = File.createTempFile("swagger-initializer", ".js");
		newTempFile.deleteOnExit();
		BufferedReader file = new BufferedReader(new FileReader(absolutePath));
		PrintWriter writer = new PrintWriter(newTempFile, "UTF-8");
		String line;
		while ((line = file.readLine()) != null) {
			if (line.contains("url: \"" + DEFAULT_SWAGGER_URL_IN_INITIALIZER + "\",")) {
				line = line.replace(DEFAULT_SWAGGER_URL_IN_INITIALIZER, swaggerFileName);
			}
			writer.println(line);
		}
		file.close();
		writer.close();
		return newTempFile.toPath();
	}
}
