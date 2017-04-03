/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.cinematic.impl.NamedElementImpl;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.BoundableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract View Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl#getWidget <em>Widget</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractViewElementImpl extends NamedElementImpl implements AbstractViewElement {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractViewElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget getWidget() {
		return (Widget)eDynamicGet(ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__WIDGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget basicGetWidget() {
		return (Widget)eDynamicGet(ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__WIDGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidget(Widget newWidget) {
		eDynamicSet(ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__WIDGET, newWidget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewAction> getActions() {
		return (EList<ViewAction>)eDynamicGet(ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__ACTIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewEvent> getEvents() {
		return (EList<ViewEvent>)eDynamicGet(ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__EVENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return (String)eDynamicGet(ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__LABEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		eDynamicSet(ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL, ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__LABEL, newLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPathValid(BoundableElement root, String path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET:
				if (resolve) return getWidget();
				return basicGetWidget();
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
				return getActions();
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
				return getEvents();
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL:
				return getLabel();
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
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET:
				setWidget((Widget)newValue);
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ViewAction>)newValue);
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends ViewEvent>)newValue);
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL:
				setLabel((String)newValue);
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
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET:
				setWidget((Widget)null);
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
				getActions().clear();
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
				getEvents().clear();
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__WIDGET:
				return basicGetWidget() != null;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
				return !getActions().isEmpty();
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
				return !getEvents().isEmpty();
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
		}
		return super.eIsSet(featureID);
	}

} //AbstractViewElementImpl
