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
package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public class ConstraintChangeTestDisabled extends AbtractTest {

//	@Test
//	public void createConstraint() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("constraint/create-constraint/v2.database", "constraint/create-constraint/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AddConstraint);
//		AddConstraint addConstraint = (AddConstraint) diffElement;
//		Constraint constraint = addConstraint.getConstraint();
//		assertNotNull(constraint);
//		assertEquals("UnitPriceGreaterThanZero", constraint.getName());
//		assertEquals("UNITPRICE>0", constraint.getExpression());
//	}
//
//	@Test
//	public void dropConstraint() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("constraint/drop-constraint/v2.database", "constraint/drop-constraint/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof RemoveConstraint);
//		RemoveConstraint removeConstraint = (RemoveConstraint) diffElement;
//		Constraint constraint = removeConstraint.getConstraint();
//		assertNotNull(constraint);
//		assertEquals("UnitPriceGreaterThanZero", constraint.getName());
//		assertEquals("UNITPRICE>0", constraint.getExpression());
//	}	
//	
//	@Test
//	public void updateTheNameOfConstraint() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("constraint/update-constraint/only-name/v2.database", "constraint/update-constraint/only-name/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof UpdateConstraint);
//		UpdateConstraint updateConstraint = (UpdateConstraint) diffElement;
////		assertEquals(1, updateConstraint.getSubchanges());
//		Constraint constraint = updateConstraint.getConstraint();
//		assertNotNull(constraint);
//		assertEquals("UnitPriceGreaterThanZero", constraint.getName());
//		assertEquals("UNITPRICE>0", constraint.getExpression());	
//		Constraint newConstraint = updateConstraint.getNewConstraint();
//		assertNotNull(newConstraint);
//		assertEquals("UnitPriceGreaterThanTen", newConstraint.getName());
//		assertEquals("UNITPRICE>0", newConstraint.getExpression());
//	}
//	
//	@Test
//	public void updateTheExpressionConstraint() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("constraint/update-constraint/only-expression/v2.database", "constraint/update-constraint/only-expression/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof UpdateConstraint);
//		UpdateConstraint updateConstraint = (UpdateConstraint) diffElement;
////		assertEquals(1, updateConstraint.getSubchanges());
//		Constraint constraint = updateConstraint.getConstraint();
//		assertNotNull(constraint);
//		assertEquals("UnitPriceGreaterThanZero", constraint.getName());
//		assertEquals("UNITPRICE>0", constraint.getExpression());	
//		Constraint newConstraint = updateConstraint.getNewConstraint();
//		assertNotNull(newConstraint);
//		assertEquals("UnitPriceGreaterThanZero", newConstraint.getName());
//		assertEquals("UNITPRICE>10", newConstraint.getExpression());
//	}
//	
//	@Test
//	public void updateNameAndExpressionConstraint() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("constraint/update-constraint/v2.database", "constraint/update-constraint/v1.database");
//		assertEquals(2, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);		
//		assertTrue(diffElement instanceof AddConstraint || diffElement instanceof RemoveConstraint);
//		diffElement = databaseChangeSet.getSubDiffElements().get(1);
//		assertTrue(diffElement instanceof AddConstraint || diffElement instanceof RemoveConstraint);		
//	}

}
