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
public interface ReferencePropertiesEditionPart {

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
	 * @return the type
	 * 
	 */
	public EObject getType();

	/**
	 * Init the type
	 * @param settings the combo setting
	 */
	public void initType(EObjectFlatComboSettings settings);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 * 
	 */
	public void setType(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the type edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter);

	/**
	 * Adds the given filter to the type edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToType(ViewerFilter filter);


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
	 * @return the isPrimaryKey
	 * 
	 */
	public Boolean getIsPrimaryKey();

	/**
	 * Defines a new isPrimaryKey
	 * @param newValue the new isPrimaryKey to set
	 * 
	 */
	public void setIsPrimaryKey(Boolean newValue);


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
	 * @return the oppositeOf
	 * 
	 */
	public EObject getOppositeOf();

	/**
	 * Init the oppositeOf
	 * @param settings the combo setting
	 */
	public void initOppositeOf(EObjectFlatComboSettings settings);

	/**
	 * Defines a new oppositeOf
	 * @param newValue the new oppositeOf to set
	 * 
	 */
	public void setOppositeOf(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setOppositeOfButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the oppositeOf edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOppositeOf(ViewerFilter filter);

	/**
	 * Adds the given filter to the oppositeOf edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOppositeOf(ViewerFilter filter);


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
