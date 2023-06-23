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
package org.obeonetwork.dsl.soa.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public interface ServicePropertiesEditionPart {

	/**
	 * @return the synchronization
	 * 
	 */
	public Enumerator getSynchronization();

	/**
	 * Init the synchronization
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSynchronization(Object input, Enumerator current);

	/**
	 * Defines a new synchronization
	 * @param newValue the new synchronization to set
	 * 
	 */
	public void setSynchronization(Enumerator newValue);


	/**
	 * @return the kind
	 * 
	 */
	public Enumerator getKind();

	/**
	 * Init the kind
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initKind(Object input, Enumerator current);

	/**
	 * Defines a new kind
	 * @param newValue the new kind to set
	 * 
	 */
	public void setKind(Enumerator newValue);


	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
