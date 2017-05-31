package org.obeonetwork.dsl.database.compare.tests.comparison;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;
import org.obeonetwork.dsl.database.compare.tests.utils.EMFCompareUtils;

/**
 * The test suite for the comparison of two {@link DataBase} models.
 * 
 * @author Florent Latombe
 *         <a href= "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DatabaseComparisonTest.class })
public class DatabaseComparisonTestSuite extends DatabaseCompareAbstractTestSuite {

	/**
	 * The singleton. Only really needed because static methods cannot be
	 * abstract.
	 */
	public static DatabaseComparisonTestSuite INSTANCE = new DatabaseComparisonTestSuite();

	/**
	 * The constructor.
	 */
	private DatabaseComparisonTestSuite() {
		// Private constructor for singleton.
	}

	/**
	 * Loads the input models found at the given URIs. Then processes their
	 * contents and places the result in a new Resource with the given desired
	 * URI. That URI is the same as the URI of the expected output model, so
	 * that EMF Compare has no problem matching the resources. This method
	 * <i>does not</i> modify the input models.
	 *
	 * @param inputURI
	 *            the URI of the input model.
	 * @param desiredSynchronizedInputURI
	 *            the desired URI for the result of the processing of the inputs
	 *            of this test suite. Should be the same as that of the expected
	 *            output.
	 * @return the resource containing the result of processing the inputs of
	 *         this test suite.
	 */
	public Resource loadAndProcessInputs(List<URI> inputURIs, URI desiredProcessedInputURI) {
		// Load input data for the test
		final Resource leftDatabaseResource = DatabaseCompareAbstractTestSuite.loadResource(inputURIs.get(0));
		final Resource rightDatabaseResource = DatabaseCompareAbstractTestSuite.loadResource(inputURIs.get(1));

		// Compare the Database models
		final DataBase leftDatabase = (DataBase) leftDatabaseResource.getContents().get(0);
		final DataBase rightDatabase = (DataBase) rightDatabaseResource.getContents().get(0);
		final Comparison comparison = EMFCompareUtils.compare(leftDatabase, rightDatabase);

		// Store the resulting Comparison into an EMF Resource
		final Resource comparisonResource = DatabaseCompareAbstractTestSuite.createResourceSet()
				.createResource(desiredProcessedInputURI);
		comparisonResource.getContents().add(comparison);

		return comparisonResource;
	}

	@Override
	public List<String> getNamesOfInputFiles() {
		ArrayList<String> namesOfInputFiles = new ArrayList<String>();
		namesOfInputFiles.add("left.database");
		namesOfInputFiles.add("right.database");
		return namesOfInputFiles;
	}

	@Override
	public List<String> getNamesOfExpectedOutputFiles() {
		ArrayList<String> namesExpectedOutputFiles = new ArrayList<String>();
		namesExpectedOutputFiles.add("comparison.xmi");
		return namesExpectedOutputFiles;
	}

	@Override
	public String getPathPrefix() {
		return "/data";
	}

}
