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
package org.obeonetwork.dsl.environment.m2doc.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.m2doc.services.EnvironmentServices;

public class EnvironmentServiceTest {

	EnvironmentServices es = new EnvironmentServices();

	@Test(expected = NullPointerException.class)
	public void getAllNamespacesNull() {
		es.getAllNamespaces(null);
	}

	@Test
	public void getAllNamespacesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<Namespace> namespaces = es.getAllNamespaces(namespace);

		assertTrue(namespaces.isEmpty());
	}

	@Test
	public void getAllNamespacesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);

		final List<Namespace> namespaces = es.getAllNamespaces(namespace);

		assertEquals(3, namespaces.size());
		assertEquals(namespace2, namespaces.get(0));
		assertEquals(namespace3, namespaces.get(1));
		assertEquals(namespace1, namespaces.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasAllNamespacesNull() {
		es.hasAllNamespaces(null);
	}

	@Test
	public void hasAllNamespacesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");

		assertFalse(es.hasAllNamespaces(namespace));
	}

	@Test
	public void hasAllNamespacesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);

		assertTrue(es.hasAllNamespaces(namespace));
	}

	@Test
	public void qualifiedNameNamespaceNull() {
		assertEquals("", es.qualifiedName((Namespace) null));
	}

	@Test
	public void qualifiedNameNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);

		assertEquals("namespace", es.qualifiedName(namespace));
		assertEquals("namespace.namespace1", es.qualifiedName(namespace1));
		assertEquals("namespace.namespace2", es.qualifiedName(namespace2));
		assertEquals("namespace.namespace2.namespace3", es.qualifiedName(namespace3));
	}

	@Test(expected = NullPointerException.class)
	public void qualifiedNameStructuredTypeNull() {
		assertEquals("", es.qualifiedName((StructuredType) null));
	}

	@Test
	public void qualifiedNameDTO() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		namespace.getTypes().add(dto);
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		namespace1.getTypes().add(dto1);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");
		namespace2.getTypes().add(dto2);
		final DTO dto3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto3.setName("dto3");
		namespace3.getTypes().add(dto3);

		assertEquals("namespace.dto", es.qualifiedName(dto));
		assertEquals("namespace.namespace1.dto1", es.qualifiedName(dto1));
		assertEquals("namespace.namespace2.dto2", es.qualifiedName(dto2));
		assertEquals("namespace.namespace2.namespace3.dto3", es.qualifiedName(dto3));
	}

	@Test(expected = NullPointerException.class)
	public void getAllAttributesNull() {
		es.getAllAttributes(null);
	}

	@Test
	public void getAllAttributesEmptyDTO() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();

		final List<Attribute> attributes = es.getAllAttributes(dto);

		assertTrue(attributes.isEmpty());
	}

	@Test
	public void getAllAttributesDTO() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute.setName("attribute");
		dto.getOwnedAttributes().add(attribute);
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute1.setName("attribute1");
		dto1.getOwnedAttributes().add(attribute1);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute2.setName("attribute2");
		dto2.getOwnedAttributes().add(attribute2);
		final DTO dto3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute3.setName("attribute3");
		dto3.getOwnedAttributes().add(attribute3);

		dto.setSupertype(dto1);
		dto.getAssociatedTypes().add(dto2);
		dto2.getAssociatedTypes().add(dto3);

		final List<Attribute> attributes = es.getAllAttributes(dto);

		assertEquals(4, attributes.size());
		assertEquals(attribute, attributes.get(0));
		assertEquals(attribute1, attributes.get(1));
		assertEquals(attribute2, attributes.get(2));
		assertEquals(attribute3, attributes.get(3));
	}

	@Test(expected = NullPointerException.class)
	public void hasAllAttributesNull() {
		es.hasAllAttributes(null);
	}

	@Test
	public void hasAllAttributesEmptyDTO() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();

		assertFalse(es.hasAllAttributes(dto));
	}

	@Test
	public void hasAllAttributesDTO() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute.setName("attribute");
		dto.getOwnedAttributes().add(attribute);
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute1.setName("attribute1");
		dto1.getOwnedAttributes().add(attribute1);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute2.setName("attribute2");
		dto2.getOwnedAttributes().add(attribute2);
		final DTO dto3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		final Attribute attribute3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute3.setName("attribute3");
		dto3.getOwnedAttributes().add(attribute3);

		dto.setSupertype(dto1);
		dto.getAssociatedTypes().add(dto2);
		dto2.getAssociatedTypes().add(dto3);

		assertTrue(es.hasAllAttributes(dto));
	}

	@Test(expected = NullPointerException.class)
	public void typeNameNull() {
		es.typeName(null);
	}

	@Test
	public void typeName() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		final DataType type = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		type.setName("Type");
		namespace.getTypes().add(type);
		attribute.setType(type);
		attribute.setMultiplicity(MultiplicityKind.ZERO_STAR_LITERAL);

		assertEquals("Type[0..*]", es.typeName(attribute));
	}

	@Test(expected = NullPointerException.class)
	public void getOriginTypeIfDifferentNullNull() {
		es.getOriginTypeIfDifferent(null, null);
	}

	@Test
	public void getOriginTypeIfDifferentAttributeNull() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		dto.getOwnedAttributes().add(attribute);

		assertEquals("From DTO dto", es.getOriginTypeIfDifferent(attribute, null));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeParent() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		dto.getOwnedAttributes().add(attribute);

		assertEquals("", es.getOriginTypeIfDifferent(attribute, dto));
	}

	@Test
	public void getOriginTypeIfDifferentAttribute() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		dto.getOwnedAttributes().add(attribute);

		assertEquals("From DTO dto", es.getOriginTypeIfDifferent(attribute, dto1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespace() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		dto.getOwnedAttributes().add(attribute);
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		namespace3.getTypes().add(dto);

		assertEquals("From DTO namespace.namespace2.namespace3.dto", es.getOriginTypeIfDifferent(attribute, dto1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespaceSuperType() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		dto1.setSupertype(dto);
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		dto.getOwnedAttributes().add(attribute);
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		namespace3.getTypes().add(dto);

		assertEquals("From supertype namespace.namespace2.namespace3.dto",
				es.getOriginTypeIfDifferent(attribute, dto1));
	}


	@Test
	public void getOriginTypeIfDifferentReferenceNull() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		dto.getOwnedReferences().add(reference);

		assertEquals("From DTO dto", es.getOriginTypeIfDifferent(reference, null));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceParent() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		dto.getOwnedReferences().add(reference);

		assertEquals("", es.getOriginTypeIfDifferent(reference, dto));
	}

	@Test
	public void getOriginTypeIfDifferentReference() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		dto.getOwnedReferences().add(reference);

		assertEquals("From DTO dto", es.getOriginTypeIfDifferent(reference, dto1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespace() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		dto.getOwnedReferences().add(reference);
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		namespace3.getTypes().add(dto);

		assertEquals("From DTO namespace.namespace2.namespace3.dto", es.getOriginTypeIfDifferent(reference, dto1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespaceSuperType() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		dto1.setSupertype(dto);
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		dto.getOwnedReferences().add(reference);
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		namespace3.getTypes().add(dto);

		assertEquals("From supertype namespace.namespace2.namespace3.dto",
				es.getOriginTypeIfDifferent(reference, dto1));
	}

	@Test(expected = NullPointerException.class)
	public void getReferencedTypeNameNull() {
		es.getReferencedTypeName(null);
	}

	@Test
	public void getReferencedTypeName() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");
		namespace.getTypes().add(dto);
		final Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		reference.setReferencedType(dto);

		assertEquals("namespace.dto", es.getReferencedTypeName(reference));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedEnumerationsNull() {
		es.getOwnedEnumerations(null);
	}

	@Test
	public void getOwnedEnumerationsEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<Enumeration> enumerations = es.getOwnedEnumerations(namespace);

		assertTrue(enumerations.isEmpty());
	}

	@Test
	public void getOwnedEnumerationsNoEnumerationsNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		final List<Enumeration> enumerations = es.getOwnedEnumerations(namespace);

		assertTrue(enumerations.isEmpty());
	}

	@Test
	public void getOwnedEnumerationsNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Enumeration enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum1.setName("enum1");
		final Enumeration enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum2.setName("enum2");
		final Enumeration enum3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum3.setName("enum3");
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(enum3);
		namespace.getTypes().add(enum1);

		final List<Enumeration> enumerations = es.getOwnedEnumerations(namespace);

		assertEquals(3, enumerations.size());
		assertEquals(enum1, enumerations.get(0));
		assertEquals(enum2, enumerations.get(1));
		assertEquals(enum3, enumerations.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedEnumerationsNull() {
		es.hasOwnedEnumerations(null);
	}

	@Test
	public void hasOwnedEnumerationsEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(es.hasOwnedEnumerations(namespace));
	}

	@Test
	public void hasOwnedEnumerationsNoEnumerationNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		assertFalse(es.hasOwnedEnumerations(namespace));
	}

	@Test
	public void hasOwnedEnumerationsNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Enumeration enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum1.setName("enum1");
		final Enumeration enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum2.setName("enum2");
		final Enumeration enum3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		enum3.setName("enum3");
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(enum3);
		namespace.getTypes().add(enum1);

		assertTrue(es.hasOwnedEnumerations(namespace));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedDTONull() {
		es.getOwnedDTO(null);
	}

	@Test
	public void getOwnedDTOEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<DTO> enumerations = es.getOwnedDTO(namespace);

		assertTrue(enumerations.isEmpty());
	}

	@Test
	public void getOwnedDTONoDTONamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Enumeration enumeration = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		namespace.getTypes().add(enumeration);

		final List<DTO> enumerations = es.getOwnedDTO(namespace);

		assertTrue(enumerations.isEmpty());
	}

	@Test
	public void getOwnedDTONamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum1.setName("enum1");
		final DTO enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum2.setName("enum2");
		final DTO enum3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum3.setName("enum3");
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(enum3);
		namespace.getTypes().add(enum1);

		final List<DTO> enumerations = es.getOwnedDTO(namespace);

		assertEquals(3, enumerations.size());
		assertEquals(enum1, enumerations.get(0));
		assertEquals(enum2, enumerations.get(1));
		assertEquals(enum3, enumerations.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedDTONull() {
		es.hasOwnedDTO(null);
	}

	@Test
	public void hasOwnedDTOEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(es.hasOwnedDTO(namespace));
	}

	@Test
	public void hasOwnedDTONoDTONamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Enumeration enumeration = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createEnumeration();
		namespace.getTypes().add(enumeration);

		assertFalse(es.hasOwnedDTO(namespace));
	}

	@Test
	public void hasOwnedDTONamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO enum1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum1.setName("enum1");
		final DTO enum2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum2.setName("enum2");
		final DTO enum3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		enum3.setName("enum3");
		namespace.getTypes().add(enum2);
		namespace.getTypes().add(enum3);
		namespace.getTypes().add(enum1);

		assertTrue(es.hasOwnedDTO(namespace));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedReferencesNull() {
		es.getOwnedReferences(null);
	}

	@Test
	public void getOwnedReferencesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<Reference> references = es.getOwnedReferences(namespace);

		assertTrue(references.isEmpty());
	}

	@Test
	public void getOwnedReferencesNoReferencesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		final List<Reference> references = es.getOwnedReferences(namespace);

		assertTrue(references.isEmpty());
	}

	@Test
	public void getOwnedReferencesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		final Reference ref1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref1.setName("ref1");
		dto1.getOwnedReferences().add(ref1);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");
		final Reference ref2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref2.setName("ref2");
		dto2.getOwnedReferences().add(ref2);
		final DTO dto3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto3.setName("dto3");
		final Reference ref3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref3.setName("ref3");
		dto3.getOwnedReferences().add(ref3);
		namespace.getTypes().add(dto2);
		namespace.getTypes().add(dto3);
		namespace.getTypes().add(dto1);

		final List<Reference> references = es.getOwnedReferences(namespace);

		assertEquals(3, references.size());
		assertEquals(ref1, references.get(0));
		assertEquals(ref2, references.get(1));
		assertEquals(ref3, references.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedReferencesNull() {
		es.hasOwnedReferences(null);
	}

	@Test
	public void hasOwnedReferencesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(es.hasOwnedReferences(namespace));
	}

	@Test
	public void hasOwnedReferencesNoEntitiesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		assertFalse(es.hasOwnedReferences(namespace));
	}

	@Test
	public void hasOwnedReferencesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		final Reference ref1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref1.setName("ref1");
		dto1.getOwnedReferences().add(ref1);
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");
		final Reference ref2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref2.setName("ref2");
		dto2.getOwnedReferences().add(ref2);
		final DTO dto3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto3.setName("dto3");
		final Reference ref3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		ref3.setName("ref3");
		dto3.getOwnedReferences().add(ref3);
		namespace.getTypes().add(dto2);
		namespace.getTypes().add(dto3);
		namespace.getTypes().add(dto1);

		assertTrue(es.hasOwnedReferences(namespace));
	}

	@Test(expected = NullPointerException.class)
	public void getNameNull() {
		es.getName((StructuredType)null);
	}

	@Test
	public void getNameNoSuperType() {
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto.setName("dto");

		assertEquals("dto", es.getName(dto));
	}

	@Test
	public void getName() {
		final DTO dto1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto1.setName("dto1");
		final DTO dto2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		dto2.setName("dto2");
		dto1.setSupertype(dto2);

		assertEquals("dto1 \u2192 dto2", es.getName(dto1));
	}

}
