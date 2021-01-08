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
package org.obeonetwork.dsl.graal.m2doc.services.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.util.EntityResourceFactoryImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.util.EnvironmentResourceFactoryImpl;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.util.SoaResourceFactoryImpl;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.util.GraalResourceFactoryImpl;

/**
 * Abstract class providing test utilities
 * 
 * @author Stephane Thibaudeau
 *
 */
abstract public class AbstractTest {

	private static final String RESOURCES_FOLDER = "resources";
	
	/**
	 * Return the name of the folder containing test models
	 * @return
	 */
	abstract protected String getMainFolder();
	
	/**
	 * Execute a query and fail if an exception occurs
	 * @param query
	 * @return
	 */
	protected <T> T query(Supplier<T> query) {
		T result = null;
		
		try {
			result = query.get();
		} catch (Exception e) {
			fail("Query failed with exception : " + e.getMessage());
			return null;
		}
		
		return result;
	}
	
	/**
	 * Load a model contained in the resources folder and return its first root EObject
	 * @param resourcePath Relative path to model
	 * @param type Type of the first roo object
	 * @return
	 */
	protected <T> T loadRoot(String resourcePath, Class<T> type) {
		return loadRoot(resourcePath, 0, type);
	}
	
	/**
	 * Load a model contained in the resources folder and return the root EObject at the specified index
	 * @param resourcePath Relative path to model
	 * @param index Index of the root EObject
	 * @param type Type of the first roo object
	 * @return
	 */
	protected <T> T loadRoot(String resourcePath, int index, Class<T> type) {
		File modelFile = new File(RESOURCES_FOLDER);
		
		if (getMainFolder() != null && !"".equals(getMainFolder().trim())) {
			modelFile = new File(modelFile, getMainFolder());
		}
		modelFile = new File(modelFile, resourcePath);
		
		assertTrue("Model file does not exist (" + modelFile.getAbsolutePath() + ")", modelFile.exists());
		
		ResourceSet set = new ResourceSetImpl();
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("graal", new GraalResourceFactoryImpl());
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("entity", new EntityResourceFactoryImpl());
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("soa", new SoaResourceFactoryImpl());
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("environment", new EnvironmentResourceFactoryImpl());
		
		GraalPackage.eINSTANCE.eClass();
		EntityPackage.eINSTANCE.eClass();
		SoaPackage.eINSTANCE.eClass();
		EnvironmentPackage.eINSTANCE.eClass();
		
		Resource resource = set.getResource(URI.createFileURI(modelFile.getAbsolutePath()), true);
		if (resource.getContents().size() > index) {
			EObject root = resource.getContents().get(index);
			assertTrue("Root object is not of the correct type", type.isInstance(root));
			return type.cast(root);
		}
		
		return null;
	}
}
