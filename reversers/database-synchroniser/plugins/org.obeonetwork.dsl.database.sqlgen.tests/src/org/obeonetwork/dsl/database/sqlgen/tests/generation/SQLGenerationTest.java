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
package org.obeonetwork.dsl.database.sqlgen.tests.generation;

import org.junit.Test;

public class SQLGenerationTest extends AbstractSQLGenerationTest {

	@Test
	public void test0_MySQL() {
		assertGenerationEquals("00-full-mysql");
	}
	
	@Test
	public void test0_MariaDB() {
		assertGenerationEquals("00-full-mariadb");
	}
	
	@Test
	public void test0_Oracle() {
		assertGenerationEquals("00-full-oracle");
	}
	
	@Test
	public void test0_PostgreSQL() {
		assertGenerationEquals("00-full-postgresql");
	}
	
	@Test
	public void test1() {
		assertGenerationEquals("01-simple");
	}
	
	@Test
	public void test2() {
		assertGenerationEquals("02-simple-techidchanged");
	}
	
	@Test
	public void test3() {
		assertGenerationEquals("03-add-schema");
	}
	
	@Test
	public void test4() {
		assertGenerationEquals("04-remove-schema");
	}
	
	@Test
	public void test5() {
		assertGenerationEquals("05-complet");
	}
	
	@Test
	public void test6() {
		assertGenerationEquals("06-complet2");
	}
	
	@Test
	public void test7() {
		assertGenerationEquals("07-column-type-changed");
	}
	
	@Test
	public void test8() {
		assertGenerationEquals("08-move-element");
	}
	
	@Test
	public void test9() {
		assertGenerationEquals("09-createH2");
	}
	
	@Test
	public void test10() {
		assertGenerationEquals("10-createPostgres");
	}
	
	@Test
	public void test11() {
		assertGenerationEquals("11-createSqlServer");
	}
	
	@Test
	public void test12() {
		assertGenerationEquals("12-update-view-query");
	}
	
	@Test
	public void test13() {
		assertGenerationEquals("13-update-view-query2");
	}
	
	@Test
	public void test14() {
		assertGenerationEquals("14-updatecolumn-pgsql");
	}
}
