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
package org.obeonetwork.dsl.graal.m2doc.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.graal.m2doc.services.DomainClassServices;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;

/**
 * Tests on DomainClassServices
 * 
 * @author Stephane Thibaudeau
 *
 */
public class DomainClassServicesTest extends AbstractTest {

	private static final DomainClassServices dcs = new DomainClassServices();

	@Override
	protected String getMainFolder() {
		return "DomainClass";
	}

	@Test
	public void testAnnotationWithNoMetadataContainer() {
		System system = loadRoot("AnnotationWithNoMetadataContainer.graal", System.class);

		DomainClass domainClass = query(() -> {
			return (DomainClass) system.getOwnedNamespaces().get(0).getTypes().get(0);
		});

		assertEquals("", getPhysicalSize(domainClass));
	}

	@Test
	public void testAnnotationWithEmptyMetadataContainer() {
		System system = loadRoot("AnnotationWithEmptyMetadataContainer.graal", System.class);

		DomainClass domainClass = query(() -> {
			return (DomainClass) system.getOwnedNamespaces().get(0).getTypes().get(0);
		});

		assertEquals("", getPhysicalSize(domainClass));
	}

	@Test
	public void testAnnotationNotPresent() {
		System system = loadRoot("AnnotationNotPresent.graal", System.class);

		DomainClass domainClass = query(() -> {
			return (DomainClass) system.getOwnedNamespaces().get(0).getTypes().get(0);
		});

		assertEquals("", getPhysicalSize(domainClass));
	}

	@Test
	public void testAnnotationPresent() {
		System system = loadRoot("AnnotationPresent.graal", System.class);

		DomainClass domainClass = query(() -> {
			return (DomainClass) system.getOwnedNamespaces().get(0).getTypes().get(0);
		});

		assertEquals("physical size", getPhysicalSize(domainClass));
	}

	@Test
	public void testAnnotationPresentMultipleTimes() {
		System system = loadRoot("AnnotationPresentMultipleTimes.graal", System.class);

		DomainClass domainClass = query(() -> {
			return (DomainClass) system.getOwnedNamespaces().get(0).getTypes().get(0);
		});

		assertEquals("physical size 1", getPhysicalSize(domainClass));
	}

	private String getPhysicalSize(ObeoDSMObject object) {
		return getService().annotation(object, "PHYSICAL_SIZE");
	}

	private DomainClassServices getService() {
		return new DomainClassServices();
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedElementsNull() {
		dcs.getOwnedElements(null);
	}

	@Test
	public void getOwnedElementsEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<ObeoDSMObject> elements = dcs.getOwnedElements(namespace);

		assertTrue(elements.isEmpty());
	}

	@Test
	public void getOwnedElements() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");

		final Reference ref1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref1.setName("ref1");
		final Reference ref2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref2.setName("ref2");
		final Reference ref3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref3.setName("ref3");

		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		domainClass1.getOwnedReferences().add(ref3);
		final DomainClass domainClass2 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass2.setName("domainClass2");

		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		dto1.getOwnedReferences().add(ref2);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");

		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		entity1.getOwnedReferences().add(ref1);
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity2.setName("entity2");

		final Enumeration enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum1.setName("enum1");
		final Enumeration enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum2.setName("enum2");

		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace.getTypes().add(enum1);
		namespace.getTypes().add(dto1);
		namespace.getTypes().add(domainClass1);
		namespace.getTypes().add(entity1);
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(dto2);
		namespace.getTypes().add(domainClass2);
		namespace.getTypes().add(entity2);

		final List<ObeoDSMObject> elements = dcs.getOwnedElements(namespace);

