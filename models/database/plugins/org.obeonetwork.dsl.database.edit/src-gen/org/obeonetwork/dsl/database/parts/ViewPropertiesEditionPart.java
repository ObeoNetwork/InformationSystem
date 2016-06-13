/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface ViewPropertiesEditionPart {

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
	 * @return the query
	 * 
	 */
	public String getQuery();

	/**
	 * Defines a new query
	 * @param newValue the new query to set
	 * 
	 */
	public void setQuery(String newValue);


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
	 * Init the columns
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initColumns(ReferencesTableSettings settings);

	/**
	 * Update the columns
	 * @param newValue the columns to update
	 * 
	 */
	public void updateColumns();

	/**
	 * Adds the given filter to the columns edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToColumns(ViewerFilter filter);

	/**
	 * Adds the given filter to the columns edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToColumns(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the columns table
	 * 
	 */
	public boolean isContainedInColumnsTable(EObject element);




	/**
	 * Init the tables
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTables(ReferencesTableSettings settings);

	/**
	 * Update the tables
	 * @param newValue the tables to update
	 * 
	 */
	public void updateTables();

	/**
	 * Adds the given filter to the tables edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTables(ViewerFilter filter);

	/**
	 * Adds the given filter to the tables edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTables(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tables table
	 * 
	 */
	public boolean isContainedInTablesTable(EObject element);





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
