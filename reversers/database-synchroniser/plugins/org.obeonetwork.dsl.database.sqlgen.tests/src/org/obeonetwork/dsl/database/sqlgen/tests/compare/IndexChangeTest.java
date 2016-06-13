package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public class IndexChangeTest extends AbtractTest {
//
//	@Test
//	public void createIndex() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("index/create-index/v2.database", "index/create-index/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof AddIndex);
//		AddIndex addIndex = (AddIndex) diffElement;
//		Index index = addIndex.getIndex();
//		assertNotNull(index);
//		assertEquals("IX_EMPLOYEES_LASTNAME", index.getName());
//		assertEquals(1, index.getElements().size());
//		Column column = index.getElements().get(0).getColumn();
//		assertNotNull(column);
//		assertEquals("LASTNAME", column.getName());
//	}
//
//	@Test
//	public void dropIndex() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("index/drop-index/v2.database", "index/drop-index/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof RemoveIndex);
//		RemoveIndex removeIndex = (RemoveIndex) diffElement;
//		Index index = removeIndex.getIndex();
//		assertNotNull(index);
//		assertEquals("IX_EMPLOYEES_LASTNAME", index.getName());
//		assertEquals(1, index.getElements().size());
//		Column column = index.getElements().get(0).getColumn();
//		assertNotNull(column);
//		assertEquals("LASTNAME", column.getName());
//	}
//
//	@Test
//	public void updateIndex() throws Exception {
//		DatabaseChangeSet databaseChangeSet = diff("index/update-index/v2.database", "index/update-index/v1.database");
//		assertEquals(1, databaseChangeSet.getSubchanges());
//		DiffElement diffElement = databaseChangeSet.getSubDiffElements().get(0);
//		assertNotNull(diffElement);
//		assertTrue(diffElement instanceof UpdateIndex);
//		UpdateIndex updateIndex = (UpdateIndex) diffElement;
//		Index index = updateIndex.getIndex();
//		assertNotNull(index);
//		assertEquals("IX_EMPLOYEES_LASTNAME", index.getName());
//		Index newIndex = updateIndex.getNewIndex();
//		assertNotNull(newIndex);
//		assertEquals("IX_EMPLOYEES_FIRSTNAME_LASTNAME", newIndex.getName());		
//		assertEquals(2, newIndex.getElements().size());
//		Column column1 = newIndex.getElements().get(0).getColumn();
//		assertNotNull(column1);
//		assertEquals("FIRSTNAME", column1.getName());
//		Column column2 = newIndex.getElements().get(1).getColumn();
//		assertNotNull(column2);
//		assertEquals("LASTNAME", column2.getName());
//	}

}
