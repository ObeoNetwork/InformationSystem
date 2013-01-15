package org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 *  */
public class A implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field b.
     */
	public static final String PROP_B = "b";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field b.
     */
	protected Collection<B> b;

	/**
	 * Default constructor.
	 */
	public A() {
		super();
		this.b = new HashSet<B>();
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
	 * @param b. 
	 */
	public A(Collection<B> b) {
		this();
		this.b.addAll(b);
	}

	/**
	 * Return b.
	 * @return b
	 */
	public Collection<B> getB() {
		return b;
	}

	/**
	 * Set a value to parameter b.
	 * @param b
	 */
	public void setB(final Collection<B> b) {
		this.b = b;
	}
	
	/**
	 * Add a b to the b collection.
	 * Birectional association : add the current A instance to given b parameter.
	 * @param bElt Element to add.
	 */
	 public void addB(final B bElt) {
	 	this.b.add(bElt);
	 	bElt.getA().add(this);
	 }
	 
	/**
	 * Remove a b to the b collection.
	 * Birectionnal association : remove the current A instance to given b parameter.
	 * @param bElt Element to remove.
	 */
	 public void removeB(final B bElt) {
	 	this.b.remove(bElt);
	 	bElt.getA().remove(this);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * A and the given object has the same PK as this
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
		if (!(other instanceof A)) {
			return false;
		}
		
		final A castedOther = (A) other;
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
