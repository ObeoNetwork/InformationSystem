package org.obeonetwork.sample.badpractives.package_;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.sample.badpractives.Class_;

// End of user code for imports

/**
 * 
 */
public class Return_ implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field Class.
     */
	public static final String PROP_CLASS_ = "Class";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field Class.
     */
	protected Class_ class_;

	/**
	 * Default constructor.
	 */
	public Return_() {
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
	 * @param Class. 
	 */
	public Return_(Class_ class_) {
		this.class_ = class_;
	}

	/**
	 * Return Class_.
	 * @return Class_
	 */
	public Class_ getClass_() {
		return class_;
	}

	/**
	 * Set a value to parameter Class_.
	 * @param Class_
	 */
	public void setClass_(final Class_ Class_) {
		this.class_ = Class_;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * return_ and the given object has the same PK as this
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
		if (!(other instanceof Return_)) {
			return false;
		}
		
		final Return_ castedOther = (Return_) other;
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