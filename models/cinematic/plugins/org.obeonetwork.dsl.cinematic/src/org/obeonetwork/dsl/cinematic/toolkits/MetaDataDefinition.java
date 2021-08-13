/**
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits;

import org.obeonetwork.dsl.environment.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Data Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.MetaDataDefinition#getHelp <em>Help</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getMetaDataDefinition()
 * @model
 * @generated
 */
public interface MetaDataDefinition extends Annotation {
	/**
	 * Returns the value of the '<em><b>Help</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help</em>' attribute.
	 * @see #setHelp(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getMetaDataDefinition_Help()
	 * @model
	 * @generated
	 */
	String getHelp();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.MetaDataDefinition#getHelp <em>Help</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help</em>' attribute.
	 * @see #getHelp()
	 * @generated
	 */
	void setHelp(String value);

} // MetaDataDefinition
