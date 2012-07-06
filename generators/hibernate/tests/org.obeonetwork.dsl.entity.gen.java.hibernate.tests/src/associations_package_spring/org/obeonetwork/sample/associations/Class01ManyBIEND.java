package org.obeonetwork.sample.associations;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class Class01ManyBIEND implements Serializable {

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
	protected Integer fakeAttr;

    /**
     * Field source.
     */
	protected Class01ManyBI source;

	/**
	 * Default constructor.
	 */
	public Class01ManyBIEND() {
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
	 * @param source. 
	 */
	public Class01ManyBIEND(Integer fakeAttr, Class01ManyBI source) {
		this.fakeAttr = fakeAttr;
		this.source = source;
	}

	/**
	 * Return fakeAttr.
	 * @return fakeAttr
	 */
	public Integer getFakeAttr() {
		return fakeAttr;
	}

	/**
	 * Set a value to parameter fakeAttr.
	 * @param fakeAttr
	 */
	public void setFakeAttr(final Integer fakeAttr) {
		this.fakeAttr = fakeAttr;
	}

	/**
	 * Return source.
	 * @return source
	 */
	public Class01ManyBI getSource() {
		return source;
	}

	/**
	 * Set a value to parameter source.
	 * @param source
	 */
	public void setSource(final Class01ManyBI source) {
		this.source = source;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Class01ManyBIEND and the given object has the same PK as this
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
		if (!(other instanceof Class01ManyBIEND)) {
			return false;
		}
		
		final Class01ManyBIEND castedOther = (Class01ManyBIEND) other;
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