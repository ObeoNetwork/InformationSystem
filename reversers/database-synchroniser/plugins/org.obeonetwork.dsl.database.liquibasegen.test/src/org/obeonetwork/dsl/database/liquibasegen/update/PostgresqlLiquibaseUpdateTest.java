/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
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
