/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
public class MariaDBLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {
	
	/**
	 * Requires a MySQL server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run -p 3306:3306 --name mariadb10 -e MARIADB_ROOT_PASSWORD=password -d mariadb:10-focal</code>
	 * @param fileName the {@link Parameters}
	 */
	public MariaDBLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:mariadb://localhost:3306/public";
		username = "root";
		password = "password";
	}

}
