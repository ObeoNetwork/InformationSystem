/*******************************************************************************
 * Copyright (c) 2012, 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import org.obeonetwork.dsl.environment.Environment;

public class ProvidedModelsService {
	
	private static final String PROVIDED_ENVIRONMENT_MODEL_EXTENSION_ID = "org.obeonetwork.dsl.environment.providedEnvironmentModel";
	
	public static Collection<Environment> getProvidedEnvironmentModels(Collection<URI> alreadyUsedURIs) {

		Collection<URI> environmentsURI = getProvidedEnvironmentUris();
		Collection<Environment> environments = new ArrayList<Environment>();
		for (URI uri : environmentsURI) {
			if (alreadyUsedURIs.contains(uri) == false) {
				ResourceSet set = new ResourceSetImpl();
				Resource resource = set.getResource(uri, true);
				if (resource != null && resource.getContents() != null) {
					for (EObject root : resource.getContents()) {
						if (root instanceof Environment) {
							environments.add((Environment)root);
						}
					}
				}
			}
		}
		return environments;
	}
	
//	public static CinematicRoot associateToolkit(CinematicRoot root, Environment toolkit) {
//		URI toolkitUri = EcoreUtil.getURI(toolkit);
//		// Check if it's already associated
//		for (Environment usedToolkit : root.getToolkits()) {
//			if (EcoreUtil.getURI(usedToolkit).equals(toolkitUri)) {
//				// already associated, do nothing and just return
//				return root;
//			}
//		}
//		// We now have to associate the toolkit to the root object
//		ResourceSet set = root.eResource().getResourceSet();
//		EObject newToolkit = set.getEObject(toolkitUri, true);
//		if (newToolkit instanceof Toolkit) {
//			root.getToolkits().add((Toolkit)newToolkit);
//		}
//		return root;
//	}
	
	public static Collection<URI> getProvidedEnvironmentUris() {
		Collection<URI> providedURIs = new ArrayList<URI>();
		for (IConfigurationElement configurationElement : getProvidedEnvironment()) {
			String providedURIAsString = configurationElement.getAttribute("uri");
			providedURIs.add(URI.createURI(providedURIAsString));
		}
		return providedURIs;
	}
	
	public static List<IConfigurationElement> getProvidedEnvironment() {
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PROVIDED_ENVIRONMENT_MODEL_EXTENSION_ID).getExtensions();
		return Arrays.stream(extensions)
				.map(IExtension::getConfigurationElements)
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());
	}
}
