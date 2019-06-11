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
package org.obeonetwork.dsl.soa.design.wizards;

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
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.design.Activator;

public class NewSoaModelWizard extends AbstractISNewModelWizard {
	
	private static final String DESC_ID_DTO_PHYSICAL_NAMES_TABLE = "EV_DTO_PhysicalNames";
	private static final String DESC_ID_DTO_NAMESPACES_HIERARCHY_DIAGRAM = "DTO Namespaces Hierarchy";
	private static final String DESC_ID_SOA_DIAGRAM = "SOA Diagram";
	private static final String SOA_RESOURCE_FILE_EXTENSION = ".soa";

	public NewSoaModelWizard() {
		super("New Soa Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewSoa.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		System system = SoaFactory.eINSTANCE.createSystem();
		system.setCreatedOn(new Date());
		return Arrays.asList(system);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, SOA_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new soa model");
		modelCreationPage.setDescription("Choose the new soa model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Soa model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
				URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
				URI.createURI("viewpoint:/org.obeonetwork.dsl.soa.design/SOA Views"),
				URI.createURI("viewpoint:/fr.gouv.mindef.safran.is.design/SOA (Safr@n consolidated view)")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(SoaPackage.Literals.SYSTEM, Arrays.asList(DESC_ID_SOA_DIAGRAM, DESC_ID_DTO_NAMESPACES_HIERARCHY_DIAGRAM, DESC_ID_DTO_PHYSICAL_NAMES_TABLE));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof System) {
			String repDescName = representationDescription.getName();
			if (DESC_ID_SOA_DIAGRAM.equals(repDescName)) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_SOA_DIAGRAM);
			} else if (DESC_ID_DTO_NAMESPACES_HIERARCHY_DIAGRAM.equals(repDescName)) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_DTO_NAMESPACES_HIERARCHY_DIAGRAM);
			} else if (DESC_ID_DTO_PHYSICAL_NAMES_TABLE.equals(repDescName)) {
				return "DTO Physical Names";
			}
		}
		return null;
	}

	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			String repDescName = ((DDiagram) representation).getDescription().getName();
			return DESC_ID_SOA_DIAGRAM.equals(repDescName) ||
					DESC_ID_DTO_NAMESPACES_HIERARCHY_DIAGRAM.equals(repDescName);
		}
		
		return false;
	}
	
}
