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
public interface ForeignKeyElementPropertiesEditionPart {

	/**
	 * @return the Source table
	 * 
	 */
	public String getSourceTable();

	/**
	 * Defines a new Source table
	 * @param newValue the new Source table to set
	 * 
	 */
	public void setSourceTable(String newValue);


	/**
	 * @return the FK Column
	 * 
	 */
	public EObject getFKColumn();

	/**
	 * Init the FK Column
	 * @param settings the combo setting
	 */
	public void initFKColumn(EObjectFlatComboSettings settings);

	/**
	 * Defines a new FK Column
	 * @param newValue the new FK Column to set
	 * 
	 */
	public void setFKColumn(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setFKColumnButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the FK Column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFKColumn(ViewerFilter filter);

	/**
	 * Adds the given filter to the FK Column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFKColumn(ViewerFilter filter);


	/**
	 * @return the Target table
	 * 
	 */
	public String getTargetTable();

	/**
	 * Defines a new Target table
	 * @param newValue the new Target table to set
	 * 
	 */
	public void setTargetTable(String newValue);


	/**
	 * @return the PK column
	 * 
	 */
	public EObject getPKColumn();

	/**
	 * Init the PK column
	 * @param settings the combo setting
	 */
	public void initPKColumn(EObjectFlatComboSettings settings);

	/**
	 * Defines a new PK column
	 * @param newValue the new PK column to set
	 * 
	 */
	public void setPKColumn(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setPKColumnButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the PK column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToPKColumn(ViewerFilter filter);

	/**
	 * Adds the given filter to the PK column edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToPKColumn(ViewerFilter filter);


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
