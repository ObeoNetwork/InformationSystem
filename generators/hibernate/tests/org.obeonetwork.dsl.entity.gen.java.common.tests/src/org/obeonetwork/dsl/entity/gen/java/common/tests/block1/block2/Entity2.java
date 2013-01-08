package org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 *  */
public class Entity2 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field attribute8.
     */
	public static final String PROP_ATTRIBUTE8 = "attribute8";
	
	/**
     * Constant representing the name of the field reference1.
     */
	public static final String PROP_REFERENCE1 = "reference1";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field attribute8.
     */
	protected String attribute8;

    /**
     * Field reference1.
     */
	protected Entity3 reference1;

	/**
	 * Default constructor.
	 */
	public Entity2() {
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
	 * @param attribute8. 
	 * @param reference1. 
	 */
	public Entity2(String attribute8, Entity3 reference1) {
		this.attribute8 = attribute8;
		this.reference1 = reference1;
	}

	/**
	 * Return attribute8.
	 * @return attribute8
	 */
	public String getAttribute8() {
		return attribute8;
	}

	/**
	 * Set a value to parameter attribute8.
	 * @param attribute8
	 */
	public void setAttribute8(final String attribute8) {
		this.attribute8 = attribute8;
	}

	/**
	 * Return reference1.
	 * @return reference1
	 */
	public Entity3 getReference1() {
		return reference1;
	}

	/**
	 * Set a value to parameter reference1.
	 * @param reference1
	 */
	public void setReference1(final Entity3 reference1) {
		this.reference1 = reference1;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity2 and the given object has the same PK as this
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
		if (!(other instanceof Entity2)) {
			return false;
		}
		
		final Entity2 castedOther = (Entity2) other;
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
