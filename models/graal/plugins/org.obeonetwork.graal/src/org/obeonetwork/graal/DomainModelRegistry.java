/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.ServiceDTO;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Model Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getDtoCategories <em>Dto Categories</em>}</li>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getDtos <em>Dtos</em>}</li>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getEntityBlocks <em>Entity Blocks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface DomainModelRegistry extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Dto Categories</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dto Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dto Categories</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_DtoCategories()
	 * @model
	 * @generated
	 */
	EList<Category> getDtoCategories();

	/**
	 * Returns the value of the '<em><b>Dtos</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.ServiceDTO}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dtos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dtos</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_Dtos()
	 * @model
	 * @generated
	 */
	EList<ServiceDTO> getDtos();

	/**
	 * Returns the value of the '<em><b>Entity Blocks</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Block}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity Blocks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Blocks</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_EntityBlocks()
	 * @model
	 * @generated
	 */
	EList<Block> getEntityBlocks();

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.entity.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_Entities()
	 * @model
	 * @generated
	 */
	EList<Entity> getEntities();

} // DomainModelRegistry
