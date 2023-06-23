/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.environment.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface OppositePropertiesEditionPart {

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
	 * @return the referencedType
	 * 
	 */
	public EObject getReferencedType();

	/**
	 * Init the referencedType
	 * @param settings the combo setting
	 */
	public void initReferencedType(EObjectFlatComboSettings settings);

	/**
	 * Defines a new referencedType
	 * @param newValue the new referencedType to set
	 * 
	 */
	public void setReferencedType(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setReferencedTypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the referencedType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToReferencedType(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencedType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToReferencedType(ViewerFilter filter);


	/**
	 * @return the multiplicity
	 * 
	 */
	public Enumerator getMultiplicity();

	/**
	 * Init the multiplicity
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initMultiplicity(Object input, Enumerator current);

	/**
	 * Defines a new multiplicity
	 * @param newValue the new multiplicity to set
	 * 
	 */
	public void setMultiplicity(Enumerator newValue);


	/**
	 * @return the isComposite
	 * 
	 */
	public Boolean getIsComposite();

	/**
	 * Defines a new isComposite
	 * @param newValue the new isComposite to set
	 * 
	 */
	public void setIsComposite(Boolean newValue);


	/**
	 * @return the navigable
	 * 
	 */
	public Boolean getNavigable();

	/**
	 * Defines a new navigable
	 * @param newValue the new navigable to set
	 * 
	 */
	public void setNavigable(Boolean newValue);


	/**
	 * @return the identifier
	 * 
	 */
	public Boolean getIdentifier();

	/**
	 * Defines a new identifier
	 * @param newValue the new identifier to set
	 * 
	 */
	public void setIdentifier(Boolean newValue);


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
