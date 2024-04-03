/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.Table;

public class SQLServiceTest {

	private SQLService service;

	@Before
	public void before() {
		service = new SQLService();
	}

	@Test
	public void checkValidateConstaint() {
		Constraint constraint = DatabaseFactory.eINSTANCE.createConstraint();
		assertFalse(service.validateConstaint(constraint).isOK()); // No parent

		Table table = DatabaseFactory.eINSTANCE.createTable();
		table.getConstraints().add(constraint);
		assertFalse(service.validateConstaint(constraint).isOK()); // Table has no name

		table.setName("A_TABLE ");
		assertFalse(service.validateConstaint(constraint).isOK()); // No constraint name

		constraint.setName("CONSTRAINT_NAME ");
		assertFalse(service.validateConstaint(constraint).isOK()); // No expression

		constraint.setExpression("AN_EXPRESSION");
		assertTrue(service.validateConstaint(constraint).isOK());
	}

	@Test
	public void checkBuildAddConstraintQuery() {
		Constraint constraint = DatabaseFactory.eINSTANCE.createConstraint();
		Table table = DatabaseFactory.eINSTANCE.createTable();
		table.getConstraints().add(constraint);

		table.setName("A_TABLE ");
		constraint.setName("CONSTRAINT_NAME ");
		constraint.setExpression("AN_EXPRESSION");

		assertEquals("ALTER TABLE A_TABLE ADD CONSTRAINT CONSTRAINT_NAME CHECK(AN_EXPRESSION);", //
				service.buildAddConstraintQuery(constraint.getOwner().getName(), constraint.getName(),
						constraint.getExpression()));

	}

}
