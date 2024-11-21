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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import io.swagger.models.Swagger;
import io.swagger.parser.OpenAPIParser;
import io.swagger.parser.SwaggerCompatConverter;
import io.swagger.util.Json;
import io.swagger.util.Yaml;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

/**
 * Utility class to convert Swagger 1.X and 2.X files to OpenAPI 3.0.1 files.
 * 
 * @author Obeo
 *
 */
public class SwaggerXToOpenAPI3Converter {
	/**
	 * <p>
	 * Converts a Swagger 1.X file (inputFile) to an OpenAPI 3.0.1 file represented
	 * by outputStream.
	 * </p>
	 * 
	 * @param inputSwagger1_XFile
	 * @param outputStream
	 * @return the messages returned by the conversion if any, an empty list otherwise.
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	public static List<String> convertSwagger1ToOpenAPI3(File inputSwagger1_XFile, OutputStream openAPI3outputStream)
			throws IOException, JsonGenerationException, JsonMappingException {
		List<String> messages = Collections.emptyList();

		// Create a temp file to hold the conversion to Swagger 2.0
		File tempSwagger2_0File = File.createTempFile(UUID.randomUUID().toString(),
				"." + Files.getFileExtension(inputSwagger1_XFile.getAbsolutePath()));
		tempSwagger2_0File.deleteOnExit();

		// Convert the given Swagger 1.X file to the Swagger 2.0 temp file
		OutputStream tempSwagger2_0OutputStream = new FileOutputStream(tempSwagger2_0File);
		convertSwagger1ToSwagger2(inputSwagger1_XFile, tempSwagger2_0OutputStream);
		
		// Convert the Swagger 2.0 temp file to OpenAPI 3.0.1 format in the given outputStream
		messages = convertSwagger2ToOpenAPI3(tempSwagger2_0File, openAPI3outputStream);
		
		return messages;
	}

	/**
	 * <p>
	 * Converts Swagger 2.X file (inputFile) into the file OpenAPI 3.0.1 file
	 * represented by outputStream
	 * </p>
	 * 
	 * @param inputFile
	 * @param outputStream
	 * @return the messages returned by the conversion if any, an empty list otherwise.
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	public static List<String> convertSwagger2ToOpenAPI3(File inputFile, OutputStream outputStream)
			throws IOException, JsonGenerationException, JsonMappingException {
		if (inputFile == null || outputStream == null) {
			return  Collections.emptyList();
		}

		SwaggerParseResult result = new OpenAPIParser().readLocation(inputFile.getAbsolutePath(), null, null);

		if (result == null || result.getOpenAPI() == null) {
			return  Collections.emptyList();
		}

		ObjectMapper outputMapper = null;
		String inputFilePath = inputFile.getAbsolutePath();
		if (inputFilePath.endsWith(".yaml") || inputFilePath.endsWith(".yml")) {
			outputMapper = io.swagger.v3.core.util.Yaml.mapper();
		} else if (inputFilePath.endsWith(".json")) {
			outputMapper = io.swagger.v3.core.util.Json.mapper();
		}

		outputMapper.writeValue(outputStream, result.getOpenAPI());
		outputStream.flush();
		return result.getMessages();
	}

	/**
	 * <p>
	 * Converts a Swagger 1.X file (inputFile) to a Swagger 2.0 file represented by
	 * outputStream.
	 * </p>
	 * 
	 * 
	 * @param inputFile
	 * @param outputStream
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws NullPointerException
	 */
	private static void convertSwagger1ToSwagger2(File inputFile, OutputStream outputStream)
			throws IOException, JsonGenerationException, JsonMappingException {
		if (inputFile == null || outputStream == null) {
			return;
		}
		Swagger swagger = new SwaggerCompatConverter().read(inputFile.getAbsolutePath());

		ObjectMapper outputMapper = null;
		String inputFilePath = inputFile.getAbsolutePath();
		if (inputFilePath.endsWith(".yaml") || inputFilePath.endsWith(".yml")) {
			outputMapper = Yaml.mapper();
		} else if (inputFilePath.endsWith(".json")) {
			outputMapper = Json.mapper();
		}
		outputMapper.writeValue(outputStream, swagger);
		outputStream.flush();
	}
}
