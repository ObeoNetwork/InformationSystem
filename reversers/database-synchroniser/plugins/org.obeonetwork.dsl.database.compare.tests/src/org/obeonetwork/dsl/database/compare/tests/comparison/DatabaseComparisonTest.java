package org.obeonetwork.dsl.database.compare.tests.comparison;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite.TestFilesNature;
import org.obeonetwork.dsl.database.compare.tests.utils.EMFUtils;
import org.obeonetwork.dsl.database.compare.tests.utils.ResourceWrapper;

@RunWith(Parameterized.class)
public class DatabaseComparisonTest {

	private ResourceWrapper expectedResourceWrapper;
	private ResourceWrapper actualResourceWrapper;

	/**
	 * The constructor.
	 * 
	 * @param expectedResourceWrapper
	 * @param actualResourceWrapper
	 */
	public DatabaseComparisonTest(ResourceWrapper expectedResourceWrapper, ResourceWrapper actualResourceWrapper) {
		this.expectedResourceWrapper = expectedResourceWrapper;
		this.actualResourceWrapper = actualResourceWrapper;
	}

	/**
	 * Provides the parameters for the {@link DatabaseComparisonTest} instances.
	 *
	 * @return as many arrays of parameters as the number of
	 *         {@link DatabaseComparisonTest} instances that will be created and
	 *         run.
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> getParameters() {
		return DatabaseComparisonTest.getActualModelAndExpectedOutputModel((inputURIs, expectedOutputURI) -> {
			return DatabaseComparisonTestSuite.INSTANCE.loadAndProcessInputs(inputURIs, expectedOutputURI);
		}, (inputURIs, expectedOutputURI) -> {
			return DatabaseComparisonTestSuite.loadResource(expectedOutputURI);
		}, (inputURIs, expectedOutputURI) -> {
			return "compare(left, right)+expected";
		});
	}

	/**
	 * Provides the parameters for the {@link DatabaseComparisonTest} instances.
	 *
	 * @param actualModelResourceRetriever
	 *            the function that takes a directory as input and returns the
	 *            file within that directory that must be used as a the test
	 *            input.
	 *
	 * @return as many arrays of parameters as the number of
	 *         {@link DatabaseComparisonTest} instances that will be created and
	 *         run.
	 */
	private static Collection<Object[]> getActualModelAndExpectedOutputModel(
			BiFunction<List<URI>, URI, Resource> actualModelResourceRetriever,
			BiFunction<List<URI>, URI, Resource> expectedOutputModelResourceRetriever,
			BiFunction<List<URI>, URI, String> testLabelRetriever) {
		final List<File> subDirectoriesWithTestFiles = DatabaseComparisonTestSuite.INSTANCE
				.recursivelyFindSubdirectoriesWithInputAndExpectedOutputFiles(
						new File(DatabaseCompareAbstractTestSuite.USER_DIRECTORY
								+ DatabaseComparisonTestSuite.INSTANCE.getPathPrefix()));

		final Collection<Object[]> collectionOfTestParameters = new ArrayList<Object[]>();

		for (final File directoryContainingTestInputs : subDirectoriesWithTestFiles) {
			final File expectedOutputFile = DatabaseComparisonTestSuite.INSTANCE
					.getFilesOfNature(TestFilesNature.EXPECTED_OUTPUT, directoryContainingTestInputs).get(0);
			final URI expectedOutputURI = DatabaseCompareAbstractTestSuite.toURI(directoryContainingTestInputs.getPath()
					+ DatabaseCompareAbstractTestSuite.SEPARATOR + expectedOutputFile.getName());

			final List<File> inputFiles = DatabaseComparisonTestSuite.INSTANCE.getFilesOfNature(TestFilesNature.INPUT,
					directoryContainingTestInputs);
			final List<URI> inputURIs = inputFiles.stream()
					.map(inputFile -> DatabaseCompareAbstractTestSuite.toURI(directoryContainingTestInputs.getPath()
							+ DatabaseCompareAbstractTestSuite.SEPARATOR + inputFile.getName()))
					.collect(Collectors.toList());

			final Resource expectedOutputResource = expectedOutputModelResourceRetriever.apply(inputURIs,
					expectedOutputURI);
			final Resource actualResource = actualModelResourceRetriever.apply(inputURIs, expectedOutputURI);

			collectionOfTestParameters.add(new Object[] {
					new ResourceWrapper(expectedOutputResource, testLabelRetriever.apply(inputURIs, expectedOutputURI),
							DatabaseComparisonTestSuite.INSTANCE.getPathPrefix()),
					new ResourceWrapper(actualResource, testLabelRetriever.apply(inputURIs, expectedOutputURI),
							DatabaseComparisonTestSuite.INSTANCE.getPathPrefix()) });
		}
		return collectionOfTestParameters;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDatabaseComparison() {
		Comparison expected = (Comparison) this.expectedResourceWrapper.getResource().getContents().get(0);
		Comparison actual = (Comparison) this.actualResourceWrapper.getResource().getContents().get(0);

		try {
			// Comparing Comparisons using EMFCompare does not seem to do well.
			// We thus compare the Comparisons in a rough way manually, errors
			// can
			// be caught in later stages.
			DatabaseComparisonTestSuite.INSTANCE.compareComparisons(expected, actual);

			// Only check for the same number of matches... :-/
			assertEquals(EMFUtils.getAllContentsOfType(ComparePackage.Literals.MATCH, expected).size(),
					EMFUtils.getAllContentsOfType(ComparePackage.Literals.MATCH, actual).size());
		} catch (AssertionError e) {
			System.out.println("Actual model being used for comparison:");
			try {
				this.actualResourceWrapper.getResource().save(System.out, null);
			} catch (final IOException ex) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Expected model being used for comparison: (from: "
					+ this.expectedResourceWrapper.toString() + ")");
			try {
				this.expectedResourceWrapper.getResource().save(System.out, null);
			} catch (final IOException ex) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw e;
		}
	}
}
