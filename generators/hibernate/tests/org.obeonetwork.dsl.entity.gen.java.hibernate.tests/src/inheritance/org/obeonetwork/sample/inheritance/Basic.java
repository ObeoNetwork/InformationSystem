package org.obeonetwork.sample.inheritance;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.sample.inheritance.Root;

// End of user code for imports

/**
 * 
 */
public class Basic extends Root implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field myProp1.
     */
	public static final String PROP_MYPROP1 = "myProp1";
	
	/**
     * Constant representing the name of the field myProp2.
     */
	public static final String PROP_MYPROP2 = "myProp2";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field myProp1.
     */
	protected String myProp1;

    /**
     * Field myProp2.
     */
	protected Float myProp2;

	/**
	 * Default constructor.
	 */
	public Basic() {
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
	 * @param myProp1. 
	 * @param myProp2. 
	 */
	public Basic(String myProp1, Float myProp2) {
		this.myProp1 = myProp1;
		this.myProp2 = myProp2;
	}

	/**
	 * Return myProp1.
	 * @return myProp1
	 */
	public String getMyProp1() {
		return myProp1;
	}

	/**
	 * Set a value to parameter myProp1.
	 * @param myProp1
	 */
	public void setMyProp1(final String myProp1) {
		this.myProp1 = myProp1;
	}

	/**
	 * Return myProp2.
	 * @return myProp2
	 */
	public Float getMyProp2() {
		return myProp2;
	}

	/**
	 * Set a value to parameter myProp2.
	 * @param myProp2
	 */
	public void setMyProp2(final Float myProp2) {
		this.myProp2 = myProp2;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Basic and the given object has the same PK as this
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
		if (!(other instanceof Basic)) {
			return false;
		}
		
		final Basic castedOther = (Basic) other;
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