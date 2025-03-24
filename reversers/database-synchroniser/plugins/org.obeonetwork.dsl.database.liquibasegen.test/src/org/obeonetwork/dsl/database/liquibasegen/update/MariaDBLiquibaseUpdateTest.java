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
package org.obeonetwork.dsl.database.liquibasegen.update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class MariaDBLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {
	
	/**
	 * Requires a Mariadb server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * A database named public must be (existing or) created too.
	 * <code>docker run -p 3306:3306 --name mariadb10 -e MARIADB_ROOT_PASSWORD=password -d mariadb:10-focal</code>
	 * Within the container create database with commands:
	 * <code>mariadb --user=root --password=password</code>
	 * <code>create database public;</code>
	 * 
	 * @param fileName the {@link Parameters}drop 
	 */
	public MariaDBLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:mariadb://localhost:3306/public";
		username = "root";
		password = "password";
	}
	
	@Before
	public void removeSchema() throws Exception {
		//Work around to delete a schema in mariadb (since a schema is a database)
		//before running  tests.
		applyChangeLog("update/update-clean-utils/run.schema.clean.changelog.xml") ;
	}

}
