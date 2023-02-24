/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.database.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.database.util.DatabaseAdapterFactory;

/**
 * 
 * 
 */
public class DatabaseEEFAdapterFactory extends DatabaseAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createDataBaseAdapter()
	 * 
	 */
	public Adapter createDataBaseAdapter() {
		return new DataBasePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createColumnAdapter()
	 * 
	 */
	public Adapter createColumnAdapter() {
		return new ColumnPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createIndexAdapter()
	 * 
	 */
	public Adapter createIndexAdapter() {
		return new IndexPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createViewAdapter()
	 * 
	 */
	public Adapter createViewAdapter() {
		return new ViewPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createTableAdapter()
	 * 
	 */
	public Adapter createTableAdapter() {
		return new TablePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createPrimaryKeyAdapter()
	 * 
	 */
	public Adapter createPrimaryKeyAdapter() {
		return new PrimaryKeyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createForeignKeyAdapter()
	 * 
	 */
	public Adapter createForeignKeyAdapter() {
		return new ForeignKeyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createForeignKeyElementAdapter()
	 * 
	 */
	public Adapter createForeignKeyElementAdapter() {
		return new ForeignKeyElementPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createIndexElementAdapter()
	 * 
	 */
	public Adapter createIndexElementAdapter() {
		return new IndexElementPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createConstraintAdapter()
	 * 
	 */
	public Adapter createConstraintAdapter() {
		return new ConstraintPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createSchemaAdapter()
	 * 
	 */
	public Adapter createSchemaAdapter() {
		return new SchemaPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.database.util.DatabaseAdapterFactory#createSequenceAdapter()
	 * 
	 */
	public Adapter createSequenceAdapter() {
		return new SequencePropertiesEditionProvider();
	}

}
