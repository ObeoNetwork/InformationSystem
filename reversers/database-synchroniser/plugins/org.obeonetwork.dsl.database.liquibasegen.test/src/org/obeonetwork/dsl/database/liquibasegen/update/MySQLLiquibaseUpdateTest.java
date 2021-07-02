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
public class MySQLLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {
	
	/**
	 * Requires a MySQL server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run --name mysql5 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test mysql:5.7</code>
	 * @param fileName the {@link Parameters}
	 */
	public MySQLLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:mysql://localhost:3306/public";
		username = "root";
		password = "password";
	}

}
