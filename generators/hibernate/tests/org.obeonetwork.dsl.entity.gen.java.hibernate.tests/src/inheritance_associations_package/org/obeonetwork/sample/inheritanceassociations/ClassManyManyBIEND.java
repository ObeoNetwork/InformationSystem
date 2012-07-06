package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 * 
 */
public class ClassManyManyBIEND implements Serializable {

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
     * Constant representing the name of the field source2.
     */
	public static final String PROP_SOURCE2 = "source2";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field fakeAttr.
     */
	protected String fakeAttr;

    /**
     * Field source2.
     */
	protected Collection<ClassManyManyBI> source2;

	/**
	 * Default constructor.
	 */
	public ClassManyManyBIEND() {
		super();
		this.source2 = new HashSet<ClassManyManyBI>();
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
	 * @param source2. 
	 */
	public ClassManyManyBIEND(String fakeAttr, Collection<ClassManyManyBI> source2) {
		this();
		this.fakeAttr = fakeAttr;
		this.source2.addAll(source2);
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
	 * Return source2.
	 * @return source2
	 */
	public Collection<ClassManyManyBI> getSource2() {
		return source2;
	}

	/**
	 * Set a value to parameter source2.
	 * @param source2
	 */
	public void setSource2(final Collection<ClassManyManyBI> source2) {
		this.source2 = source2;
	}
	
	/**
	 * Add a source2 to the source2 collection.
	 * Birectional association : add the current Class_Many_Many_BI_END instance to given source2 parameter.
	 * @param source2Elt Element to add.
	 */
	 public void addSource2(final ClassManyManyBI source2Elt) {
	 	this.source2.add(source2Elt);
	 	source2Elt.getTarget2().add(this);
	 }
	 
	/**
	 * Remove a source2 to the source2 collection.
	 * Birectionnal association : remove the current Class_Many_Many_BI_END instance to given source2 parameter.
	 * @param source2Elt Element to remove.
	 */
	 public void removeSource2(final ClassManyManyBI source2Elt) {
	 	this.source2.remove(source2Elt);
	 	source2Elt.getTarget2().remove(this);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassManyManyBIEND and the given object has the same PK as this
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
		if (!(other instanceof ClassManyManyBIEND)) {
			return false;
		}
		
		final ClassManyManyBIEND castedOther = (ClassManyManyBIEND) other;
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