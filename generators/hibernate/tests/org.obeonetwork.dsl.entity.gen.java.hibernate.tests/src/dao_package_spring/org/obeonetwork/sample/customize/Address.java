package org.obeonetwork.sample.customize;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 *  */
public class Address implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field city.
     */
	public static final String PROP_CITY = "city";
	
	/**
     * Constant representing the name of the field street.
     */
	public static final String PROP_STREET = "street";
	
	/**
     * Constant representing the name of the field nb.
     */
	public static final String PROP_NB = "nb";
	
	/**
     * Constant representing the name of the field person.
     */
	public static final String PROP_PERSON = "person";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field city.
     */
	protected String city;

    /**
     * Field street.
     */
	protected String street;

    /**
     * Field nb.
     */
	protected String nb;

    /**
     * Field person.
     */
	protected Person person;

	/**
	 * Default constructor.
	 */
	public Address() {
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
	 * @param city. 
	 * @param street. 
	 * @param nb. 
	 * @param person. 
	 */
	public Address(String city, String street, String nb, Person person) {
		this.city = city;
		this.street = street;
		this.nb = nb;
		this.person = person;
	}

	/**
	 * Return city.
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set a value to parameter city.
	 * @param city
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Return street.
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Set a value to parameter street.
	 * @param street
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * Return nb.
	 * @return nb
	 */
	public String getNb() {
		return nb;
	}

	/**
	 * Set a value to parameter nb.
	 * @param nb
	 */
	public void setNb(final String nb) {
		this.nb = nb;
	}

	/**
	 * Return person.
	 * @return person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Set a value to parameter person.
	 * @param person
	 */
	public void setPerson(final Person person) {
		this.person = person;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Address and the given object has the same PK as this
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
		if (!(other instanceof Address)) {
			return false;
		}
		
		final Address castedOther = (Address) other;
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
