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
	 * @param fileName the {@link Parameters}
	 * @throws Exception 
	 */
	public PostgresqlLiquibaseUpdateTest(String fileName) throws Exception {	
		super(fileName);		
		url = "jdbc:postgresql://localhost:5432/";
		username = "postgres";
		password = "password";
	}
}
