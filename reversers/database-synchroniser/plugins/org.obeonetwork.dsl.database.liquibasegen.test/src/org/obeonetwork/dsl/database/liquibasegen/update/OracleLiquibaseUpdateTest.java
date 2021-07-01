package org.obeonetwork.dsl.database.liquibasegen.update;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author tbezierslafosse
 *
 */
@RunWith(Parameterized.class)
public class OracleLiquibaseUpdateTest extends AbstractLiquibaseUpdateTest {	
	/**
	 * Requires a H2 server to be running. You can check the Docker configuration in org.obeonetwork.dsl.database.test
	 * <code>docker run --name h21.4.198 -p 1521:1521 -p 81:81 -v <absoluteURI>:/opt/h2-data -e H2_OPTIONS='-ifNotExists' -d thibaultblf/h2:1.4.199</code>
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
		return Arrays.asList(	"update-oracle/01-create-table/run.changelog.xml",
								"update/02-primary-key/run.changelog.xml",
								"update/03-foreign-key/run.changelog.xml",
								"update/04-sequence/run.changelog.xml",
								"update/05-index/run.changelog.xml");
	}
	
}
