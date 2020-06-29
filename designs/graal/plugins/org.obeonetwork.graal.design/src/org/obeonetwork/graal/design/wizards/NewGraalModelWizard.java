/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.wizards;

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
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.design.Activator;

public class NewGraalModelWizard extends AbstractISNewModelWizard {
	
	private static final String GRAAL_RESOURCE_FILE_EXTENSION = ".graal";
	private static final String DESC_ID_DOMAIN_NAMESPACES_HIERARCHY = "Domain Classes Namespaces Hierarchy";
	private static final String DESC_ID_TASKS_GRAPH = "Tasks Graph";
	private static final String DESC_ID_ACTORS_GRAPH = "Actors Graph";
	private static final String DESC_ID_USE_CASES_MAIN_VIEW = "Use Cases Main View";
	
	public NewGraalModelWizard() {
		super("New Graal Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewGraal.gif"));
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, GRAAL_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new graal model");
		modelCreationPage.setDescription("Choose the new graal model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		System system = GraalFactory.eINSTANCE.createSystem();
		system.setCreatedOn(new Date());
		system.setName(extractNameFromTargetResourceName(GRAAL_RESOURCE_FILE_EXTENSION));
		return Arrays.asList(system);
	}

	@Override
	protected String getWizardTitle() {
		return "New Graal model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
				URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
				URI.createURI("viewpoint:/org.obeonetwork.graal.design/Graal Methodology"),
				URI.createURI("viewpoint:/fr.gouv.mindef.safran.is.design/Graal Methodology (Safr@n consolidated view)"),
				URI.createURI("viewpoint:/org.obeonetwork.dsl.interaction.design/Interaction"),
				URI.createURI("viewpoint:/org.obeonetwork.dsl.statemachine.design/State Machine")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(GraalPackage.Literals.SYSTEM, Arrays.asList(DESC_ID_DOMAIN_NAMESPACES_HIERARCHY, DESC_ID_TASKS_GRAPH, DESC_ID_ACTORS_GRAPH, DESC_ID_USE_CASES_MAIN_VIEW));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		String representationName = null;
		if (object instanceof System) {
			switch (representationDescription.getName()) {
			case DESC_ID_DOMAIN_NAMESPACES_HIERARCHY:
				representationName = String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_DOMAIN_NAMESPACES_HIERARCHY);
				break;
			case DESC_ID_TASKS_GRAPH:
				representationName = String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_TASKS_GRAPH);
				break;
			case DESC_ID_ACTORS_GRAPH:
				representationName = String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_ACTORS_GRAPH);
				break;
			case DESC_ID_USE_CASES_MAIN_VIEW:
				representationName = String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_USE_CASES_MAIN_VIEW);
				break;
			default:
				break;
			}
		}
		return representationName;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		return representation instanceof DDiagram && DESC_ID_TASKS_GRAPH.equals(((DDiagram) representation).getDescription().getName());
	}
}
