package org.obeonetwork.sample.kindofdao;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class ExempleDirect implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field myAttribute.
     */
	public static final String PROP_MYATTRIBUTE = "myAttribute";
	
	/**
     * Constant representing the name of the field myId.
     */
	public static final String PROP_MYID = "myId";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field myAttribute.
     */
	protected String myAttribute;

    /**
     * Field myId.
     */
	protected String myId;

	/**
	 * Default constructor.
	 */
	public ExempleDirect() {
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
	 * @param myAttribute. 
	 * @param myId. 
	 */
	public ExempleDirect(String myAttribute, String myId) {
		this.myAttribute = myAttribute;
		this.myId = myId;
	}

	/**
	 * Return myAttribute.
	 * @return myAttribute
	 */
	public String getMyAttribute() {
		return myAttribute;
	}

	/**
	 * Set a value to parameter myAttribute.
	 * @param myAttribute
	 */
	public void setMyAttribute(final String myAttribute) {
		this.myAttribute = myAttribute;
	}

	/**
	 * Return myId.
	 * @return myId
	 */
	public String getMyId() {
		return myId;
	}

	/**
	 * Set a value to parameter myId.
	 * @param myId
	 */
	public void setMyId(final String myId) {
		this.myId = myId;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * ExempleDirect and the given object has the same PK as this
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
		if (!(other instanceof ExempleDirect)) {
			return false;
		}
		
		final ExempleDirect castedOther = (ExempleDirect) other;
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