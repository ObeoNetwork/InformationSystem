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
/**
 * 
 */
package org.obeonetwork.tools.requirement.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.core.RequirementLink;

/**
 * @author Obeo
 *
 */
public class RequirementLinkImpl implements RequirementLink {

	private Requirement requirement;
	protected EObject source;

	/**
	 * @param source
	 */
	public RequirementLinkImpl(Requirement requirement, EObject source) {
		this.requirement = requirement;
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.EObjectLink#getType()
	 */
	public String getType() {
		return RequirementLinkType.REQUIREMENT_LINK_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.EObjectLink#getSource()
	 */
	public EObject getSource() {
		return source;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.EObjectLink#delete()
	 */
	public void delete() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.requirement.core.RequirementLink#getRequirement()
	 */
	public Requirement getRequirement() {
		return requirement;
	}

}
