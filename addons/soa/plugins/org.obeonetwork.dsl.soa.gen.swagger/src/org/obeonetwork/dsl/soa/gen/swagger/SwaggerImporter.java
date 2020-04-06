package org.obeonetwork.dsl.soa.gen.swagger;

import java.io.File;
import java.io.IOException;

import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;

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

	public Component importFromFile(String inputFilePath) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = null;
		if(inputFilePath.endsWith(".yaml")) {
			objectMapper = Yaml.mapper();
		} else if(inputFilePath.endsWith(".json")) {
			objectMapper = Json.mapper();
		}

		File file = new File(inputFilePath);

		OpenAPI swagger = objectMapper.readValue(file, OpenAPI.class);
		
		SoaComponentBuilder soaComponentBuilder = new SoaComponentBuilder(swagger, soaSystem, environment);
		Component soaComponent = soaComponentBuilder.createSoaComponent();

		return soaComponent;
		
	}

}
