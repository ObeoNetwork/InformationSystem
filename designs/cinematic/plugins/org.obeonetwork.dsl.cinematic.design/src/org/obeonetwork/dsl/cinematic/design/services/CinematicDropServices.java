/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class CinematicDropServices {
	
	public static boolean isDropAllowedForCinematicElementOn(EObject element, EObject container) {
		EList<EReference> containmentReferences = container.eClass().getEAllContainments();
		for (EReference eReference : containmentReferences) {
			if (eReference.getEType() != null) {
				if (eReference.getEType().isInstance(element)) {
					return true;
				}
			}
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static EObject dropOnCinematicContainer(EObject element, EObject container) {
		EList<EReference> containmentReferences = container.eClass().getEAllContainments();
		for (EReference eReference : containmentReferences) {
			if (eReference.getEType() != null) {
				if (eReference.getEType().isInstance(element)) {
					// We're going to move the element into this containment feature
					Object oldValues = container.eGet(eReference, true);
					if (oldValues instanceof Collection) {
						((Collection)oldValues).add(element);
					}
//					container.eSet(eReference, oldValues);
					return element;
				}
			}
		}
		return element;
	}
}
