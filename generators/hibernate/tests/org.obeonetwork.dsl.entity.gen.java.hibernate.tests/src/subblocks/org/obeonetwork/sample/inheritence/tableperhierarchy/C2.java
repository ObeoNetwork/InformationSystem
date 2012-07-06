package org.obeonetwork.sample.inheritence.tableperhierarchy;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.sample.inheritence.tableperhierarchy.Root;

// End of user code for imports

/**
 * 
 */
public class C2 extends Root implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field a2.
     */
	public static final String PROP_A2 = "a2";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field a2.
     */
	protected String a2;

	/**
	 * Default constructor.
	 */
	public C2() {
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
	 * @param a2. 
	 */
	public C2(String a2) {
		this.a2 = a2;
	}

	/**
	 * Return a2.
	 * @return a2
	 */
	public String getA2() {
		return a2;
	}

	/**
	 * Set a value to parameter a2.
	 * @param a2
	 */
	public void setA2(final String a2) {
		this.a2 = a2;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * C2 and the given object has the same PK as this
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
		if (!(other instanceof C2)) {
			return false;
		}
		
		final C2 castedOther = (C2) other;
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