/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getToolkit <em>Toolkit</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getPossibleEvents <em>Possible Events</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#isIsContainer <em>Is Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetImpl extends IdentifiableImpl implements Widget {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isIsContainer() <em>Is Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONTAINER_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolkitsPackage.Literals.WIDGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__NAME, ToolkitsPackage.Literals.WIDGET__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(ToolkitsPackage.WIDGET__NAME, ToolkitsPackage.Literals.WIDGET__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__ICON, ToolkitsPackage.Literals.WIDGET__ICON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		eDynamicSet(ToolkitsPackage.WIDGET__ICON, ToolkitsPackage.Literals.WIDGET__ICON, newIcon);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementation() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__IMPLEMENTATION, ToolkitsPackage.Literals.WIDGET__IMPLEMENTATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(String newImplementation) {
		eDynamicSet(ToolkitsPackage.WIDGET__IMPLEMENTATION, ToolkitsPackage.Literals.WIDGET__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Toolkit getToolkit() {
		return (Toolkit)eDynamicGet(ToolkitsPackage.WIDGET__TOOLKIT, ToolkitsPackage.Literals.WIDGET__TOOLKIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Toolkit basicGetToolkit() {
		return (Toolkit)eDynamicGet(ToolkitsPackage.WIDGET__TOOLKIT, ToolkitsPackage.Literals.WIDGET__TOOLKIT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToolkit(Toolkit newToolkit, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToolkit, ToolkitsPackage.WIDGET__TOOLKIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToolkit(Toolkit newToolkit) {
		eDynamicSet(ToolkitsPackage.WIDGET__TOOLKIT, ToolkitsPackage.Literals.WIDGET__TOOLKIT, newToolkit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<WidgetEventType> getPossibleEvents() {
		return (EList<WidgetEventType>)eDynamicGet(ToolkitsPackage.WIDGET__POSSIBLE_EVENTS, ToolkitsPackage.Literals.WIDGET__POSSIBLE_EVENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsContainer() {
		return (Boolean)eDynamicGet(ToolkitsPackage.WIDGET__IS_CONTAINER, ToolkitsPackage.Literals.WIDGET__IS_CONTAINER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsContainer(boolean newIsContainer) {
		eDynamicSet(ToolkitsPackage.WIDGET__IS_CONTAINER, ToolkitsPackage.Literals.WIDGET__IS_CONTAINER, newIsContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToolkitsPackage.WIDGET__TOOLKIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToolkit((Toolkit)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToolkitsPackage.WIDGET__TOOLKIT:
				return basicSetToolkit(null, msgs);
			case ToolkitsPackage.WIDGET__POSSIBLE_EVENTS:
				return ((InternalEList<?>)getPossibleEvents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ToolkitsPackage.WIDGET__TOOLKIT:
				return eInternalContainer().eInverseRemove(this, ToolkitsPackage.TOOLKIT__WIDGETS, Toolkit.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToolkitsPackage.WIDGET__NAME:
				return getName();
			case ToolkitsPackage.WIDGET__ICON:
				return getIcon();
			case ToolkitsPackage.WIDGET__IMPLEMENTATION:
				return getImplementation();
			case ToolkitsPackage.WIDGET__TOOLKIT:
				if (resolve) return getToolkit();
				return basicGetToolkit();
			case ToolkitsPackage.WIDGET__POSSIBLE_EVENTS:
				return getPossibleEvents();
			case ToolkitsPackage.WIDGET__IS_CONTAINER:
				return isIsContainer();
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
			case ToolkitsPackage.WIDGET__NAME:
				setName((String)newValue);
				return;
			case ToolkitsPackage.WIDGET__ICON:
				setIcon((String)newValue);
				return;
			case ToolkitsPackage.WIDGET__IMPLEMENTATION:
				setImplementation((String)newValue);
				return;
			case ToolkitsPackage.WIDGET__TOOLKIT:
				setToolkit((Toolkit)newValue);
				return;
			case ToolkitsPackage.WIDGET__POSSIBLE_EVENTS:
				getPossibleEvents().clear();
				getPossibleEvents().addAll((Collection<? extends WidgetEventType>)newValue);
				return;
			case ToolkitsPackage.WIDGET__IS_CONTAINER:
				setIsContainer((Boolean)newValue);
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
			case ToolkitsPackage.WIDGET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ToolkitsPackage.WIDGET__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case ToolkitsPackage.WIDGET__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case ToolkitsPackage.WIDGET__TOOLKIT:
				setToolkit((Toolkit)null);
				return;
			case ToolkitsPackage.WIDGET__POSSIBLE_EVENTS:
				getPossibleEvents().clear();
				return;
			case ToolkitsPackage.WIDGET__IS_CONTAINER:
				setIsContainer(IS_CONTAINER_EDEFAULT);
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
			case ToolkitsPackage.WIDGET__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case ToolkitsPackage.WIDGET__ICON:
				return ICON_EDEFAULT == null ? getIcon() != null : !ICON_EDEFAULT.equals(getIcon());
			case ToolkitsPackage.WIDGET__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? getImplementation() != null : !IMPLEMENTATION_EDEFAULT.equals(getImplementation());
			case ToolkitsPackage.WIDGET__TOOLKIT:
				return basicGetToolkit() != null;
			case ToolkitsPackage.WIDGET__POSSIBLE_EVENTS:
				return !getPossibleEvents().isEmpty();
			case ToolkitsPackage.WIDGET__IS_CONTAINER:
				return isIsContainer() != IS_CONTAINER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //WidgetImpl
