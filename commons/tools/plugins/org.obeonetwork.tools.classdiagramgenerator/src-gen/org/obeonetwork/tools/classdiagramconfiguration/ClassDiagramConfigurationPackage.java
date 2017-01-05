/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ClassDiagramConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdiagramconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/classdiagramconf/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classdiagramconf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassDiagramConfigurationPackage eINSTANCE = org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfigurationElement()
	 * @generated
	 */
	int CONFIGURATION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__FULL_QUALIFIED_ID = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>String Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__STRING_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Boolean Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__BOOLEAN_VALUES = 4;

	/**
	 * The number of structural features of the '<em>Configuration Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Configuration Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl <em>Diagram Conf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getDiagramConf()
	 * @generated
	 */
	int DIAGRAM_CONF = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VIEWPOINT = 2;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DIAGRAMS = 3;

	/**
	 * The feature id for the '<em><b>Colors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__COLORS = 4;

	/**
	 * The feature id for the '<em><b>Java Extensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__JAVA_EXTENSIONS = 5;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__ID = CONFIGURATION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__FULL_QUALIFIED_ID = CONFIGURATION_ELEMENT__FULL_QUALIFIED_ID;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__CHILDREN = CONFIGURATION_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>String Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__STRING_VALUES = CONFIGURATION_ELEMENT__STRING_VALUES;

	/**
	 * The feature id for the '<em><b>Boolean Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__BOOLEAN_VALUES = CONFIGURATION_ELEMENT__BOOLEAN_VALUES;

	/**
	 * The feature id for the '<em><b>Description Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__DESCRIPTION_ID = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF__METAMODELS = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Diagram Conf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Diagram Conf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONF_OPERATION_COUNT = CONFIGURATION_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl <em>Configuration Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfigurationValue()
	 * @generated
	 */
	int CONFIGURATION_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_VALUE__ID = 0;

	/**
	 * The feature id for the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_VALUE__FULL_QUALIFIED_ID = 1;

	/**
	 * The number of structural features of the '<em>Configuration Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.StringValueImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__ID = CONFIGURATION_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__FULL_QUALIFIED_ID = CONFIGURATION_VALUE__FULL_QUALIFIED_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = CONFIGURATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = CONFIGURATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_OPERATION_COUNT = CONFIGURATION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.BooleanValueImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__ID = CONFIGURATION_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__FULL_QUALIFIED_ID = CONFIGURATION_VALUE__FULL_QUALIFIED_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__VALUE = CONFIGURATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = CONFIGURATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_OPERATION_COUNT = CONFIGURATION_VALUE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl <em>Color Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl
	 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getColorInfo()
	 * @generated
	 */
	int COLOR_INFO = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO__RED = 1;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO__GREEN = 2;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO__BLUE = 3;

	/**
	 * The number of structural features of the '<em>Color Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Color Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INFO_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDescription()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Description();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getViewpoint <em>Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Viewpoint</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getViewpoint()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Viewpoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDiagrams()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Diagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getColors <em>Colors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colors</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getColors()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Colors();

	/**
	 * Returns the meta object for the attribute list '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getJavaExtensions <em>Java Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Extensions</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.Configuration#getJavaExtensions()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_JavaExtensions();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf <em>Diagram Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Conf</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.DiagramConf
	 * @generated
	 */
	EClass getDiagramConf();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getDescriptionId <em>Description Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Id</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getDescriptionId()
	 * @see #getDiagramConf()
	 * @generated
	 */
	EAttribute getDiagramConf_DescriptionId();

	/**
	 * Returns the meta object for the attribute list '{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getMetamodels <em>Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Metamodels</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getMetamodels()
	 * @see #getDiagramConf()
	 * @generated
	 */
	EAttribute getDiagramConf_Metamodels();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue <em>Configuration Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Value</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue
	 * @generated
	 */
	EClass getConfigurationValue();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getId()
	 * @see #getConfigurationValue()
	 * @generated
	 */
	EAttribute getConfigurationValue_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getFullQualifiedId <em>Full Qualified Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Qualified Id</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getFullQualifiedId()
	 * @see #getConfigurationValue()
	 * @generated
	 */
	EAttribute getConfigurationValue_FullQualifiedId();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.BooleanValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.BooleanValue#isValue()
	 * @see #getBooleanValue()
	 * @generated
	 */
	EAttribute getBooleanValue_Value();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo <em>Color Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Info</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ColorInfo
	 * @generated
	 */
	EClass getColorInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getName()
	 * @see #getColorInfo()
	 * @generated
	 */
	EAttribute getColorInfo_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getRed <em>Red</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getRed()
	 * @see #getColorInfo()
	 * @generated
	 */
	EAttribute getColorInfo_Red();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getGreen <em>Green</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getGreen()
	 * @see #getColorInfo()
	 * @generated
	 */
	EAttribute getColorInfo_Green();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getBlue <em>Blue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getBlue()
	 * @see #getColorInfo()
	 * @generated
	 */
	EAttribute getColorInfo_Blue();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Element</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement
	 * @generated
	 */
	EClass getConfigurationElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getId()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getFullQualifiedId <em>Full Qualified Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Qualified Id</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getFullQualifiedId()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_FullQualifiedId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getChildren()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EReference getConfigurationElement_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getStringValues <em>String Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>String Values</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getStringValues()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EReference getConfigurationElement_StringValues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getBooleanValues <em>Boolean Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boolean Values</em>'.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getBooleanValues()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EReference getConfigurationElement_BooleanValues();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassDiagramConfigurationFactory getClassDiagramConfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DESCRIPTION = eINSTANCE.getConfiguration_Description();

		/**
		 * The meta object literal for the '<em><b>Viewpoint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__VIEWPOINT = eINSTANCE.getConfiguration_Viewpoint();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__DIAGRAMS = eINSTANCE.getConfiguration_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Colors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__COLORS = eINSTANCE.getConfiguration_Colors();

		/**
		 * The meta object literal for the '<em><b>Java Extensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__JAVA_EXTENSIONS = eINSTANCE.getConfiguration_JavaExtensions();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl <em>Diagram Conf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getDiagramConf()
		 * @generated
		 */
		EClass DIAGRAM_CONF = eINSTANCE.getDiagramConf();

		/**
		 * The meta object literal for the '<em><b>Description Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_CONF__DESCRIPTION_ID = eINSTANCE.getDiagramConf_DescriptionId();

		/**
		 * The meta object literal for the '<em><b>Metamodels</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_CONF__METAMODELS = eINSTANCE.getDiagramConf_Metamodels();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl <em>Configuration Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfigurationValue()
		 * @generated
		 */
		EClass CONFIGURATION_VALUE = eINSTANCE.getConfigurationValue();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_VALUE__ID = eINSTANCE.getConfigurationValue_Id();

		/**
		 * The meta object literal for the '<em><b>Full Qualified Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_VALUE__FULL_QUALIFIED_ID = eINSTANCE.getConfigurationValue_FullQualifiedId();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.StringValueImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.BooleanValueImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl <em>Color Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getColorInfo()
		 * @generated
		 */
		EClass COLOR_INFO = eINSTANCE.getColorInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_INFO__NAME = eINSTANCE.getColorInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_INFO__RED = eINSTANCE.getColorInfo_Red();

		/**
		 * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_INFO__GREEN = eINSTANCE.getColorInfo_Green();

		/**
		 * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_INFO__BLUE = eINSTANCE.getColorInfo_Blue();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl
		 * @see org.obeonetwork.tools.classdiagramconfiguration.impl.ClassDiagramConfigurationPackageImpl#getConfigurationElement()
		 * @generated
		 */
		EClass CONFIGURATION_ELEMENT = eINSTANCE.getConfigurationElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_ELEMENT__ID = eINSTANCE.getConfigurationElement_Id();

		/**
		 * The meta object literal for the '<em><b>Full Qualified Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_ELEMENT__FULL_QUALIFIED_ID = eINSTANCE.getConfigurationElement_FullQualifiedId();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_ELEMENT__CHILDREN = eINSTANCE.getConfigurationElement_Children();

		/**
		 * The meta object literal for the '<em><b>String Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_ELEMENT__STRING_VALUES = eINSTANCE.getConfigurationElement_StringValues();

		/**
		 * The meta object literal for the '<em><b>Boolean Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_ELEMENT__BOOLEAN_VALUES = eINSTANCE.getConfigurationElement_BooleanValues();

	}

} //ClassDiagramConfigurationPackage
