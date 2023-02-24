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
public interface BindingReferencePropertiesEditionPart {

	/**
	 * @return the left
	 * 
	 */
	public Object getLeft();

	/**
	 * Init the left
	 * @param input choice of values
	 * @param currentValue the current value
	 */
	public void initLeft(Object input, Object currentValue);

	/**
	 * Defines a new left
	 * @param newValue the new left to set
	 * 
	 */
	public void setLeft(Object newValue);

	/**
	 * Adds the given filter to the left edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLeft(ViewerFilter filter);


	/**
	 * @return the right
	 * 
	 */
	public Object getRight();

	/**
	 * Init the right
	 * @param input choice of values
	 * @param currentValue the current value
	 */
	public void initRight(Object input, Object currentValue);

	/**
	 * Defines a new right
	 * @param newValue the new right to set
	 * 
	 */
	public void setRight(Object newValue);

	/**
	 * Adds the given filter to the right edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRight(ViewerFilter filter);


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
