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
package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public class ForeignKeyChangeTestDisabled extends AbtractTest {

//	@Test
//	public void createForeignKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("fk/create-fk/v2.database", "fk/create-fk/v1.database");		
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof AddForeignKey);
//		AddForeignKey addPK = (AddForeignKey) diffElement;
//		ForeignKey fk = addPK.getForeignKey();
//		assertNotNull(fk);
//		assertEquals("FK_EMPLOYEES_EMPLOYEES", fk.getName());
//		assertEquals(1, fk.getElements().size());
//		Column fkColumn = fk.getElements().get(0).getFkColumn();
//		assertEquals("REPORTSTO", fkColumn.getName());
//		assertEquals("EMPLOYEES", ((Table)fkColumn.eContainer()).getName());
//		Column pkColumn = fk.getElements().get(0).getPkColumn();
//		assertNotNull(pkColumn);
//		assertEquals("EMPLOYEEID", pkColumn.getName());		
//		assertEquals("EMPLOYEES", ((Table)pkColumn.eContainer()).getName());
//	}
//	
//	@Test
//	public void dropForeignKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("fk/drop-fk/v2.database", "fk/drop-fk/v1.database");		
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof RemoveForeignKey);
//		RemoveForeignKey removePK = (RemoveForeignKey) diffElement;
//		ForeignKey fk = removePK.getForeignKey();
//		assertNotNull(fk);
//		assertEquals("FK_EMPLOYEES_EMPLOYEES", fk.getName());		
//	}
//	
//	@Test
//	public void updateForeignKey() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("fk/update-fk/v2.database", "fk/update-fk/v1.database");
//		assertEquals(2, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof UpdateForeignKey);
//		UpdateForeignKey updatePK = (UpdateForeignKey) diffElement;
//		assertEquals(2, updatePK.getSubchanges());
//		ForeignKey fk = updatePK.getForeignKey();
//		assertNotNull(fk);
//		assertEquals("FK_EMPLOYEES_EMPLOYEES", fk.getName());		
//		ForeignKey newFk = updatePK.getNewForeignKey();
//		assertNotNull(newFk);
//		assertEquals("FK_EMPLOYEES_EMPLOYEES2", newFk.getName());		
//		assertEquals(1, newFk.getElements().size());
//		Column fkColumn = newFk.getElements().get(0).getFkColumn();
//		assertEquals("HIREBY", fkColumn.getName());
//		assertEquals("EMPLOYEES", ((Table)fkColumn.eContainer()).getName());
//		Column pkColumn = newFk.getElements().get(0).getPkColumn();
//		assertNotNull(pkColumn);
//		assertEquals("EMPLOYEEID", pkColumn.getName());		
//		assertEquals("EMPLOYEES", ((Table)pkColumn.eContainer()).getName());
//	}	
//	

}
