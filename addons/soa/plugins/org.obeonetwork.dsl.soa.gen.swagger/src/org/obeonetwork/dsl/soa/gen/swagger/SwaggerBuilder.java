package org.obeonetwork.dsl.soa.gen.swagger;

import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.emptyIfNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.gen.swagger.utils.OperationGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ParameterGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.PropertyGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ServiceGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.StreamUtils;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SystemGenUtil;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;

public class SwaggerBuilder {

    private static final String COMPONENT_SCHEMA_$REF = "#/components/schemas/";
    
    private static final String OPEN_API_TYPE_OBJECT = "object";
    private static final String OPEN_API_TYPE_STRING = "string";
    private static final String OPEN_API_TYPE_NUMBER = "number";
    private static final String OPEN_API_TYPE_INTEGER = "integer";
    private static final String OPEN_API_TYPE_BOOLEAN = "boolean";
    
    private static final String OPEN_API_FORMAT_BINARY = "binary";
    private static final String OPEN_API_FORMAT_DATE = "date";
    private static final String OPEN_API_FORMAT_DOUBLE = "double";
    private static final String OPEN_API_FORMAT_FLOAT = "float";
    private static final String OPEN_API_FORMAT_INT32 = "int32";
    private static final String OPEN_API_FORMAT_INT64 = "int64";
    private static final String OPEN_API_FORMAT_DATETIME = "date-time";
    
    private static final String OPEN_API_IN_BODY = "body";
    private static final String OPEN_API_IN_COOKIE = "cookie";
    private static final String OPEN_API_IN_HEADER = "header";
    private static final String OPEN_API_IN_PATH = "path";
    private static final String OPEN_API_IN_QUERY = "query";
    
	protected System soaSystem;
	
	protected OpenAPI openApi;

	public SwaggerBuilder(System system) {
		this.soaSystem = system;
	}

	public OpenAPI createOpenAPI() {
    	openApi = new OpenAPI();
    	
    	buildHeader();
    	buildComponents();
    	buildPaths();
    	
		return openApi;
	}

	//// Header ////
	
    private void buildHeader() {
    	openApi.setInfo(createInfo());
    	openApi.setServers(createServers());
	}
    
	private Info createInfo() {
    	Info info = new Info();
    	info.setTitle(SystemGenUtil.getName(soaSystem));
		info.setDescription(soaSystem.getDescription());
		info.setVersion(Integer.toString(soaSystem.getVersion()));
    	info.setLicense(createLicense());
    	return info;
    }
    
    private License createLicense() {
    	License license = new License();
    	license.setName("Apache 2.0");
        license.setUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        return license;
	}
    
    private List<Server> createServers() {
    	if(falseForFutureEvolution()) {
        	// Handle multiple servers
    	}
    	List<Server> servers = new ArrayList<>();
    	servers.add(createDefaultServer());
    	return servers;
	}

	private Server createDefaultServer() {
    	Server server = new Server();
    	server.setUrl(emptyIfNull(soaSystem.getURL()));
    	return server;
	}

	//// Components ////
	
    private void buildComponents() {
    	openApi.setComponents(new Components());
    	
    	// Enums
    	StreamUtils.asStream(soaSystem.eAllContents())
    	.filter(Enumeration.class::isInstance).map(Enumeration.class::cast)
    	.forEach(soaEnumeration -> buildSoaEnumerationComponent(soaEnumeration));
    	
    	// DTOs
    	StreamUtils.asStream(soaSystem.eAllContents())
    	.filter(DTO.class::isInstance).map(DTO.class::cast)
    	.forEach(soaDto -> buildSoaDtoComponent(soaDto));
    	
    }
	
    private void buildSoaEnumerationComponent(Enumeration soaEnumeration) {
    	openApi.getComponents().addSchemas(getSoaTypeKey(soaEnumeration), createSoaEnumerationSchema(soaEnumeration));
    }
    
	private Schema<Object> createSoaEnumerationSchema(Enumeration soaEnumeration) {
		Schema<Object> schema = createSchema(OPEN_API_TYPE_STRING, null);
		soaEnumeration.getLiterals().forEach(soaLiteral -> schema.addEnumItemObject(soaLiteral.getName()));
		return schema;
	}

