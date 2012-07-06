package org.obeonetwork.sample.badpractives;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 * 
 */
public class MyEntity implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field attr 1.
     */
	public static final String PROP_ATTR1 = "attr 1";
	
	/**
     * Constant representing the name of the field private.
     */
	public static final String PROP_PRIVATE_ = "private";
	
	/**
     * Constant representing the name of the field public.
     */
	public static final String PROP_PUBLIC_ = "public";
	
	/**
     * Constant representing the name of the field protected.
     */
	public static final String PROP_PROTECTED_ = "protected";
	
	/**
     * Constant representing the name of the field null.
     */
	public static final String PROP_NULL_ = "null";
	
	/**
     * Constant representing the name of the field String.
     */
	public static final String PROP_STRING = "String";
	
	/**
     * Constant representing the name of the field à.
     */
	public static final String PROP_A = "à";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field attr 1.
     */
	protected Integer attr1;

    /**
     * Field private.
     */
	protected Integer private_;

    /**
     * Field public.
     */
	protected Integer public_;

    /**
     * Field protected.
     */
	protected String protected_;

    /**
     * Field null.
     */
	protected String null_;

    /**
     * Field String.
     */
	protected String string;

    /**
     * Field à.
     */
	protected Float a;

	/**
	 * Default constructor.
	 */
	public MyEntity() {
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
	 * @param attr 1. 
	 * @param private. 
	 * @param public. 
	 * @param protected. 
	 * @param null. 
	 * @param String. 
	 * @param à. 
	 */
	public MyEntity(Integer attr1, Integer private_, Integer public_, String protected_, String null_, String string, Float a) {
		this.attr1 = attr1;
		this.private_ = private_;
		this.public_ = public_;
		this.protected_ = protected_;
		this.null_ = null_;
		this.string = string;
		this.a = a;
	}

	/**
	 * Return attr1.
	 * @return attr1
	 */
	public Integer getAttr1() {
		return attr1;
	}

	/**
	 * Set a value to parameter attr 1.
	 * @param attr1
	 */
	public void setAttr1(final Integer attr1) {
		this.attr1 = attr1;
	}

	/**
	 * Return private_.
	 * @return private_
	 */
	public Integer getPrivate_() {
		return private_;
	}

	/**
	 * Set a value to parameter private.
	 * @param private_
	 */
	public void setPrivate_(final Integer private_) {
		this.private_ = private_;
	}

	/**
	 * Return public_.
	 * @return public_
	 */
	public Integer getPublic_() {
		return public_;
	}

	/**
	 * Set a value to parameter public.
	 * @param public_
	 */
	public void setPublic_(final Integer public_) {
		this.public_ = public_;
	}

	/**
	 * Return protected_.
	 * @return protected_
	 */
	public String getProtected_() {
		return protected_;
	}

	/**
	 * Set a value to parameter protected.
	 * @param protected_
	 */
	public void setProtected_(final String protected_) {
		this.protected_ = protected_;
	}

	/**
	 * Return null_.
	 * @return null_
	 */
	public String getNull_() {
		return null_;
	}

	/**
	 * Set a value to parameter null.
	 * @param null_
	 */
	public void setNull_(final String null_) {
		this.null_ = null_;
	}

	/**
	 * Return String.
	 * @return String
	 */
	public String getString() {
		return string;
	}

	/**
	 * Set a value to parameter String.
	 * @param String
	 */
	public void setString(final String string) {
		this.string = string;
	}

	/**
	 * Return a.
	 * @return a
	 */
	public Float getA() {
		return a;
	}

	/**
	 * Set a value to parameter à.
	 * @param a
	 */
	public void setA(final Float a) {
		this.a = a;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * myEntity and the given object has the same PK as this
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
		if (!(other instanceof MyEntity)) {
			return false;
		}
		
		final MyEntity castedOther = (MyEntity) other;
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