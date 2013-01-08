package org.obeonetwork.dsl.entity.gen.java.common.tests.block1;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;


// End of user code for imports

/**
 *  */
public class Entity1 implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	/**
     * Constant representing the name of the field attribute1.
     */
	public static final String PROP_ATTRIBUTE1 = "attribute1";
	
	/**
     * Constant representing the name of the field atttribute2.
     */
	public static final String PROP_ATTTRIBUTE2 = "atttribute2";
	
	/**
     * Constant representing the name of the field atttribute3.
     */
	public static final String PROP_ATTTRIBUTE3 = "atttribute3";
	
	/**
     * Constant representing the name of the field atttribute4.
     */
	public static final String PROP_ATTTRIBUTE4 = "atttribute4";
	
	/**
     * Constant representing the name of the field atttribute5.
     */
	public static final String PROP_ATTTRIBUTE5 = "atttribute5";
	
	/**
     * Constant representing the name of the field atttribute6.
     */
	public static final String PROP_ATTTRIBUTE6 = "atttribute6";
	
	/**
     * Constant representing the name of the field atttribute7.
     */
	public static final String PROP_ATTTRIBUTE7 = "atttribute7";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field attribute1.
     */
	protected Boolean attribute1;

    /**
     * Field atttribute2.
     */
	protected Date atttribute2;

    /**
     * Field atttribute3.
     */
	protected Double atttribute3;

    /**
     * Field atttribute4.
     */
	protected String atttribute4;

    /**
     * Field atttribute5.
     */
	protected Float atttribute5;

    /**
     * Field atttribute6.
     */
	protected Integer atttribute6;

    /**
     * Field atttribute7.
     */
	protected String atttribute7;

	/**
	 * Default constructor.
	 */
	public Entity1() {
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
	 * @param attribute1. 
	 * @param atttribute2. 
	 * @param atttribute3. 
	 * @param atttribute4. 
	 * @param atttribute5. 
	 * @param atttribute6. 
	 * @param atttribute7. 
	 */
	public Entity1(Boolean attribute1, Date atttribute2, Double atttribute3, String atttribute4, Float atttribute5, Integer atttribute6, String atttribute7) {
		this.attribute1 = attribute1;
		this.atttribute2 = atttribute2;
		this.atttribute3 = atttribute3;
		this.atttribute4 = atttribute4;
		this.atttribute5 = atttribute5;
		this.atttribute6 = atttribute6;
		this.atttribute7 = atttribute7;
	}

	/**
	 * Return attribute1.
	 * @return attribute1
	 */
	public Boolean getAttribute1() {
		return attribute1;
	}

	/**
	 * Set a value to parameter attribute1.
	 * @param attribute1
	 */
	public void setAttribute1(final Boolean attribute1) {
		this.attribute1 = attribute1;
	}

	/**
	 * Return atttribute2.
	 * @return atttribute2
	 */
	public Date getAtttribute2() {
		return atttribute2;
	}

	/**
	 * Set a value to parameter atttribute2.
	 * @param atttribute2
	 */
	public void setAtttribute2(final Date atttribute2) {
		this.atttribute2 = atttribute2;
	}

	/**
	 * Return atttribute3.
	 * @return atttribute3
	 */
	public Double getAtttribute3() {
		return atttribute3;
	}

	/**
	 * Set a value to parameter atttribute3.
	 * @param atttribute3
	 */
	public void setAtttribute3(final Double atttribute3) {
		this.atttribute3 = atttribute3;
	}

	/**
	 * Return atttribute4.
	 * @return atttribute4
	 */
	public String getAtttribute4() {
		return atttribute4;
	}

	/**
	 * Set a value to parameter atttribute4.
	 * @param atttribute4
	 */
	public void setAtttribute4(final String atttribute4) {
		this.atttribute4 = atttribute4;
	}

	/**
	 * Return atttribute5.
	 * @return atttribute5
	 */
	public Float getAtttribute5() {
		return atttribute5;
	}

	/**
	 * Set a value to parameter atttribute5.
	 * @param atttribute5
	 */
	public void setAtttribute5(final Float atttribute5) {
		this.atttribute5 = atttribute5;
	}

	/**
	 * Return atttribute6.
	 * @return atttribute6
	 */
	public Integer getAtttribute6() {
		return atttribute6;
	}

	/**
	 * Set a value to parameter atttribute6.
	 * @param atttribute6
	 */
	public void setAtttribute6(final Integer atttribute6) {
		this.atttribute6 = atttribute6;
	}

	/**
	 * Return atttribute7.
	 * @return atttribute7
	 */
	public String getAtttribute7() {
		return atttribute7;
	}

	/**
	 * Set a value to parameter atttribute7.
	 * @param atttribute7
	 */
	public void setAtttribute7(final String atttribute7) {
		this.atttribute7 = atttribute7;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Entity1 and the given object has the same PK as this
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
		if (!(other instanceof Entity1)) {
			return false;
		}
		
		final Entity1 castedOther = (Entity1) other;
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
