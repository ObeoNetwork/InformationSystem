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
package org.obeonetwork.graal.parts;

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
public interface TransitionPropertiesEditionPart {

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
	 * @return the kind
	 * 
	 */
	public Enumerator getKind();

	/**
	 * Init the kind
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initKind(Object input, Enumerator current);

	/**
	 * Defines a new kind
	 * @param newValue the new kind to set
	 * 
	 */
	public void setKind(Enumerator newValue);


	/**
	 * @return the source
	 * 
	 */
	public EObject getSource();

	/**
	 * Init the source
	 * @param settings the combo setting
	 */
	public void initSource(EObjectFlatComboSettings settings);

	/**
	 * Defines a new source
	 * @param newValue the new source to set
	 * 
	 */
	public void setSource(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter);


	/**
	 * @return the target
	 * 
	 */
	public EObject getTarget();

	/**
	 * Init the target
	 * @param settings the combo setting
	 */
	public void initTarget(EObjectFlatComboSettings settings);

	/**
	 * Defines a new target
	 * @param newValue the new target to set
	 * 
	 */
	public void setTarget(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTargetButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the target edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTarget(ViewerFilter filter);

	/**
	 * Adds the given filter to the target edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTarget(ViewerFilter filter);


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
