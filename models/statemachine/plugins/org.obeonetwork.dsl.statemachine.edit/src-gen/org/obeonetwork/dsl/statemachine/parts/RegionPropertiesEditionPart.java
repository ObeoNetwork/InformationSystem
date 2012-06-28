/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.statemachine.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;


// End of user code

/**
 * 
 * 
 */
public interface RegionPropertiesEditionPart {

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
	 * @return the keywords
	 * 
	 */
	public EList getKeywords();

	/**
	 * Defines a new keywords
	 * @param newValue the new keywords to set
	 * 
	 */
	public void setKeywords(EList newValue);

	/**
	 * Add a value to the keywords multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToKeywords(Object newValue);

	/**
	 * Remove a value to the keywords multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToKeywords(Object newValue);


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
