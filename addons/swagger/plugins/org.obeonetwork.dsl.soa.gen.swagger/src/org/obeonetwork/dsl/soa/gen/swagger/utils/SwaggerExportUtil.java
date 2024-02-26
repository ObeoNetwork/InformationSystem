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

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.runtime.IStatus;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json31;
import io.swagger.v3.core.util.OpenAPI30To31;
import io.swagger.v3.core.util.Yaml31;
import io.swagger.v3.oas.models.OpenAPI;

public class SwaggerExportUtil {

	public enum MapperType {
		YAML, JSON;
	}

	public static SwaggerExportResult export(Component component, MapperType outputType, OutputStream outputStream) {

		SwaggerBuilder swaggerBuilder = new SwaggerBuilder(component);

		int status = swaggerBuilder.build();

		OpenAPI swagger = null;

		if (status != IStatus.ERROR) {
			swagger = swaggerBuilder.getOpenAPI();

			OpenAPI30To31 oapi30To31 = new OpenAPI30To31();
			oapi30To31.process(swagger);
			// Don't write dialect.
			swagger.setJsonSchemaDialect(null);
			ObjectMapper mapper = null;
			switch (outputType) {
			case JSON:
				mapper = Json31.mapper();
				break;
			case YAML:
				mapper = Yaml31.mapper();
				break;
			}
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.setSerializationInclusion(Include.NON_EMPTY);
			// Since Jackson 2.9.X., using option Include.NON_EMPTY in
			// setSerializationInclusion has as effect to ignore maps with an (unique) entry
			// whose value is null/empty (empty list for instance.)

			// See also: https://github.com/FasterXML/jackson-databind/issues/2136
			// So we force an entry to be taken into account with
			// a non-empty entry's key and any values accepted for the entry's value.
			mapper.setDefaultPropertyInclusion(
					JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, JsonInclude.Include.ALWAYS));

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
