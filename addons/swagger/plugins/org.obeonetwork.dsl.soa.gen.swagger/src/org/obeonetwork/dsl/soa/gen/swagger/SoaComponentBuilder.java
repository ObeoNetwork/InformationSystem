/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.COMPONENT_SCHEMA_$REF;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_BOOLEAN;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_INTEGER;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_NUMBER;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.OPEN_API_TYPE_STRING;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.getPrimitiveTypeName;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isEnum;
import static org.obeonetwork.dsl.soa.gen.swagger.OpenApiParserHelper.isObject;
import static org.obeonetwork.utils.common.EObjectUtils.getAncestors;
import static org.obeonetwork.utils.common.StringUtils.emptyIfNull;
import static org.obeonetwork.utils.common.StringUtils.upperFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
import org.obeonetwork.dsl.soa.ApiKeyLocation;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Example;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.FlowType;
import org.obeonetwork.dsl.soa.HttpScheme;
import org.obeonetwork.dsl.soa.Information;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.ParameterRestData;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.Scope;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ExampleGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.NamespaceGenUtil;
import org.obeonetwork.dsl.soa.services.HttpStatusService;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.utils.common.StringUtils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SoaComponentBuilder {

	private static final String DEFAULT_FOR_UNNAMED = "unnamed";
	private static final String BODY_PARAMETER_NAME = "body";
	private static final String DEFAULT_SERVICE_NAME = "Default";
	private static final String TOO_WILD_TO_BE_NAMED_DTO = "Data";
	private static final String QUALIFIED_PATH_SEPARATOR = "/";	
	private static final Set<String> PAGINATION_SIZE_PARAMETER_NAMES = new HashSet<>(Arrays.asList("size", "taille"));
	private static final Set<String> PAGINATION_PAGE_PARAMETER_NAMES = new HashSet<>(Arrays.asList("page"));
	private static final Predicate<String> PATH_PARAM_PATTERN_PREDICATE = Pattern.compile("\\{[^}]+\\}").asPredicate();

	private int status;
	private OpenAPI openApi;
	private Environment environment;
	private Component soaComponent;
	private Namespace soaRootNamespace;

	private Set<String> reservedOperationNames = null;
	private Map<String, Integer> operationNamesDisambiguationIndex = null;

	/**
	 * Typed elements (Attribute, Reference or Parameter) using inline types (DTO or
	 * Enumeration) as their type.
	 */
	private Map<Type, List<ObeoDSMObject>> inlineTypes;
	private String paginationExtension;

	public SoaComponentBuilder(OpenAPI swagger, Environment environment, String paginationExtension) {
		this.openApi = swagger;
		this.environment = environment;
		this.paginationExtension = paginationExtension;
	}

	public int build() {
		status = IStatus.OK;

		operationNamesDisambiguationIndex = new HashMap<>();

		reservedOperationNames = new HashSet<>();
		for (Operation operation : openApi.getPaths().entrySet().stream().map(Map.Entry::getValue)
				.flatMap(pathItem -> pathItem.readOperations().stream()).collect(toList())) {
			if (operation.getOperationId() != null) {
				String operationId = operation.getOperationId();
				if (reservedOperationNames.contains(operationId)) {
					logWarning(String.format("Operation Id \"%s\" used on more than one operation.", operationId));
				} else {
					reservedOperationNames.add(operationId);
				}
			}
		}

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
		if (status != IStatus.ERROR) {
			status = IStatus.WARNING;
		}
	}

	private Component createSoaComponent() {

		String soaComponentName = getSoaComponentName();
		if (soaComponentName == null) {
			logError("Component name could not be computed.");
			return null;
		}

		soaComponent = SoaFactory.eINSTANCE.createComponent();
		soaComponent.setName(soaComponentName);
		extractPropertiesExtensions(openApi, soaComponent);

		Info info = openApi.getInfo();

		soaComponent.setName(info.getTitle());
		soaComponent.setDescription(info.getDescription());
		soaComponent.setApiVersion(info.getVersion());

		/** SAFRAN-936 **/
		setInformation(soaComponent, info);
		setContactInformation(soaComponent, info.getContact());
		setLicenseInformation(soaComponent, info.getLicense());

		extractPropertiesExtensions(info, soaComponent.getInformation());
		extractPropertiesExtensions(info.getContact(), soaComponent.getContact());
		extractPropertiesExtensions(info.getLicense(), soaComponent.getLicense());
		/****************/

		List<Server> servers = openApi.getServers();
		if (servers != null && !servers.isEmpty()) {
			for (Server server : servers) {
				soaComponent.getServers().add(createSoaServer(server));
			}			
		}

		inlineTypes = new HashMap<>();

		buildSoaSecuritySchemes();

		buildSoaExposedTypes();

		buildSoaServices();

		buildSoaOperations();

		processInlineTypes();

		return soaComponent;
	}
	
	private org.obeonetwork.dsl.soa.Server createSoaServer(Server server) {
		org.obeonetwork.dsl.soa.Server soaServer = SoaFactory.eINSTANCE.createServer();
		soaServer.setURL(server.getUrl());
		soaServer.setDescription(server.getDescription());
		extractPropertiesExtensions(server, soaServer);
		return soaServer;
	}

	private void buildSoaSecuritySchemes() {
		if (openApi.getComponents() != null && openApi.getComponents().getSecuritySchemes() != null) {
			Map<String, SecurityScheme> swgSecuritySchemes = openApi.getComponents().getSecuritySchemes();

			for (String key : swgSecuritySchemes.keySet()) {
				SecurityScheme swgSecurityScheme = swgSecuritySchemes.get(key);
				soaComponent.getSecuritySchemes().add(createSecurityScheme(key, swgSecurityScheme));
			}
		}
	}

	private org.obeonetwork.dsl.soa.SecurityScheme createSecurityScheme(String key, SecurityScheme swgSecurityScheme) {
		org.obeonetwork.dsl.soa.SecurityScheme soaSecurityScheme = SoaFactory.eINSTANCE.createSecurityScheme();

		soaSecurityScheme.setName(key);

		if (swgSecurityScheme.getType() != null) {
			soaSecurityScheme.setType(toSoa(swgSecurityScheme.getType()));
		}

		if (swgSecurityScheme.getDescription() != null) {
			soaSecurityScheme.setDescription(swgSecurityScheme.getDescription());
		}
		
		switch(soaSecurityScheme.getType()) {
		case API_KEY:
			
			if (swgSecurityScheme.getIn() != null) {
				soaSecurityScheme.setApiKeyLocation(toSoa(swgSecurityScheme.getIn()));
			}
			soaSecurityScheme.setKey(swgSecurityScheme.getName());

			break;
		case HTTP:
			if (StringUtils.isNullOrWhite(swgSecurityScheme.getBearerFormat())) {
				soaSecurityScheme.setHttpScheme(HttpScheme.BASIC);
			} else {
				soaSecurityScheme.setHttpScheme(HttpScheme.BEARER);
				soaSecurityScheme.setFormat(swgSecurityScheme.getBearerFormat());
			}
			break;
		case OAUTH2:
			if (swgSecurityScheme.getFlows() != null) {
				soaSecurityScheme.getFlows().addAll(createSoaFlows(swgSecurityScheme.getFlows()));
			}
			break;
		case OPEN_ID_CONNECT:
			if (swgSecurityScheme.getOpenIdConnectUrl() != null) {
				soaSecurityScheme.setConnectURL(swgSecurityScheme.getOpenIdConnectUrl());
			}
			
			if (swgSecurityScheme.getFlows() != null) {
				soaSecurityScheme.getFlows().addAll(createSoaFlows(swgSecurityScheme.getFlows()));
			}
			break;
		default:
			break;
		}

		extractPropertiesExtensions(swgSecurityScheme, soaSecurityScheme);

		return soaSecurityScheme;
	}

	private Collection<? extends Flow> createSoaFlows(OAuthFlows flows) {
		ArrayList<Flow> soaFlows = new ArrayList<>();
		if (flows.getAuthorizationCode() != null) {
			Flow flow = createSoaFlow(flows.getAuthorizationCode());
			flow.setFlowType(FlowType.AUTHORIZATIONCODE);
			soaFlows.add(flow);
		}
		if (flows.getClientCredentials() != null) {
			Flow flow = createSoaFlow(flows.getClientCredentials());
			flow.setFlowType(FlowType.CREDENTIALS);
			soaFlows.add(flow);
		}
		if (flows.getImplicit() != null) {
			Flow flow = createSoaFlow(flows.getImplicit());
			flow.setFlowType(FlowType.IMPLICIT);
			soaFlows.add(flow);
		}
		if (flows.getPassword() != null) {
			Flow flow = createSoaFlow(flows.getPassword());
			flow.setFlowType(FlowType.PASSWORD);
			soaFlows.add(flow);
		}		
		return soaFlows;
	}
	
	private Flow createSoaFlow(OAuthFlow swgOAuthFlow) {
		Flow soaFlow = SoaFactory.eINSTANCE.createFlow();
		soaFlow.setAuthorizationURL(swgOAuthFlow.getAuthorizationUrl());
		soaFlow.setTokenURL(swgOAuthFlow.getTokenUrl());
		soaFlow.setRefreshURL(swgOAuthFlow.getRefreshUrl());
		if (swgOAuthFlow.getScopes() != null) {
			swgOAuthFlow.getScopes().forEach((name, description) -> {
				Scope scope = SoaFactory.eINSTANCE.createScope();
				scope.setName(name);
				scope.setSummary(description);
				soaFlow.getScopes().add(scope);
			});
		}
		
		return soaFlow;
	}

	private SecuritySchemeType toSoa(SecurityScheme.Type swgSecuritySchemeType) {
		SecuritySchemeType soaSecuritySchemeType = null;

		switch (swgSecuritySchemeType) {
		case APIKEY:
			soaSecuritySchemeType = SecuritySchemeType.API_KEY;
			break;
		case HTTP:
			soaSecuritySchemeType = SecuritySchemeType.HTTP;
			break;
		case OAUTH2:
			soaSecuritySchemeType = SecuritySchemeType.OAUTH2;
			break;
		case OPENIDCONNECT:
			soaSecuritySchemeType = SecuritySchemeType.OPEN_ID_CONNECT;
			break;
		}

		return soaSecuritySchemeType;
	}

	private ApiKeyLocation toSoa(SecurityScheme.In swgIn) {
		ApiKeyLocation soaApiKeyLocation = null;

		switch (swgIn) {
		case COOKIE:
			soaApiKeyLocation = ApiKeyLocation.COOKIE;
			break;
		case HEADER:
			soaApiKeyLocation = ApiKeyLocation.HEADER;
			break;
		case QUERY:
			soaApiKeyLocation = ApiKeyLocation.QUERY;
			break;
		}

		return soaApiKeyLocation;
	}

	private void processInlineTypes() {
		// Start by processing the types originating from schemas.
		// To be processed, a type has to be used by a type already in the model.
		// Therefore, the process is repeated over all the schema inline types
		// until all the types are processed.
		List<Type> unprocessedSchemaInlineTypes = getUnprocessedSchemaInlineTypes();

		while (!unprocessedSchemaInlineTypes.isEmpty()) {
			for (Type inlineType : unprocessedSchemaInlineTypes) {
				processSchemaInlineType(inlineType);
			}
			unprocessedSchemaInlineTypes = getUnprocessedSchemaInlineTypes();
		}

		// Now process the types inline to service parameters.
		List<Type> unprocessedParameterInlineTypes = getUnprocessedParameterInlineTypes();
		for (Type inlineType : unprocessedParameterInlineTypes) {
			processParameterInlineType(inlineType);
		}

		// The unprocessed types remaining at this stage are the types inline to
		// parameter inline types at any level of depth.
		List<Type> unprocessedInlineTypes = getUnprocessedInlineTypes();
		while (!unprocessedInlineTypes.isEmpty()) {
			for (Type inlineType : unprocessedInlineTypes) {
				processParameterSubInlineType(inlineType);
			}
			unprocessedInlineTypes = getUnprocessedInlineTypes();
		}
	}

	private void processParameterSubInlineType(Type inlineType) {
		List<Property> usingProperties = inlineTypes.get(inlineType).stream().filter(Property.class::isInstance)
				.map(Property.class::cast).filter(p -> p.eContainer().eContainer() != null).collect(toList());

		if (!usingProperties.isEmpty()) {

			TypesDefinition commonTypesContainer = getCommonAncestor(usingProperties, TypesDefinition.class);
			if (commonTypesContainer == null) {
				Namespace typesNamesapce = getOrCreateTypesNamespace();
				logWarning(String.format("Could not find common types container for %s. Using %s instead.",
						usingProperties.stream().map(p -> ((Type) p.eContainer()).getName()).collect(joining(", ")),
						typesNamesapce.getName()));
				commonTypesContainer = typesNamesapce;
			}

			String inlineTypeName = null;
			if (usingProperties.size() == 1) {
				Property usingProperty = usingProperties.get(0);
				StructuredType usingType = (StructuredType) usingProperty.eContainer();
				inlineTypeName = usingType.getName() + upperFirst(usingProperty.getName());
			} else {
				inlineTypeName = usingProperties.stream().map(p -> upperFirst(p.getName())).collect(toSet()).stream()
						.collect(joining());
			}

			inlineTypeName = toUniqueName(commonTypesContainer, inlineTypeName);

			inlineType.setName(inlineTypeName);
			commonTypesContainer.getTypes().add(inlineType);
		}
	}

	private void processParameterInlineType(Type inlineType) {
		List<org.obeonetwork.dsl.soa.Parameter> usingParameters = inlineTypes.get(inlineType).stream()
				.filter(org.obeonetwork.dsl.soa.Parameter.class::isInstance)
				.map(org.obeonetwork.dsl.soa.Parameter.class::cast).collect(toList());

		Namespace destinationNamespace = getOrCreateServicesNamespace();

		Service soaService = getCommonAncestor(usingParameters, Service.class);
		if (soaService != null) {
			destinationNamespace = getOrCreateNamespace(destinationNamespace, soaService.getName());
		}

		String inlineTypeName = usingParameters.stream().map(p -> upperFirst(p.getName())).collect(toSet()).stream()
				.collect(joining());

		org.obeonetwork.dsl.soa.Operation soaOperation = getCommonAncestor(usingParameters,
				org.obeonetwork.dsl.soa.Operation.class);
		if (soaOperation != null) {
			inlineTypeName = upperFirst(soaOperation.getName()) + inlineTypeName;
		}

		inlineTypeName = toUniqueName(destinationNamespace, inlineTypeName);
		inlineType.setName(inlineTypeName);

		destinationNamespace.getTypes().add(inlineType);

	}

	private <T extends EObject> T getCommonAncestor(List<? extends EObject> eObjects, Class<T> type) {
		Collection<List<EObject>> eObjectsAncestors = eObjects.stream().map(o -> getAncestors(o)).collect(toList());

		List<EObject> commonAncestors = getCommonPath(eObjectsAncestors);

		Collections.reverse(commonAncestors);

		return (T) commonAncestors.stream().filter(e -> type.isInstance(e)).findFirst().orElse(null);
	}

	private <T> List<T> getCommonPath(Collection<List<T>> pathCollection) {
		List<Iterator<T>> pathIterators = pathCollection.stream().map(l -> l.iterator()).collect(toList());

		List<T> commonPath = new ArrayList<>();
		T nextCommonElement = nextCommonElement(pathIterators);
		while (nextCommonElement != null) {
			commonPath.add(nextCommonElement);
			nextCommonElement = nextCommonElement(pathIterators);
		}

		return commonPath;
	}

	private <T> T nextCommonElement(List<Iterator<T>> elements) {
		T nextCommonElement = null;
		if (elements.stream().map(i -> i.hasNext()).reduce((t1, t2) -> t1 && t2).orElse(false)) {
			Set<T> nextDistinctElements = elements.stream().map(i -> i.next()).collect(toSet());
			if (nextDistinctElements.size() == 1) {
				nextCommonElement = nextDistinctElements.iterator().next();
			}
		}
		return nextCommonElement;
	}

	private void processSchemaInlineType(Type inlineType) {
		List<Property> usingProperties = inlineTypes.get(inlineType).stream().filter(Property.class::isInstance)
				.map(Property.class::cast).filter(p -> p.eContainer().eContainer() != null).collect(toList());
		if (!usingProperties.isEmpty()) {
			TypesDefinition typesContainer = getCommonAncestor(usingProperties, TypesDefinition.class);

			String inlineTypeName = null;
			if (usingProperties.size() == 1) {
				Property usingProperty = usingProperties.get(0);
				StructuredType usingType = (StructuredType) usingProperty.eContainer();
				inlineTypeName = usingType.getName() + upperFirst(usingProperty.getName());
			} else {
				Set<String> distinctUsingPropertyNames = usingProperties.stream().map(p -> upperFirst(p.getName()))
						.collect(toSet());
				if (distinctUsingPropertyNames.size() > 3) {
					inlineTypeName = TOO_WILD_TO_BE_NAMED_DTO;
				} else {
					inlineTypeName = usingProperties.stream().map(p -> upperFirst(p.getName())).collect(toSet())
							.stream().collect(joining());
				}
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
		while (usedNames.contains(uniqueName)) {
			if (uniqueName.matches(".*" + NAME_INDEX_SEPARATOR + "([0-9]+)")) {
				int index = Integer.valueOf(uniqueName
						.substring(uniqueName.lastIndexOf(NAME_INDEX_SEPARATOR) + NAME_INDEX_SEPARATOR.length()));
				index++;
				uniqueName = uniqueName.substring(0, uniqueName.lastIndexOf(NAME_INDEX_SEPARATOR))
						+ NAME_INDEX_SEPARATOR + index;
			} else {
				uniqueName = uniqueName + NAME_INDEX_SEPARATOR + "1";
			}
		}

		return uniqueName;
	}

	private List<Type> getUnprocessedSchemaInlineTypes() {
		return inlineTypes.keySet().stream().filter(t -> t.eContainer() == null).filter(t -> isSchemaInlineType(t))
				.collect(toList());
	}

	/**
	 * This test supposes that no parameter inline type is already in the model.
	 * Therefore, a type is supposed to be originating from a schema if it is used
	 * by a property owned by a type already in the model, or if one of these types
	 * is (recursively).
	 */
	private boolean isSchemaInlineType(Type inlineType) {
		if (inlineTypes.get(inlineType) == null) {
			return false;
		}

		List<Property> usingProperties = inlineTypes.get(inlineType).stream().filter(Property.class::isInstance)
				.map(Property.class::cast).collect(toList());

		if (usingProperties.isEmpty()) {
			return false;
		}

		List<Type> usingTypes = usingProperties.stream().map(p -> (Type) p.eContainer()).collect(toList());

		if (usingTypes.stream().anyMatch(t -> t.eContainer() != null)) {
			return true;
		}

		return usingTypes.stream().anyMatch(t -> isSchemaInlineType(t));
	}

	private List<Type> getUnprocessedParameterInlineTypes() {
		return inlineTypes.keySet().stream().filter(t -> t.eContainer() == null)
				.filter(t -> inlineTypes.get(t).stream().anyMatch(org.obeonetwork.dsl.soa.Parameter.class::isInstance))
				.collect(toList());
	}

	private List<Type> getUnprocessedInlineTypes() {
		return inlineTypes.keySet().stream().filter(t -> t.eContainer() == null).collect(toList());
	}

	private <T extends Type> T registerInlineType(ObeoDSMObject context, T soaType) {
		// context is of type Attribute, Reference or Parameter
		// soaType is of type DTO or Enumeration

		T registeredType = (T) inlineTypes.keySet().stream().filter(t -> soaEquals(soaType, t)).findFirst()
				.orElse(soaType);

		List<ObeoDSMObject> contexts = inlineTypes.get(registeredType);
		if (contexts == null) {
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
		if (a == b) {
			return true;
		}

		if (a.eClass() != b.eClass()) {
			return false;
		}

		EClass eClass = a.eClass();

		boolean attributesEquals = eClass.getEAllAttributes().stream()
				.filter(attribute -> !IGNORED_FEATURES.contains(attribute)).filter(attribute -> !attribute.isDerived())
				.map(attr -> Objects.equals(a.eGet(attr), b.eGet(attr))).reduce((t1, t2) -> t1 && t2).orElse(true);

		boolean containmentReferencesMono = eClass.getEAllContainments().stream()
				.filter(containment -> !containment.isMany())
				.map(containment -> soaEquals((EObject) a.eGet(containment), (EObject) b.eGet(containment)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);

		boolean containmentReferencesMulti = eClass.getEAllContainments().stream()
				.filter(containment -> containment.isMany())
				.map(containment -> soaContentMultiEquals((List<?>) a.eGet(containment), (List<?>) b.eGet(containment)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);

		boolean referencesMono = eClass.getEAllReferences().stream().filter(reference -> !reference.isContainment())
				.filter(reference -> reference.getEOpposite() == null || !reference.getEOpposite().isContainment())
				.filter(reference -> !reference.isDerived()).filter(reference -> !reference.isMany())
				.map(reference -> a.eGet(reference) == b.eGet(reference)).reduce((t1, t2) -> t1 && t2).orElse(true);

		boolean referencesMulti = eClass.getEAllReferences().stream().filter(reference -> !reference.isContainment())
				.filter(reference -> reference.getEOpposite() == null || !reference.getEOpposite().isContainment())
				.filter(reference -> !reference.isDerived()).filter(reference -> reference.isMany())
				.map(reference -> soaReferenceMultiEquals((List<?>) a.eGet(reference), (List<?>) b.eGet(reference)))
				.reduce((t1, t2) -> t1 && t2).orElse(true);

		return attributesEquals && containmentReferencesMono && containmentReferencesMulti && referencesMono
				&& referencesMulti;
	}

	private boolean soaContentMultiEquals(List<?> la, List<?> lb) {
		if (la == null && lb == null) {
			return true;
		}

		if (la == null || lb == null) {
			return false;
		}

		if (la.size() != lb.size()) {
			return false;
		}

		Iterator<?> ia = la.iterator();
		Iterator<?> ib = lb.iterator();
		boolean equals = true;
		while (equals && ia.hasNext()) {
			Object a = ia.next();
			Object b = ib.next();
			if (a instanceof EObject && b instanceof EObject) {
				equals = equals && soaEquals((EObject) a, (EObject) b);
			} else {
				equals = equals && a.equals(b);
			}
		}

		return equals;
	}

	private boolean soaReferenceMultiEquals(List<?> la, List<?> lb) {
		if (la == null && lb == null) {
			return true;
		}

		if (la == null || lb == null) {
			return false;
		}

		if (la.size() != lb.size()) {
			return false;
		}

		Iterator<?> ia = la.iterator();
		Iterator<?> ib = lb.iterator();
		boolean equals = true;
		while (equals && ia.hasNext()) {
			Object a = ia.next();
			Object b = ib.next();
			equals = equals && (a == b);
		}

		return equals;
	}

	private String getSoaComponentName() {
		if (openApi.getInfo() != null) {
			return openApi.getInfo().getTitle();
		}
		return null;
	}

	private void buildSoaOperations() {
		for (String path : openApi.getPaths().keySet()) {
			openApi.getPaths().get(path).readOperationsMap().entrySet().stream()
					.forEach(operationsMapEntry -> createSoaOperation(path, operationsMapEntry.getKey(),
							operationsMapEntry.getValue()));
		}
	}

	private org.obeonetwork.dsl.soa.Operation createSoaOperation(String path, HttpMethod swgVerb,
			Operation swgOperation) {
		Service soaService = getSoaServiceFromPath(path);
		Interface soaInterface = getOrCreateInterface(soaService);
		
		org.obeonetwork.dsl.soa.Operation soaOperation = SoaFactory.eINSTANCE.createOperation();
		soaInterface.getOwnedOperations().add(soaOperation);

		extractPropertiesExtensions(swgOperation, soaOperation);

		soaOperation.setPublic(true);
		soaOperation.setExposition(ExpositionKind.REST);

		String soaOperationUri = path.substring((soaComponent.getURI() + soaService.getURI()).length());
		soaOperation.setURI(soaOperationUri);

		String soaOperationName = null;
		if (swgOperation.getOperationId() != null && !swgOperation.getOperationId().isEmpty()) {
			soaOperationName = swgOperation.getOperationId();
		} else {
			soaOperationName = computeSoaOperationName(swgVerb, soaOperationUri);
		}

		if (soaOperationName == null || soaOperationName.isEmpty()) {
			soaOperationName = DEFAULT_FOR_UNNAMED;
		}
		soaOperation.setName(soaOperationName);

		soaOperation.setDescription(swgOperation.getDescription());

		Verb soaVerb = Verb.get(swgVerb.toString());
		if (soaVerb != null) {
			soaOperation.setVerb(soaVerb);
		} else {
			logError(String.format("Unsupported verb %s for path %s.", swgVerb.toString(), path));
		}

		if (swgOperation.getParameters() != null) {
			for (Parameter parameter : swgOperation.getParameters()) {
				if (parameter != null) {
					createSoaInputParameter(soaOperation, parameter);
				}
			}
		}

		RequestBody requestBody = swgOperation.getRequestBody();
		if (requestBody != null) {
			createSoaBodyParameter(soaOperation, requestBody);
		}

		createPaginationProperties(swgOperation, soaOperation);
		
		ApiResponses responses = swgOperation.getResponses();
		extractPropertiesExtensions(responses, soaOperation);

		if (responses != null) {
			for (String responseKey : responses.keySet()) {
				createSoaResponseParameter(soaOperation, responseKey, responses.get(responseKey));
			}
		}

		if (swgOperation.getSecurity() != null) {
			for (SecurityRequirement swgSecurityRequirement : swgOperation.getSecurity()) {

				if (!swgSecurityRequirement.keySet().isEmpty()) {
					String ssKey = swgSecurityRequirement.keySet().iterator().next();

					for(org.obeonetwork.dsl.soa.SecurityScheme securityScheme : soaComponent.getSecuritySchemes().stream()
							.filter(ss -> ssKey.equals(ss.getName())).collect(toList())) {
						SecurityApplication soaSecurityApplication = SoaFactory.eINSTANCE.createSecurityApplication();
						soaSecurityApplication.setSecurityScheme(securityScheme);
						soaOperation.getSecurityApplications().add(soaSecurityApplication);
						
						List<String> scopeNames = swgSecurityRequirement.get(ssKey);
						if(scopeNames != null) {
							for(String scopeName : scopeNames) {
								List<Scope> soaScopes = securityScheme.getFlows().stream()
										.flatMap(f -> f.getScopes().stream())
										.filter(s -> s.getName().equals(scopeName))
										.collect(toList());
								soaSecurityApplication.getScopes().addAll(soaScopes);
							}
						}
					}
				}
			}
		}

		PathItem swgPathItem = getPathItemFromPath(path);
		extractPropertiesExtensions(swgPathItem, soaOperation);
		
		// Servers
		if (swgPathItem.getServers() != null) {
			for (Server swgServer : swgPathItem.getServers()) {
				soaOperation.getServers().add(createSoaServer(swgServer));
			}
		}
		
		extractPropertiesExtensions(getPathItemFromPath(path), soaOperation);

		return soaOperation;
	}

	private void createPaginationProperties(Operation swgOperation, org.obeonetwork.dsl.soa.Operation soaOperation) {
		boolean hasPaginationParameter = (swgOperation.getParameters() != null) && swgOperation.getParameters()
				.stream()
				.anyMatch(parameter -> PAGINATION_SIZE_PARAMETER_NAMES.contains(parameter.getName()) ||
						PAGINATION_PAGE_PARAMETER_NAMES.contains(parameter.getName()));
		
		boolean hasPaginationPropertyExtension = (swgOperation.getExtensions() != null) && swgOperation.getExtensions().keySet().contains(paginationExtension);
				
		if (hasPaginationPropertyExtension || hasPaginationParameter) {
			soaOperation.setPaged(true);
			
			if (hasPaginationPropertyExtension) {
				setPaginationPropertyExtension(soaOperation);	
			}
			
			if (hasPaginationParameter) {
				setPaginationParameters(soaOperation);
			}
		} else {
			soaOperation.setPaged(false);
		}
		
	}

	/**
	 * Set the size and page {@link org.obeonetwork.dsl.soa.Parameter} references for a Soa {@link org.obeonetwork.dsl.soa.Operation}.
	 * @param soaOperation an {@link org.obeonetwork.dsl.soa.Operation}
	 */
	private void setPaginationParameters(org.obeonetwork.dsl.soa.Operation soaOperation) {
		// if the input swg operation has a pagination extension, 
		// since it has already been mapped to the current soa operation,
		// we can associate it with the pagination extension property of the operation.
		
		Optional<org.obeonetwork.dsl.soa.Parameter> inputPageParameter = soaOperation.getInput().stream()
			.filter(parameter -> PAGINATION_PAGE_PARAMETER_NAMES.contains(parameter.getName()))
			.findFirst();				
		if (inputPageParameter.isPresent())
			soaOperation.setPage(inputPageParameter.get());
		
		Optional<org.obeonetwork.dsl.soa.Parameter> inputSizeParameter = soaOperation.getInput().stream()
				.filter(parameter -> PAGINATION_SIZE_PARAMETER_NAMES.contains(parameter.getName()))
				.findFirst();				
		if (inputSizeParameter.isPresent())
				soaOperation.setSize(inputSizeParameter.get());
	}
	
	/**
	 * Set the {@link PropertiesExtension} reference for the {@link org.obeonetwork.dsl.soa.Operation}.
	 * @param soaOperation an {@link org.obeonetwork.dsl.soa.Operation}
	 */
	private void setPaginationPropertyExtension(org.obeonetwork.dsl.soa.Operation soaOperation) {
		if (soaOperation.getMetadatas() != null) {
			soaOperation.setPaginationExtension(soaOperation
				.getMetadatas()
				.getMetadatas()
				.stream()
				.filter(PropertiesExtension.class::isInstance)
				.map(PropertiesExtension.class::cast)
				.filter(property -> ((PropertiesExtension) property).getTitle().equals(paginationExtension))
				.findFirst().orElse(null));					
		}
	}
	
	private String computeSoaOperationName(HttpMethod verb, String uri) {
		List<String> segments = Arrays.asList(uri.split(QUALIFIED_PATH_SEPARATOR));

		StringBuffer name = new StringBuffer();
		name.append(verb.toString().toLowerCase());

		name.append(segments.stream().filter(PATH_PARAM_PATTERN_PREDICATE.negate()).map(segment -> upperFirst(segment))
				.collect(joining()));

		String suffix = segments.stream().filter(PATH_PARAM_PATTERN_PREDICATE)
				.map(segment -> upperFirst(segment.substring(1, segment.length() - 1))).collect(joining("And"));

		if (!suffix.isEmpty()) {
			name.append("From");
			name.append(suffix);
		}

		String rawComputedSoaOperationName = name.toString();

		String soaOperationName = rawComputedSoaOperationName;

		if (operationNamesDisambiguationIndex.get(rawComputedSoaOperationName) == null) {
			operationNamesDisambiguationIndex.put(rawComputedSoaOperationName, 0);
		} else {
			soaOperationName = computeNextOperationDisambiguedName(rawComputedSoaOperationName);
		}

		while (reservedOperationNames.contains(soaOperationName)) {
			soaOperationName = computeNextOperationDisambiguedName(rawComputedSoaOperationName);
		}

		return soaOperationName;
	}

	private String computeNextOperationDisambiguedName(String rawComputedSoaOperationName) {
		int disambiguationIndex = operationNamesDisambiguationIndex.get(rawComputedSoaOperationName) + 1;
		operationNamesDisambiguationIndex.put(rawComputedSoaOperationName, disambiguationIndex);

		return rawComputedSoaOperationName + disambiguationIndex;
	}

	private Interface getOrCreateInterface(Service soaService) {
		Interface soaInterface = soaService.getOwnedInterface();
		if (soaInterface == null) {
			soaInterface = SoaFactory.eINSTANCE.createInterface();
			soaService.setOwnedInterface(soaInterface);
			soaInterface.setName(soaService.getName());
		}
		return soaInterface;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaInputParameter(org.obeonetwork.dsl.soa.Operation soaOperation,
			Parameter swgParameter) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		soaOperation.getInput().add(soaParameter);

		ParameterRestData soaRestData = SoaFactory.eINSTANCE.createParameterRestData();
		soaRestData.setRestId(swgParameter.getName());

		soaParameter.setRestData(soaRestData);

		soaParameter.setName(swgParameter.getName());

		soaParameter.setDescription(swgParameter.getDescription());

		soaParameter.setMultiplicity(computeMultiplicity(
				swgParameter.getRequired() != null && swgParameter.getRequired(), swgParameter.getSchema()));

		if (swgParameter instanceof CookieParameter) {
			soaParameter.getRestData().setPassingMode(ParameterPassingMode.COOKIE);
		} else if (swgParameter instanceof HeaderParameter) {
			soaParameter.getRestData().setPassingMode(ParameterPassingMode.HEADER);
		} else if (swgParameter instanceof PathParameter) {
			soaParameter.getRestData().setPassingMode(ParameterPassingMode.PATH);
		} else if (swgParameter instanceof QueryParameter) {
			soaParameter.getRestData().setPassingMode(ParameterPassingMode.QUERY);
		} else {
			logError(String.format("Unsupported parameter type : %s.", swgParameter.getClass().getName()));
		}

		Schema schema = unwrapArrayOrComposedSchema(swgParameter.getSchema());
		if (schema != null) {
			Type soaParameterType = getOrCreateSoaParameterType(soaOperation, schema, soaParameter);
			soaParameter.setType(soaParameterType);
		}

		extractPropertiesExtensions(swgParameter, soaParameter);

		return soaParameter;
	}

	private Schema unwrapArrayOrComposedSchema(Schema schema) {
		if (schema instanceof ArraySchema && ((ArraySchema) schema).getItems() != null) {
			return ((ArraySchema) schema).getItems();
		} else if (schema instanceof ComposedSchema) {
			List<Schema> allOf = ((ComposedSchema) schema).getAllOf();
			if (allOf.size() == 1) {
				return allOf.get(0);
			}
		}
		return schema;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaBodyParameter(org.obeonetwork.dsl.soa.Operation soaOperation,
			RequestBody requestBody) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		extractPropertiesExtensions(requestBody, soaParameter);

		soaOperation.getInput().add(soaParameter);

		soaParameter.setRestData(SoaFactory.eINSTANCE.createParameterRestData());
		soaParameter.getRestData().setPassingMode(ParameterPassingMode.BODY);

		soaParameter.setName(BODY_PARAMETER_NAME);

		soaParameter.setDescription(requestBody.getDescription());

		if (requestBody.getContent() != null && !requestBody.getContent().isEmpty()) {
			Set<Entry<String, MediaType>> contents = requestBody.getContent().entrySet();

			Schema schema = contents.stream().map(c -> c.getValue()).filter(m -> m.getSchema() != null)
					.map(m -> m.getSchema()).findFirst().orElse(null);

			if (schema != null) {
				soaParameter.setMultiplicity(
						computeMultiplicity(requestBody.getRequired() != null && requestBody.getRequired(), schema));

				Schema unwrappedSchema = unwrapArrayOrComposedSchema(schema);
				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, soaParameter);
				soaParameter.setType(soaParameterType);
			}

			contents.forEach(entry -> {
				String identifier = entry.getKey();
				MediaType mediaType = entry.getValue();
				org.obeonetwork.dsl.soa.MediaType soaMediaType = SoaFactory.eINSTANCE.createMediaType();
				extractPropertiesExtensions(mediaType, soaMediaType);

				soaMediaType.setIdentifier(identifier);
				soaMediaType.getExamples().addAll(createSoaExamples(mediaType));
				soaParameter.getMediaType().add(soaMediaType);
			});
		}

		return soaParameter;
	}

	private Collection<? extends Example> createSoaExamples(MediaType mediaType) {
		List<Example> examples = new ArrayList<>();

		if (mediaType.getExamples() != null) {
			List<Example> collect = mediaType.getExamples().entrySet().stream().map(entrySet -> {
				String name = entrySet.getKey();
				io.swagger.v3.oas.models.examples.Example example = entrySet.getValue();
				return createSoaExample(name, example);
			}).collect(Collectors.toList());
			examples.addAll(collect);
		}

		return examples;
	}

	private Example createSoaExample(String name, io.swagger.v3.oas.models.examples.Example example) {
		Example soaExample = SoaFactory.eINSTANCE.createExample();
		soaExample.setName(name);
		soaExample.setSummary(example.getSummary());
		soaExample.setDescription(example.getDescription());
		soaExample.setValue(ExampleGenUtil.getExampleValueFromObject(soaExample.getValue()));

		extractPropertiesExtensions(example, soaExample);

		return soaExample;
	}

	private Type getOrCreateSoaParameterType(org.obeonetwork.dsl.soa.Operation soaOperation, Schema schema,
			org.obeonetwork.dsl.soa.Parameter soaParameter) {
		Type soaParameterType = null;

		if (schema.get$ref() != null) {
			soaParameterType = getExposedTypeFrom$ref(schema.get$ref());
		} else if (isPrimitiveType(schema)) {
			soaParameterType = getPrimitiveType(schema);
		} else {
			if (isEnum(schema)) {
				Enumeration soaEnumeration = EnvironmentFactory.eINSTANCE.createEnumeration();

				updateEnumeration(soaEnumeration, schema);
				soaParameterType = registerInlineType(soaParameter, soaEnumeration);
			} else if (isObject(schema)) {
				DTO soaDto = EnvironmentFactory.eINSTANCE.createDTO();

				updateDto(soaDto, schema);
				soaParameterType = registerInlineType(soaParameter, soaDto);
			}
		}

		extractPropertiesExtensions(schema, soaParameter);

		return soaParameterType;
	}

	private org.obeonetwork.dsl.soa.Parameter createSoaResponseParameter(org.obeonetwork.dsl.soa.Operation soaOperation,
			String responseKey, ApiResponse apiResponse) {
		org.obeonetwork.dsl.soa.Parameter soaParameter = SoaFactory.eINSTANCE.createParameter();
		extractPropertiesExtensions(apiResponse, soaParameter);
		String parameterName = null;
		if (responseKey.matches("[123]..") || responseKey.equals("default")) {
			soaOperation.getOutput().add(soaParameter);
			parameterName = "output" + responseKey;
		} else if (responseKey.matches("[45]..")) {
			soaOperation.getFault().add(soaParameter);
			parameterName = "fault" + responseKey;
		} else {
			logError(String.format("Unsupported status code : %s for operation %s with path %s.", responseKey,
					soaOperation.getName(), soaComponent.getURI() + soaOperation.getURI()));
			return null;
		}
		soaParameter.setName(parameterName);

		soaParameter.setStatusCode(responseKey);
		soaParameter.setDescription(apiResponse.getDescription());
		soaParameter.setStatusMessage(emptyIfNull(HttpStatusService.getHttpMessage(responseKey)));

		if (apiResponse.getContent() != null && !apiResponse.getContent().isEmpty()) {
			Set<Entry<String, MediaType>> contents = apiResponse.getContent().entrySet();

			Schema schema = contents.stream().map(c -> c.getValue()).filter(m -> m.getSchema() != null)
					.map(m -> m.getSchema()).findFirst().orElse(null);

			if (schema != null) {
				soaParameter.setMultiplicity(computeMultiplicity(false, schema));

				Schema unwrappedSchema = unwrapArrayOrComposedSchema(schema);

				Type soaParameterType = getOrCreateSoaParameterType(soaOperation, unwrappedSchema, soaParameter);
				soaParameter.setType(soaParameterType);
			}

			contents.forEach(entry -> {
				String identifier = entry.getKey();
				MediaType mediaType = entry.getValue();
				org.obeonetwork.dsl.soa.MediaType soaMediaType = SoaFactory.eINSTANCE.createMediaType();
				soaMediaType.setIdentifier(identifier);
				soaMediaType.getExamples().addAll(createSoaExamples(mediaType));
				soaParameter.getMediaType().add(soaMediaType);

				extractPropertiesExtensions(mediaType, soaMediaType);
			});
		}

		return soaParameter;
	}

	private Service getSoaServiceFromPath(String path) {
		String soaServiceName = getSoaServiceNameFromPath(path);

		return soaComponent.getProvidedServices().stream()
				.filter(soaService -> Objects.equals(soaServiceName, soaService.getName())).findFirst().orElse(null);
	}

	private void buildSoaServices() {
		String soaComponentUri = getCommonPathBeforePathParam(openApi.getPaths().keySet());
		soaComponent.setURI(soaComponentUri);

		Map<String, List<String>> soaServicesPaths = new HashMap<>();
		for (String path : openApi.getPaths().keySet()) {
			String soaServiceName = getSoaServiceNameFromPath(path);
			List<String> servicePaths = soaServicesPaths.get(soaServiceName);
			if (servicePaths == null) {
				servicePaths = new ArrayList<>();
				soaServicesPaths.put(soaServiceName, servicePaths);
			}
			servicePaths.add(path);
		}

		extractPropertiesExtensions(openApi.getPaths(), soaComponent);

//		for(String soaServiceName : soaServicesPaths.keySet()) {
//			List<String> servicePaths = soaServicesPaths.get(soaServiceName);
//			System.out.println(soaServiceName);
//			for(String servicePath : servicePaths) {
//				System.out.println("  " + servicePath);
//			}
//		}

		for (String soaServiceName : soaServicesPaths.keySet()) {
			String soaServiceUri = getCommonPathBeforePathParam(soaServicesPaths.get(soaServiceName).stream()
					.map(path -> path.substring(soaComponentUri.length())).collect(toList()));

			Service soaService = SoaFactory.eINSTANCE.createService();
			soaService.setName(soaServiceName);
			soaService.setURI(soaServiceUri);
			soaService.setKind(InterfaceKind.PROVIDED_LITERAL);

			List<String> soaServiceTags = soaServicesPaths.get(soaServiceName).stream()
					.flatMap(path -> openApi.getPaths().get(path).readOperations().stream())
					.filter(op -> op.getTags() != null).flatMap(op -> op.getTags().stream()).collect(toSet()).stream()
					.sorted().collect(toList());

			StringBuffer soaServiceDescription = new StringBuffer();
			for (int tagIndex = 0; tagIndex < soaServiceTags.size(); tagIndex++) {
				String tagName = soaServiceTags.get(tagIndex);
				if (soaServiceTags.size() > 1) {
					soaServiceDescription.append(tagName).append(":").append(System.lineSeparator());
				}

				Tag tagElement = null;
				if (openApi.getTags() != null) {
					tagElement = openApi.getTags().stream().filter(t -> tagName.equals(t.getName())).findFirst()
							.orElse(null);
				}
				if (tagElement != null) {
					soaServiceDescription.append(tagElement.getDescription());
					extractPropertiesExtensions(tagElement, soaService);
				}

				if (tagIndex < soaServiceTags.size() - 1) {
					soaServiceDescription.append(System.lineSeparator());
				}
			}
			soaService.setDescription(soaServiceDescription.toString());

			soaComponent.getOwnedServices().add(soaService);
		}
	}

	private String getCommonPathBeforePathParam(Collection<String> paths) {
		List<String> commonPath = getCommonPath(
				paths.stream().map(path -> Arrays.asList(path.split(QUALIFIED_PATH_SEPARATOR))).collect(toList()));

		List<String> commonPathBeforePathParam = new ArrayList<>();
		Iterator<String> commonPathSegmentsIterator = commonPath.iterator();
		boolean stop = false;
		while (commonPathSegmentsIterator.hasNext() && !stop) {
			String segment = commonPathSegmentsIterator.next();
			stop = PATH_PARAM_PATTERN_PREDICATE.test(segment);
			if (!stop) {
				commonPathBeforePathParam.add(segment);
			}
		}

		return commonPathBeforePathParam.stream().collect(joining(QUALIFIED_PATH_SEPARATOR));
	}

	private PathItem getPathItemFromPath(String path) {
		return openApi.getPaths().get(path);
	}

	private String getSoaServiceNameFromPath(String path) {
		String soaServiceName = openApi.getPaths().get(path).readOperations().stream()
				.filter(op -> op.getTags() != null).flatMap(op -> op.getTags().stream()).collect(toSet()).stream()
				.map(tag -> upperFirst(tag)).sorted().collect(joining());

		if (soaServiceName.isEmpty()) {
			soaServiceName = upperFirst(DEFAULT_SERVICE_NAME);
		}

		return soaServiceName;
	}

	private void buildSoaExposedTypes() {
		if (openApi.getComponents() != null && openApi.getComponents().getSchemas() != null ) {
			openApi.getComponents().getSchemas().entrySet().stream()
			.filter(entry -> !isPrimitiveType(entry.getValue()))
			.forEach(entry -> touchExposedType(entry.getKey(), entry.getValue()));
			
			openApi.getComponents().getSchemas().entrySet().stream()
			.filter(entry -> !isPrimitiveType(entry.getValue()))
			.forEach(entry -> updateExposedType(getExposedTypeFromKey(entry.getKey()), entry.getValue()));
		}
	}

	private Type touchExposedType(String key, Schema schema) {
		Type exposedType = getExposedTypeFromKey(key);
		if (exposedType != null) {
			logError(String.format("Could not create exposed type %s : type already exists.", key));
			return null;
		}
		int soaTypeId = computeSoaType(schema);
		switch (soaTypeId) {
		case EnvironmentPackage.DTO:
			exposedType = touchDto(key);
			break;
		case EnvironmentPackage.ENUMERATION:
			exposedType = touchEnumeration(key);
			break;
		}

		extractPropertiesExtensions(schema, exposedType);
		return exposedType;
	}

	private DTO touchDto(String key) {
		Namespace namespace = getOrCreateNamespaceFromComponentKey(key);
		String dtoName = computeExposedTypeNameFromKey(key);
		return touchDto(namespace, dtoName);
	}

	private String computeExposedTypeNameFromKey(String key) {
		String[] segments = key.split(QUALIFIED_PATH_SEPARATOR);
		return segments[segments.length - 1];
	}

	private Enumeration touchEnumeration(String key) {
		Namespace namespace = getOrCreateNamespaceFromComponentKey(key);
		String enumerationName = computeExposedTypeNameFromKey(key);
		return touchEnumeration(namespace, enumerationName);
	}

	private Namespace getOrCreateNamespace(Namespace namespace, String name) {

		Namespace ownedNamespace = NamespaceGenUtil.getNamespaceByName(namespace, name);

		if (ownedNamespace == null) {
			ownedNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			namespace.getOwnedNamespaces().add(ownedNamespace);
			ownedNamespace.setName(name);
		}

		return ownedNamespace;
	}

	private Namespace getOrCreateRootNamespace() {
		if (soaRootNamespace == null) {
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

		if (schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema) schema;
			if (!composedSchema.getAllOf().isEmpty()) {
				Schema subSchema = composedSchema.getAllOf().get(0);
				typeId = computeSoaType(subSchema);
			}
		} else if (schema.get$ref() != null) {
			Schema refSchema = getReferencedSchema(schema.get$ref());
			if (refSchema != null) {
				typeId = computeSoaType(refSchema);
			}
		} else if (isEnum(schema)) {
			typeId = EnvironmentPackage.ENUMERATION;
		} else if (isObject(schema)) {
			typeId = EnvironmentPackage.DTO;
		}

		if (typeId == -1) {
			logError("Schema type not supported : type=" + schema.getType() + " format=" + schema.getFormat());
		}

		return typeId;
	}

	private boolean isPrimitiveType(Schema schema) {
		if(schema.get$ref() != null) {
			return isPrimitiveType(getReferencedSchema(schema.get$ref()));
		}
		
		String type = schema.getType();
		List _enum = schema.getEnum();
		return OPEN_API_TYPE_INTEGER.equals(type) 
				|| OPEN_API_TYPE_NUMBER.equals(type) 
				|| (OPEN_API_TYPE_STRING.equals(type) && (_enum == null || _enum.isEmpty())) 
				|| OPEN_API_TYPE_BOOLEAN.equals(type);
	}

	private Schema getReferencedSchema(String $ref) {
		Schema schema = null;

		if (!$ref.startsWith(COMPONENT_SCHEMA_$REF)) {
			logError("Unmanaged reference : " + $ref);
		} else {
			String key = $ref.substring(COMPONENT_SCHEMA_$REF.length());
			schema = openApi.getComponents().getSchemas().get(key);
			if (schema == null) {
				logError(String.format("Reference \"%s\" cannot be resolved.", $ref));
			}
		}

		return schema;
	}

	private void updateExposedType(Type exposedType, Schema schema) {
		switch (exposedType.eClass().getClassifierID()) {
		case EnvironmentPackage.DTO:
			updateDto((DTO) exposedType, schema);
			break;
		case EnvironmentPackage.ENUMERATION:
			updateEnumeration((Enumeration) exposedType, schema);
			break;
		}
	}

	private Enumeration updateEnumeration(Enumeration enumeration, Schema schema) {
		Set<String> literalNames = new HashSet<>();
		collectLiterals(literalNames, schema);
		updateEnumeration(enumeration, literalNames);

		return enumeration;

	}

	private void collectLiterals(Set<String> literalNames, Schema schema) {

		if (schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema) schema;
			for (Schema subSchema : composedSchema.getAllOf()) {
				collectLiterals(literalNames, subSchema);
			}
		} else if (schema.get$ref() != null) {
			Schema refSchema = getReferencedSchema(schema.get$ref());
			if (refSchema != null) {
				collectLiterals(literalNames, refSchema);
			}
		} else if (schema.getEnum() != null) {
			schema.getEnum().forEach(e -> literalNames.add(e.toString()));
		}

	}

	private Enumeration updateEnumeration(Enumeration enumeration, Set<String> literalNames) {
		for (String literalName : literalNames) {
			Literal literal = EnvironmentFactory.eINSTANCE.createLiteral();
			enumeration.getLiterals().add(literal);
			literal.setName(literalName);
		}
		return enumeration;
	}

	private DTO updateDto(DTO dto, Schema schema) {
		if (conformsToGeneratizationPattern(schema)) {
			Schema parentSchema = getParentFromGeneralizationSchema(schema);
			DTO superType = (DTO) getExposedTypeFrom$ref(parentSchema.get$ref());
			Schema baseSchema = getBaseFromGeneralizationSchema(schema);
			dto.setSupertype(superType);
			buildSoaProperties(dto, schema, getProperties(baseSchema));
		} else if (schema instanceof ComposedSchema) {
			buildSoaProperties(dto, schema, getAllProperties(schema));
		} else if (schema.get$ref() != null) {
			// Case of a pass-trough type
			DTO superType = (DTO) getExposedTypeFrom$ref(schema.get$ref());
			dto.setSupertype(superType);
		} else {
			// Terminal case of a structure defining properties
			buildSoaProperties(dto, schema, getProperties(schema));
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
		if (schema instanceof ComposedSchema) {
			ComposedSchema composedSchema = (ComposedSchema) schema;
			for (Schema subSchema : composedSchema.getAllOf()) {
				collectAllProperties(allProperties, subSchema);
			}
		} else if (schema.get$ref() != null) {
			Schema refSchema = getReferencedSchema(schema.get$ref());
			if (refSchema != null) {
				collectAllProperties(allProperties, refSchema);
			}
		}
	}

	private boolean conformsToGeneratizationPattern(Schema schema) {
		if (!(schema instanceof ComposedSchema)) {
			return false;
		}

		ComposedSchema composedSchema = (ComposedSchema) schema;
		if (composedSchema.getAllOf() == null || composedSchema.getAllOf().size() != 2) {
			return false;
		}

		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);

		if (schema1.get$ref() != null && schema2.get$ref() == null && isObject(schema2)) {
			return true;
		}

		if (schema2.get$ref() != null && schema1.get$ref() == null && isObject(schema1)) {
			return true;
		}

		return false;
	}

	private Schema getParentFromGeneralizationSchema(Schema schema) {
		ComposedSchema composedSchema = (ComposedSchema) schema;

		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);

		if (schema1.get$ref() != null) {
			return schema1;
		}

		return schema2;
	}

	private Schema getBaseFromGeneralizationSchema(Schema schema) {
		ComposedSchema composedSchema = (ComposedSchema) schema;

		Schema schema1 = composedSchema.getAllOf().get(0);
		Schema schema2 = composedSchema.getAllOf().get(1);

		if (schema1.get$ref() == null) {
			return schema1;
		}

		return schema2;
	}

	private void buildSoaProperties(StructuredType type, Schema enclosingSchema, Map<String, Schema> properties) {
		for (String propertyKey : properties.keySet()) {
			Schema property = properties.get(propertyKey);
			Property soaProperty = createSoaProperty(type, enclosingSchema, propertyKey, property);
			if (soaProperty == null) {
				logError(String.format("Unsupported property type : %s for key %s.", property.getClass().getName(),
						propertyKey));
			}
		}
	}

	private Property createSoaProperty(StructuredType type, Schema enclosingSchema, String propertyKey,
			Schema propertySchema) {
		Property soaProperty = null;

		Schema unwrappedSchema = unwrapArrayOrComposedSchema(propertySchema);
		if (isPrimitiveType(unwrappedSchema)) {
			soaProperty = createPrimitiveTypeAttribute(type, unwrappedSchema);
		} else if (unwrappedSchema.get$ref() != null) {
			soaProperty = createReferencedTypeProperty(type, unwrappedSchema);
		} else {
			soaProperty = createInlineTypeProperty(type, propertyKey, unwrappedSchema);
		}

		if (soaProperty != null) {
			soaProperty.setName(propertyKey);

			soaProperty.setMultiplicity(computeMultiplicity(
					enclosingSchema.getRequired() != null && enclosingSchema.getRequired().contains(propertyKey),
					propertySchema));
		}

		extractPropertiesExtensions(propertySchema, soaProperty);

		return soaProperty;
	}

	private Property createReferencedTypeProperty(StructuredType type, Schema propertySchema) {
		Property soaProperty = null;

		switch (computeSoaType(propertySchema)) {
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
		attribute.setType((DataType) getExposedTypeFrom$ref(propertySchema.get$ref()));

		return attribute;
	}

	private Reference createReferencedDtoReference(StructuredType type, Schema propertySchema) {
		Reference reference = EnvironmentFactory.eINSTANCE.createReference();
		type.getOwnedReferences().add(reference);
		reference.setReferencedType((StructuredType) getExposedTypeFrom$ref(propertySchema.get$ref()));

		return reference;
	}

	private Type getExposedTypeFrom$ref(String $ref) {
		Type exposedType = null;
		if (!$ref.startsWith(COMPONENT_SCHEMA_$REF)) {
			logWarning("Unmanaged reference : " + $ref);
		} else {
			String key = $ref.substring(COMPONENT_SCHEMA_$REF.length());
			exposedType = getExposedTypeFromKey(key);
		}

		return exposedType;
	}

	private Property createInlineTypeProperty(StructuredType type, String propertyKey, Schema propertySchema) {
		Property soaProperty = null;

		switch (computeSoaType(propertySchema)) {
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
		if(schema.get$ref() != null) {
			return getPrimitiveType(getReferencedSchema(schema.get$ref()));
		}
		
		String primitiveTypeName = getPrimitiveTypeName(schema);
		if (primitiveTypeName != null) {
			return environment.getTypesDefinition().getTypes().stream().filter(t -> t instanceof DataType)
					.map(t -> (DataType) t).filter(t -> primitiveTypeName.equals(t.getName())).findFirst().orElse(null);
		} else {
			logWarning(String.format("Primitive type mapping not found for schema type \"%s\" and format \"%s\".",
					schema.getType(), schema.getFormat()));
		}
		return null;
	}

	private MultiplicityKind computeMultiplicity(boolean required, Schema schema) {
		int min = 0;
		int max = 1;

		if (schema instanceof ArraySchema) {
			ArraySchema arraySchema = (ArraySchema) schema;
			if ((arraySchema.getMinItems() != null && arraySchema.getMinItems() > 0)) {
				min = 1;
			}

			max = -1;
			if (arraySchema.getMaxItems() != null && arraySchema.getMaxItems() == 1) {
				max = 1;
			}
		}

		if (required) {
			min = 1;
		}

		MultiplicityKind multiplicity = null;
		if (min == 0 && max == 1) { // 0..1
			multiplicity = MultiplicityKind.ZERO_ONE_LITERAL;
		} else if (min == 0 && max == -1) { // 0..*
			multiplicity = MultiplicityKind.ZERO_STAR_LITERAL;
		} else if (min == 1 && max == 1) { // 1
			multiplicity = MultiplicityKind.ONE_LITERAL;
		} else if (min == 1 && max == -1) { // 1..*
			multiplicity = MultiplicityKind.ONE_STAR_LITERAL;
		}

		return multiplicity;
	}

	private Map<String, Schema> getProperties(Schema schema) {
		Map<String, Schema> properties = new HashMap<>();
		if (schema.getProperties() != null) {
			properties.putAll(schema.getProperties());
		}
		return properties;
	}

	private Type getExposedTypeFromKey(String key) {
		Namespace namespace = getOrCreateTypesNamespace();
		List<String> segments = new ArrayList<>(Arrays.asList(key.split(QUALIFIED_PATH_SEPARATOR)));
		String typeName = segments.remove(segments.size() - 1);

		Iterator<String> i = segments.iterator();
		while (i.hasNext() && namespace != null) {
			String segment = i.next();
			namespace = NamespaceGenUtil.getNamespaceByName(namespace, segment);
		}
		Type type = null;
		if (namespace != null) {
			type = NamespaceGenUtil.getTypeByName(namespace, typeName);
		}
		return type;
	}

	/**
	 * Sets the value of the {@link org.obeonetwork.dsl.soa.Contact} of a
	 * {@link Component} According to the {@link OpenAPI} {@link Contact}
	 * 
	 * @param component a {@link Component}
	 * @param contact   a {@link OpenAPI} {@link Contact}
	 */
	private void setContactInformation(Component component, Contact contact) {
		if (contact != null && component.getContact() != null) {
			component.getContact().setEmail(contact.getEmail());
			component.getContact().setName(contact.getName());
			component.getContact().setURL(contact.getUrl());
		}
	}

	/**
	 * Sets the value of the {@link org.obeonetwork.dsl.soa.License} of a
	 * {@link Component} According to the {@link OpenAPI} {@link License}
	 * 
	 * @param component a {@link Component}
	 * @param license   a {@link OpenAPI} {@link License}
	 */
	private void setLicenseInformation(Component component, License license) {
		if (license != null && component.getLicense() != null) {
			component.getLicense().setName(license.getName());
			component.getLicense().setURL(license.getUrl());
		}
	}

	/**
	 * Sets the value of the {@link Information} of a {@link Component} According to
	 * the {@link OpenAPI} {@link Info}.
	 * 
	 * @param component   a {@link Component}
	 * @param information a {@link OpenAPI} {@link Info}
	 */
	private void setInformation(Component component, Info information) {
		if (component.getInformation() != null && information != null) {
			component.getInformation().setTermsOfService(information.getTermsOfService());
			component.getInformation().setApiVersion(information.getVersion());
		}
	}

	private void extractPropertiesExtensions(Object swaggerElement, ObeoDSMObject soaElement) {
		PropertiesExtensionsHelper.addPropertiesExtensionsFromSwgToSoa(swaggerElement, soaElement);
	}
}
