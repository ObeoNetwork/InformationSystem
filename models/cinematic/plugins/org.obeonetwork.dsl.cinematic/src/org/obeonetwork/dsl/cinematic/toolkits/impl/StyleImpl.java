/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition;
import org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getDecorator <em>Decorator</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getDecoratorPosition <em>Decorator Position</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isDecoratorVFill <em>Decorator VFill</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isDecoratorHFill <em>Decorator HFill</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isBordered <em>Bordered</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isRoundedCorners <em>Rounded Corners</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isFontUnderlined <em>Font Underlined</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getLabelHAlignment <em>Label HAlignment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getDefaultWidth <em>Default Width</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getDefaultHeight <em>Default Height</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#getExampleExpression <em>Example Expression</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.StyleImpl#isLabelHidden <em>Label Hidden</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StyleImpl extends IdentifiableImpl implements Style {
	/**
	 * The default value of the '{@link #getDecorator() <em>Decorator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecorator()
	 * @generated
	 * @ordered
	 */
	protected static final String DECORATOR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDecoratorPosition() <em>Decorator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoratorPosition()
	 * @generated
	 * @ordered
	 */
	protected static final CardinalPosition DECORATOR_POSITION_EDEFAULT = CardinalPosition.WEST;

	/**
	 * The default value of the '{@link #isDecoratorVFill() <em>Decorator VFill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoratorVFill()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECORATOR_VFILL_EDEFAULT = true;

	/**
	 * The default value of the '{@link #isDecoratorHFill() <em>Decorator HFill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoratorHFill()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECORATOR_HFILL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isBordered() <em>Bordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBordered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BORDERED_EDEFAULT = true;

	/**
	 * The default value of the '{@link #isRoundedCorners() <em>Rounded Corners</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRoundedCorners()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ROUNDED_CORNERS_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_COLOR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isFontUnderlined() <em>Font Underlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFontUnderlined()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FONT_UNDERLINED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getLabelHAlignment() <em>Label HAlignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelHAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final HorizontalAlignment LABEL_HALIGNMENT_EDEFAULT = HorizontalAlignment.CENTER;

	/**
	 * The default value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_WIDTH_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getDefaultHeight() <em>Default Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_HEIGHT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getExampleExpression() <em>Example Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExampleExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXAMPLE_EXPRESSION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isLabelHidden() <em>Label Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLabelHidden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LABEL_HIDDEN_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolkitsPackage.Literals.STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecorator() {
		return (String)eDynamicGet(ToolkitsPackage.STYLE__DECORATOR, ToolkitsPackage.Literals.STYLE__DECORATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecorator(String newDecorator) {
		eDynamicSet(ToolkitsPackage.STYLE__DECORATOR, ToolkitsPackage.Literals.STYLE__DECORATOR, newDecorator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalPosition getDecoratorPosition() {
		return (CardinalPosition)eDynamicGet(ToolkitsPackage.STYLE__DECORATOR_POSITION, ToolkitsPackage.Literals.STYLE__DECORATOR_POSITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoratorPosition(CardinalPosition newDecoratorPosition) {
		eDynamicSet(ToolkitsPackage.STYLE__DECORATOR_POSITION, ToolkitsPackage.Literals.STYLE__DECORATOR_POSITION, newDecoratorPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecoratorVFill() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__DECORATOR_VFILL, ToolkitsPackage.Literals.STYLE__DECORATOR_VFILL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoratorVFill(boolean newDecoratorVFill) {
		eDynamicSet(ToolkitsPackage.STYLE__DECORATOR_VFILL, ToolkitsPackage.Literals.STYLE__DECORATOR_VFILL, newDecoratorVFill);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecoratorHFill() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__DECORATOR_HFILL, ToolkitsPackage.Literals.STYLE__DECORATOR_HFILL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoratorHFill(boolean newDecoratorHFill) {
		eDynamicSet(ToolkitsPackage.STYLE__DECORATOR_HFILL, ToolkitsPackage.Literals.STYLE__DECORATOR_HFILL, newDecoratorHFill);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBordered() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__BORDERED, ToolkitsPackage.Literals.STYLE__BORDERED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBordered(boolean newBordered) {
		eDynamicSet(ToolkitsPackage.STYLE__BORDERED, ToolkitsPackage.Literals.STYLE__BORDERED, newBordered);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRoundedCorners() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__ROUNDED_CORNERS, ToolkitsPackage.Literals.STYLE__ROUNDED_CORNERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundedCorners(boolean newRoundedCorners) {
		eDynamicSet(ToolkitsPackage.STYLE__ROUNDED_CORNERS, ToolkitsPackage.Literals.STYLE__ROUNDED_CORNERS, newRoundedCorners);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFontColor() {
		return (String)eDynamicGet(ToolkitsPackage.STYLE__FONT_COLOR, ToolkitsPackage.Literals.STYLE__FONT_COLOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontColor(String newFontColor) {
		eDynamicSet(ToolkitsPackage.STYLE__FONT_COLOR, ToolkitsPackage.Literals.STYLE__FONT_COLOR, newFontColor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFontUnderlined() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__FONT_UNDERLINED, ToolkitsPackage.Literals.STYLE__FONT_UNDERLINED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontUnderlined(boolean newFontUnderlined) {
		eDynamicSet(ToolkitsPackage.STYLE__FONT_UNDERLINED, ToolkitsPackage.Literals.STYLE__FONT_UNDERLINED, newFontUnderlined);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HorizontalAlignment getLabelHAlignment() {
		return (HorizontalAlignment)eDynamicGet(ToolkitsPackage.STYLE__LABEL_HALIGNMENT, ToolkitsPackage.Literals.STYLE__LABEL_HALIGNMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelHAlignment(HorizontalAlignment newLabelHAlignment) {
		eDynamicSet(ToolkitsPackage.STYLE__LABEL_HALIGNMENT, ToolkitsPackage.Literals.STYLE__LABEL_HALIGNMENT, newLabelHAlignment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultWidth() {
		return (Integer)eDynamicGet(ToolkitsPackage.STYLE__DEFAULT_WIDTH, ToolkitsPackage.Literals.STYLE__DEFAULT_WIDTH, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultWidth(int newDefaultWidth) {
		eDynamicSet(ToolkitsPackage.STYLE__DEFAULT_WIDTH, ToolkitsPackage.Literals.STYLE__DEFAULT_WIDTH, newDefaultWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultHeight() {
		return (Integer)eDynamicGet(ToolkitsPackage.STYLE__DEFAULT_HEIGHT, ToolkitsPackage.Literals.STYLE__DEFAULT_HEIGHT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultHeight(int newDefaultHeight) {
		eDynamicSet(ToolkitsPackage.STYLE__DEFAULT_HEIGHT, ToolkitsPackage.Literals.STYLE__DEFAULT_HEIGHT, newDefaultHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExampleExpression() {
		return (String)eDynamicGet(ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION, ToolkitsPackage.Literals.STYLE__EXAMPLE_EXPRESSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExampleExpression(String newExampleExpression) {
		eDynamicSet(ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION, ToolkitsPackage.Literals.STYLE__EXAMPLE_EXPRESSION, newExampleExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLabelHidden() {
		return (Boolean)eDynamicGet(ToolkitsPackage.STYLE__LABEL_HIDDEN, ToolkitsPackage.Literals.STYLE__LABEL_HIDDEN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelHidden(boolean newLabelHidden) {
		eDynamicSet(ToolkitsPackage.STYLE__LABEL_HIDDEN, ToolkitsPackage.Literals.STYLE__LABEL_HIDDEN, newLabelHidden);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToolkitsPackage.STYLE__DECORATOR:
				return getDecorator();
			case ToolkitsPackage.STYLE__DECORATOR_POSITION:
				return getDecoratorPosition();
			case ToolkitsPackage.STYLE__DECORATOR_VFILL:
				return isDecoratorVFill();
			case ToolkitsPackage.STYLE__DECORATOR_HFILL:
				return isDecoratorHFill();
			case ToolkitsPackage.STYLE__BORDERED:
				return isBordered();
			case ToolkitsPackage.STYLE__ROUNDED_CORNERS:
				return isRoundedCorners();
			case ToolkitsPackage.STYLE__FONT_COLOR:
				return getFontColor();
			case ToolkitsPackage.STYLE__FONT_UNDERLINED:
				return isFontUnderlined();
			case ToolkitsPackage.STYLE__LABEL_HALIGNMENT:
				return getLabelHAlignment();
			case ToolkitsPackage.STYLE__DEFAULT_WIDTH:
				return getDefaultWidth();
			case ToolkitsPackage.STYLE__DEFAULT_HEIGHT:
				return getDefaultHeight();
			case ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION:
				return getExampleExpression();
			case ToolkitsPackage.STYLE__LABEL_HIDDEN:
				return isLabelHidden();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ToolkitsPackage.STYLE__DECORATOR:
				setDecorator((String)newValue);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_POSITION:
				setDecoratorPosition((CardinalPosition)newValue);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_VFILL:
				setDecoratorVFill((Boolean)newValue);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_HFILL:
				setDecoratorHFill((Boolean)newValue);
				return;
			case ToolkitsPackage.STYLE__BORDERED:
				setBordered((Boolean)newValue);
				return;
			case ToolkitsPackage.STYLE__ROUNDED_CORNERS:
				setRoundedCorners((Boolean)newValue);
				return;
			case ToolkitsPackage.STYLE__FONT_COLOR:
				setFontColor((String)newValue);
				return;
			case ToolkitsPackage.STYLE__FONT_UNDERLINED:
				setFontUnderlined((Boolean)newValue);
				return;
			case ToolkitsPackage.STYLE__LABEL_HALIGNMENT:
				setLabelHAlignment((HorizontalAlignment)newValue);
				return;
			case ToolkitsPackage.STYLE__DEFAULT_WIDTH:
				setDefaultWidth((Integer)newValue);
				return;
			case ToolkitsPackage.STYLE__DEFAULT_HEIGHT:
				setDefaultHeight((Integer)newValue);
				return;
			case ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION:
				setExampleExpression((String)newValue);
				return;
			case ToolkitsPackage.STYLE__LABEL_HIDDEN:
				setLabelHidden((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ToolkitsPackage.STYLE__DECORATOR:
				setDecorator(DECORATOR_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_POSITION:
				setDecoratorPosition(DECORATOR_POSITION_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_VFILL:
				setDecoratorVFill(DECORATOR_VFILL_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__DECORATOR_HFILL:
				setDecoratorHFill(DECORATOR_HFILL_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__BORDERED:
				setBordered(BORDERED_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__ROUNDED_CORNERS:
				setRoundedCorners(ROUNDED_CORNERS_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__FONT_UNDERLINED:
				setFontUnderlined(FONT_UNDERLINED_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__LABEL_HALIGNMENT:
				setLabelHAlignment(LABEL_HALIGNMENT_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__DEFAULT_WIDTH:
				setDefaultWidth(DEFAULT_WIDTH_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__DEFAULT_HEIGHT:
				setDefaultHeight(DEFAULT_HEIGHT_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION:
				setExampleExpression(EXAMPLE_EXPRESSION_EDEFAULT);
				return;
			case ToolkitsPackage.STYLE__LABEL_HIDDEN:
				setLabelHidden(LABEL_HIDDEN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ToolkitsPackage.STYLE__DECORATOR:
				return DECORATOR_EDEFAULT == null ? getDecorator() != null : !DECORATOR_EDEFAULT.equals(getDecorator());
			case ToolkitsPackage.STYLE__DECORATOR_POSITION:
				return getDecoratorPosition() != DECORATOR_POSITION_EDEFAULT;
			case ToolkitsPackage.STYLE__DECORATOR_VFILL:
				return isDecoratorVFill() != DECORATOR_VFILL_EDEFAULT;
			case ToolkitsPackage.STYLE__DECORATOR_HFILL:
				return isDecoratorHFill() != DECORATOR_HFILL_EDEFAULT;
			case ToolkitsPackage.STYLE__BORDERED:
				return isBordered() != BORDERED_EDEFAULT;
			case ToolkitsPackage.STYLE__ROUNDED_CORNERS:
				return isRoundedCorners() != ROUNDED_CORNERS_EDEFAULT;
			case ToolkitsPackage.STYLE__FONT_COLOR:
				return FONT_COLOR_EDEFAULT == null ? getFontColor() != null : !FONT_COLOR_EDEFAULT.equals(getFontColor());
			case ToolkitsPackage.STYLE__FONT_UNDERLINED:
				return isFontUnderlined() != FONT_UNDERLINED_EDEFAULT;
			case ToolkitsPackage.STYLE__LABEL_HALIGNMENT:
				return getLabelHAlignment() != LABEL_HALIGNMENT_EDEFAULT;
			case ToolkitsPackage.STYLE__DEFAULT_WIDTH:
				return getDefaultWidth() != DEFAULT_WIDTH_EDEFAULT;
			case ToolkitsPackage.STYLE__DEFAULT_HEIGHT:
				return getDefaultHeight() != DEFAULT_HEIGHT_EDEFAULT;
			case ToolkitsPackage.STYLE__EXAMPLE_EXPRESSION:
				return EXAMPLE_EXPRESSION_EDEFAULT == null ? getExampleExpression() != null : !EXAMPLE_EXPRESSION_EDEFAULT.equals(getExampleExpression());
			case ToolkitsPackage.STYLE__LABEL_HIDDEN:
				return isLabelHidden() != LABEL_HIDDEN_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //StyleImpl
