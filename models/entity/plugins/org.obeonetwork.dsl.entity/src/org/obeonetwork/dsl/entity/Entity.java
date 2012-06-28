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
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getEstimatedAccess <em>Estimated Access</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getOwnedFinders <em>Owned Finders</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getBlock <em>Block</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.Entity#getInheritanceKind <em>Inheritance Kind</em>}</li>
 * </ul>
 * </p>
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
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entity.Attribute#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attributes</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attributes</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_OwnedAttributes()
	 * @see org.obeonetwork.dsl.entity.Attribute#getEntity
	 * @model opposite="entity" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Attribute> getOwnedAttributes();

	/**
	 * Returns the value of the '<em><b>Owned References</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Reference}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entity.Reference#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned References</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned References</em>' containment reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_OwnedReferences()
	 * @see org.obeonetwork.dsl.entity.Reference#getEntity
	 * @model opposite="entity" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Reference> getOwnedReferences();

	/**
	 * Returns the value of the '<em><b>Supertype</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Supertype</em>' reference.
	 * @see #setSupertype(Entity)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_Supertype()
	 * @model
	 * @generated
	 */
	Entity getSupertype();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#getSupertype <em>Supertype</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supertype</em>' reference.
	 * @see #getSupertype()
	 * @generated
	 */
	void setSupertype(Entity value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_Attributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_References()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_Properties()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Estimated Volumetry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimated Volumetry</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.entity.Block#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' container reference.
	 * @see #setBlock(Block)
	 * @see org.obeonetwork.dsl.entity.EntityPackage#getEntity_Block()
	 * @see org.obeonetwork.dsl.entity.Block#getEntities
	 * @model opposite="entities" required="true" transient="false"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.entity.Entity#getBlock <em>Block</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' container reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Inheritance Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.entity.InheritanceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance Kind</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isSubtypeOf(Entity entity);

} // Entity
