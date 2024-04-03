/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logInfo;
import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.eclipse.core.runtime.IStatus;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ComponentGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerExportUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerExportUtil.MapperType;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerExportUtil.SwaggerExportResult;

import io.swagger.v3.oas.models.OpenAPI;

public class SwaggerExporter {
	
	private Component component;
	private MapperType mapperType = MapperType.YAML;
	private OpenAPI swagger = null;
    
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

		int status = IStatus.OK;
		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			logError("File not found exception.", e);
			status = IStatus.ERROR;
		}
		
		if (outputStream != null) {
			SwaggerExportResult result = SwaggerExportUtil.export(component, mapperType, outputStream);
			swagger = result.getSwagger();
			status = result.getStatus();
		}
		
		if(status != IStatus.ERROR) {
			logInfo(String.format("Component %s exported in file %s.", component.getName(), outputFile.getAbsolutePath()));
		}
		
		return status;
	}
	
}
