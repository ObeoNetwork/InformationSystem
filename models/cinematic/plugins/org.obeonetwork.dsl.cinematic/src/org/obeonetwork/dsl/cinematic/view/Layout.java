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
package org.obeonetwork.dsl.cinematic.view;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Layout owned by a ViewContainer defines the layout of all the recursively owned ViewElements of the ViewContainer.
 * It does not define the layout of the ViewElements owned by referenced ViewContainers.
 * The viewElement reference defines the element on which the size and position attributes applies.
 * Therefore, the viewElement of a Layout directly contained in a ViewContainer is this ViewContainer itself.
 * A Layout always defines its x, y, width and height attribute values.
 * If a Layout applies to a ViewConainer, then its owned layouts applies to nothing. In this case, an owned layout only defines a compartment of the horizontal or vertical stack.
 * If a Layout applies to nothing, then its owened layouts applies to an element.
 * If a Layout applies to a ViewElement, the direction is meaningless and it cannot own other layouts.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getX <em>X</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getY <em>Y</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getWidth <em>Width</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getHeight <em>Height</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getViewElement <em>View Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.Layout#getOwnedLayouts <em>Owned Layouts</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Layout extends CDOObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_Height()
	 * @model
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.cinematic.view.LayoutDirection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.view.LayoutDirection
	 * @see #setDirection(LayoutDirection)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_Direction()
	 * @model
	 * @generated
	 */
	LayoutDirection getDirection();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.view.LayoutDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(LayoutDirection value);

	/**
	 * Returns the value of the '<em><b>View Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Element</em>' reference.
	 * @see #setViewElement(AbstractViewElement)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_ViewElement()
	 * @model
	 * @generated
	 */
	AbstractViewElement getViewElement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.Layout#getViewElement <em>View Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Element</em>' reference.
	 * @see #getViewElement()
	 * @generated
	 */
	void setViewElement(AbstractViewElement value);

	/**
	 * Returns the value of the '<em><b>Owned Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.Layout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Layouts</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getLayout_OwnedLayouts()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Layout> getOwnedLayouts();

} // Layout
