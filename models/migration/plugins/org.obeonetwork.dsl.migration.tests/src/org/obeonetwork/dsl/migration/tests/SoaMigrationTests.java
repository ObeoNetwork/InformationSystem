package org.obeonetwork.dsl.migration.tests;

import org.junit.Test;

public class SoaMigrationTests extends MigrationTests {
	
	@Test
	public void testSoaSimple() {
		testMigration("simple");
	}
	
	@Test
	public void testSoaComplet() {
		testMigration("complet");
	}

	@Override
	protected String getRootFolder() {
		return "models/soa";
	}

	@Override
	protected String getModelFileExtension() {
		return "soa";
	}
	
}