    private void buildSoaDtoComponent(DTO soaDto) {
    	openApi.getComponents().addSchemas(getSoaTypeKey(soaDto), createSoaDtoSchema(soaDto));
    }
    
    private Schema<Object> createSoaDtoSchema(DTO soaDto) {
    	Schema<Object> dtoSchema = null;
    	
		Schema<Object> schema = createSchema(OPEN_API_TYPE_OBJECT, null);
		schema.setDescription(soaDto.getDescription());
		
		soaDto.getAttributes().forEach(a -> buildProperty(schema, a));
		
		soaDto.getReferences().forEach(r -> buildProperty(schema, r));
		
		if(soaDto.getSupertype() != null) {
			dtoSchema = createComposedSchema(schema, soaDto.getSupertype());
		} else {
			dtoSchema = schema;
		}
		
		return dtoSchema;
		
	}

	private Schema<Object> createComposedSchema(Schema<Object> schema, StructuredType superType) {
		ComposedSchema composedSchema = new ComposedSchema();
		composedSchema.addAllOfItem(createTypeUseSchema(superType));
		composedSchema.addAllOfItem(schema);
		return composedSchema;
	}

	private void buildProperty(Schema<Object> schema, Property soaProperty) {
		schema.addProperties(soaProperty.getName(), createSoaPropertySchema(soaProperty));
		
		if(PropertyGenUtil.isRequired(soaProperty)) {
			schema.addRequiredItem(soaProperty.getName());
		}
	}

	protected Schema<Object> createSoaPropertySchema(Property soaProperty) {
		Schema<Object> schema = createTypeUseSchema(PropertyGenUtil.getType(soaProperty));
		
		// Set read only
    	if(soaProperty.isIsIdentifier()) {
    		schema.readOnly(true);
    	}
    	
    	// Set default value
    	if(falseForFutureEvolution()) {
//        	schema.setDefault(defaultValue);
    	}
		
		if(PropertyGenUtil.isMany(soaProperty)) {
			schema = createArraySchema(schema, soaProperty);
		}
		
		return schema;
	}
	
	private Schema<Object> createArraySchema(Schema<Object> schema, Property soaProperty) {
    	ArraySchema arraySchema = new ArraySchema();
    	arraySchema.minItems(PropertyGenUtil.getLowerBound(soaProperty));
		arraySchema.setItems(schema);
		return arraySchema;
	}

	private Schema<Object> createTypeUseSchema(Type soaType) {
    	Schema<Object> schema = new Schema<>();
		if(soaType instanceof StructuredType || soaType instanceof Enumeration) {
			schema.set$ref(getType$ref(soaType));
		} else {
			schema = createSoaDataTypeSchema((DataType)soaType);
		}
		return schema;
	}

	private String getType$ref(Type soaType) {
    	StringBuilder reference = new StringBuilder(COMPONENT_SCHEMA_$REF);
    	reference.append(getSoaTypeKey(soaType));
    	return reference.toString();
	}

	private String getSoaTypeKey(Type soaType) {
		return soaType.getName();
	}

    private static final Map<String, Schema<Object>> dataTypePrototypeSchemas = new HashMap<>();
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
	private Schema<Object> createSoaDataTypeSchema(DataType soaDataType) {
		Schema<Object> prototypeSchema = dataTypePrototypeSchemas.get(soaDataType.getName());
		if(prototypeSchema != null) {
			return createSchema(prototypeSchema.getType(), prototypeSchema.getFormat());
		}
		
		return null;
	}

	protected static <T> Schema<T> createSchema(String type, String format) {
    	Schema<T> schema = new Schema<>();
    	schema.setType(type);
    	schema.setFormat(format);
    	return schema;
    }

	//// Paths ////
	
	private void buildPaths() {
		openApi.setPaths(new Paths());
		
		soaSystem.getOwnedComponents().stream()
		.flatMap(soaComponent -> soaComponent.getProvidedServices().stream())
		.map(soaService -> soaService.getOwnedInterface())
		.flatMap(soaInterface -> soaInterface.getOwnedOperations().stream())
		.forEach(soaOperation -> buildPathItem(soaOperation));
	}

