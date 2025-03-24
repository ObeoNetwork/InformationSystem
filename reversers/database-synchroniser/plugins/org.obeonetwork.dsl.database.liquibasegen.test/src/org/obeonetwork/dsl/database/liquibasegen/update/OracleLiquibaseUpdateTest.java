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
public class OracleLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {	
	/**
	 * Requires a clean Oracle server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * 
	 * For the Docker commands below to succeed, an Oracle account will be necessary to pull the image.
	 * Furthermore, accepting (after login with an Oracle account) the Oracle license agreement on site: 
	 * https://container-registry.oracle.com/ords/ocr/ba/database/enterprise
	 * is mandatory to get the authorization to pull the image.
	 * 
	 * <code>docker login container-registry.oracle.com</code>
	 * <code>docker run -d -it --name oracle -v <localRepo>:/ORCL -p 1521:1521 container-registry.oracle.com/database/database-enterprise:12.2.0.1</code>
	 * 
	 * Once the oracle instance is running, set SYSTEM's password with following commands (to run inside the container):
	 * <code>export ORACLE_SID=ORCLCDB</code>
	 * <code>/u01/app/oracle/product/12.2.0/dbhome_1/bin/sqlplus / as SYSDBA</code>
	 * <code>conn SYSTEM/Oradoc_db1 as sysdba</code>
	 * <code>quit</code>
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
		return Arrays.asList(
								"update/update-oracle/01-create-table/run.changelog.xml",
								"update/update-oracle/02-primary-key/run.changelog.xml",
								"update/update-oracle/03-foreign-key/run.changelog.xml",
								"update/update-oracle/04-sequence/run.changelog.xml",
								"update/update-oracle/05-index/run.changelog.xml");
	}
	
	@Before
	public void clearDatabaseTables() throws Exception {
		//Workaround to delete tables in oracle database before running each test.
		//since liquibase.dropAll() doesn't drop tables.
		applyChangeLog("update/update-clean-utils/run.oracle.tables.clean.changelog.xml") ;
	}
	
}