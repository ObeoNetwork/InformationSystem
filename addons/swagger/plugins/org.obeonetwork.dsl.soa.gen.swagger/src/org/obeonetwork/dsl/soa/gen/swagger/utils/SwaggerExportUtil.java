/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.runtime.IStatus;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;

public class SwaggerExportUtil {
	
    public enum MapperType {
        YAML, JSON;
    }

    public static SwaggerExportResult export(Component component, MapperType outputType, OutputStream outputStream) {
    	

		SwaggerBuilder swaggerBuilder = new SwaggerBuilder(component);
		
		int status = swaggerBuilder.build();
		
		OpenAPI swagger  = null;
		
		if(status != IStatus.ERROR) {
	        swagger  = swaggerBuilder.getOpenAPI();
	        
	        ObjectMapper mapper = null;	        
	        switch (outputType) {
	        case JSON:
	            mapper = Json.mapper();
	            break;
	        case YAML:
	            mapper = Yaml.mapper();
	            break;
	        }
	        mapper.setSerializationInclusion(Include.NON_NULL);
	        mapper.setSerializationInclusion(Include.NON_EMPTY);
	        
	        mapper.enable(MapperFeature.USE_ANNOTATIONS);
	        try {
				mapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, swagger);
			} catch (JsonGenerationException e) {
				logError("Json generation exception.", e);
				status = IStatus.ERROR;
			} catch (JsonMappingException e) {
				logError("Json mapping exception.", e);
				status = IStatus.ERROR;
			} catch (IOException e) {
				logError("I/O exception.", e);
				status = IStatus.ERROR;
			}
		}
		
		return new SwaggerExportResult(swagger, status);
	}
    
    public static class SwaggerExportResult {
    	private OpenAPI swagger;
    	private int status;

    	public SwaggerExportResult(OpenAPI swagger, int status) {
			super();
			this.swagger = swagger;
			this.status = status;
		}

		public OpenAPI getSwagger() {
			return swagger;
		}
		
		public int getStatus() {
			return status;
		}
    }	
}
