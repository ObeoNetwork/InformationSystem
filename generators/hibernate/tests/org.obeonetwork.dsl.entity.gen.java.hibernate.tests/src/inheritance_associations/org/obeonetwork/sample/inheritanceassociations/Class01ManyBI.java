package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 * 
 */
public class Class01ManyBI implements Serializable {

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
	protected Collection<Class01ManyBIEND> target;

	/**
	 * Default constructor.
	 */
	public Class01ManyBI() {
		super();
		this.target = new HashSet<Class01ManyBIEND>();
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
	public Class01ManyBI(String fakeAttr, Collection<Class01ManyBIEND> target) {
		this();
		this.fakeAttr = fakeAttr;
		this.target.addAll(target);
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
	public Collection<Class01ManyBIEND> getTarget() {
		return target;
	}

	/**
	 * Set a value to parameter target.
	 * @param target
	 */
	public void setTarget(final Collection<Class01ManyBIEND> target) {
		this.target = target;
	}
	
	/**
	 * Add a target to the target collection.
	 * Birectional association : add the current Class_01_Many_BI instance to given target parameter.
	 * @param targetElt Element to add.
	 */
	 public void addTarget(final Class01ManyBIEND targetElt) {
	 	this.target.add(targetElt);
	 	targetElt.setSource(this);
	 }
	 
	/**
	 * Remove a target to the target collection.
	 * Birectionnal association : remove the current Class_01_Many_BI instance to given target parameter.
	 * @param targetElt Element to remove.
	 */
	 public void removeTarget(final Class01ManyBIEND targetElt) {
	 	this.target.remove(targetElt);
 		targetElt.setSource(null);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Class01ManyBI and the given object has the same PK as this
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
		if (!(other instanceof Class01ManyBI)) {
			return false;
		}
		
		final Class01ManyBI castedOther = (Class01ManyBI) other;
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