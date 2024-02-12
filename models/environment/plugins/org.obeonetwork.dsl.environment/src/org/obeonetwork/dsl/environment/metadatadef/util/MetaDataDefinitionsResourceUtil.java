/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.metadatadef.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.resource.ResourceDescriptor;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;

public class MetaDataDefinitionsResourceUtil {

	private static final String PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_URI_ATTRIBUTE = "uri";

	private static final String METADATA_DEFINITIONS_RESOURCE_EXTENSION = "metadatadef";

	/**
	 * 
	 * @param analysis
	 * @return true if a resource with extension
	 *         {@link #METADATA_DEFINITIONS_RESOURCE_EXTENSION} exists in analysis.
	 */
	public static boolean isAnyMetaDataDefinitionsResourceRegistered(DAnalysis analysis) {
		return analysis.getSemanticResources().stream().map(ResourceDescriptor::getResourceURI).map(URI::fileExtension)
				.filter(ext -> METADATA_DEFINITIONS_RESOURCE_EXTENSION.equals(ext)).findFirst().isPresent();
	}

	/**
	 * 
	 * @param uri
	 * @param uriString
	 * @return true if a uri is an {@link URI} with extension
	 *         {@link #METADATA_DEFINITIONS_RESOURCE_EXTENSION} and
	 *         uri.toString().equals uriString.
	 */
	public static boolean isSameMetaDataDefinitionsResource(URI uri, String uriString) {
		return uri != null && uriString != null && METADATA_DEFINITIONS_RESOURCE_EXTENSION.equals(uri.fileExtension())
				&& uri.toString().equals(uriString);
	}

	/**
	 * 
	 * @param analysis
	 * @return a {@link Collection} of {@link URI}s with extension
	 *         {@link #METADATA_DEFINITIONS_RESOURCE_EXTENSION} existing in
	 *         analysis.
	 */
	public static Collection<URI> getRegisteredMetaDataDefinitionsResources(DAnalysis analysis) {
		if (analysis == null) {
			return Collections.emptyList();
		}
		return analysis.getSemanticResources().stream().map(ResourceDescriptor::getResourceURI)
				.filter(uri -> METADATA_DEFINITIONS_RESOURCE_EXTENSION.equals(uri.fileExtension()))
				.collect(Collectors.toUnmodifiableList());
	}

	/**
	 * 
	 * @param uris
	 * @param uriToLookAt
	 * @return true if uriToLookAt matches an {@link URI} in uris.
	 */
	public static boolean isURIPresent(Collection<URI> uris, String uriToLookAt) {
		return uris != null && !uris.isEmpty()
				&& uris.stream().anyMatch(uri -> isSameMetaDataDefinitionsResource(uri, uriToLookAt));
	}

	/**
	 * <p>
	 * Adds in session the resources* provided by
	 * {@link ProvidedMetaDataDefinitionsModelsService#getProvidedMetaDataDefinitions()}.
	 * </p>
	 * <p>
	 * *A resource is not added if its {@link URI} is contained in
	 * urisMetaDataDefintionsToExclude.
	 * </p>
	 * 
	 * @param session
	 * @param urisMetaDataDefintionsToExclude
	 */
	public static void addProvidedMetaDataDefintionsResourceToSemanticResource(Session session,
			Collection<URI> urisMetaDataDefintionsToExclude) {
		// Read Extension
		List<IConfigurationElement> configElements = ProvidedMetaDataDefinitionsModelsService
				.getProvidedMetaDataDefinitions();
		if (!configElements.isEmpty()) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
			if (ted != null) {
				configElements.stream()
						.map(c -> c.getAttribute(PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_URI_ATTRIBUTE))
						.filter(uri -> !isURIPresent(urisMetaDataDefintionsToExclude, uri)).map(URI::createURI)
						// Add to semantic resources
						.map(uri -> new AddSemanticResourceCommand(session, uri, new NullProgressMonitor()))
						.forEach(command -> ted.getCommandStack().execute(command));
			}
		}
	}

}
