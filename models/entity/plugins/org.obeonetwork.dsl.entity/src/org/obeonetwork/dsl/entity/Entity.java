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
package org.obeonetwork.dsl.entity;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getEstimatedAccess <em>Estimated Access</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getOwnedFinders <em>Owned Finders</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getInheritanceKind <em>Inheritance Kind</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends StructuredType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Estimated Volumetry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimated Volumetry</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The estimated volumetry
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Estimated Volumetry</em>' attribute.
	 * @see #setEstimatedVolumetry(int)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_EstimatedVolumetry()
	 * @model
	 * @generated
	 */
	int getEstimatedVolumetry();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#getEstimatedVolumetry <em>Estimated Volumetry</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimated Volumetry</em>' attribute.
	 * @see #getEstimatedVolumetry()
	 * @generated
	 */
	void setEstimatedVolumetry(int value);

	/**
	 * Returns the value of the '<em><b>Estimated Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimated Access</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The estimated accesses.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Estimated Access</em>' attribute.
	 * @see #setEstimatedAccess(int)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_EstimatedAccess()
	 * @model
	 * @generated
	 */
	int getEstimatedAccess();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#getEstimatedAccess <em>Estimated Access</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimated Access</em>' attribute.
	 * @see #getEstimatedAccess()
	 * @generated
	 */
	void setEstimatedAccess(int value);

	/**
	 * Returns the value of the '<em><b>Historized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Historized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if historized
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Historized</em>' attribute.
	 * @see #setHistorized(boolean)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_Historized()
	 * @model required="true"
	 * @generated
	 */
	boolean isHistorized();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#isHistorized <em>Historized</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Historized</em>' attribute.
	 * @see #isHistorized()
	 * @generated
	 */
	void setHistorized(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Finders</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.obeonetwork.dsl.entity.Finder}. It is bidirectional and its opposite
	 * is '{@link org.obeonetwork.dsl.entity.Finder#getEntity <em>Entity</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Finders</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owned Finders</em>' containment
	 *         reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_OwnedFinders()
	 * @see org.obeonetwork.dsl.entity.Finder#getEntity
	 * @model type="org.obeonetwork.dsl.entity.Finder" opposite="entity"
	 *        containment="true"
	 * @generated
	 */
	EList<Finder> getOwnedFinders();

	/**
	 * Returns the value of the '<em><b>Inheritance Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.entity.InheritanceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance Kind</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inheritance kind.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inheritance Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.entity.InheritanceKind
	 * @see #setInheritanceKind(InheritanceKind)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_InheritanceKind()
	 * @model
	 * @generated
	 */
	InheritanceKind getInheritanceKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#getInheritanceKind <em>Inheritance Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.entity.InheritanceKind
	 * @see #getInheritanceKind()
	 * @generated
	 */
	void setInheritanceKind(InheritanceKind value);

} // Entity
