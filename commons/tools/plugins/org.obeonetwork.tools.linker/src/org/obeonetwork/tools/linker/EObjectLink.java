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
