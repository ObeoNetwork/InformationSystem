/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.AttributeChange;
import org.obeonetwork.dsl.database.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Table Comment Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange#getNewTable <em>New Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateTableCommentChange()
 * @model
 * @generated
 */
public interface UpdateTableCommentChange extends TableChange {

	/**
	 * Returns the value of the '<em><b>New Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Table</em>' reference.
	 * @see #setNewTable(Table)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateTableCommentChange_NewTable()
	 * @model required="true"
	 * @generated
	 */
	Table getNewTable();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange#getNewTable <em>New Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Table</em>' reference.
	 * @see #getNewTable()
	 * @generated
	 */
	void setNewTable(Table value);
} // UpdateTableCommentChange
