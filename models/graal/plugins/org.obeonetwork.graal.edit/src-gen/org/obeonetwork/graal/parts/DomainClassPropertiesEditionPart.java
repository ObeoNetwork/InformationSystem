/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface DomainClassPropertiesEditionPart {

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
	 * @return the superType
	 * 
	 */
	public EObject getSuperType();

	/**
	 * Init the superType
	 * @param settings the combo setting
	 */
	public void initSuperType(EObjectFlatComboSettings settings);

	/**
	 * Defines a new superType
	 * @param newValue the new superType to set
	 * 
	 */
	public void setSuperType(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSuperTypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the superType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSuperType(ViewerFilter filter);

	/**
	 * Adds the given filter to the superType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSuperType(ViewerFilter filter);




	/**
	 * Init the associatedTypes
	 * @param settings settings for the associatedTypes ReferencesTable 
	 */
	public void initAssociatedTypes(ReferencesTableSettings settings);

	/**
	 * Update the associatedTypes
	 * @param newValue the associatedTypes to update
	 * 
	 */
	public void updateAssociatedTypes();

	/**
	 * Adds the given filter to the associatedTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToAssociatedTypes(ViewerFilter filter);

	/**
	 * Adds the given filter to the associatedTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToAssociatedTypes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the associatedTypes table
	 * 
	 */
	public boolean isContainedInAssociatedTypesTable(EObject element);


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
