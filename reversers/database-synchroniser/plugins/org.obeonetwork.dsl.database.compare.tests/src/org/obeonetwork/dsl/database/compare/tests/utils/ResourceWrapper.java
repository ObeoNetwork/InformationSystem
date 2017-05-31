package org.obeonetwork.dsl.database.compare.tests.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.database.compare.tests.DatabaseCompareAbstractTestSuite;

/**
 * Small wrapper around a {@link Resource} in order to redefine
 * {@code toString()} so that the JUnit test runner has meaningful labels for
 * tests.
 *
 * @author Florent Latombe<a href=
 *         "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
public class ResourceWrapper {

	/**
	 * The {@link Resource} wrapped by this wrapper.
	 */
	private final Resource resource;
	/**
	 * Label suffix appended to the string representation of this wrapper.
	 */
	private final String labelSuffix;
	/**
	 * The base folder.
	 */
	private final String pathPrefix;

	/**
	 * Creates a wrapper for the given {@link Resource}.
	 *
	 * @param resource
	 *            the {@link Resource} to wrap.
	 * @param labelSuffix
	 *            the label suffix to append.
	 */
	public ResourceWrapper(Resource resource, String labelSuffix, String pathPrefix) {
		this.resource = resource;
		this.labelSuffix = labelSuffix;
		this.pathPrefix = pathPrefix;
	}

	/**
	 * Provides this wrapper's {@link Resource}.
	 *
	 * @return the {@link Resource} of this wrapper.
	 */
	public Resource getResource() {
		return this.resource;
	}

	@Override
	public String toString() {
		final String uriAsString = this.resource.getURI().toString();
		String label = uriAsString.substring(
				uriAsString.indexOf(pathPrefix + (pathPrefix.endsWith(DatabaseCompareAbstractTestSuite.SEPARATOR) ? ""
						: DatabaseCompareAbstractTestSuite.SEPARATOR)) + pathPrefix.length() + 1);
		label = label.substring(0, label.lastIndexOf(DatabaseCompareAbstractTestSuite.SEPARATOR));
		label += DatabaseCompareAbstractTestSuite.SEPARATOR + this.labelSuffix;
		return label;
	}
}
