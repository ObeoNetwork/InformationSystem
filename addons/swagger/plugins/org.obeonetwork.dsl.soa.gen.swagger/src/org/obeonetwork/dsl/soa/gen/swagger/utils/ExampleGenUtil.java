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

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;

public class ExampleGenUtil {

	private static ObjectMapper jsonMapper = Json.mapper();
	private static ObjectMapper yamlMapper = Yaml.mapper();

	/**
	 * 
	 * @param value a Json or Yaml {@link String}
	 * @return an {@link Object}, either a {@link JsonNode} or a {@link String} if it cannot be parsed
	 */
	public static Object getExampleObjectFromValue(String value) {				
		JsonNode jsonNode = null;		
		try {
			jsonNode = jsonMapper.readTree(value);
		} catch (IOException jsonException) {
			try {
				jsonNode = yamlMapper.readTree(value);
			} catch (IOException yamlException) {
				jsonException.printStackTrace();
				yamlException.printStackTrace();
			}
		}
		
		if (jsonNode == null)
			return value;
		else 
			return jsonNode;
	}
	
	/**
	 * Serializes an {@link Object} to a JSON String
	 * 
	 * @param value an {@link Object}
	 * @return the serialized {@link String} 
	 */
	public static String getExampleValueFromObject(Object value) {
		try {
			return jsonMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
 