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
package org.obeonetwork.dsl.soa;

import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.TypesDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.ImplementationComponent#getImplement <em>Implement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.ImplementationComponent#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getImplementationComponent()
 * @model
 * @generated
 */
public interface ImplementationComponent extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Implement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The implemented interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implement</em>' reference.
	 * @see #setImplement(Interface)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getImplementationComponent_Implement()
	 * @model
	 * @generated
	 */
	Interface getImplement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.ImplementationComponent#getImplement <em>Implement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implement</em>' reference.
	 * @see #getImplement()
	 * @generated
	 */
	void setImplement(Interface value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entities</em>' reference.
	 * @see #setEntities(TypesDefinition)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getImplementationComponent_Entities()
	 * @model
	 * @generated
	 */
	TypesDefinition getEntities();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.ImplementationComponent#getEntities <em>Entities</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entities</em>' reference.
	 * @see #getEntities()
	 * @generated
	 */
	void setEntities(TypesDefinition value);

} // ImplementationComponent