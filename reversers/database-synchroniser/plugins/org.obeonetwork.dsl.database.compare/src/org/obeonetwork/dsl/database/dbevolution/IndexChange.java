/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Diff;
import org.obeonetwork.dsl.database.Index;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Index Change</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.IndexChange#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getIndexChange()
 * @model abstract="true"
 * @generated
 */
public interface IndexChange extends DBDiff {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Index</em>' reference.
	 * @see #setIndex(Index)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getIndexChange_Index()
	 * @model required="true"
	 * @generated
	 */
	Index getIndex();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.IndexChange#getIndex <em>Index</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Index value);

} // IndexChange
