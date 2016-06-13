/**
 * 
 */
package org.obeonetwork.tools.linker;

import org.eclipse.emf.ecore.EObject;


/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface EObjectLink {
	
	/**
	 * @return the type of the link.
	 */
	String getType();

	/**
	 * @return the source of the link.
	 */
	EObject getSource();
	
	/**
	 * Delete the link
	 */
	void delete();

}
