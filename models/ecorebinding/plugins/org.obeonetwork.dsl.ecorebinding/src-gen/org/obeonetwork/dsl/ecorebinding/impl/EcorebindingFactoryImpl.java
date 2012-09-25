/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.dsl.ecorebinding.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorebindingFactoryImpl extends EFactoryImpl implements EcorebindingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcorebindingFactory init() {
		try {
			EcorebindingFactory theEcorebindingFactory = (EcorebindingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeonetwork.org/dsl/ecorebinding/1.0.0"); 
			if (theEcorebindingFactory != null) {
				return theEcorebindingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcorebindingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorebindingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EcorebindingPackage.BMODEL: return (EObject)createBModel();
			case EcorebindingPackage.BPACKAGE: return (EObject)createBPackage();
			case EcorebindingPackage.BCLASS: return (EObject)createBClass();
			case EcorebindingPackage.BFEATURE: return (EObject)createBFeature();
			case EcorebindingPackage.BENUM: return (EObject)createBEnum();
			case EcorebindingPackage.BENUM_LITERAL: return (EObject)createBEnumLiteral();
			case EcorebindingPackage.BCLASSIFIER: return (EObject)createBClassifier();
			case EcorebindingPackage.BDATA_TYPE: return (EObject)createBDataType();
			case EcorebindingPackage.BOPERATION: return (EObject)createBOperation();
			case EcorebindingPackage.BPARAMETER: return (EObject)createBParameter();
			case EcorebindingPackage.BTYPED_ELEMENT: return (EObject)createBTypedElement();
			case EcorebindingPackage.BTYPE_PARAMETER: return (EObject)createBTypeParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModel createBModel() {
		BModelImpl bModel = new BModelImpl();
		return bModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPackage createBPackage() {
		BPackageImpl bPackage = new BPackageImpl();
		return bPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BClass createBClass() {
		BClassImpl bClass = new BClassImpl();
		return bClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFeature createBFeature() {
		BFeatureImpl bFeature = new BFeatureImpl();
		return bFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BEnum createBEnum() {
		BEnumImpl bEnum = new BEnumImpl();
		return bEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BEnumLiteral createBEnumLiteral() {
		BEnumLiteralImpl bEnumLiteral = new BEnumLiteralImpl();
		return bEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BClassifier createBClassifier() {
		BClassifierImpl bClassifier = new BClassifierImpl();
		return bClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BDataType createBDataType() {
		BDataTypeImpl bDataType = new BDataTypeImpl();
		return bDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BOperation createBOperation() {
		BOperationImpl bOperation = new BOperationImpl();
		return bOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BParameter createBParameter() {
		BParameterImpl bParameter = new BParameterImpl();
		return bParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTypedElement createBTypedElement() {
		BTypedElementImpl bTypedElement = new BTypedElementImpl();
		return bTypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTypeParameter createBTypeParameter() {
		BTypeParameterImpl bTypeParameter = new BTypeParameterImpl();
		return bTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorebindingPackage getEcorebindingPackage() {
		return (EcorebindingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcorebindingPackage getPackage() {
		return EcorebindingPackage.eINSTANCE;
	}

} //EcorebindingFactoryImpl
