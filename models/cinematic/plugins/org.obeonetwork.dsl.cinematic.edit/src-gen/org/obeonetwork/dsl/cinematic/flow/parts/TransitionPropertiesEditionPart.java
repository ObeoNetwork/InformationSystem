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
package org.obeonetwork.dsl.cinematic.flow.parts;

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
public interface TransitionPropertiesEditionPart {

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
	 * @return the guard
	 * 
	 */
	public String getGuard();

	/**
	 * Defines a new guard
	 * @param newValue the new guard to set
	 * 
	 */
	public void setGuard(String newValue);


	/**
	 * @return the modal
	 * 
	 */
	public Boolean getModal();

	/**
	 * Defines a new modal
	 * @param newValue the new modal to set
	 * 
	 */
	public void setModal(Boolean newValue);




	/**
	 * Init the on
	 * @param settings settings for the on ReferencesTable 
	 */
	public void initOn(ReferencesTableSettings settings);

	/**
	 * Update the on
	 * @param newValue the on to update
	 * 
	 */
	public void updateOn();

	/**
	 * Adds the given filter to the on edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOn(ViewerFilter filter);

	/**
	 * Adds the given filter to the on edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOn(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the on table
	 * 
	 */
	public boolean isContainedInOnTable(EObject element);


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
	 * @return the from
	 * 
	 */
	public EObject getFrom();

	/**
	 * Init the from
	 * @param settings the combo setting
	 */
	public void initFrom(EObjectFlatComboSettings settings);

	/**
	 * Defines a new from
	 * @param newValue the new from to set
	 * 
	 */
	public void setFrom(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setFromButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the from edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFrom(ViewerFilter filter);

	/**
	 * Adds the given filter to the from edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFrom(ViewerFilter filter);


	/**
	 * @return the to
	 * 
	 */
	public EObject getTo();

	/**
	 * Init the to
	 * @param settings the combo setting
	 */
	public void initTo(EObjectFlatComboSettings settings);

	/**
	 * Defines a new to
	 * @param newValue the new to to set
	 * 
	 */
	public void setTo(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setToButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the to edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTo(ViewerFilter filter);

	/**
	 * Adds the given filter to the to edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTo(ViewerFilter filter);





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
