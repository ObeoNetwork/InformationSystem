package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class ClassMany01 implements Serializable {

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
	protected String fakeAttr;

    /**
     * Field target.
     */
	protected ClassMany01END target;

	/**
	 * Default constructor.
	 */
	public ClassMany01() {
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
	 * @param fakeAttr. 
	 * @param target. 
	 */
	public ClassMany01(String fakeAttr, ClassMany01END target) {
		this.fakeAttr = fakeAttr;
		this.target = target;
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
	 * Return target.
	 * @return target
	 */
	public ClassMany01END getTarget() {
		return target;
	}

	/**
	 * Set a value to parameter target.
	 * @param target
	 */
	public void setTarget(final ClassMany01END target) {
		this.target = target;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassMany01 and the given object has the same PK as this
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
		if (!(other instanceof ClassMany01)) {
			return false;
		}
		
		final ClassMany01 castedOther = (ClassMany01) other;
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