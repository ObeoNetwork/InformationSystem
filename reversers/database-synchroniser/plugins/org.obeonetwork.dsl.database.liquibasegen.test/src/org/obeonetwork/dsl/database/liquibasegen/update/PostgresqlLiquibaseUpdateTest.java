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
public class PostgresqlLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {
	
	/**
	 * Requires a Postgresql server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run --name -d postgresInstance -p 5432:5432 -e POSTGRES_PASSWORD=password postgres</code>
	 * @param fileName the {@link Parameters}
	 * @throws Exception 
	 */
	public PostgresqlLiquibaseUpdateTest(String fileName) throws Exception {	
		super(fileName);		
		url = "jdbc:postgresql://localhost:5432/";
		username = "postgres";
		password = "password";
	}
	
	@Before
	public void removeSchema() throws Exception {
		//Delete a schema used in test in H2 database if existing before running  tests.
		//Since liquibase.dropAll() doesn't drop all schemas.
		applyChangeLog("update/update-clean-utils/run.schema.clean.changelog.xml") ;
	}
}
