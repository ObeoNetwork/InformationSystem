package org.obeonetwork.sample.attributes;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

// End of user code for imports

/**
 * 
 */
public class Cardinality implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field one.
     */
	public static final String PROP_ONE = "one";
	
	/**
     * Constant representing the name of the field zeroOrOne.
     */
	public static final String PROP_ZEROORONE = "zeroOrOne";
	
	/**
     * Constant representing the name of the field oneOrMany.
     */
	public static final String PROP_ONEORMANY = "oneOrMany";
	
	/**
     * Constant representing the name of the field zeroOrMany.
     */
	public static final String PROP_ZEROORMANY = "zeroOrMany";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field one.
     */
	protected String one;

    /**
     * Field zeroOrOne.
     */
	protected String zeroOrOne;

    /**
     * Field oneOrMany.
     */
	protected Collection<String> oneOrMany;

    /**
     * Field zeroOrMany.
     */
	protected Collection<String> zeroOrMany;

	/**
	 * Default constructor.
	 */
	public Cardinality() {
		super();
		this.oneOrMany = new HashSet<String>();
		this.zeroOrMany = new HashSet<String>();
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
	 * @param one. 
	 * @param zeroOrOne. 
	 * @param oneOrMany. 
	 * @param zeroOrMany. 
	 */
	public Cardinality(String one, String zeroOrOne, Collection<String> oneOrMany, Collection<String> zeroOrMany) {
		this();
		this.one = one;
		this.zeroOrOne = zeroOrOne;
		this.oneOrMany.addAll(oneOrMany);
		this.zeroOrMany.addAll(zeroOrMany);
	}

	/**
	 * Return one.
	 * @return one
	 */
	public String getOne() {
		return one;
	}

	/**
	 * Set a value to parameter one.
	 * @param one
	 */
	public void setOne(final String one) {
		this.one = one;
	}

	/**
	 * Return zeroOrOne.
	 * @return zeroOrOne
	 */
	public String getZeroOrOne() {
		return zeroOrOne;
	}

	/**
	 * Set a value to parameter zeroOrOne.
	 * @param zeroOrOne
	 */
	public void setZeroOrOne(final String zeroOrOne) {
		this.zeroOrOne = zeroOrOne;
	}

	/**
	 * Return oneOrMany.
	 * @return oneOrMany
	 */
	public Collection<String> getOneOrMany() {
		return oneOrMany;
	}

	/**
	 * Set a value to parameter oneOrMany.
	 * @param oneOrMany
	 */
	public void setOneOrMany(final Collection<String> oneOrMany) {
		this.oneOrMany = oneOrMany;
	}
	
	/**
	 * Add a oneOrMany to the oneOrMany collection.
	 * @param oneOrManyElt Element to add.
	 */
	 public void addOneOrMany(final String oneOrManyElt) {
	 	this.oneOrMany.add(oneOrManyElt);
	 }
	 
	/**
	 * Remove a oneOrMany to the oneOrMany collection.
	 * @param oneOrManyElt Element to remove.
	 */
	 public void removeOneOrMany(final String oneOrManyElt) {
	 	this.oneOrMany.remove(oneOrManyElt);
	 }

	/**
	 * Return zeroOrMany.
	 * @return zeroOrMany
	 */
	public Collection<String> getZeroOrMany() {
		return zeroOrMany;
	}

	/**
	 * Set a value to parameter zeroOrMany.
	 * @param zeroOrMany
	 */
	public void setZeroOrMany(final Collection<String> zeroOrMany) {
		this.zeroOrMany = zeroOrMany;
	}
	
	/**
	 * Add a zeroOrMany to the zeroOrMany collection.
	 * @param zeroOrManyElt Element to add.
	 */
	 public void addZeroOrMany(final String zeroOrManyElt) {
	 	this.zeroOrMany.add(zeroOrManyElt);
	 }
	 
	/**
	 * Remove a zeroOrMany to the zeroOrMany collection.
	 * @param zeroOrManyElt Element to remove.
	 */
	 public void removeZeroOrMany(final String zeroOrManyElt) {
	 	this.zeroOrMany.remove(zeroOrManyElt);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Cardinality and the given object has the same PK as this
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
		if (!(other instanceof Cardinality)) {
			return false;
		}
		
		final Cardinality castedOther = (Cardinality) other;
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