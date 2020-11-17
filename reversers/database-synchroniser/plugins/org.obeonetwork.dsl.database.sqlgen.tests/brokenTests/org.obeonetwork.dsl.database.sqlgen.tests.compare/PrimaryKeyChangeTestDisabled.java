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
package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public class PrimaryKeyChangeTestDisabled extends AbtractTest {

//	@Test
//	public void createPrimaryKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("pk/create-pk/v2.database", "pk/create-pk/v1.database");		
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof AddPrimaryKey);
//		AddPrimaryKey addPK = (AddPrimaryKey) diffElement;
//		PrimaryKey pk = addPK.getPrimaryKey();
//		assertNotNull(pk);
//		assertEquals("PRIMARY", pk.getName());
//		assertEquals(1, pk.getColumns().size());
//		Column column = pk.getColumns().get(0);
//		assertNotNull(column);
//		assertEquals("EMPLOYEEID", column.getName());
//	}
//	
//	@Test
//	public void dropPrimaryKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("pk/drop-pk/v2.database", "pk/drop-pk/v1.database");		
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof RemovePrimaryKey);
//		RemovePrimaryKey removePK = (RemovePrimaryKey) diffElement;
//		PrimaryKey pk = removePK.getPrimaryKey();
//		assertNotNull(pk);
//		assertEquals("PRIMARY", pk.getName());
//		assertEquals(1, pk.getColumns().size());
//		Column column = pk.getColumns().get(0);
//		assertNotNull(column);
//		assertEquals("EMPLOYEEID", column.getName());
//	}
//	
//	@Test
//	public void updatePrimaryKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("pk/update-pk/v2.database", "pk/update-pk/v1.database");
//		assertEquals(2, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof UpdatePrimaryKey);
//		UpdatePrimaryKey updatePK = (UpdatePrimaryKey) diffElement;
//		PrimaryKey pk = updatePK.getPrimaryKey();
//		assertNotNull(pk);
//		assertEquals("PRIMARY", pk.getName());
//		PrimaryKey newPk = updatePK.getNewPrimaryKey();
//		assertNotNull(newPk);
//		assertEquals("PRIMARY2", newPk.getName());
//		assertEquals(2, newPk.getColumns().size());
//		Column column1 = newPk.getColumns().get(0);
//		assertNotNull(column1);
//		assertEquals("EMPLOYEEID", column1.getName());
//		Column column2 = newPk.getColumns().get(1);
//		assertNotNull(column2);
//		assertEquals("HIREDATE", column2.getName());
//	}	
//	

}
