/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingFactory
 * @model kind="package"
 * @generated
 */
public interface EcorebindingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecorebinding";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/ecorebinding/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecorebinding";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcorebindingPackage eINSTANCE = org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.BBase <em>BBase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.BBase
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBBase()
	 * @generated
	 */
	int BBASE = 0;

	/**
	 * The number of structural features of the '<em>BBase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBASE_FEATURE_COUNT = EnvironmentPackage.BOUNDABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BModelImpl <em>BModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BModelImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBModel()
	 * @generated
	 */
	int BMODEL = 1;

	/**
	 * The feature id for the '<em><b>BPackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__BPACKAGES = BBASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL_FEATURE_COUNT = BBASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl <em>BPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBPackage()
	 * @generated
	 */
	int BPACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Ecore Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__ECORE_PACKAGE = BBASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>BModel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__BMODEL = BBASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>BEnums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__BENUMS = BBASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>BData Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__BDATA_TYPES = BBASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>BClasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__BCLASSES = BBASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Nested BPackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__NESTED_BPACKAGES = BBASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>BClassifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE__BCLASSIFIERS = BBASE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>BPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPACKAGE_FEATURE_COUNT = BBASE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl <em>BClassifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBClassifier()
	 * @generated
	 */
	int BCLASSIFIER = 7;

	/**
	 * The feature id for the '<em><b>BType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASSIFIER__BTYPE_PARAMETERS = BBASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>BPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASSIFIER__BPACKAGE = BBASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BClassifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASSIFIER_FEATURE_COUNT = BBASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BClassImpl <em>BClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BClassImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBClass()
	 * @generated
	 */
	int BCLASS = 3;

	/**
	 * The feature id for the '<em><b>BType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS__BTYPE_PARAMETERS = BCLASSIFIER__BTYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>BPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS__BPACKAGE = BCLASSIFIER__BPACKAGE;

	/**
	 * The feature id for the '<em><b>Ecore Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS__ECORE_CLASS = BCLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>BFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS__BFEATURES = BCLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>BOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS__BOPERATIONS = BCLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>BClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCLASS_FEATURE_COUNT = BCLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BTypedElementImpl <em>BTyped Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BTypedElementImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBTypedElement()
	 * @generated
	 */
	int BTYPED_ELEMENT = 11;

	/**
	 * The number of structural features of the '<em>BTyped Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTYPED_ELEMENT_FEATURE_COUNT = BBASE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl <em>BFeature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBFeature()
	 * @generated
	 */
	int BFEATURE = 4;

	/**
	 * The feature id for the '<em><b>BClass</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE__BCLASS = BTYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ecore Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE__ECORE_FEATURE = BTYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BFeature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_FEATURE_COUNT = BTYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BDataTypeImpl <em>BData Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BDataTypeImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBDataType()
	 * @generated
	 */
	int BDATA_TYPE = 8;

	/**
	 * The feature id for the '<em><b>BType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BDATA_TYPE__BTYPE_PARAMETERS = BCLASSIFIER__BTYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>BPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BDATA_TYPE__BPACKAGE = BCLASSIFIER__BPACKAGE;

	/**
	 * The feature id for the '<em><b>Ecore Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BDATA_TYPE__ECORE_DATA_TYPE = BCLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BData Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BDATA_TYPE_FEATURE_COUNT = BCLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl <em>BEnum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBEnum()
	 * @generated
	 */
	int BENUM = 5;

	/**
	 * The feature id for the '<em><b>BType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM__BTYPE_PARAMETERS = BDATA_TYPE__BTYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>BPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM__BPACKAGE = BDATA_TYPE__BPACKAGE;

	/**
	 * The feature id for the '<em><b>Ecore Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM__ECORE_DATA_TYPE = BDATA_TYPE__ECORE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Ecore Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM__ECORE_ENUM = BDATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>BEnum Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM__BENUM_LITERALS = BDATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BEnum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM_FEATURE_COUNT = BDATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumLiteralImpl <em>BEnum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BEnumLiteralImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBEnumLiteral()
	 * @generated
	 */
	int BENUM_LITERAL = 6;

	/**
	 * The feature id for the '<em><b>BEnum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM_LITERAL__BENUM = BBASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ecore Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM_LITERAL__ECORE_ENUM_LITERAL = BBASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BEnum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENUM_LITERAL_FEATURE_COUNT = BBASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl <em>BOperation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBOperation()
	 * @generated
	 */
	int BOPERATION = 9;

	/**
	 * The feature id for the '<em><b>BClass</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOPERATION__BCLASS = BTYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ecore Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOPERATION__ECORE_OPERATION = BTYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>BParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOPERATION__BPARAMETERS = BTYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>BType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOPERATION__BTYPE_PARAMETERS = BTYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>BOperation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOPERATION_FEATURE_COUNT = BTYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl <em>BParameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBParameter()
	 * @generated
	 */
	int BPARAMETER = 10;

	/**
	 * The feature id for the '<em><b>BOperation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETER__BOPERATION = BTYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ecore Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETER__ECORE_PARAMETER = BTYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETER_FEATURE_COUNT = BTYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BTypeParameterImpl <em>BType Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.ecorebinding.impl.BTypeParameterImpl
	 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBTypeParameter()
	 * @generated
	 */
	int BTYPE_PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Ecore Type Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTYPE_PARAMETER__ECORE_TYPE_PARAMETER = BBASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BType Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTYPE_PARAMETER_FEATURE_COUNT = BBASE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BBase <em>BBase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BBase</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BBase
	 * @generated
	 */
	EClass getBBase();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BModel <em>BModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BModel</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BModel
	 * @generated
	 */
	EClass getBModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BModel#getBPackages <em>BPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BPackages</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BModel#getBPackages()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_BPackages();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BPackage <em>BPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPackage</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage
	 * @generated
	 */
	EClass getBPackage();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getEcorePackage <em>Ecore Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Package</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getEcorePackage()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_EcorePackage();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBModel <em>BModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>BModel</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBModel()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_BModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBEnums <em>BEnums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BEnums</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBEnums()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_BEnums();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBDataTypes <em>BData Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BData Types</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBDataTypes()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_BDataTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBClasses <em>BClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BClasses</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBClasses()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_BClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getNestedBPackages <em>Nested BPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested BPackages</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getNestedBPackages()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_NestedBPackages();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBClassifiers <em>BClassifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>BClassifiers</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBClassifiers()
	 * @see #getBPackage()
	 * @generated
	 */
	EReference getBPackage_BClassifiers();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BClass <em>BClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BClass</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClass
	 * @generated
	 */
	EClass getBClass();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BClass#getEcoreClass <em>Ecore Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Class</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClass#getEcoreClass()
	 * @see #getBClass()
	 * @generated
	 */
	EReference getBClass_EcoreClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BClass#getBFeatures <em>BFeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BFeatures</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClass#getBFeatures()
	 * @see #getBClass()
	 * @generated
	 */
	EReference getBClass_BFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BClass#getBOperations <em>BOperations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BOperations</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClass#getBOperations()
	 * @see #getBClass()
	 * @generated
	 */
	EReference getBClass_BOperations();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BFeature <em>BFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFeature</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BFeature
	 * @generated
	 */
	EClass getBFeature();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.ecorebinding.BFeature#getBClass <em>BClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>BClass</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BFeature#getBClass()
	 * @see #getBFeature()
	 * @generated
	 */
	EReference getBFeature_BClass();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BFeature#getEcoreFeature <em>Ecore Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Feature</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BFeature#getEcoreFeature()
	 * @see #getBFeature()
	 * @generated
	 */
	EReference getBFeature_EcoreFeature();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BEnum <em>BEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BEnum</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnum
	 * @generated
	 */
	EClass getBEnum();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BEnum#getEcoreEnum <em>Ecore Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Enum</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnum#getEcoreEnum()
	 * @see #getBEnum()
	 * @generated
	 */
	EReference getBEnum_EcoreEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BEnum#getBEnumLiterals <em>BEnum Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BEnum Literals</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnum#getBEnumLiterals()
	 * @see #getBEnum()
	 * @generated
	 */
	EReference getBEnum_BEnumLiterals();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral <em>BEnum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BEnum Literal</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnumLiteral
	 * @generated
	 */
	EClass getBEnumLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum <em>BEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>BEnum</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum()
	 * @see #getBEnumLiteral()
	 * @generated
	 */
	EReference getBEnumLiteral_BEnum();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getEcoreEnumLiteral <em>Ecore Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Enum Literal</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getEcoreEnumLiteral()
	 * @see #getBEnumLiteral()
	 * @generated
	 */
	EReference getBEnumLiteral_EcoreEnumLiteral();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BClassifier <em>BClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BClassifier</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClassifier
	 * @generated
	 */
	EClass getBClassifier();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage <em>BPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>BPackage</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage()
	 * @see #getBClassifier()
	 * @generated
	 */
	EReference getBClassifier_BPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBTypeParameters <em>BType Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BType Parameters</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BClassifier#getBTypeParameters()
	 * @see #getBClassifier()
	 * @generated
	 */
	EReference getBClassifier_BTypeParameters();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BDataType <em>BData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BData Type</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BDataType
	 * @generated
	 */
	EClass getBDataType();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BDataType#getEcoreDataType <em>Ecore Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Data Type</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BDataType#getEcoreDataType()
	 * @see #getBDataType()
	 * @generated
	 */
	EReference getBDataType_EcoreDataType();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BOperation <em>BOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BOperation</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation
	 * @generated
	 */
	EClass getBOperation();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBClass <em>BClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>BClass</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getBClass()
	 * @see #getBOperation()
	 * @generated
	 */
	EReference getBOperation_BClass();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getEcoreOperation <em>Ecore Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Operation</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getEcoreOperation()
	 * @see #getBOperation()
	 * @generated
	 */
	EReference getBOperation_EcoreOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBParameters <em>BParameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BParameters</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getBParameters()
	 * @see #getBOperation()
	 * @generated
	 */
	EReference getBOperation_BParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBTypeParameters <em>BType Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BType Parameters</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getBTypeParameters()
	 * @see #getBOperation()
	 * @generated
	 */
	EReference getBOperation_BTypeParameters();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BParameter <em>BParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BParameter</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BParameter
	 * @generated
	 */
	EClass getBParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation <em>BOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>BOperation</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation()
	 * @see #getBParameter()
	 * @generated
	 */
	EReference getBParameter_BOperation();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BParameter#getEcoreParameter <em>Ecore Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Parameter</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BParameter#getEcoreParameter()
	 * @see #getBParameter()
	 * @generated
	 */
	EReference getBParameter_EcoreParameter();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BTypedElement <em>BTyped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BTyped Element</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BTypedElement
	 * @generated
	 */
	EClass getBTypedElement();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.ecorebinding.BTypeParameter <em>BType Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BType Parameter</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BTypeParameter
	 * @generated
	 */
	EClass getBTypeParameter();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.ecorebinding.BTypeParameter#getEcoreTypeParameter <em>Ecore Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Type Parameter</em>'.
	 * @see org.obeonetwork.dsl.ecorebinding.BTypeParameter#getEcoreTypeParameter()
	 * @see #getBTypeParameter()
	 * @generated
	 */
	EReference getBTypeParameter_EcoreTypeParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcorebindingFactory getEcorebindingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.BBase <em>BBase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.BBase
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBBase()
		 * @generated
		 */
		EClass BBASE = eINSTANCE.getBBase();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BModelImpl <em>BModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BModelImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBModel()
		 * @generated
		 */
		EClass BMODEL = eINSTANCE.getBModel();

		/**
		 * The meta object literal for the '<em><b>BPackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__BPACKAGES = eINSTANCE.getBModel_BPackages();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl <em>BPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BPackageImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBPackage()
		 * @generated
		 */
		EClass BPACKAGE = eINSTANCE.getBPackage();

		/**
		 * The meta object literal for the '<em><b>Ecore Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__ECORE_PACKAGE = eINSTANCE.getBPackage_EcorePackage();

		/**
		 * The meta object literal for the '<em><b>BModel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__BMODEL = eINSTANCE.getBPackage_BModel();

		/**
		 * The meta object literal for the '<em><b>BEnums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__BENUMS = eINSTANCE.getBPackage_BEnums();

		/**
		 * The meta object literal for the '<em><b>BData Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__BDATA_TYPES = eINSTANCE.getBPackage_BDataTypes();

		/**
		 * The meta object literal for the '<em><b>BClasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__BCLASSES = eINSTANCE.getBPackage_BClasses();

		/**
		 * The meta object literal for the '<em><b>Nested BPackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__NESTED_BPACKAGES = eINSTANCE.getBPackage_NestedBPackages();

		/**
		 * The meta object literal for the '<em><b>BClassifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPACKAGE__BCLASSIFIERS = eINSTANCE.getBPackage_BClassifiers();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BClassImpl <em>BClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BClassImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBClass()
		 * @generated
		 */
		EClass BCLASS = eINSTANCE.getBClass();

		/**
		 * The meta object literal for the '<em><b>Ecore Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCLASS__ECORE_CLASS = eINSTANCE.getBClass_EcoreClass();

		/**
		 * The meta object literal for the '<em><b>BFeatures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCLASS__BFEATURES = eINSTANCE.getBClass_BFeatures();

		/**
		 * The meta object literal for the '<em><b>BOperations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCLASS__BOPERATIONS = eINSTANCE.getBClass_BOperations();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl <em>BFeature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBFeature()
		 * @generated
		 */
		EClass BFEATURE = eINSTANCE.getBFeature();

		/**
		 * The meta object literal for the '<em><b>BClass</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFEATURE__BCLASS = eINSTANCE.getBFeature_BClass();

		/**
		 * The meta object literal for the '<em><b>Ecore Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFEATURE__ECORE_FEATURE = eINSTANCE.getBFeature_EcoreFeature();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl <em>BEnum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBEnum()
		 * @generated
		 */
		EClass BENUM = eINSTANCE.getBEnum();

		/**
		 * The meta object literal for the '<em><b>Ecore Enum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENUM__ECORE_ENUM = eINSTANCE.getBEnum_EcoreEnum();

		/**
		 * The meta object literal for the '<em><b>BEnum Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENUM__BENUM_LITERALS = eINSTANCE.getBEnum_BEnumLiterals();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumLiteralImpl <em>BEnum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BEnumLiteralImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBEnumLiteral()
		 * @generated
		 */
		EClass BENUM_LITERAL = eINSTANCE.getBEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>BEnum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENUM_LITERAL__BENUM = eINSTANCE.getBEnumLiteral_BEnum();

		/**
		 * The meta object literal for the '<em><b>Ecore Enum Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENUM_LITERAL__ECORE_ENUM_LITERAL = eINSTANCE.getBEnumLiteral_EcoreEnumLiteral();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl <em>BClassifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BClassifierImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBClassifier()
		 * @generated
		 */
		EClass BCLASSIFIER = eINSTANCE.getBClassifier();

		/**
		 * The meta object literal for the '<em><b>BPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCLASSIFIER__BPACKAGE = eINSTANCE.getBClassifier_BPackage();

		/**
		 * The meta object literal for the '<em><b>BType Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCLASSIFIER__BTYPE_PARAMETERS = eINSTANCE.getBClassifier_BTypeParameters();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BDataTypeImpl <em>BData Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BDataTypeImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBDataType()
		 * @generated
		 */
		EClass BDATA_TYPE = eINSTANCE.getBDataType();

		/**
		 * The meta object literal for the '<em><b>Ecore Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BDATA_TYPE__ECORE_DATA_TYPE = eINSTANCE.getBDataType_EcoreDataType();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl <em>BOperation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBOperation()
		 * @generated
		 */
		EClass BOPERATION = eINSTANCE.getBOperation();

		/**
		 * The meta object literal for the '<em><b>BClass</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOPERATION__BCLASS = eINSTANCE.getBOperation_BClass();

		/**
		 * The meta object literal for the '<em><b>Ecore Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOPERATION__ECORE_OPERATION = eINSTANCE.getBOperation_EcoreOperation();

		/**
		 * The meta object literal for the '<em><b>BParameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOPERATION__BPARAMETERS = eINSTANCE.getBOperation_BParameters();

		/**
		 * The meta object literal for the '<em><b>BType Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOPERATION__BTYPE_PARAMETERS = eINSTANCE.getBOperation_BTypeParameters();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl <em>BParameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBParameter()
		 * @generated
		 */
		EClass BPARAMETER = eINSTANCE.getBParameter();

		/**
		 * The meta object literal for the '<em><b>BOperation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPARAMETER__BOPERATION = eINSTANCE.getBParameter_BOperation();

		/**
		 * The meta object literal for the '<em><b>Ecore Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPARAMETER__ECORE_PARAMETER = eINSTANCE.getBParameter_EcoreParameter();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BTypedElementImpl <em>BTyped Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BTypedElementImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBTypedElement()
		 * @generated
		 */
		EClass BTYPED_ELEMENT = eINSTANCE.getBTypedElement();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.ecorebinding.impl.BTypeParameterImpl <em>BType Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.ecorebinding.impl.BTypeParameterImpl
		 * @see org.obeonetwork.dsl.ecorebinding.impl.EcorebindingPackageImpl#getBTypeParameter()
		 * @generated
		 */
		EClass BTYPE_PARAMETER = eINSTANCE.getBTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Ecore Type Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BTYPE_PARAMETER__ECORE_TYPE_PARAMETER = eINSTANCE.getBTypeParameter_EcoreTypeParameter();

	}

} //EcorebindingPackage
