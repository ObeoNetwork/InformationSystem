package org.obeonetwork.sample.associations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 * 
 */
public class ClassManyMany implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field fakeAttr.
     */
	public static final String PROP_FAKEATTR = "fakeAttr";
	
	/**
     * Constant representing the name of the field target.
     */
	public static final String PROP_TARGET = "target";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field fakeAttr.
     */
	protected Float fakeAttr;

    /**
     * Field target.
     */
	protected Collection<ClassManyManyEnd> target;

	/**
	 * Default constructor.
	 */
	public ClassManyMany() {
		super();
		this.target = new HashSet<ClassManyManyEnd>();
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
	 * @param fakeAttr. 
	 * @param target. 
	 */
	public ClassManyMany(Float fakeAttr, Collection<ClassManyManyEnd> target) {
		this();
		this.fakeAttr = fakeAttr;
		this.target.addAll(target);
	}

	/**
	 * Return fakeAttr.
	 * @return fakeAttr
	 */
	public Float getFakeAttr() {
		return fakeAttr;
	}

	/**
	 * Set a value to parameter fakeAttr.
	 * @param fakeAttr
	 */
	public void setFakeAttr(final Float fakeAttr) {
		this.fakeAttr = fakeAttr;
	}

	/**
	 * Return target.
	 * @return target
	 */
	public Collection<ClassManyManyEnd> getTarget() {
		return target;
	}

	/**
	 * Set a value to parameter target.
	 * @param target
	 */
	public void setTarget(final Collection<ClassManyManyEnd> target) {
		this.target = target;
	}
	
	/**
	 * Add a target to the target collection.
	 * @param targetElt Element to add.
	 */
	 public void addTarget(final ClassManyManyEnd targetElt) {
	 	this.target.add(targetElt);
	 }
	 
	/**
	 * Remove a target to the target collection.
	 * @param targetElt Element to remove.
	 */
	 public void removeTarget(final ClassManyManyEnd targetElt) {
	 	this.target.remove(targetElt);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassManyMany and the given object has the same PK as this
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
		if (!(other instanceof ClassManyMany)) {
			return false;
		}
		
		final ClassManyMany castedOther = (ClassManyMany) other;
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