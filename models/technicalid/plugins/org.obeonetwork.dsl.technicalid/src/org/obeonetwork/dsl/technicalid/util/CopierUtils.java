/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.technicalid.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.technicalid.Identifiable;

public class CopierUtils {

	public static <T extends EObject> T copy(T element) {
		EObject newObject = EcoreUtil.copy(element);
		if (newObject instanceof Identifiable) {
			// Set a new Id for the new object and its children
			generateNewIds((Identifiable)newObject);
		}
		@SuppressWarnings("unchecked") T result = (T)newObject;
		return result;
	}
	
	public static <T> Collection<T> copyAll(Collection<? extends T> eObjects) {
		Collection<T> newObjects = EcoreUtil.copyAll(eObjects);
		for (T newObject : newObjects) {
			if (newObject instanceof Identifiable) {
				// Set a new Id for the new object and its children
				generateNewIds((Identifiable)newObject);
			}
		}
		return newObjects;
	}
	
	private static void generateNewIds(Identifiable element) {
		element.setTechnicalid(EcoreUtil.generateUUID());
		for (EObject child : element.eContents()) {
			if (child instanceof Identifiable) {
				generateNewIds((Identifiable)child);
			}
		}
	}
}
