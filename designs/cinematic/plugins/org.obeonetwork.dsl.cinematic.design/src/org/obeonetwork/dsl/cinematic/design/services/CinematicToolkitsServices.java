/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.util.ToolkitsProvider;


public class CinematicToolkitsServices {

	public static Collection<Toolkit> getCinematicProvidedToolkits(EObject context, Collection<Toolkit> alreadyUsedToolkits) {
		Collection<URI> alreadyUsedToolkitsURIs = new ArrayList<URI>();
		for (Toolkit usedToolkit : alreadyUsedToolkits) {
			alreadyUsedToolkitsURIs.add(EcoreUtil.getURI(usedToolkit));
		}
		Collection<URI> toolkitsURI = ToolkitsProvider.getProvidedToolkits();
		Collection<Toolkit> toolkits = new ArrayList<Toolkit>();
		for (URI uri : toolkitsURI) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(uri, true);
			if (resource != null && resource.getContents() != null) {
				for (EObject root : resource.getContents()) {
					if (root instanceof Toolkit) {
						Toolkit toolkit = (Toolkit)root;
						if (!alreadyUsedToolkitsURIs.contains(EcoreUtil.getURI(toolkit))) {
							toolkits.add(toolkit);
						}
					}
				}
			}
		}
		return toolkits;
	}
	
	public static CinematicRoot associateToolkit(CinematicRoot root, Toolkit toolkit) {
		URI toolkitUri = EcoreUtil.getURI(toolkit);
		// Check if it's already associated
		for (Toolkit usedToolkit : root.getToolkits()) {
			if (EcoreUtil.getURI(usedToolkit).equals(toolkitUri)) {
				// already associated, do nothing and just return
				return root;
			}
		}
		// We now have to associate the toolkit to the root object
		ResourceSet set = root.eResource().getResourceSet();
		EObject newToolkit = set.getEObject(toolkitUri, true);
		if (newToolkit instanceof Toolkit) {
			root.getToolkits().add((Toolkit)newToolkit);
		}
		return root;
	}
}
