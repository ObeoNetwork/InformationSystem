package org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2;

// Start of user code for imports
import java.io.Serializable;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity6;

// End of user code for imports

/**
 *  */
public class Entity5 extends Entity2 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field reference2.
     */
	public static final String PROP_REFERENCE2 = "reference2";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field reference2.
     */
	protected Entity6 reference2;

	/**
	 * Default constructor.
	 */
	public Entity5() {
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
	 * @param reference2. 
	 */
	public Entity5(Entity6 reference2) {
		this.reference2 = reference2;
	}

	/**
	 * Return reference2.
	 * @return reference2
	 */
	public Entity6 getReference2() {
		return reference2;
	}

	/**
	 * Set a value to parameter reference2.
	 * @param reference2
	 */
	public void setReference2(final Entity6 reference2) {
		this.reference2 = reference2;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity5 and the given object has the same PK as this
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
		if (!(other instanceof Entity5)) {
			return false;
		}
		
		final Entity5 castedOther = (Entity5) other;
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
