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
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.technicalid.util.CopierUtils;

public class CinematicEcoreServices {
	
	public CinematicRoot getCinematicRoot(EObject any) {
		if (any instanceof CinematicRoot) {
			return (CinematicRoot)any;
		} else if (any instanceof DSemanticDecorator) {
			return getCinematicRoot(((DSemanticDecorator)any).getTarget());
		} else if (any == null) {
			return null;
		} else {
			return getCinematicRoot(any.eContainer());
			
		}
	}
	
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
		EObject clone = CopierUtils.copy(context);
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
	
	/**
	 * Return the abstractPackage container.
	 * @param context the AbstractPackage
	 * @return the container
	 */
	public AbstractPackage getAbstractPackageContainer(AbstractPackage context){
		EObject container = context.eContainer();
		AbstractPackage abstractPackageToReturn = null;
		while (container.eContainer() != null && !(context.eContainer() instanceof AbstractPackage)){
			container = container.eContainer();
		}
		if (container instanceof AbstractPackage){
			abstractPackageToReturn = (AbstractPackage)container;
		}
		return abstractPackageToReturn;
	}
	
	/**
	 * Return the type name.
	 * @param context the ViewEvent
	 * @return String, name type
	 */
	public String getTypeName(ViewEvent context){		
		return context.getType().getName();
	}
}
