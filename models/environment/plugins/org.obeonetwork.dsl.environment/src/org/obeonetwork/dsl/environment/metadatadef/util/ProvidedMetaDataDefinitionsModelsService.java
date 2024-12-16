/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.metadatadef.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions;

public class ProvidedMetaDataDefinitionsModelsService {

	private static final String PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_ID = "org.obeonetwork.dsl.environment.providedMetaDataDefinitionsModels";

	private static Collection<MetaDataDefinitions> PROVIDED_METADATA_DEFINITIONS_MODELS = null;
	
	public static Collection<MetaDataDefinitions> getProvidedMetaDataDefinitionsModels() {
		if(PROVIDED_METADATA_DEFINITIONS_MODELS == null) {
			PROVIDED_METADATA_DEFINITIONS_MODELS = getProvidedMetaDataDefinitionsModels(Collections.emptyList());
		}
		return Collections.unmodifiableCollection(PROVIDED_METADATA_DEFINITIONS_MODELS);
	}
	
	/**
	 * 
	 * @param urisToExclude
	 * @return a collection of {@link MetaDataDefinitions} provided by contributions
	 *         to the extension point with ID
	 *         {@link PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_ID}.
	 */
	private static Collection<MetaDataDefinitions> getProvidedMetaDataDefinitionsModels(Collection<URI> urisToExclude) {

		Collection<URI> metaDataDefinitionsURI = getProvidedMetaDataDefinitionsModelsUris();
		Collection<MetaDataDefinitions> metaDataDefinitions = new ArrayList<MetaDataDefinitions>();
		for (URI uri : metaDataDefinitionsURI) {
			if (!urisToExclude.contains(uri)) {
				ResourceSet set = new ResourceSetImpl();
				Resource resource = set.getResource(uri, true);
				if (resource != null && resource.getContents() != null) {
					for (EObject root : resource.getContents()) {
						if (root instanceof MetaDataDefinitions) {
							metaDataDefinitions.add((MetaDataDefinitions) root);
						}
					}
				}
			}
		}
		return metaDataDefinitions;
	}

	/**
	 * 
	 * @return a collection of {@link URI} provided by contributions to the
	 *         extension point with ID
	 *         {@link PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_ID}.
	 */
	public static Collection<URI> getProvidedMetaDataDefinitionsModelsUris() {
		Collection<URI> providedURIs = new ArrayList<URI>();
		for (IConfigurationElement configurationElement : getProvidedMetaDataDefinitions()) {
			String providedURIAsString = configurationElement.getAttribute("uri");
			providedURIs.add(URI.createURI(providedURIAsString));
		}
		return providedURIs;
	}

	/**
	 * 
	 * @return a list of extensions of the extension point with ID:
	 *         {@link PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_ID}.
	 */
	public static List<IConfigurationElement> getProvidedMetaDataDefinitions() {
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(PROVIDED_METADATA_DEFINITIONS_MODELS_EXTENSION_ID).getExtensions();
		return Arrays.stream(extensions).map(IExtension::getConfigurationElements).flatMap(Arrays::stream)
				.collect(Collectors.toList());
	}
}
