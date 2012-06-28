/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.bindingdialect.impl;

import fr.obeo.dsl.viewpoint.DRepresentationElement;
import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

import fr.obeo.dsl.viewpoint.description.DescriptionPackage;
import fr.obeo.dsl.viewpoint.impl.DRepresentationImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;

import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DBinding Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl#getBoundElements <em>Bound Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl#getBindingEdges <em>Binding Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBindingEditorImpl extends DRepresentationImpl implements DBindingEditor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected DBindingEditorDescription description;

	/**
	 * The cached value of the '{@link #getBoundElements() <em>Bound Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DBoundElement> boundElements;

	/**
	 * The cached value of the '{@link #getBindingEdges() <em>Binding Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<DBindingEdge> bindingEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DBindingEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingdialectPackage.Literals.DBINDING_EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingdialectPackage.DBINDING_EDITOR__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingdialectPackage.DBINDING_EDITOR__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBindingEditorDescription getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (DBindingEditorDescription)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBindingEditorDescription basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(DBindingEditorDescription newDescription) {
		DBindingEditorDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBoundElement> getBoundElements() {
		if (boundElements == null) {
			boundElements = new EObjectContainmentEList<DBoundElement>(DBoundElement.class, this, BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS);
		}
		return boundElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBindingEdge> getBindingEdges() {
		if (bindingEdges == null) {
			bindingEdges = new EObjectContainmentEList<DBindingEdge>(DBindingEdge.class, this, BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES);
		}
		return bindingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS:
				return ((InternalEList<?>)getBoundElements()).basicRemove(otherEnd, msgs);
			case BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES:
				return ((InternalEList<?>)getBindingEdges()).basicRemove(otherEnd, msgs);
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
			case BindingdialectPackage.DBINDING_EDITOR__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS:
				return getBoundElements();
			case BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES:
				return getBindingEdges();
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
			case BindingdialectPackage.DBINDING_EDITOR__TARGET:
				setTarget((EObject)newValue);
				return;
			case BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION:
				setDescription((DBindingEditorDescription)newValue);
				return;
			case BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS:
				getBoundElements().clear();
				getBoundElements().addAll((Collection<? extends DBoundElement>)newValue);
				return;
			case BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES:
				getBindingEdges().clear();
				getBindingEdges().addAll((Collection<? extends DBindingEdge>)newValue);
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
			case BindingdialectPackage.DBINDING_EDITOR__TARGET:
				setTarget((EObject)null);
				return;
			case BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION:
				setDescription((DBindingEditorDescription)null);
				return;
			case BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS:
				getBoundElements().clear();
				return;
			case BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES:
				getBindingEdges().clear();
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
			case BindingdialectPackage.DBINDING_EDITOR__TARGET:
				return target != null;
			case BindingdialectPackage.DBINDING_EDITOR__DESCRIPTION:
				return description != null;
			case BindingdialectPackage.DBINDING_EDITOR__BOUND_ELEMENTS:
				return boundElements != null && !boundElements.isEmpty();
			case BindingdialectPackage.DBINDING_EDITOR__BINDING_EDGES:
				return bindingEdges != null && !bindingEdges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DSemanticDecorator.class) {
			switch (derivedFeatureID) {
				case BindingdialectPackage.DBINDING_EDITOR__TARGET: return ViewpointPackage.DSEMANTIC_DECORATOR__TARGET;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DSemanticDecorator.class) {
			switch (baseFeatureID) {
				case ViewpointPackage.DSEMANTIC_DECORATOR__TARGET: return BindingdialectPackage.DBINDING_EDITOR__TARGET;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.impl.DRepresentationImpl#getOwnedRepresentationElements()
	 */
	@Override
	public EList<DRepresentationElement> getOwnedRepresentationElements() {
		List<DRepresentationElement> representationElements = new ArrayList<DRepresentationElement>();
		representationElements.addAll(getBindingEdges());
		representationElements.addAll(getBoundElements());
		return new EcoreEList.UnmodifiableEList<DRepresentationElement>(this,
				ViewpointPackage.Literals.DREPRESENTATION__OWNED_REPRESENTATION_ELEMENTS,
				representationElements.size(),
				representationElements.toArray());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.impl.DRepresentationImpl#getRepresentationElements()
	 */
	@Override
	public EList<DRepresentationElement> getRepresentationElements() {
		return new EcoreEList.UnmodifiableEList<DRepresentationElement>(this,
				ViewpointPackage.Literals.DREPRESENTATION__REPRESENTATION_ELEMENTS,
				getOwnedRepresentationElements().size(),
				getOwnedRepresentationElements().toArray());
	}
	
	

} //DBindingEditorImpl
