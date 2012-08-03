package org.obeonetwork.sample.blog;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;import java.util.Date;

import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.informations.Comment;

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
     * Constant representing the name of the field categories.
     */
	public static final String PROP_CATEGORIES = "categories";
	
	/**
     * Constant representing the name of the field tags.
     */
	public static final String PROP_TAGS = "tags";
	
	/**
     * Constant representing the name of the field comments.
     */
	public static final String PROP_COMMENTS = "comments";
	
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
     * Field categories.
     */
	protected Collection<Category> categories;

    /**
     * Field tags.
     */
	protected Collection<Tag> tags;

    /**
     * Field comments.
     */
	protected Collection<Comment> comments;

	/**
	 * Default constructor.
	 */
	public BlogEntry() {
		super();
		this.categories = new HashSet<Category>();
		this.tags = new HashSet<Tag>();
		this.comments = new HashSet<Comment>();
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
	 * @param categories. 
	 * @param tags. 
	 * @param comments. 
	 */
	public BlogEntry(String title, Date creationDate, String content, User authorUser, Collection<Category> categories, Collection<Tag> tags, Collection<Comment> comments) {
		this();
		this.title = title;
		this.creationDate = creationDate;
		this.content = content;
		this.authorUser = authorUser;
		this.categories.addAll(categories);
		this.tags.addAll(tags);
		this.comments.addAll(comments);
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
	 * Return categories.
	 * @return categories
	 */
	public Collection<Category> getCategories() {
		return categories;
	}

	/**
	 * Set a value to parameter categories.
	 * @param categories
	 */
	public void setCategories(final Collection<Category> categories) {
		this.categories = categories;
	}
	
	/**
	 * Add a categories to the categories collection.
	 * Birectional association : add the current BlogEntry instance to given categories parameter.
	 * @param categoriesElt Element to add.
	 */
	 public void addCategories(final Category categoriesElt) {
	 	this.categories.add(categoriesElt);
	 	categoriesElt.getIsCategoryOf().add(this);
	 }
	 
	/**
	 * Remove a categories to the categories collection.
	 * Birectionnal association : remove the current BlogEntry instance to given categories parameter.
	 * @param categoriesElt Element to remove.
	 */
	 public void removeCategories(final Category categoriesElt) {
	 	this.categories.remove(categoriesElt);
	 	categoriesElt.getIsCategoryOf().remove(this);
	 }

	/**
	 * Return tags.
	 * @return tags
	 */
	public Collection<Tag> getTags() {
		return tags;
	}

	/**
	 * Set a value to parameter tags.
	 * @param tags
	 */
	public void setTags(final Collection<Tag> tags) {
		this.tags = tags;
	}
	
	/**
	 * Add a tags to the tags collection.
	 * Birectional association : add the current BlogEntry instance to given tags parameter.
	 * @param tagsElt Element to add.
	 */
	 public void addTags(final Tag tagsElt) {
	 	this.tags.add(tagsElt);
	 	tagsElt.getIsTagOf().add(this);
	 }
	 
	/**
	 * Remove a tags to the tags collection.
	 * Birectionnal association : remove the current BlogEntry instance to given tags parameter.
	 * @param tagsElt Element to remove.
	 */
	 public void removeTags(final Tag tagsElt) {
	 	this.tags.remove(tagsElt);
	 	tagsElt.getIsTagOf().remove(this);
	 }

	/**
	 * Return comments.
	 * @return comments
	 */
	public Collection<Comment> getComments() {
		return comments;
	}

	/**
	 * Set a value to parameter comments.
	 * @param comments
	 */
	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * Add a comments to the comments collection.
	 * Birectional association : add the current BlogEntry instance to given comments parameter.
	 * @param commentsElt Element to add.
	 */
	 public void addComments(final Comment commentsElt) {
	 	this.comments.add(commentsElt);
	 	commentsElt.setIsCommentOf(this);
	 }
	 
	/**
	 * Remove a comments to the comments collection.
	 * Birectionnal association : remove the current BlogEntry instance to given comments parameter.
	 * @param commentsElt Element to remove.
	 */
	 public void removeComments(final Comment commentsElt) {
	 	this.comments.remove(commentsElt);
 		commentsElt.setIsCommentOf(null);
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