/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.bindingdialect.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

import org.eclipse.sirius.viewpoint.impl.DRepresentationElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DBound Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl#getEdgesAsLeft <em>Edges As Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl#getEdgesAsRight <em>Edges As Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DBoundElementImpl extends DRepresentationElementImpl implements DBoundElement {
	private String cachedPath = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected DBoundElement parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<DBoundElement> children;

	/**
	 * The cached value of the '{@link #getEdgesAsLeft() <em>Edges As Left</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsLeft()
	 * @generated
	 * @ordered
	 */
	protected EList<DBindingEdge> edgesAsLeft;

	/**
	 * The cached value of the '{@link #getEdgesAsRight() <em>Edges As Right</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsRight()
	 * @generated
	 * @ordered
	 */
	protected EList<DBindingEdge> edgesAsRight;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DBoundElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingdialectPackage.Literals.DBOUND_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBoundElement getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (DBoundElement)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingdialectPackage.DBOUND_ELEMENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBoundElement basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(DBoundElement newParent, NotificationChain msgs) {
		DBoundElement oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BindingdialectPackage.DBOUND_ELEMENT__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(DBoundElement newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, BindingdialectPackage.DBOUND_ELEMENT__CHILDREN, DBoundElement.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, BindingdialectPackage.DBOUND_ELEMENT__CHILDREN, DBoundElement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingdialectPackage.DBOUND_ELEMENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBoundElement> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<DBoundElement>(DBoundElement.class, this, BindingdialectPackage.DBOUND_ELEMENT__CHILDREN, BindingdialectPackage.DBOUND_ELEMENT__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBindingEdge> getEdgesAsLeft() {
		if (edgesAsLeft == null) {
			edgesAsLeft = new EObjectWithInverseResolvingEList<DBindingEdge>(DBindingEdge.class, this, BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT, BindingdialectPackage.DBINDING_EDGE__LEFT);
		}
		return edgesAsLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBindingEdge> getEdgesAsRight() {
		if (edgesAsRight == null) {
			edgesAsRight = new EObjectWithInverseResolvingEList<DBindingEdge>(DBindingEdge.class, this, BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT, BindingdialectPackage.DBINDING_EDGE__RIGHT);
		}
		return edgesAsRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DBindingEdge> getEdges() {
		List<DBindingEdge> edges = new ArrayList<DBindingEdge>();
		edges.addAll(getEdgesAsLeft());
		edges.addAll(getEdgesAsRight());
		
		return new EcoreEList.UnmodifiableEList<DBindingEdge>(this,
				BindingdialectPackage.Literals.DBOUND_ELEMENT__EDGES,
				edges.size(),
				edges.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPath() {
		if (cachedPath == null) {
			String parentPath = "";
			if (getParent() != null) {
				parentPath = getParent().getPath() + "::";
			}
			cachedPath = parentPath + getFragment(getTarget());
		}
		return cachedPath;
	}
	
	private String getFragment(EObject target) {
		return target.eResource().getURIFragment(target);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, BindingdialectPackage.DBOUND_ELEMENT__CHILDREN, DBoundElement.class, msgs);
				return basicSetParent((DBoundElement)otherEnd, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsLeft()).basicAdd(otherEnd, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsRight()).basicAdd(otherEnd, msgs);
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
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				return ((InternalEList<?>)getEdgesAsLeft()).basicRemove(otherEnd, msgs);
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				return ((InternalEList<?>)getEdgesAsRight()).basicRemove(otherEnd, msgs);
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
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				return getChildren();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				return getEdgesAsLeft();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				return getEdgesAsRight();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES:
				return getEdges();
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
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				setParent((DBoundElement)newValue);
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends DBoundElement>)newValue);
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				getEdgesAsLeft().clear();
				getEdgesAsLeft().addAll((Collection<? extends DBindingEdge>)newValue);
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				getEdgesAsRight().clear();
				getEdgesAsRight().addAll((Collection<? extends DBindingEdge>)newValue);
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
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				setParent((DBoundElement)null);
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				getChildren().clear();
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				getEdgesAsLeft().clear();
				return;
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				getEdgesAsRight().clear();
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
			case BindingdialectPackage.DBOUND_ELEMENT__PARENT:
				return parent != null;
			case BindingdialectPackage.DBOUND_ELEMENT__CHILDREN:
				return children != null && !children.isEmpty();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_LEFT:
				return edgesAsLeft != null && !edgesAsLeft.isEmpty();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES_AS_RIGHT:
				return edgesAsRight != null && !edgesAsRight.isEmpty();
			case BindingdialectPackage.DBOUND_ELEMENT__EDGES:
				return !getEdges().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DBoundElementImpl
