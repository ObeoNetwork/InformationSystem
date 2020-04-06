package org.obeonetwork.dsl.soa.gen.swagger;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;
import static org.obeonetwork.dsl.environment.design.services.ModelServices.getContainerOrSelf;
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logWarning;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.COMPONENT_SCHEMA_$REF;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.QUALIFIED_KEY_SEPARATOR;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.getPrimitiveTypeName;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isEnum;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isObject;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isPrimitiveType;
import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.upperFirst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.gen.swagger.utils.NamespaceGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SystemGenUtil;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.CookieParameter;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.PathParameter;
import io.swagger.v3.oas.models.parameters.QueryParameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SoaComponentBuilder {
	
	private static final String DEFAULT_FOR_UNNAMED = "unnamed";
	private static final String BODY_PARAMETER_NAME = "body";
	
	private OpenAPI openApi;
	private Environment environment;
	private System soaSystem;
	private Component soaComponent;

	public SoaComponentBuilder(OpenAPI swagger, System system, Environment environment) {
		this.openApi = swagger;
		this.soaSystem = system;
		this.environment = environment;
	}

	public Component createSoaComponent() {
		
		String soaComponentName = getSoaComponentName();
		if(soaComponentName == null) {
			logError("Component name could not be computed.");
			return null;
		}
		soaComponent = SystemGenUtil.getComponentByName(soaSystem, soaComponentName);
		if(soaComponent != null) {
			logError(String.format("Component with name %s already exist.", soaComponentName));
		}
		
		soaComponent = SoaFactory.eINSTANCE.createComponent();
		soaSystem.getOwnedComponents().add(soaComponent);
		soaComponent.setName(soaComponentName);
		
		Info info = openApi.getInfo();
		soaComponent.setName(info.getTitle());
		soaComponent.setDescription(info.getDescription());
		soaComponent.setApiVersion(info.getVersion());
		// ? info.getLicense();

		List<Server> servers = openApi.getServers();
		if(servers.size() > 1) {
			logWarning("Multiple servers not supported.");
		}
		
		if(!servers.isEmpty()) {
			Server server = servers.get(0);
			soaComponent.setURI(server.getUrl());
		}
		
		createSoaExposedTypes();
		
		createSoaServices();
		
		createSoaOperations();
		
		return soaComponent;
	}

	private String getSoaComponentName() {
		if(openApi.getInfo() != null) {
			return openApi.getInfo().getTitle();
		}
		return null;
	}

	private void createSoaOperations() {
		for(String path : openApi.getPaths().keySet()) {
			openApi.getPaths().get(path).readOperationsMap().entrySet().stream()
			.forEach(operationsMapEntry -> createSoaOperation(path, operationsMapEntry.getKey(), operationsMapEntry.getValue()));
		}
		
		java.lang.System.out.println("Qualified Operations URIs:");
		for(Service soaService : soaComponent.getProvidedServices()) {
			for(org.obeonetwork.dsl.soa.Operation soaOperation : soaService.getOwnedInterface().getOwnedOperations()) {
				java.lang.System.out.println(soaComponent.getURI() + soaService.getURI() + soaOperation.getURI());
			}
		}
	}

	private org.obeonetwork.dsl.soa.Operation createSoaOperation(String path, HttpMethod verb, Operation operation) {
		Service soaService = getSoaServiceFromPath(path);
		Interface soaInterface = getOrCreateInterface(soaService);
		
		org.obeonetwork.dsl.soa.Operation soaOperation = SoaFactory.eINSTANCE.createOperation();
		soaInterface.getOwnedOperations().add(soaOperation);
		
		String soaOperationUri = path.substring((soaComponent.getURI() + soaService.getURI()).length());
		soaOperation.setURI(soaOperationUri);
		
		String soaOperationName = null;
		if(operation.getOperationId() != null && !operation.getOperationId().isEmpty()) {
			soaOperationName = operation.getOperationId();
		} else {
			soaOperationName = verb.toString().toLowerCase() + camelCaseFromUri(soaService.getURI());
		}
		
		if(soaOperationName == null || soaOperationName.isEmpty()) {
			soaOperationName = DEFAULT_FOR_UNNAMED;
		}
		soaOperation.setName(soaOperationName);
		
		soaOperation.setDescription(operation.getDescription());
		
		Verb soaVerb = Verb.valueOf(verb.toString());
		if(soaVerb != null) {
			soaOperation.setVerb(soaVerb);
		} else {
			logError(String.format("Unsupported verb %s for path %s.", verb.toString(), path));
		}
		
		if(operation.getParameters() != null) {
			for(Parameter parameter : operation.getParameters()) {
				createSoaInputParameter(soaOperation, parameter);
			}
		}
		
		RequestBody requestBody = operation.getRequestBody();
		if(requestBody != null) {
			createSoaBodyParameter(soaOperation, requestBody);
		}
		
		ApiResponses responses = operation.getResponses();
		if(responses != null) {
			for(String responseKey : responses.keySet()) {
				createSoaResponseParameter(soaOperation, responseKey, responses.get(responseKey));
			}
		}
		
		return soaOperation;
	}

	private Interface getOrCreateInterface(Service soaService) {
		Interface soaInterface = soaService.getOwnedInterface();
		if(soaInterface == null) {
			soaInterface = SoaFactory.eINSTANCE.createInterface();
			soaService.setOwnedInterface(soaInterface);
			soaInterface.setName(soaService.getName());
		}
		return soaInterface;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaInputParameter(org.obeonetwork.dsl.soa.Operation soaOperation, Parameter parameter) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		soaOperation.getInput().add(soaParameter);
		
		soaParameter.setName(parameter.getName());
		
		soaParameter.setDescription(parameter.getDescription());
		
		soaParameter.setMultiplicity(computeMultiplicity(parameter.getRequired()!= null && parameter.getRequired(), parameter.getSchema()));
		
		if(parameter instanceof CookieParameter) {
			soaParameter.setPassingMode(ParameterPassingMode.COOKIE);
		} else if(parameter instanceof HeaderParameter) {
			soaParameter.setPassingMode(ParameterPassingMode.HEADER);
		} else if(parameter instanceof PathParameter) {
			soaParameter.setPassingMode(ParameterPassingMode.PATH);
		} else if(parameter instanceof QueryParameter) {
			soaParameter.setPassingMode(ParameterPassingMode.QUERY);
		} else {
			logError(String.format("Unsupported parameter type : %s.", parameter.getClass().getName()));
		}
		
		Schema schema = unwrapArraySchema(parameter.getSchema());
		
		Type soaParameterType = getOrCreateSoaParameterType(soaOperation, schema, parameter.getName());
		soaParameter.setType(soaParameterType);
		
		return soaParameter;
	}

	private String computeTypeNameFromParameterName(String parameterName) {
		return upperFirst(parameterName);
	}

	private Schema unwrapArraySchema(Schema schema) {
		if(schema instanceof ArraySchema) {
			return ((ArraySchema) schema).getItems();
		}
		return schema;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaBodyParameter(org.obeonetwork.dsl.soa.Operation soaOperation, RequestBody requestBody) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		soaOperation.getInput().add(soaParameter);
		soaParameter.setPassingMode(ParameterPassingMode.BODY);
		
		soaParameter.setName(BODY_PARAMETER_NAME);
		
		soaParameter.setDescription(requestBody.getDescription());
		
		if(requestBody.getContent() != null && !requestBody.getContent().isEmpty()) {
			Set<Entry<String, MediaType>> contents = requestBody.getContent().entrySet();
			if(contents.size() > 1) {
				logWarning("Multiple media types not supported. Taking the first typed one to define the request body.");
			}
			Schema schema = contents.stream()
					.map(c -> c.getValue())
					.filter(m -> m.getSchema() != null)
					.map(m -> m.getSchema())
					.findFirst().orElse(null);
			
			if(schema != null) {
				soaParameter.setMultiplicity(computeMultiplicity(requestBody.getRequired() != null && requestBody.getRequired(), schema));
				
				Schema unwrappedSchema = unwrapArraySchema(schema);
				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, BODY_PARAMETER_NAME);
				soaParameter.setType(soaParameterType);
			}
		}
		
		return soaParameter;
	}

	private Type getOrCreateSoaParameterType(org.obeonetwork.dsl.soa.Operation soaOperation, Schema schema, String parameterName) {
		Type soaParameterType = null;
		
		if(schema.get$ref() != null) {
			soaParameterType = getExposedTypeFrom$ref(schema.get$ref());
		} else {
			Namespace namespace = getOrCreateNamespaceForInlineTypes(soaOperation);
			String typeName = computeTypeNameFromParameterName(parameterName);
			if(isEnum(schema)) {
				Enumeration enumeration = touchEnumeration(namespace, typeName);
				updateEnumeration(enumeration, schema);
				soaParameterType = enumeration;
			} else if(isObject(schema)) {
				DTO dto = touchDto(namespace, typeName);
				updateDto(dto, schema);
				soaParameterType = dto;
			} else if(isPrimitiveType(schema)) {
				soaParameterType = getPrimitiveType(schema);
			} 
		}
		
		return soaParameterType;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaResponseParameter(org.obeonetwork.dsl.soa.Operation soaOperation, String responseKey, ApiResponse apiResponse) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		String parameterName = null;
		if(responseKey.matches("[123]..")) {
			soaOperation.getOutput().add(soaParameter);
			parameterName = "output" + responseKey;
		} else if(responseKey.matches("[45]..")) {
			soaOperation.getFault().add(soaParameter);
			parameterName = "fault" + responseKey;
		} else {
			logError(String.format("Unsupported status code : %s.", responseKey));
			return null;
		}
		soaParameter.setName(parameterName);
		soaParameter.setStatusCode(responseKey);

		soaParameter.setDescription(apiResponse.getDescription());
		
		if(apiResponse.getContent() != null && !apiResponse.getContent().isEmpty()) {
			Set<Entry<String, MediaType>> contents = apiResponse.getContent().entrySet();
			if(contents.size() > 1) {
				logWarning("Multiple media types not supported. Taking the first typed one to define the response type.");
			}
			Schema schema = contents.stream()
					.map(c -> c.getValue())
					.filter(m -> m.getSchema() != null)
					.map(m -> m.getSchema())
					.findFirst().orElse(null);
			
			if(schema != null) {
				soaParameter.setMultiplicity(computeMultiplicity(false, schema));
				
				Schema unwrappedSchema = unwrapArraySchema(schema);
				
				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, parameterName);
				soaParameter.setType(soaParameterType);
			}
		}
		
		return soaParameter;
	}

	private Service getSoaServiceFromPath(String path) {
		return soaComponent.getProvidedServices().stream()
		.filter(soaService -> path.startsWith(soaComponent.getURI() + soaService.getURI()))
		.findFirst().orElse(null);
	}

	private void createSoaServices() {
		
		/* Parse the paths of the api along their segments, building a tree
		 * based on the paths segments.
		 * 
		 * The longest path found starting from the root will serve as the 
		 * component uri.
		 * Then for each of the following sub segments, the longest path found 
		 * will serve as the segments uris.
		 * 
		 * The following algorithm uses a Map<String, Map> tree structure to 
		 * decompose the different paths in a structure removing the duplicated 
		 * segments.
		 */
		java.lang.System.out.println("Paths:");
		Map<String, Map> pathSegmentRoot = new HashMap<String, Map>();
		Map<String, Map> pathSegmentNodePointer = null;
		for(String path : openApi.getPaths().keySet()) {
			java.lang.System.out.println(path);
			pathSegmentNodePointer = pathSegmentRoot;
			for(String segment : Arrays.asList(path.split(QUALIFIED_KEY_SEPARATOR))) {
				if(!segment.isEmpty()) {
					Map<String, Map> pathSegmentSubNode = pathSegmentNodePointer.get(segment);
					if(pathSegmentSubNode == null) {
						pathSegmentSubNode = new HashMap<>();
						pathSegmentNodePointer.put(segment, pathSegmentSubNode);
					}
					pathSegmentNodePointer = pathSegmentSubNode;
				}
			}
		}
		
		// If if the root is not unique, create a new root with an empty segment name
		if(pathSegmentRoot.size() > 1) {
			java.lang.System.out.println("No unique path root found. Empty root added.");
			Map<String, Map> pathSegmentSubRoot = new HashMap<String, Map>();
			pathSegmentSubRoot.put("", pathSegmentRoot);
			pathSegmentRoot = pathSegmentSubRoot;
		}
		
		// Now that the tree structure is built, extract the component uri out of it
		// by following the path starting at the root and ending when it splits.
		String longestComponentUri = "";
		pathSegmentNodePointer = pathSegmentRoot;
		while(pathSegmentNodePointer.size() == 1) {
			String segment = pathSegmentNodePointer.keySet().iterator().next();
			if(!segment.isEmpty()) {
				longestComponentUri = longestComponentUri + QUALIFIED_KEY_SEPARATOR + segment;
			}
			pathSegmentNodePointer = pathSegmentNodePointer.values().iterator().next();
		}
		
		java.lang.System.out.println("Longest Component URI match:");
		soaComponent.setURI(longestComponentUri);
		
		String shortestComponentUri = longestComponentUri;
		for(String path : openApi.getPaths().keySet()) {
			if(shortestComponentUri.startsWith(path) && path.length() <= shortestComponentUri.length()) {
				shortestComponentUri = path;
			}
		}
		
		java.lang.System.out.println("Component URI:");
		soaComponent.setURI(shortestComponentUri);
		java.lang.System.out.println(shortestComponentUri);
		
		// Make pathSegmentNodePointer coherent with shortestComponentUri
		pathSegmentNodePointer = pathSegmentRoot;
		for(String segment : Arrays.asList(shortestComponentUri.split(QUALIFIED_KEY_SEPARATOR))) {
			if(pathSegmentNodePointer.get(segment) != null) {
				pathSegmentNodePointer = pathSegmentNodePointer.get(segment);
			}
		}
		
		// For each of the following path, repeat the process of finding the paths 
		// until they split again.
		// Each of such path constitues the service URIs.
		java.lang.System.out.println("Services URIs:");
		for(String serviceSegment : pathSegmentNodePointer.keySet()) {
			String longestServiceUri = QUALIFIED_KEY_SEPARATOR + serviceSegment;
			Map<String, Map> serviceSegmentNode = pathSegmentNodePointer.get(serviceSegment);
			while(serviceSegmentNode.size() == 1) {
				Entry<String, Map> entry = serviceSegmentNode.entrySet().iterator().next();
				longestServiceUri = longestServiceUri + QUALIFIED_KEY_SEPARATOR + entry.getKey();
				serviceSegmentNode = entry.getValue();
			}
			
			String shortestServiceUri = longestServiceUri;
			for(String path : openApi.getPaths().keySet()) {
				if((shortestComponentUri + shortestServiceUri).startsWith(path) && 
						path.length() <= shortestComponentUri.length() + shortestServiceUri.length()) {
					shortestServiceUri = path.substring(shortestComponentUri.length());
				}
			}
			
			java.lang.System.out.println("\t" + shortestServiceUri);
			Service soaService =  SoaFactory.eINSTANCE.createService();
			soaService.setURI(shortestServiceUri);
			soaService.setKind(InterfaceKind.PROVIDED_LITERAL);
			soaComponent.getOwnedServices().add(soaService);
		}
		
		// Attempt to find a name for the SOA Services, looking for a unique tag
		// among the rest operations.
		// If no unique tag is found, compute a name out of the service URI.
		java.lang.System.out.println("Qualified services URIs:");
		for(Service soaService : soaComponent.getProvidedServices()) {
			String qualifiedServiceUri = soaComponent.getURI() + soaService.getURI();
			java.lang.System.out.println(qualifiedServiceUri);
			Set<String> appliedTags = openApi.getPaths().keySet().stream()
					.filter(key -> key.startsWith(qualifiedServiceUri))
					.map(key -> openApi.getPaths().get(key))
					.flatMap(path -> path.readOperations().stream())
					.flatMap(op -> op.getTags().stream())
					.collect(toSet());
			if(appliedTags.size() == 1) {
				soaService.setName(appliedTags.iterator().next());
			} else {
				soaService.setName(camelCaseFromUri(soaService.getURI()));
			}
		}
	}

	private String camelCaseFromUri(String uri) {
		return Arrays.asList(uri.split(QUALIFIED_KEY_SEPARATOR)).stream()
				.map(s -> upperFirst(s))
				.collect(joining());
	}
	//// Components ////
	
	private void createSoaExposedTypes() {
		openApi.getComponents().getSchemas().forEach((key, schema) -> touchExposedType(key, schema));
		openApi.getComponents().getSchemas().forEach((key, schema) -> updateExposedType(getExposedTypeFromKey(key), schema));
	}

	private Type touchExposedType(String key, Schema schema) {
		Type exposedType = getExposedTypeFromKey(key);
		if(exposedType != null) {
			logError(String.format("Could not create exposed type %s : type already exists.", key));
			return null;
		}
		int soaTypeId = computeSoaType(schema);
		switch(soaTypeId) {
		case EnvironmentPackage.DTO: 
			exposedType = touchDto(key);
			break;
		case EnvironmentPackage.ENUMERATION: 
			exposedType = touchEnumeration(key);
			break;
		}
		return exposedType;
	}
	
	private DTO touchDto(String key) {
		Namespace namespace = getOrCreateNamespaceFromComponentKey(key);
		String dtoName = computeExposedTypeNameFromKey(key);
		return touchDto(namespace, dtoName);
	}

	private String computeExposedTypeNameFromKey(String key) {
		String[] segments = key.split(QUALIFIED_KEY_SEPARATOR);
		return  segments[segments.length - 1];
	}

	private Enumeration touchEnumeration(String key) {
		Namespace namespace = getOrCreateNamespaceFromComponentKey(key);
		String enumerationName = computeExposedTypeNameFromKey(key);
		return touchEnumeration(namespace, enumerationName);
	}

	private Namespace getOrCreateNamespaceFromComponentKey(String key) {
		Namespace namespace = getOrCreateRootNamespace();
		List<String> segments = new LinkedList<>(Arrays.asList(key.split(QUALIFIED_KEY_SEPARATOR)));
		segments.remove(segments.size() - 1);
		for (String segment : segments) {
			namespace = getOrCreateOwnedNamespace(namespace, segment);
		}
		return namespace;
	}

	private Namespace getOrCreateRootNamespace() {
		return getOrCreateOwnedNamespace(soaSystem, soaComponent.getName());
	}
	
	private Namespace getRootNamespace() {
		return NamespaceGenUtil.getNamespaceByName(soaSystem, soaComponent.getName());
	}
	
	private Namespace getOrCreateOwnedNamespace(Namespace namespace, String name) {
		
		Namespace ownedNamespace = NamespaceGenUtil.getNamespaceByName(namespace, name);
		
		if(ownedNamespace == null) {
			ownedNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			namespace.getOwnedNamespaces().add(ownedNamespace);
			ownedNamespace.setName(name);
		}
		
		return ownedNamespace;
	}

	private int computeSoaType(Schema schema) {
		int typeId = -1;
		
		if(schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema)schema;
			if(!composedSchema.getAllOf().isEmpty()) {
				Schema subSchema = composedSchema.getAllOf().get(0);
				typeId = computeSoaType(subSchema);
			}
		} else if(schema.get$ref() != null) {
			Schema refSchema = getReferencedSchema(schema.get$ref());
			typeId = computeSoaType(refSchema);
		} else if(isEnum(schema)) {
			typeId = EnvironmentPackage.ENUMERATION;
		} else if(isObject(schema)) {
			typeId = EnvironmentPackage.DTO;
		}
		
		if(typeId == -1) {
			logError("Schema type not supported : type=" + schema.getType() + " format=" + schema.getFormat());
		}
		
		return typeId;
	}

	private Schema getReferencedSchema(String $ref) {
		Schema schema = null;
		
		if(!$ref.startsWith(COMPONENT_SCHEMA_$REF)) {
			logError("Unmanaged reference : " + $ref);
		} else {
			String key = $ref.substring(COMPONENT_SCHEMA_$REF.length());
			schema = openApi.getComponents().getSchemas().get(key);
		}
		
		return schema;
	}

	private void updateExposedType(Type exposedType, Schema schema) {
		switch(exposedType.eClass().getClassifierID()) {
		case EnvironmentPackage.DTO: 
			updateDto((DTO)exposedType, schema);
			break;
		case EnvironmentPackage.ENUMERATION: 
			updateEnumeration((Enumeration)exposedType, schema);
			break;
		}
	}

	private Enumeration updateEnumeration(Enumeration enumaration, Schema schema) {
		Set<String> literalNames = new HashSet<>();
		collectLiterals(literalNames, schema);
		updateEnumeration(enumaration, literalNames);
		
		return enumaration;
		
	}

	private void collectLiterals(Set<String> literalNames, Schema schema) {
		
		if(schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema)schema;
			for (Schema subSchema : composedSchema.getAllOf()) {
				collectLiterals(literalNames, subSchema);
			}
		} else if(schema.get$ref() != null) {
			Schema refSchema = getReferencedSchema(schema.get$ref());
			collectLiterals(literalNames, refSchema);
		} else if(schema.getEnum() != null) {
			schema.getEnum().forEach(e -> literalNames.add(e.toString()));
		}
		
	}

	private Enumeration updateEnumeration(Enumeration enumeration, Set<String> literalNames) {
		for(String literalName : literalNames) {
			Literal literal = EnvironmentFactory.eINSTANCE.createLiteral();
			enumeration.getLiterals().add(literal);
			literal.setName(literalName);
		}
		return enumeration;
	}

	private DTO updateDto(DTO dto, Schema schema) {
		if(conformsToGeneratizationPattern(schema)) {
			Schema parentSchema = getParentFromGeneralizationSchema(schema);
			DTO superType = (DTO) getExposedTypeFrom$ref(parentSchema.get$ref());
			Schema baseSchema = getBaseFromGeneralizationSchema(schema);
			dto.setSupertype(superType);
			createSoaProperties(dto, schema, getProperties(baseSchema));
		} else if(schema instanceof ComposedSchema) {
			createSoaProperties(dto, schema, getAllProperties(schema));
		} else if(schema.get$ref() != null) {
			// Case of a pass-trough type
			DTO superType = (DTO) getExposedTypeFrom$ref(schema.get$ref());
			dto.setSupertype(superType);
		} else {
			// Terminal case of a structure defining properties
			createSoaProperties(dto, schema, getProperties(schema));
		}
		
		return dto;
	}

	private Map<String, Schema> getAllProperties(Schema schema) {
		Map<String, Schema> allProperties = new HashMap<>();
		collectAllProperties(allProperties, schema);
		
		return allProperties;
	}

	private void collectAllProperties(Map<String, Schema> allProperties, Schema schema) {
		allProperties.putAll(getProperties(schema));
		if(schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema) schema;
			for(Schema subSchema : composedSchema.getAllOf()) {
				collectAllProperties(allProperties, subSchema);
			}
		} else if(schema.get$ref() != null) {
			Schema referencedSchema = getReferencedSchema(schema.get$ref());
			collectAllProperties(allProperties, referencedSchema);
		}
	}

	private boolean conformsToGeneratizationPattern(Schema schema) {
		if(!(schema instanceof ComposedSchema)) {
			return false;
		}
		
		ComposedSchema composedSchema = (ComposedSchema) schema;
		if(composedSchema.getAllOf() == null || composedSchema.getAllOf().size() != 2) {
			return false;
		}
		
		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);
		
		if(schema1.get$ref() != null && schema2.get$ref() == null && isObject(schema2)) {
			return true;
		}
		
		if(schema2.get$ref() != null && schema1.get$ref() == null && isObject(schema1)) {
			return true;
		}
		
		return false;
	}

	private Schema getParentFromGeneralizationSchema(Schema schema) {
		ComposedSchema composedSchema = (ComposedSchema) schema;
		
		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);
		
		if(schema1.get$ref() != null) {
			return schema1;
		}
		
		return schema2;
	}

	private Schema getBaseFromGeneralizationSchema(Schema schema) {
		ComposedSchema composedSchema = (ComposedSchema) schema;
		
		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);
		
		if(schema1.get$ref() == null) {
			return schema1;
		}
		
		return schema2;
	}

	private void createSoaProperties(StructuredType type, Schema enclosingSchema, Map<String, Schema> properties) {
		for(String propertyKey : properties.keySet()) {
			Schema property = properties.get(propertyKey);
			Property soaProperty = createSoaProperty(type, enclosingSchema, propertyKey, property);
			if(soaProperty == null) {
				logError(String.format("Unsupported property type : %s for key %s.", property.getClass().getName(), propertyKey));
			}
		}
	}

	private Property createSoaProperty(StructuredType type, Schema enclosingSchema, String propertyKey, Schema propertySchema) {
		Property soaProperty = null;
		
		Schema unwrappedSchema = unwrapArraySchema(propertySchema);
		if(isPrimitiveType(unwrappedSchema)) {
			soaProperty = createPrimitiveTypeAttribute(type, unwrappedSchema);
		} else if(unwrappedSchema.get$ref() != null) {
			soaProperty = createReferencedTypeProperty(type, unwrappedSchema);
		} else {
			soaProperty = createInlineTypeProperty(type, propertyKey, unwrappedSchema);
		}
		
		if(soaProperty != null) {
			soaProperty.setName(propertyKey);
			
			soaProperty.setMultiplicity(computeMultiplicity(
					enclosingSchema.getRequired() != null && 
					enclosingSchema.getRequired().contains(propertyKey),
					propertySchema));
		}
			
		return soaProperty;
	}

	private Property createReferencedTypeProperty(StructuredType type, Schema propertySchema) {
		Property soaProperty = null;
		
		switch(computeSoaType(propertySchema)) {
		case EnvironmentPackage.DTO: 
			soaProperty = createReferencedDtoReference(type, propertySchema);
			break;
		case EnvironmentPackage.ENUMERATION: 
			soaProperty = createReferencedEnumerationAttribute(type, propertySchema);
			break;
		}
		
		return soaProperty;
	}

	private Attribute createReferencedEnumerationAttribute(StructuredType type, Schema propertySchema) {
		Attribute attribute = EnvironmentFactory.eINSTANCE.createAttribute();
		type.getOwnedAttributes().add(attribute);
		attribute.setType((DataType)getExposedTypeFrom$ref(propertySchema.get$ref()));
		
		return attribute;
	}

	private Reference createReferencedDtoReference(StructuredType type, Schema propertySchema) {
		Reference reference = EnvironmentFactory.eINSTANCE.createReference();
		type.getOwnedReferences().add(reference);
		reference.setReferencedType((StructuredType)getExposedTypeFrom$ref(propertySchema.get$ref()));
		
		return reference;
	}

	private Type getExposedTypeFrom$ref(String $ref) {
		Type exposedType = null;
		if(!$ref.startsWith(COMPONENT_SCHEMA_$REF)) {
			logWarning("Unmanaged reference : " + $ref);
		} else {
			String key = $ref.substring(COMPONENT_SCHEMA_$REF.length());
			exposedType = getExposedTypeFromKey(key);
		}
		
		return exposedType;
	}

	private Property createInlineTypeProperty(StructuredType type, String propertyKey, Schema propertySchema) {
		Property soaProperty = null;

		switch(computeSoaType(propertySchema)) {
		case EnvironmentPackage.DTO: 
			soaProperty = createInlineDtoReference(type, propertyKey, propertySchema);
			break;
		case EnvironmentPackage.ENUMERATION: 
			soaProperty = createInlineEnumerationAttribute(type, propertyKey, propertySchema);
			break;
		}
		
		return soaProperty;
	}

	private String computeTypeNameFromPropertyKey(String propertyKey) {
		return upperFirst(propertyKey);
	}

	private Reference createInlineDtoReference(StructuredType type, String propertyKey, Schema propertySchema) {
		Namespace namespace = getOrCreateNamespaceForInlineTypes(type);
		
		DTO dto = touchDto(namespace, computeTypeNameFromPropertyKey(propertyKey));
		updateDto(dto, propertySchema);
		
		Reference reference = EnvironmentFactory.eINSTANCE.createReference();
		type.getOwnedReferences().add(reference);
		
		reference.setReferencedType(dto);
		
		return reference;
	}

	private DTO touchDto(Namespace namespace, String dtoName) {
		DTO soaDto = EnvironmentFactory.eINSTANCE.createDTO();
		namespace.getTypes().add(soaDto);
		soaDto.setName(dtoName);
		
		return soaDto;
	}

	private Attribute createInlineEnumerationAttribute(StructuredType type, String propertyKey, Schema propertySchema) {
		Namespace namespace = getOrCreateNamespaceForInlineTypes(type);
		
		Enumeration enumeration = touchEnumeration(namespace, computeTypeNameFromPropertyKey(propertyKey));
		updateEnumeration(enumeration, propertySchema);
		
		Attribute attribute = EnvironmentFactory.eINSTANCE.createAttribute();
		type.getOwnedAttributes().add(attribute);

		attribute.setType(enumeration);
		
		return attribute;
	}

	private Namespace getOrCreateNamespaceForInlineTypes(org.obeonetwork.dsl.soa.Operation soaOperation) {
		Namespace rootNamespace = getOrCreateRootNamespace();
		Namespace serviceNamespace = getOrCreateOwnedNamespace(rootNamespace, getContainerOrSelf(soaOperation, Service.class).getName());
		Namespace operationNamespace = getOrCreateOwnedNamespace(serviceNamespace, soaOperation.getName());
		
		return operationNamespace;
	}
	
	private Namespace getOrCreateNamespaceForInlineTypes(StructuredType type) {
		Namespace inlineTypesNamespace = null;
		
		String inlineTypesNamespaceName = type.getName();
		NamespacesContainer container = getContainerOrSelf(type, NamespacesContainer.class);
		
		if(container instanceof Namespace && inlineTypesNamespaceName.equals(((Namespace) container).getName())) {
			inlineTypesNamespace = (Namespace) container;
		} else {
			inlineTypesNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			container.getOwnedNamespaces().add(inlineTypesNamespace);
			inlineTypesNamespace.setName(inlineTypesNamespaceName);
		}
		return inlineTypesNamespace;
	}

	private Enumeration touchEnumeration(Namespace namespace, String enumertionName) {
		Enumeration soaEnumeration = EnvironmentFactory.eINSTANCE.createEnumeration();
		namespace.getTypes().add(soaEnumeration);
		soaEnumeration.setName(enumertionName);
		
		return soaEnumeration;
	}

	private Attribute createPrimitiveTypeAttribute(StructuredType type, Schema propertySchema) {
		Attribute attribute = EnvironmentFactory.eINSTANCE.createAttribute();
		type.getOwnedAttributes().add(attribute);
		DataType primitiveType = getPrimitiveType(propertySchema);
		attribute.setType(primitiveType);
				
		return attribute;
	}

	private DataType getPrimitiveType(Schema schema) {
		String primitiveTypeName = getPrimitiveTypeName(schema);
		if(primitiveTypeName != null) {
			return environment.getTypesDefinition().getTypes().stream()
			.filter(t -> t instanceof DataType).map(t -> (DataType)t)
			.filter(t -> primitiveTypeName.equals(t.getName()))
			.findFirst().orElse(null);
		}
		return null;
	}

	private MultiplicityKind computeMultiplicity(boolean required, Schema schema) {
		int min = 0;
		int max = 1;
		
		if(schema instanceof ArraySchema) {
			ArraySchema arraySchema = (ArraySchema) schema;
			if((arraySchema.getMinItems() != null && arraySchema.getMinItems() > 0)) {
				min = 1;
			}
			
			max = -1;
			if(arraySchema.getMaxItems() != null && arraySchema.getMaxItems() == 1) {
				max = 1;
			}
		}
		
		if(required) {
			min = 1;
		}
		
		MultiplicityKind multiplicity = null;
		if(min == 0 && max == 1) { // 0..1
			multiplicity = MultiplicityKind.ZERO_ONE_LITERAL;
		} else if(min == 0 && max == -1) { // 0..*
			multiplicity = MultiplicityKind.ZERO_STAR_LITERAL;
		} else if(min == 1 && max == 1) { // 1
			multiplicity = MultiplicityKind.ONE_LITERAL;
		} else if(min == 1 && max == -1) { // 1..*
			multiplicity = MultiplicityKind.ONE_STAR_LITERAL;
		}
		
		return multiplicity;
	}
	
	private Map<String, Schema> getProperties(Schema schema) {
		Map<String, Schema> properties = new HashMap<>();
		if(schema.getProperties() != null) {
			properties.putAll(schema.getProperties());
		}
		return properties;
	}
	
	private Type getExposedTypeFromKey(String key) {
		Namespace namespace = getRootNamespace();
		List<String> segments = new LinkedList<>(Arrays.asList(key.split(QUALIFIED_KEY_SEPARATOR)));
		String typeName = segments.remove(segments.size() - 1);
		
		Iterator<String> i = segments.iterator();
		while(i.hasNext() && namespace != null) {
			String segment = i.next();
			namespace = NamespaceGenUtil.getNamespaceByName(namespace, segment);
		}
		Type type = null;
		if(namespace != null) {
			type = NamespaceGenUtil.getTypeByName(namespace, typeName);
		}
		return type;
	}
	
}
