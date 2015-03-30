/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public interface EntityPropertiesEditionPart {

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
	 * @return the estimatedVolumetry
	 * 
	 */
	public String getEstimatedVolumetry();

	/**
	 * Defines a new estimatedVolumetry
	 * @param newValue the new estimatedVolumetry to set
	 * 
	 */
	public void setEstimatedVolumetry(String newValue);


	/**
	 * @return the estimatedAccess
	 * 
	 */
	public String getEstimatedAccess();

	/**
	 * Defines a new estimatedAccess
	 * @param newValue the new estimatedAccess to set
	 * 
	 */
	public void setEstimatedAccess(String newValue);


	/**
	 * @return the historized
	 * 
	 */
	public Boolean getHistorized();

	/**
	 * Defines a new historized
	 * @param newValue the new historized to set
	 * 
	 */
	public void setHistorized(Boolean newValue);


	/**
	 * @return the inheritanceKind
	 * 
	 */
	public Enumerator getInheritanceKind();

	/**
	 * Init the inheritanceKind
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInheritanceKind(Object input, Enumerator current);

	/**
	 * Defines a new inheritanceKind
	 * @param newValue the new inheritanceKind to set
	 * 
	 */
	public void setInheritanceKind(Enumerator newValue);


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
