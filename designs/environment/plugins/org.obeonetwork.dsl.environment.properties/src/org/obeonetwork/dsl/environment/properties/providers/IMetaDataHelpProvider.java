/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties.providers;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * 
 * @author Obeo
 *
 */
public interface IMetaDataHelpProvider {
	
	/**
	 * Returns an help message provided by the {@link ObeoDSMObject} 
	 * @param dsmObject a {@link ObeoDSMObject}
	 * @return a {@link String}
	 * 
	 * Make sure to return an empty {@link String} or <code>null</code>, 
	 * if the {@link ObeoDSMObject} provided is not conforming to the expected class.
	 */
	public String getHelpMessage(ObeoDSMObject dsmObject);	
	
}
