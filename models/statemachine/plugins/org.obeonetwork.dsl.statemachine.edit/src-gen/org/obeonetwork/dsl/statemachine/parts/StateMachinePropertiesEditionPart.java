/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
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
package org.obeonetwork.dsl.statemachine.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface StateMachinePropertiesEditionPart {

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
	 * Init the regions
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRegions(ReferencesTableSettings settings);

	/**
	 * Update the regions
	 * @param newValue the regions to update
	 * 
	 */
	public void updateRegions();

	/**
	 * Adds the given filter to the regions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRegions(ViewerFilter filter);

	/**
	 * Adds the given filter to the regions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRegions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the regions table
	 * 
	 */
	public boolean isContainedInRegionsTable(EObject element);


	/**
	 * @return the keywords
	 * 
	 */
	public EList getKeywords();

	/**
	 * Defines a new keywords
	 * @param newValue the new keywords to set
	 * 
	 */
	public void setKeywords(EList newValue);

	/**
	 * Add a value to the keywords multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToKeywords(Object newValue);

	/**
	 * Remove a value to the keywords multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToKeywords(Object newValue);


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
