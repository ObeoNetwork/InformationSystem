package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.io.File;

import org.eclipse.emf.compare.Comparison;
import org.junit.Test;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;

public class PrimaryKeySQLGenTest extends AbtractGeneratorTest {

	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {
		DatabaseGen primaryKeyGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return primaryKeyGen;
	}
	
	@Test
	public void createPrimaryKey() throws Exception {
		assertGen("pk/create-pk", "create-pk.sql");
	}

	@Test
	public void dropPrimaryKey() throws Exception {
		assertGen("pk/drop-pk", "drop-pk.sql");
	}

	@Test
	public void alterPrimaryKey() throws Exception {
		assertGen("pk/update-pk", "alter-pk.sql");
	}
}
