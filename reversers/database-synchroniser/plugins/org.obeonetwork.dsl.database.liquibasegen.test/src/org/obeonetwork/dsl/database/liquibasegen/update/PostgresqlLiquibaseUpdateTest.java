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
	 */
	public PostgresqlLiquibaseUpdateTest(String fileName) {
		super(fileName);
		url = "jdbc:postgresql://localhost:5432/";
		username = "postgres";
		password = "password";
	}

}
