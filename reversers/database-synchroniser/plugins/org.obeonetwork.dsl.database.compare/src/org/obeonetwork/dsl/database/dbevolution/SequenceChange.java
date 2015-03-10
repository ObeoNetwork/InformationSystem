/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Diff;
import org.obeonetwork.dsl.database.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.SequenceChange#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getSequenceChange()
 * @model abstract="true"
 * @generated
 */
public interface SequenceChange extends DBDiff {
	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' reference.
	 * @see #setSequence(Sequence)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getSequenceChange_Sequence()
	 * @model required="true"
	 * @generated
	 */
	Sequence getSequence();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.SequenceChange#getSequence <em>Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence</em>' reference.
	 * @see #getSequence()
	 * @generated
	 */
	void setSequence(Sequence value);

} // SequenceChange
