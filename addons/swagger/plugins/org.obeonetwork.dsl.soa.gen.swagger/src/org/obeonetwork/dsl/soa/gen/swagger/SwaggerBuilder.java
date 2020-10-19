/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger;

import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_200;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_200_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_201;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_201_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_204;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_204_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_206;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_206_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_400;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_400_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_404;
import static org.obeonetwork.dsl.soa.gen.swagger.HTTPStatusCodes.HTTP_404_DESC;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.COMPONENT_SCHEMA_$REF;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_FORMAT_INT64;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_IN_BODY;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_IN_COOKIE;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_IN_HEADER;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_IN_PATH;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_IN_QUERY;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_INTEGER;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_OBJECT;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_STRING;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.createPrimitiveTypeSchema;
import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.emptyIfNull;
import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.isNullOrWhite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ComponentGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.OperationGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ParameterGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.PropertyGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ServiceGenUtil;

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

@SuppressWarnings("unchecked")
public class SwaggerBuilder {

	public static final String SOA_SIZE_PARAMETER_NAME = "size";
	public static final String SOA_PAGE_PARAMETER_NAME = "page";

	private static final String QUALIFIED_TYPE_NAME_SEPARATOR = "_";

	private OpenAPI openApi;
	
	private Component soaComponent;
	
	private Collection<Type> exposedSoaTypes = null;
	private Map<Type, String> exposedSoaTypeKeys = null;

	private boolean computeShortestKey = false;

	private int status;

	public SwaggerBuilder(Component soaComponent) {
		this.soaComponent = soaComponent;
	}
	
	public int build() {
		status = IStatus.OK;
		
		createOpenAPI();
		
		return status;
	}

	private void logError(String message) {
		Activator.logError(message);
		status = IStatus.ERROR;
	}
	
	public OpenAPI getOpenAPI() {
		return openApi;
	}
	
	private OpenAPI createOpenAPI() {
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
    	info.setTitle(ComponentGenUtil.getName(soaComponent));
		info.setDescription(soaComponent.getDescription());
		info.setVersion(soaComponent.getApiVersion());
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
    	Server defaultServer = createDefaultServer();
    	if(defaultServer != null) {
    		servers.add(defaultServer);
    	}
    	return servers;
	}

	private Server createDefaultServer() {
    	Server server = null;
    	if(!isNullOrWhite(soaComponent.getURL())) {
    		server = new Server();
        	server.setUrl(soaComponent.getURL().trim());
    	}
    	return server;
	}

	//// Components ////
	
    private void buildComponents() {
    	openApi.setComponents(new Components());
    	
    	exposedSoaTypes = ComponentGenUtil.getExposedTypes(soaComponent);
    	
    	// Compute the exposed Soa Types keys
    	exposedSoaTypeKeys = new HashMap<>();
    	
    	if(exposedSoaTypes.size() == 1) {
    		Type soaType = exposedSoaTypes.iterator().next();
    		exposedSoaTypeKeys.put(soaType, soaType.getName());
    	} else {
        	if(computeShortestKey ) {
            	Map<String, Type> keyReferential = new HashMap<>();
            	for(Type soaType : exposedSoaTypes) {
            		String key = computeSoaTypeKey(soaType, "");
            		
            		// While computed key is already in use
            		while(keyReferential.get(key) != null) {
            			// Compute a longer key for both objects matching the key
            			Type otherType = keyReferential.remove(key);
            			String otherKey = computeSoaTypeKey(otherType, key);
            			keyReferential.put(otherKey, otherType);
            			
            			key = computeSoaTypeKey(soaType, key);
            		}
            		keyReferential.put(key, soaType);
            	}
            	
            	keyReferential.entrySet().forEach(entry -> exposedSoaTypeKeys.put(entry.getValue(), entry.getKey()));
        	} else {
        		List<String> keys = new ArrayList<>();
            	for(Type soaType : exposedSoaTypes) {
            		keys.add(computeSoaTypeLongKey(soaType));
            	}
            	
            	int index = 0;
            	if(!keys.isEmpty() && ! keys.get(0).isEmpty()) {
                	boolean isCharAtIndexCommon = true;
                	while(isCharAtIndexCommon && index < keys.get(0).length()) {
                    	char charAtIndex = keys.get(0).charAt(index);
                    	int keyIndex = 1;
                    	while(isCharAtIndexCommon && keyIndex < keys.size()) {
                    		isCharAtIndexCommon = isCharAtIndexCommon && index < keys.get(keyIndex).length() && keys.get(keyIndex).charAt(index) == charAtIndex;
                    		keyIndex++;
                    	}
                    	if(isCharAtIndexCommon) {
                    		index++;
                    	}
                	}
            	}
            	
            	for(Type soaType : exposedSoaTypes) {
            		exposedSoaTypeKeys.put(soaType, computeSoaTypeLongKey(soaType).substring(index));
            	}
        	}
    	}
    	
    	
    	// Build the components
    	exposedSoaTypes.forEach(exposedSoaType -> buildComponent(exposedSoaType));
    	
    }
	
