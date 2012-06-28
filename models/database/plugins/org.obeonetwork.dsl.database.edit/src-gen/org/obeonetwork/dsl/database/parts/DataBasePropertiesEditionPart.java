/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface DataBasePropertiesEditionPart {

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
	 * @return the url
	 * 
	 */
	public String getUrl();

	/**
	 * Defines a new url
	 * @param newValue the new url to set
	 * 
	 */
	public void setUrl(String newValue);




	/**
	 * Init the usedLibraries
	 * @param settings settings for the usedLibraries ReferencesTable 
	 */
	public void initUsedLibraries(ReferencesTableSettings settings);

	/**
	 * Update the usedLibraries
	 * @param newValue the usedLibraries to update
	 * 
	 */
	public void updateUsedLibraries();

	/**
	 * Adds the given filter to the usedLibraries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToUsedLibraries(ViewerFilter filter);

	/**
	 * Adds the given filter to the usedLibraries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToUsedLibraries(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the usedLibraries table
	 * 
	 */
	public boolean isContainedInUsedLibrariesTable(EObject element);


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
