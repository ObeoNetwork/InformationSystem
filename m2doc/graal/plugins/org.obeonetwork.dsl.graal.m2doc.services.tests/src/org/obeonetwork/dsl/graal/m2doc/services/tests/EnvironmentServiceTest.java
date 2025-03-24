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
package org.obeonetwork.dsl.graal.m2doc.services.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.m2doc.services.EnvironmentServices;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;

public class EnvironmentServiceTest {

	EnvironmentServices es = new EnvironmentServices();

	@Test
	public void getOriginTypeIfDifferentAttributeNull() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		domainClass.getOwnedAttributes().add(attribute);

		assertEquals("From DomainClass domainClass", es.getOriginTypeIfDifferent(attribute, null));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeParent() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		domainClass.getOwnedAttributes().add(attribute);

		assertEquals("", es.getOriginTypeIfDifferent(attribute, domainClass));
	}

	@Test
	public void getOriginTypeIfDifferentAttribute() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		domainClass.getOwnedAttributes().add(attribute);

		assertEquals("From DomainClass domainClass", es.getOriginTypeIfDifferent(attribute, domainClass1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespace() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		domainClass.getOwnedAttributes().add(attribute);
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
		namespace3.getTypes().add(domainClass);

		assertEquals("From DomainClass namespace.namespace2.namespace3.domainClass",
				es.getOriginTypeIfDifferent(attribute, domainClass1));
	}

	@Test
	public void getOriginTypeIfDifferentAttributeQualifiedNameNamespaceSuperType() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		domainClass1.setSupertype(domainClass);
		Attribute attribute = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createAttribute();
		domainClass.getOwnedAttributes().add(attribute);
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
		namespace3.getTypes().add(domainClass);

		assertEquals("From supertype namespace.namespace2.namespace3.domainClass",
				es.getOriginTypeIfDifferent(attribute, domainClass1));
	}


	@Test
	public void getOriginTypeIfDifferentReferenceNull() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		domainClass.getOwnedReferences().add(reference);

		assertEquals("From DomainClass domainClass", es.getOriginTypeIfDifferent(reference, null));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceParent() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		domainClass.getOwnedReferences().add(reference);

		assertEquals("", es.getOriginTypeIfDifferent(reference, domainClass));
	}

	@Test
	public void getOriginTypeIfDifferentReference() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		domainClass.getOwnedReferences().add(reference);

		assertEquals("From DomainClass domainClass", es.getOriginTypeIfDifferent(reference, domainClass1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespace() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		domainClass.getOwnedReferences().add(reference);
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
		namespace3.getTypes().add(domainClass);

		assertEquals("From DomainClass namespace.namespace2.namespace3.domainClass",
				es.getOriginTypeIfDifferent(reference, domainClass1));
	}

	@Test
	public void getOriginTypeIfDifferentReferenceQualifiedNameNamespaceSuperType() {
		final DomainClass domainClass = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass.setName("domainClass");
		final DomainClass domainClass1 = GraalPackage.eINSTANCE.getGraalFactory().createDomainClass();
		domainClass1.setName("domainClass1");
		domainClass1.setSupertype(domainClass);
		Reference reference = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createReference();
		domainClass.getOwnedReferences().add(reference);
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
		namespace3.getTypes().add(domainClass);

		assertEquals("From supertype namespace.namespace2.namespace3.domainClass",
				es.getOriginTypeIfDifferent(reference, domainClass1));
	}

}
