/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RemoveConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remove Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RemoveConstraintImpl extends ConstraintChangeImpl implements RemoveConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.REMOVE_CONSTRAINT;
	}

} // RemoveConstraintImpl
