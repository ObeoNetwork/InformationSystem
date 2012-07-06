package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 * 
 */
public class ClassMany01BIEND implements Serializable {

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
     * Constant representing the name of the field source.
     */
	public static final String PROP_SOURCE = "source";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field fakeAttr.
     */
	protected String fakeAttr;

    /**
     * Field source.
     */
	protected Collection<ClassMany01BI> source;

	/**
	 * Default constructor.
	 */
	public ClassMany01BIEND() {
		super();
		this.source = new HashSet<ClassMany01BI>();
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
	 * @param source. 
	 */
	public ClassMany01BIEND(String fakeAttr, Collection<ClassMany01BI> source) {
		this();
		this.fakeAttr = fakeAttr;
		this.source.addAll(source);
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
	 * Return source.
	 * @return source
	 */
	public Collection<ClassMany01BI> getSource() {
		return source;
	}

	/**
	 * Set a value to parameter source.
	 * @param source
	 */
	public void setSource(final Collection<ClassMany01BI> source) {
		this.source = source;
	}
	
	/**
	 * Add a source to the source collection.
	 * Birectional association : add the current Class_Many_01_BI_END instance to given source parameter.
	 * @param sourceElt Element to add.
	 */
	 public void addSource(final ClassMany01BI sourceElt) {
	 	this.source.add(sourceElt);
	 	sourceElt.setTarget(this);
	 }
	 
	/**
	 * Remove a source to the source collection.
	 * Birectionnal association : remove the current Class_Many_01_BI_END instance to given source parameter.
	 * @param sourceElt Element to remove.
	 */
	 public void removeSource(final ClassMany01BI sourceElt) {
	 	this.source.remove(sourceElt);
 		sourceElt.setTarget(null);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ClassMany01BIEND and the given object has the same PK as this
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
		if (!(other instanceof ClassMany01BIEND)) {
			return false;
		}
		
		final ClassMany01BIEND castedOther = (ClassMany01BIEND) other;
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