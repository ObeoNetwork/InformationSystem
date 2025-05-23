/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.tests;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.obeonetwork.utils.common.StreamUtils.asStream;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;

public class ObeoDSMTestHelper {

	/**
	 * Asserts the two given {@link EObject} serializations are equal, not taking
	 * into account the differences in XMI ids, and the values of a few features
	 * like technicalid, modifiedOn, createdOn as specified in
	 * {@link ObeoDSMXMIResourceTestImpl}
	 * 
	 * @param message
	 * @param expectedEObject
	 * @param actualEObject
	 */
	public static void assertObeoDSMEquals(String message, EObject expectedEObject, EObject actualEObject) {
		
		String actual = null;
		String expected = null;
        try {
        	XMIResource actualResource = new ObeoDSMXMIResourceTestImpl();
            actualResource.getContents().add(sortAllELists(EcoreUtil.copy(actualEObject)));
            StringWriter actualWriter = new StringWriter();
            actualResource.save(actualWriter, Collections.emptyMap());
            actual = actualWriter.toString();
            
            XMIResource expectedResource = new ObeoDSMXMIResourceTestImpl();
    		expectedResource.getContents().add(sortAllELists(EcoreUtil.copy(expectedEObject)));
            StringWriter expectedWriter = new StringWriter();
			expectedResource.save(expectedWriter, Collections.emptyMap());
			expected = expectedWriter.toString();
		} catch (IOException e) {
			// Fail case
		}
        
        if(actual == null || expected == null) {
			fail(String.format("Unable to serialize %s.", expectedEObject.eClass().getName()));
        }

		assertEquals(message, expected, actual);
	}
	
	public static void assertObeoDSMEquals(String message, String expectedXMIObject, String actualXMIObject) {
		
		EObject expectedEObject = loadFromXMI(expectedXMIObject, "expected");
		EObject actualEObject = loadFromXMI(actualXMIObject, "actual");
		
		assertObeoDSMEquals(message, expectedEObject, actualEObject);
	}
	
	private static EObject loadFromXMI(String xmiObject, String resourceName) {
		
		URI uri = URI.createURI(resourceName);
		
		Map<Object,Object> options = new HashMap<Object,Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		
		try {
			resource.load(new URIConverter.ReadableInputStream(xmiObject), options);
		} catch (IOException e) {
			fail("Exception while reading: " + e.getMessage());
			e.printStackTrace();
		}
		
		return resource.getContents().get(0);
	}
	
	private static EObject sortAllELists(EObject eObject) {
		
		List<EList<?>> eListValues = asStream(eObject.eAllContents())
		.flatMap(e -> e.eClass().getEAllStructuralFeatures().stream()
				.filter(feature -> feature.isMany())
				.filter(feature -> feature.isChangeable())
				.filter(feature -> !feature.isDerived())
				.map(f -> e.eGet(f)))
		.filter(EList.class::isInstance).map(EList.class::cast)
		.collect(toList());
		
		eListValues.forEach(eList -> ECollections.sort(eList, (a, b) -> getSortKey(a).compareTo(getSortKey(b))));
		
		return eObject;
	}
	
	private static String getSortKey(Object object) {
		String sortKey = null;
		if(object instanceof EObject) {
			EObject eObject = (EObject) object;
        	EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
        	if(nameFeature != null && eObject.eGet(nameFeature) != null) {
        		sortKey = eObject.eGet(nameFeature).toString();
        	} else {
            	sortKey = Integer.toString(eObject.toString().length());
        	}
		} else {
        	sortKey = object.toString();
		}
    	return sortKey;
	}
	
}
