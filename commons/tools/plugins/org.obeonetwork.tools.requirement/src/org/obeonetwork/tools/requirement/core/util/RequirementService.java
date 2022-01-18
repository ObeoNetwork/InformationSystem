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
package org.obeonetwork.tools.requirement.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

/**
 * Utilities for {@link Requirement Requirements}.
 */
public class RequirementService {
	
	/**
	 * Checks whether the object has at least one linked requirement
	 * @param eObject
	 * @return true if there is at least one linked requirement
	 */
	public static boolean hasLinkedRequirement(EObject eObject) {
		return getLinkedRequirements(eObject).length > 0;
	}
	
	/**
	 * Checks whether one of the object's descendant has a linked requirement
	 * @param eObject
	 * @return
	 */
	public static boolean hasDescendantWithLinkedRequirement(EObject eObject) {
		return hasLinkedRequirementOrDescendantWithLinkedRequirement(eObject.eContents());
	}
	
	public static boolean hasLinkedRequirementOrDescendantWithLinkedRequirement(List<EObject> children) {
		// Check if one of the children has a requirement
		for (EObject child : children) {
			if (hasLinkedRequirement(child)) {
				return true;
			}
		}
		// if not, let's check descendants
		for (EObject child : children) {
			if (hasDescendantWithLinkedRequirement(child)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the {@link Requirement Requirements} linked to the given
	 * {@link EObject}.
	 * 
	 * @param eObject
	 *            the {@link EObject}.
	 * @return the {@link Requirement Requirements} within the {@link Session}
	 *         of {@code eObject} which are linked to {@code eObject}.
	 */
	public static Requirement[] getLinkedRequirements(EObject eObject) {
		Set<Requirement> linkedRequirements = getLinkedRequirementsSet(eObject);
		return linkedRequirements.toArray(new Requirement[linkedRequirements.size()]);
	}

	/**
	 * Retrieves the {@link Requirement Requirements} linked to the given
	 * {@link EObject}.
	 * 
	 * @param eObject
	 *            the {@link EObject}.
	 * @return the {@link Requirement Requirements} within the {@link Session}
	 *         of {@code eObject} which are linked to {@code eObject}.
	 */
	public static Set<Requirement> getLinkedRequirementsSet(EObject eObject) {
		final Session session = SessionManager.INSTANCE.getSession(eObject);
		if (session != null) {
			return getLinkedRequirements(session, eObject);
		}
		return new HashSet<Requirement>();
	}

	private static Set<Requirement> getLinkedRequirements(Session session, EObject eObject) {
		ECrossReferenceAdapter crossReferenceAdapter = session.getSemanticCrossReferencer();
		HashSet<Requirement> linkedRequirements = new HashSet<Requirement>();
		for (Setting setting : crossReferenceAdapter.getInverseReferences(eObject)) {
			if (setting != null && setting.getEObject() instanceof Requirement) {
				Requirement requirement = (Requirement) setting.getEObject();

				// Check if requirement really references the object
				// Workaround to avoid a problem with CrossReferencer containing
				// duplicates
				if (requirement.getReferencedObject().contains(eObject)) {
					linkedRequirements.add(requirement);
				}

			}
		}
		return linkedRequirements;
	}

	/**
	 * 
	 * @param context
	 * @return the {@link Resource Resources} within the {@link Session} of
	 *         {@code context} whose contents is a {@link Repository}.
	 */
	public static Collection<Resource> findRequirementsRepositories(EObject context) {
		final Collection<Resource> repositories = new ArrayList<Resource>();

		Session session = SessionManager.INSTANCE.getSession(context);
		if (session != null) {
			// Test resources containing requirements repositories
			for (Resource semanticResource : session.getSemanticResources()) {
				for (EObject object : semanticResource.getContents()) {
					if (object instanceof Repository) {
						repositories.add(semanticResource);
						break;
					}
				}
			}
		}
		return repositories;
	}
}
