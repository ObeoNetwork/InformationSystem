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
package org.obeonetwork.dsl.database.liquibasegen.update;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * 
 * @author Obeo
 *         
 */
@RunWith(Parameterized.class)
public class MySQLLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {
	
	/**
	 * Requires a MySQL server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * A database named public must be (existing or) created too.
	 * <code>docker run --name mysql5 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test mysql:5.7</code>
	 * Within the container create database with commands:
	 * <code>mysql --host=localhost --user=root --password=password</code>
	 * <code>create database public;</code>
	 * 
	 * 
	 * @param fileName the {@link Parameters}
	 */
	public MySQLLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:mysql://localhost:3306/public";
		username = "root";
		password = "password";
	}

	@Before
	public void removeSchema() throws Exception {
		//Work around to delete a schema in MySQL (since a schema is a database)
		//before running  tests.
		applyChangeLog("update/update-clean-utils/run.schema.clean.changelog.xml") ;
	}
}
