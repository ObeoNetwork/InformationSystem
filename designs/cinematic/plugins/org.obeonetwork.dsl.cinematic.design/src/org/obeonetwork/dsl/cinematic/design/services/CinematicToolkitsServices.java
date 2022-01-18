/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.common.ui.tools.api.selection.EObjectSelectionWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.provider.ToolkitsItemProviderAdapterFactory;
import org.obeonetwork.dsl.cinematic.toolkits.util.ToolkitsProvider;


public class CinematicToolkitsServices {

	public static Collection<Toolkit> getCinematicProvidedToolkits(CinematicRoot cinematicRoot) {
		Collection<Toolkit> toolkits = new ArrayList<Toolkit>();
		Collection<URI> toolkitsURI = new ArrayList<URI>();
		
		Collection<Toolkit> alreadyUsedToolkits = new ArrayList<Toolkit>(cinematicRoot.getToolkits());
		
		// Get toolkits in ResourceSet
		Collection<Toolkit> toolkitsInResourceSet = getToolkitsInResourceSet(cinematicRoot);
		for (Toolkit toolkitInResourceSet : toolkitsInResourceSet) {
			// We do not propose the already used toolkits
			if (!alreadyUsedToolkits.contains(toolkitInResourceSet)) {
				toolkits.add(toolkitInResourceSet);
				toolkitsURI.add(EcoreUtil.getURI(toolkitInResourceSet));
			}
		}
		
		// Get the already used toolkits URI which should not be proposed
		Collection<URI> alreadyUsedToolkitsURIs = new ArrayList<URI>();
		for (Toolkit usedToolkit : alreadyUsedToolkits) {
			alreadyUsedToolkitsURIs.add(EcoreUtil.getURI(usedToolkit));
		}
		
		// Get toolkits provided using the extension point
		Collection<URI> providedToolkitsURI = ToolkitsProvider.getProvidedToolkits();
		for (URI uri : providedToolkitsURI) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(uri, true);
			if (resource != null && resource.getContents() != null) {
				for (EObject root : resource.getContents()) {
					if (root instanceof Toolkit) {
						Toolkit toolkit = (Toolkit)root;
						URI toolkitURI = EcoreUtil.getURI(toolkit);
						if (!toolkitsURI.contains(toolkitURI) && !alreadyUsedToolkitsURIs.contains(toolkitURI)) {
							toolkits.add(toolkit);
						}
					}
				}
			}
		}
		
		// Get toolkits in ResourceSet
		
		
		return toolkits;
	}
	
	private static Collection<Toolkit> getToolkitsInResourceSet(EObject context) {
		Collection<Toolkit> toolkits = new ArrayList<Toolkit>();
		// Get ResourceSet
		if (context.eResource() != null) {
			ResourceSet set = context.eResource().getResourceSet();
			if (set != null) {
				for (Resource resource : set.getResources()) {
					for (EObject object : resource.getContents()) {
						if (object instanceof Toolkit) {
							toolkits.add((Toolkit)object);
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
	
	public List<Toolkit> getToolkits(CinematicRoot context){
		return context.getToolkits();
	}
	
	/**
	 * Opens a toolkit selection dialog.
	 * @param cinematicRoot the {@link CinematicRoot}
	 */
	public void openToolkitSelectionWizard(EObject cinematicRoot) {
		if (!(cinematicRoot instanceof CinematicRoot)) 
			return;
		
		
		// all the toolkits
		Collection<Toolkit> toolkits = getCinematicProvidedToolkits((CinematicRoot) cinematicRoot);
		// we remove all the toolkits already added to the cinematic root
		toolkits = toolkits.stream()
				.filter(toolkit -> !((CinematicRoot) cinematicRoot).getToolkits().contains(toolkit))
				.distinct()
				.collect(Collectors.toList());
				
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		EObjectSelectionWizard wizard = new EObjectSelectionWizard("Selection Wizard", "Select a toolkit to associate", 
				null, toolkits, new ToolkitsItemProviderAdapterFactory());
		WizardDialog dialog = new WizardDialog(shell, wizard);
		
		int returnCode = dialog.open();
		
		if (returnCode != Window.CANCEL)
			wizard.getSelectedEObjects().stream().filter(Toolkit.class::isInstance).forEach(toolkit -> ((CinematicRoot) cinematicRoot).getToolkits().add((Toolkit) toolkit));		
	}
}
