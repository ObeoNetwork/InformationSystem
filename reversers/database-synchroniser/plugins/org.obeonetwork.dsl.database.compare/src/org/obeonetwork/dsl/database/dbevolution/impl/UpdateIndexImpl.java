/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.Equivalence;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.impl.MatchImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateIndex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Update Index</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateIndexImpl#getNewIndex <em>New Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateIndexImpl extends IndexChangeImpl implements UpdateIndex {
	/**
	 * The cached value of the '{@link #getNewIndex() <em>New Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected Index newIndex;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateIndexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.UPDATE_INDEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Index getNewIndex() {
		if (newIndex != null && ((EObject)newIndex).eIsProxy()) {
			InternalEObject oldNewIndex = (InternalEObject)newIndex;
			newIndex = (Index)eResolveProxy(oldNewIndex);
			if (newIndex != oldNewIndex) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.UPDATE_INDEX__NEW_INDEX, oldNewIndex, newIndex));
			}
		}
		return newIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Index basicGetNewIndex() {
		return newIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewIndex(Index newNewIndex) {
		Index oldNewIndex = newIndex;
		newIndex = newNewIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.UPDATE_INDEX__NEW_INDEX, oldNewIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_INDEX__NEW_INDEX:
				if (resolve) return getNewIndex();
				return basicGetNewIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_INDEX__NEW_INDEX:
				setNewIndex((Index)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_INDEX__NEW_INDEX:
				setNewIndex((Index)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_INDEX__NEW_INDEX:
				return newIndex != null;
		}
		return super.eIsSet(featureID);
	}

} // UpdateIndexImpl
