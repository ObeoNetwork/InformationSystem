package org.obeonetwork.sample.blog;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;


// End of user code for imports

/**
 * 
 */
public class BlogEntry implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field title.
     */
	public static final String PROP_TITLE = "title";
	
	/**
     * Constant representing the name of the field creationDate.
     */
	public static final String PROP_CREATIONDATE = "creationDate";
	
	/**
     * Constant representing the name of the field content.
     */
	public static final String PROP_CONTENT = "content";
	
	/**
     * Constant representing the name of the field authorUser.
     */
	public static final String PROP_AUTHORUSER = "authorUser";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field title.
     */
	protected String title;

    /**
     * Field creationDate.
     */
	protected Date creationDate;

    /**
     * Field content.
     */
	protected String content;

    /**
     * Field authorUser.
     */
	protected User authorUser;

	/**
	 * Default constructor.
	 */
	public BlogEntry() {
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
	 * @param title. 
	 * @param creationDate. 
	 * @param content. 
	 * @param authorUser. 
	 */
	public BlogEntry(String title, Date creationDate, String content, User authorUser) {
		this.title = title;
		this.creationDate = creationDate;
		this.content = content;
		this.authorUser = authorUser;
	}

	/**
	 * Return title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set a value to parameter title.
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Return creationDate.
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Set a value to parameter creationDate.
	 * @param creationDate
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Return content.
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set a value to parameter content.
	 * @param content
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Return authorUser.
	 * @return authorUser
	 */
	public User getAuthorUser() {
		return authorUser;
	}

	/**
	 * Set a value to parameter authorUser.
	 * @param authorUser
	 */
	public void setAuthorUser(final User authorUser) {
		this.authorUser = authorUser;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * BlogEntry and the given object has the same PK as this
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
		if (!(other instanceof BlogEntry)) {
			return false;
		}
		
		final BlogEntry castedOther = (BlogEntry) other;
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