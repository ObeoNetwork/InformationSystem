/**
 * 
 */
package org.obeonetwork.tools.requirement.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.core.RequirementLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
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
	 * @see org.obeonetwork.tools.linker.EObjectLink#getType()
	 */
	public String getType() {
		return RequirementLinkType.REQUIREMENT_LINK_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.EObjectLink#getSource()
	 */
	public EObject getSource() {
		return source;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.EObjectLink#delete()
	 */
	public void delete() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.requirement.core.RequirementLink#getRequirement()
	 */
	public Requirement getRequirement() {
		return requirement;
	}

	
}
