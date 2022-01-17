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

import java.util.Arrays;
import java.util.List;

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
public class SQLServerLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest{
	
	/**
	 * 
	 * Requires a MS SQL server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test.
	 * A database labelled test must be created too.
	 * <code>docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=password" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest</code>
	 * @param fileName
	 */
	public SQLServerLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:sqlserver://localhost:1433;databaseName=test";
		username = "sa";
		password = "P4sSw0rd";		
	}

	@Parameters
	public static List<String> parameters() {
		return Arrays.asList(	"update/update-mssql/01-create-table/run.changelog.xml",
								"update/update-mssql/02-primary-key/run.changelog.xml",
								"update/update-mssql/03-foreign-key/run.changelog.xml",
								"update/update-mssql/04-sequence/run.changelog.xml",
								"update/update-mssql/05-index/run.changelog.xml");
	}
}
