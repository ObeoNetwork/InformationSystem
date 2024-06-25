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
package org.obeonetwork.dsl.soa.gen.swagger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.JsonSchema;
import io.swagger.v3.oas.models.media.Schema;

@SuppressWarnings("rawtypes")
public class OpenApiParserHelper {

	public static final String COMPONENT_SCHEMA_$REF = "#/components/schemas/";

	public static final String OPEN_API_TYPE_OBJECT = "object";
	public static final String OPEN_API_TYPE_STRING = "string";
	public static final String OPEN_API_TYPE_NUMBER = "number";
	public static final String OPEN_API_TYPE_INTEGER = "integer";
	public static final String OPEN_API_TYPE_BOOLEAN = "boolean";

	public static final String OPEN_API_FORMAT_BINARY = "binary";
	public static final String OPEN_API_FORMAT_DATE = "date";
	public static final String OPEN_API_FORMAT_DOUBLE = "double";
	public static final String OPEN_API_FORMAT_FLOAT = "float";
	public static final String OPEN_API_FORMAT_INT32 = "int32";
	public static final String OPEN_API_FORMAT_INT64 = "int64";
	public static final String OPEN_API_FORMAT_DATETIME = "date-time";
	public static final String OPEN_API_FORMAT_BYTE = "byte";
	public static final String OPEN_API_FORMAT_PASSWORD = "password";

	public static final String OPEN_API_IN_BODY = "body";
	public static final String OPEN_API_IN_COOKIE = "cookie";
	public static final String OPEN_API_IN_HEADER = "header";
	public static final String OPEN_API_IN_PATH = "path";
	public static final String OPEN_API_IN_QUERY = "query";

	public static final String SOA_PRIMITIVE_TYPE_NAME_BINARY = "Binary";
	public static final String SOA_PRIMITIVE_TYPE_NAME_BOOLEAN = "Boolean";
	public static final String SOA_PRIMITIVE_TYPE_NAME_DATE = "Date";
	public static final String SOA_PRIMITIVE_TYPE_NAME_DOUBLE = "Double";
	public static final String SOA_PRIMITIVE_TYPE_NAME_FLOAT = "Float";
	public static final String SOA_PRIMITIVE_TYPE_NAME_INTEGER = "Integer";
	public static final String SOA_PRIMITIVE_TYPE_NAME_LONG = "Long";
	public static final String SOA_PRIMITIVE_TYPE_NAME_STRING = "String";
	public static final String SOA_PRIMITIVE_TYPE_NAME_TIME = "Time";
	public static final String SOA_PRIMITIVE_TYPE_NAME_TIMESTAMP = "Timestamp";

