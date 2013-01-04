package org.obeonetwork.dsl.entity.gen.java.common.tests.block1;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class Entity7 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field reference5.
     */
	public static final String PROP_REFERENCE5 = "reference5";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field reference5.
     */
	protected Entity8 reference5;

	/**
	 * Default constructor.
	 */
	public Entity7() {
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
	 * @param reference5. 
	 */
	public Entity7(Entity8 reference5) {
		this.reference5 = reference5;
	}

	/**
	 * Return reference5.
	 * @return reference5
	 */
	public Entity8 getReference5() {
		return reference5;
	}

	/**
	 * Set a value to parameter reference5.
	 * @param reference5
	 */
	public void setReference5(final Entity8 reference5) {
		this.reference5 = reference5;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity7 and the given object has the same PK as this
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
		if (!(other instanceof Entity7)) {
			return false;
		}
		
		final Entity7 castedOther = (Entity7) other;
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
