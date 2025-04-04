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
package org.obeonetwork.dsl.migration.tests;

import org.junit.Test;

public class EnvironmentMigrationTest extends MigrationTest {

	@Test
	public void testField2Literal() {
		testMigration("field2literal", false);
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
