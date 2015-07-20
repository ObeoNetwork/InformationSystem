/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface TypeInstancePropertiesEditionPart {

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
	 * @return the length
	 * 
	 */
	public String getLength();

	/**
	 * Defines a new length
	 * @param newValue the new length to set
	 * 
	 */
	public void setLength(String newValue);


	/**
	 * @return the precision
	 * 
	 */
	public String getPrecision();

	/**
	 * Defines a new precision
	 * @param newValue the new precision to set
	 * 
	 */
	public void setPrecision(String newValue);


	/**
	 * @return the literals
	 * 
	 */
	public EList getLiterals();

	/**
	 * Defines a new literals
	 * @param newValue the new literals to set
	 * 
	 */
	public void setLiterals(EList newValue);

	/**
	 * Add a value to the literals multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToLiterals(Object newValue);

	/**
	 * Remove a value to the literals multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToLiterals(Object newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	public void updateTypeFields(boolean lengthVisible, boolean precisionVisible, boolean literalsVisible);
// End of user code

}
