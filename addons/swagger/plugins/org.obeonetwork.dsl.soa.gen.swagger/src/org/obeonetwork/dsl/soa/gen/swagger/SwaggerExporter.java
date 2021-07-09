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
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logInfo;
import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ComponentGenUtil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;

public class SwaggerExporter {
	
	private Component component;
	private MapperType mapperType = MapperType.YAML;
	private OpenAPI swagger = null;
	
    public enum MapperType {
        YAML, JSON;
    }
    
    public SwaggerExporter(Component component) {
    	this.component = component;
    }
    
    public void setOutputFormat(MapperType mapperType) {
    	this.mapperType = mapperType;
    }

	public int exportInDir(File outputDir) {
        File outputFile = new File(outputDir, getOutputFileName());
        
        return exportInFile(outputFile);
	}
	
	public String getOutputFileName() {
		StringBuffer outputFileName = new StringBuffer();
		outputFileName.append(ComponentGenUtil.getName(component));
		if(!isNullOrWhite(component.getApiVersion())) {
			outputFileName.append("-");
			outputFileName.append(component.getApiVersion());
		}
		outputFileName.append(".");
		outputFileName.append(mapperType.toString().toLowerCase());
		
		return outputFileName.toString();
	}

	public OpenAPI getExportedSwagger() {
		return swagger;
	}

	public int exportInFile(File outputFile) {
		SwaggerBuilder swaggerBuilder = new SwaggerBuilder(component);
		
		int status = swaggerBuilder.build();
		
		if(status != IStatus.ERROR) {
	        swagger  = swaggerBuilder.getOpenAPI();
	        
	        ObjectMapper mapper = null;	        
	        switch (mapperType) {
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
				mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, swagger);
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
		
		if(status != IStatus.ERROR) {
			logInfo(String.format("Component %s exported in file %s.", component.getName(), outputFile.getAbsolutePath()));
		}
		
		return status;
	}	
}
