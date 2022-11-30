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
package org.obeonetwork.dsl.database.design.wizards;

import static org.obeonetwork.dsl.database.design.IDatabaseViewpointConstants.DATABASE_DIAGRAM_ID;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_LOGICAL_TYPES;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_106;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_8;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_21C;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_14;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.H2_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.LOGICAL_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.MARIADB_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.MYSQL_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.ORACLE_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.POSTGRES_PATHMAP;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.SQLSERVER_PATHMAP;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.design.Activator;
import org.obeonetwork.dsl.database.design.IDatabaseViewpointConstants;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;

public class NewDatabaseModelWizard extends AbstractISNewModelWizard {

	private static final String DATABASE_RESOURCE_FILE_EXTENSION = ".database";

	protected DatabaseModelWizardInitialObjectCreationPage initialDatabaseCreationPage;

	public NewDatabaseModelWizard() {
		super("New Database model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewDatabase.gif"));
	}
	
	@Override
	protected Collection<EObject> createInitialObjects() {
		ResourceSet resourceSet = getTargetModelingProject().getSession().getSessionResource().getResourceSet();
		DataBase database = DatabaseFactory.eINSTANCE.createDataBase();
		database.setName(extractNameFromTargetResourceName(DATABASE_RESOURCE_FILE_EXTENSION));
		String dbVendor = this.initialDatabaseCreationPage.dbVendorField.getText();
		
		Resource typesLibraryResource = null;
		switch (dbVendor) {
		case DB_MYSQL_8:
			typesLibraryResource = resourceSet.getResource(URI.createURI(MYSQL_PATHMAP), true);
			break;
		case DB_MARIADB_106: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(MARIADB_PATHMAP), true);
			break;
		case DB_ORACLE_21C: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(ORACLE_PATHMAP), true);
			break;
		case DB_H2_13: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(H2_PATHMAP), true);
			break;
		case DB_POSTGRES_14: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(POSTGRES_PATHMAP), true);
			break;
		case DB_SQLSERVER_2008: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(SQLSERVER_PATHMAP), true);
			break;
		case DB_LOGICAL_TYPES: 
			typesLibraryResource = resourceSet.getResource(URI.createURI(LOGICAL_PATHMAP), true);
			break;
		default:
			break;
		}
		
		if (typesLibraryResource != null) {
			EObject typesRoot = typesLibraryResource.getContents().get(0);
			if (typesRoot instanceof TypesLibrary) {
				database.getUsedLibraries().add((TypesLibrary) typesRoot);
			}
		}
		
		return Arrays.asList(database);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, DATABASE_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new database model");
		modelCreationPage.setDescription("Choose the new database model name and path.");
		addPage(modelCreationPage);
		initialDatabaseCreationPage = new DatabaseModelWizardInitialObjectCreationPage("DatabaseOptionSelection");
		addPage(initialDatabaseCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Database model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return IDatabaseViewpointConstants.VIEWPOINT_DEPENDENCIES;
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(DatabasePackage.Literals.DATA_BASE, Arrays.asList(DATABASE_DIAGRAM_ID));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof DataBase) {
			String repDescName = representationDescription.getName();
			if (DATABASE_DIAGRAM_ID.equals(repDescName)) {
				return String.format("%1$s - %2$s", this.getProjectName(), "Database");
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			String repDescName = ((DDiagram) representation).getDescription().getName();
			return DATABASE_DIAGRAM_ID.equals(repDescName);
		}
		return false;
	}

}
