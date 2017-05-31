package org.obeonetwork.dsl.database.compare.tests.transformation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.database.compare.extensions.processor.DatabasePostProcessor;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;
import org.obeonetwork.dsl.database.compare.tests.comparison.DatabaseComparisonTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseTransformationTest.class })
public class DatabaseTransformationTestSuite extends DatabaseCompareAbstractTestSuite {

	/**
	 * The singleton. Only really needed because static methods cannot be
	 * abstract.
	 */
	public static DatabaseTransformationTestSuite INSTANCE = new DatabaseTransformationTestSuite();

	/**
	 * The constructor.
	 */
	private DatabaseTransformationTestSuite() {
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
		final Resource comparisonResource = DatabaseCompareAbstractTestSuite.loadResource(inputURIs.get(2));
		EcoreUtil.resolveAll(comparisonResource);

		// Transform the EMFCompare Comparison into a Dbevolution model.
		final Comparison comparison = (Comparison) comparisonResource.getContents().get(0);
		final Comparison dbevolution = transform(comparison);

		// Store the resulting Dbevolution into an EMF Resource
		final Resource dbevolutionResource = DatabaseCompareAbstractTestSuite.createResourceSet()
				.createResource(desiredProcessedInputURI);
		dbevolutionResource.getContents().add(dbevolution);

		return dbevolutionResource;
	}

	private Comparison transform(Comparison originalComparison) {
		IPostProcessor transformer = new DatabasePostProcessor();

		Comparison comparison = EcoreUtil.copy(originalComparison);

		transformer.postComparison(comparison, null);
		return comparison;
	}

	@Override
	public List<String> getNamesOfInputFiles() {
		ArrayList<String> namesOfInputFiles = new ArrayList<String>();
		// left.database and right.database
		namesOfInputFiles.addAll(DatabaseComparisonTestSuite.INSTANCE.getNamesOfInputFiles());
		// comparison.xmi
		namesOfInputFiles.addAll(DatabaseComparisonTestSuite.INSTANCE.getNamesOfExpectedOutputFiles());
		return namesOfInputFiles;
	}

	@Override
	public List<String> getNamesOfExpectedOutputFiles() {
		ArrayList<String> namesExpectedOutputFiles = new ArrayList<String>();
		namesExpectedOutputFiles.add("dbevolution.xmi");
		return namesExpectedOutputFiles;
	}

	@Override
	public String getPathPrefix() {
		return "/data";
	}

}
