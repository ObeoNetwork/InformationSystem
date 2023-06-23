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
package org.obeonetwork.dsl.requirement.spec;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.RequirementType;
import org.obeonetwork.dsl.requirement.impl.RequirementImpl;

public class RequirementSpec extends RequirementImpl {

	@Override
	public void setName(String newName) {
		super.setName(newName);
		handleRequirementModification();
	}

	@Override
	public void setId(String newId) {
		String oldId = getId();
		super.setId(newId);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__ID, oldId, newId));
	}

	@Override
	public void setVersion(int newVersion) {
		int oldVersion = getVersion();
		super.setVersion(newVersion);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__VERSION, oldVersion,
					newVersion));

	}

	@Override
	public void setStatement(String newStatement) {
		String oldStatement = getStatement();
		super.setStatement(newStatement);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__STATEMENT, oldStatement,
					newStatement));

	}

	@Override
	public void setRationale(String newRationale) {
		String oldRationale = getRationale();
		super.setRationale(newRationale);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__RATIONALE, oldRationale,
					newRationale));

	}

	@Override
	public void setAcceptanceCriteria(String newAcceptanceCriteria) {
		String oldAcceptanceCriteria = getAcceptanceCriteria();
		super.setAcceptanceCriteria(newAcceptanceCriteria);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__ACCEPTANCE_CRITERIA,
					oldAcceptanceCriteria, newAcceptanceCriteria));

	}

	@Override
	public void setType(RequirementType newType) {
		RequirementType oldType = getType();
		super.setType(newType == null ? RequirementType.FUNCTIONAL : newType);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__TYPE, oldType, newType));

	}

	@Override
	public void setCategory(Category newCategory) {
		if (newCategory != eInternalContainer()
				|| (eContainerFeatureID() != RequirementPackage.REQUIREMENT__CATEGORY && newCategory != null)) {
			if (EcoreUtil.isAncestor(this, newCategory))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCategory != null)
				msgs = ((InternalEObject) newCategory).eInverseAdd(this,
						RequirementPackage.CATEGORY__REQUIREMENTS,
						Category.class, msgs);
			msgs = eBasicSetContainer((InternalEObject) newCategory,
					RequirementPackage.REQUIREMENT__CATEGORY, msgs);
			handleRequirementModification();
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__CATEGORY, newCategory,
					newCategory));

	}

	@Override
	public void setSubtype(String newSubtype) {
		String oldSubtype = getSubtype();
		super.setSubtype(newSubtype);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__SUBTYPE, oldSubtype,
					newSubtype));

	}

	@Override
	public void setStatus(String newStatus) {
		String oldStatus = getStatus();
		super.setStatus(newStatus);
		handleRequirementModification();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__STATUS, oldStatus,
					newStatus));

	}

	@Override
	public Date getCreatedOn() {
		if (super.getCreatedOn() == null) {
			super.setCreatedOn(new Date());
		}
		return super.getCreatedOn();
	}

	private void handleRequirementModification() {
		setModifiedOn(new Date());
	}
}
