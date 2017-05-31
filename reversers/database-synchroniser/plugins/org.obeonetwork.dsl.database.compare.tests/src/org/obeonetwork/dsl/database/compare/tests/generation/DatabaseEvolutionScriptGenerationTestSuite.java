package org.obeonetwork.dsl.database.compare.tests.generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;
import org.obeonetwork.dsl.database.compare.tests.transformation.DatabaseTransformationTestSuite;
import org.obeonetwork.dsl.database.dbevolution.ColumnChange;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseEvolutionScriptGenerationTest.class })
public class DatabaseEvolutionScriptGenerationTestSuite extends DatabaseCompareAbstractTestSuite {

	/**
	 * The singleton. Only really needed because static methods cannot be
	 * abstract.
	 */
	static DatabaseEvolutionScriptGenerationTestSuite INSTANCE = new DatabaseEvolutionScriptGenerationTestSuite();

	/**
	 * The constructor.
	 */
	private DatabaseEvolutionScriptGenerationTestSuite() {
		// Private constructor for singleton.
	}

	public List<File> loadAndProcessInputs(List<URI> inputURIs, List<String> expectedFileNames) {
		// Load input data for the test
		final Resource dbevolutionResource = DatabaseCompareAbstractTestSuite.loadResource(inputURIs.get(0));		

		List<File> generatedFiles = generateEvolutionScripts((Comparison) dbevolutionResource.getContents().get(0));

		// Place scripts in some file
		return generatedFiles;
	}

	private List<File> generateEvolutionScripts(Comparison dbevolution) {
		final File targetBaseFolder = new File("sql-gen/");
		System.out.println("Generating to: " + targetBaseFolder.getAbsolutePath());

		// // Initialize a resourceset to be sure the model is contained within
		// a
		// // resource (or Acceleo will throw a NPE)
		// ResourceSet set = new ResourceSetImpl();
		// Resource resource = new ResourceImpl();
		// resource.getContents().add(dbevolution);
		// set.getResources().add(resource);

		List<File> generatedFiles = new ArrayList<>();
		try {
			DatabaseGen databaseGen = new DatabaseGen(dbevolution, targetBaseFolder, Collections.emptyList());
			databaseGen.doGenerate(new BasicMonitor());
			// for (String maybeGeneratedFileName : DatabaseGen.SQL_FILES) {
			// File maybeGeneratedFile = new File(databaseGen.getTargetFolder(),
			// maybeGeneratedFileName);
			// if (maybeGeneratedFile.exists()) {
			// generatedFiles.add(maybeGeneratedFile);
			// }
			// }
			generatedFiles.add(new File(databaseGen.getTargetFolder(), "all.sql"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedFiles;
	}

	@Override
	public List<String> getNamesOfInputFiles() {
		ArrayList<String> namesOfInputFiles = new ArrayList<String>();
		// dbevolution.xmi
		namesOfInputFiles.addAll(DatabaseTransformationTestSuite.INSTANCE.getNamesOfExpectedOutputFiles());
		return namesOfInputFiles;
	}

	@Override
	public List<String> getNamesOfExpectedOutputFiles() {
		ArrayList<String> namesExpectedOutputFiles = new ArrayList<String>();
		namesExpectedOutputFiles.add("all.sql");
		return namesExpectedOutputFiles;
	}

	@Override
	public String getPathPrefix() {
		return "/data";
	}
}
