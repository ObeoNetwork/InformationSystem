/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Match;
import org.obeonetwork.dsl.database.PrimaryKey;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Update Primary Key</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey <em>New Primary Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdatePrimaryKey()
 * @model
 * @generated
 */
public interface UpdatePrimaryKey extends PrimaryKeyChange {

	/**
	 * Returns the value of the '<em><b>New Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Primary Key</em>' reference.
	 * @see #setNewPrimaryKey(PrimaryKey)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdatePrimaryKey_NewPrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	PrimaryKey getNewPrimaryKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey <em>New Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Primary Key</em>' reference.
	 * @see #getNewPrimaryKey()
	 * @generated
	 */
	void setNewPrimaryKey(PrimaryKey value);

} // UpdatePrimaryKey
