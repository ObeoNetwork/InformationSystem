package org.obeonetwork.sample.types;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;


// End of user code for imports

/**
 * 
 */
public class Types implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field myBoolean.
     */
	public static final String PROP_MYBOOLEAN = "myBoolean";
	
	/**
     * Constant representing the name of the field myDate.
     */
	public static final String PROP_MYDATE = "myDate";
	
	/**
     * Constant representing the name of the field myDouble.
     */
	public static final String PROP_MYDOUBLE = "myDouble";
	
	/**
     * Constant representing the name of the field myMail.
     */
	public static final String PROP_MYMAIL = "myMail";
	
	/**
     * Constant representing the name of the field myFloat.
     */
	public static final String PROP_MYFLOAT = "myFloat";
	
	/**
     * Constant representing the name of the field myInteger.
     */
	public static final String PROP_MYINTEGER = "myInteger";
	
	/**
     * Constant representing the name of the field myLong.
     */
	public static final String PROP_MYLONG = "myLong";
	
	/**
     * Constant representing the name of the field myString.
     */
	public static final String PROP_MYSTRING = "myString";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field myBoolean.
     */
	protected Boolean myBoolean;

    /**
     * Field myDate.
     */
	protected Date myDate;

    /**
     * Field myDouble.
     */
	protected Double myDouble;

    /**
     * Field myMail.
     */
	protected String myMail;

    /**
     * Field myFloat.
     */
	protected Float myFloat;

    /**
     * Field myInteger.
     */
	protected Integer myInteger;

    /**
     * Field myLong.
     */
	protected Long myLong;

    /**
     * Field myString.
     */
	protected String myString;

	/**
	 * Default constructor.
	 */
	public Types() {
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
	 * @param myBoolean. 
	 * @param myDate. 
	 * @param myDouble. 
	 * @param myMail. 
	 * @param myFloat. 
	 * @param myInteger. 
	 * @param myLong. 
	 * @param myString. 
	 */
	public Types(Boolean myBoolean, Date myDate, Double myDouble, String myMail, Float myFloat, Integer myInteger, Long myLong, String myString) {
		this.myBoolean = myBoolean;
		this.myDate = myDate;
		this.myDouble = myDouble;
		this.myMail = myMail;
		this.myFloat = myFloat;
		this.myInteger = myInteger;
		this.myLong = myLong;
		this.myString = myString;
	}

	/**
	 * Return myBoolean.
	 * @return myBoolean
	 */
	public Boolean getMyBoolean() {
		return myBoolean;
	}

	/**
	 * Set a value to parameter myBoolean.
	 * @param myBoolean
	 */
	public void setMyBoolean(final Boolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	/**
	 * Return myDate.
	 * @return myDate
	 */
	public Date getMyDate() {
		return myDate;
	}

	/**
	 * Set a value to parameter myDate.
	 * @param myDate
	 */
	public void setMyDate(final Date myDate) {
		this.myDate = myDate;
	}

	/**
	 * Return myDouble.
	 * @return myDouble
	 */
	public Double getMyDouble() {
		return myDouble;
	}

	/**
	 * Set a value to parameter myDouble.
	 * @param myDouble
	 */
	public void setMyDouble(final Double myDouble) {
		this.myDouble = myDouble;
	}

	/**
	 * Return myMail.
	 * @return myMail
	 */
	public String getMyMail() {
		return myMail;
	}

	/**
	 * Set a value to parameter myMail.
	 * @param myMail
	 */
	public void setMyMail(final String myMail) {
		this.myMail = myMail;
	}

	/**
	 * Return myFloat.
	 * @return myFloat
	 */
	public Float getMyFloat() {
		return myFloat;
	}

	/**
	 * Set a value to parameter myFloat.
	 * @param myFloat
	 */
	public void setMyFloat(final Float myFloat) {
		this.myFloat = myFloat;
	}

	/**
	 * Return myInteger.
	 * @return myInteger
	 */
	public Integer getMyInteger() {
		return myInteger;
	}

	/**
	 * Set a value to parameter myInteger.
	 * @param myInteger
	 */
	public void setMyInteger(final Integer myInteger) {
		this.myInteger = myInteger;
	}

	/**
	 * Return myLong.
	 * @return myLong
	 */
	public Long getMyLong() {
		return myLong;
	}

	/**
	 * Set a value to parameter myLong.
	 * @param myLong
	 */
	public void setMyLong(final Long myLong) {
		this.myLong = myLong;
	}

	/**
	 * Return myString.
	 * @return myString
	 */
	public String getMyString() {
		return myString;
	}

	/**
	 * Set a value to parameter myString.
	 * @param myString
	 */
	public void setMyString(final String myString) {
		this.myString = myString;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Types and the given object has the same PK as this
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
		if (!(other instanceof Types)) {
			return false;
		}
		
		final Types castedOther = (Types) other;
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