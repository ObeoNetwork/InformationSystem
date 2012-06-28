/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.tools.requirement.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.obeonetwork.dsl.requirement.Requirement;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;

public class RequirementService {
	
	private static final String REQUIREMENT_MODELFILE_EXTENSION = ".requirement"; //$NON-NLS-1$

	public static Requirement[] getLinkedRequirements(EObject eObject){
		final Session session = SessionManager.INSTANCE.getSession(eObject);
		if (session != null) {
			Set<Requirement> linkedRequirements = getLinkedRequirements(session, eObject);
			return linkedRequirements.toArray(new Requirement[linkedRequirements.size()]);
		}
		return new Requirement[0];
	}

	private static Set<Requirement> getLinkedRequirements(Session session, EObject eObject) {
		ECrossReferenceAdapter crossReferenceAdapter = session.getSemanticCrossReferencer();
		HashSet<Requirement> linkedRequirements = new HashSet<Requirement>();
		for (Setting setting : crossReferenceAdapter.getInverseReferences(eObject)) {
			if (setting.getEObject() instanceof Requirement) {
				Requirement requirement = (Requirement) setting.getEObject();
				linkedRequirements.add(requirement);
			}
		}
		return linkedRequirements;
	}

	public static Collection<Resource> findRequirementsRepositories(EObject context) {
		final ArrayList<Resource> repositories = new ArrayList<Resource>();
		
		Session session = SessionManager.INSTANCE.getSession(context);
		if (session != null) {
			for (Resource semanticResource : session.getSemanticResources()) {
				if (semanticResource.getURI().toString().endsWith(REQUIREMENT_MODELFILE_EXTENSION)) { 
					repositories.add(semanticResource);
				}
			}
		}
		return repositories;
	}
}
