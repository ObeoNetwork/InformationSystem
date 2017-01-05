/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory;

/**
 * 
 * 
 */
public class EntityrelationEEFAdapterFactory extends EntityRelationAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createLogicalModelAdapter()
	 * 
	 */
	public Adapter createLogicalModelAdapter() {
		return new LogicalModelPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createEntityAdapter()
	 * 
	 */
	public Adapter createEntityAdapter() {
		return new EntityPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createRelationAdapter()
	 * 
	 */
	public Adapter createRelationAdapter() {
		return new RelationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createRelationElementAdapter()
	 * 
	 */
	public Adapter createRelationElementAdapter() {
		return new RelationElementPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createAttributeAdapter()
	 * 
	 */
	public Adapter createAttributeAdapter() {
		return new AttributePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entityrelation.util.EntityRelationAdapterFactory#createIdentifierAdapter()
	 * 
	 */
	public Adapter createIdentifierAdapter() {
		return new IdentifierPropertiesEditionProvider();
	}

}
