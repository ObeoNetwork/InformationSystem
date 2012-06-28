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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.cinematic.NamedElement;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;

public class CinematicEcoreServices {
	
	public static Collection<EObject> getAllRootsForCinematic(EObject any) {
		Collection<EObject> roots = new ArrayList<EObject>();
		
		Session session = SessionManager.INSTANCE.getSession(any);
		
		if (session != null) {
			for (Resource childRes : session.getSemanticResources()) {
				roots.addAll(childRes.getContents());
			}
		}
		
		return roots;
	}
	
	@SuppressWarnings("unchecked")
	public static EObject duplicateCinematicElement(EObject context) {
		EObject clone = EcoreUtil.copy(context);
		if (clone instanceof NamedElement) {
			NamedElement namedElement = (NamedElement)clone;
			namedElement.setName(namedElement.getName() + " copy");
		}
		EStructuralFeature containmentFeature = context.eContainingFeature();
		Object feature = context.eContainer().eGet(containmentFeature, true);
		if (feature instanceof Collection) {
			((Collection<EObject>)feature).add(clone);
		}
		
		return clone;
	}
}
