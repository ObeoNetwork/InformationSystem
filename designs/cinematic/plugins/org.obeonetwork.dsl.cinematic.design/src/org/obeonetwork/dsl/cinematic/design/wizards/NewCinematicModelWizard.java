/*******************************************************************************
 * Copyright (c) 2008, 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.cinematic.CinematicFactory;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewCinematicModelWizard extends AbstractISNewModelWizard {
	
	private static final String DESC_ID_PACKAGE_DIAGRAM = "Package Diagram";
	private static final String DESC_ID_UI_STRUCTURE_TREE = "UI Structure";
	private static final String CINEMATIC_RESOURCE_FILE_EXTENSION = ".cinematic";

	public NewCinematicModelWizard() {
		super("New Cinematic model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewCinematic.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		CinematicRoot cinematicRoot = CinematicFactory.eINSTANCE.createCinematicRoot();
		cinematicRoot.setCreatedOn(new Date());
		cinematicRoot.setName(getProjectName());
		return Arrays.asList(cinematicRoot);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, CINEMATIC_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new cinematic model");
		modelCreationPage.setDescription("Choose the new cinematic model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Cinematic model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
				URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
				URI.createURI("viewpoint:/org.obeonetwork.dsl.cinematic.design/Cinematic Views")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(CinematicPackage.Literals.CINEMATIC_ROOT, Arrays.asList(DESC_ID_UI_STRUCTURE_TREE, DESC_ID_PACKAGE_DIAGRAM));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof CinematicRoot) {
			String repDescName = representationDescription.getName();
			if (DESC_ID_PACKAGE_DIAGRAM.equals(repDescName)) {
				return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_PACKAGE_DIAGRAM);
			} else if (DESC_ID_UI_STRUCTURE_TREE.equals(repDescName)) {
				return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_UI_STRUCTURE_TREE);
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			String repDescName = ((DDiagram) representation).getDescription().getName();
			return DESC_ID_PACKAGE_DIAGRAM.equals(repDescName);
		}
		return false;
	}

}
