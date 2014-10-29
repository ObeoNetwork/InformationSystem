package org.obeonetwork.dsl.migration.tests;

import org.junit.Assert;
import org.junit.Test;

public class EntityMigrationTests extends MigrationTests {
	
	@Test
	public void testSimpleEntity() {
		testMigration("simple");
	}

	@Test
	public void testEntities() {
		testMigration("entities");
	}
	
	@Test
	public void testMigrationNotNeeded() {
		String folder = "migrationNotNeeded";
		testMigration(folder);
		
		// The file should not be changed by migration
		String sourceModelPath = getFullPathForBeforeModel(folder);
		String expectedModelPath = getFullPathForExpectedModel(folder);
		Assert.assertEquals("File did not change at all", getFileContents(expectedModelPath), getFileContents(sourceModelPath)); 
	}

	@Override
	protected String getRootFolder() {
		return "models/entity";
	}

	@Override
	protected String getModelFileExtension() {
		return "entity";
	}
	
}