	private void buildPathItem(org.obeonetwork.dsl.soa.Operation soaOperation) {
		
		String operationUri = getSoaOperationUri(soaOperation);
		
		PathItem pathItem = getOrCreatePathItem(operationUri);
		
		switch (soaOperation.getVerb()) {
		case GET:
			pathItem.setGet(createOperation(soaOperation));
			break;
		case PUT:
			pathItem.setPut(createOperation(soaOperation));
			break;
		case POST:
			pathItem.setPost(createOperation(soaOperation));
			break;
		case DELETE:
			pathItem.setDelete(createOperation(soaOperation));
			break;
		default:
			break;
		}
	}

	private String getSoaOperationUri(org.obeonetwork.dsl.soa.Operation soaOperation) {
		StringBuilder soaOperationUri = new StringBuilder();
		soaOperationUri.append(emptyIfNull(soaOperation.getURI()));
		
		Service soaService = OperationGenUtil.getService(soaOperation);
		soaOperationUri.insert(0, emptyIfNull(soaService.getURI()));
		
		Component soaComponent = ServiceGenUtil.getComponent(soaService);
		soaOperationUri.insert(0, emptyIfNull(soaComponent.getURI()));
		
		return soaOperationUri.toString();
	}

	private PathItem getOrCreatePathItem(String uri) {
		PathItem pathItem = openApi.getPaths().get(uri);
		if(pathItem == null) {
			pathItem = new PathItem();
			openApi.getPaths().addPathItem(uri, pathItem);
		}		
		return pathItem;
	}

	private Operation createOperation(org.obeonetwork.dsl.soa.Operation soaOperation) {
    	Operation operation = new Operation();
    	operation.operationId(soaOperation.getName());
    	
		operation.addTagsItem(OperationGenUtil.getComponent(soaOperation).getName());
//		operation.summary(soaOperation.getDescription());
		operation.description(soaOperation.getDescription());
//		operation.deprecated(soaOperation.isDeprecated());
    	
    	buildParameters(operation, soaOperation);
    	buildApiResponses(operation, soaOperation);
    	
    	return operation;
	}
	
    private void buildApiResponses(Operation operation, org.obeonetwork.dsl.soa.Operation soaOperation) {
    	operation.setResponses(createApiResponses(soaOperation));
	}
    
	private ApiResponses createApiResponses(org.obeonetwork.dsl.soa.Operation soaOperation) {
		ApiResponses apiResponses = new ApiResponses();
		
		buildDefaultApiResponses(apiResponses, soaOperation);
		
    	soaOperation.getOutput().stream().forEach(soaOutputParameter -> buildApiResponse(apiResponses, soaOutputParameter));
    	
    	soaOperation.getFault().stream().forEach(soaFaultParameter -> buildApiResponse(apiResponses, soaFaultParameter));
    	
		return apiResponses;
	}

	private void buildDefaultApiResponses(ApiResponses apiResponses, org.obeonetwork.dsl.soa.Operation soaOperation) {
		if(soaOperation.getOutput().isEmpty() && soaOperation.getVerb() == Verb.DELETE) {
			ApiResponse apiResponse = new ApiResponse();
			String statusCode = getDefaultOutputStatusCode(soaOperation);
			String description = getDefaultDescriptionFromStatusCode(statusCode);
			apiResponse.description(description);
			apiResponses.addApiResponse(statusCode, apiResponse);
		}
		
		if(soaOperation.getFault().isEmpty()) {
			ApiResponse apiResponse = new ApiResponse();
			String statusCode = getDefaultFaultStatusCode(soaOperation);
			String description = getDefaultDescriptionFromStatusCode(statusCode);
			apiResponse.description(description);
			apiResponse.content(createContentErrorResponse());
			apiResponses.addApiResponse(statusCode, apiResponse);
		}
		
	}
    
    private Content createContentErrorResponse() {
		Content content = new Content();
		content.addMediaType("application/json", createErrorMediaType());
		return content;
	}
    
    private MediaType createErrorMediaType() {
		MediaType mediaType = new MediaType();
		ArraySchema arraySchema = new ArraySchema();
		arraySchema.name("errors");
		arraySchema.items(createErrorSchema());
		mediaType.schema(arraySchema);
		return mediaType;
	}
    
