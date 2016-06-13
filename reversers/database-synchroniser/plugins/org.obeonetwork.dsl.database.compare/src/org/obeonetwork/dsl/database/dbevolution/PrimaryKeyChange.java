/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Diff;
import org.obeonetwork.dsl.database.PrimaryKey;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Primary Key Change</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getPrimaryKeyChange()
 * @model abstract="true"
 * @generated
 */
public interface PrimaryKeyChange extends DBDiff {
	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(PrimaryKey)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getPrimaryKeyChange_PrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	PrimaryKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(PrimaryKey value);

} // PrimaryKeyChange
