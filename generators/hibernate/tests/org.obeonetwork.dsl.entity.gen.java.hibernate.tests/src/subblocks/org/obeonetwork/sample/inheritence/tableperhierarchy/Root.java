package org.obeonetwork.sample.inheritence.tableperhierarchy;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 *  */
public class Root implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field name.
     */
	public static final String PROP_NAME = "name";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field name.
     */
	protected String name;

	/**
	 * Default constructor.
	 */
	public Root() {
		super();
	}
	
	/**
	 * Return the identifier.
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Set a value to parameter id.
	 * @param id Value of the identifier.
	 */
	public void setId(final String id) {
		this.id = id;
	}	

	/**
	 * Constructor with all parameters initialized.
	 * @param name. 
	 */
	public Root(String name) {
		this.name = name;
	}

	/**
	 * Return name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a value to parameter name.
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Root and the given object has the same PK as this
     * if the PK is not null or their ids are equal.
	 */
	public boolean equals(final Object other) {
	 	// Start of user code for equals
		if (this == other) {
			return true;
		}
		if (id==null) {
			return false;
		}
		if (!(other instanceof Root)) {
			return false;
		}
		
		final Root castedOther = (Root) other;
		if (id != null && castedOther.getId() != null) {
			return id.equals(castedOther.getId());
		}
		return true;
		
		 // End of user code for equals
	}

	/** 
	 * HashTable code based on identifier hash codes.
	 * @return hash value.
	 */
	public int hashCode() {
		return id==null ? System.identityHashCode(this) : id.hashCode();
	}
   
	// Start of user code for private methods
	// TODO Remove this line and add your private methods here
	// End of user code for private methods
   
}
