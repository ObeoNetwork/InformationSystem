/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.obeonetwork.acceleo.utils.properties.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.osgi.framework.Bundle;

/**
 * @author @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class PropertiesLoader {
	
	protected Bundle bundle;
	
	/**
	 * 
	 */
	public PropertiesLoader() {
		super();
		this.bundle = null;
	}

	/**
	 * @param bundle
	 */
	public PropertiesLoader(Bundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * Load the properties of the given file.
	 * @param filename the file to load.
	 * @return the loaded {@link Properties}.
	 */
	public Properties loadProperties(String filename) {
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filename);
			properties.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			if (bundle != null) {
				URL res = bundle.getResource(filename);
				if (res != null) {
					try {
						properties.load(res.openStream());
					} catch (IOException e1) {
						return null;
					}
					return properties;
				}
			}
			return null;
		} catch (IOException e) {
			return null;
		}
		return properties;
	}

	/**
	 * Load the properties of the given file.
	 * @param filename the file to load.
	 * @return the loaded {@link Properties}.
	 */
	public void saveProperties(Properties properties, String filename) {
		try {
			FileOutputStream fis = new FileOutputStream(filename);
			properties.store(fis, "Saving properties file");
			fis.close();
		} catch (FileNotFoundException e) {
			//TODO Throw error
		} catch (IOException e) {
			//TODO Throw error
		}
	}

}
