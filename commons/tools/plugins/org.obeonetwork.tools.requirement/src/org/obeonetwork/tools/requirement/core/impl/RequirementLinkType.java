/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.requirement.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.LinkType;
import org.obeonetwork.tools.requirement.core.util.RequirementService;

/**
 * @author Obeo
 *
 */
public class RequirementLinkType implements LinkType {

	public static final String REQUIREMENT_LINK_TYPE = "org.obeonetwork.tools.requirement.linktype"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.LinkType#getId()
	 */
	public String getId() {
		return REQUIREMENT_LINK_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.LinkType#loadLinks(org.eclipse.emf.ecore.EObject)
	 */
	public List<EObjectLink> loadLinks(EObject source) {
		List<EObjectLink> links = new ArrayList<EObjectLink>();
		Requirement[] linkedRequirements = RequirementService.getLinkedRequirements(source);
		if (linkedRequirements.length > 0) {
			for (Requirement requirement : linkedRequirements) {
				links.add(new RequirementLinkImpl(requirement, source));
			}
		}
		return links;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.LinkType#createLink(org.eclipse.emf.ecore.EObject)
	 */
	public EObjectLink createLink(EObject source) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.LinkType#delete(org.obeonetwork.tools.linker.EObjectLink)
	 */
	public void delete(EObjectLink link) {
		// TODO Auto-generated method stub

	}

}
