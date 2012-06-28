/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.entity;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.Block#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Block#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Block#getSubblocks <em>Subblocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.entity.EntityPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getBlock_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Block#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.obeonetwork.dsl.entity.Entity}. It is bidirectional and its opposite
	 * is '{@link org.obeonetwork.dsl.entity.Entity#getBlock <em>Block</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entities</em>' containment reference
	 *         list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getBlock_Entities()
	 * @see org.obeonetwork.dsl.entity.Entity#getBlock
	 * @model type="org.obeonetwork.dsl.entity.Entity" opposite="block"
	 *        containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

	/**
	 * Returns the value of the '<em><b>Subblocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Block}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subblocks</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subblocks</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getBlock_Subblocks()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Block> getSubblocks();

} // Block
