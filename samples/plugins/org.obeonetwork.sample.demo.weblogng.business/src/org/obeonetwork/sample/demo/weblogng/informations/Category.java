package org.obeonetwork.sample.demo.weblogng.informations;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;	
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;

// End of user code for imports

/**
 * 
 */
public class Category implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field description.
     */
	public static final String PROP_DESCRIPTION = "description";
	
	/**
     * Constant representing the name of the field isCategoryOf.
     */
	public static final String PROP_ISCATEGORYOF = "isCategoryOf";
	
	/**
     * Constant representing the name of the field name.
     */
	public static final String PROP_NAME = "name";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field description.
     */
	protected String description;

    /**
     * Field isCategoryOf.
     */
	protected Collection<BlogEntry> isCategoryOf;

    /**
     * Field name.
     */
	protected String name;

	/**
	 * Default constructor.
	 */
	public Category() {
		super();
		this.isCategoryOf = new HashSet<BlogEntry>();
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
	 * @param description. 
	 * @param isCategoryOf. 
	 * @param name. 
	 */
	public Category(String description, Collection<BlogEntry> isCategoryOf, String name) {
		this();
		this.description = description;
		this.isCategoryOf.addAll(isCategoryOf);
		this.name = name;
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
	 * Return description.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set a value to parameter description.
	 * @param description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Return isCategoryOf.
	 * @return isCategoryOf
	 */
	public Collection<BlogEntry> getIsCategoryOf() {
		return isCategoryOf;
	}

	/**
	 * Set a value to parameter isCategoryOf.
	 * @param isCategoryOf
	 */
	public void setIsCategoryOf(final Collection<BlogEntry> isCategoryOf) {
		this.isCategoryOf = isCategoryOf;
	}
	
	/**
	 * Add a isCategoryOf to the isCategoryOf collection.
	 * Birectional association : add the current Category instance to given isCategoryOf parameter.
	 * @param isCategoryOfElt Element to add.
	 */
	 public void addIsCategoryOf(final BlogEntry isCategoryOfElt) {
	 	this.isCategoryOf.add(isCategoryOfElt);
	 	isCategoryOfElt.getCategories().add(this);
	 }
	 
	/**
	 * Remove a isCategoryOf to the isCategoryOf collection.
	 * Birectionnal association : remove the current Category instance to given isCategoryOf parameter.
	 * @param isCategoryOfElt Element to remove.
	 */
	 public void removeIsCategoryOf(final BlogEntry isCategoryOfElt) {
	 	this.isCategoryOf.remove(isCategoryOfElt);
	 	isCategoryOfElt.getCategories().remove(this);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Category and the given object has the same PK as this
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
		if (!(other instanceof Category)) {
			return false;
		}
		
		final Category castedOther = (Category) other;
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
