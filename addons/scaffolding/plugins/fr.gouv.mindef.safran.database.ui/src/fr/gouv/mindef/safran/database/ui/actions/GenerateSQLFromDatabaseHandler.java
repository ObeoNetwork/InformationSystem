/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.obeonetwork.dsl.database.util.DatabaseResourceImpl;

public class GenerateSQLFromDatabaseHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		// We have to compute an emfdiff file from a comparison with an empty database
		// ---
		
		// First let's create an empty model containing only 
		Resource resource = new DatabaseResourceImpl(URI.createURI("memory:/empty_database"));
		TableContainer rootContainer = getFirstTableContainer(selection);
		TableContainer newContainer = null;
		if (rootContainer instanceof DataBase) {
			newContainer = copyDatabase((DataBase)rootContainer);
			resource.getContents().add(newContainer);
		} else if (rootContainer instanceof Schema) {
			newContainer = copySchema((Schema)rootContainer);
			resource.getContents().add(newContainer);
		}
		
		// Then compare the two models
		Comparison comparison = null;
		try {
			comparison = DatabaseCompareService.compare(rootContainer, newContainer);
		} catch (Exception e) {
		}
		
		// The diff model can now be used to generate the SQL script
		if (comparison != null) {
			ExportAsSQLScriptsAction action = new ExportAsSQLScriptsAction();
			action.exportComparison(comparison);
		}
		
		return null;
	}
	
	private DataBase copyDatabase(DataBase database) {
		DataBase newDatabase = DatabaseFactory.eINSTANCE.createDataBase();
		newDatabase.setName(database.getName());
		for (Schema schema : database.getSchemas()) {
			newDatabase.getSchemas().add((Schema)copySchema(schema));
		}
		return newDatabase;
	}
	
	private Schema copySchema(Schema schema) {
		Schema newSchema = DatabaseFactory.eINSTANCE.createSchema();
		newSchema.setName(schema.getName());
		return newSchema;
	}
	
	private TableContainer getFirstTableContainer(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IResource) {
				IResource iResource = (IResource)firstElement;
				ResourceSet set = new ResourceSetImpl();
				URI uri = URI.createPlatformResourceURI(iResource.getFullPath().toString(), true);
				Resource resource = set.getResource(uri,true);
				return getFirstTableContainer(resource);
			} else if (firstElement instanceof Resource) {
				return getFirstTableContainer((Resource)firstElement);
			}
		}
		return null;
	}
	
	private TableContainer getFirstTableContainer(Resource resource) {
		if (resource != null && resource.getContents().isEmpty() == false) {
			for (EObject object : resource.getContents()) {
				if (object instanceof TableContainer) {
					return (TableContainer)object;
				}
			}
		}
		return null;
	}

}
