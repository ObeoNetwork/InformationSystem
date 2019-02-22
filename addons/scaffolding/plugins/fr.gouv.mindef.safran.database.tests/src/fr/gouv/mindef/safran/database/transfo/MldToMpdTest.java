/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.transfo;


import org.junit.Test;

public class MldToMpdTest extends AbstractTransformationTest {

	@Override
	String getModelsFolder() {
		return "/fr.gouv.mindef.safran.database.tests/models/mld2mpd/";
	}

	@Test
	public void test12DefaultLengthAndPrecision() {
		testMldToMpd("11-oracle-default-length-and-precision");
	}
	
	@Test
	public void test1() {
		testMldToMpd("1-oracle-simple");
	}
	
	@Test
	public void testOracleConstraint() {
		testMldToMpd("2-oracle-constraint");
	}
	
	@Test
	public void testOracleConcurrentModificationException() {
		testMldToMpdWithScaffoldModel("3-safran155-oracle-concurrentmodification");
	}
	
	@Test
	public void test4() {
		testMldToMpd("4-mysql-simple");
	}
	
	@Test
	public void test5() {
		testMldToMpd("5-h2-simple");
	}
	
	@Test
	public void test6() {
		testMldToMpd("6-sqlserver-simple");
	}
	
	@Test
	public void test7() {
		testMldToMpd("7-postgres-simple");
	}
	
	@Test
	public void testSafran416() {
		testMldToMpdWithScaffoldModel("8-safran-416-sequence-comments");
	}
	
	@Test
	public void testSafran417() {
		testMldToMpdWithScaffoldModel("9-safran-417-sequence-attributes");
	}
	
	@Test
	public void testSafran416InitialComments() {
		testMldToMpd("10-safran-416-sequence-initialcomments");
	}
	
	@Test
	public void test12() {
		testMldToMpd("12-mariadb-simple");
	}
}
