package org.obeonetwork.dsl.soa.gen.swagger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

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
    
	public static final String OPEN_API_IN_BODY = "body";
	public static final String OPEN_API_IN_COOKIE = "cookie";
	public static final String OPEN_API_IN_HEADER = "header";
	public static final String OPEN_API_IN_PATH = "path";
	public static final String OPEN_API_IN_QUERY = "query";
    
	public static final String QUALIFIED_KEY_SEPARATOR = "/";
    
    private static final Map<String, Schema> dataTypePrototypeSchemas = new HashMap<>();
    static {
		dataTypePrototypeSchemas.put("Binary",    createSchema(OPEN_API_TYPE_STRING,  OPEN_API_FORMAT_BINARY));
    	dataTypePrototypeSchemas.put("Boolean",   createSchema(OPEN_API_TYPE_BOOLEAN, null));
		dataTypePrototypeSchemas.put("Date",      createSchema(OPEN_API_TYPE_STRING,  OPEN_API_FORMAT_DATE));
		dataTypePrototypeSchemas.put("Double",    createSchema(OPEN_API_TYPE_NUMBER,  OPEN_API_FORMAT_DOUBLE));
		dataTypePrototypeSchemas.put("Float",     createSchema(OPEN_API_TYPE_NUMBER,  OPEN_API_FORMAT_FLOAT));
		dataTypePrototypeSchemas.put("Integer",   createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT32));
		dataTypePrototypeSchemas.put("Long",      createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
    	dataTypePrototypeSchemas.put("String",    createSchema(OPEN_API_TYPE_STRING,  null));
		dataTypePrototypeSchemas.put("Time",      createSchema(OPEN_API_TYPE_STRING,  OPEN_API_FORMAT_DATETIME));
    	dataTypePrototypeSchemas.put("Timestamp", createSchema(OPEN_API_TYPE_STRING,  OPEN_API_FORMAT_DATETIME));
    }
    public static Schema createPrimitiveTypeSchema(String primitiveTypeName) {
		Schema prototypeSchema = dataTypePrototypeSchemas.get(primitiveTypeName);
		if(prototypeSchema != null) {
			return createSchema(prototypeSchema.getType(), prototypeSchema.getFormat());
		}
		
		return null;
	}

	public static String getPrimitiveTypeName(Schema schema) {
		Entry<String, Schema> entry = dataTypePrototypeSchemas.entrySet().stream()
		.filter(e -> 
			Objects.equals(e.getValue().getType(), schema.getType())
			&& Objects.equals(e.getValue().getFormat(), schema.getFormat()))
		.findFirst().orElse(null);

		if(entry != null) {
			return entry.getKey();
		}
		return null;
    }
    
	private static <T> Schema<T> createSchema(String type, String format) {
    	Schema<T> schema = new Schema<>();
    	schema.setType(type);
    	schema.setFormat(format);
    	return schema;
    }
	
	public static boolean isPrimitiveType(Schema schema) {
		String type = schema.getType();
		List _enum = schema.getEnum();
		return OPEN_API_TYPE_INTEGER.equals(type) 
				|| (OPEN_API_TYPE_STRING.equals(type) && (_enum == null || _enum.isEmpty())) 
				|| OPEN_API_TYPE_NUMBER.equals(type) 
				|| OPEN_API_TYPE_BOOLEAN.equals(type);
	}

	public static boolean isEnum(Schema schema) {
		return OPEN_API_TYPE_STRING.equals(schema.getType()) 
				&& schema.getEnum() != null 
				&& !schema.getEnum().isEmpty();
	}

	public static boolean isObject(Schema schema) {
		return OPEN_API_TYPE_OBJECT.equals(schema.getType());
	}
	
}
