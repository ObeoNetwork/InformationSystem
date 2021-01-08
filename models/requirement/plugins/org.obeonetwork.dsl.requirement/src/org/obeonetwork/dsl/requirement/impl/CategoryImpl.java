/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getSubCategories <em>Sub Categories</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getParentCategory <em>Parent Category</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl#getReferencedObject <em>Referenced Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoryImpl extends CategoriesContainerImpl implements Category {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2021 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Category> getOwnedCategories() {
			return new BasicEList<Category>(((Category)this).getSubCategories());
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Requirement> getRequirements() {
		return (EList<Requirement>)eDynamicGet(RequirementPackage.CATEGORY__REQUIREMENTS, RequirementPackage.Literals.CATEGORY__REQUIREMENTS, true, true);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Category> getSubCategories() {
		return (EList<Category>)eDynamicGet(RequirementPackage.CATEGORY__SUB_CATEGORIES, RequirementPackage.Literals.CATEGORY__SUB_CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(RequirementPackage.CATEGORY__ID, RequirementPackage.Literals.CATEGORY__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(RequirementPackage.CATEGORY__ID, RequirementPackage.Literals.CATEGORY__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository() {
		return (Repository)eDynamicGet(RequirementPackage.CATEGORY__REPOSITORY, RequirementPackage.Literals.CATEGORY__REPOSITORY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository basicGetRepository() {
		return (Repository)eDynamicGet(RequirementPackage.CATEGORY__REPOSITORY, RequirementPackage.Literals.CATEGORY__REPOSITORY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository, RequirementPackage.CATEGORY__REPOSITORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository(Repository newRepository) {
		eDynamicSet(RequirementPackage.CATEGORY__REPOSITORY, RequirementPackage.Literals.CATEGORY__REPOSITORY, newRepository);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category getParentCategory() {
		return (Category)eDynamicGet(RequirementPackage.CATEGORY__PARENT_CATEGORY, RequirementPackage.Literals.CATEGORY__PARENT_CATEGORY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category basicGetParentCategory() {
		return (Category)eDynamicGet(RequirementPackage.CATEGORY__PARENT_CATEGORY, RequirementPackage.Literals.CATEGORY__PARENT_CATEGORY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentCategory(Category newParentCategory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentCategory, RequirementPackage.CATEGORY__PARENT_CATEGORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentCategory(Category newParentCategory) {
		eDynamicSet(RequirementPackage.CATEGORY__PARENT_CATEGORY, RequirementPackage.Literals.CATEGORY__PARENT_CATEGORY, newParentCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getReferencedObject() {
		return (EList<EObject>)eDynamicGet(RequirementPackage.CATEGORY__REFERENCED_OBJECT, RequirementPackage.Literals.CATEGORY__REFERENCED_OBJECT, true, true);
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubCategories()).basicAdd(otherEnd, msgs);
			case RequirementPackage.CATEGORY__REPOSITORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository((Repository)otherEnd, msgs);
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentCategory((Category)otherEnd, msgs);
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				return ((InternalEList<?>)getSubCategories()).basicRemove(otherEnd, msgs);
			case RequirementPackage.CATEGORY__REPOSITORY:
				return basicSetRepository(null, msgs);
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				return basicSetParentCategory(null, msgs);
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
			case RequirementPackage.CATEGORY__REPOSITORY:
				return eInternalContainer().eInverseRemove(this, RequirementPackage.REPOSITORY__MAIN_CATEGORIES, Repository.class, msgs);
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				return eInternalContainer().eInverseRemove(this, RequirementPackage.CATEGORY__SUB_CATEGORIES, Category.class, msgs);
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				return getRequirements();
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				return getSubCategories();
			case RequirementPackage.CATEGORY__ID:
				return getId();
			case RequirementPackage.CATEGORY__REPOSITORY:
				if (resolve) return getRepository();
				return basicGetRepository();
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				if (resolve) return getParentCategory();
				return basicGetParentCategory();
			case RequirementPackage.CATEGORY__REFERENCED_OBJECT:
				return getReferencedObject();
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				getSubCategories().clear();
				getSubCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case RequirementPackage.CATEGORY__ID:
				setId((String)newValue);
				return;
			case RequirementPackage.CATEGORY__REPOSITORY:
				setRepository((Repository)newValue);
				return;
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				setParentCategory((Category)newValue);
				return;
			case RequirementPackage.CATEGORY__REFERENCED_OBJECT:
				getReferencedObject().clear();
				getReferencedObject().addAll((Collection<? extends EObject>)newValue);
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				getRequirements().clear();
				return;
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				getSubCategories().clear();
				return;
			case RequirementPackage.CATEGORY__ID:
				setId(ID_EDEFAULT);
				return;
			case RequirementPackage.CATEGORY__REPOSITORY:
				setRepository((Repository)null);
				return;
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				setParentCategory((Category)null);
				return;
			case RequirementPackage.CATEGORY__REFERENCED_OBJECT:
				getReferencedObject().clear();
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
			case RequirementPackage.CATEGORY__REQUIREMENTS:
				return !getRequirements().isEmpty();
			case RequirementPackage.CATEGORY__SUB_CATEGORIES:
				return !getSubCategories().isEmpty();
			case RequirementPackage.CATEGORY__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case RequirementPackage.CATEGORY__REPOSITORY:
				return basicGetRepository() != null;
			case RequirementPackage.CATEGORY__PARENT_CATEGORY:
				return basicGetParentCategory() != null;
			case RequirementPackage.CATEGORY__REFERENCED_OBJECT:
				return !getReferencedObject().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CategoryImpl
