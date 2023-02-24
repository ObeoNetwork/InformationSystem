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
package org.obeonetwork.dsl.entity.m2doc.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.m2doc.services.EnvironmentServices;

public class EnvironmentServiceTest {

	EnvironmentServices es = new EnvironmentServices();

	@Test
	public void qualifiedNameEntity() {
		final Root root = EntityPackage.eINSTANCE.getEntityFactory().createRoot();
		root.setName("root");
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		root.getOwnedNamespaces().add(namespace);
		final Namespace namespace1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace1.setName("namespace1");
		final Namespace namespace2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace2.setName("namespace2");
		final Namespace namespace3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace3.setName("namespace3");
		namespace.getOwnedNamespaces().add(namespace2);
		namespace.getOwnedNamespaces().add(namespace1);
		namespace2.getOwnedNamespaces().add(namespace3);
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		namespace.getTypes().add(entity);
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		namespace1.getTypes().add(entity1);
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity2.setName("entity2");
		namespace2.getTypes().add(entity2);
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity3.setName("entity3");
		namespace3.getTypes().add(entity3);

		assertEquals("namespace.entity", es.qualifiedName(entity));
		assertEquals("namespace.namespace1.entity1", es.qualifiedName(entity1));
		assertEquals("namespace.namespace2.entity2", es.qualifiedName(entity2));
		assertEquals("namespace.namespace2.namespace3.entity3", es.qualifiedName(entity3));
	}

	@Test
	public void getAllAttributesEmptyEntity() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();

		final List<Attribute> attributes = es.getAllAttributes(entity);

		assertTrue(attributes.isEmpty());
	}

	@Test
	public void getAllAttributesEntity() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute.setName("entiry");
		entity.getOwnedAttributes().add(attribute);
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute1.setName("entity1");
		entity1.getOwnedAttributes().add(attribute1);
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute2.setName("entity2");
		entity2.getOwnedAttributes().add(attribute2);
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute3.setName("entity3");
		entity3.getOwnedAttributes().add(attribute3);

		entity.setSupertype(entity1);
		entity.getAssociatedTypes().add(entity2);
		entity2.getAssociatedTypes().add(entity3);

		final List<Attribute> attributes = es.getAllAttributes(entity);

		assertEquals(4, attributes.size());
		assertEquals(attribute, attributes.get(0));
		assertEquals(attribute1, attributes.get(1));
		assertEquals(attribute2, attributes.get(2));
		assertEquals(attribute3, attributes.get(3));
	}

	@Test
	public void hasAllAttributesEmptyEntity() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();

		assertFalse(es.hasAllAttributes(entity));
	}

	@Test
	public void hasAllAttributesEntity() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute.setName("entiry");
		entity.getOwnedAttributes().add(attribute);
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute1 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute1.setName("entity1");
		entity1.getOwnedAttributes().add(attribute1);
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute2 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute2.setName("entity2");
		entity2.getOwnedAttributes().add(attribute2);
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		final Attribute attribute3 = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		attribute3.setName("entity3");
		entity3.getOwnedAttributes().add(attribute3);

		entity.setSupertype(entity1);
		entity.getAssociatedTypes().add(entity2);
		entity2.getAssociatedTypes().add(entity3);

		assertTrue(es.hasAllAttributes(entity));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeNull() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		entity.getOwnedAttributes().add(attribute);

		assertEquals("From Entity entity", es.getOriginTypeIfDifferent(attribute, null));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeParent() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		entity.getOwnedAttributes().add(attribute);

		assertEquals("", es.getOriginTypeIfDifferent(attribute, entity));
	}

	@Test
	public void getOriginTypeIfDifferentAttribute() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		entity.getOwnedAttributes().add(attribute);

		assertEquals("From Entity entity", es.getOriginTypeIfDifferent(attribute, entity1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespace() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		entity.getOwnedAttributes().add(attribute);
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
		namespace3.getTypes().add(entity);

		assertEquals("From Entity namespace.namespace2.namespace3.entity",
				es.getOriginTypeIfDifferent(attribute, entity1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespaceSuperType() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		entity1.setSupertype(entity);
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		entity.getOwnedAttributes().add(attribute);
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
		namespace3.getTypes().add(entity);

		assertEquals("From supertype namespace.namespace2.namespace3.entity",
				es.getOriginTypeIfDifferent(attribute, entity1));
	}


	@Test
	public void getOriginTypeIfDifferentReferenceNull() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		entity.getOwnedReferences().add(reference);

		assertEquals("From Entity entity", es.getOriginTypeIfDifferent(reference, null));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceParent() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		entity.getOwnedReferences().add(reference);

		assertEquals("", es.getOriginTypeIfDifferent(reference, entity));
	}

	@Test
	public void getOriginTypeIfDifferentReference() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		entity.getOwnedReferences().add(reference);

		assertEquals("From Entity entity", es.getOriginTypeIfDifferent(reference, entity1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespace() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		entity.getOwnedReferences().add(reference);
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
		namespace3.getTypes().add(entity);

		assertEquals("From Entity namespace.namespace2.namespace3.entity",
				es.getOriginTypeIfDifferent(reference, entity1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespaceSuperType() {
		final Entity entity = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity.setName("entity");
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		entity1.setSupertype(entity);
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		entity.getOwnedReferences().add(reference);
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
		namespace3.getTypes().add(entity);

		assertEquals("From supertype namespace.namespace2.namespace3.entity",
				es.getOriginTypeIfDifferent(reference, entity1));
	}

}
