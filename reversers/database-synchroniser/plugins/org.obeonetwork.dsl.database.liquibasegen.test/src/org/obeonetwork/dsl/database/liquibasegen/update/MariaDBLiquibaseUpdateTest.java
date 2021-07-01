package org.obeonetwork.dsl.database.liquibasegen.update;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
