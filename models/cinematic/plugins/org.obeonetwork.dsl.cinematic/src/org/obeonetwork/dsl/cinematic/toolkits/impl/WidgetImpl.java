/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.cinematic.toolkits.MetaDataDefinition;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getToolkit <em>Toolkit</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getPossibleEvents <em>Possible Events</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#isIsContainer <em>Is Container</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getMetadataHelp <em>Metadata Help</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl#getMetadataDefinitions <em>Metadata Definitions</em>}</li>
 * </ul>
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
	 * The default value of the '{@link #getMetadataHelp() <em>Metadata Help</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadataHelp()
	 * @generated
	 * @ordered
	 */
	protected static final String METADATA_HELP_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENTATION_EDEFAULT = null;

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
	public Style getStyle() {
		return (Style)eDynamicGet(ToolkitsPackage.WIDGET__STYLE, ToolkitsPackage.Literals.WIDGET__STYLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style basicGetStyle() {
		return (Style)eDynamicGet(ToolkitsPackage.WIDGET__STYLE, ToolkitsPackage.Literals.WIDGET__STYLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStyle(Style newStyle, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newStyle, ToolkitsPackage.WIDGET__STYLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(Style newStyle) {
		eDynamicSet(ToolkitsPackage.WIDGET__STYLE, ToolkitsPackage.Literals.WIDGET__STYLE, newStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetadataHelp() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__METADATA_HELP, ToolkitsPackage.Literals.WIDGET__METADATA_HELP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSummary() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__SUMMARY, ToolkitsPackage.Literals.WIDGET__SUMMARY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummary(String newSummary) {
		eDynamicSet(ToolkitsPackage.WIDGET__SUMMARY, ToolkitsPackage.Literals.WIDGET__SUMMARY, newSummary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentation() {
		return (String)eDynamicGet(ToolkitsPackage.WIDGET__DOCUMENTATION, ToolkitsPackage.Literals.WIDGET__DOCUMENTATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation(String newDocumentation) {
		eDynamicSet(ToolkitsPackage.WIDGET__DOCUMENTATION, ToolkitsPackage.Literals.WIDGET__DOCUMENTATION, newDocumentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MetaDataDefinition> getMetadataDefinitions() {
		return (EList<MetaDataDefinition>)eDynamicGet(ToolkitsPackage.WIDGET__METADATA_DEFINITIONS, ToolkitsPackage.Literals.WIDGET__METADATA_DEFINITIONS, true, true);
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
			case ToolkitsPackage.WIDGET__STYLE:
				return basicSetStyle(null, msgs);
			case ToolkitsPackage.WIDGET__METADATA_DEFINITIONS:
				return ((InternalEList<?>)getMetadataDefinitions()).basicRemove(otherEnd, msgs);
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
			case ToolkitsPackage.WIDGET__STYLE:
				if (resolve) return getStyle();
				return basicGetStyle();
			case ToolkitsPackage.WIDGET__METADATA_HELP:
				return getMetadataHelp();
			case ToolkitsPackage.WIDGET__SUMMARY:
				return getSummary();
			case ToolkitsPackage.WIDGET__DOCUMENTATION:
				return getDocumentation();
			case ToolkitsPackage.WIDGET__METADATA_DEFINITIONS:
				return getMetadataDefinitions();
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
			case ToolkitsPackage.WIDGET__STYLE:
				setStyle((Style)newValue);
				return;
			case ToolkitsPackage.WIDGET__SUMMARY:
				setSummary((String)newValue);
				return;
			case ToolkitsPackage.WIDGET__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case ToolkitsPackage.WIDGET__METADATA_DEFINITIONS:
				getMetadataDefinitions().clear();
				getMetadataDefinitions().addAll((Collection<? extends MetaDataDefinition>)newValue);
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
			case ToolkitsPackage.WIDGET__STYLE:
				setStyle((Style)null);
				return;
			case ToolkitsPackage.WIDGET__SUMMARY:
				setSummary(SUMMARY_EDEFAULT);
				return;
			case ToolkitsPackage.WIDGET__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case ToolkitsPackage.WIDGET__METADATA_DEFINITIONS:
				getMetadataDefinitions().clear();
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
			case ToolkitsPackage.WIDGET__STYLE:
				return basicGetStyle() != null;
			case ToolkitsPackage.WIDGET__METADATA_HELP:
				return METADATA_HELP_EDEFAULT == null ? getMetadataHelp() != null : !METADATA_HELP_EDEFAULT.equals(getMetadataHelp());
			case ToolkitsPackage.WIDGET__SUMMARY:
				return SUMMARY_EDEFAULT == null ? getSummary() != null : !SUMMARY_EDEFAULT.equals(getSummary());
			case ToolkitsPackage.WIDGET__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? getDocumentation() != null : !DOCUMENTATION_EDEFAULT.equals(getDocumentation());
			case ToolkitsPackage.WIDGET__METADATA_DEFINITIONS:
				return !getMetadataDefinitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WidgetImpl
