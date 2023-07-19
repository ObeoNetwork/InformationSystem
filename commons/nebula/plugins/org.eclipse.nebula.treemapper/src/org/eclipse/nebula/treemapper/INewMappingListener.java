/*******************************************************************************
* Copyright (c) 2011, 2016 PetalsLink
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
* Mickael Istria, PetalsLink - initial API and implementation
*******************************************************************************/
package org.eclipse.nebula.treemapper;


/**
 * Listener for the creation of new mapping in a {@link TreeMapper}. To be used when the
 * list of mapping specified to {@link TreeMapper#setInput(Object, Object, java.util.List)}
 * is not intended to be used as a reference to the concrete list of mappings. 
 * 
 * @author Obeo
 * @since 0.1.0
 * 
 * @param <M> the datatype of the mappings object 
 */
public interface INewMappingListener<M> {

	/**
	 * Notify that the user just added a new mapping.
	 * @param mapping the newly created mapping.
	 */
	void mappingCreated(M mapping);

}
