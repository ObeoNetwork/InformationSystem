/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
public interface TaskPropertiesEditionPart {

	/**
	 * @return the id
	 * 
	 */
	public String getId();

	/**
	 * Defines a new id
	 * @param newValue the new id to set
	 * 
	 */
	public void setId(String newValue);


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
	 * @return the preconditions
	 * 
	 */
	public String getPreconditions();

	/**
	 * Defines a new preconditions
	 * @param newValue the new preconditions to set
	 * 
	 */
	public void setPreconditions(String newValue);


	/**
	 * @return the postconditions
	 * 
	 */
	public String getPostconditions();

	/**
	 * Defines a new postconditions
	 * @param newValue the new postconditions to set
	 * 
	 */
	public void setPostconditions(String newValue);




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
	 * Init the actors
	 * @param settings settings for the actors ReferencesTable 
	 */
	public void initActors(ReferencesTableSettings settings);

	/**
	 * Update the actors
	 * @param newValue the actors to update
	 * 
	 */
	public void updateActors();

	/**
	 * Adds the given filter to the actors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToActors(ViewerFilter filter);

	/**
	 * Adds the given filter to the actors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToActors(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the actors table
	 * 
	 */
	public boolean isContainedInActorsTable(EObject element);




	/**
	 * Init the uses
	 * @param settings settings for the uses ReferencesTable 
	 */
	public void initUses(ReferencesTableSettings settings);

	/**
	 * Update the uses
	 * @param newValue the uses to update
	 * 
	 */
	public void updateUses();

	/**
	 * Adds the given filter to the uses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToUses(ViewerFilter filter);

	/**
	 * Adds the given filter to the uses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToUses(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the uses table
	 * 
	 */
	public boolean isContainedInUsesTable(EObject element);





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
