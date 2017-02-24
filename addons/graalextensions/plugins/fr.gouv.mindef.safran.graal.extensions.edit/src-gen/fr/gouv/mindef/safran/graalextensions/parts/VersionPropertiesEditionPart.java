/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts;

// Start of user code for imports



// End of user code

/**
 * @author Obeo.fr
 * 
 */
public interface VersionPropertiesEditionPart {

	/**
	 * @return the modifiedOn
	 * 
	 */
	public String getModifiedOn();

	/**
	 * Defines a new modifiedOn
	 * @param newValue the new modifiedOn to set
	 * 
	 */
	public void setModifiedOn(String newValue);


	/**
	 * @return the createdOn
	 * 
	 */
	public String getCreatedOn();

	/**
	 * Defines a new createdOn
	 * @param newValue the new createdOn to set
	 * 
	 */
	public void setCreatedOn(String newValue);




	// Start of user code for version specific getters and setters declaration
	
	public Integer getVersion();
	public void setVersion(Integer version);
	
	// End of user code

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
