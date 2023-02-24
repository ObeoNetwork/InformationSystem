/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits;

import org.eclipse.emf.cdo.CDOObject;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecorator <em>Decorator</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecoratorPosition <em>Decorator Position</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorVFill <em>Decorator VFill</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorHFill <em>Decorator HFill</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isBordered <em>Bordered</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isRoundedCorners <em>Rounded Corners</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isFontUnderlined <em>Font Underlined</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getLabelHAlignment <em>Label HAlignment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultWidth <em>Default Width</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultHeight <em>Default Height</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getExampleExpression <em>Example Expression</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isLabelHidden <em>Label Hidden</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle()
 * @model
 * @generated
 */
public interface Style extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Decorator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator</em>' attribute.
	 * @see #setDecorator(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_Decorator()
	 * @model
	 * @generated
	 */
	String getDecorator();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecorator <em>Decorator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator</em>' attribute.
	 * @see #getDecorator()
	 * @generated
	 */
	void setDecorator(String value);

	/**
	 * Returns the value of the '<em><b>Decorator Position</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator Position</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition
	 * @see #setDecoratorPosition(CardinalPosition)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_DecoratorPosition()
	 * @model
	 * @generated
	 */
	CardinalPosition getDecoratorPosition();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDecoratorPosition <em>Decorator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator Position</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition
	 * @see #getDecoratorPosition()
	 * @generated
	 */
	void setDecoratorPosition(CardinalPosition value);

	/**
	 * Returns the value of the '<em><b>Decorator VFill</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator VFill</em>' attribute.
	 * @see #setDecoratorVFill(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_DecoratorVFill()
	 * @model default="true"
	 * @generated
	 */
	boolean isDecoratorVFill();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorVFill <em>Decorator VFill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator VFill</em>' attribute.
	 * @see #isDecoratorVFill()
	 * @generated
	 */
	void setDecoratorVFill(boolean value);

	/**
	 * Returns the value of the '<em><b>Decorator HFill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorator HFill</em>' attribute.
	 * @see #setDecoratorHFill(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_DecoratorHFill()
	 * @model
	 * @generated
	 */
	boolean isDecoratorHFill();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isDecoratorHFill <em>Decorator HFill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator HFill</em>' attribute.
	 * @see #isDecoratorHFill()
	 * @generated
	 */
	void setDecoratorHFill(boolean value);

	/**
	 * Returns the value of the '<em><b>Bordered</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bordered</em>' attribute.
	 * @see #setBordered(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_Bordered()
	 * @model default="true"
	 * @generated
	 */
	boolean isBordered();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isBordered <em>Bordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bordered</em>' attribute.
	 * @see #isBordered()
	 * @generated
	 */
	void setBordered(boolean value);

	/**
	 * Returns the value of the '<em><b>Rounded Corners</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounded Corners</em>' attribute.
	 * @see #setRoundedCorners(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_RoundedCorners()
	 * @model
	 * @generated
	 */
	boolean isRoundedCorners();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isRoundedCorners <em>Rounded Corners</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounded Corners</em>' attribute.
	 * @see #isRoundedCorners()
	 * @generated
	 */
	void setRoundedCorners(boolean value);

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see #setFontColor(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_FontColor()
	 * @model
	 * @generated
	 */
	String getFontColor();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(String value);

	/**
	 * Returns the value of the '<em><b>Font Underlined</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Underlined</em>' attribute.
	 * @see #setFontUnderlined(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_FontUnderlined()
	 * @model default="false"
	 * @generated
	 */
	boolean isFontUnderlined();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isFontUnderlined <em>Font Underlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Underlined</em>' attribute.
	 * @see #isFontUnderlined()
	 * @generated
	 */
	void setFontUnderlined(boolean value);

	/**
	 * Returns the value of the '<em><b>Label HAlignment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label HAlignment</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment
	 * @see #setLabelHAlignment(HorizontalAlignment)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_LabelHAlignment()
	 * @model
	 * @generated
	 */
	HorizontalAlignment getLabelHAlignment();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getLabelHAlignment <em>Label HAlignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label HAlignment</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment
	 * @see #getLabelHAlignment()
	 * @generated
	 */
	void setLabelHAlignment(HorizontalAlignment value);

	/**
	 * Returns the value of the '<em><b>Default Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Width</em>' attribute.
	 * @see #setDefaultWidth(int)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_DefaultWidth()
	 * @model
	 * @generated
	 */
	int getDefaultWidth();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultWidth <em>Default Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Width</em>' attribute.
	 * @see #getDefaultWidth()
	 * @generated
	 */
	void setDefaultWidth(int value);

	/**
	 * Returns the value of the '<em><b>Default Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Height</em>' attribute.
	 * @see #setDefaultHeight(int)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_DefaultHeight()
	 * @model
	 * @generated
	 */
	int getDefaultHeight();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getDefaultHeight <em>Default Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Height</em>' attribute.
	 * @see #getDefaultHeight()
	 * @generated
	 */
	void setDefaultHeight(int value);

	/**
	 * Returns the value of the '<em><b>Example Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * AQL expression evaluated in the context of the AbstractViewElement that uses this Widget, and which provides the label that should be displayed in the diagram when using the "example" layer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Example Expression</em>' attribute.
	 * @see #setExampleExpression(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_ExampleExpression()
	 * @model
	 * @generated
	 */
	String getExampleExpression();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#getExampleExpression <em>Example Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Example Expression</em>' attribute.
	 * @see #getExampleExpression()
	 * @generated
	 */
	void setExampleExpression(String value);

	/**
	 * Returns the value of the '<em><b>Label Hidden</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Hidden</em>' attribute.
	 * @see #setLabelHidden(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getStyle_LabelHidden()
	 * @model default="false"
	 * @generated
	 */
	boolean isLabelHidden();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Style#isLabelHidden <em>Label Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Hidden</em>' attribute.
	 * @see #isLabelHidden()
	 * @generated
	 */
	void setLabelHidden(boolean value);

} // Style
