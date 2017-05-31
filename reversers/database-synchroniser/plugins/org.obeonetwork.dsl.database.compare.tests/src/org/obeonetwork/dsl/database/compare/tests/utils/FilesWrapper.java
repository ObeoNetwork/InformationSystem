package org.obeonetwork.dsl.database.compare.tests.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;

/**
 * Small wrapper around a list of {@link File} in order to redefine
 * {@code toString()} so that the JUnit test runner has meaningful labels for
 * tests.
 *
 * @author Florent Latombe<a href=
 *         "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
public class FilesWrapper {

	/**
	 * The list of {@link File} wrapped by this wrapper.
	 */
	private final List<File> files;
	/**
	 * Label suffix appended to the string representation of this wrapper.
	 */
	private final String labelSuffix;
	/**
	 * The base folder.
	 */
	private final String pathPrefix;

	/**
	 * Index from the file name to the {@link File}.
	 */
	private final Map<String, File> index;

	/**
	 * Creates a wrapper for the given list of {@link File}.
	 *
	 * @param resource
	 *            the list of {@link File} to wrap.
	 * @param labelSuffix
	 *            the label suffix to append.
	 */
	public FilesWrapper(List<File> files, String labelSuffix, String pathPrefix) {
		if (files.stream().map(file -> file.getName()).collect(Collectors.toSet()).size() == files.size()) {
			this.files = files;
			this.labelSuffix = labelSuffix;
			this.pathPrefix = pathPrefix;
			this.index = new HashMap<>();
			for (File file : files) {
				index.put(file.getName(), file);
			}
		} else {
			throw new RuntimeException("All files should have different names.");
		}
	}

	public Set<String> getFileNames() {
		return index.keySet();
	}

	public File getFile(String fileName) {
		return index.get(fileName);
	}

	@Override
	public String toString() {
		return this.files.stream()
				.map(file -> file.getAbsolutePath().replace(File.separator, DatabaseCompareAbstractTestSuite.SEPARATOR))
				.map(absolutePath -> {
					String label = absolutePath
							.substring(absolutePath
									.indexOf(pathPrefix
											+ (pathPrefix.endsWith(DatabaseCompareAbstractTestSuite.SEPARATOR) ? ""
													: DatabaseCompareAbstractTestSuite.SEPARATOR))
									+ pathPrefix.length() + 1);
					label = label.substring(0, label.lastIndexOf(DatabaseCompareAbstractTestSuite.SEPARATOR));
					label += DatabaseCompareAbstractTestSuite.SEPARATOR + this.labelSuffix;
					return label;
				}).collect(Collectors.joining(", "));
	}
}
