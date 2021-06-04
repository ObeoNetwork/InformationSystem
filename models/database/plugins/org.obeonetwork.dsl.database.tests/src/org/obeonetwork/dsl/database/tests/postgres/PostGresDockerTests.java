package org.obeonetwork.dsl.database.tests.postgres;

import org.junit.Test;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;
import org.testcontainers.containers.GenericContainer;

/**
 * Requires: .testcontainers.properties in your ~/
 * docker-machine in your PATH. Can be installed with `choco install docker-machine` on windows 
 * @author tbezierslafosse
 *
 */
public class PostGresDockerTests {
	private static final String POSTGRES_HOST_DEFAULT = "0.0.0.0";
	
	private static final String POSTGRES_PORT_DEFAULT = "5432";
	
	private static final String POSTGRES_USERNAME_DEFAULT = "postgres";
	
	private static final String POSTGRES_PASSWORD_DEFAULT = "password";
	
	@Test
	public void importPostgreSQL9() {
		
		GenericContainer postgres9 = new GenericContainer("postgres:9.5-alpine")				
		   .withExposedPorts(5432);
		
		postgres9.start();
	}
}
