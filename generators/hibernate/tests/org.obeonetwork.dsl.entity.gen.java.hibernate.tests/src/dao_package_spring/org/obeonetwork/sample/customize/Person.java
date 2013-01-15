package org.obeonetwork.sample.customize;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;


// End of user code for imports

/**
 *  */
public class Person implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field firstName.
     */
	public static final String PROP_FIRSTNAME = "firstName";
	
	/**
     * Constant representing the name of the field age.
     */
	public static final String PROP_AGE = "age";
	
	/**
     * Constant representing the name of the field birthDate.
     */
	public static final String PROP_BIRTHDATE = "birthDate";
	
	/**
     * Constant representing the name of the field lastName.
     */
	public static final String PROP_LASTNAME = "lastName";
	
	/**
     * Constant representing the name of the field address.
     */
	public static final String PROP_ADDRESS = "address";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field firstName.
     */
	protected String firstName;

    /**
     * Field age.
     */
	protected Integer age;

    /**
     * Field birthDate.
     */
	protected Date birthDate;

    /**
     * Field lastName.
     */
	protected String lastName;

    /**
     * Field address.
     */
	protected Address address;

	/**
	 * Default constructor.
	 */
	public Person() {
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
	 * @param firstName. 
	 * @param age. 
	 * @param birthDate. 
	 * @param lastName. 
	 * @param address. 
	 */
	public Person(String firstName, Integer age, Date birthDate, String lastName, Address address) {
		this.firstName = firstName;
		this.age = age;
		this.birthDate = birthDate;
		this.lastName = lastName;
		this.address = address;
	}

	/**
	 * Return firstName.
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set a value to parameter firstName.
	 * @param firstName
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return age.
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Set a value to parameter age.
	 * @param age
	 */
	public void setAge(final Integer age) {
		this.age = age;
	}

	/**
	 * Return birthDate.
	 * @return birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Set a value to parameter birthDate.
	 * @param birthDate
	 */
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Return lastName.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set a value to parameter lastName.
	 * @param lastName
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return address.
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Set a value to parameter address.
	 * @param address
	 */
	public void setAddress(final Address address) {
		this.address = address;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Person and the given object has the same PK as this
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
		if (!(other instanceof Person)) {
			return false;
		}
		
		final Person castedOther = (Person) other;
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
