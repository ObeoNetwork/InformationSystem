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
package org.obeonetwork.dsl.cinematic.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ToolkitsPropertiesEditionPart {



	/**
	 * Init the toolkits
	 * @param settings settings for the toolkits ReferencesTable 
	 */
	public void initToolkits(ReferencesTableSettings settings);

	/**
	 * Update the toolkits
	 * @param newValue the toolkits to update
	 * 
	 */
	public void updateToolkits();

	/**
	 * Adds the given filter to the toolkits edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToToolkits(ViewerFilter filter);

	/**
	 * Adds the given filter to the toolkits edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToToolkits(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the toolkits table
	 * 
	 */
	public boolean isContainedInToolkitsTable(EObject element);





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
