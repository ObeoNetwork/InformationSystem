/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.view.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.cinematic.impl.CinematicElementImpl;
import org.obeonetwork.dsl.cinematic.impl.NamedElementImpl;

import org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment;

import org.obeonetwork.dsl.cinematic.view.ViewHorizontalAlignment;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.ViewStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewStyleImpl#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewStyleImpl#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewStyleImpl#getLabelHorizontalAlignment <em>Label Horizontal Alignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewStyleImpl extends CinematicElementImpl implements ViewStyle {
	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_SIZE_EDEFAULT = 12;

	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_COLOR_EDEFAULT = "DEFAULT";

	/**
	 * The default value of the '{@link #getLabelHorizontalAlignment() <em>Label Horizontal Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelHorizontalAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final ViewHorizontalAlignment LABEL_HORIZONTAL_ALIGNMENT_EDEFAULT = ViewHorizontalAlignment.DEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFontSize() {
		return (Integer)eDynamicGet(ViewPackage.VIEW_STYLE__FONT_SIZE, ViewPackage.Literals.VIEW_STYLE__FONT_SIZE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontSize(int newFontSize) {
		eDynamicSet(ViewPackage.VIEW_STYLE__FONT_SIZE, ViewPackage.Literals.VIEW_STYLE__FONT_SIZE, newFontSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFontColor() {
		return (String)eDynamicGet(ViewPackage.VIEW_STYLE__FONT_COLOR, ViewPackage.Literals.VIEW_STYLE__FONT_COLOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontColor(String newFontColor) {
		eDynamicSet(ViewPackage.VIEW_STYLE__FONT_COLOR, ViewPackage.Literals.VIEW_STYLE__FONT_COLOR, newFontColor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewHorizontalAlignment getLabelHorizontalAlignment() {
		return (ViewHorizontalAlignment)eDynamicGet(ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT, ViewPackage.Literals.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelHorizontalAlignment(ViewHorizontalAlignment newLabelHorizontalAlignment) {
		eDynamicSet(ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT, ViewPackage.Literals.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT, newLabelHorizontalAlignment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.VIEW_STYLE__FONT_SIZE:
				return getFontSize();
			case ViewPackage.VIEW_STYLE__FONT_COLOR:
				return getFontColor();
			case ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT:
				return getLabelHorizontalAlignment();
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
			case ViewPackage.VIEW_STYLE__FONT_SIZE:
				setFontSize((Integer)newValue);
				return;
			case ViewPackage.VIEW_STYLE__FONT_COLOR:
				setFontColor((String)newValue);
				return;
			case ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT:
				setLabelHorizontalAlignment((ViewHorizontalAlignment)newValue);
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
			case ViewPackage.VIEW_STYLE__FONT_SIZE:
				setFontSize(FONT_SIZE_EDEFAULT);
				return;
			case ViewPackage.VIEW_STYLE__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
				return;
			case ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT:
				setLabelHorizontalAlignment(LABEL_HORIZONTAL_ALIGNMENT_EDEFAULT);
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
			case ViewPackage.VIEW_STYLE__FONT_SIZE:
				return getFontSize() != FONT_SIZE_EDEFAULT;
			case ViewPackage.VIEW_STYLE__FONT_COLOR:
				return FONT_COLOR_EDEFAULT == null ? getFontColor() != null : !FONT_COLOR_EDEFAULT.equals(getFontColor());
			case ViewPackage.VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT:
				return getLabelHorizontalAlignment() != LABEL_HORIZONTAL_ALIGNMENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ViewStyleImpl
