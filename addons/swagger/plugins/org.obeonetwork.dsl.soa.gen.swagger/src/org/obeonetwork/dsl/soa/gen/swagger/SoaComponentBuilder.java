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

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.obeonetwork.dsl.environment.design.services.ModelServices.getAncestors;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.COMPONENT_SCHEMA_$REF;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.getPrimitiveTypeName;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isEnum;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isObject;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isPrimitiveType;
import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.upperFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.gen.swagger.utils.NamespaceGenUtil;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

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
	
	private static final String QUALIFIED_PATH_SEPARATOR = "/";
	
	int status;
	private OpenAPI openApi;
	private Environment environment;
	private Component soaComponent;
	private Namespace soaRootNamespace;

	/**
	 * Typed elements (Attribute, Reference or Parameter) using inline types (DTO or Enumeration) as their type.
	 */
	private Map<Type, List<ObeoDSMObject>> inlineTypes;
	
	public SoaComponentBuilder(OpenAPI swagger, Environment environment) {
		this.openApi = swagger;
		this.environment = environment;
	}
	
	public int build() {
		status = IStatus.OK;
		
		createSoaComponent();
		
		return status;
	}

	public Namespace getNamespace() {
		return soaRootNamespace;
	}
	
	public Component getComponent() {
		return soaComponent;
	}
	
	private void logError(String message) {
		Activator.logError(message);
		status = IStatus.ERROR;
	}
	
	private void logWarning(String message) {
		Activator.logWarning(message);
		status = IStatus.WARNING;
	}
	
	private Component createSoaComponent() {
		
		String soaComponentName = getSoaComponentName();
		if(soaComponentName == null) {
			logError("Component name could not be computed.");
			return null;
		}
		
		soaComponent = SoaFactory.eINSTANCE.createComponent();
		soaComponent.setName(soaComponentName);
		
		Info info = openApi.getInfo();
		soaComponent.setName(info.getTitle());
		soaComponent.setDescription(info.getDescription());
		soaComponent.setApiVersion(info.getVersion());
		// ? info.getLicense();

		List<Server> servers = openApi.getServers();
		if(servers != null && servers.size() > 1) {
			logWarning("Multiple servers not supported.");
		}
		
		if(servers != null && !servers.isEmpty()) {
			Server server = servers.get(0);
			soaComponent.setURI(server.getUrl());
		}
		
		inlineTypes = new HashMap<>();
		
		createSoaExposedTypes();
		
		createSoaServices();
		
		createSoaOperations();
		
		processInlineTypes();
		
		return soaComponent;
	}

	private void processInlineTypes() {
		// Start by processing the types originating from schemas.
		// To be processed, a type has to be used by a type already in the model.
		// Therefore, the process is reapeted over all the schema inline types
		// until all the types are processed.
		List<Type> unprocessedSchemaInlineTypes = getUnprocessedSchemaInlineTypes();
		
		while(!unprocessedSchemaInlineTypes.isEmpty()) {
			for(Type inlineType : unprocessedSchemaInlineTypes) {
				processSchemaInlineType(inlineType);
			}
			unprocessedSchemaInlineTypes = getUnprocessedSchemaInlineTypes();
		}
		
		// Now process the types inline to service parameters.
		List<Type> unprocessedParameterInlineTypes = getUnprocessedParameterInlineTypes();
		for(Type inlineType : unprocessedParameterInlineTypes) {
			processParameterInlineType(inlineType);
		}
		
		// The unprocessed types remaining at this stage are the types inline to 
		// parameter inline types at any level of depth.
		List<Type> unprocessedInlineTypes = getUnprocessedInlineTypes();
		while(!unprocessedInlineTypes.isEmpty()) {
			for(Type inlineType : unprocessedInlineTypes) {
				processParameterSubInlineType(inlineType);
			}
			unprocessedInlineTypes = getUnprocessedInlineTypes();
		}
	}

	private void processParameterSubInlineType(Type inlineType) {
		List<Property> usingProperties = inlineTypes.get(inlineType).stream()
				.filter(Property.class::isInstance)
				.map(Property.class::cast)
				.filter(p -> p.eContainer().eContainer() != null)
				.collect(toList());
		
		if(!usingProperties.isEmpty()) {
			
			TypesDefinition commonTypesContainer = getCommonAncestor(usingProperties, TypesDefinition.class);
			if(commonTypesContainer == null) {
				Namespace typesNamesapce = getOrCreateTypesNamespace();
				logWarning(String.format("Could not find common types container for %s. Using %s instead.", 
						usingProperties.stream().map(p -> ((Type)p.eContainer()).getName()).collect(joining(", ")), 
						typesNamesapce.getName()));
				commonTypesContainer = typesNamesapce;
			}
			
			String inlineTypeName = null;
			if(usingProperties.size() == 1) {
				Property usingProperty = usingProperties.get(0);
				StructuredType usingType = (StructuredType) usingProperty.eContainer();
				inlineTypeName = usingType.getName() + upperFirst(usingProperty.getName());
			} else {
				inlineTypeName = usingProperties.stream().map(p -> upperFirst(p.getName())).collect(toSet()).stream().collect(joining());
			}
			
			inlineTypeName = toUniqueName(commonTypesContainer, inlineTypeName);
			
			inlineType.setName(inlineTypeName);
			commonTypesContainer.getTypes().add(inlineType);
		}
	}

	private void processParameterInlineType(Type inlineType) {
		List<org.obeonetwork.dsl.soa.Parameter> usingParameters = inlineTypes.get(inlineType).stream()
				.filter(org.obeonetwork.dsl.soa.Parameter.class::isInstance)
				.map(org.obeonetwork.dsl.soa.Parameter.class::cast)
				.collect(toList());
		
		Namespace destinationNamespace = getOrCreateServicesNamespace();
		
		Service soaService = getCommonAncestor(usingParameters, Service.class);
		if(soaService != null) {
			destinationNamespace = getOrCreateNamespace(destinationNamespace, soaService.getName());
		}
		
		String inlineTypeName = usingParameters.stream().map(p -> upperFirst(p.getName())).collect(toSet()).stream().collect(joining());
		
		org.obeonetwork.dsl.soa.Operation soaOperation = getCommonAncestor(usingParameters, org.obeonetwork.dsl.soa.Operation.class);
		if(soaOperation != null) {
			inlineTypeName = upperFirst(soaOperation.getName()) + inlineTypeName;
		}

		inlineTypeName = toUniqueName(destinationNamespace, inlineTypeName);
		inlineType.setName(inlineTypeName);
			
		destinationNamespace.getTypes().add(inlineType);
		
	}

	private <T extends EObject> T getCommonAncestor(List<? extends EObject> eObjects, Class<T> type) {
		List<Iterator<EObject>> eObjectsAncestors = eObjects.stream().map(o -> getAncestors(o).iterator()).collect(toList());
		
		List<EObject> upwardCommonAncestors = new LinkedList<>();
		EObject nextCommonElement = nextCommonElement(eObjectsAncestors);
		while(nextCommonElement != null) {
			upwardCommonAncestors.add(0, nextCommonElement);
			nextCommonElement = nextCommonElement(eObjectsAncestors);
		}

		return (T)upwardCommonAncestors.stream().filter(e -> type.isInstance(e)).findFirst().orElse(null);
	}
	
	private <T> T nextCommonElement(List<Iterator<T>> elements) {
		T nextCommonElement = null;
		if(elements.stream().map(i -> i.hasNext()).reduce((t1, t2) -> t1 && t2).orElse(false)) {
			Set<T> nextDistinctElements = elements.stream().map(i -> i.next()).collect(toSet());
			if(nextDistinctElements.size() == 1) {
				nextCommonElement = nextDistinctElements.iterator().next();
			}
		}
		return nextCommonElement;
	}

	private void processSchemaInlineType(Type inlineType) {
		List<Property> usingProperties = inlineTypes.get(inlineType).stream()
				.filter(Property.class::isInstance)
				.map(Property.class::cast)
				.filter(p -> p.eContainer().eContainer() != null)
				.collect(toList());
		if(!usingProperties.isEmpty()) {
			TypesDefinition typesContainer = getCommonAncestor(usingProperties, TypesDefinition.class);
			
			String inlineTypeName = null;
			if(usingProperties.size() == 1) {
				Property usingProperty = usingProperties.get(0);
				StructuredType usingType = (StructuredType) usingProperty.eContainer();
				inlineTypeName = usingType.getName() + upperFirst(usingProperty.getName());
			} else {
				inlineTypeName = usingProperties.stream().map(p -> upperFirst(p.getName())).collect(toSet()).stream().collect(joining());
			}
			
			inlineTypeName = toUniqueName(typesContainer, inlineTypeName);
			
			inlineType.setName(inlineTypeName);
			typesContainer.getTypes().add(inlineType);
		}
	}

	private static final String NAME_INDEX_SEPARATOR = "_";
	private String toUniqueName(TypesDefinition typesContainer, String inlineTypeName) {
		String uniqueName = inlineTypeName;
		List<String> usedNames = typesContainer.getTypes().stream().map(t -> t.getName()).collect(toList());
		while(usedNames.contains(uniqueName)) {
			if(uniqueName.matches(".*" + NAME_INDEX_SEPARATOR + "([0-9]+)")) {
				int index = Integer.valueOf(uniqueName.substring(uniqueName.lastIndexOf(NAME_INDEX_SEPARATOR) + NAME_INDEX_SEPARATOR.length()));
				index++;
				uniqueName = uniqueName.substring(0, uniqueName.lastIndexOf(NAME_INDEX_SEPARATOR)) + NAME_INDEX_SEPARATOR + index;
			} else {
				uniqueName = uniqueName + NAME_INDEX_SEPARATOR + "1";
			}
		}
		
		return uniqueName;
	}

	private List<Type> getUnprocessedSchemaInlineTypes() {
		return inlineTypes.keySet().stream()
				.filter(t -> t.eContainer() == null)
				.filter(t -> isSchemaInlineType(t))
				.collect(toList());
	}

	/**
	 * This test supposes that no parameter inline type is already in the model.
	 * Therefore, a type is supposed to be originating from a schema if it is used
	 * by a property owned by a type already in the model, or if one of these types
	 * is (recursively).
	 */
	private boolean isSchemaInlineType(Type inlineType) {
		if(inlineTypes.get(inlineType) == null) {
			return false;
		}
		
		List<Property> usingProperties = inlineTypes.get(inlineType).stream()
				.filter(Property.class::isInstance)
				.map(Property.class::cast)
				.collect(toList());
		
		if(usingProperties.isEmpty()) {
			return false;
		}
		
		List<Type> usingTypes = usingProperties.stream().map(p -> (Type)p.eContainer()).collect(toList());
		
		if(usingTypes.stream().anyMatch(t -> t.eContainer() != null)) {
			return true;
		}
		
		return usingTypes.stream().anyMatch(t -> isSchemaInlineType(t));
	}

	private List<Type> getUnprocessedParameterInlineTypes() {
		return inlineTypes.keySet().stream()
				.filter(t -> t.eContainer() == null)
				.filter(t -> inlineTypes.get(t).stream().anyMatch(org.obeonetwork.dsl.soa.Parameter.class::isInstance))
				.collect(toList());
	}

	private List<Type> getUnprocessedInlineTypes() {
		return inlineTypes.keySet().stream()
				.filter(t -> t.eContainer() == null)
				.collect(toList());
	}
	
	private <T extends Type> T registerInlineType(ObeoDSMObject context, T soaType) {
		// context is of type Attribute, Reference or Parameter
		// soaType is of type DTO or Enumeration
		
		T registeredType = (T) inlineTypes.keySet().stream().filter(t -> soaEquals(soaType, t)).findFirst().orElse(soaType); 
		
		List<ObeoDSMObject> contexts = inlineTypes.get(registeredType);
		if(contexts == null) {
			contexts = new ArrayList<>();
			inlineTypes.put(registeredType, contexts);
		}
		contexts.add(context);
		
		return registeredType;
	}

	private static final List<EStructuralFeature> IGNORED_FEATURES = new ArrayList<>();
	static {
		IGNORED_FEATURES.add(TechnicalIDPackage.eINSTANCE.getIdentifiable_Technicalid());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version());
	}
	private boolean soaEquals(EObject a, EObject b) {
		if(a == b) {
			return true;
		}
		
		if(a.eClass() != b.eClass()) {
			return false;
		}
		
		EClass eClass = a.eClass();

		boolean attributesEquals = eClass.getEAllAttributes().stream()
				.filter(attribute -> !IGNORED_FEATURES.contains(attribute))
				.filter(attribute -> !attribute.isDerived())
				.map(attr -> Objects.equals(a.eGet(attr), b.eGet(attr)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);
		
		boolean containmentReferencesMono = eClass.getEAllContainments().stream()
			.filter(containment -> !containment.isMany())
			.map(containment -> soaEquals((EObject)a.eGet(containment), (EObject)b.eGet(containment)))
			.reduce((t1, t2) -> t1 && t2).orElse(true);
		
		boolean containmentReferencesMulti = eClass.getEAllContainments().stream()
				.filter(containment -> containment.isMany())
				.map(containment -> soaContentMultiEquals((List<?>)a.eGet(containment), (List<?>)b.eGet(containment)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);
		
		boolean referencesMono = eClass.getEAllReferences().stream()
				.filter(reference -> !reference.isContainment())
				.filter(reference -> reference.getEOpposite() == null || !reference.getEOpposite().isContainment())
				.filter(reference -> !reference.isDerived())
				.filter(reference -> !reference.isMany())
				.map(reference -> a.eGet(reference) == b.eGet(reference))
				.reduce((t1, t2) -> t1 && t2).orElse(true);
		
		boolean referencesMulti = eClass.getEAllReferences().stream()
				.filter(reference -> !reference.isContainment())
				.filter(reference -> reference.getEOpposite() == null || !reference.getEOpposite().isContainment())
				.filter(reference -> !reference.isDerived())
				.filter(reference -> reference.isMany())
				.map(reference -> soaReferenceMultiEquals((List<?>)a.eGet(reference), (List<?>)b.eGet(reference)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);
		
		return attributesEquals && containmentReferencesMono && containmentReferencesMulti && referencesMono && referencesMulti;
	}
	
	private boolean soaContentMultiEquals(List<?> la, List<?> lb) {
		if(la == null && lb == null) {
			return true;
		}
		
		if(la == null || lb == null) {
			return false;
		}
		
		if(la.size() != lb.size()) {
			return false;
		}
		
		Iterator<?> ia = la.iterator();
		Iterator<?> ib = lb.iterator();
		boolean equals = true;
		while(equals && ia.hasNext()) {
			Object a = ia.next();
			Object b = ib.next();
			if(a instanceof EObject && b instanceof EObject) {
				equals = equals && soaEquals((EObject)a, (EObject)b);
			} else {
				equals = equals && a.equals(b);
			}
		}
		
		return equals;
	}
	
	private boolean soaReferenceMultiEquals(List<?> la, List<?> lb) {
		if(la == null && lb == null) {
			return true;
		}
		
		if(la == null || lb == null) {
			return false;
		}
		
		if(la.size() != lb.size()) {
			return false;
		}
		
		Iterator<?> ia = la.iterator();
		Iterator<?> ib = lb.iterator();
		boolean equals = true;
		while(equals && ia.hasNext()) {
			Object a = ia.next();
			Object b = ib.next();
			equals = equals && (a == b);
		}
		
		return equals;
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
	}

	private org.obeonetwork.dsl.soa.Operation createSoaOperation(String path, HttpMethod verb, Operation operation) {
		Service soaService = getSoaServiceFromPath(path);
		Interface soaInterface = getOrCreateInterface(soaService);
		
		org.obeonetwork.dsl.soa.Operation soaOperation = SoaFactory.eINSTANCE.createOperation();
		soaInterface.getOwnedOperations().add(soaOperation);
		
		soaOperation.setPublic(true);
		soaOperation.setExposition(ExpositionKind.REST);
		
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
		
		Verb soaVerb = Verb.get(verb.toString());
		if(soaVerb != null) {
			soaOperation.setVerb(soaVerb);
		} else {
			// TODO Support all HTTP Methods
			logError(String.format("Unsupported verb %s for path %s.", verb.toString(), path));
		}
		
		if(operation.getParameters() != null) {
			for(Parameter parameter : operation.getParameters()) {
				if(parameter != null) {
					createSoaInputParameter(soaOperation, parameter);
				}
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
		if(schema != null) {
			Type soaParameterType = getOrCreateSoaParameterType(soaOperation, schema, soaParameter);
			soaParameter.setType(soaParameterType);
		}
		
		return soaParameter;
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
				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, soaParameter);
				soaParameter.setType(soaParameterType);
			}
		}
		
		return soaParameter;
	}

	private Type getOrCreateSoaParameterType(org.obeonetwork.dsl.soa.Operation soaOperation, Schema schema, org.obeonetwork.dsl.soa.Parameter soaParameter) {
		Type soaParameterType = null;
		
		if(schema.get$ref() != null) {
			soaParameterType = getExposedTypeFrom$ref(schema.get$ref());
		} else if(isPrimitiveType(schema)) {
			soaParameterType = getPrimitiveType(schema);
		} else {
			if(isEnum(schema)) {
				Enumeration soaEnumeration = EnvironmentFactory.eINSTANCE.createEnumeration();
				
				updateEnumeration(soaEnumeration, schema);
				soaParameterType = registerInlineType(soaParameter, soaEnumeration);
			} else if(isObject(schema)) {
				DTO soaDto = EnvironmentFactory.eINSTANCE.createDTO();
				
				updateDto(soaDto, schema);
				soaParameterType = registerInlineType(soaParameter, soaDto);
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
				
				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, soaParameter);
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
		Map<String, Map> pathSegmentRoot = new HashMap<String, Map>();
		Map<String, Map> pathSegmentNodePointer = null;
		for(String path : openApi.getPaths().keySet()) {
			pathSegmentNodePointer = pathSegmentRoot;
			for(String segment : Arrays.asList(path.split(QUALIFIED_PATH_SEPARATOR))) {
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
				longestComponentUri = longestComponentUri + QUALIFIED_PATH_SEPARATOR + segment;
			}
			pathSegmentNodePointer = pathSegmentNodePointer.values().iterator().next();
		}
		
		// Now that the longest common path has been found, look among all the paths to find a shortest path 
		String shortestComponentUri = longestComponentUri;
		for(String path : openApi.getPaths().keySet()) {
			if(shortestComponentUri.startsWith(path) && path.length() <= shortestComponentUri.length()) {
				shortestComponentUri = path;
			}
		}
		
		soaComponent.setURI(shortestComponentUri);
		
		// Make pathSegmentNodePointer coherent with shortestComponentUri
		pathSegmentNodePointer = pathSegmentRoot;
		for(String segment : Arrays.asList(shortestComponentUri.split(QUALIFIED_PATH_SEPARATOR))) {
			if(pathSegmentNodePointer.get(segment) != null) {
				pathSegmentNodePointer = pathSegmentNodePointer.get(segment);
			}
		}
		
		// For each of the following path, repeat the process of finding the paths 
		// until they split again.
		// Each of such path constitues the service URIs.
		for(String serviceSegment : pathSegmentNodePointer.keySet()) {
			String longestServiceUri = QUALIFIED_PATH_SEPARATOR + serviceSegment;
			Map<String, Map> serviceSegmentNode = pathSegmentNodePointer.get(serviceSegment);
			while(serviceSegmentNode.size() == 1) {
				Entry<String, Map> entry = serviceSegmentNode.entrySet().iterator().next();
				longestServiceUri = longestServiceUri + QUALIFIED_PATH_SEPARATOR + entry.getKey();
				serviceSegmentNode = entry.getValue();
			}
			
			String shortestServiceUri = longestServiceUri;
			for(String path : openApi.getPaths().keySet()) {
				if((shortestComponentUri + shortestServiceUri).startsWith(path) && 
						path.length() <= shortestComponentUri.length() + shortestServiceUri.length()) {
					shortestServiceUri = path.substring(shortestComponentUri.length());
				}
			}
			
			Service soaService =  SoaFactory.eINSTANCE.createService();
			soaService.setURI(shortestServiceUri);
			soaService.setKind(InterfaceKind.PROVIDED_LITERAL);
			soaComponent.getOwnedServices().add(soaService);
		}
		
		// Attempt to find a name for the SOA Services, looking for a unique tag
		// among the rest operations.
		// If no unique tag is found, compute a name out of the service URI.
		for(Service soaService : soaComponent.getProvidedServices()) {
			String qualifiedServiceUri = soaComponent.getURI() + soaService.getURI();
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
		return Arrays.asList(uri.split(QUALIFIED_PATH_SEPARATOR)).stream()
				.map(s -> upperFirst(s))
				.collect(joining());
	}
	
	private void createSoaExposedTypes() {
		if(openApi.getComponents() != null) {
			openApi.getComponents().getSchemas().forEach((key, schema) -> touchExposedType(key, schema));
			openApi.getComponents().getSchemas().forEach((key, schema) -> updateExposedType(getExposedTypeFromKey(key), schema));
		}
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
		String[] segments = key.split(QUALIFIED_PATH_SEPARATOR);
		return  segments[segments.length - 1];
	}

	private Enumeration touchEnumeration(String key) {
		Namespace namespace = getOrCreateNamespaceFromComponentKey(key);
		String enumerationName = computeExposedTypeNameFromKey(key);
		return touchEnumeration(namespace, enumerationName);
	}

	private Namespace getOrCreateNamespace(Namespace namespace, String name) {
		
		Namespace ownedNamespace = NamespaceGenUtil.getNamespaceByName(namespace, name);
		
		if(ownedNamespace == null) {
			ownedNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			namespace.getOwnedNamespaces().add(ownedNamespace);
			ownedNamespace.setName(name);
		}
		
		return ownedNamespace;
	}

	private Namespace getOrCreateRootNamespace() {
		if(soaRootNamespace == null) {
			soaRootNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			soaRootNamespace.setName(soaComponent.getName());
		}
		return soaRootNamespace;
	}
	
	private Namespace getOrCreateServicesNamespace() {
		return getOrCreateRootNamespace();
	}
	
	private Namespace getOrCreateTypesNamespace() {
		return getOrCreateRootNamespace();
	}
	
	private Namespace getOrCreateNamespaceFromComponentKey(String key) {
		Namespace namespace = getOrCreateTypesNamespace();
		List<String> segments = new ArrayList<>(Arrays.asList(key.split(QUALIFIED_PATH_SEPARATOR)));
		segments.remove(segments.size() - 1);
		for (String segment : segments) {
			namespace = getOrCreateNamespace(namespace, segment);
		}
		return namespace;
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

	private Reference createInlineDtoReference(StructuredType type, String propertyKey, Schema propertySchema) {
		DTO soaDto = EnvironmentFactory.eINSTANCE.createDTO();
		
		updateDto(soaDto, propertySchema);
		
		Reference reference = EnvironmentFactory.eINSTANCE.createReference();
		type.getOwnedReferences().add(reference);
		
		soaDto = registerInlineType(reference, soaDto);
		
		reference.setReferencedType(soaDto);
		
		return reference;
	}

	private DTO touchDto(Namespace namespace, String dtoName) {
		DTO soaDto = EnvironmentFactory.eINSTANCE.createDTO();
		namespace.getTypes().add(soaDto);
		soaDto.setName(dtoName);
		
		return soaDto;
	}

	private Attribute createInlineEnumerationAttribute(StructuredType type, String propertyKey, Schema propertySchema) {
		Enumeration soaEnumeration = EnvironmentFactory.eINSTANCE.createEnumeration();
		
		updateEnumeration(soaEnumeration, propertySchema);
		
		Attribute attribute = EnvironmentFactory.eINSTANCE.createAttribute();
		type.getOwnedAttributes().add(attribute);

		soaEnumeration = registerInlineType(attribute, soaEnumeration);
		
		attribute.setType(soaEnumeration);
		
		return attribute;
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
		Namespace namespace = getOrCreateTypesNamespace();
		List<String> segments = new ArrayList<>(Arrays.asList(key.split(QUALIFIED_PATH_SEPARATOR)));
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
