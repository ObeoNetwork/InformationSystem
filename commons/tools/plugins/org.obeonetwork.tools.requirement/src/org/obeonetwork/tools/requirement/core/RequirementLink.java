/**
 * 
 */
package org.obeonetwork.tools.requirement.core;

import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.linker.EObjectLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface RequirementLink extends EObjectLink {

	/**
	 * @return the Requirement.
	 */
	public abstract Requirement getRequirement();

	
	
}
