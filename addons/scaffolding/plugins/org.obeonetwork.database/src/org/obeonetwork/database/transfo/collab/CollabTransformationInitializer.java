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
package org.obeonetwork.database.transfo.collab;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.ecore.extender.business.api.permission.exception.LockedInstanceException;

import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldType;
import org.obeonetwork.database.transfo.InitializerException;
import fr.obeo.dsl.viewpoint.collab.api.lock.CDOLockManager;

public class CollabTransformationInitializer {

	/**
	 * Initialize the transformation for a collaborative modeling project
	 * @param traceabilityMap 
	 * @param references 
	 * @param targetObject 
	 * @param sourceObject 
	 * @param scaffoldType 
	 * @param scaffoldInfo 
	 * @throws InitializerException Exception thrown if a problem occured during initialization
	 */
	public void initialize(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType) throws InitializerException {
		EObject targetObject = scaffoldInfo.getEndingObjectForTransformation(scaffoldType);
		
		// We have to acquire locks on target objects
		Collection<CDOObject> elementsToLock = new ArrayList<CDOObject>();
		if (scaffoldInfo.eResource() != null) {
			elementsToLock.add(scaffoldInfo);
		}
		if (targetObject instanceof CDOObject) {
			elementsToLock.add((CDOObject)targetObject);
		}
		try {
			Collection<CDOObject> lockedElements = CDOLockManager.INSTANCE.acquireLock(elementsToLock, false, true);			
		} catch (LockedInstanceException e) {
			throw new InitializerException("Transformation can not be executed : some elements are locked by other users");
		}
		
	}
}
