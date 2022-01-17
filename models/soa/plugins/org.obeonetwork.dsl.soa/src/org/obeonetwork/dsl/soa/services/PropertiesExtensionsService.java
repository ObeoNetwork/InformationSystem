/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SoaPackage.Literals;

/**
 * Services around support for OpenAPI Properties extensions
 */
public class PropertiesExtensionsService {

	public static final String PROPERTIES_EXTENSION_PREFIX = "x-";
	
	private static final Map<EClass, Collection<String>> POSSIBLE_CONTEXTS = new HashMap<>();
	
	static {
		POSSIBLE_CONTEXTS.put(Literals.COMPONENT, Arrays.asList("OpenAPI", "Paths"));
		POSSIBLE_CONTEXTS.put(Literals.CONTACT, Arrays.asList("Contact"));
		POSSIBLE_CONTEXTS.put(Literals.INFORMATION, Arrays.asList("Info"));
		POSSIBLE_CONTEXTS.put(Literals.LICENSE, Arrays.asList("License"));
		POSSIBLE_CONTEXTS.put(Literals.SERVICE, Arrays.asList("Tag"));
		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.TYPE, Arrays.asList("Schema"));
		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.ATTRIBUTE, Arrays.asList("Schema"));
		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.REFERENCE, Arrays.asList("Schema"));
		POSSIBLE_CONTEXTS.put(Literals.OPERATION, Arrays.asList("Operation", "PathItem", "ApiResponses"));
		POSSIBLE_CONTEXTS.put(Literals.PARAMETER, Arrays.asList("Parameter", "RequestBody", "ApiResponse", "Schema"));
		POSSIBLE_CONTEXTS.put(Literals.MEDIA_TYPE, Arrays.asList("MediaType"));
		POSSIBLE_CONTEXTS.put(Literals.EXAMPLE, Arrays.asList("Example"));
		POSSIBLE_CONTEXTS.put(Literals.SERVER, Arrays.asList("Server"));
	}

	/**
	 * Return the PropertiesExtension objects attached to an object
	 * 
	 * @param object current object
	 * @param context context attached to the extensions
	 * @return List of PropertiesExtensions attached to the object
	 */
	public static Collection<PropertiesExtension> getPropertiesExtensions(ObeoDSMObject object, String context) {
		if (object != null) {
			MetaDataContainer metadatas = object.getMetadatas();
			if (metadatas != null) {
				return metadatas.getMetadatas().stream().filter(PropertiesExtension.class::isInstance).map(PropertiesExtension.class::cast)
						.filter(it -> context == null || context.equals(it.getContext())).collect(Collectors.toList());
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Check if a Component is at least partially exposed i.e. one of its provided service is exposed 
	 * @param component Component
	 * @return true if one of the contained provided services is exposed
	 */
	public static boolean isConcernedByExposition(Component component) {
		if (component != null) {
			return component.getProvidedServices().stream().anyMatch(service -> isConcernedByExposition(service));
		}
		return false;
	}
	
	/**
	 * Check if a Service is at least partially exposed i.e. one of its operations is exposed
	 * @param service Service
	 * @return true if one of the contained operations is exposed
	 */
	public static boolean isConcernedByExposition(Service service) {
		if (service != null) {
			Interface ownedInterface = service.getOwnedInterface();
			if (ownedInterface != null) {
				return ownedInterface.getOwnedOperations().stream().anyMatch(operation -> isConcernedByExposition(operation));
			}
		}
		return false;
	}
	
	/**
	 * Check if an Operation is exposed
	 * @param operation Operation
	 * @return true if containing service is a provided service and operation exposition is different from NONE
	 */
	public static boolean isConcernedByExposition(Operation operation) {
		if (operation != null) {
			if (ExpositionKind.NONE.equals(operation.getExposition())) {
				return false;
			} else {
				if (operation.eContainer() instanceof Interface) {
					Interface itf = (Interface)operation.eContainer();
					if (itf.eContainer() instanceof Service) {
						Service service = (Service)itf.eContainer();
						return InterfaceKind.PROVIDED_LITERAL.equals(service.getKind()); 					
					}
				}				
			}
		}
		return false;
	}
	
	/**
	 * Check if a parameter is concerned by exposition, i.e. its containing Operation is exposed
	 * @param parameter Parameter
	 * @return true if containing operation is concerned by exposition
	 */
	public static boolean isConcernedByExposition(Parameter parameter) {
		if (parameter != null && parameter.eContainer() instanceof Operation) {
			return isConcernedByExposition((Operation)parameter.eContainer());
		}
		return false;
	}
	
	/**
	 * Check if an element supports properties extensions
	 * 
	 * @param object Current object
	 * @return true if element can have properties extensions
	 */
	public static boolean isPropertiesExtensionPossible(EObject object) {
		if (object != null && POSSIBLE_CONTEXTS.keySet().stream().anyMatch(eClass -> eClass.isInstance(object))) {
			if (EnvironmentPackage.Literals.TYPE.isInstance(object)) {
				return isReferencedByRESTService((Type) object);
			} else if (EnvironmentPackage.Literals.ATTRIBUTE.isInstance(object)) {
				return isReferencedByRESTService((Attribute) object);
			} else if (EnvironmentPackage.Literals.REFERENCE.isInstance(object)) {
				return isReferencedByRESTService((Reference) object);				
			} else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if a {@link Type} is referenced directly or indirectly by a REST {@link Operation}
	 * 
	 * @param type a {@link Type}
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean isReferencedByRESTService(Type type) {
		return isReferencedByRESTService(type, new HashSet<>());
	}
	
	private static boolean isReferencedByRESTService(Type type, Set<Type> visitedTypes) {
		if(visitedTypes.contains(type)) {
			return false;
		}
		
		if(new EObjectQuery(type).getInverseReferences(SoaPackage.eINSTANCE.getParameter_Type())
			.stream()
			.map(Parameter.class::cast)
			.anyMatch(p -> p.eContainer() != null && p.eContainer() instanceof Operation && 
				ExpositionKind.REST.equals(((Operation) p.eContainer()).getExposition()))) {
			return true;
		}
		
		visitedTypes.add(type);
		
		return new EObjectQuery(type).getInverseReferences(EnvironmentPackage.eINSTANCE.getReference_ReferencedType()).stream()
			.map(Reference.class::cast).filter(ref -> ref.getContainingType() != null).map(ref -> ref.getContainingType())
			.anyMatch(referencingType -> isReferencedByRESTService(referencingType, visitedTypes));
		
	}
	
	/**
	 * Checks if a {@link Property} is owned by a {@link Type} involved in a REST {@link Operation}
	 * 
	 * @param property a {@link Property}
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean isReferencedByRESTService(Property property) {
		if (property.eContainer() instanceof Type) { 
			return isReferencedByRESTService((Type)property.eContainer());					
		}
		return false;
	}
	
	/**
	 * Return all possible OpenAPI contexts for an object 
	 * 
	 * @param object Current object
	 * @return collection of string corresponding to OpenAPI contexts i.e. OpenAPI tags
	 */
	public static Collection<String> getPossibleContexts(EObject object) {
		if (object != null) {
			Collection<String> contexts = POSSIBLE_CONTEXTS.entrySet().stream().filter(entry -> entry.getKey().isInstance(object)).map(entry -> entry.getValue()).flatMap(it -> it.stream())
					.collect(Collectors.toList());
			return contexts;
		}
		return Collections.emptyList();
	}
	
	/**
	 * Return the default context to use for an object
	 * 
	 * @param object SOA element
	 * @return the default context
	 */
	public static String getDefaultContext(EObject object) {
		if (object != null && object.eContainer() != null && object.eContainer().eContainer() != null) {
			EObject mainObject = object.eContainer().eContainer();
			Collection<String> possibleContexts = getPossibleContexts(mainObject);
			if (possibleContexts != null && !possibleContexts.isEmpty()) {
				return possibleContexts.iterator().next();
			}
		}
		return "";
	}
}
