package org.obeonetwork.dsl.soa.gen.swagger;

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
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.swagger.v3.oas.models.security.OAuthFlows;

public class SwaggerFileQuery {

	private static final String KEY_SWAGGER = "swagger";//$NON-NLS-1$
	private static final String KEY_SWAGGER_VERSION = "swaggerVersion";//$NON-NLS-1$
	private static final String KEY_OPEN_API = "openapi";//$NON-NLS-1$
	private static final String KEY_COMPONENTS = "components";//$NON-NLS-1$
	private static final String KEY_SECURITY_SCHEMES = "securitySchemes";//$NON-NLS-1$
	private static final String KEY_FLOWS = "flows";//$NON-NLS-1$

	public static final String VERSION_NAME_SWAGGER = "Swagger";//$NON-NLS-1$
	public static final String VERSION_NAME_OPEN_API = "OpenAPI";//$NON-NLS-1$

	public static final String OPEN_API_3_1_0_VERSION_PATTERN = VERSION_NAME_OPEN_API + " 3.1(.0)?";//$NON-NLS-1$
	public static final String OPEN_API_3_0_VERSION_PATTERN = VERSION_NAME_OPEN_API + " 3.0(.[0-9]+)?";//$NON-NLS-1$
	public static final String SWAGGER_2_X_VERSION_PATTERN = VERSION_NAME_SWAGGER + " 2(.[0-9]+)?";//$NON-NLS-1$
	public static final String SWAGGER_1_X_VERSION_PATTERN = VERSION_NAME_SWAGGER + " 1(.[0-9]+)?";//$NON-NLS-1$

	private ObjectMapper mapper;
	private JsonNode root;

	public SwaggerFileQuery(File file) throws JsonProcessingException, IOException {
		if (file.getPath().endsWith(".yaml") || file.getPath().endsWith(".yml")) {
			mapper = new ObjectMapper(new YAMLFactory());
		} else if (file.getPath().endsWith(".json")) {
			mapper = new ObjectMapper();
		}

		if (mapper != null)
			root = mapper.readTree(file);
	}

	/**
	 * 
	 * @return version Swagger/OpenAPI of the read file.
	 */
	public String getVersion() {
		String version = "Unknown format";

		if (root != null) {
			if (root.has(KEY_SWAGGER)) {
				version = VERSION_NAME_SWAGGER + " " + root.get(KEY_SWAGGER).asText();
			} else if (root.has(KEY_SWAGGER_VERSION)) {
				version = VERSION_NAME_SWAGGER + " " + root.get(KEY_SWAGGER_VERSION).asText();
			}

			if (root.has(KEY_OPEN_API)) {
				version = VERSION_NAME_OPEN_API + " " + root.get(KEY_OPEN_API).asText();
			}
		}

		return version;
	}

	public OAuthFlows getOAuthFlows(String schemeName) throws JsonProcessingException, IOException {
		if (root != null && mapper != null && root.get(KEY_COMPONENTS) != null
				&& root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES) != null
				&& root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES).get(schemeName) != null) {

			JsonNode flowsNode = root.get(KEY_COMPONENTS).get(KEY_SECURITY_SCHEMES).get(schemeName).get(KEY_FLOWS);
			if (flowsNode != null) {
				return mapper.convertValue(flowsNode, OAuthFlows.class);
			}
		}

		return null;
	}

	/**
	 * Supported versions are those returned by {@link #getSupportedVersions()}.
	 * 
	 * @param version
	 * @return whether version is among supported versions.
	 */
	public static boolean isVersionSupported(String version) {
		//
		return version != null && (version.matches(OPEN_API_3_1_0_VERSION_PATTERN)
				|| version.matches(OPEN_API_3_0_VERSION_PATTERN) || version.matches(SWAGGER_2_X_VERSION_PATTERN)
				|| version.matches(SWAGGER_1_X_VERSION_PATTERN));
	}

	/**
	 * Gets the list of Swagger/OpenAPI versions that can be processed. That's
	 * versions that can be imported as an SOA model.
	 * 
	 * @return
	 */
	public static List<String> getSupportedVersions() {
		return List.of(VERSION_NAME_OPEN_API + " 3.1.0", //$NON-NLS-1$
				VERSION_NAME_OPEN_API + " 3.0.x", //$NON-NLS-1$
				VERSION_NAME_SWAGGER + " 2.x", //$NON-NLS-1$
				VERSION_NAME_SWAGGER + " 1.x");//$NON-NLS-1$
	}

	/**
	 * 
	 * @param version
	 * @return whether a version returned by {@link SwaggerFileQuery#getVersion()}
	 *         is equivalent to "OpenAPI 3.1.0".
	 */
	public static boolean isOpenAPI3_1_0Version(String version) {
		return version != null && version.matches(OPEN_API_3_1_0_VERSION_PATTERN);
	}

}
