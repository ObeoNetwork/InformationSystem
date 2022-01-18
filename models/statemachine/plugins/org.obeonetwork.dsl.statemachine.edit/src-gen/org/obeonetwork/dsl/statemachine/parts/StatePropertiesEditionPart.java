/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
public interface StatePropertiesEditionPart {

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
	 * Init the incomingTransitions
	 * @param settings settings for the incomingTransitions ReferencesTable 
	 */
	public void initIncomingTransitions(ReferencesTableSettings settings);

	/**
	 * Update the incomingTransitions
	 * @param newValue the incomingTransitions to update
	 * 
	 */
	public void updateIncomingTransitions();

	/**
	 * Adds the given filter to the incomingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToIncomingTransitions(ViewerFilter filter);

	/**
	 * Adds the given filter to the incomingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToIncomingTransitions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the incomingTransitions table
	 * 
	 */
	public boolean isContainedInIncomingTransitionsTable(EObject element);




	/**
	 * Init the outcomingTransitions
	 * @param settings settings for the outcomingTransitions ReferencesTable 
	 */
	public void initOutcomingTransitions(ReferencesTableSettings settings);

	/**
	 * Update the outcomingTransitions
	 * @param newValue the outcomingTransitions to update
	 * 
	 */
	public void updateOutcomingTransitions();

	/**
	 * Adds the given filter to the outcomingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOutcomingTransitions(ViewerFilter filter);

	/**
	 * Adds the given filter to the outcomingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOutcomingTransitions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outcomingTransitions table
	 * 
	 */
	public boolean isContainedInOutcomingTransitionsTable(EObject element);


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
