package org.obeonetwork.dsl.entity.gen.java.common.tests.block1;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 *  */
public class Entity6 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field reference4.
     */
	public static final String PROP_REFERENCE4 = "reference4";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field reference4.
     */
	protected Collection<Entity4> reference4;

	/**
	 * Default constructor.
	 */
	public Entity6() {
		super();
		this.reference4 = new HashSet<Entity4>();
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
	 * @param reference4. 
	 */
	public Entity6(Collection<Entity4> reference4) {
		this();
		this.reference4.addAll(reference4);
	}

	/**
	 * Return reference4.
	 * @return reference4
	 */
	public Collection<Entity4> getReference4() {
		return reference4;
	}

	/**
	 * Set a value to parameter reference4.
	 * @param reference4
	 */
	public void setReference4(final Collection<Entity4> reference4) {
		this.reference4 = reference4;
	}
	
	/**
	 * Add a reference4 to the reference4 collection.
	 * @param reference4Elt Element to add.
	 */
	 public void addReference4(final Entity4 reference4Elt) {
	 	this.reference4.add(reference4Elt);
	 }
	 
	/**
	 * Remove a reference4 to the reference4 collection.
	 * @param reference4Elt Element to remove.
	 */
	 public void removeReference4(final Entity4 reference4Elt) {
	 	this.reference4.remove(reference4Elt);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity6 and the given object has the same PK as this
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
		if (!(other instanceof Entity6)) {
			return false;
		}
		
		final Entity6 castedOther = (Entity6) other;
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
