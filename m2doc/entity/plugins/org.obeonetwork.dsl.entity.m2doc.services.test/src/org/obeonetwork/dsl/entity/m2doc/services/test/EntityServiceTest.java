/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
import org.obeonetwork.dsl.entity.m2doc.services.EntityServices;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;

public class EntityServiceTest {

	EntityServices es = new EntityServices();

	@Test(expected = NullPointerException.class)
	public void getOwnedEntitiesNull() {
		es.getOwnedEntities(null);
	}

	@Test
	public void getOwnedEntitiesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		final List<Entity> entities = es.getOwnedEntities(namespace);

		assertTrue(entities.isEmpty());
	}

	@Test
	public void getOwnedEntitiesNoEntitiesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		final List<Entity> entities = es.getOwnedEntities(namespace);

		assertTrue(entities.isEmpty());
	}

	@Test
	public void getOwnedEntitiesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity2.setName("entity2");
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity3.setName("entity3");
		namespace.getTypes().add(entity2);
		namespace.getTypes().add(entity3);
		namespace.getTypes().add(entity1);

		final List<Entity> entities = es.getOwnedEntities(namespace);

		assertEquals(3, entities.size());
		assertEquals(entity1, entities.get(0));
		assertEquals(entity2, entities.get(1));
		assertEquals(entity3, entities.get(2));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedEntitiesNull() {
		es.hasOwnedEntities(null);
	}

	@Test
	public void hasOwnedEntitiesEmptyNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();

		assertFalse(es.hasOwnedEntities(namespace));
	}

	@Test
	public void hasOwnedEntitiesNoEntitiesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final DTO dto = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createDTO();
		namespace.getTypes().add(dto);

		assertFalse(es.hasOwnedEntities(namespace));
	}

	@Test
	public void hasOwnedEntitiesNamespace() {
		final Namespace namespace = EnvironmentPackage.eINSTANCE.getEnvironmentFactory().createNamespace();
		final Entity entity1 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity1.setName("entity1");
		final Entity entity2 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity2.setName("entity2");
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity3.setName("entity3");
		namespace.getTypes().add(entity2);
		namespace.getTypes().add(entity3);
		namespace.getTypes().add(entity1);

		assertTrue(es.hasOwnedEntities(namespace));
	}

}
