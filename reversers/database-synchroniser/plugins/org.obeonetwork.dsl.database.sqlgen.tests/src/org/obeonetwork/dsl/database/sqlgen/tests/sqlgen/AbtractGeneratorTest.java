package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;
import org.obeonetwork.dsl.database.sqlgen.tests.AbtractTest;

public abstract class AbtractGeneratorTest extends AbtractTest {

	protected class GeneratedFile{
		String fileName;
		String expectedFile;
		public GeneratedFile(String fileName, String expectedFile) {
			super();
			this.fileName = fileName;
			this.expectedFile = expectedFile;
		}		
	}
	
	protected void assertSQL(AcceleoTextGenerationListener acceleoTextGenerationListener, GeneratedFile...generatedFiles) throws Exception {	
		assertTrue(generatedFiles.length <= acceleoTextGenerationListener.getFileNames().size());
		for(GeneratedFile generatedFile : generatedFiles){
			assertTrue(generatedFile.fileName+" not found.",acceleoTextGenerationListener.getFileNames().contains(generatedFile.fileName));
			String actualSQL = acceleoTextGenerationListener.getBody(generatedFile.fileName).trim();

			System.out.println("[\n" + actualSQL + "\n]\n");

			InputStream expectedStream = getClass().getClassLoader().getResourceAsStream(generatedFile.expectedFile);
			assertNotNull(expectedStream);
			BufferedReader expectedReader = new BufferedReader(new InputStreamReader(expectedStream));
			BufferedReader actualReader = new BufferedReader(new StringReader(actualSQL));
			int line = 0;
			while (expectedReader.ready()) {
				String expectedLine = expectedReader.readLine();
				String actualLine = actualReader.readLine();
				assertEquals("Line " + line + " in expected file ("+generatedFile.fileName+")not match", expectedLine, actualLine);
				line++;
			}
			assertNull("Expected content after line: " + line+" for "+generatedFile.fileName, expectedReader.readLine());
			assertNull("Generated content after line: " + line+" for "+generatedFile.fileName, actualReader.readLine());	
		}
	}
	
	protected AcceleoTextGenerationListener generate(Comparison databaseChangeSet, File folder) throws Exception {
		SQLGenerator sqlGen = createGenerator(databaseChangeSet, folder);		
		PreviewStrategy strategy = new PreviewStrategy();
		sqlGen.setGenerationStrategy(strategy);
		AcceleoTextGenerationListener listener = new AcceleoTextGenerationListener();
		sqlGen.addGenerationListener(listener);
		sqlGen.doGenerate(new BasicMonitor());
		return listener;
	}

	protected void assertGen(String testCase, String genFileName) throws Exception {
		Comparison databaseChangeSet = diff(testCase + "/v2.database", testCase + "/v1.database");
		File folder = new File("testFolder");
		AcceleoTextGenerationListener acceleoTextGenerationListener = generate(databaseChangeSet, folder);
		String path = folder.getAbsolutePath()+ File.separator + "" + getTimeStamp() + File.separator;
		GeneratedFile generatedFile = new GeneratedFile(path + genFileName, testCase + File.separator + "expected.sql");
		assertSQL(acceleoTextGenerationListener, generatedFile );
	}
	
	protected void assertGen(String testCase, GeneratedFile...generatedFiles) throws Exception {
		Comparison databaseChangeSet = diff(testCase + "/v2.database", testCase + "/v1.database");
		File folder = new File("testFolder");
		AcceleoTextGenerationListener acceleoTextGenerationListener = generate(databaseChangeSet, folder);		
		assertSQL(acceleoTextGenerationListener, generatedFiles );
	}
	
	private String getTimeStamp() {
		java.sql.Timestamp timeStampDate = new Timestamp(System.currentTimeMillis()); 
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	return formatter.format(timeStampDate);
	}
	

	protected abstract SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception;

	protected ArrayList<String>  getArguments(){
		ArrayList<String> arguments = new ArrayList<String>();	
		return arguments;
	}
}
