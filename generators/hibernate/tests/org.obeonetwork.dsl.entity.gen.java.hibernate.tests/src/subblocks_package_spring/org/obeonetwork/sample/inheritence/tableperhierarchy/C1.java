package org.obeonetwork.sample.inheritence.tableperhierarchy;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.sample.inheritence.tableperhierarchy.Root;

// End of user code for imports

/**
 *  */
public class C1 extends Root implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field a1.
     */
	public static final String PROP_A1 = "a1";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field a1.
     */
	protected String a1;

	/**
	 * Default constructor.
	 */
	public C1() {
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
	 * @param a1. 
	 */
	public C1(String a1) {
		this.a1 = a1;
	}

	/**
	 * Return a1.
	 * @return a1
	 */
	public String getA1() {
		return a1;
	}

	/**
	 * Set a value to parameter a1.
	 * @param a1
	 */
	public void setA1(final String a1) {
		this.a1 = a1;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * C1 and the given object has the same PK as this
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
		if (!(other instanceof C1)) {
			return false;
		}
		
		final C1 castedOther = (C1) other;
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
