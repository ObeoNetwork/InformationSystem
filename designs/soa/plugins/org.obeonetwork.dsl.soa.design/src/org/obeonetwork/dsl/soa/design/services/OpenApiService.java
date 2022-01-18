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
package org.obeonetwork.dsl.soa.design.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.services.PropertiesExtensionsService;

/**
 * Services around Open API
 */
public class OpenApiService {
	
	
	/**
	 * Return the key to display, without the "x-" prefix
	 * 
	 * @param extension Properties extension
	 * @return key without the "x-" prefix
	 */
	public String getPropertiesExtensionKeyToDisplay(PropertiesExtension extension) {
		if (extension != null) {
			String key = extension.getTitle();
			if (key != null) {
				if ( key.toLowerCase().startsWith(PropertiesExtensionsService.PROPERTIES_EXTENSION_PREFIX)) {
					return key.substring(PropertiesExtensionsService.PROPERTIES_EXTENSION_PREFIX.length());
				} else {
					return key;
				}
			} 
		}
		return "";
	}
	
	/**
	 * Set the key for a properties extension and add the "x-" prefix if it was omitted
	 * 
	 * @param extension Properties extension
	 * @param key the key value
	 * @return the modified properties extension
	 */
	public PropertiesExtension setPropertiesExtensionKey(PropertiesExtension extension, String key) {
		if (extension != null) {
			String newKey = key;
			if (newKey != null && !newKey.trim().isEmpty() && !newKey.toLowerCase().startsWith(PropertiesExtensionsService.PROPERTIES_EXTENSION_PREFIX)) {
				newKey = PropertiesExtensionsService.PROPERTIES_EXTENSION_PREFIX + newKey.trim();
			}
			extension.setTitle(newKey);
		}
		return extension;
	}
	
	/**
	 * Return the main object for properties extension i.e. the object containing
	 * the MetaDataContainer containing the PropertiesExtension object
	 * 
	 * @param extension Properties extension object
	 * @return the container of the container of the properties extension
	 */
	public EObject getMainObjectForPropertiesExtension(PropertiesExtension extension) {
		if (extension != null) {
			EObject eContainer = extension.eContainer();
			if (eContainer instanceof MetaDataContainer) {
				return eContainer.eContainer();
			}
		}
		return null;
	}
}
