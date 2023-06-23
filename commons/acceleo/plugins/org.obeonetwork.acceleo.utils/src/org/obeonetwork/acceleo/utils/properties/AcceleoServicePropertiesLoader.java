/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.acceleo.utils.properties;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.acceleo.engine.service.AcceleoService;
import org.obeonetwork.acceleo.utils.properties.util.PropertiesLoader;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AcceleoServicePropertiesLoader extends PropertiesLoader {

	private AcceleoService service;
	
	private AcceleoServicePropertiesLoader[] parentLoaders;

	/**
	 * @param service service to manage.
	 */
	public AcceleoServicePropertiesLoader(AcceleoService service, Bundle bundle) {
		super(bundle);
		this.service = service;
		this.parentLoaders = null;
	}
	
	/**
	 * @param service service to manage.
	 * @param super helpers. 
	 */
	public AcceleoServicePropertiesLoader(AcceleoService service, Bundle bundle, AcceleoServicePropertiesLoader... parentLoaders) {
		super(bundle);
		this.service = service;
		this.parentLoaders = parentLoaders;
	}

	
	/**
	 * Load properties to the given Acceleo Service
	 */
	public void loadService() {
		if (parentLoaders != null) {
			for (AcceleoServicePropertiesLoader helper : parentLoaders) {
				helper.loadService();
			}
		}
		for (String propertiesFilename : getPropertiesFilenames()) {
			addPropertiesToService(loadProperties(propertiesFilename));
		}
	}

	/**
	 * @return the propertiesFilenames
	 */
	public abstract List<String> getPropertiesFilenames();

	private void addPropertiesToService(Properties properties) {
		Map<String, String> propertiesToAdd = new HashMap<String, String>();
		Enumeration<?> propertiesNames = properties.propertyNames();
		while(propertiesNames.hasMoreElements()) {
			String propertyName = (String)propertiesNames.nextElement();
			String propertyValue = properties.getProperty(propertyName);
			propertiesToAdd.put(propertyName, propertyValue);
		}
		if (propertiesToAdd.isEmpty() == false) {
			service.addProperties(propertiesToAdd);
		}
	}
	
	/**
	 * @param string
	 */
	public void overrideProperties(String propertiesFilename) {
		addPropertiesToService(loadProperties(propertiesFilename));
	}

	
}
