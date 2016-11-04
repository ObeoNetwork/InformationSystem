/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remove Foreign Key</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class RemoveForeignKeyImpl extends ForeignKeyChangeImpl implements RemoveForeignKey {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.REMOVE_FOREIGN_KEY;
	}

} // RemoveForeignKeyImpl
