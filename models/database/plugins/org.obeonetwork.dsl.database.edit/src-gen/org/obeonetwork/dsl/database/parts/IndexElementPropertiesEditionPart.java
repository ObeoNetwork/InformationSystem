/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface IndexElementPropertiesEditionPart {

	/**
	 * @return the column
	 * 
	 */
	public EObject getColumn();

	/**
	 * Init the column
	 * @param settings the combo setting
	 */
	public void initColumn(EObjectFlatComboSettings settings);

	/**
	 * Defines a new column
	 * @param newValue the new column to set
	 * 
	 */
	public void setColumn(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setColumnButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToColumn(ViewerFilter filter);

	/**
	 * Adds the given filter to the column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToColumn(ViewerFilter filter);


	/**
	 * @return the asc
	 * 
	 */
	public Boolean getAsc();

	/**
	 * Defines a new asc
	 * @param newValue the new asc to set
	 * 
	 */
	public void setAsc(Boolean newValue);


	/**
	 * @return the comments
	 * 
	 */
	public String getComments();

	/**
	 * Defines a new comments
	 * @param newValue the new comments to set
	 * 
	 */
	public void setComments(String newValue);





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