	private String computeSoaTypeLongKey(Type soaType) {
		StringBuffer computedKey = new StringBuffer(soaType.getName());
		Object qnElement = getQNParent(soaType);
		while(qnElement != null) {
			computedKey.insert(0, QUALIFIED_TYPE_NAME_SEPARATOR);
			computedKey.insert(0, asQNSegment(qnElement));
			qnElement = getQNParent(qnElement);
		}
		
		return computedKey.toString();
	}

	private String computeSoaTypeKey(Type soaType, String key) {
		StringBuffer computedKey = new StringBuffer(asQNSegment(soaType));
		Object parent = getQNParent(soaType);
		while(computedKey.length() <= key.length() && parent != null) {
			computedKey.insert(0, QUALIFIED_TYPE_NAME_SEPARATOR);
			computedKey.insert(0, asQNSegment(parent));
			parent = getQNParent(parent);
		}
		
		return computedKey.toString();
	}
    
	private String asQNSegment(Object qnElement) {
		String qnSegment = null;
		if(qnElement instanceof EObject) {
			EObject eObject = (EObject) qnElement;
			EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
			if(nameFeature != null) {
				qnSegment = (String) eObject.eGet(nameFeature);
			}
			if(isNullOrWhite(qnSegment)) {
				if(eObject.eClass() == EntityPackage.eINSTANCE.getRoot()) {
					qnSegment = "Entities";
				} else {
					qnSegment = eObject.eClass().getName();
				}
			}
		} else if(qnElement instanceof Resource) {
			Resource resource = (Resource) qnElement;
			qnSegment = resource.getURI().lastSegment();
		}
		
		return qnSegment.replaceAll("\\.", QUALIFIED_TYPE_NAME_SEPARATOR);
	}
	
	private Object getQNParent(Object qnElement) {
		Object parent = null;
		
		if(qnElement instanceof Resource) {
			return null;
		}
		
		if(qnElement instanceof EObject) {
			EObject eObject = (EObject)qnElement;
			
			parent = eObject.eContainer();
			if(parent == null) {
				parent = eObject.eResource();
			}
		}
		
		// Skip the model root and move to the containing resource
		if(parent instanceof EObject && isModelRoot((EObject)parent)) {
			parent = getQNParent(parent);
		}

		return parent;
	}

	private boolean isModelRoot(EObject eObject) {
		return (!(eObject instanceof Resource)) && (eObject.eContainer() == null || eObject.eContainer() instanceof Resource);
	}
	
	private void buildComponent(Type soaType) {
    	openApi.getComponents().addSchemas(getSoaTypeKey(soaType), createSchema(soaType));
    }
    
	private <T> Schema<T> createSchema(String type, String format) {
    	Schema<T> schema = new Schema<>();
    	schema.setType(type);
    	schema.setFormat(format);
    	return schema;
    }
	
	private Schema<Object> createSchema(Type soaType) {
		Schema<Object> schema = null;
		if(soaType instanceof Enumeration) {
			schema = createSoaEnumerationSchema((Enumeration) soaType);
		} else if(soaType instanceof StructuredType) {
			schema = createSoaStructuredTypeSchema((StructuredType) soaType);
		}
		return schema;
	}
	
