/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.transfo.collab;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.ecore.extender.business.api.permission.exception.LockedInstanceException;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.transfo.InitializerException;
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