    private <T> Schema<T> createErrorSchema() {
		Schema<T> error = createSchema(OPEN_API_TYPE_OBJECT, null);
		error.addProperties("code", createSchema(OPEN_API_TYPE_STRING, null));
		error.addProperties("message", createSchema(OPEN_API_TYPE_STRING, null));
		error.addProperties("internalReferenceId", createSchema(OPEN_API_TYPE_STRING, null));
		return error;
	}
    
	private void buildApiResponse(ApiResponses apiResponses, org.obeonetwork.dsl.soa.Parameter soaOutputParameter) {
		apiResponses.addApiResponse(getStatusCode(soaOutputParameter), createApiResponse(soaOutputParameter));
	}

	private ApiResponse createApiResponse(org.obeonetwork.dsl.soa.Parameter soaOutputParameter) {
			ApiResponse apiResponse = new ApiResponse();
			apiResponse.setDescription(getDescription(soaOutputParameter));
			
			if(/* ParameterGenUtil.getOperation(soaOutputParameter).isPaginable() */ falseForFutureEvolution()) {
				apiResponse.addHeaderObject("X-Total-Element", createResponseHeader(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
				apiResponse.addHeaderObject("X-Page-Element-Count", createResponseHeader(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
				apiResponse.addHeaderObject("Accept-Range", createResponseHeader(OPEN_API_TYPE_STRING, null));
				apiResponse.addHeaderObject("Content-Range", createResponseHeader(OPEN_API_TYPE_STRING, null));
				apiResponse.addHeaderObject("Link", createResponseHeader(OPEN_API_TYPE_STRING, null));
			}
			
			if(soaOutputParameter.getType() != null){
				apiResponse.setContent(createContent(soaOutputParameter));
			}
			
			return apiResponse;
		}
	
	private Header createResponseHeader(String type, String format) {
		Header header = new Header();
		header.schema(createSchema(type, format));
		return header;
	}
	
	private String getDescription(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		String description = null;
		if(soaParameter.getDescription() != null && !soaParameter.getDescription().trim().isEmpty()) {
			description = soaParameter.getDescription();
		} else {
			description = getDefaultDescriptionFromStatusCode(getStatusCode(soaParameter));
		}
		return description;
	}

	private String getStatusCode(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		String statusCode = soaParameter.getStatusCode();
		if(statusCode == null) {
			if(ParameterGenUtil.isOutput(soaParameter)) {
				statusCode = getDefaultOutputStatusCode(ParameterGenUtil.getOperation(soaParameter));
			}
			if((ParameterGenUtil.isFault(soaParameter))) {
				statusCode = getDefaultFaultStatusCode(ParameterGenUtil.getOperation(soaParameter));
			}
		}
		return statusCode;
	}

	private String getDefaultFaultStatusCode(org.obeonetwork.dsl.soa.Operation soaOperation) {
		String statusCode = "404";
		if(soaOperation.getVerb() == Verb.POST) {
			statusCode = "400";
		}
		return statusCode;
	}

	private String getDefaultOutputStatusCode(org.obeonetwork.dsl.soa.Operation soaOperation) {
		String statusCode = "200";
		if(soaOperation.getVerb() == Verb.GET) {
//			if(soaOperation.isPaginable()){
//				statusCode = "206";
//			}
		} else if(soaOperation.getVerb() == Verb.DELETE) {
			statusCode = "204";
		} else if (soaOperation.getVerb() == Verb.PUT || soaOperation.getVerb() == Verb.POST) {
			statusCode = "201";
		}
		return statusCode;
	}

    private static final Map<String, String> defaultDescriptionByStatusCode = new HashMap<>();
    static {
    	defaultDescriptionByStatusCode.put("200", "Ok");
    	defaultDescriptionByStatusCode.put("206", "Partial Content");
    	defaultDescriptionByStatusCode.put("204", "No Content");
    	defaultDescriptionByStatusCode.put("201", "Created");
    	defaultDescriptionByStatusCode.put("404", "Not Found");
    	defaultDescriptionByStatusCode.put("400", "Bad Request");
    }
    private String getDefaultDescriptionFromStatusCode(String statusCode) {
    	String description = defaultDescriptionByStatusCode.get(statusCode);
    	if(description == null) {
    		description = "Unknown Status Code";
    	}
    	
    	return description;
    }
    

	private Operation buildParameters(Operation operation, org.obeonetwork.dsl.soa.Operation soaOperation) {
    	soaOperation.getInput().stream()
    	.filter(soaParameter -> soaParameter.getPassingMode() != ParameterPassingMode.BODY)
    	.forEach(soaParameter -> buildParameter(operation, soaParameter));
    	
    	soaOperation.getInput().stream()
    	.filter(soaParameter -> soaParameter.getPassingMode() == ParameterPassingMode.BODY)
    	.forEach(soaParameter -> buildRequestBody(operation, soaParameter));
    	
    	if(/* soaOperation.isSortable() */ falseForFutureEvolution()) {
    		buildSortParameter(operation);
    	}
    	
    	if(/* soaOperation.isPaginable() */ falseForFutureEvolution()) {
    		buildPaginableSizeParameter(operation, soaOperation);
    		buildPaginablePageParameter(operation);
    	}
    	
    	return operation;
	}
    
	private void buildParameter(Operation operation, org.obeonetwork.dsl.soa.Parameter soaParameter) {
		operation.addParametersItem(createParameter(soaParameter));
	}

    private Parameter createParameter(org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	Parameter parameter = createParameter(soaParameter.getName(), ParameterGenUtil.isRequired(soaParameter), getIn(soaParameter));
    	parameter.setSchema(createParameterSchema(soaParameter));
    	return parameter;
    }
    
	protected Schema<Object> createParameterSchema(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		
		Schema<Object> schema = createTypeUseSchema(soaParameter.getType());
		
		if(ParameterGenUtil.isMany(soaParameter)) {
			schema = createArraySchema(schema, soaParameter);
		}
		
		return schema;
	}
	
	private Schema<Object> createArraySchema(Schema<Object> schema, org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	ArraySchema arraySchema = new ArraySchema();
    	arraySchema.minItems(ParameterGenUtil.getLowerBound(soaParameter));
		arraySchema.setItems(schema);
		return arraySchema;
	}

	private void buildRequestBody(Operation operation, org.obeonetwork.dsl.soa.Parameter soaParameter) {
		operation.requestBody(createRequestBody(soaParameter));
	}
	
    private RequestBody createRequestBody(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		RequestBody requestBody = new RequestBody();
		requestBody.setContent(createContent(soaParameter));
		return requestBody;
	}
    
    private Content createContent(org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	Content content = new Content();
    	content.addMediaType("application/json", createMediaType(soaParameter));
    	return content;
    }
    
    private MediaType createMediaType(org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	MediaType mediaType = new MediaType();
    	mediaType.schema(createParameterSchema(soaParameter));
    	return mediaType;
    }
    
	private void buildSortParameter(Operation operation) {
    	Parameter param = createParameter("sort", false, OPEN_API_IN_QUERY);
    	param.schema(createSchema(OPEN_API_TYPE_STRING, null));
    	operation.addParametersItem(param);
    }
    
    private void buildPaginableSizeParameter(Operation operation, org.obeonetwork.dsl.soa.Operation soaOperation) {
    	Parameter sizeParameter = createParameter("size", false, OPEN_API_IN_QUERY);
    	sizeParameter.schema(createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
//    	sizeParameter.description("Default size : " + soaOperation.getDefautPageSize());
    	operation.addParametersItem(sizeParameter);
    }
    
    private void buildPaginablePageParameter(Operation operation) {
    	Parameter pageParameter = createParameter("page", false, OPEN_API_IN_QUERY);
    	pageParameter.schema(createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
    	operation.addParametersItem(pageParameter);
    }
    
    private Parameter createParameter(String name, Boolean required, String in) {
    	Parameter parameter = new Parameter();
    	parameter = parameter.name(name);
    	parameter = parameter.required(required);
    	parameter = parameter.in(in);
    	return parameter;
	}
    
    private String getIn(org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	String in = null;
    	
    	switch (soaParameter.getPassingMode()) {
		case BODY:
			in = OPEN_API_IN_BODY;
			break;
		case COOKIE:
			in = OPEN_API_IN_COOKIE;
			break;
		case HEADER:
			in = OPEN_API_IN_HEADER;
			break;
		case PATH:
			in = OPEN_API_IN_PATH;
			break;
		case QUERY:
			in = OPEN_API_IN_QUERY;
			break;
		default:
			break;
		}
    	
    	return in;
    }
    
    private boolean falseForFutureEvolution() {
		return false;
	}

}
