package org.obeonetwork.dsl.soa.gen.swagger.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
	 * @param inputFile
	 * @param outputStream
	 * @return the messages returned by the conversion if any, null otherwise.
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	public static List<String> convertSwagger1ToOpenAPI3(File inputFile, OutputStream outputStream)
			throws IOException, JsonGenerationException, JsonMappingException {
		if (inputFile == null || outputStream == null) {
			return null;
		}

		File tempSwagger2_0File = File.createTempFile(UUID.randomUUID().toString(),
				"." + Files.getFileExtension(inputFile.getAbsolutePath()));
		if (tempSwagger2_0File == null) {
			return null;
		}
		OutputStream tempOutputStream = new FileOutputStream(tempSwagger2_0File);
		convertSwagger1ToSwagger2(inputFile, tempOutputStream);
		List<String> res = null;
		if (tempSwagger2_0File != null && tempSwagger2_0File.exists()) {
			try {
				tempSwagger2_0File.deleteOnExit();
				res = convertSwagger2ToOpenAPI3(tempSwagger2_0File, outputStream);
				tempSwagger2_0File.delete();
			} catch (SecurityException e) {
				if (e != null) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * <p>
	 * Converts Swagger 2.X file (inputFile) into the file OpenAPI 3.0.1 file
	 * represented by outputStream
	 * </p>
	 * 
	 * @param inputFile
	 * @param outputStream
	 * @return the messages returned by the conversion if any, null otherwise.
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	public static List<String> convertSwagger2ToOpenAPI3(File inputFile, OutputStream outputStream)
			throws IOException, JsonGenerationException, JsonMappingException {
		if (inputFile == null || outputStream == null) {
			return null;
		}

		SwaggerParseResult result = new OpenAPIParser().readLocation(inputFile.getAbsolutePath(), null, null);

		if (result == null || result.getOpenAPI() == null) {
			return null;
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
