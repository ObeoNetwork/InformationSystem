/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.design.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.design.Activator;

public class NewRequirementModelWizard extends AbstractISNewModelWizard {
	
	private static final String REQUIREMENT_RESOURCE_FILE_EXTENSION = ".requirement";
	private static final String DESC_ID_REQUIREMENTS_TABLE = "Requirements Table";
	
	public NewRequirementModelWizard() {
		super("New Requirement Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewRequirement.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Repository repository = RequirementFactory.eINSTANCE.createRepository();
		repository.setName(extractNameFromTargetResourceName(REQUIREMENT_RESOURCE_FILE_EXTENSION));
		return Arrays.asList(repository);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, REQUIREMENT_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new requirement model");
		modelCreationPage.setDescription("Choose the new requirement model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Requirement model";
	}

	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		List<URI> vpAboutToBeActivated = new ArrayList<>();
		vpAboutToBeActivated.add(URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"));
		vpAboutToBeActivated.add(URI.createURI("viewpoint:/org.obeonetwork.dsl.requirement.design/Requirements"));
		if (projectContainsGraalResource()) {
			vpAboutToBeActivated.add(URI.createURI("viewpoint:/org.obeonetwork.graal.design/Requirements (Graal consolidated view)"));
		}
		return vpAboutToBeActivated;
	}

	private boolean projectContainsGraalResource() {
		return this.getTargetModelingProject()
				.getSession()
				.getSemanticResources()
				.stream()
				.anyMatch(this::isGraalResource);
	}
	
	private boolean isGraalResource(Resource resource) {
		String fileExtension = resource.getURI().fileExtension();
		return "graal".equals(fileExtension);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(RequirementPackage.Literals.REPOSITORY, Arrays.asList(DESC_ID_REQUIREMENTS_TABLE));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof Repository) {
			if (DESC_ID_REQUIREMENTS_TABLE.equals(representationDescription.getName())) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_REQUIREMENTS_TABLE);
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		return representation instanceof DTable && DESC_ID_REQUIREMENTS_TABLE.equals(((DTable) representation).getDescription().getName());
	}
	
}
