package org.obeonetwork.sample.badpractives;

// Start of user code for imports
import java.io.Serializable;


// End of user code for imports

/**
 *  */
public class TABLE implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field COLUMN.
     */
	public static final String PROP_COLUMN = "COLUMN";
	
	/**
     * Constant representing the name of the field PRIMARY KEY.
     */
	public static final String PROP_PRIMARYKEY = "PRIMARY KEY";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field COLUMN.
     */
	protected Integer cOLUMN;

    /**
     * Field PRIMARY KEY.
     */
	protected Integer pRIMARYKEY;

	/**
	 * Default constructor.
	 */
	public TABLE() {
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
	 * @param COLUMN. 
	 * @param PRIMARY KEY. 
	 */
	public TABLE(Integer cOLUMN, Integer pRIMARYKEY) {
		this.cOLUMN = cOLUMN;
		this.pRIMARYKEY = pRIMARYKEY;
	}

	/**
	 * Return COLUMN.
	 * @return COLUMN
	 */
	public Integer getCOLUMN() {
		return cOLUMN;
	}

	/**
	 * Set a value to parameter COLUMN.
	 * @param COLUMN
	 */
	public void setCOLUMN(final Integer cOLUMN) {
		this.cOLUMN = cOLUMN;
	}

	/**
	 * Return PRIMARYKEY.
	 * @return PRIMARYKEY
	 */
	public Integer getPRIMARYKEY() {
		return pRIMARYKEY;
	}

	/**
	 * Set a value to parameter PRIMARY KEY.
	 * @param PRIMARYKEY
	 */
	public void setPRIMARYKEY(final Integer pRIMARYKEY) {
		this.pRIMARYKEY = pRIMARYKEY;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * TABLE and the given object has the same PK as this
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
		if (!(other instanceof TABLE)) {
			return false;
		}
		
		final TABLE castedOther = (TABLE) other;
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
