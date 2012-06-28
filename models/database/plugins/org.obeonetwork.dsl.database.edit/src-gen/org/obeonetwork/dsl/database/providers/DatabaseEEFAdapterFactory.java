/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.database.providers.ColumnPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.ConstraintPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.DataBasePropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.ForeignKeyElementPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.ForeignKeyPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.IndexElementPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.IndexPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.PrimaryKeyPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.SchemaPropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.SequencePropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.TablePropertiesEditionProvider;
import org.obeonetwork.dsl.database.providers.ViewPropertiesEditionProvider;

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
