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
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.design.Activator;
import org.obeonetwork.dsl.environment.metadatadef.MetadatadefFactory;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewMetaDataDefinitionsModelWizard extends AbstractISNewModelWizard {

	private static final String METADATADEF_RESOURCE_FILE_EXTENSION = ".metadatadef";

	public NewMetaDataDefinitionsModelWizard() {
		super("New Metadatadef Model",
				Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/obj16/MetaDataDefinition.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		return List.of(MetadatadefFactory.eINSTANCE.createMetaDataDefinitions());
	}

	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection,
				METADATADEF_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new Metadatadef model");
		modelCreationPage.setDescription("Choose the new Metadatadef model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Metadatadef Model";
	}

}
