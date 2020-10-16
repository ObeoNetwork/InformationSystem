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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;

public class SwaggerImporter {
	
	private System soaSystem;
	private Environment environment;
	
	public SwaggerImporter(System system, Environment environment) {
		this.soaSystem = system;
		this.environment = environment;
	}

	public int importFromFile(String inputFilePath) {
		int status = IStatus.OK;
		
		ObjectMapper objectMapper = null;
		if(inputFilePath.endsWith(".yaml")) {
			objectMapper = Yaml.mapper();
		} else if(inputFilePath.endsWith(".json")) {
			objectMapper = Json.mapper();
		}

		File file = new File(inputFilePath);

		OpenAPI swagger = null;
		try {
			swagger = objectMapper.readValue(file, OpenAPI.class);
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
		
		if(status != IStatus.ERROR) {
			SoaComponentBuilder soaComponentBuilder = new SoaComponentBuilder(swagger, environment);
			status = soaComponentBuilder.build();
			
			if(status != IStatus.ERROR) {
				Component soaComponent = soaComponentBuilder.getComponent();
				Namespace soaComponentNamespace = soaComponentBuilder.getNamespace();
				
				if(SystemGenUtil.getComponentByName(soaSystem, soaComponent.getName()) != null) {
					logError(String.format("Component with name %s already exist.", soaComponent.getName()));
					status = IStatus.ERROR;
				}
				
				if(NamespaceGenUtil.getNamespaceByName(soaSystem, soaComponentNamespace.getName()) != null) {
					logError(String.format("Namespace with name %s already exist.", soaComponentNamespace.getName()));
					status = IStatus.ERROR;
				}
				
				if(status != IStatus.ERROR) {
					soaSystem.getOwnedComponents().add(soaComponent);
					soaSystem.getOwnedNamespaces().add(soaComponentNamespace);
				}
				
			}
		}
		
		return status;
		
	}

}
