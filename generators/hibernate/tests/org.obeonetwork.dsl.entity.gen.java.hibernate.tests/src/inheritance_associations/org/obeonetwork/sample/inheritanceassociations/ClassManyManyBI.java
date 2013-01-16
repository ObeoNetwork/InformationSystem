package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 *  */
public class ClassManyManyBI implements Serializable {

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
     * Constant representing the name of the field target2.
     */
	public static final String PROP_TARGET2 = "target2";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field fakeAttr.
     */
	protected String fakeAttr;

    /**
     * Field target2.
     */
	protected Collection<ClassManyManyBIEND> target2;

	/**
	 * Default constructor.
	 */
	public ClassManyManyBI() {
		super();
		this.target2 = new HashSet<ClassManyManyBIEND>();
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
	 * @param target2. 
	 */
	public ClassManyManyBI(String fakeAttr, Collection<ClassManyManyBIEND> target2) {
		this();
		this.fakeAttr = fakeAttr;
		this.target2.addAll(target2);
	}

	/**
	 * Return fakeAttr.
	 * @return fakeAttr
	 */
	public String getFakeAttr() {
		return fakeAttr;
	}

	/**
	 * Set a value to parameter fakeAttr.
	 * @param fakeAttr
	 */
	public void setFakeAttr(final String fakeAttr) {
		this.fakeAttr = fakeAttr;
	}

	/**
	 * Return target2.
	 * @return target2
	 */
	public Collection<ClassManyManyBIEND> getTarget2() {
		return target2;
	}

	/**
	 * Set a value to parameter target2.
	 * @param target2
	 */
	public void setTarget2(final Collection<ClassManyManyBIEND> target2) {
		this.target2 = target2;
	}
	
	/**
	 * Add a target2 to the target2 collection.
	 * Birectional association : add the current Class_Many_Many_BI instance to given target2 parameter.
	 * @param target2Elt Element to add.
	 */
	 public void addTarget2(final ClassManyManyBIEND target2Elt) {
	 	this.target2.add(target2Elt);
	 	target2Elt.getSource2().add(this);
	 }
	 
	/**
	 * Remove a target2 to the target2 collection.
	 * Birectionnal association : remove the current Class_Many_Many_BI instance to given target2 parameter.
	 * @param target2Elt Element to remove.
	 */
	 public void removeTarget2(final ClassManyManyBIEND target2Elt) {
	 	this.target2.remove(target2Elt);
	 	target2Elt.getSource2().remove(this);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassManyManyBI and the given object has the same PK as this
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
		if (!(other instanceof ClassManyManyBI)) {
			return false;
		}
		
		final ClassManyManyBI castedOther = (ClassManyManyBI) other;
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
