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
package org.obeonetwork.dsl.environment.bindingdialect.description.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription;
import org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage;

import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationElementMapping;
import org.eclipse.sirius.viewpoint.description.tool.impl.RepresentationCreationDescriptionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DBinding Editor Creation Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorCreationDescriptionImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DBindingEditorCreationDescriptionImpl extends RepresentationCreationDescriptionImpl implements DBindingEditorCreationDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DBindingEditorCreationDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionPackage.Literals.DBINDING_EDITOR_CREATION_DESCRIPTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
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
			case DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION:
				setDescription((DBindingEditorDescription)newValue);
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
			case DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION:
				setDescription((DBindingEditorDescription)null);
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
			case DescriptionPackage.DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION:
				return description != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.description.tool.impl.RepresentationCreationDescriptionImpl#getMappings()
	 * @generated NOT
	 */
	@Override
	public EList<RepresentationElementMapping> getMappings() {
		if (this.eResource() == null) {
			throw new UnsupportedOperationException();
		}
		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(this.eResource().getResourceSet());
		if (crossReferencer == null) {
			throw new UnsupportedOperationException();
		}
		final List<RepresentationElementMapping> mappings = new LinkedList<RepresentationElementMapping>();
		final Collection<Setting> settings = crossReferencer.getInverseReferences(this, true);
		for (final Setting setting : settings) {
			final EObject eReferencer = setting.getEObject();
			final EStructuralFeature eFeature = setting.getEStructuralFeature();
			if (eReferencer instanceof RepresentationElementMapping
					&& eFeature.equals(org.eclipse.sirius.viewpoint.description.DescriptionPackage.eINSTANCE
							.getRepresentationElementMapping_DetailDescriptions())) {
				mappings.add((RepresentationElementMapping)eReferencer);
			}
		}
		return new BasicEList<RepresentationElementMapping>(mappings);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.description.tool.impl.RepresentationCreationDescriptionImpl#basicGetRepresentationDescription()
	 * @generated NOT
	 */
	@Override
	public RepresentationDescription basicGetRepresentationDescription() {
		return getDescription();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.description.tool.impl.RepresentationCreationDescriptionImpl#getRepresentationDescription()
	 * @generated NOT
	 */
	@Override
	public DBindingEditorDescription getRepresentationDescription() {
		return getDescription();
	}

} //DBindingEditorCreationDescriptionImpl
