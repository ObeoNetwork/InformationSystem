/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.update;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Obeo
 *         
 */
@RunWith(Parameterized.class)
public class OracleLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {	
	/**
	 * Requires a clean Oracle server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run -d -it --name oracle -v <localRepo>:/ORCL -p 1521:1521 store/oracle/database-enterprise:12.2.0.1</code>
	 * 
	 * @param fileName the {@link Parameters}
	 */
	public OracleLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
		username = "SYSTEM";
		password = "Oradoc_db1";		
	}
	
	@Parameters
	public static List<String> parameters() {
		return Arrays.asList(	"update/update-oracle/01-create-table/run.changelog.xml",
								"update/update-oracle/02-primary-key/run.changelog.xml",
								"update/update-oracle/03-foreign-key/run.changelog.xml",
								"update/update-oracle/04-sequence/run.changelog.xml",
								"update/update-oracle/05-index/run.changelog.xml");
	}
	
}
