package org.obeonetwork.demo.weblogng.business.users;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;	
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;

// End of user code for imports

/**
 * 
 */
public class User implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field telephone.
     */
	public static final String PROP_TELEPHONE = "telephone";
	
	/**
     * Constant representing the name of the field login.
     */
	public static final String PROP_LOGIN = "login";
	
	/**
     * Constant representing the name of the field entries.
     */
	public static final String PROP_ENTRIES = "entries";
	
	/**
     * Constant representing the name of the field password.
     */
	public static final String PROP_PASSWORD = "password";
	
	/**
     * Constant representing the name of the field lastName.
     */
	public static final String PROP_LASTNAME = "lastName";
	
	/**
     * Constant representing the name of the field email.
     */
	public static final String PROP_EMAIL = "email";
	
	/**
     * Constant representing the name of the field firstName.
     */
	public static final String PROP_FIRSTNAME = "firstName";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field telephone.
     */
	protected String telephone;

    /**
     * Field login.
     */
	protected String login;

    /**
     * Field entries.
     */
	protected Collection<BlogEntry> entries;

    /**
     * Field password.
     */
	protected String password;

    /**
     * Field lastName.
     */
	protected String lastName;

    /**
     * Field email.
     */
	protected String email;

    /**
     * Field firstName.
     */
	protected String firstName;

	/**
	 * Default constructor.
	 */
	public User() {
		super();
		this.entries = new HashSet<BlogEntry>();
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
	 * @param telephone. 
	 * @param login. 
	 * @param entries. 
	 * @param password. 
	 * @param lastName. 
	 * @param email. 
	 * @param firstName. 
	 */
	public User(String telephone, String login, Collection<BlogEntry> entries, String password, String lastName, String email, String firstName) {
		this();
		this.telephone = telephone;
		this.login = login;
		this.entries.addAll(entries);
		this.password = password;
		this.lastName = lastName;
		this.email = email;
		this.firstName = firstName;
	}

	/**
	 * Return email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set a value to parameter email.
	 * @param email
	 */
	public void setEmail(final String email) {
		this.email = email;
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
	 * Return login.
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Set a value to parameter login.
	 * @param login
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Return password.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set a value to parameter password.
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Return telephone.
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Set a value to parameter telephone.
	 * @param telephone
	 */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Return entries.
	 * @return entries
	 */
	public Collection<BlogEntry> getEntries() {
		return entries;
	}

	/**
	 * Set a value to parameter entries.
	 * @param entries
	 */
	public void setEntries(final Collection<BlogEntry> entries) {
		this.entries = entries;
	}
	
	/**
	 * Add a entries to the entries collection.
	 * Birectional association : add the current User instance to given entries parameter.
	 * @param entriesElt Element to add.
	 */
	 public void addEntries(final BlogEntry entriesElt) {
	 	this.entries.add(entriesElt);
	 	entriesElt.setAuthorUser(this);
	 }
	 
	/**
	 * Remove a entries to the entries collection.
	 * Birectionnal association : remove the current User instance to given entries parameter.
	 * @param entriesElt Element to remove.
	 */
	 public void removeEntries(final BlogEntry entriesElt) {
	 	this.entries.remove(entriesElt);
 		entriesElt.setAuthorUser(null);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * User and the given object has the same PK as this
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
		if (!(other instanceof User)) {
			return false;
		}
		
		final User castedOther = (User) other;
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
