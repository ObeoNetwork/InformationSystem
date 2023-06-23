/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.migration.tests;

import org.junit.Assert;
import org.junit.Test;

public class EntityMigrationTest extends MigrationTest {
	
	@Test
	public void testSimpleEntity() {
		testMigration("simple", false);
	}

	@Test
	public void testEntities() {
		testMigration("entities", false);
	}
	
	@Test
	public void testMigrationNotNeeded() {
		String folder = "migrationNotNeeded";
		testMigration(folder, false);
		
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
