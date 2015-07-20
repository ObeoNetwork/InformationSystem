/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.ecorebinding.BClassifier;
import org.obeonetwork.dsl.ecorebinding.BPackage;
import org.obeonetwork.dsl.ecorebinding.BTypeParameter;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BClassifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl#getBTypeParameters <em>BType Parameters</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl#getBPackage <em>BPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BClassifierImpl extends IdentifiableImpl implements BClassifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BCLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPackage getBPackage() {
		return (BPackage)eGet(EcorebindingPackage.Literals.BCLASSIFIER__BPACKAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPackage(BPackage newBPackage) {
		eSet(EcorebindingPackage.Literals.BCLASSIFIER__BPACKAGE, newBPackage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BTypeParameter> getBTypeParameters() {
		return (EList<BTypeParameter>)eGet(EcorebindingPackage.Literals.BCLASSIFIER__BTYPE_PARAMETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPathValid(BoundableElement root, String path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //BClassifierImpl
