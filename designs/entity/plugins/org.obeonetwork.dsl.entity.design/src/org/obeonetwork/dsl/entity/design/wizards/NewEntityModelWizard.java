/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.design.wizards;

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
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.entity.design.Activator;

public class NewEntityModelWizard extends AbstractISNewModelWizard {

	private static final String ENTITY_RESOURCE_FILE_EXTENSION = ".entity";
	private static final String DESC_ID_PHYSICAL_NAMES_TABLE = "EV_Entities_PhysicalNames";
	private static final String DESC_ID_NAMESPACES_HIERARCHY = "Entities Namespaces Hierarchy";

	public NewEntityModelWizard() {
		super("New Entity Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewEntity.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Root rootObject = EntityFactory.eINSTANCE.createRoot();
		rootObject.setCreatedOn(new Date());
		return Arrays.asList(rootObject);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, ENTITY_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new entity model");
		modelCreationPage.setDescription("Choose the new entity model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected
	String getWizardTitle() {
		return "New Entity model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
					URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
					URI.createURI("viewpoint:/org.obeonetwork.dsl.entity.design/Entity Views"),
					URI.createURI("viewpoint:/org.obeonetwork.is.design/Entity (Safr@n consolidated view)")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(EntityPackage.Literals.ROOT, Arrays.asList(DESC_ID_NAMESPACES_HIERARCHY, DESC_ID_PHYSICAL_NAMES_TABLE));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof Root) {
			if (DESC_ID_NAMESPACES_HIERARCHY.equals(representationDescription.getName())) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_NAMESPACES_HIERARCHY);
			} else if (DESC_ID_PHYSICAL_NAMES_TABLE.equals(representationDescription.getName())) {
				return "Entities Physical Names";
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			if (DESC_ID_NAMESPACES_HIERARCHY.equals(((DDiagram) representation).getDescription().getName())) {
				return true;
			}
		}
		return false;
	}
}
