/**
 * 
 */
package org.obeonetwork.tools.requirement.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.tools.linker.EObjectLinker;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RequirementLinkHelper {

	/**
	 * @param source
	 * @return
	 */
	public static final EObjectLinker getRequirementLinker(EObject source) {
		EObjectLinker linker = EObjectLinker.getLinker(source);
		if (linker != null) {
			linker.registerType(new RequirementLinkType());
		}
		return linker;
	}
	
}
