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
public interface IndexPropertiesEditionPart {

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
	 * @return the qualifier
	 * 
	 */
	public String getQualifier();

	/**
	 * Defines a new qualifier
	 * @param newValue the new qualifier to set
	 * 
	 */
	public void setQualifier(String newValue);


	/**
	 * @return the unique
	 * 
	 */
	public Boolean getUnique();

	/**
	 * Defines a new unique
	 * @param newValue the new unique to set
	 * 
	 */
	public void setUnique(Boolean newValue);


	/**
	 * @return the cardinality
	 * 
	 */
	public String getCardinality();

	/**
	 * Defines a new cardinality
	 * @param newValue the new cardinality to set
	 * 
	 */
	public void setCardinality(String newValue);


	/**
	 * @return the index type
	 * 
	 */
	public String getIndexType();

	/**
	 * Defines a new index type
	 * @param newValue the new index type to set
	 * 
	 */
	public void setIndexType(String newValue);




	/**
	 * Init the elements
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initElements(ReferencesTableSettings settings);

	/**
	 * Update the elements
	 * @param newValue the elements to update
	 * 
	 */
	public void updateElements();

	/**
	 * Adds the given filter to the elements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToElements(ViewerFilter filter);

	/**
	 * Adds the given filter to the elements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToElements(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the elements table
	 * 
	 */
	public boolean isContainedInElementsTable(EObject element);


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
