/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.PriorityDefinition;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.design.Activator;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewEnvironmentModelWizard extends AbstractISNewModelWizard {
	
	private static final String ENVIRONMENT_RESOURCE_FILE_EXTENSION = ".environment";
	private static final String DESC_ID_ENVIRONMENT_TABLE = "E_Environment";
	
	public NewEnvironmentModelWizard() {
		super("New Environment Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewEnvironment.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Environment environment = EnvironmentFactory.eINSTANCE.createEnvironment();
		environment.setName(extractNameFromTargetResourceName(ENVIRONMENT_RESOURCE_FILE_EXTENSION));
		environment.setCreatedOn(new Date());
		TypesDefinition typesDefinition = EnvironmentFactory.eINSTANCE.createTypesDefinition();
		typesDefinition.setCreatedOn(new Date());
		PriorityDefinition priorityDefinition = EnvironmentFactory.eINSTANCE.createPriorityDefinition();
		priorityDefinition.setCreatedOn(new Date());
		environment.setTypesDefinition(typesDefinition);
		environment.setPriorityDefinitions(priorityDefinition);
		return Arrays.asList(environment);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, ENVIRONMENT_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new environment model");
		modelCreationPage.setDescription("Choose the new environment model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Environment model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
					URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
					URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.design/OD4IS_Environment")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(EnvironmentPackage.Literals.ENVIRONMENT, Arrays.asList(DESC_ID_ENVIRONMENT_TABLE));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof Environment) {
			if (DESC_ID_ENVIRONMENT_TABLE.equals(representationDescription.getName())) {
				return String.format("%1$s - %2$s", this.getProjectName(), "Environment");
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		return false;
	}

}
