package org.obeonetwork.dsl.database.compare.tests.generation;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite.TestFilesNature;
import org.obeonetwork.dsl.database.compare.tests.utils.FilesWrapper;

@RunWith(Parameterized.class)
public class DatabaseEvolutionScriptGenerationTest {

	private FilesWrapper expectedGeneratedFilesWrapper;
	private FilesWrapper actualGeneratedFilesWrapper;

	/**
	 * The constructor.
	 * 
	 * @param expectedResourceWrapper
	 * @param actualResourceWrapper
	 */
	public DatabaseEvolutionScriptGenerationTest(FilesWrapper expectedGeneratedFilesWrapper,
			FilesWrapper actualGeneratedFilesWrapper) {
		this.expectedGeneratedFilesWrapper = expectedGeneratedFilesWrapper;
		this.actualGeneratedFilesWrapper = actualGeneratedFilesWrapper;
	}

	/**
	 * Provides the parameters for the
	 * {@link DatabaseEvolutionScriptGenerationTest} instances.
	 *
	 * @return as many arrays of parameters as the number of
	 *         {@link DatabaseEvolutionScriptGenerationTest} instances that will
	 *         be created and run.
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> getParameters() {
		return DatabaseEvolutionScriptGenerationTest
				.getActualModelAndExpectedOutputModel((inputURIs, expectedFileNames) -> {
					return DatabaseEvolutionScriptGenerationTestSuite.INSTANCE.loadAndProcessInputs(inputURIs,
							expectedFileNames);
				}, (inputURIs, expectedOutputPaths) -> {
					return inputURIs.get(0).lastSegment() + "+" + DatabaseEvolutionScriptGenerationTestSuite.INSTANCE.getNamesOfExpectedOutputFiles();
				});
	}

	/**
	 * Provides the parameters for the
	 * {@link DatabaseEvolutionScriptGenerationTest} instances.
	 *
	 * @param actualGeneratedFilesRetriever
	 *            the function that takes a directory as input and returns the
	 *            file within that directory that must be used as a the test
	 *            input.
	 *
	 * @return as many arrays of parameters as the number of
	 *         {@link DatabaseEvolutionScriptGenerationTest} instances that will
	 *         be created and run.
	 */
	private static Collection<Object[]> getActualModelAndExpectedOutputModel(
			BiFunction<List<URI>, List<String>, List<File>> actualGeneratedFilesRetriever,
			BiFunction<List<URI>, List<String>, String> testLabelRetriever) {
		final List<File> subDirectoriesWithTestFiles = DatabaseEvolutionScriptGenerationTestSuite.INSTANCE
				.recursivelyFindSubdirectoriesWithInputAndExpectedOutputFiles(
						new File(DatabaseCompareAbstractTestSuite.USER_DIRECTORY
								+ DatabaseEvolutionScriptGenerationTestSuite.INSTANCE.getPathPrefix()));

		final Collection<Object[]> collectionOfTestParameters = new ArrayList<Object[]>();

		for (final File directoryContainingTestInputs : subDirectoriesWithTestFiles) {
			final List<File> expectedOutputFiles = DatabaseEvolutionScriptGenerationTestSuite.INSTANCE
					.getFilesOfNature(TestFilesNature.EXPECTED_OUTPUT, directoryContainingTestInputs);
			final List<String> expectedGeneratedFileNames = expectedOutputFiles.stream().map(file -> file.getName())
					.collect(Collectors.toList());

			final List<File> inputFiles = DatabaseEvolutionScriptGenerationTestSuite.INSTANCE
					.getFilesOfNature(TestFilesNature.INPUT, directoryContainingTestInputs);
			final List<URI> inputURIs = inputFiles.stream()
					.map(inputFile -> DatabaseCompareAbstractTestSuite.toURI(directoryContainingTestInputs.getPath()
							+ DatabaseCompareAbstractTestSuite.SEPARATOR + inputFile.getName()))
					.collect(Collectors.toList());

			final List<File> actualGeneratedFiles = actualGeneratedFilesRetriever.apply(inputURIs,
					expectedGeneratedFileNames);

			collectionOfTestParameters.add(new Object[] {
					new FilesWrapper(expectedOutputFiles,
							testLabelRetriever.apply(inputURIs, expectedGeneratedFileNames),
							DatabaseEvolutionScriptGenerationTestSuite.INSTANCE.getPathPrefix()),
					new FilesWrapper(actualGeneratedFiles,
							testLabelRetriever.apply(inputURIs, expectedGeneratedFileNames),
							DatabaseEvolutionScriptGenerationTestSuite.INSTANCE.getPathPrefix()), });
		}
		return collectionOfTestParameters;
	}

	@Test
	public void testScriptsGeneration() throws IOException {
		// Check the actually generated file names are the same as the expected
		// ones.
		assertEquals("The generated files and the expected files do not have the same names.",
				this.expectedGeneratedFilesWrapper.getFileNames(), this.actualGeneratedFilesWrapper.getFileNames());

		// For every file, check the content is the same in the similarly-named
		// file.
		for (String fileName : this.actualGeneratedFilesWrapper.getFileNames()) {
			File actualFile = this.actualGeneratedFilesWrapper.getFile(fileName);
			File expectedFile = this.expectedGeneratedFilesWrapper.getFile(fileName);

			List<String> actualContents = Files.readAllLines(actualFile.toPath());
			List<String> expectedContents = Files.readAllLines(expectedFile.toPath());
			assertEquals(
					"[" + fileName + "]The generated file has " + actualContents.size()
							+ " lines while the expected file has " + expectedContents.size() + " lines.",
					expectedContents.size(), actualContents.size());

			for (int i = 0; i < expectedContents.size(); i++) {
				String actualLine = actualContents.get(i);
				String expectedLine = expectedContents.get(i);
				assertEquals("Line " + i + " of the *actual* generated file:\n" + actualLine + "\nLine " + i
						+ " of the *expected* generated file:\n" + expectedLine, expectedLine, actualLine);
			}
		}
	}
}
