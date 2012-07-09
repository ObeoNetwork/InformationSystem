/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.acceleo.utils.properties.util;

import java.util.Properties;

import org.eclipse.acceleo.engine.service.AcceleoService;
import org.eclipse.acceleo.engine.service.properties.AbstractAcceleoPropertiesLoaderService;

public class ObeoNetworkPropertiesLoaderService extends AbstractAcceleoPropertiesLoaderService {
	
	public ObeoNetworkPropertiesLoaderService(AcceleoService acceleoService) {
		this.acceleoService = acceleoService;
	}
	
	@Override
	protected Properties alternatePropertiesLoading(String filepath) {
		/*
		 * We are out of Eclipse so let's try to load the file from its path
		 * as if it was the absolute path of a file on the file system.
		 **/
		return this.loadProperties(filepath);
	}
}
