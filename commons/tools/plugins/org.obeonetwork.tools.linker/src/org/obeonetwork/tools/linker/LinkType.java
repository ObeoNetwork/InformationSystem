/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.linker;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface LinkType {
	
	/**
	 * @return an unique ID for the type of link.
	 */
	String getId();
	
	/**
	 * Loads the link of the given {@link EObject}.
	 * @param source eObject to process.
	 * @return List of {@link EObjectLink} for this element.
	 */
	List<EObjectLink> loadLinks(EObject source);
	
	/**
	 * Creates a new {@link EObjectLink}.
	 * @param source Element to link.
	 * @return the created link.
	 */
	EObjectLink createLink(EObject source);

	
	/**
	 * Removes the given {@link EObjectLink} of it source.
	 * @param link
	 */
	void delete(EObjectLink link);
}
