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

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Data Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions#getMetaDataDefinitions <em>Meta Data Definitions</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinitions()
 * @model
 * @generated
 */
public interface MetaDataDefinitions extends Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Meta Data Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data Definitions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#getMetaDataDefinitions_MetaDataDefinitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MetaDataDefinition> getMetaDataDefinitions();

} // MetaDataDefinitions
