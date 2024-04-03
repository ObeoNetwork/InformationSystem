/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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

import org.eclipse.emf.ecore.EObject;


/**
 * @author Obeo
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
