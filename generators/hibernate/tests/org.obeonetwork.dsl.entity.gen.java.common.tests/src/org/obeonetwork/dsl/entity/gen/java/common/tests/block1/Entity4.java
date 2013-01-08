package org.obeonetwork.dsl.entity.gen.java.common.tests.block1;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 *  */
public class Entity4 extends Entity1 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field reference3.
     */
	public static final String PROP_REFERENCE3 = "reference3";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field reference3.
     */
	protected Collection<Entity6> reference3;

	/**
	 * Default constructor.
	 */
	public Entity4() {
		super();
		this.reference3 = new HashSet<Entity6>();
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
	 * @param reference3. 
	 */
	public Entity4(Collection<Entity6> reference3) {
		this();
		this.reference3.addAll(reference3);
	}

	/**
	 * Return reference3.
	 * @return reference3
	 */
	public Collection<Entity6> getReference3() {
		return reference3;
	}

	/**
	 * Set a value to parameter reference3.
	 * @param reference3
	 */
	public void setReference3(final Collection<Entity6> reference3) {
		this.reference3 = reference3;
	}
	
	/**
	 * Add a reference3 to the reference3 collection.
	 * @param reference3Elt Element to add.
	 */
	 public void addReference3(final Entity6 reference3Elt) {
	 	this.reference3.add(reference3Elt);
	 }
	 
	/**
	 * Remove a reference3 to the reference3 collection.
	 * @param reference3Elt Element to remove.
	 */
	 public void removeReference3(final Entity6 reference3Elt) {
	 	this.reference3.remove(reference3Elt);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity4 and the given object has the same PK as this
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
		if (!(other instanceof Entity4)) {
			return false;
		}
		
		final Entity4 castedOther = (Entity4) other;
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
