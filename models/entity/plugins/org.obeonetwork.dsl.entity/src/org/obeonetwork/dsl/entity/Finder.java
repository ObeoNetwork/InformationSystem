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
package org.obeonetwork.dsl.entity;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Finder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.Finder#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Finder#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Finder#getCustomizedName <em>Customized Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Finder#getCriterions <em>Criterions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Finder#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder()
 * @model
 * @generated
 */
public interface Finder extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder_Name()
	 * @model required="true" transient="true" changeable="false"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entity.Entity#getOwnedFinders <em>Owned Finders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entity</em>' container reference.
	 * @see #setEntity(Entity)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder_Entity()
	 * @see org.obeonetwork.dsl.entity.Entity#getOwnedFinders
	 * @model opposite="ownedFinders" required="true" transient="false"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Finder#getEntity <em>Entity</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' container reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Customized Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customized Name</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The customized name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Customized Name</em>' attribute.
	 * @see #setCustomizedName(String)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder_CustomizedName()
	 * @model
	 * @generated
	 */
	String getCustomizedName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Finder#getCustomizedName <em>Customized Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customized Name</em>' attribute.
	 * @see #getCustomizedName()
	 * @generated
	 */
	void setCustomizedName(String value);

	/**
	 * Returns the value of the '<em><b>Criterions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Criterion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterions</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of criterions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Criterions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder_Criterions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Criterion> getCriterions();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.environment.MultiplicityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #setMultiplicity(MultiplicityKind)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getFinder_Multiplicity()
	 * @model required="true"
	 * @generated
	 */
	MultiplicityKind getMultiplicity();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Finder#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityKind value);

} // Finder
