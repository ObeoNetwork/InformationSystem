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
package org.obeonetwork.dsl.requirement.validation.rules;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

public class UniqueIdConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		if (eObject instanceof Requirement) {
			Requirement requirement = (Requirement)eObject;
			if (isRequirementIdUnique(requirement) == false) {
				return ctx.createFailureStatus(requirement.getId());
			}
		}
		return ctx.createSuccessStatus();
	}
	
	private boolean isRequirementIdUnique(Requirement requirement) {
		String searchedId = requirement.getId();
		if (searchedId == null || searchedId.equals("")) {
			// Id is not set we dont check for unicity
			return true;
		}
		boolean idAlreadyMet = false;
		ResourceSet set = requirement.eResource().getResourceSet();
		for(TreeIterator<Object> iter = EcoreUtil.getAllContents(set, true); iter.hasNext();) {
			Object content = iter.next();
			if (content instanceof Requirement) {
				String reqId = ((Requirement)content).getId();
				if (searchedId.equalsIgnoreCase(reqId)) {
					if (idAlreadyMet == false) {
						// First time we encounter this id, it's normal it's probably the one we're analyzing
						idAlreadyMet = true;
					} else {
						// Second time we encounter this id, this is not normal
						return false;
					}
				}
			}
			if (shouldGetChildren(content) == false) {
				iter.prune();
			}
		}
		return true;
	}
	
	private boolean shouldGetChildren(Object item) {
		return item instanceof Resource
				|| item instanceof Repository
				|| item instanceof Category;
	}

}
