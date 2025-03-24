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
package org.obeonetwork.graal.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface LoopPropertiesEditionPart {

	/**
	 * @return the lowerBound
	 * 
	 */
	public String getLowerBound();

	/**
	 * Defines a new lowerBound
	 * @param newValue the new lowerBound to set
	 * 
	 */
	public void setLowerBound(String newValue);


	/**
	 * @return the upperBound
	 * 
	 */
	public String getUpperBound();

	/**
	 * Defines a new upperBound
	 * @param newValue the new upperBound to set
	 * 
	 */
	public void setUpperBound(String newValue);


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
	 * Init the subActivities
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSubActivities(ReferencesTableSettings settings);

	/**
	 * Update the subActivities
	 * @param newValue the subActivities to update
	 * 
	 */
	public void updateSubActivities();

	/**
	 * Adds the given filter to the subActivities edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSubActivities(ViewerFilter filter);

	/**
	 * Adds the given filter to the subActivities edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSubActivities(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the subActivities table
	 * 
	 */
	public boolean isContainedInSubActivitiesTable(EObject element);





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
