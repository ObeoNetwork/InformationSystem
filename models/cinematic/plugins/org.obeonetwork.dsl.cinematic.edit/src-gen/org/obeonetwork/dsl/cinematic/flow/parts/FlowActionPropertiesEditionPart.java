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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface FlowActionPropertiesEditionPart {

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
	 * Init the calls
	 * @param settings settings for the calls ReferencesTable 
	 */
	public void initCalls(ReferencesTableSettings settings);

	/**
	 * Update the calls
	 * @param newValue the calls to update
	 * 
	 */
	public void updateCalls();

	/**
	 * Adds the given filter to the calls edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCalls(ViewerFilter filter);

	/**
	 * Adds the given filter to the calls edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCalls(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the calls table
	 * 
	 */
	public boolean isContainedInCallsTable(EObject element);




	/**
	 * Init the operations
	 * @param settings settings for the operations ReferencesTable 
	 */
	public void initOperations(ReferencesTableSettings settings);

	/**
	 * Update the operations
	 * @param newValue the operations to update
	 * 
	 */
	public void updateOperations();

	/**
	 * Adds the given filter to the operations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter);

	/**
	 * Adds the given filter to the operations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the operations table
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element);


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
