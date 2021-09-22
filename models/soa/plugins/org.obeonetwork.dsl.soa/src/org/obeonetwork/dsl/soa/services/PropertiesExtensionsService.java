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
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.soa.PropertiesExtension;
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
//		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.TYPE, Arrays.asList("Schema"));
//		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.ATTRIBUTE, Arrays.asList("Schema"));
//		POSSIBLE_CONTEXTS.put(EnvironmentPackage.Literals.REFERENCE, Arrays.asList("Schema"));
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
		if (object != null) {
			return POSSIBLE_CONTEXTS.keySet().stream().anyMatch(eClass -> eClass.isInstance(object));
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
