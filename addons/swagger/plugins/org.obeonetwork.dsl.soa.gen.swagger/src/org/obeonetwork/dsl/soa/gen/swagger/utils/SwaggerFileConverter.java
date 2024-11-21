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
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.obeonetwork.dsl.soa.gen.swagger.SwaggerFileQuery;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Json31;
import io.swagger.v3.core.util.OpenAPI30To31;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.core.util.Yaml31;
import io.swagger.v3.oas.models.OpenAPI;

/**
 * Converts a Swagger/OpenAPI file with supported version but version OpenAPI
 * 3.1.0, to an OpenAPI file with version OpenAPI 3.1.0.
 * 
 * @author Obeo
 *
 */
public class SwaggerFileConverter {

	/**
	 * Converts inputFile into the file represented by outputStream.
	 * 
	 * @param inputFile
	 * @param outputStream
	 * @return warnings from parsing if any, an empty list otherwise.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws UnsupportedSwagerFileException
	 */
	public static List<String> convert(File inputFile, OutputStream outputStream)
			throws JsonParseException, JsonMappingException, IOException, UnsupportedSwagerFileException {
		List<String> parsingWarnings = Collections.emptyList();
		if (inputFile == null || outputStream == null) {
			return parsingWarnings;
		}
		SwaggerFileQuery fileQuery = null;
		fileQuery = new SwaggerFileQuery(inputFile);
		String version = fileQuery.getVersion();
		if (!canConvertToOpenAPI310(version)) {
			throw new UnsupportedSwagerFileException(String.format(
					"Swagger/OpenAPI version is not supported for conversion to OpenAPI 3.1.0 for file: %s",
					inputFile.getAbsolutePath()));
		}
		
		if (version.matches(SwaggerFileQuery.VERSION_NAME_OPEN_API + " 3.0(.[0-9])?")) {
			// OpenAPI 3.0.x
			convertOpenAPI30To310(inputFile, outputStream);
		} else {
			// Swagger 1.x or Swagger 2.x
			parsingWarnings = convertSwaggerXToOpenAPI310(version, inputFile, outputStream);
		}

		return parsingWarnings;
	}

	/**
	 * Convertible versions are supported versions but OpenAPI 3.1.x., x>=0.
	 * 
	 * @param version
	 * @return
	 */
	public static boolean canConvertToOpenAPI310(String version) {
		return version != null && SwaggerFileQuery.isVersionSupported(version)
				&& !version.matches(SwaggerFileQuery.VERSION_NAME_OPEN_API + " 3.1(.[0-9])?");
	}

	private static void convertOpenAPI30To310(File inputFile, OutputStream outputStream)
			throws JsonParseException, JsonMappingException, IOException, UnsupportedSwagerFileException {
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
			throw new UnsupportedSwagerFileException(String.format(String.format(
					"Conversion couldn't proceed, missing file extension: yaml or yml or json, for file: %s",
					inputFilePath)));
		}
		swagger = objectMapper.readValue(inputFile, OpenAPI.class);
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
		outputMapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, swagger);
		outputStream.flush();
	}

	private static List<String> convertSwaggerXToOpenAPI310(String inputSwaggerVersion, File inputFile,
			OutputStream outputStream)
			throws JsonParseException, JsonMappingException, IOException, UnsupportedSwagerFileException {
		List<String> parsingWarnings = Collections.emptyList();
		if (inputSwaggerVersion == null || outputStream == null || inputFile == null) {
			return parsingWarnings;
		}
		File tempOpenAPI3_0File = File.createTempFile(UUID.randomUUID().toString(),
				"." + Files.getFileExtension(inputFile.getAbsolutePath()));
		if (tempOpenAPI3_0File == null) {
			return parsingWarnings;
		}
		OutputStream tempOutputStream = new FileOutputStream(tempOpenAPI3_0File);
		if (inputSwaggerVersion.matches(SwaggerFileQuery.SWAGGER_1_X_VERSION_PATTERN)) {
			parsingWarnings = SwaggerXToOpenAPI3Converter.convertSwagger1ToOpenAPI3(inputFile, tempOutputStream);
		} else if (inputSwaggerVersion.matches(SwaggerFileQuery.SWAGGER_2_X_VERSION_PATTERN)) {
			parsingWarnings = SwaggerXToOpenAPI3Converter.convertSwagger2ToOpenAPI3(inputFile, tempOutputStream);
		}

		if (tempOpenAPI3_0File != null && tempOpenAPI3_0File.exists()) {
			tempOpenAPI3_0File.deleteOnExit();
			convertOpenAPI30To310(tempOpenAPI3_0File, outputStream);
			try {
				tempOpenAPI3_0File.delete();
			} catch (SecurityException e) {
				if (e != null) {
					e.printStackTrace();
				}
			}
		}
		return parsingWarnings;
	}
}
