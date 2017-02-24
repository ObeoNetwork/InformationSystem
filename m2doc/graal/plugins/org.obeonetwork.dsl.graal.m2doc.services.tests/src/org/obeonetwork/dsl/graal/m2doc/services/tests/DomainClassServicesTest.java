/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.graal.m2doc.services.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.graal.m2doc.services.DomainClassServices;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.System; 

/**
 * Tests on DomainClassServices
 * 
 * @author Stephane Thibaudeau
 *
 */
public class DomainClassServicesTest extends AbstractTest {

	@Override
	protected String getMainFolder() {
		return "DomainClass";
	}
	
	@Test
	public void testAnnotationWithNoMetadataContainer() {
		System system = loadRoot("AnnotationWithNoMetadataContainer.graal", System.class);
		
		DomainClass domainClass = query(() -> {
			return (DomainClass)system.getOwnedNamespaces().get(0).getTypes().get(0);
		});
		
		assertEquals("", getPhysicalSize(domainClass));
	}
	
	@Test
	public void testAnnotationWithEmptyMetadataContainer() {
		System system = loadRoot("AnnotationWithEmptyMetadataContainer.graal", System.class);
		
		DomainClass domainClass = query(() -> {
			return (DomainClass)system.getOwnedNamespaces().get(0).getTypes().get(0);
		});
		
		assertEquals("", getPhysicalSize(domainClass));
	}
	
	@Test
	public void testAnnotationNotPresent() {
		System system = loadRoot("AnnotationNotPresent.graal", System.class);
		
		DomainClass domainClass = query(() -> {
			return (DomainClass)system.getOwnedNamespaces().get(0).getTypes().get(0);
		});
		
		assertEquals("", getPhysicalSize(domainClass));
	}
	
	@Test
	public void testAnnotationPresent() {
		System system = loadRoot("AnnotationPresent.graal", System.class);
		
		DomainClass domainClass = query(() -> {
			return (DomainClass)system.getOwnedNamespaces().get(0).getTypes().get(0);
		});
		
		assertEquals("physical size", getPhysicalSize(domainClass));
	}
	
	@Test
	public void testAnnotationPresentMultipleTimes() {
		System system = loadRoot("AnnotationPresentMultipleTimes.graal", System.class);
		
		DomainClass domainClass = query(() -> {
			return (DomainClass)system.getOwnedNamespaces().get(0).getTypes().get(0);
		});
		
		assertEquals("physical size 1", getPhysicalSize(domainClass));
	}
	
	private String getPhysicalSize(ObeoDSMObject object) {
		return getService().annotation(object, "PHYSICAL_SIZE");
	}
	
	private DomainClassServices getService() {
		return new DomainClassServices();
	}
}
