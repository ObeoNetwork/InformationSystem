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
public interface ForeignKeysPropertiesEditionPart {



	/**
	 * Init the foreign keys
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initForeignKeys(ReferencesTableSettings settings);

	/**
	 * Update the foreign keys
	 * @param newValue the foreign keys to update
	 * 
	 */
	public void updateForeignKeys();

	/**
	 * Adds the given filter to the foreign keys edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToForeignKeys(ViewerFilter filter);

	/**
	 * Adds the given filter to the foreign keys edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToForeignKeys(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the foreign keys table
	 * 
	 */
	public boolean isContainedInForeignKeysTable(EObject element);





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
