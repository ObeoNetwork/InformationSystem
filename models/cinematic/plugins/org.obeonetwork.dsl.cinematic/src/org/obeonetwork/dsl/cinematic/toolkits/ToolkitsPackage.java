/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.toolkits;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

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
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsFactory
 * @model kind="package"
 * @generated
 */
public interface ToolkitsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "toolkits";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/cinematic/toolkits/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cinematic-toolkits";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ToolkitsPackage eINSTANCE = org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitImpl <em>Toolkit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitImpl
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getToolkit()
	 * @generated
	 */
	int TOOLKIT = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOLKIT__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOLKIT__WIDGETS = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOLKIT__NAME = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Toolkit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOLKIT_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__NAME = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__ICON = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__IMPLEMENTATION = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Toolkit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__TOOLKIT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Possible Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__POSSIBLE_EVENTS = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__IS_CONTAINER = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__STYLE = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetEventTypeImpl <em>Widget Event Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetEventTypeImpl
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getWidgetEventType()
	 * @generated
	 */
	int WIDGET_EVENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EVENT_TYPE__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EVENT_TYPE__NAME = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Widget Event Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EVENT_TYPE_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 3;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DECORATOR = 0;

	/**
	 * The feature id for the '<em><b>Decorator Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DECORATOR_POSITION = 1;

	/**
	 * The feature id for the '<em><b>Decorator VFill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DECORATOR_VFILL = 2;

	/**
	 * The feature id for the '<em><b>Decorator HFill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DECORATOR_HFILL = 3;

	/**
	 * The feature id for the '<em><b>Bordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__BORDERED = 4;

	/**
	 * The feature id for the '<em><b>Rounded Corners</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__ROUNDED_CORNERS = 5;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FONT_COLOR = 6;

	/**
	 * The feature id for the '<em><b>Font Underlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FONT_UNDERLINED = 7;

	/**
	 * The feature id for the '<em><b>Label HAlignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__LABEL_HALIGNMENT = 8;

	/**
	 * The feature id for the '<em><b>Default Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DEFAULT_WIDTH = 9;

	/**
	 * The feature id for the '<em><b>Default Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__DEFAULT_HEIGHT = 10;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition <em>Cardinal Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getCardinalPosition()
	 * @generated
	 */
	int CARDINAL_POSITION = 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment <em>Horizontal Alignment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment
	 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getHorizontalAlignment()
	 * @generated
	 */
	int HORIZONTAL_ALIGNMENT = 5;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit <em>Toolkit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Toolkit</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Toolkit
	 * @generated
	 */
	EClass getToolkit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets()
	 * @see #getToolkit()
	 * @generated
	 */
	EReference getToolkit_Widgets();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getName()
	 * @see #getToolkit()
	 * @generated
	 */
	EAttribute getToolkit_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getName()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Implementation();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Toolkit</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Toolkit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getPossibleEvents <em>Possible Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Events</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getPossibleEvents()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_PossibleEvents();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer <em>Is Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Container</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_IsContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getStyle()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Style();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType <em>Widget Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Event Type</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType
	 * @generated
	 */
	EClass getWidgetEventType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType#getName()
	 * @see #getWidgetEventType()
	 * @generated
	 */
	EAttribute getWidgetEventType_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.toolkits.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecorator <em>Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getDecorator()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Decorator();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecoratorPosition <em>Decorator Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator Position</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getDecoratorPosition()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_DecoratorPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorVFill <em>Decorator VFill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator VFill</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorVFill()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_DecoratorVFill();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorHFill <em>Decorator HFill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator HFill</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorHFill()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_DecoratorHFill();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isBordered <em>Bordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bordered</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#isBordered()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Bordered();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isRoundedCorners <em>Rounded Corners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rounded Corners</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#isRoundedCorners()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_RoundedCorners();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getFontColor()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_FontColor();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isFontUnderlined <em>Font Underlined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Underlined</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#isFontUnderlined()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_FontUnderlined();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getLabelHAlignment <em>Label HAlignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label HAlignment</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getLabelHAlignment()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_LabelHAlignment();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultWidth <em>Default Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Width</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultWidth()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_DefaultWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultHeight <em>Default Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Height</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultHeight()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_DefaultHeight();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition <em>Cardinal Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cardinal Position</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition
	 * @generated
	 */
	EEnum getCardinalPosition();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment <em>Horizontal Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Horizontal Alignment</em>'.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment
	 * @generated
	 */
	EEnum getHorizontalAlignment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ToolkitsFactory getToolkitsFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitImpl <em>Toolkit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitImpl
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getToolkit()
		 * @generated
		 */
		EClass TOOLKIT = eINSTANCE.getToolkit();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOLKIT__WIDGETS = eINSTANCE.getToolkit_Widgets();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOLKIT__NAME = eINSTANCE.getToolkit_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__NAME = eINSTANCE.getWidget_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__ICON = eINSTANCE.getWidget_Icon();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__IMPLEMENTATION = eINSTANCE.getWidget_Implementation();

		/**
		 * The meta object literal for the '<em><b>Toolkit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__TOOLKIT = eINSTANCE.getWidget_Toolkit();

		/**
		 * The meta object literal for the '<em><b>Possible Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__POSSIBLE_EVENTS = eINSTANCE.getWidget_PossibleEvents();

		/**
		 * The meta object literal for the '<em><b>Is Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__IS_CONTAINER = eINSTANCE.getWidget_IsContainer();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__STYLE = eINSTANCE.getWidget_Style();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetEventTypeImpl <em>Widget Event Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetEventTypeImpl
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getWidgetEventType()
		 * @generated
		 */
		EClass WIDGET_EVENT_TYPE = eINSTANCE.getWidgetEventType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_EVENT_TYPE__NAME = eINSTANCE.getWidgetEventType_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Decorator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DECORATOR = eINSTANCE.getStyle_Decorator();

		/**
		 * The meta object literal for the '<em><b>Decorator Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DECORATOR_POSITION = eINSTANCE.getStyle_DecoratorPosition();

		/**
		 * The meta object literal for the '<em><b>Decorator VFill</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DECORATOR_VFILL = eINSTANCE.getStyle_DecoratorVFill();

		/**
		 * The meta object literal for the '<em><b>Decorator HFill</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DECORATOR_HFILL = eINSTANCE.getStyle_DecoratorHFill();

		/**
		 * The meta object literal for the '<em><b>Bordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__BORDERED = eINSTANCE.getStyle_Bordered();

		/**
		 * The meta object literal for the '<em><b>Rounded Corners</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__ROUNDED_CORNERS = eINSTANCE.getStyle_RoundedCorners();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__FONT_COLOR = eINSTANCE.getStyle_FontColor();

		/**
		 * The meta object literal for the '<em><b>Font Underlined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__FONT_UNDERLINED = eINSTANCE.getStyle_FontUnderlined();

		/**
		 * The meta object literal for the '<em><b>Label HAlignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__LABEL_HALIGNMENT = eINSTANCE.getStyle_LabelHAlignment();

		/**
		 * The meta object literal for the '<em><b>Default Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DEFAULT_WIDTH = eINSTANCE.getStyle_DefaultWidth();

		/**
		 * The meta object literal for the '<em><b>Default Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__DEFAULT_HEIGHT = eINSTANCE.getStyle_DefaultHeight();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition <em>Cardinal Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getCardinalPosition()
		 * @generated
		 */
		EEnum CARDINAL_POSITION = eINSTANCE.getCardinalPosition();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment <em>Horizontal Alignment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment
		 * @see org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl#getHorizontalAlignment()
		 * @generated
		 */
		EEnum HORIZONTAL_ALIGNMENT = eINSTANCE.getHorizontalAlignment();

	}

} //ToolkitsPackage
