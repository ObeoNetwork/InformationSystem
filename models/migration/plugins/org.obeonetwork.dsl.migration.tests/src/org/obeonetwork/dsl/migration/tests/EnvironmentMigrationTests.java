package org.obeonetwork.dsl.migration.tests;

import org.junit.Test;

public class EnvironmentMigrationTests extends MigrationTests {

	@Test
	public void testField2Literal() {
		testMigration("field2literal");
	}

	@Override
	protected String getRootFolder() {
		return "models/environment";
	}

	@Override
	protected String getModelFileExtension() {
		return "environment";
	}
	
}
