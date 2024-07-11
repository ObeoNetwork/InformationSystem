/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.metadatadef;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Data Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getTitle <em>Title</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getBody <em>Body</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinition()
 * @model
 * @generated
 */
public interface MetaDataDefinition extends Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinition_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinition_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinition_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // MetaDataDefinition
