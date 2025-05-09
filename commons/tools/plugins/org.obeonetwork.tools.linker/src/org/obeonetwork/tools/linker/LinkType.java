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
package org.obeonetwork.tools.linker;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Obeo
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
