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
	 * Init the dtoCategories
	 * @param settings settings for the dtoCategories ReferencesTable 
	 */
	public void initDtoCategories(ReferencesTableSettings settings);

	/**
	 * Update the dtoCategories
	 * @param newValue the dtoCategories to update
	 * 
	 */
	public void updateDtoCategories();

	/**
	 * Adds the given filter to the dtoCategories edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDtoCategories(ViewerFilter filter);

	/**
	 * Adds the given filter to the dtoCategories edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDtoCategories(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the dtoCategories table
	 * 
	 */
	public boolean isContainedInDtoCategoriesTable(EObject element);




	/**
	 * Init the dtos
	 * @param settings settings for the dtos ReferencesTable 
	 */
	public void initDtos(ReferencesTableSettings settings);

	/**
	 * Update the dtos
	 * @param newValue the dtos to update
	 * 
	 */
	public void updateDtos();

	/**
	 * Adds the given filter to the dtos edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDtos(ViewerFilter filter);

	/**
	 * Adds the given filter to the dtos edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDtos(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the dtos table
	 * 
	 */
	public boolean isContainedInDtosTable(EObject element);




	/**
	 * Init the entityBlocks
	 * @param settings settings for the entityBlocks ReferencesTable 
	 */
	public void initEntityBlocks(ReferencesTableSettings settings);

	/**
	 * Update the entityBlocks
	 * @param newValue the entityBlocks to update
	 * 
	 */
	public void updateEntityBlocks();

	/**
	 * Adds the given filter to the entityBlocks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEntityBlocks(ViewerFilter filter);

	/**
	 * Adds the given filter to the entityBlocks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEntityBlocks(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the entityBlocks table
	 * 
	 */
	public boolean isContainedInEntityBlocksTable(EObject element);




	/**
	 * Init the entities
	 * @param settings settings for the entities ReferencesTable 
	 */
	public void initEntities(ReferencesTableSettings settings);

	/**
	 * Update the entities
	 * @param newValue the entities to update
	 * 
	 */
	public void updateEntities();

	/**
	 * Adds the given filter to the entities edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEntities(ViewerFilter filter);

	/**
	 * Adds the given filter to the entities edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEntities(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the entities table
	 * 
	 */
	public boolean isContainedInEntitiesTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code 
	
	// End of user code

}
