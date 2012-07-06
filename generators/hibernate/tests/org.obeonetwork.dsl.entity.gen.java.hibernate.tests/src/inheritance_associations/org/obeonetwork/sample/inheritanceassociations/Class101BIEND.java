package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class Class101BIEND implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field source.
     */
	public static final String PROP_SOURCE = "source";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field source.
     */
	protected Class101BI source;

	/**
	 * Default constructor.
	 */
	public Class101BIEND() {
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
	 * @param source. 
	 */
	public Class101BIEND(Class101BI source) {
		this.source = source;
	}

	/**
	 * Return source.
	 * @return source
	 */
	public Class101BI getSource() {
		return source;
	}

	/**
	 * Set a value to parameter source.
	 * @param source
	 */
	public void setSource(final Class101BI source) {
		this.source = source;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Class101BIEND and the given object has the same PK as this
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
		if (!(other instanceof Class101BIEND)) {
			return false;
		}
		
		final Class101BIEND castedOther = (Class101BIEND) other;
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
	// End of user code
   
}