		assertEquals(13, elements.size());
		assertEquals(dto1, elements.get(0));
		assertEquals(dto2, elements.get(1));
		assertEquals(entity1, elements.get(2));
		assertEquals(entity2, elements.get(3));
		assertEquals(domainClass1, elements.get(4));
		assertEquals(domainClass2, elements.get(5));
		assertEquals(ref1, elements.get(6));
		assertEquals(ref2, elements.get(7));
		assertEquals(ref3, elements.get(8));
		assertEquals(enum1, elements.get(9));
		assertEquals(enum2, elements.get(10));
		assertEquals(namespace1, elements.get(11));
		assertEquals(namespace2, elements.get(12));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedElementsNull() {
		dcs.hasOwnedElements(null);
	}

	@Test
	public void hasOwnedElementsEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(dcs.hasOwnedElements(namespace));
	}

	@Test
	public void hasOwnedElements() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");

		final Reference ref1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref1.setName("ref1");
		final Reference ref2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref2.setName("ref2");
		final Reference ref3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref3.setName("ref3");

		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		domainClass1.getOwnedReferences().add(ref3);
		final DomainClass domainClass2 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass2.setName("domainClass2");

		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		dto1.getOwnedReferences().add(ref2);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");

		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		entity1.getOwnedReferences().add(ref1);
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity2.setName("entity2");

		final Enumeration enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum1.setName("enum1");
		final Enumeration enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum2.setName("enum2");

		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace.getTypes().add(enum1);
		namespace.getTypes().add(dto1);
		namespace.getTypes().add(domainClass1);
		namespace.getTypes().add(entity1);
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(dto2);
		namespace.getTypes().add(domainClass2);
		namespace.getTypes().add(entity2);

		assertTrue(dcs.hasOwnedElements(namespace));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedDomainClassesNull() {
		dcs.getOwnedDomainClasses(null);
	}

	@Test
	public void getOwnedDomainClassesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<DomainClass> domainClasses = dcs.getOwnedDomainClasses(namespace);

		assertTrue(domainClasses.isEmpty());
	}

	@Test
	public void getOwnedDomainClassesNoDomainClassesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		final List<DomainClass> domainClasses = dcs.getOwnedDomainClasses(namespace);

		assertTrue(domainClasses.isEmpty());
	}

	@Test
	public void getOwnedDomainClassesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		final DomainClass domainClass2 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass2.setName("domainClass2");
		final DomainClass domainClass3 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass3.setName("domainClass3");
		namespace.getTypes().add(domainClass2);
		namespace.getTypes().add(domainClass3);
		namespace.getTypes().add(domainClass1);

		final List<DomainClass> domainClasses = dcs.getOwnedDomainClasses(namespace);

		assertEquals(3, domainClasses.size());
		assertEquals(domainClass1, domainClasses.get(0));
		assertEquals(domainClass2, domainClasses.get(1));
		assertEquals(domainClass3, domainClasses.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedDomainClassesNull() {
		dcs.hasOwnedDomainClasses(null);
	}

	@Test
	public void hasOwnedDomainClassesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(dcs.hasOwnedDomainClasses(namespace));
	}

	@Test
	public void hasOwnedDomainClassesNoDomainClassNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		assertFalse(dcs.hasOwnedDomainClasses(namespace));
	}

	@Test
	public void hasOwnedDomainClassesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		final DomainClass domainClass2 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass2.setName("domainClass2");
		final DomainClass domainClass3 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass3.setName("domainClass3");
		namespace.getTypes().add(domainClass2);
		namespace.getTypes().add(domainClass3);
		namespace.getTypes().add(domainClass1);

		assertTrue(dcs.hasOwnedDomainClasses(namespace));
	}

	@Test(expected = NullPointerException.class)
	public void getTypeNameNull() {
		dcs.getTypeName(null);
	}

	@Test
	public void getTypeName() {
		final Enumeration enumeration = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();

		assertEquals("Enumeration", dcs.getTypeName(enumeration));
	}

	@Test
	public void asOuiNonTrue() {
		assertEquals("Oui", dcs.asOuiNon(true));
	}

	@Test
	public void asOuiNonFalse() {
		assertEquals("Non", dcs.asOuiNon(false));
	}

}
