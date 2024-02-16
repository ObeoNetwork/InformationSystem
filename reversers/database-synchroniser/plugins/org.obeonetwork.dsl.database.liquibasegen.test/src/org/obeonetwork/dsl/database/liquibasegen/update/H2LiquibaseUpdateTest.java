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
 */
@RunWith(Parameterized.class)
public class H2LiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {	
	/**
	 * Requires a H2 server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run --name h21.4.198 -p 1521:1521 -p 81:81 -v <absoluteURI>:/opt/h2-data -e H2_OPTIONS='-ifNotExists' -d thibaultblf/h2:1.4.199</code>
	 * @param fileName the {@link Parameters}
	 */
	public H2LiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:h2:tcp://localhost:1521/test";
		username = "sa";
		password = "";
	}
	
	@Before
	public void removeSchema() throws Exception {
		//Delete a schema used in test in H2 database if existing before running  tests.
		//Since liquibase.dropAll() doesn't drop all schemas.
		applyChangeLog("update/update-clean-utils/run.schema.clean.changelog.xml") ;
	}
}
