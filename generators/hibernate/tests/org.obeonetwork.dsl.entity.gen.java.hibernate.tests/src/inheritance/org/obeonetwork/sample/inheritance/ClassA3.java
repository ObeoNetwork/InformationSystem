package org.obeonetwork.sample.inheritance;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.sample.inheritance.ClassA2;

// End of user code for imports

/**
 * 
 */
public class ClassA3 extends ClassA2 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field a3.
     */
	public static final String PROP_A3 = "a3";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field a3.
     */
	protected String a3;

	/**
	 * Default constructor.
	 */
	public ClassA3() {
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
	 * @param a3. 
	 */
	public ClassA3(String a3) {
		this.a3 = a3;
	}

	/**
	 * Return a3.
	 * @return a3
	 */
	public String getA3() {
		return a3;
	}

	/**
	 * Set a value to parameter a3.
	 * @param a3
	 */
	public void setA3(final String a3) {
		this.a3 = a3;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassA3 and the given object has the same PK as this
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
		if (!(other instanceof ClassA3)) {
			return false;
		}
		
		final ClassA3 castedOther = (ClassA3) other;
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