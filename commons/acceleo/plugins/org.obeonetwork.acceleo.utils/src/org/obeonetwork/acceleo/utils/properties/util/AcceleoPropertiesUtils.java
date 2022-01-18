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
package org.obeonetwork.acceleo.utils.properties.util;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;

public class AcceleoPropertiesUtils {
	
	public static final String PROPERTIES_FILE_EXTENSION = "properties";
	public static final String PLATFORM_RESOURCE = "platform:/resource/";
	public static final String PLATFORM_PLUGIN = "platform:/plugin/";
	
	public static Set<String> getPropertiesFilesNearModel(Resource eResource) {
		Set<String> propertiesFilesNearModel = new LinkedHashSet<String>();

		String file = eResource.getURI().toFileString();
		if (file == null) {
			file = eResource.getURI().toString();
		}
		if (file.startsWith(PLATFORM_RESOURCE)) {
			IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(file.substring(PLATFORM_RESOURCE.length())));
			file = iFile.getLocation().toFile().getAbsolutePath();
		}
		
		File modelDirectory = new File(file).getParentFile();

		for (File propertiesFile : modelDirectory.listFiles())
		{
			if (propertiesFile.isFile() && propertiesFile.getName().endsWith("." + PROPERTIES_FILE_EXTENSION))
			{
				String propertiesFilePath = propertiesFile.getAbsolutePath();
				propertiesFilesNearModel.add(propertiesFilePath);
			}
		}
		
		return propertiesFilesNearModel;
	}
}
