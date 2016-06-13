/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface SystemPropertiesEditionPart {

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
	 * Init the namespaces
	 * @param settings settings for the namespaces ReferencesTable 
	 */
	public void initNamespaces(ReferencesTableSettings settings);

	/**
	 * Update the namespaces
	 * @param newValue the namespaces to update
	 * 
	 */
	public void updateNamespaces();

	/**
	 * Adds the given filter to the namespaces edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToNamespaces(ViewerFilter filter);

	/**
	 * Adds the given filter to the namespaces edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToNamespaces(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the namespaces table
	 * 
	 */
	public boolean isContainedInNamespacesTable(EObject element);




	/**
	 * Init the types
	 * @param settings settings for the types ReferencesTable 
	 */
	public void initTypes(ReferencesTableSettings settings);

	/**
	 * Update the types
	 * @param newValue the types to update
	 * 
	 */
	public void updateTypes();

	/**
	 * Adds the given filter to the types edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTypes(ViewerFilter filter);

	/**
	 * Adds the given filter to the types edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTypes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the types table
	 * 
	 */
	public boolean isContainedInTypesTable(EObject element);





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
