package org.obeonetwork.sample.demo.weblogng.informations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;

// End of user code for imports

/**
 *  */
public class Comment implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field name.
     */
	public static final String PROP_NAME = "name";
	
	/**
     * Constant representing the name of the field email.
     */
	public static final String PROP_EMAIL = "email";
	
	/**
     * Constant representing the name of the field website.
     */
	public static final String PROP_WEBSITE = "website";
	
	/**
     * Constant representing the name of the field content.
     */
	public static final String PROP_CONTENT = "content";
	
	/**
     * Constant representing the name of the field creationDate.
     */
	public static final String PROP_CREATIONDATE = "creationDate";
	
	/**
     * Constant representing the name of the field isCommentOf.
     */
	public static final String PROP_ISCOMMENTOF = "isCommentOf";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field name.
     */
	protected String name;

    /**
     * Field email.
     */
	protected String email;

    /**
     * Field website.
     */
	protected String website;

    /**
     * Field content.
     */
	protected String content;

    /**
     * Field creationDate.
     */
	protected Date creationDate;

    /**
     * Field isCommentOf.
     */
	protected BlogEntry isCommentOf;

	/**
	 * Default constructor.
	 */
	public Comment() {
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
	 * @param name. 
	 * @param email. 
	 * @param website. 
	 * @param content. 
	 * @param creationDate. 
	 * @param isCommentOf. 
	 */
	public Comment(String name, String email, String website, String content, Date creationDate, BlogEntry isCommentOf) {
		this.name = name;
		this.email = email;
		this.website = website;
		this.content = content;
		this.creationDate = creationDate;
		this.isCommentOf = isCommentOf;
	}

	/**
	 * Return name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a value to parameter name.
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
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
	 * Return website.
	 * @return website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Set a value to parameter website.
	 * @param website
	 */
	public void setWebsite(final String website) {
		this.website = website;
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
	 * Return isCommentOf.
	 * @return isCommentOf
	 */
	public BlogEntry getIsCommentOf() {
		return isCommentOf;
	}

	/**
	 * Set a value to parameter isCommentOf.
	 * @param isCommentOf
	 */
	public void setIsCommentOf(final BlogEntry isCommentOf) {
		this.isCommentOf = isCommentOf;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Comment and the given object has the same PK as this
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
		if (!(other instanceof Comment)) {
			return false;
		}
		
		final Comment castedOther = (Comment) other;
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
