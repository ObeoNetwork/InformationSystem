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
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface SequencePropertiesEditionPart {

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
	 * @return the start
	 * 
	 */
	public String getStart();

	/**
	 * Defines a new start
	 * @param newValue the new start to set
	 * 
	 */
	public void setStart(String newValue);


	/**
	 * @return the increment
	 * 
	 */
	public String getIncrement();

	/**
	 * Defines a new increment
	 * @param newValue the new increment to set
	 * 
	 */
	public void setIncrement(String newValue);


	/**
	 * @return the min value
	 * 
	 */
	public String getMinValue();

	/**
	 * Defines a new min value
	 * @param newValue the new min value to set
	 * 
	 */
	public void setMinValue(String newValue);


	/**
	 * @return the max value
	 * 
	 */
	public String getMaxValue();

	/**
	 * Defines a new max value
	 * @param newValue the new max value to set
	 * 
	 */
	public void setMaxValue(String newValue);


	/**
	 * @return the cycle
	 * 
	 */
	public Boolean getCycle();

	/**
	 * Defines a new cycle
	 * @param newValue the new cycle to set
	 * 
	 */
	public void setCycle(Boolean newValue);


	/**
	 * @return the cache size
	 * 
	 */
	public String getCacheSize();

	/**
	 * Defines a new cache size
	 * @param newValue the new cache size to set
	 * 
	 */
	public void setCacheSize(String newValue);


	/**
	 * @return the comments
	 * 
	 */
	public String getComments();

	/**
	 * Defines a new comments
	 * @param newValue the new comments to set
	 * 
	 */
	public void setComments(String newValue);





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
