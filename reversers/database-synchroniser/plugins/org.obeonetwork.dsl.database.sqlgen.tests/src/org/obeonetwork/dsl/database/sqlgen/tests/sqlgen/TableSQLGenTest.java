package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.io.File;

import org.eclipse.emf.compare.Comparison;
import org.junit.Test;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;

public class TableSQLGenTest extends AbtractGeneratorTest {

	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {	
		DatabaseGen tableGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return tableGen;
	}
	
	@Test
	public void createTable() throws Exception {
		assertGen("table/create-table", "create-tables.sql");
	}

	@Test
	public void dropTable() throws Exception {
		assertGen("table/drop-table", "drop-tables.sql");
	}

	@Test
	public void renameTable() throws Exception {
		assertGen("table/rename-table", "alter-tables.sql");
	}
	
	@Test
	public void createAddColumn() throws Exception {
		assertGen("table/add-column", "alter-tables.sql");	
	}
	
	@Test
	public void createAddColumnWithComment() throws Exception {
		assertGen("table/add-column/with-comment", "alter-tables.sql");	
	}
	
	@Test
	public void createRemoveColumn() throws Exception {
		assertGen("table/remove-column", "alter-tables.sql");
	}
	
	@Test
	public void createRenameColumn() throws Exception {
		assertGen("table/rename-column", "alter-tables.sql");
	}
	
	@Test
	public void createUpdateColumn() throws Exception {
		assertGen("table/update-column", "alter-tables.sql");
	}

	@Test
	public void createUpdateColumnComment() throws Exception {
		assertGen("table/update-column-comment", "alter-tables.sql");
	}
	
	@Test
	public void createUpdateTableComment() throws Exception {
		assertGen("table/update-table-comment", "alter-tables.sql");
	}
	
	@Test
	public void changeColumnSize() throws Exception {		
		assertGen("table/change-column-size", "alter-tables.sql");		
	}
}
