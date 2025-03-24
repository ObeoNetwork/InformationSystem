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
package org.obeonetwork.database.ui.actions.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import org.obeonetwork.database.scaffold.ScaffoldType;

public abstract class AbstractScaffoldingPropertyTester extends PropertyTester {

	public static final String ENTITY_TO_LOGICAL_DATABASE = "ENTITY_TO_LOGICAL_DATABASE";
	public static final String LOGICAL_DATABASE_TO_ENTITY = "LOGICAL_DATABASE_TO_ENTITY";
	public static final String LOGICAL_DATABASE_TO_PHYSICAL_DATABASE = "LOGICAL_DATABASE_TO_PHYSICAL_DATABASE";
	public static final String PHYSICAL_DATABASE_TO_LOGICAL_DATABASE = "PHYSICAL_DATABASE_TO_LOGICAL_DATABASE";
	
	public static final String ENTITY_EXTENSION = "entity";
	public static final String OIS_EXTENSION = "ois";
	public static final String DATABASE_EXTENSION = "database";
	public static final String SCAFFOLD_EXTENSION = "scaffold";
	
	protected URI getModelURI(Object element) {
		if (element instanceof IFile) {
			return URI.createPlatformResourceURI(((IFile)element).getFullPath().toString(), true);
		} else if (element instanceof Resource) {
			return ((Resource)element).getURI();
		} else if (element instanceof EObject) {
			Resource eResource = ((EObject)element).eResource();
			if (eResource != null) {
				return eResource.getURI();
			} else {
				return null;
			}
		}
		return null;
	}
	
	protected ScaffoldType getCorrespondingScaffoldType(String kind) {
		if (ENTITY_TO_LOGICAL_DATABASE.equals(kind)) {
			return ScaffoldType.ENTITY_TO_MLD;							
		} else if (LOGICAL_DATABASE_TO_ENTITY.equals(kind)) {
			return ScaffoldType.MLD_TO_ENTITY;
		} else if (LOGICAL_DATABASE_TO_PHYSICAL_DATABASE.equals(kind)) {
			return ScaffoldType.MLD_TO_MPD;
		} else if (PHYSICAL_DATABASE_TO_LOGICAL_DATABASE.equals(kind)) {
			return ScaffoldType.MPD_TO_MLD;
		}
		return null;
	}

}
