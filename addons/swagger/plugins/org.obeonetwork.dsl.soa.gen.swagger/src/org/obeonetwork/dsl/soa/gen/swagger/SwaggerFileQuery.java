package org.obeonetwork.dsl.soa.gen.swagger;

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
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.swagger.v3.oas.models.security.OAuthFlows;

public class SwaggerFileQuery {
	
	private static final String KEY_SWAGGER = "swagger";
	private static final String KEY_OPEN_API = "openapi";
	private static final String KEY_COMPONENTS = "components";
	private static final String KEY_SECURITY_SCHEMES = "securitySchemes";
	private static final String KEY_FLOWS = "flows";
	
	public static final String VERSION_NAME_SWAGGER = "Swagger";
	public static final String VERSION_NAME_OPEN_API = "OpenAPI";

	private ObjectMapper mapper;
	private JsonNode root;
	
	public SwaggerFileQuery(File file) throws JsonProcessingException, IOException {
		if(file.getPath().endsWith(".yaml")) {
			mapper = new ObjectMapper(new YAMLFactory());
		} else if(file.getPath().endsWith(".json")) {
			mapper = new ObjectMapper();
		}
		
		if (mapper != null) 
			root = mapper.readTree(file);
	}

	public String getVersion() {
		String version = "Unknown format";
		
		if (root != null) {
			if(root.has(KEY_SWAGGER)) {
				version = VERSION_NAME_SWAGGER + " " + root.get(KEY_SWAGGER).asText();
			}
			
			if(root.has(KEY_OPEN_API)) {
				version = VERSION_NAME_OPEN_API + " " + root.get(KEY_OPEN_API).asText();
			}	
		}
		
		return version;
	}
	
	public OAuthFlows getOAuthFlows(String schemeName) throws JsonProcessingException, IOException {
		if(root != null && mapper != null && 
				root.get(KEY_COMPONENTS) != null && 
				root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES) != null &&
				root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES).get(schemeName) != null) {
			
			JsonNode flowsNode = root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES).get(schemeName).get(KEY_FLOWS);
			if (flowsNode != null) {
				return mapper.convertValue(flowsNode, OAuthFlows.class);
			}
		}
		
		return null;
	}

}
