/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
	public void testFragment() {
		testMigration("fragment");
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
