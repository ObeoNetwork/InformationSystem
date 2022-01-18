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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.services.PropertiesExtensionsService;

import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;

/**
 *
 * Helper methods around Properties Extensions
 *
 */
public class PropertiesExtensionsHelper {

	/**
	 * Return the properties extensions existing on a SOA element
	 * that correspond to the context of a swagger object
	 * @param soaElement SOA element
	 * @param swaggerContextObject Swagger element used to define context
	 * @return collection of properties extension of the corresponding context
	 */
	public static Collection<PropertiesExtension> getPropertiesExtensionForSwaggerContext(ObeoDSMObject soaElement, Object swaggerContextObject) {
		String context = PropertiesExtensionsHelper.getContext(swaggerContextObject);
		return PropertiesExtensionsService.getPropertiesExtensions(soaElement, context);
	}
	
	/**
	 * Add all properties extension from a SOA element to the corresponding Swagger element
	 * @param soaElement SOA Element
	 * @param swaggerElement Swagger element that will be modified
	 */
    public static void addPropertiesExtensionsFromSoaToSwg(ObeoDSMObject soaElement, Object swaggerElement) {
    	if (swaggerElement != null) {
    		String context = getContext(swaggerElement);
			Collection<PropertiesExtension> extensions = PropertiesExtensionsService.getPropertiesExtensions(soaElement, context);
    		for (PropertiesExtension extension : extensions) {
    			PropertiesExtensionsHelper.addPropertiesExtensionToSwgElt(swaggerElement, extension);
			}
    	}
    }
    
    public static void addPropertiesExtensionsFromSwgToSoa(Object swaggerElement, ObeoDSMObject soaElement) {
    	if (swaggerElement != null && soaElement != null) {
    		Collection<PropertiesExtension> extensions = getPropertiesExtensionFromSwgElt(swaggerElement, soaElement);
    		for (PropertiesExtension extension : extensions) {
    			addPropertiesExtension(soaElement, extension);
			}
    	}
    }
	
    private static void addPropertiesExtension(ObeoDSMObject object, PropertiesExtension extension) {
    	if (object != null) {
    		MetaDataContainer metadatas = object.getMetadatas();
    		// Initialize container if required
    		if (metadatas == null) {
    			metadatas = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
    			object.setMetadatas(metadatas);
    		}
    		
    		metadatas.getMetadatas().add(extension);
    	}
    }
    
    /**
     * Add a PropertiesExtension object values to a Swagger element
     * @param swaggerElement Swagger element
     * @param extension SOA PropertiesExtension object
     */
    private static void addPropertiesExtensionToSwgElt(Object swaggerElement, PropertiesExtension extension) {
    	try {
			Method addExtensionMethod = swaggerElement.getClass().getMethod("addExtension", String.class, Object.class);
			addExtensionMethod.invoke(swaggerElement, extension.getTitle(), extension.getBody());
		} catch (Exception e) {
			// no method available to add properties extension or error while invoking the method, exit the method
			return;
		}
    }
    
    private static Collection<PropertiesExtension> getPropertiesExtensionFromSwgElt(Object swaggerElement, ObeoDSMObject soaElement) {
    	try {
			Method getExtensionsMethod = swaggerElement.getClass().getMethod("getExtensions");
			Object result = getExtensionsMethod.invoke(swaggerElement);
			if (result instanceof Map<?, ?>) {
				String context = getContext(swaggerElement);
				return ((Map<?,?>)result).entrySet().stream().map(entry -> {
					PropertiesExtension extension = null;
					// Check if this context is available for the SOA Element
					if (PropertiesExtensionsService.getPossibleContexts(soaElement).contains(context)) {
						extension = SoaFactory.eINSTANCE.createPropertiesExtension();
						extension.setContext(context);
						Object key = entry.getKey();
						if (key instanceof String) {
							extension.setTitle((String)key);						
						}
						Object value = entry.getValue();
						if (value != null) {
							extension.setBody(value.toString());						
						}
					}
					return extension;
				}).filter(Objects::nonNull).collect(Collectors.toList());
			}
		} catch (Exception e) {
			// no method available to get extensions, we return an empty list
		}
    	return Collections.emptyList();
    }
    
	/**
	 * Return the context to be used with PropertiesExtension objects
	 * 
	 * @param swaggerElement Swagger object
	 * @return the context to use with PropertiesExtension
	 */
	private static String getContext(Object swaggerElement) {
		if (swaggerElement != null) {
			// Special case for Schema inheritance
			if (swaggerElement instanceof Schema) {
				return Schema.class.getSimpleName();
			}
			
			// Special case for Parameter inheritance
			if (swaggerElement instanceof Parameter) {
				return Parameter.class.getSimpleName();
			}
			
			return swaggerElement.getClass().getSimpleName();
		}
		return null;
	}
}
