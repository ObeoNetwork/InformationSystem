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
package org.obeonetwork.dsl.soa.m2doc.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.m2doc.services.EnvironmentServices;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;

public class EnvironmentServiceTest {

	EnvironmentServices es = new EnvironmentServices();

	@Test
	public void qualifiedNameEntity() {
		final System system = SoaPackage.eINSTANCE.getSoaFactory().createSystem();
		system.setName("system");
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		namespace.setName("namespace");
		system.getOwnedNamespaces().add(namespace);
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

}
