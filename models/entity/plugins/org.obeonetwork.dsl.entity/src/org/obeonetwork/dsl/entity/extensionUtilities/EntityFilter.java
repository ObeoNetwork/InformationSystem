/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.extensionUtilities;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Filter;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Entity Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getAttributeReferences <em>Attribute References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getReferenceReferences <em>Reference References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getOwnedPropertyReferences <em>Owned Property References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#getEntityFilter()
 * @model
 * @generated
 */
public interface EntityFilter extends Filter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Attribute References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute References</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of referenced attributes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute References</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#getEntityFilter_AttributeReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Attribute> getAttributeReferences();

	/**
	 * Returns the value of the '<em><b>Reference References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference References</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of referenced references.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference References</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#getEntityFilter_ReferenceReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Reference> getReferenceReferences();

	/**
	 * Returns the value of the '<em><b>Owned Property References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property References</em>' reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property References</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#getEntityFilter_OwnedPropertyReferences()
	 * @model
	 * @generated
	 */
	EList<Property> getOwnedPropertyReferences();

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(Entity)
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#getEntityFilter_Entity()
	 * @model required="true"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

} // EntityFilter
