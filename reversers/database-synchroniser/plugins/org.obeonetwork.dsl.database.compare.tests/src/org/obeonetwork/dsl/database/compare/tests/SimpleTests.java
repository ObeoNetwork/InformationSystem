/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.tests;

import org.junit.Test;

public class SimpleTests extends AbstractDatabaseCompareTest {

	@Test
	public void test01Simple() {
		testDatabaseCompare("01-simple");
	}
	
	@Test
	public void test02SimpleWithChangedTechId() {
		testDatabaseCompare("02-simple-techidchanged");
	}
	
	@Test
	public void test03AddSchema() {
		testDatabaseCompare("03-add-schema");
	}
	
	@Test
	public void test04RemoveSchema() {
		testDatabaseCompare("04-remove-schema");
	}
	
	@Test
	public void test05Complet() {
		testDatabaseCompare("05-complet");
	}
	
	@Test
	public void test06Complet2() {
		testDatabaseCompare("06-complet2");
	}

	@Test
	public void test07ColumnTypeChanged() {
		testDatabaseCompare("07-column-type-changed");
	}
	
	@Test
	public void test08MoveElement() {
		testDatabaseCompare("08-move-element");
	}
}
