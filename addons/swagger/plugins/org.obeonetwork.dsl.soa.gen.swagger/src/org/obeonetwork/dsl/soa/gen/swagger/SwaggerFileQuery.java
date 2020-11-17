package org.obeonetwork.dsl.soa.gen.swagger;

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
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class SwaggerFileQuery {
	
	private static final String KEY_SWAGGER = "swagger";
	private static final String KEY_OPEN_API = "openapi";
	
	public static final String VERSION_NAME_SWAGGER = "Swagger";
	public static final String VERSION_NAME_OPEN_API = "OpenAPI";

	private File file;

	public SwaggerFileQuery(File file) {
		this.file = file;
	}

	public String getVersion() throws JsonProcessingException, IOException {
		String version = "Unknown format";
		
		ObjectMapper mapper = null;
		if(file.getPath().endsWith(".yaml")) {
			mapper = new ObjectMapper(new YAMLFactory());
		} else if(file.getPath().endsWith(".json")) {
			mapper = new ObjectMapper();
		}
		
		if(mapper != null) {
			JsonNode root = mapper.readTree(file);
			
			if(root.has(KEY_SWAGGER)) {
				version = VERSION_NAME_SWAGGER + " " + root.get(KEY_SWAGGER).asText();
			}
			
			if(root.has(KEY_OPEN_API)) {
				version = VERSION_NAME_OPEN_API + " " + root.get(KEY_OPEN_API).asText();
			}
			
		}
		
		return version;
	}

}