	private Schema<Object> createSoaEnumerationSchema(Enumeration soaEnumeration) {
		Schema<Object> schema = createSchema(OPEN_API_TYPE_STRING, null);
		soaEnumeration.getLiterals().forEach(soaLiteral -> schema.addEnumItemObject(soaLiteral.getName()));
		return schema;
	}

    private Schema<Object> createSoaStructuredTypeSchema(StructuredType soaStructuredType) {
    	Schema<Object> structuredTypeSchema = null;
    	
		Schema<Object> schema = createSchema(OPEN_API_TYPE_OBJECT, null);
		schema.setDescription(soaStructuredType.getDescription());
		
		soaStructuredType.getAttributes().forEach(a -> buildProperty(schema, a));
		
		soaStructuredType.getReferences().forEach(r -> buildProperty(schema, r));
		
		if(soaStructuredType.getSupertype() != null) {
			structuredTypeSchema = createComposedSchema(schema, soaStructuredType.getSupertype());
		} else {
			structuredTypeSchema = schema;
		}
		
		return structuredTypeSchema;
		
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

	private Schema<Object> createSoaPropertySchema(Property soaProperty) {
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
    	Schema<Object> schema = null;
    	if(soaType == null) {
    		schema = new Schema<>();
    	} else if(soaType instanceof StructuredType || soaType instanceof Enumeration) {
    		schema = new Schema<>();
			schema.set$ref(getType$ref(soaType));
		} else {
			schema = createPrimitiveTypeSchema(soaType.getName());
		}
    	
		if(schema == null) {
			logError(String.format("Unsupported type : %s.", soaType.getName()));
			schema = new Schema<>();
		}
		return schema;
	}

	private String getType$ref(Type soaType) {
    	StringBuilder reference = new StringBuilder(COMPONENT_SCHEMA_$REF);
    	reference.append(getSoaTypeKey(soaType));
    	return reference.toString();
	}

	private String getSoaTypeKey(Type soaType) {
		return exposedSoaTypeKeys.get(soaType);
	}

	//// Paths ////
	
	private void buildPaths() {
		openApi.setPaths(new Paths());
		
		soaComponent.getProvidedServices().stream()
		.flatMap(soaService -> soaService.getOwnedInterface().getOwnedOperations().stream())
		.filter(o -> o.getExposition() == ExpositionKind.REST)
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
    	
		operation.addTagsItem(OperationGenUtil.getService(soaOperation).getName());
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
		
		OperationGenUtil.getOutput(soaOperation).stream().forEach(soaOutputParameter -> buildApiResponse(apiResponses, soaOutputParameter));
    	
		OperationGenUtil.getFault(soaOperation).stream().forEach(soaFaultParameter -> buildApiResponse(apiResponses, soaFaultParameter));
    	
		return apiResponses;
	}

	private void buildDefaultApiResponses(ApiResponses apiResponses, org.obeonetwork.dsl.soa.Operation soaOperation) {
		if(OperationGenUtil.getOutput(soaOperation).isEmpty() && soaOperation.getVerb() == Verb.DELETE) {
			ApiResponse apiResponse = new ApiResponse();
			String statusCode = getDefaultOutputStatusCode(soaOperation);
			String description = getDefaultDescriptionFromStatusCode(statusCode);
			apiResponse.description(description);
			apiResponses.addApiResponse(statusCode, apiResponse);
		}
		
		if(OperationGenUtil.getFault(soaOperation).isEmpty()) {
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
			
			if(ParameterGenUtil.getOperation(soaOutputParameter).isPaged()) {
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
		if(!isNullOrWhite(soaParameter.getDescription())) {
			description = soaParameter.getDescription();
		} else {
			description = getDefaultDescriptionFromStatusCode(getStatusCode(soaParameter));
		}
		return description;
	}

	private String getStatusCode(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		String statusCode = soaParameter.getStatusCode();
		if(isNullOrWhite(statusCode)) {
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
		String statusCode = HTTP_404;
		if(soaOperation.getVerb() == Verb.POST) {
			statusCode = HTTP_400;
		}
		return statusCode;
	}

	private String getDefaultOutputStatusCode(org.obeonetwork.dsl.soa.Operation soaOperation) {
		String statusCode = HTTP_200;
		if(soaOperation.getVerb() == Verb.GET) {
			if(soaOperation.isPaged()){
				statusCode = HTTP_206;
			}
		} else if(soaOperation.getVerb() == Verb.DELETE) {
			statusCode = HTTP_204;
		} else if (soaOperation.getVerb() == Verb.PUT || soaOperation.getVerb() == Verb.POST) {
			statusCode = HTTP_201;
		}
		return statusCode;
	}

    private static final Map<String, String> defaultDescriptionByStatusCode = new HashMap<>();
    static {
    	defaultDescriptionByStatusCode.put(HTTP_200, HTTP_200_DESC);
    	defaultDescriptionByStatusCode.put(HTTP_206, HTTP_206_DESC);
    	defaultDescriptionByStatusCode.put(HTTP_204, HTTP_204_DESC);
    	defaultDescriptionByStatusCode.put(HTTP_201, HTTP_201_DESC);
    	defaultDescriptionByStatusCode.put(HTTP_404, HTTP_404_DESC);
    	defaultDescriptionByStatusCode.put(HTTP_400, HTTP_400_DESC);
    }
    private String getDefaultDescriptionFromStatusCode(String statusCode) {
    	String description = defaultDescriptionByStatusCode.get(statusCode);
    	if(description == null) {
    		description = "Unknown Status Code";
    	}
    	
    	return description;
    }

	private Operation buildParameters(Operation operation, org.obeonetwork.dsl.soa.Operation soaOperation) {
    	OperationGenUtil.getInput(soaOperation).stream()
    	.filter(soaParameter -> soaParameter.getRestData().getPassingMode() != ParameterPassingMode.BODY)
    	.forEach(soaParameter -> buildParameter(operation, soaParameter));
    	
    	OperationGenUtil.getInput(soaOperation).stream()
    	.filter(soaParameter -> soaParameter.getRestData() != null)
    	.filter(soaParameter -> soaParameter.getRestData().getPassingMode() == ParameterPassingMode.BODY)
    	.forEach(soaParameter -> buildRequestBody(operation, soaParameter));
    	
    	if(/* soaOperation.isSortable() */ falseForFutureEvolution()) {
    		buildSortParameter(operation);
    	}
    	
    	if(soaOperation.isPaged() && soaOperation.getVerb() == Verb.GET) {
    		buildPaginableSizeParameter(operation, soaOperation);
    		buildPaginablePageParameter(operation);
    	}
    	
    	return operation;
	}
    
	private void buildParameter(Operation operation, org.obeonetwork.dsl.soa.Parameter soaParameter) {
		operation.addParametersItem(createParameter(soaParameter));
	}

    private Parameter createParameter(org.obeonetwork.dsl.soa.Parameter soaParameter) {
    	Parameter parameter = createParameter(ParameterGenUtil.getName(soaParameter), ParameterGenUtil.isRequired(soaParameter), getIn(soaParameter));
    	parameter.setSchema(createParameterSchema(soaParameter));
    	return parameter;
    }
    
	private Schema<Object> createParameterSchema(org.obeonetwork.dsl.soa.Parameter soaParameter) {
		
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
    	Parameter sizeParameter = createParameter(SOA_SIZE_PARAMETER_NAME, false, OPEN_API_IN_QUERY);
    	sizeParameter.schema(createSchema(OPEN_API_TYPE_INTEGER, OPEN_API_FORMAT_INT64));
//    	sizeParameter.description("Default size : " + soaOperation.getDefautPageSize());
    	operation.addParametersItem(sizeParameter);
    }
    
    private void buildPaginablePageParameter(Operation operation) {
    	Parameter pageParameter = createParameter(SOA_PAGE_PARAMETER_NAME, false, OPEN_API_IN_QUERY);
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
    	
    	switch (soaParameter.getRestData().getPassingMode()) {
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
