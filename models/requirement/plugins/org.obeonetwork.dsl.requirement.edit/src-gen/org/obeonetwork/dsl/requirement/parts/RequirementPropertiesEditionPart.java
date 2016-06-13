/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface RequirementPropertiesEditionPart {

	/**
	 * @return the type
	 * 
	 */
	public Enumerator getType();

	/**
	 * Init the type
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initType(Object input, Enumerator current);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 * 
	 */
	public void setType(Enumerator newValue);


	/**
	 * @return the subtype
	 * 
	 */
	public String getSubtype();

	/**
	 * Defines a new subtype
	 * @param newValue the new subtype to set
	 * 
	 */
	public void setSubtype(String newValue);


	/**
	 * @return the id
	 * 
	 */
	public String getId();

	/**
	 * Defines a new id
	 * @param newValue the new id to set
	 * 
	 */
	public void setId(String newValue);


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
	 * @return the status
	 * 
	 */
	public String getStatus();

	/**
	 * Defines a new status
	 * @param newValue the new status to set
	 * 
	 */
	public void setStatus(String newValue);


	/**
	 * @return the statement
	 * 
	 */
	public String getStatement();

	/**
	 * Defines a new statement
	 * @param newValue the new statement to set
	 * 
	 */
	public void setStatement(String newValue);


	/**
	 * @return the modifiedOn
	 * 
	 */
	public String getModifiedOn();

	/**
	 * Defines a new modifiedOn
	 * @param newValue the new modifiedOn to set
	 * 
	 */
	public void setModifiedOn(String newValue);


	/**
	 * @return the createdOn
	 * 
	 */
	public String getCreatedOn();

	/**
	 * Defines a new createdOn
	 * @param newValue the new createdOn to set
	 * 
	 */
	public void setCreatedOn(String newValue);




	// Start of user code for version specific getters and setters declaration
	
	public Integer getVersion();
	public void setVersion(Integer version);
	
	// End of user code

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
