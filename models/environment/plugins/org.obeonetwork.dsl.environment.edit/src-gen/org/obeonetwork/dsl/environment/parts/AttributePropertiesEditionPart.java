/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface AttributePropertiesEditionPart {

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
	public Object getType();

	/**
	 * Init the type
	 * @param input choice of values
	 * @param currentValue the current value
	 */
	public void initType(Object input, Object currentValue);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 * 
	 */
	public void setType(Object newValue);

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
