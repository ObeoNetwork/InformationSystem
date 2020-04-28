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

import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.isNullOrWhite;

import java.io.File;
import java.io.IOException;

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
	
    public enum MapperType {
        YAML, JSON;
    }

	public static void exportInDir(Component component, MapperType mapperType, File outputDir) throws IOException {
        File outputFile = new File(outputDir, getFileNameForComponent(component, mapperType));
        exportInFile(component, mapperType, outputFile);
	}
	
	public static String getFileNameForComponent(Component component, MapperType mapperType) {
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

	public static void exportInFile(Component component, MapperType mapperType, File outputFile) throws JsonGenerationException, JsonMappingException, IOException {
		SwaggerBuilder swaggerBuilder = new SwaggerBuilder(component);
		
        OpenAPI swagger = swaggerBuilder.createOpenAPI();
        
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

        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, swagger);
	}

}
