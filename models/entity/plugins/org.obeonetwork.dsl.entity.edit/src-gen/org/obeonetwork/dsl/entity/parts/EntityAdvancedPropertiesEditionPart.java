/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public interface EntityAdvancedPropertiesEditionPart {

	/**
	 * @return the estimatedVolumetry
	 * 
	 */
	public String getEstimatedVolumetry();

	/**
	 * Defines a new estimatedVolumetry
	 * @param newValue the new estimatedVolumetry to set
	 * 
	 */
	public void setEstimatedVolumetry(String newValue);


	/**
	 * @return the estimatedAccess
	 * 
	 */
	public String getEstimatedAccess();

	/**
	 * Defines a new estimatedAccess
	 * @param newValue the new estimatedAccess to set
	 * 
	 */
	public void setEstimatedAccess(String newValue);


	/**
	 * @return the historized
	 * 
	 */
	public Boolean getHistorized();

	/**
	 * Defines a new historized
	 * @param newValue the new historized to set
	 * 
	 */
	public void setHistorized(Boolean newValue);


	/**
	 * @return the inheritanceKind
	 * 
	 */
	public Enumerator getInheritanceKind();

	/**
	 * Init the inheritanceKind
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInheritanceKind(Object input, Enumerator current);

	/**
	 * Defines a new inheritanceKind
	 * @param newValue the new inheritanceKind to set
	 * 
	 */
	public void setInheritanceKind(Enumerator newValue);





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
