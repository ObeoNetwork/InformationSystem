/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation;

import org.obeonetwork.dsl.typeslibrary.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Attribute#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Attribute#isRequired <em>Required</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Attribute#getUsedInIdentifier <em>Used In Identifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Attribute#isInPrimaryIdentifier <em>In Primary Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entityrelation.Entity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Entity)
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute_Owner()
	 * @see org.obeonetwork.dsl.entityrelation.Entity#getAttributes
	 * @model opposite="attributes" transient="false"
	 * @generated
	 */
	Entity getOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entityrelation.Attribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Entity value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entityrelation.Attribute#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entityrelation.Attribute#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Used In Identifier</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entityrelation.Identifier#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used In Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used In Identifier</em>' reference.
	 * @see #setUsedInIdentifier(Identifier)
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute_UsedInIdentifier()
	 * @see org.obeonetwork.dsl.entityrelation.Identifier#getAttributes
	 * @model opposite="attributes"
	 * @generated
	 */
	Identifier getUsedInIdentifier();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entityrelation.Attribute#getUsedInIdentifier <em>Used In Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used In Identifier</em>' reference.
	 * @see #getUsedInIdentifier()
	 * @generated
	 */
	void setUsedInIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>In Primary Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Primary Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Primary Identifier</em>' attribute.
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getAttribute_InPrimaryIdentifier()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInPrimaryIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addToPrimaryIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeFromPrimaryIdentifier();

} // Attribute
