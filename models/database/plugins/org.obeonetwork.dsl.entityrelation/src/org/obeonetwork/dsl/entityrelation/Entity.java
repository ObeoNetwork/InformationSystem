/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Entity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Entity#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.Entity#getPrimaryIdentifier <em>Primary Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entityrelation.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entityrelation.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getEntity_Attributes()
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entityrelation.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getEntity_Identifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Identifier> getIdentifiers();

	/**
	 * Returns the value of the '<em><b>Primary Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Identifier</em>' reference.
	 * @see #setPrimaryIdentifier(Identifier)
	 * @see org.obeonetwork.dsl.entityrelation.EntityRelationPackage#getEntity_PrimaryIdentifier()
	 * @model
	 * @generated
	 */
	Identifier getPrimaryIdentifier();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entityrelation.Entity#getPrimaryIdentifier <em>Primary Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Identifier</em>' reference.
	 * @see #getPrimaryIdentifier()
	 * @generated
	 */
	void setPrimaryIdentifier(Identifier value);

} // Entity
