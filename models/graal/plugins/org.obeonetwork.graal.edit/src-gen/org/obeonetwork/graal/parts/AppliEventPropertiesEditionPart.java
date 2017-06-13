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
public interface AppliEventPropertiesEditionPart {

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
	 * Init the outgoingTransitions
	 * @param settings settings for the outgoingTransitions ReferencesTable 
	 */
	public void initOutgoingTransitions(ReferencesTableSettings settings);

	/**
	 * Update the outgoingTransitions
	 * @param newValue the outgoingTransitions to update
	 * 
	 */
	public void updateOutgoingTransitions();

	/**
	 * Adds the given filter to the outgoingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOutgoingTransitions(ViewerFilter filter);

	/**
	 * Adds the given filter to the outgoingTransitions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOutgoingTransitions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outgoingTransitions table
	 * 
	 */
	public boolean isContainedInOutgoingTransitionsTable(EObject element);




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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
