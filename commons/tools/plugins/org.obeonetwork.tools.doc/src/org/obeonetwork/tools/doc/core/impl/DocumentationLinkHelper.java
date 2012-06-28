/**
 * 
 */
package org.obeonetwork.tools.doc.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.tools.linker.EObjectLinker;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DocumentationLinkHelper {

	public static final EObjectLinker getDocumentationLinker(EObject source) {
		EObjectLinker linker = EObjectLinker.getLinker(source);
		if (linker != null) {
			linker.registerType(new DocumentationLinkType());
		}
		return linker;
	}
	
}
