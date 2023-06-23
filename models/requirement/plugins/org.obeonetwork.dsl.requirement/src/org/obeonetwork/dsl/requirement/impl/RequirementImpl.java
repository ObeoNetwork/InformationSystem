/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.RequirementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getAcceptanceCriteria <em>Acceptance Criteria</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl#getModifiedOn <em>Modified On</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementImpl extends NamedElementImpl implements Requirement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_EDEFAULT = 1;
	/**
	 * The default value of the '{@link #getStatement() <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected static final String RATIONALE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getAcceptanceCriteria() <em>Acceptance Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptanceCriteria()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCEPTANCE_CRITERIA_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementType TYPE_EDEFAULT = RequirementType.FUNCTIONAL;
	/**
	 * The default value of the '{@link #getSubtype() <em>Subtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtype()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBTYPE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_ON_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getModifiedOn() <em>Modified On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFIED_ON_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RequirementImpl() {
		super();
		if (getCreatedOn() == null) {
			setCreatedOn(new Date());
		}
		if (getModifiedOn() == null) {
			setModifiedOn(new Date());
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__ID, RequirementPackage.Literals.REQUIREMENT__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(RequirementPackage.REQUIREMENT__ID, RequirementPackage.Literals.REQUIREMENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersion() {
		return (Integer)eDynamicGet(RequirementPackage.REQUIREMENT__VERSION, RequirementPackage.Literals.REQUIREMENT__VERSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(int newVersion) {
		eDynamicSet(RequirementPackage.REQUIREMENT__VERSION, RequirementPackage.Literals.REQUIREMENT__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getReferencedObject() {
		return (EList<EObject>)eDynamicGet(RequirementPackage.REQUIREMENT__REFERENCED_OBJECT, RequirementPackage.Literals.REQUIREMENT__REFERENCED_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatement() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__STATEMENT, RequirementPackage.Literals.REQUIREMENT__STATEMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(String newStatement) {
		eDynamicSet(RequirementPackage.REQUIREMENT__STATEMENT, RequirementPackage.Literals.REQUIREMENT__STATEMENT, newStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRationale() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__RATIONALE, RequirementPackage.Literals.REQUIREMENT__RATIONALE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRationale(String newRationale) {
		eDynamicSet(RequirementPackage.REQUIREMENT__RATIONALE, RequirementPackage.Literals.REQUIREMENT__RATIONALE, newRationale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAcceptanceCriteria() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA, RequirementPackage.Literals.REQUIREMENT__ACCEPTANCE_CRITERIA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcceptanceCriteria(String newAcceptanceCriteria) {
		eDynamicSet(RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA, RequirementPackage.Literals.REQUIREMENT__ACCEPTANCE_CRITERIA, newAcceptanceCriteria);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementType getType() {
		return (RequirementType)eDynamicGet(RequirementPackage.REQUIREMENT__TYPE, RequirementPackage.Literals.REQUIREMENT__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(RequirementType newType) {
		eDynamicSet(RequirementPackage.REQUIREMENT__TYPE, RequirementPackage.Literals.REQUIREMENT__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category getCategory() {
		return (Category)eDynamicGet(RequirementPackage.REQUIREMENT__CATEGORY, RequirementPackage.Literals.REQUIREMENT__CATEGORY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category basicGetCategory() {
		return (Category)eDynamicGet(RequirementPackage.REQUIREMENT__CATEGORY, RequirementPackage.Literals.REQUIREMENT__CATEGORY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCategory(Category newCategory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCategory, RequirementPackage.REQUIREMENT__CATEGORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(Category newCategory) {
		eDynamicSet(RequirementPackage.REQUIREMENT__CATEGORY, RequirementPackage.Literals.REQUIREMENT__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubtype() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__SUBTYPE, RequirementPackage.Literals.REQUIREMENT__SUBTYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubtype(String newSubtype) {
		eDynamicSet(RequirementPackage.REQUIREMENT__SUBTYPE, RequirementPackage.Literals.REQUIREMENT__SUBTYPE, newSubtype);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return (String)eDynamicGet(RequirementPackage.REQUIREMENT__STATUS, RequirementPackage.Literals.REQUIREMENT__STATUS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		eDynamicSet(RequirementPackage.REQUIREMENT__STATUS, RequirementPackage.Literals.REQUIREMENT__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreatedOn() {
		return (Date)eDynamicGet(RequirementPackage.REQUIREMENT__CREATED_ON, RequirementPackage.Literals.REQUIREMENT__CREATED_ON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedOn(Date newCreatedOn) {
		eDynamicSet(RequirementPackage.REQUIREMENT__CREATED_ON, RequirementPackage.Literals.REQUIREMENT__CREATED_ON, newCreatedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModifiedOn() {
		return (Date)eDynamicGet(RequirementPackage.REQUIREMENT__MODIFIED_ON, RequirementPackage.Literals.REQUIREMENT__MODIFIED_ON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedOn(Date newModifiedOn) {
		eDynamicSet(RequirementPackage.REQUIREMENT__MODIFIED_ON, RequirementPackage.Literals.REQUIREMENT__MODIFIED_ON, newModifiedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementPackage.REQUIREMENT__CATEGORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCategory((Category)otherEnd, msgs);
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
			case RequirementPackage.REQUIREMENT__CATEGORY:
				return basicSetCategory(null, msgs);
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
			case RequirementPackage.REQUIREMENT__CATEGORY:
				return eInternalContainer().eInverseRemove(this, RequirementPackage.CATEGORY__REQUIREMENTS, Category.class, msgs);
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
			case RequirementPackage.REQUIREMENT__ID:
				return getId();
			case RequirementPackage.REQUIREMENT__VERSION:
				return getVersion();
			case RequirementPackage.REQUIREMENT__REFERENCED_OBJECT:
				return getReferencedObject();
			case RequirementPackage.REQUIREMENT__STATEMENT:
				return getStatement();
			case RequirementPackage.REQUIREMENT__RATIONALE:
				return getRationale();
			case RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA:
				return getAcceptanceCriteria();
			case RequirementPackage.REQUIREMENT__TYPE:
				return getType();
			case RequirementPackage.REQUIREMENT__CATEGORY:
				if (resolve) return getCategory();
				return basicGetCategory();
			case RequirementPackage.REQUIREMENT__SUBTYPE:
				return getSubtype();
			case RequirementPackage.REQUIREMENT__STATUS:
				return getStatus();
			case RequirementPackage.REQUIREMENT__CREATED_ON:
				return getCreatedOn();
			case RequirementPackage.REQUIREMENT__MODIFIED_ON:
				return getModifiedOn();
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
			case RequirementPackage.REQUIREMENT__ID:
				setId((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__VERSION:
				setVersion((Integer)newValue);
				return;
			case RequirementPackage.REQUIREMENT__REFERENCED_OBJECT:
				getReferencedObject().clear();
				getReferencedObject().addAll((Collection<? extends EObject>)newValue);
				return;
			case RequirementPackage.REQUIREMENT__STATEMENT:
				setStatement((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__RATIONALE:
				setRationale((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA:
				setAcceptanceCriteria((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__TYPE:
				setType((RequirementType)newValue);
				return;
			case RequirementPackage.REQUIREMENT__CATEGORY:
				setCategory((Category)newValue);
				return;
			case RequirementPackage.REQUIREMENT__SUBTYPE:
				setSubtype((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__STATUS:
				setStatus((String)newValue);
				return;
			case RequirementPackage.REQUIREMENT__CREATED_ON:
				setCreatedOn((Date)newValue);
				return;
			case RequirementPackage.REQUIREMENT__MODIFIED_ON:
				setModifiedOn((Date)newValue);
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
			case RequirementPackage.REQUIREMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__REFERENCED_OBJECT:
				getReferencedObject().clear();
				return;
			case RequirementPackage.REQUIREMENT__STATEMENT:
				setStatement(STATEMENT_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__RATIONALE:
				setRationale(RATIONALE_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA:
				setAcceptanceCriteria(ACCEPTANCE_CRITERIA_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__CATEGORY:
				setCategory((Category)null);
				return;
			case RequirementPackage.REQUIREMENT__SUBTYPE:
				setSubtype(SUBTYPE_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__CREATED_ON:
				setCreatedOn(CREATED_ON_EDEFAULT);
				return;
			case RequirementPackage.REQUIREMENT__MODIFIED_ON:
				setModifiedOn(MODIFIED_ON_EDEFAULT);
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
			case RequirementPackage.REQUIREMENT__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case RequirementPackage.REQUIREMENT__VERSION:
				return getVersion() != VERSION_EDEFAULT;
			case RequirementPackage.REQUIREMENT__REFERENCED_OBJECT:
				return !getReferencedObject().isEmpty();
			case RequirementPackage.REQUIREMENT__STATEMENT:
				return STATEMENT_EDEFAULT == null ? getStatement() != null : !STATEMENT_EDEFAULT.equals(getStatement());
			case RequirementPackage.REQUIREMENT__RATIONALE:
				return RATIONALE_EDEFAULT == null ? getRationale() != null : !RATIONALE_EDEFAULT.equals(getRationale());
			case RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA:
				return ACCEPTANCE_CRITERIA_EDEFAULT == null ? getAcceptanceCriteria() != null : !ACCEPTANCE_CRITERIA_EDEFAULT.equals(getAcceptanceCriteria());
			case RequirementPackage.REQUIREMENT__TYPE:
				return getType() != TYPE_EDEFAULT;
			case RequirementPackage.REQUIREMENT__CATEGORY:
				return basicGetCategory() != null;
			case RequirementPackage.REQUIREMENT__SUBTYPE:
				return SUBTYPE_EDEFAULT == null ? getSubtype() != null : !SUBTYPE_EDEFAULT.equals(getSubtype());
			case RequirementPackage.REQUIREMENT__STATUS:
				return STATUS_EDEFAULT == null ? getStatus() != null : !STATUS_EDEFAULT.equals(getStatus());
			case RequirementPackage.REQUIREMENT__CREATED_ON:
				return CREATED_ON_EDEFAULT == null ? getCreatedOn() != null : !CREATED_ON_EDEFAULT.equals(getCreatedOn());
			case RequirementPackage.REQUIREMENT__MODIFIED_ON:
				return MODIFIED_ON_EDEFAULT == null ? getModifiedOn() != null : !MODIFIED_ON_EDEFAULT.equals(getModifiedOn());
		}
		return super.eIsSet(featureID);
	}



} //RequirementImpl
