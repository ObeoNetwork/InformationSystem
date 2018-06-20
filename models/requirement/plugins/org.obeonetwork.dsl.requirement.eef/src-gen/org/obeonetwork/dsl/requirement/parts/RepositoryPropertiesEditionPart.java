/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
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
package org.obeonetwork.dsl.requirement.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface RepositoryPropertiesEditionPart {

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
	 * Init the mainCategories
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initMainCategories(ReferencesTableSettings settings);

	/**
	 * Update the mainCategories
	 * @param newValue the mainCategories to update
	 * 
	 */
	public void updateMainCategories();

	/**
	 * Adds the given filter to the mainCategories edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMainCategories(ViewerFilter filter);

	/**
	 * Adds the given filter to the mainCategories edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMainCategories(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the mainCategories table
	 * 
	 */
	public boolean isContainedInMainCategoriesTable(EObject element);




	/**
	 * Init the referencedObject
	 * @param settings settings for the referencedObject ReferencesTable 
	 */
	public void initReferencedObject(ReferencesTableSettings settings);

	/**
	 * Update the referencedObject
	 * @param newValue the referencedObject to update
	 * 
	 */
	public void updateReferencedObject();

	/**
	 * Adds the given filter to the referencedObject edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencedObject(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencedObject edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencedObject(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the referencedObject table
	 * 
	 */
	public boolean isContainedInReferencedObjectTable(EObject element);





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
