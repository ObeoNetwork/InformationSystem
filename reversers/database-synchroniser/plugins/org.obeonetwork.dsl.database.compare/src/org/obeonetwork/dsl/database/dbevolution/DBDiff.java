/**
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Diff</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.DBDiff#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getDBDiff()
 * @model abstract="true"
 * @generated
 */
public interface DBDiff extends Diff {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getDBDiff_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.DBDiff#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);
} // DBDiff
