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
package org.obeonetwork.dsl.cinematic.view;

import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.NamedElement;

import org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getLabelHorizontalAlignment <em>Label Horizontal Alignment</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewStyle()
 * @model
 * @generated
 */
public interface ViewStyle extends CinematicElement {
	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute.
	 * The default value is <code>"12"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(int)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewStyle_FontSize()
	 * @model default="12"
	 * @generated
	 */
	int getFontSize();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(int value);

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * The default value is <code>"DEFAULT"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see #setFontColor(String)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewStyle_FontColor()
	 * @model default="DEFAULT"
	 * @generated
	 */
	String getFontColor();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(String value);

	/**
	 * Returns the value of the '<em><b>Label Horizontal Alignment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.cinematic.view.ViewHorizontalAlignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Horizontal Alignment</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewHorizontalAlignment
	 * @see #setLabelHorizontalAlignment(ViewHorizontalAlignment)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewStyle_LabelHorizontalAlignment()
	 * @model
	 * @generated
	 */
	ViewHorizontalAlignment getLabelHorizontalAlignment();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewStyle#getLabelHorizontalAlignment <em>Label Horizontal Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Horizontal Alignment</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewHorizontalAlignment
	 * @see #getLabelHorizontalAlignment()
	 * @generated
	 */
	void setLabelHorizontalAlignment(ViewHorizontalAlignment value);

} // ViewStyle
