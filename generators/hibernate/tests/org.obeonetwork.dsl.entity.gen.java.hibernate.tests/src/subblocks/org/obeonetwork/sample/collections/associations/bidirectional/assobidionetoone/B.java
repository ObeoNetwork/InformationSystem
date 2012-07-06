package org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class B implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field a.
     */
	public static final String PROP_A = "a";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field a.
     */
	protected A a;

	/**
	 * Default constructor.
	 */
	public B() {
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
	 * @param a. 
	 */
	public B(A a) {
		this.a = a;
	}

	/**
	 * Return a.
	 * @return a
	 */
	public A getA() {
		return a;
	}

	/**
	 * Set a value to parameter a.
	 * @param a
	 */
	public void setA(final A a) {
		this.a = a;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * B and the given object has the same PK as this
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
		if (!(other instanceof B)) {
			return false;
		}
		
		final B castedOther = (B) other;
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