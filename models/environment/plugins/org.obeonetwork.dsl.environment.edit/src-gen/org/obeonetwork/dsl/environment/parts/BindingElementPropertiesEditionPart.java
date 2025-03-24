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
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts;

// Start of user code for imports
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface BindingElementPropertiesEditionPart {

	/**
	 * @return the boundElement
	 * 
	 */
	public Object getBoundElement();

	/**
	 * Init the boundElement
	 * @param input choice of values
	 * @param currentValue the current value
	 */
	public void initBoundElement(Object input, Object currentValue);

	/**
	 * Defines a new boundElement
	 * @param newValue the new boundElement to set
	 * 
	 */
	public void setBoundElement(Object newValue);

	/**
	 * Adds the given filter to the boundElement edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToBoundElement(ViewerFilter filter);


	/**
	 * @return the bindingExpression
	 * 
	 */
	public String getBindingExpression();

	/**
	 * Defines a new bindingExpression
	 * @param newValue the new bindingExpression to set
	 * 
	 */
	public void setBindingExpression(String newValue);


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
