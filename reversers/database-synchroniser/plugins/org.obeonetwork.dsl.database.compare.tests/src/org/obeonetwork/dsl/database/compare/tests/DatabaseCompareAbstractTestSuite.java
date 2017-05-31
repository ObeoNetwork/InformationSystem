package org.obeonetwork.dsl.database.compare.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.compare.tests.utils.EMFCompareUtils;
import org.obeonetwork.dsl.database.compare.tests.utils.LabeledFunction;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl;

/**
 * Base class for all test suites related to the comparison of {@link DataBase}
 * models, transformation of the comparison result, and generation of the
 * corresponding SQL scripts.
 * 
 * @author Florent Latombe
 *         <a href= "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
public abstract class DatabaseCompareAbstractTestSuite {
	public static final String SEPARATOR = "/";
	public static final String USER_DIRECTORY = System.getProperty("user.dir");

	/**
	 * Provides the base folder containing the test data for this test suite.
	 * 
	 * @return the base folder in which to look for test data.
	 */
	public abstract String getPathPrefix();

	/**
	 * Provides the names (including file extension) of all files used as input
	 * for this test suite.
	 * 
	 * @return the names of the input files used for this test suite.
	 */
	public abstract List<String> getNamesOfInputFiles();

	/**
	 * Provides the names (including file extension) of all files to be used as
	 * the expected outputs for this test suite.
	 * 
	 * @return the names of the expected output files used for this test suite.
	 */
	public abstract List<String> getNamesOfExpectedOutputFiles();

	/**
	 * Recursively finds all sub-directories containing the input and expected
	 * output files of a test.
	 *
	 * @param directory
	 *            the directory in which to search for the sub-directories.
	 * @return the list of directories containing files with fitting names.
	 */
	public List<File> recursivelyFindSubdirectoriesWithInputAndExpectedOutputFiles(File directory) {
		final List<File> subDirectoriesWithTwoViewpointSpecificationModelsWithExpectedNames = new ArrayList<>();
		final List<File> files = Arrays.asList(directory.listFiles());
		for (final File candidateSubdirectory : files) {
			if (candidateSubdirectory.exists() && candidateSubdirectory.isDirectory()) {
				if (getFilesOfNature(TestFilesNature.INPUT, candidateSubdirectory) != null
						&& getFilesOfNature(TestFilesNature.EXPECTED_OUTPUT, candidateSubdirectory) != null) {
					subDirectoriesWithTwoViewpointSpecificationModelsWithExpectedNames.add(candidateSubdirectory);
				} else {
					subDirectoriesWithTwoViewpointSpecificationModelsWithExpectedNames.addAll(
							recursivelyFindSubdirectoriesWithInputAndExpectedOutputFiles(candidateSubdirectory));
				}
			}
		}
		return subDirectoriesWithTwoViewpointSpecificationModelsWithExpectedNames;
	}

	/**
	 * Loads the {@link Resource} with the given file URI in a new ResourceSet.
	 *
	 * @param fileURI
	 *            the file URI of the Resource.
	 * @return the Resource whose file URI is <code>fileURI</code>.
	 */
	public static Resource loadResource(URI fileURI) {
		final ResourceSet resourceSet = createResourceSet();
		final Resource resource = resourceSet.getResource(fileURI, true);
		resource.setURI(URI.createURI(fileURI.toString()));
		return resource;
	}

	/**
	 * Transforms a String path into a file URI.
	 *
	 * @param uriString
	 *            a String like "/path/to/file".
	 * @return the file URI corresponding to <code>uriString</code>.
	 */
	public static URI toURI(String uriString) {
		final String fileUriAsString = uriString.startsWith(USER_DIRECTORY) ? uriString : USER_DIRECTORY + uriString;
		return URI.createFileURI(fileUriAsString);
	}

	/**
	 * Creates a {@link ResourceSet} properly initialized for Database,
	 * Dbevolution, EMFCompare and XMI models.
	 *
	 * @return
	 */
	protected static ResourceSet createResourceSet() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(DatabasePackage.eNS_URI, DatabasePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(DbevolutionPackage.eNS_URI, DbevolutionPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ComparePackage.eNS_URI, ComparePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dbevolution",
				new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("database",
				new DatabaseResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("typeslibrary",
				new XMIResourceFactoryImpl());
		return resourceSet;
	}

	/**
	 * Retrieves the input or expected output files from the given directory.
	 *
	 * @param nature
	 *            the {@link TestFilesNature}.
	 * @param directory
	 *            the directory containing a test's input files and expected
	 *            output files.
	 * @return the input files. Null if the input files could not be found.
	 */
	public List<File> getFilesOfNature(TestFilesNature nature, File directory) {
		List<String> namesOfSoughtFiles = nature == TestFilesNature.INPUT ? this.getNamesOfInputFiles()
				: this.getNamesOfExpectedOutputFiles();
		List<File> filesFound = new ArrayList<>();
		for (String soughtFileName : namesOfSoughtFiles) {
			for (final File candidateFile : Arrays.asList(directory.listFiles())) {
				final String fileName = candidateFile.getName();
				if (fileName.equals(soughtFileName)) {
					filesFound.add(candidateFile);
					break;
				}
			}
		}
		if (filesFound.size() == namesOfSoughtFiles.size()) {
			return filesFound;
		} else {
			return null;
		}
	}

	/**
	 * The test files we may retrieve are either the input files of the test
	 * suite, or its expected output(s).
	 * 
	 * @author Florent Latombe <a href=
	 *         "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
	 *
	 */
	public enum TestFilesNature {
		INPUT, EXPECTED_OUTPUT;
	}

	@SuppressWarnings("unchecked")
	public void compareComparisons(Comparison expected, Comparison actual,
			LabeledFunction<Comparison, Object>... functionsArray) {
		List<LabeledFunction<Comparison, Object>> functionsList = new ArrayList<>(Arrays.asList(functionsArray));
		if (functionsList.isEmpty()) {
			// Check both comparisons have the same number of differences.
			functionsList.add(
					new LabeledFunction<>("Number of differences", comparison -> comparison.getDifferences().size()));
			// Check they use the same concrete types of differences (e.g. from
			// dbevolution metamodel).
			functionsList.add(new LabeledFunction<>("Concrete types of differences",
					comparison -> EMFCompareUtils.getAllDifferenceTypes(comparison.getDifferences()).size()));
			// Check they have the same number of occurrences of each concrete
			// type of difference.
			functionsList.add(new LabeledFunction<>("Same number of occurrences of each concrete type of difference",
					comparison -> {
						Map<EClass, Long> differenceTypesCounts = new HashMap<>();
						for (EClass differenceType : EMFCompareUtils
								.getAllDifferenceTypes(comparison.getDifferences())) {
							differenceTypesCounts.put(differenceType, comparison.getDifferences().stream()
									.filter(difference -> differenceType.isInstance(difference)).count());
						}
						return differenceTypesCounts;
					}));
		}
		for (LabeledFunction<Comparison, Object> function : functionsList) {
			assertEquals(function.getLabel(), function.apply(expected), function.apply(actual));
		}
	}

}
