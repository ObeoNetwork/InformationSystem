/*******************************************************************************
 * Copyright (c) 2021 Obeo.
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
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.PropertiesExtension;
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
	 * Checks if a {@link Type} is referenced by a Soa {@link Operation}
	 * @param type a {@link Type}
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean isReferencedByRESTService(Type type) {
		return new EObjectQuery(type).getInverseReferences(SoaPackage.eINSTANCE.getParameter_Type())
			.stream()
			.filter(Parameter.class::isInstance)
			.map(Parameter.class::cast)
			.anyMatch(p -> p.eContainer() != null && p.eContainer() instanceof Operation && ExpositionKind.REST.equals(((Operation) p.eContainer()).getExposition()));
	}
	
	/**
	 * Checks if a {@link Reference} starts from, or targets, a {@link Type} that is referenced by a Soa {@link Operation}
	 * @param reference a {@link Reference}
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean isReferencedByRESTService(Reference reference) {
		boolean isTargetRestService = false;
		boolean isSourceRestService = false;
		if (reference.getContainingType() != null) { 
			isSourceRestService = isReferencedByRESTService(reference.getContainingType());					
		}
		if (reference.getReferencedType() != null) {
			isTargetRestService = isReferencedByRESTService(reference.getReferencedType());
		}
		return isTargetRestService || isSourceRestService;
	}
	
	/**
	 * Checks if the {@link Attribute} is contained in a {@link Type} that is referenced by a Soa {@link Operation}
	 * @param attribute an {@link Attribute}
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean isReferencedByRESTService(Attribute attribute) {
		if (attribute.getContainingType() != null) {
			return isReferencedByRESTService(attribute.getContainingType());
		} else {
			return false;
		}
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
