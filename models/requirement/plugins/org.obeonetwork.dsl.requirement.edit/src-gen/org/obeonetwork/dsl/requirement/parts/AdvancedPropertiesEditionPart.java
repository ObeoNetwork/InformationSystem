/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
public interface AdvancedPropertiesEditionPart {

	/**
	 * @return the rationale
	 * 
	 */
	public String getRationale();

	/**
	 * Defines a new rationale
	 * @param newValue the new rationale to set
	 * 
	 */
	public void setRationale(String newValue);


	/**
	 * @return the acceptanceCriteria
	 * 
	 */
	public String getAcceptanceCriteria();

	/**
	 * Defines a new acceptanceCriteria
	 * @param newValue the new acceptanceCriteria to set
	 * 
	 */
	public void setAcceptanceCriteria(String newValue);




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
