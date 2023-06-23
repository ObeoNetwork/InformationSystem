/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * @author Obeo.fr
 * 
 */
public interface RiskPropertiesEditionPart {

	/**
	 * @return the benefits
	 * 
	 */
	public Enumerator getBenefits();

	/**
	 * Init the benefits
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initBenefits(Object input, Enumerator current);

	/**
	 * Defines a new benefits
	 * @param newValue the new benefits to set
	 * 
	 */
	public void setBenefits(Enumerator newValue);


	/**
	 * @return the drawbacks
	 * 
	 */
	public Enumerator getDrawbacks();

	/**
	 * Init the drawbacks
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initDrawbacks(Object input, Enumerator current);

	/**
	 * Defines a new drawbacks
	 * @param newValue the new drawbacks to set
	 * 
	 */
	public void setDrawbacks(Enumerator newValue);


	/**
	 * @return the risk
	 * 
	 */
	public Enumerator getRisk();

	/**
	 * Init the risk
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRisk(Object input, Enumerator current);

	/**
	 * Defines a new risk
	 * @param newValue the new risk to set
	 * 
	 */
	public void setRisk(Enumerator newValue);





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
