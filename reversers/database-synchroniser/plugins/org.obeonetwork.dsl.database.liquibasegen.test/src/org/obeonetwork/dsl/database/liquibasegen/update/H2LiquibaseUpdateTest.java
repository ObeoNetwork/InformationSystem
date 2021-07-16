package org.obeonetwork.dsl.database.liquibasegen.update;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
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
}
