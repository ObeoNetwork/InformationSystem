/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.application;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.ecorebinding.BModel;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.application.Configuration#getBindingRegistries <em>Binding Registries</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.Configuration#getEcoreModel <em>Ecore Model</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.Configuration#getCinematicModel <em>Cinematic Model</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.Configuration#getEcoreBindingModel <em>Ecore Binding Model</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.application.ApplicationPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Binding Registries</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingRegistry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Registries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Registries</em>' containment reference list.
	 * @see org.obeonetwork.dsl.application.ApplicationPackage#getConfiguration_BindingRegistries()
	 * @model containment="true"
	 * @generated
	 */
	EList<BindingRegistry> getBindingRegistries();

	/**
	 * Returns the value of the '<em><b>Ecore Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Model</em>' reference.
	 * @see #setEcoreModel(EPackage)
	 * @see org.obeonetwork.dsl.application.ApplicationPackage#getConfiguration_EcoreModel()
	 * @model
	 * @generated
	 */
	EPackage getEcoreModel();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.application.Configuration#getEcoreModel <em>Ecore Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Model</em>' reference.
	 * @see #getEcoreModel()
	 * @generated
	 */
	void setEcoreModel(EPackage value);

	/**
	 * Returns the value of the '<em><b>Cinematic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cinematic Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cinematic Model</em>' reference.
	 * @see #setCinematicModel(CinematicRoot)
	 * @see org.obeonetwork.dsl.application.ApplicationPackage#getConfiguration_CinematicModel()
	 * @model
	 * @generated
	 */
	CinematicRoot getCinematicModel();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.application.Configuration#getCinematicModel <em>Cinematic Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cinematic Model</em>' reference.
	 * @see #getCinematicModel()
	 * @generated
	 */
	void setCinematicModel(CinematicRoot value);

	/**
	 * Returns the value of the '<em><b>Ecore Binding Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Binding Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Binding Model</em>' reference.
	 * @see #setEcoreBindingModel(BModel)
	 * @see org.obeonetwork.dsl.application.ApplicationPackage#getConfiguration_EcoreBindingModel()
	 * @model
	 * @generated
	 */
	BModel getEcoreBindingModel();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.application.Configuration#getEcoreBindingModel <em>Ecore Binding Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Binding Model</em>' reference.
	 * @see #getEcoreBindingModel()
	 * @generated
	 */
	void setEcoreBindingModel(BModel value);

} // Configuration
