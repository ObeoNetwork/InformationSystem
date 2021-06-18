package org.obeonetwork.dsl.database.tests.h2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

@RunWith(Parameterized.class)
public class H2DockerTests {
	
	private static final Object H2_PORT_DEFAULT = "1521";
	private static final Object H2_WEBPORT_DEFAULT = "81";
	private static final String H2_HOST_DEFAULT = "localhost";
	private static final String H2_USERNAME_DEFAULT = "h2";
	private static final String H2_PASSWORD_DEFAULT = "password";
	private static final String H2_DATABASE_MODEL_REFERENCE_PATH = "resources/h2_outputRef.database";
	private static final String H2_PATH_TO_LOCAL_DATABASE = "resources/h2-db";
	private static final String JDBC_H2_URL_PATTERN = "jdbc:h2:tcp://%1$s:%2$s/%3$s";
	
	private Database database;
	private final String containerName; 
	private final String containerImage;
	
	/**
	 * The {@link String} parameter is provided through the {@link Parameterized} JUnit Runner. 
	 */
	public H2DockerTests(String containerImage) {		
		this.containerImage = containerImage;
		String cleanedName = containerImage.replace(':', '_');
		cleanedName = cleanedName.replace('/', '_');
		this.containerName = cleanedName; // container name cannot contain the ':' character, often used in Docker images.		
	}
		
	/**
	 * {@link https://github.com/oscarfonts/docker-h2}
	 * @return
	 */
	@Parameters( name = "{0}")
	public static Collection<String> postgreSQLVersions() {
		return Arrays.asList(   "oscarfonts/h2:1.4.199",
								"oscarfonts/h2:1.4.197",
								"oscarfonts/h2:1.4.196",								
								"oscarfonts/h2:1.3.176",
								"oscarfonts/h2:1.1.119"
							);
	}

	@Test
	public void testImportPostgres() throws IOException, LiquibaseException {
		String url = String.format(JDBC_H2_URL_PATTERN, H2_HOST_DEFAULT, H2_PORT_DEFAULT, H2_USERNAME_DEFAULT, true);
		
        database = TestUtils.openDatabaseConnection("jdbc:h2:tcp://localhost:1521/test", "sa", "");
		TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
				
		DataSource dataSource = new DataSource(H2_USERNAME_DEFAULT, "PUBLIC");
		dataSource.setJdbcUsername("sa");
		dataSource.setJdbcUrl("jdbc:h2:tcp://localhost:1521/test");
		dataSource.setVendor(DatabaseConstants.DB_H2_13);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);			
		String modelRefURI = "resources/"+containerName+"/h2_outputRef.database";
		
		if (new File(modelRefURI).exists())	{
			DataBase databaseRef = TestUtils.loadModel(modelRefURI, TypesLibraryUtil.H2_PATHMAP);	
			H2Tests.prepareH2RefModel(databaseRef, database);
			TestUtils.checkEquality(database, databaseRef);
		} else {
			// No reference model have been provided for the testing. 
			// We instead save the model produced, 
			// that should be verified by the tester and used as a reference later.
			TestUtils.saveModel(database, modelRefURI); 
		}			
	}
	

	@Before
	public void testWithPostgresVersion() {
		ProcessBuilder builder = new ProcessBuilder();
		
		File localRepo = new File(String.format("%s/%s", H2_PATH_TO_LOCAL_DATABASE, containerName));
		if (localRepo.exists())
			localRepo.delete();
				
		localRepo.mkdirs();
				
		builder.command("docker", "pull", containerImage); // downloads the docker image if not available
		// starting the container
		builder.command("docker", "run", "--name", containerName, 
				"-p", H2_PORT_DEFAULT+":"+H2_PORT_DEFAULT,
				"-p", H2_WEBPORT_DEFAULT+":"+H2_WEBPORT_DEFAULT,
				"-v", localRepo.getAbsolutePath()+":/opt/h2-data", // mapping a local repo to the container's database repo
				"-e H2_OPTIONS=-ifNotExists",
				"-d", containerImage);
		
		try {
			Process process = builder.start();
			StringBuilder output = new StringBuilder();

	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	        }

	        int exitVal = process.waitFor();
            System.out.println(output);
            Thread.sleep(5000); 
            
            // wait for container to boot if created at the moment. 
            // a better implementation would check the output log until the containers tells its ready
            
	        if (exitVal != 0) {
	        	throw new Exception("Could not initialize docker image: exit code: "+exitVal);
	        }

		} catch (Exception e) {
			Assert.fail(e.toString());
		}		
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("docker", "kill", containerName); // shut down the container
		builder.command("docker", "rm", "-f", containerName); // removes it from docker
		Process process = builder.start();
		process.waitFor();
	}

	
	public static List<? extends Column> getColumnsFromDatabase(DataBase ref) {
		List<Column> columns = ref.getTables().stream()
				.filter(Table.class::isInstance)
				.map(Table.class::cast)
				.map(Table::getColumns)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		return columns;
	}
	 
	
	@AfterClass
	public static void tearDownAfterClass() throws DatabaseException {
		// We do not clear the database since we kill the container instead		
	}	
}
