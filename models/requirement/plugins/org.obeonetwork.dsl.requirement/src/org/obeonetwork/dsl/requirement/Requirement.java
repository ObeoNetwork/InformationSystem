/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement;

import java.util.Date;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getVersion <em>Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getStatement <em>Statement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getAcceptanceCriteria <em>Acceptance Criteria</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getCategory <em>Category</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getStatus <em>Status</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Requirement#getModifiedOn <em>Modified On</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isRequirementValid'"
 * @generated
 */
public interface Requirement extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Version()
	 * @model default="1"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Referenced Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Object</em>' reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_ReferencedObject()
	 * @model
	 * @generated
	 */
	EList<EObject> getReferencedObject();

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' attribute.
	 * @see #setStatement(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Statement()
	 * @model
	 * @generated
	 */
	String getStatement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getStatement <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' attribute.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(String value);

	/**
	 * Returns the value of the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rationale</em>' attribute.
	 * @see #setRationale(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Rationale()
	 * @model
	 * @generated
	 */
	String getRationale();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getRationale <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rationale</em>' attribute.
	 * @see #getRationale()
	 * @generated
	 */
	void setRationale(String value);

	/**
	 * Returns the value of the '<em><b>Acceptance Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acceptance Criteria</em>' attribute.
	 * @see #setAcceptanceCriteria(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_AcceptanceCriteria()
	 * @model
	 * @generated
	 */
	String getAcceptanceCriteria();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getAcceptanceCriteria <em>Acceptance Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acceptance Criteria</em>' attribute.
	 * @see #getAcceptanceCriteria()
	 * @generated
	 */
	void setAcceptanceCriteria(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.requirement.RequirementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @see #setType(RequirementType)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Type()
	 * @model
	 * @generated
	 */
	RequirementType getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @see #getType()
	 * @generated
	 */
	void setType(RequirementType value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Category#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' container reference.
	 * @see #setCategory(Category)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Category()
	 * @see org.obeonetwork.dsl.requirement.Category#getRequirements
	 * @model opposite="requirements" transient="false"
	 * @generated
	 */
	Category getCategory();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getCategory <em>Category</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' container reference.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(Category value);

	/**
	 * Returns the value of the '<em><b>Subtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtype</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtype</em>' attribute.
	 * @see #setSubtype(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Subtype()
	 * @model
	 * @generated
	 */
	String getSubtype();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getSubtype <em>Subtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subtype</em>' attribute.
	 * @see #getSubtype()
	 * @generated
	 */
	void setSubtype(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_Status()
	 * @model
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created On</em>' attribute.
	 * @see #setCreatedOn(Date)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_CreatedOn()
	 * @model
	 * @generated
	 */
	Date getCreatedOn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getCreatedOn <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created On</em>' attribute.
	 * @see #getCreatedOn()
	 * @generated
	 */
	void setCreatedOn(Date value);

	/**
	 * Returns the value of the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified On</em>' attribute.
	 * @see #setModifiedOn(Date)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRequirement_ModifiedOn()
	 * @model
	 * @generated
	 */
	Date getModifiedOn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Requirement#getModifiedOn <em>Modified On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified On</em>' attribute.
	 * @see #getModifiedOn()
	 * @generated
	 */
	void setModifiedOn(Date value);

} // Requirement
