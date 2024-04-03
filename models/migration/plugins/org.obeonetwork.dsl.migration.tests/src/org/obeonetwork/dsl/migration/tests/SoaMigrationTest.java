/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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

public class SoaMigrationTest extends MigrationTest {
	
	@Test
	public void testSoaSimple() {
		testMigration("simple", false);
	}
	
	@Test
	public void testSoaComplet() {
		testMigration("complet", false);
	}

	@Test
	public void testSoaSecurityApplication() {
		testMigration("securityapplication", true);
	}

	@Test
	public void testSoaSubsystem() {
		testMigration("subsystem", true);
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
