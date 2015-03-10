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
