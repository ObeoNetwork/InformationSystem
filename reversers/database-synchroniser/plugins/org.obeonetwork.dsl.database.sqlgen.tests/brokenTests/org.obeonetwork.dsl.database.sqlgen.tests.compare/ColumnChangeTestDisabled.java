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

public class ColumnChangeTestDisabled extends AbtractTest {

//	@Test
//	public void bug13_change_type_not_detected_on_column() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("bugs/bug13/v2.database", "bugs/bug13/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable)diffElement;
//		assertEquals(1, alterTable.getSubchanges());
//		diffElement = alterTable.getSubDiffElements().get(0);		
//		assertTrue(diffElement instanceof UpdateColumnChange);
//		UpdateColumnChange updateColumnChange = (UpdateColumnChange) diffElement;
//		assertNotNull(updateColumnChange.getColumn());
//		assertEquals("col1", updateColumnChange.getColumn().getName());		
//	}
//	
//	@Test
//	public void bug14_rename_column_not_detected_with_same_xmiid() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("bugs/bug14/withsamexmiid/v2.database", "bugs/bug14/withsamexmiid/v1.database");
//		assertRenameColumn(databaseChangeSet);	
//	}
//	
//	@Test
//	public void bug14_rename_column_not_detected_with_no_xmiid_matching() throws Exception {		
//		DatabaseChangeSet databaseChangeSet = diff("bugs/bug14/withnoxmiid/v2.database", "bugs/bug14/withnoxmiid/v1.database");
//		assertRenameColumn(databaseChangeSet);		
//	}
//	
//	private void assertRenameColumn(DatabaseChangeSet databaseChangeSet) throws Exception {				
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable)diffElement;
//		assertEquals(1, alterTable.getSubchanges());
//		diffElement = alterTable.getSubDiffElements().get(0);
//		assertTrue(diffElement instanceof RenameColumnChange);
//		RenameColumnChange renameColumnChange = (RenameColumnChange) diffElement;
//		assertNotNull(renameColumnChange.getColumn());
//		assertNotNull(renameColumnChange.getNewColumn());
//		assertEquals("rf_zfct_lib", renameColumnChange.getColumn().getName());		
//		assertEquals("PIERREPAULJACQUES", renameColumnChange.getNewColumn().getName());		
//	}
//	
//	@Test
//	public void changeColumnSize() throws Exception {		
//		DatabaseChangeSet databaseChangeSet = diff("table/change-column-size/v2.database", "table/change-column-size/v1.database");
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);		
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable)diffElement;
//		assertEquals(1, alterTable.getSubchanges());
//		diffElement = alterTable.getSubDiffElements().get(0);
//		assertTrue(diffElement instanceof UpdateColumnChange);
//		UpdateColumnChange updateColumnChange = (UpdateColumnChange) diffElement;
//		assertNotNull(updateColumnChange.getColumn());
//		assertNotNull(updateColumnChange.getColumn().getType());
//		assertTrue(updateColumnChange.getColumn().getType() instanceof TypeInstance);		
//		TypeInstance typeInstance = (TypeInstance)updateColumnChange.getColumn().getType();
//		assertEquals("VARCHAR2",typeInstance.getNativeType().getName());
//		assertEquals(31,typeInstance.getLength().intValue());		
//	}
	
}
