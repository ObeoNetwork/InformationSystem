/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BClassifier;
import org.obeonetwork.dsl.ecorebinding.BDataType;
import org.obeonetwork.dsl.ecorebinding.BEnum;
import org.obeonetwork.dsl.ecorebinding.BModel;
import org.obeonetwork.dsl.ecorebinding.BPackage;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

import org.obeonetwork.dsl.environment.BoundableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getEcorePackage <em>Ecore Package</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getBModel <em>BModel</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getBEnums <em>BEnums</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getBDataTypes <em>BData Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getBClasses <em>BClasses</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getNestedBPackages <em>Nested BPackages</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl#getBClassifiers <em>BClassifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BPackageImpl extends CDOObjectImpl implements BPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BPACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getEcorePackage() {
		return (EPackage)eGet(EcorebindingPackage.Literals.BPACKAGE__ECORE_PACKAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcorePackage(EPackage newEcorePackage) {
		eSet(EcorebindingPackage.Literals.BPACKAGE__ECORE_PACKAGE, newEcorePackage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModel getBModel() {
		return (BModel)eGet(EcorebindingPackage.Literals.BPACKAGE__BMODEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBModel(BModel newBModel) {
		eSet(EcorebindingPackage.Literals.BPACKAGE__BMODEL, newBModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BEnum> getBEnums() {
		return (EList<BEnum>)eGet(EcorebindingPackage.Literals.BPACKAGE__BENUMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BDataType> getBDataTypes() {
		return (EList<BDataType>)eGet(EcorebindingPackage.Literals.BPACKAGE__BDATA_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BClass> getBClasses() {
		return (EList<BClass>)eGet(EcorebindingPackage.Literals.BPACKAGE__BCLASSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BPackage> getNestedBPackages() {
		return (EList<BPackage>)eGet(EcorebindingPackage.Literals.BPACKAGE__NESTED_BPACKAGES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BClassifier> getBClassifiers() {
		return (EList<BClassifier>)eGet(EcorebindingPackage.Literals.BPACKAGE__BCLASSIFIERS, true);
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

} //BPackageImpl