	private static final Map<String, Schema> dataTypePrototypeSchemas = new HashMap<>();
	static {
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_BINARY,
				createSchema(OPEN_API_TYPE_STRING, OPEN_API_FORMAT_BINARY));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_DATE,
				createSchema(OPEN_API_TYPE_STRING, OPEN_API_FORMAT_DATE));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_STRING, createSchema(OPEN_API_TYPE_STRING, null));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_TIME,
				createSchema(OPEN_API_TYPE_STRING, OPEN_API_FORMAT_DATETIME));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_TIMESTAMP,
				createSchema(OPEN_API_TYPE_STRING, OPEN_API_FORMAT_DATETIME));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_BOOLEAN, createSchema(OPEN_API_TYPE_BOOLEAN, null));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_INTEGER,
				createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT32));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_LONG,
				createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_FLOAT,
				createSchema(OPEN_API_TYPE_NUMBER, OPEN_API_FORMAT_FLOAT));
		dataTypePrototypeSchemas.put(SOA_PRIMITIVE_TYPE_NAME_DOUBLE,
				createSchema(OPEN_API_TYPE_NUMBER, OPEN_API_FORMAT_DOUBLE));
	}

	public static Schema createPrimitiveTypeSchema(String primitiveTypeName) {
		Schema prototypeSchema = dataTypePrototypeSchemas.get(primitiveTypeName);
		if (prototypeSchema != null) {
			return createSchema(getSingleSchemaType(prototypeSchema), prototypeSchema.getFormat());
		}

		return null;
	}

	public static String getPrimitiveTypeName(Schema schema) {
		String primitiveTypeName = null;
		String schemaType = getSingleSchemaType(schema);
		if (OPEN_API_TYPE_STRING.equals(schemaType)) {
			if (OPEN_API_FORMAT_BINARY.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_BINARY;
			} else if (OPEN_API_FORMAT_DATE.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_DATE;
			} else if (OPEN_API_FORMAT_DATETIME.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_TIMESTAMP;
			} else {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_STRING;
			}
		} else if (OPEN_API_TYPE_BOOLEAN.equals(schemaType)) {
			primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_BOOLEAN;
		} else if (OPEN_API_TYPE_INTEGER.equals(schemaType)) {
			if (OPEN_API_FORMAT_INT32.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_INTEGER;
			} else if (OPEN_API_FORMAT_INT64.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_LONG;
			} else {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_LONG;
			}
		} else if (OPEN_API_TYPE_NUMBER.equals(schemaType)) {
			if (OPEN_API_FORMAT_FLOAT.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_FLOAT;
			} else if (OPEN_API_FORMAT_DOUBLE.equals(schema.getFormat())) {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_DOUBLE;
			} else {
				primitiveTypeName = SOA_PRIMITIVE_TYPE_NAME_DOUBLE;
			}
		}

		return primitiveTypeName;
	}

	private static <T> Schema<T> createSchema(String type, String format) {
		// OpenAPI 3.1.0 Schema.
		Schema<T> schema = new Schema<>();
		Set<String> types = new HashSet<>();
		types.add(type);
		schema.setTypes(types);

		schema.setFormat(format);
		return schema;
	}

	public static boolean isEnum(Schema schema) {
		return OPEN_API_TYPE_STRING.equals(getSingleSchemaType(schema)) && schema.getEnum() != null
				&& !schema.getEnum().isEmpty();
	}

	/**
	 * <p>
	 * Gets the single type of a Schema from an OpenAPI 3.1.0 version.<br>
	 * Note: OpenAPI 3.0 schema is not managed here and should be converted into
	 * OpenAPI 3.1.0 schema beforehand. Managing of Schema type in OpenAPI 3.0
	 * version is different.
	 * </p>
	 * <p>
	 * <b>Actually multiple types are possible, but for the moment only one type is
	 * currently managed for a Schema.</b>
	 * </p>
	 * <p>
	 * By default, if several values are found including
	 * {@value #OPEN_API_TYPE_STRING}, the latter is returned.
	 * </p>
	 * <p>
	 * By default, if several values are found including
	 * {@value #OPEN_API_TYPE_OBJECT}, the latter is returned.
	 * </p>
	 * 
	 * @param schema
	 * @return
	 */
	public static String getSingleSchemaType(Schema schema) {
		// OpenAPI 3.1
		if(schema == null) {
			return null;
		}
		Set types = schema.getTypes();
		if (types == null) {
			return OPEN_API_TYPE_OBJECT;
		}
		if (types.size() == 1) {
			return (String) types.toArray()[0];
		} else if (types.size() > 1) {
			if (types.contains(OPEN_API_TYPE_STRING)) {
				return OPEN_API_TYPE_STRING;
			}
			if (types.contains(OPEN_API_TYPE_OBJECT)) {
				return OPEN_API_TYPE_OBJECT;
			}
		}
		return null;
	}

	public static boolean isObject(Schema schema) {
		return OPEN_API_TYPE_OBJECT.equals(getSingleSchemaType(schema));
	}

	/**
	 * Workaround to determine whether schema is an ArraySchema. Due to bug:
	 * https://github.com/OpenAPITools/openapi-generator/issues/14200 OpenAPI 3.1.0
	 * arrays are unmarshalled as JsonSchema instead of ArraySchema as in OpenAPI
	 * 3.0.0.
	 * 
	 * @param schema
	 * @return
	 */
	public static boolean isArraySchema(Schema schema) {
		return (schema instanceof ArraySchema)
				|| ("array".equals(getSingleSchemaType(schema)) && schema instanceof JsonSchema);
	}
}
