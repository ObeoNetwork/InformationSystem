package org.obeonetwork.sample.attributes;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;


// End of user code for imports

/**
 * 
 */
public class PrimitiveType implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field stringAttribute.
     */
	public static final String PROP_STRINGATTRIBUTE = "stringAttribute";
	
	/**
     * Constant representing the name of the field integerAttribute.
     */
	public static final String PROP_INTEGERATTRIBUTE = "integerAttribute";
	
	/**
     * Constant representing the name of the field booleanAttribute.
     */
	public static final String PROP_BOOLEANATTRIBUTE = "booleanAttribute";
	
	/**
     * Constant representing the name of the field doubleAttribute.
     */
	public static final String PROP_DOUBLEATTRIBUTE = "doubleAttribute";
	
	/**
     * Constant representing the name of the field emailAttribute.
     */
	public static final String PROP_EMAILATTRIBUTE = "emailAttribute";
	
	/**
     * Constant representing the name of the field dateAttribute.
     */
	public static final String PROP_DATEATTRIBUTE = "dateAttribute";
	
	/**
     * Constant representing the name of the field floatAttribute.
     */
	public static final String PROP_FLOATATTRIBUTE = "floatAttribute";
	
	/**
     * Constant representing the name of the field longAttribute.
     */
	public static final String PROP_LONGATTRIBUTE = "longAttribute";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field stringAttribute.
     */
	protected String stringAttribute;

    /**
     * Field integerAttribute.
     */
	protected Integer integerAttribute;

    /**
     * Field booleanAttribute.
     */
	protected Boolean booleanAttribute;

    /**
     * Field doubleAttribute.
     */
	protected Double doubleAttribute;

    /**
     * Field emailAttribute.
     */
	protected String emailAttribute;

    /**
     * Field dateAttribute.
     */
	protected Date dateAttribute;

    /**
     * Field floatAttribute.
     */
	protected Float floatAttribute;

    /**
     * Field longAttribute.
     */
	protected Long longAttribute;

	/**
	 * Default constructor.
	 */
	public PrimitiveType() {
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
	 * @param stringAttribute. 
	 * @param integerAttribute. 
	 * @param booleanAttribute. 
	 * @param doubleAttribute. 
	 * @param emailAttribute. 
	 * @param dateAttribute. 
	 * @param floatAttribute. 
	 * @param longAttribute. 
	 */
	public PrimitiveType(String stringAttribute, Integer integerAttribute, Boolean booleanAttribute, Double doubleAttribute, String emailAttribute, Date dateAttribute, Float floatAttribute, Long longAttribute) {
		this.stringAttribute = stringAttribute;
		this.integerAttribute = integerAttribute;
		this.booleanAttribute = booleanAttribute;
		this.doubleAttribute = doubleAttribute;
		this.emailAttribute = emailAttribute;
		this.dateAttribute = dateAttribute;
		this.floatAttribute = floatAttribute;
		this.longAttribute = longAttribute;
	}

	/**
	 * Return stringAttribute.
	 * @return stringAttribute
	 */
	public String getStringAttribute() {
		return stringAttribute;
	}

	/**
	 * Set a value to parameter stringAttribute.
	 * @param stringAttribute
	 */
	public void setStringAttribute(final String stringAttribute) {
		this.stringAttribute = stringAttribute;
	}

	/**
	 * Return integerAttribute.
	 * @return integerAttribute
	 */
	public Integer getIntegerAttribute() {
		return integerAttribute;
	}

	/**
	 * Set a value to parameter integerAttribute.
	 * @param integerAttribute
	 */
	public void setIntegerAttribute(final Integer integerAttribute) {
		this.integerAttribute = integerAttribute;
	}

	/**
	 * Return booleanAttribute.
	 * @return booleanAttribute
	 */
	public Boolean getBooleanAttribute() {
		return booleanAttribute;
	}

	/**
	 * Set a value to parameter booleanAttribute.
	 * @param booleanAttribute
	 */
	public void setBooleanAttribute(final Boolean booleanAttribute) {
		this.booleanAttribute = booleanAttribute;
	}

	/**
	 * Return doubleAttribute.
	 * @return doubleAttribute
	 */
	public Double getDoubleAttribute() {
		return doubleAttribute;
	}

	/**
	 * Set a value to parameter doubleAttribute.
	 * @param doubleAttribute
	 */
	public void setDoubleAttribute(final Double doubleAttribute) {
		this.doubleAttribute = doubleAttribute;
	}

	/**
	 * Return emailAttribute.
	 * @return emailAttribute
	 */
	public String getEmailAttribute() {
		return emailAttribute;
	}

	/**
	 * Set a value to parameter emailAttribute.
	 * @param emailAttribute
	 */
	public void setEmailAttribute(final String emailAttribute) {
		this.emailAttribute = emailAttribute;
	}

	/**
	 * Return dateAttribute.
	 * @return dateAttribute
	 */
	public Date getDateAttribute() {
		return dateAttribute;
	}

	/**
	 * Set a value to parameter dateAttribute.
	 * @param dateAttribute
	 */
	public void setDateAttribute(final Date dateAttribute) {
		this.dateAttribute = dateAttribute;
	}

	/**
	 * Return floatAttribute.
	 * @return floatAttribute
	 */
	public Float getFloatAttribute() {
		return floatAttribute;
	}

	/**
	 * Set a value to parameter floatAttribute.
	 * @param floatAttribute
	 */
	public void setFloatAttribute(final Float floatAttribute) {
		this.floatAttribute = floatAttribute;
	}

	/**
	 * Return longAttribute.
	 * @return longAttribute
	 */
	public Long getLongAttribute() {
		return longAttribute;
	}

	/**
	 * Set a value to parameter longAttribute.
	 * @param longAttribute
	 */
	public void setLongAttribute(final Long longAttribute) {
		this.longAttribute = longAttribute;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * PrimitiveType and the given object has the same PK as this
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
		if (!(other instanceof PrimitiveType)) {
			return false;
		}
		
		final PrimitiveType castedOther = (PrimitiveType) other;
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