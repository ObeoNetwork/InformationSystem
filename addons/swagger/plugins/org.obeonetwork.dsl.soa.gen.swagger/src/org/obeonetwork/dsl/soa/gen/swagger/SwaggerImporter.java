/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.utils.NamespaceGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SystemGenUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

public class SwaggerImporter {
	
	private static final String OPEN_API_SUPPORTED_VERSION_PATTERN = "OpenAPI 3.[0-9]+(.[0-9]+)?";
	private static final String OPEN_API_SUPPORTED_VERSIONS = "OpenAPI 3.x";
	
	private System soaSystem;
	private Environment environment;
	private SwaggerFileQuery fileQuery;
	
	public SwaggerImporter(System system, Environment environment) {
		this.soaSystem = system;
		this.environment = environment;
	}

	public int importFromFile(String inputFilePath, String paginationExtension) {
		int status = IStatus.OK;
		
		File inputFile = new File(inputFilePath);

		String swaggerVersion = null;
		try {
			fileQuery = new SwaggerFileQuery(inputFile);
			swaggerVersion = fileQuery.getVersion();
		} catch (JsonProcessingException e) {
			logError(String.format("Invalid file content : %s.", inputFilePath), e);
			status = IStatus.ERROR;
		} catch (IOException e) {
			logError("I/O exception.", e);
			status = IStatus.ERROR;
		}
		
		if(status != IStatus.ERROR && !swaggerVersion.matches(OPEN_API_SUPPORTED_VERSION_PATTERN)) {
			logError(String.format("Unsupported format : %s. Supported version are %s.", swaggerVersion, OPEN_API_SUPPORTED_VERSIONS));
			status = IStatus.ERROR;
		}
		
		OpenAPI swagger = null;
		if(status != IStatus.ERROR) {
			
			ObjectMapper objectMapper = null;
			if(inputFilePath.endsWith(".yaml")) {
				objectMapper = Yaml.mapper();
			} else if(inputFilePath.endsWith(".json")) {
				objectMapper = Json.mapper();
			}

			try {
				swagger = objectMapper.readValue(inputFile, OpenAPI.class);
				// SAFRAN-961
				addFlowsToOpenIdConnectSchemes(swagger);
			} catch (JsonParseException e) {
				logError("Json parsing exception.", e);
				status = IStatus.ERROR;
			} catch (JsonMappingException e) {
				logError("Json mapping exception.", e);
				status = IStatus.ERROR;
			} catch (IOException e) {
				logError("I/O exception.", e);
				status = IStatus.ERROR;
			}
		}
		
		if(status != IStatus.ERROR) {
			
			SoaComponentBuilder soaComponentBuilder = new SoaComponentBuilder(swagger, environment, paginationExtension);
			status = soaComponentBuilder.build();
			
			if(status != IStatus.ERROR) {
				Component soaComponent = soaComponentBuilder.getComponent();
				Namespace soaComponentNamespace = soaComponentBuilder.getNamespace();
				
				if(soaComponent != null && SystemGenUtil.getComponentByName(soaSystem, soaComponent.getName()) != null) {
					logError(String.format("Component with name %s already exist.", soaComponent.getName()));
					status = IStatus.ERROR;
				}
				
				if(soaComponentNamespace != null && NamespaceGenUtil.getNamespaceByName(soaSystem, soaComponentNamespace.getName()) != null) {
					logError(String.format("Namespace with name %s already exist.", soaComponentNamespace.getName()));
					status = IStatus.ERROR;
				}
				
				if(status != IStatus.ERROR) {
					if(soaComponent != null) {
						soaSystem.getOwnedComponents().add(soaComponent);
					}
					if(soaComponentNamespace != null) {
						soaSystem.getOwnedNamespaces().add(soaComponentNamespace);
					}
				}
			}
		}
		
		return status;		
	}
	
	/**
	 * Checks the {@link SecurityScheme} of the {@link Components}. 
	 * If a scheme has the OpenIDConnect {@link Type}, it gathers the {@link OAuthFlow} it may contain.  
	 * @param api the {@link OpenAPI}
	 */
	private void addFlowsToOpenIdConnectSchemes(OpenAPI api) {
		api.getComponents().getSecuritySchemes().entrySet().stream()
		.filter(entry -> {
			return entry.getValue().getType().equals(SecurityScheme.Type.OPENIDCONNECT); 
		})
		.forEach(entry -> {
			try {
				entry.getValue().setFlows(fileQuery.getOAuthFlows(entry.getKey()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}
