/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.m2doc.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.Wire;
import org.obeonetwork.dsl.soa.m2doc.services.SOAServices;

public class SOAServicesTest {

	SOAServices soas = new SOAServices();

	@Test(expected = NullPointerException.class)
	public void hasOwnedComponentNull() {
		soas.hasOwnedComponent(null);
	}

	@Test
	public void hasOwnedComponentEmptySystem() {
		final System system = SoaPackage.eINSTANCE.getSoaFactory().createSystem();

		assertFalse(soas.hasOwnedComponent(system));
	}

	@Test
	public void hasOwnedComponent() {
		final System system = SoaPackage.eINSTANCE.getSoaFactory().createSystem();

		final Component component1 = SoaPackage.eINSTANCE.getSoaFactory().createComponent();
		system.getOwnedComponents().add(component1);

		assertTrue(soas.hasOwnedComponent(system));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedWireNull() {
		soas.hasOwnedWire(null);
	}

	@Test
	public void hasOwnedWireEmptySystem() {
		final System system = SoaPackage.eINSTANCE.getSoaFactory().createSystem();

		assertFalse(soas.hasOwnedWire(system));
	}

	@Test
	public void hasOwnedWire() {
		final System system = SoaPackage.eINSTANCE.getSoaFactory().createSystem();

		final Wire wire1 = SoaPackage.eINSTANCE.getSoaFactory().createWire();
		system.getOwnedWires().add(wire1);

		assertTrue(soas.hasOwnedWire(system));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedOperationsNull() {
		soas.getOwnedOperations(null);
	}

	@Test
	public void getOwnedOperationsEmptyService() {
		final Service service = SoaPackage.eINSTANCE.getSoaFactory().createService();

		final List<Operation> operations = soas.getOwnedOperations(service);

		assertEquals(0, operations.size());
	}

	@Test
	public void getOwnedOperations() {
		final Service service = SoaPackage.eINSTANCE.getSoaFactory().createService();
		final Interface interface1 = SoaPackage.eINSTANCE.getSoaFactory().createInterface();
		service.setOwnedInterface(interface1);
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();
		interface1.getOwnedOperations().add(operation);

		final List<Operation> operations = soas.getOwnedOperations(service);

		assertEquals(1, operations.size());
		assertEquals(operation, operations.get(0));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedOperationsNull() {
		soas.hasOwnedOperations(null);
	}

	@Test
	public void hasOwnedOperationsEmptyService() {
		final Service service = SoaPackage.eINSTANCE.getSoaFactory().createService();

		assertFalse(soas.hasOwnedOperations(service));
	}

	@Test
	public void hasOwnedOperations() {
		final Service service = SoaPackage.eINSTANCE.getSoaFactory().createService();
		final Interface interface1 = SoaPackage.eINSTANCE.getSoaFactory().createInterface();
		service.setOwnedInterface(interface1);
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();
		interface1.getOwnedOperations().add(operation);

		assertTrue(soas.hasOwnedOperations(service));
	}

	@Test(expected = NullPointerException.class)
	public void getOwnedParametersNull() {
		soas.getOwnedParameters(null);
	}

	@Test
	public void getOwnedParametersEmptyOperation() {
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();

		final List<Parameter> parameters = soas.getOwnedParameters(operation);

		assertEquals(0, parameters.size());
	}

	@Test
	public void getOwnedParameters() {
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();
		final Parameter parameter1 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter2 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter3 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter4 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter5 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter6 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();

		operation.getInput().add(parameter3);
		operation.getInput().add(parameter4);
		operation.getOutput().add(parameter2);
		operation.getOutput().add(parameter5);
		operation.getFault().add(parameter1);
		operation.getFault().add(parameter6);

		final List<Parameter> parameters = soas.getOwnedParameters(operation);

		assertEquals(6, parameters.size());
		assertEquals(parameter3, parameters.get(0));
		assertEquals(parameter4, parameters.get(1));
		assertEquals(parameter2, parameters.get(2));
		assertEquals(parameter5, parameters.get(3));
		assertEquals(parameter1, parameters.get(4));
		assertEquals(parameter6, parameters.get(5));
	}

	@Test(expected = NullPointerException.class)
	public void hasOwnedParametersNull() {
		soas.hasOwnedParameters(null);
	}

	@Test
	public void hasOwnedParametersEmptyOperation() {
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();

		assertFalse(soas.hasOwnedParameters(operation));
	}

	@Test
	public void hasOwnedParameters() {
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();
		final Parameter parameter1 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter2 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter3 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter4 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter5 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter6 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();

		operation.getInput().add(parameter3);
		operation.getInput().add(parameter4);
		operation.getOutput().add(parameter2);
		operation.getOutput().add(parameter5);
		operation.getFault().add(parameter1);
		operation.getFault().add(parameter6);

		assertTrue(soas.hasOwnedParameters(operation));
	}

	@Test(expected = NullPointerException.class)
	public void kindNull() {
		soas.kind(null);
	}

	@Test
	public void kind() {
		final Operation operation = SoaPackage.eINSTANCE.getSoaFactory().createOperation();
		final Parameter parameter1 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter2 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		final Parameter parameter3 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();

		operation.getInput().add(parameter3);
		operation.getOutput().add(parameter2);
		operation.getFault().add(parameter1);

		assertEquals("fault", soas.kind(parameter1));
		assertEquals("output", soas.kind(parameter2));
		assertEquals("input", soas.kind(parameter3));
	}

	@Test(expected = NullPointerException.class)
	public void uniqueNull() {
		soas.unique(null);
	}

	@Test
	public void unique() {
		final Parameter parameter1 = SoaPackage.eINSTANCE.getSoaFactory().createParameter();

		parameter1.setIsUnique(false);

		assertFalse(soas.unique(parameter1));

		parameter1.setIsUnique(true);

		assertTrue(soas.unique(parameter1));
	}

	@Test(expected = NullPointerException.class)
	public void typeNameNull() {
		soas.typeName(null);
	}

	@Test
	public void typeName() {
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
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity3.setName("entity3");
		namespace3.getTypes().add(entity3);
		final Parameter parameter = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		parameter.setType(entity3);

		assertEquals("entity3[1]", soas.typeName(parameter));
	}

	@Test(expected = NullPointerException.class)
	public void qualifiedTypeNameNull() {
		soas.qualifiedTypeName(null);
	}

	@Test
	public void qualifiedTypeName() {
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
		final Entity entity3 = EntityPackage.eINSTANCE.getEntityFactory().createEntity();
		entity3.setName("entity3");
		namespace3.getTypes().add(entity3);
		final Parameter parameter = SoaPackage.eINSTANCE.getSoaFactory().createParameter();
		parameter.setType(entity3);

		assertEquals("namespace.namespace2.namespace3.entity3[1]", soas.qualifiedTypeName(parameter));
	}

}
