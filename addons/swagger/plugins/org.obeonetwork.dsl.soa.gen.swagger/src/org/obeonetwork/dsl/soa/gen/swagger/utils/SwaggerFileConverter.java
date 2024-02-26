/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logWarning;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.obeonetwork.dsl.soa.gen.swagger.SwaggerFileQuery;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Json31;
import io.swagger.v3.core.util.OpenAPI30To31;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.core.util.Yaml31;
import io.swagger.v3.oas.models.OpenAPI;

/**
 * Converts a Swagger/OpenAPI file with supported version but version OpenAPI
 * 3.1.0 to an OpenAPI file with version OpenAPI 3.1.0.
 * 
 * @author Obeo
 *
 */
public class SwaggerFileConverter {

	/**
	 * Converts inputFile into the file represented by outputStream. Errors are
	 * logged in error log if they occur.
	 * 
	 * @param inputFile
	 * @param outputStream
	 */
	public static void convert(File inputFile, OutputStream outputStream) {
		if (inputFile == null || outputStream == null) {
			return;
		}
		SwaggerFileQuery fileQuery = null;
		try {
			fileQuery = new SwaggerFileQuery(inputFile);
		} catch (JsonProcessingException e) {
			logError(String.format("Invalid file content : %s.", inputFile.getAbsolutePath()), e);
		} catch (IOException e) {
			logError("I/O exception.", e);
		}
		if (fileQuery == null) {
			return;
		}
		String version = fileQuery.getVersion();
		if (!canConvertToOpenAPI310(version)) {
			logWarning("The Swagger/OpenAPI version of the file is not supported for conversion to OpenAPI 3.1.0");
			return;
		}

		if (version.matches(SwaggerFileQuery.VERSION_NAME_OPEN_API + " 3.0(.[0-9])?")) {
			// OpenAPI 3.0.x
			convertOpenAPI30To310(inputFile, outputStream);
		} else {
			// Swagger 1.x or Swagger 2.x
			convertSwaggerXToOpenAPI310(inputFile, outputStream);
		}

		return;
	}

	/**
	 * Convertible versions are supported versions but the OpenAPI 3.1.x., x>0.
	 * 
	 * @param version
	 * @return
	 */
	public static boolean canConvertToOpenAPI310(String version) {
		return version != null && SwaggerFileQuery.isVersionSupported(version)
				&& !version.matches(SwaggerFileQuery.VERSION_NAME_OPEN_API + " 3.1(.[0-9])?");
	}

	private static void convertOpenAPI30To310(File inputFile, OutputStream outputStream) {
		// 3.0 version
		String inputFilePath = inputFile.getAbsolutePath();
		ObjectMapper objectMapper = null;
		OpenAPI swagger = null;
		if (inputFilePath.endsWith(".yaml") || inputFilePath.endsWith(".yml")) {
			objectMapper = Yaml.mapper();
		} else if (inputFilePath.endsWith(".json")) {
			objectMapper = Json.mapper();
		} else {
			// Should not happen
			logWarning(String.format(
					"Conversion couldn't proceed, missing file extension: yaml or yml or json, for file: %s",
					inputFilePath));
			return;
		}
		try {
			swagger = objectMapper.readValue(inputFile, OpenAPI.class);
		} catch (JsonParseException e) {
			logError("Parsing exception.", e);
		} catch (JsonMappingException e) {
			logError("Mapping exception.", e);
		} catch (IOException e) {
			logError("I/O exception.", e);
		}
		if (swagger == null) {
			return;
		}

		OpenAPI30To31 oapi30To31 = new OpenAPI30To31();
		oapi30To31.process(swagger);
		ObjectMapper outputMapper = null;
		if (inputFilePath.endsWith(".yaml") || inputFilePath.endsWith(".yml")) {
			outputMapper = Yaml31.mapper();
		} else if (inputFilePath.endsWith(".json")) {
			outputMapper = Json31.mapper();
		}
		// Single serialization option.
		// Don't write JsonSchemaDialect.
		swagger.setJsonSchemaDialect(null);
		try {

			outputMapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, swagger);
			outputStream.flush();
		} catch (JsonGenerationException e) {
			logError("Generation exception.", e);
		} catch (JsonMappingException e) {
			logError("Mapping exception.", e);
		} catch (IOException e) {
			logError("I/O exception.", e);
		}
	}

	private static void convertSwaggerXToOpenAPI310(File inputFile, OutputStream outputStream) {
		return;
	}
}
