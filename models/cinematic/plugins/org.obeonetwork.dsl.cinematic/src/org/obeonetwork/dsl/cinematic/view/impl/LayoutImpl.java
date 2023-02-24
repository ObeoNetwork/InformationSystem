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
package org.obeonetwork.dsl.cinematic.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.LayoutDirection;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getX <em>X</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getViewElement <em>View Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.LayoutImpl#getOwnedLayouts <em>Owned Layouts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LayoutImpl extends CDOObjectImpl implements Layout {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final LayoutDirection DIRECTION_EDEFAULT = LayoutDirection.VERTICAL;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.LAYOUT;
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
	public int getX() {
		return (Integer)eDynamicGet(ViewPackage.LAYOUT__X, ViewPackage.Literals.LAYOUT__X, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX) {
		eDynamicSet(ViewPackage.LAYOUT__X, ViewPackage.Literals.LAYOUT__X, newX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getY() {
		return (Integer)eDynamicGet(ViewPackage.LAYOUT__Y, ViewPackage.Literals.LAYOUT__Y, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY) {
		eDynamicSet(ViewPackage.LAYOUT__Y, ViewPackage.Literals.LAYOUT__Y, newY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return (Integer)eDynamicGet(ViewPackage.LAYOUT__WIDTH, ViewPackage.Literals.LAYOUT__WIDTH, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		eDynamicSet(ViewPackage.LAYOUT__WIDTH, ViewPackage.Literals.LAYOUT__WIDTH, newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return (Integer)eDynamicGet(ViewPackage.LAYOUT__HEIGHT, ViewPackage.Literals.LAYOUT__HEIGHT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		eDynamicSet(ViewPackage.LAYOUT__HEIGHT, ViewPackage.Literals.LAYOUT__HEIGHT, newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutDirection getDirection() {
		return (LayoutDirection)eDynamicGet(ViewPackage.LAYOUT__DIRECTION, ViewPackage.Literals.LAYOUT__DIRECTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(LayoutDirection newDirection) {
		eDynamicSet(ViewPackage.LAYOUT__DIRECTION, ViewPackage.Literals.LAYOUT__DIRECTION, newDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractViewElement getViewElement() {
		return (AbstractViewElement)eDynamicGet(ViewPackage.LAYOUT__VIEW_ELEMENT, ViewPackage.Literals.LAYOUT__VIEW_ELEMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractViewElement basicGetViewElement() {
		return (AbstractViewElement)eDynamicGet(ViewPackage.LAYOUT__VIEW_ELEMENT, ViewPackage.Literals.LAYOUT__VIEW_ELEMENT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewElement(AbstractViewElement newViewElement) {
		eDynamicSet(ViewPackage.LAYOUT__VIEW_ELEMENT, ViewPackage.Literals.LAYOUT__VIEW_ELEMENT, newViewElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Layout> getOwnedLayouts() {
		return (EList<Layout>)eDynamicGet(ViewPackage.LAYOUT__OWNED_LAYOUTS, ViewPackage.Literals.LAYOUT__OWNED_LAYOUTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewPackage.LAYOUT__OWNED_LAYOUTS:
				return ((InternalEList<?>)getOwnedLayouts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.LAYOUT__X:
				return getX();
			case ViewPackage.LAYOUT__Y:
				return getY();
			case ViewPackage.LAYOUT__WIDTH:
				return getWidth();
			case ViewPackage.LAYOUT__HEIGHT:
				return getHeight();
			case ViewPackage.LAYOUT__DIRECTION:
				return getDirection();
			case ViewPackage.LAYOUT__VIEW_ELEMENT:
				if (resolve) return getViewElement();
				return basicGetViewElement();
			case ViewPackage.LAYOUT__OWNED_LAYOUTS:
				return getOwnedLayouts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ViewPackage.LAYOUT__X:
				setX((Integer)newValue);
				return;
			case ViewPackage.LAYOUT__Y:
				setY((Integer)newValue);
				return;
			case ViewPackage.LAYOUT__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ViewPackage.LAYOUT__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ViewPackage.LAYOUT__DIRECTION:
				setDirection((LayoutDirection)newValue);
				return;
			case ViewPackage.LAYOUT__VIEW_ELEMENT:
				setViewElement((AbstractViewElement)newValue);
				return;
			case ViewPackage.LAYOUT__OWNED_LAYOUTS:
				getOwnedLayouts().clear();
				getOwnedLayouts().addAll((Collection<? extends Layout>)newValue);
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
			case ViewPackage.LAYOUT__X:
				setX(X_EDEFAULT);
				return;
			case ViewPackage.LAYOUT__Y:
				setY(Y_EDEFAULT);
				return;
			case ViewPackage.LAYOUT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ViewPackage.LAYOUT__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ViewPackage.LAYOUT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case ViewPackage.LAYOUT__VIEW_ELEMENT:
				setViewElement((AbstractViewElement)null);
				return;
			case ViewPackage.LAYOUT__OWNED_LAYOUTS:
				getOwnedLayouts().clear();
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
			case ViewPackage.LAYOUT__X:
				return getX() != X_EDEFAULT;
			case ViewPackage.LAYOUT__Y:
				return getY() != Y_EDEFAULT;
			case ViewPackage.LAYOUT__WIDTH:
				return getWidth() != WIDTH_EDEFAULT;
			case ViewPackage.LAYOUT__HEIGHT:
				return getHeight() != HEIGHT_EDEFAULT;
			case ViewPackage.LAYOUT__DIRECTION:
				return getDirection() != DIRECTION_EDEFAULT;
			case ViewPackage.LAYOUT__VIEW_ELEMENT:
				return basicGetViewElement() != null;
			case ViewPackage.LAYOUT__OWNED_LAYOUTS:
				return !getOwnedLayouts().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayoutImpl
