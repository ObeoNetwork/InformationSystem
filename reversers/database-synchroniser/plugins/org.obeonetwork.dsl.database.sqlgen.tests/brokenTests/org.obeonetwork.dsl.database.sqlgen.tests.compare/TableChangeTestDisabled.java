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
package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public class TableChangeTestDisabled extends AbtractTest {

//	@Test
//	public void createTable() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/create-table/v2.database", "table/create-table/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AddTable);
//		AddTable addTable = (AddTable) diffElement;
//		Table table = addTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//	}
//
//	@Test
//	public void dropTable() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/drop-table/v2.database", "table/drop-table/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof RemoveTable);
//		RemoveTable removeTable = (RemoveTable) diffElement;
//		Table table = removeTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//	}
//
//	@Test
//	public void renameTable() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/rename-table/v2.database", "table/rename-table/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof RenameTableChange);
//		RenameTableChange change = (RenameTableChange)alterTable.getSubDiffElements().get(0);		
//		Table oldTable= change.getTable();
//		assertNotNull(oldTable);
//		Table newTable= change.getNewTable();
//		assertNotNull(newTable);
//		assertEquals("EMPLOYEES", oldTable.getName());
//		assertEquals("EMPLOYEES2", newTable.getName());		
//	}
//	
//	@Test
//	public void createAddColumn() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/add-column/v2.database", "table/add-column/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof AddColumnChange);
//		AddColumnChange change = (AddColumnChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getColumn());
//		Column column = change.getColumn();
//		assertEquals("NewColumn", column.getName());		
//	}
//	
//	@Test
//	public void createRemoveColumn() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/remove-column/v2.database", "table/remove-column/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof RemoveColumnChange);
//		RemoveColumnChange change = (RemoveColumnChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getColumn());
//		Column column = change.getColumn();
//		assertEquals("NewColumn", column.getName());		
//	}
//	
//	@Test
//	public void createRenameColumn() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/rename-column/v2.database", "table/rename-column/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof RenameColumnChange);
//		RenameColumnChange change = (RenameColumnChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getColumn());
//		Column oldColumn = change.getColumn();
//		assertNotNull(change.getNewColumn());
//		Column newColumn = change.getNewColumn();
//		assertEquals("LASTNAME", oldColumn.getName());		
//		assertEquals("LASTNAME_RENAMED", newColumn.getName());
//	}
//	
//	@Test
//	public void createUpdateColumn() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/update-column/v2.database", "table/update-column/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof UpdateColumnChange);
//		UpdateColumnChange change = (UpdateColumnChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getColumn());
//		Column column = change.getColumn();		
//		assertEquals("LASTNAME", column.getName());
//		assertEquals(1, change.getSubchanges());
//	}
//	
//	@Test
//	public void createUpdateColumnComment() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/update-column-comment/v2.database", "table/update-column-comment/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof UpdateColumnCommentChange);
//		UpdateColumnCommentChange change = (UpdateColumnCommentChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getColumn());
//		Column column = change.getColumn();
//		assertEquals("EMPLOYEEID", column.getName());		
//		assertEquals("A Comment with '.", column.getComments());
//	}
//	
//	@Test
//	public void createUpdateTableComment() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("table/update-table-comment/v2.database", "table/update-table-comment/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AlterTable);
//		AlterTable alterTable = (AlterTable) diffElement;
//		assertNotNull(alterTable);
//		Table table = alterTable.getTable();
//		assertNotNull(table);
//		assertEquals("EMPLOYEES", table.getName());
//		assertEquals(1, alterTable.getSubchanges());
//		assertTrue(alterTable.getSubDiffElements().get(0) instanceof UpdateTableCommentChange);
//		UpdateTableCommentChange change = (UpdateTableCommentChange)alterTable.getSubDiffElements().get(0);
//		assertNotNull(change);
//		assertNotNull(change.getTable());
//		Table t = change.getTable();
//		assertEquals("EMPLOYEES", t.getName());		
//		assertEquals("A Table Comment.", t.getComments());
//	}
}
