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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.graal.m2doc.services.UseCaseServices;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.UseCase;

/**
 * Tests on UseCaseServices
 * 
 * @author Stephane Thibaudeau
 *
 */
public class UseCaseServicesTest extends AbstractTest {

	@Override
	protected String getMainFolder() {
		return "UseCase";
	}
	
	@Test
	public void testNoDomainClasses() {
		System system = loadRoot("NoDomainClasses.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{});
	}
	
	@Test
	public void testDirectlyReferencedDomainClasses() {
		System system = loadRoot("DirectlyReferencedDomainClasses.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.DomainClass3",
														"ns1.ns3.DomainClass6",
														"ns2.DomainClass2"});
	}
	
	@Test
	public void testReferencedByNamespacesDomainClasses() {
		System system = loadRoot("ReferencedByNamespacesDomainClasses.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.ns3.DomainClass6",
														"ns1.ns3.DomainClass7",
														"ns2.DomainClass1",
														"ns2.DomainClass2",
														"ns2.DomainClass4"});
	}
	
	@Test
	public void testNamespacesAndSubnamespaces() {
		System system = loadRoot("NamespacesAndSubnamespaces.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.DomainClass3",
														"ns1.DomainClass5",
														"ns1.ns3.DomainClass6",
														"ns1.ns3.DomainClass7"});
	}
	
	@Test
	public void testReferencedByTypesDomainClasses() {
		System system = loadRoot("ReferencedByTypesDomainClasses.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.DomainClass3",
														"ns2.DomainClass2"});
	}
	
	@Test
	public void testNoDuplicates() {
		System system = loadRoot("NoDuplicates.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.DomainClass3",
														"ns1.ns3.DomainClass6",
														"ns2.DomainClass1",
														"ns2.DomainClass2",
														"ns2.DomainClass4"});
	}
	
	@Test
	public void testOtherStructuredTypes() {
		// StructuredTypes of another type than DomainClass  should not be returned
		
		System system = loadRoot("OtherStructuredTypes.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		assertTrue(useCase.getTypes().get(1) instanceof Entity);
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.ns3.DomainClass7",
														"ns2.DomainClass1"});
	}
	
	@Test
	public void testAllKindsOfReferences() {
		System system = loadRoot("AllKindsOfReferences.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.DomainClass3",
														"ns1.ns3.DomainClass6",
														"ns1.ns3.DomainClass7",
														"ns2.DomainClass1",
														"ns2.DomainClass2"});
	}
	
	@Test
	public void testSortIgnoringAccents() {
		System system = loadRoot("SortIgnoringAccents.graal", System.class);
		
		UseCase useCase = query(() -> {
			return (UseCase)system.getUseCases().get(0);
		});
		
		verifyAllDomainClasses(useCase, new String[]{	"ns1.BaShouldBe1",
														"ns1.bbShouldBe2",
														"ns1.éaShouldBe3",
														"ns1.EBShouldBe4"});
	}
	
	private void verifyAllDomainClasses(UseCase uc, String[] expectedClassesNames) {
		UseCaseServices service = new UseCaseServices();
		List<DomainClass> allDomainClasses = service.allDomainClasses(uc);
		Stream<String> domainClassesNames = allDomainClasses.stream().map((domainClass) -> service.fullQualifiedName(domainClass));
		assertArrayEquals("", expectedClassesNames, domainClassesNames.toArray());
	}
}
