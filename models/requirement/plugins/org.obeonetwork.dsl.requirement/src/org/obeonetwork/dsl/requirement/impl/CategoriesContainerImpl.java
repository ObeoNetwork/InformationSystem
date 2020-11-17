/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Categories Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl#getOwnedCategories <em>Owned Categories</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl#getOwnedRequirements <em>Owned Requirements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CategoriesContainerImpl extends NamedElementImpl implements CategoriesContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoriesContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.CATEGORIES_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Category> getOwnedCategories() {
		return (EList<Category>)eDynamicGet(RequirementPackage.CATEGORIES_CONTAINER__OWNED_CATEGORIES, RequirementPackage.Literals.CATEGORIES_CONTAINER__OWNED_CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public EList<Requirement> getOwnedRequirements() {
		if(this instanceof Category){
			return new BasicEList<Requirement>(((Category)this).getRequirements());
		}
		return (EList<Requirement>)eDynamicGet(RequirementPackage.CATEGORIES_CONTAINER__OWNED_REQUIREMENTS, RequirementPackage.Literals.CATEGORIES_CONTAINER__OWNED_REQUIREMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequirementPackage.CATEGORIES_CONTAINER__OWNED_CATEGORIES:
				return getOwnedCategories();
			case RequirementPackage.CATEGORIES_CONTAINER__OWNED_REQUIREMENTS:
				return getOwnedRequirements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RequirementPackage.CATEGORIES_CONTAINER__OWNED_CATEGORIES:
				return !getOwnedCategories().isEmpty();
			case RequirementPackage.CATEGORIES_CONTAINER__OWNED_REQUIREMENTS:
				return !getOwnedRequirements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CategoriesContainerImpl
