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
package org.obeonetwork.acceleo.utils.properties.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

/**
 * @author Obeo
 *
 */
public class AcceleoGenerationPropertiesHelper extends PropertiesLoader {

	private static final String ACCELEO_GENERATION_TARGET = "acceleo.generation.target";
	private static final String EXTENSION_DELIMITER = ".";
	private static final String PROPERTIES_FILE_EXTENSION = "properties";
	private IFile modelFile;

	/**
	 * @param modelFile
	 */
	public AcceleoGenerationPropertiesHelper(IFile modelFile) {
		this.modelFile = modelFile;
	}
	
	/**
	 * @return a list of properties filename around the model.
	 * @throws CoreException
	 */
	public List<String> associatedProperties() throws CoreException {
		List<String> result = new ArrayList<String>();
		IResource[] members = modelFile.getParent().members();
		for (int i = 0; i < members.length; i++) {
			IResource iResource = members[i];
			if (iResource instanceof IFile && ((IFile)iResource).getFileExtension().equals(PROPERTIES_FILE_EXTENSION)) {
				result.add(iResource.getLocation().toString());
			}
		}
		return result;
	}

	/**
	 * @param name the searched properties file.
	 * @return properties file with the given name.
	 * @throws CoreException
	 */
	public String associatedProperties(String name) throws CoreException {
		IResource[] members = modelFile.getParent().members();
		for (int i = 0; i < members.length; i++) {
			IResource iResource = members[i];
			if (iResource instanceof IFile 
					&& (((IFile)iResource).getName().equals(name) || ((IFile)iResource).getName().equals(name + EXTENSION_DELIMITER + PROPERTIES_FILE_EXTENSION))) {
				return iResource.getLocation().toString();
			}
		}
		return null;
	}

	/**
	 * Search in properties files arround the model the 'acceleo.generation.target' key value.
	 * @return the last generation target <code>null</code> otherwise.
	 * @throws CoreException 
	 */
	public IProject lastGenerationTarget() throws CoreException {
		String associatedProperties = associatedProperties("acceleo");
		if (associatedProperties != null) {
			Properties acceleoProperties = loadProperties(associatedProperties);
			String projectName = acceleoProperties.getProperty(ACCELEO_GENERATION_TARGET);
			if (projectName != null) {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				if (project.isAccessible()) {
					return project;
				}
			}
			
		}
		return null;
	}
	
	/**
	 * @param value
	 * @throws CoreException 
	 */
	public void saveLastGenerationTarget(String value) throws CoreException {
		String associatedProperties = associatedProperties("acceleo");
		if (associatedProperties != null) {
			Properties acceleoProperties = loadProperties(associatedProperties);
			acceleoProperties.put(ACCELEO_GENERATION_TARGET, value);
			saveProperties(acceleoProperties, associatedProperties);
		} else {
			// Creation of a new Acceleo properties file.
			Properties acceleoProperties = new Properties();
			acceleoProperties.put(ACCELEO_GENERATION_TARGET, value);
			saveProperties(acceleoProperties, modelFile.getParent().getFile(new Path("acceleo.properties")).getLocation().toString());
		}
	}
}
