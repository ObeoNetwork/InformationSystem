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
package fr.gouv.mindef.safran.database.ui.actions.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;

public class TestScaffoldingInput extends PropertyTester {

	private static final String ENTITY_TO_LOGICAL_DATABASE = "ENTITY_TO_LOGICAL_DATABASE";
	private static final String LOGICAL_DATABASE_TO_ENTITY = "LOGICAL_DATABASE_TO_ENTITY";
	private static final String LOGICAL_DATABASE_TO_PHYSICAL_DATABASE = "LOGICAL_DATABASE_TO_PHYSICAL_DATABASE";
	private static final String PHYSICAL_DATABASE_TO_LOGICAL_DATABASE = "PHYSICAL_DATABASE_TO_LOGICAL_DATABASE";
	
	private static final String ENTITY_EXTENSION = "entity";
	private static final String OIS_EXTENSION = "ois";
	private static final String DATABASE_EXTENSION = "database";
	private static final String SCAFFOLD_EXTENSION = "scaffold";
	
	public TestScaffoldingInput() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection)receiver;
			if (selection.size() == 1) {
				Object element = selection.getFirstElement();
				if (args != null && args.length >= 1) {
					String kind = (String)args[0];
					if (element instanceof Resource) {
						Resource resource = (Resource)element;
						if (ENTITY_TO_LOGICAL_DATABASE.equals(kind)) {
							return handleEntityToLogicalDatabase(resource);							
						} else if (LOGICAL_DATABASE_TO_ENTITY.equals(kind)) {
							return handleLogicalDatabaseToEntity(resource);
						} else if (LOGICAL_DATABASE_TO_PHYSICAL_DATABASE.equals(kind)) {
							return handleLogicalDatabaseToPhysicalDatabase(resource);
						} else if (PHYSICAL_DATABASE_TO_LOGICAL_DATABASE.equals(kind)) {
							return handlePhysicalDatabaseToLogicalDatabase(resource);
						}
					} else {
						URI uri = getModelURI(element);
						if (uri != null) {
							if (ENTITY_TO_LOGICAL_DATABASE.equals(kind)) {
								return handleEntityToLogicalDatabase(uri);							
							} else if (LOGICAL_DATABASE_TO_ENTITY.equals(kind)) {
								return handleLogicalDatabaseToEntity(uri);
							} else if (LOGICAL_DATABASE_TO_PHYSICAL_DATABASE.equals(kind)) {
								return handleLogicalDatabaseToPhysicalDatabase(uri);
							} else if (PHYSICAL_DATABASE_TO_LOGICAL_DATABASE.equals(kind)) {
								return handlePhysicalDatabaseToLogicalDatabase(uri);
							}
						}
						
					}
				}
			}
		}
		return false;
	}
	
	private URI getModelURI(Object element) {
		if (element instanceof IFile) {
			return URI.createPlatformResourceURI(((IFile)element).getFullPath().toString(), true);
		} else if (element instanceof CDOResource) {
			return ((CDOResource)element).getURI();
		}
		return null;
	}
	
	private boolean handleEntityToLogicalDatabase(URI modelURI) {
		if (ENTITY_EXTENSION.equals(modelURI.fileExtension())
				|| OIS_EXTENSION.equals(modelURI.fileExtension())) {						
			return true;
		}
		return handleScaffoldModel(modelURI, ScaffoldType.ENTITY_TO_MLD);
	}
	
	private boolean handleEntityToLogicalDatabase(Resource emfResource) {
		if (ENTITY_EXTENSION.equals(emfResource.getURI().fileExtension())
				|| OIS_EXTENSION.equals(emfResource.getURI().fileExtension())) {						
			return true;
		}
		return handleScaffoldModel(emfResource, ScaffoldType.ENTITY_TO_MLD);
	}

	private boolean handleLogicalDatabaseToEntity(URI modelURI) {
		return handleDatabaseModel(modelURI, TypesLibraryKind.LOGICAL_TYPES) ||
				handleScaffoldModel(modelURI, ScaffoldType.MLD_TO_ENTITY);
	}
	
	private boolean handleLogicalDatabaseToEntity(Resource emfResource) {
		return handleDatabaseModel(emfResource, TypesLibraryKind.LOGICAL_TYPES) ||
				handleScaffoldModel(emfResource, ScaffoldType.MLD_TO_ENTITY);
	}

	private boolean handlePhysicalDatabaseToLogicalDatabase(URI modelURI) {
		return handleDatabaseModel(modelURI, TypesLibraryKind.PHYSICAL_TYPES) ||
				handleScaffoldModel(modelURI, ScaffoldType.MPD_TO_MLD);
	}
	
	private boolean handlePhysicalDatabaseToLogicalDatabase(Resource emfResource) {
		return handleDatabaseModel(emfResource, TypesLibraryKind.PHYSICAL_TYPES) ||
				handleScaffoldModel(emfResource, ScaffoldType.MPD_TO_MLD);
	}
	
	private boolean handleLogicalDatabaseToPhysicalDatabase(URI modelURI) {
		return handleDatabaseModel(modelURI, TypesLibraryKind.LOGICAL_TYPES) ||
				handleScaffoldModel(modelURI, ScaffoldType.MLD_TO_MPD);
	}
	
	private boolean handleLogicalDatabaseToPhysicalDatabase(Resource emfResource) {
		return handleDatabaseModel(emfResource, TypesLibraryKind.LOGICAL_TYPES) ||
				handleScaffoldModel(emfResource, ScaffoldType.MLD_TO_MPD);
	}
	
	private boolean handleScaffoldModel(URI modelURI, ScaffoldType scaffoldType) {
		if (SCAFFOLD_EXTENSION.equals(modelURI.fileExtension())) {
			ResourceSet set = new ResourceSetImpl();
 			Resource emfResource = set.getResource(modelURI, true);
 			return handleScaffoldModel(emfResource, scaffoldType);
		}
		return false;
	}
	
	private boolean handleScaffoldModel(Resource emfResource, ScaffoldType scaffoldType) {
		if (emfResource.getContents() != null && emfResource.getContents().isEmpty() == false) {
			EObject root = emfResource.getContents().get(0);
			if (root instanceof ScaffoldInfo) {
				ScaffoldInfo scaffoldInfo = (ScaffoldInfo)root;
				return scaffoldInfo.getLeftToRightTransformationType() == scaffoldType
						|| scaffoldInfo.getRightToLeftTransformationType() == scaffoldType;
			}
		}
		return false;
	}
	
	private boolean handleDatabaseModel(URI modelURI, TypesLibraryKind libraryKind) {
		if (DATABASE_EXTENSION.equals(modelURI.fileExtension())) {						
			ResourceSet set = new ResourceSetImpl();
 			Resource emfResource = set.getResource(modelURI, true);
 			return handleDatabaseModel(emfResource, libraryKind);
		}
		return false;
	}
	
	private boolean handleDatabaseModel(Resource emfResource, TypesLibraryKind libraryKind) {
		if (emfResource.getContents() != null && emfResource.getContents().isEmpty() == false) {
				EObject root = emfResource.getContents().get(0);
				if (root instanceof DataBase) {
					return usesLibraryOfKind((DataBase)root, libraryKind);
				}
			}
		return false;
	}
	
	protected boolean usesLibraryOfKind(DataBase database, TypesLibraryKind kind) {
		for (TypesLibrary typesLibrary : database.getUsedLibraries()) {
			if (kind.equals(typesLibrary.getKind())) {
				return true;
			}
		}
		return false;
	}
}
