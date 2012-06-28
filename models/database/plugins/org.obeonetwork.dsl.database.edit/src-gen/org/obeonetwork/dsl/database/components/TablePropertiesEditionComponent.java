/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.PrimaryKeyPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class TablePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Table part
	 * 
	 */
	private TablePropertiesEditionPart tablePart;

	/**
	 * The TableTablePropertiesEditionComponent sub component
	 * 
	 */
	protected TableTablePropertiesEditionComponent tableTablePropertiesEditionComponent;

	/**
	 * The Primary Key part
	 * 
	 */
	private PrimaryKeyPropertiesEditionPart primaryKeyPart;

	/**
	 * The TablePrimaryKeyPropertiesEditionComponent sub component
	 * 
	 */
	protected TablePrimaryKeyPropertiesEditionComponent tablePrimaryKeyPropertiesEditionComponent;

	/**
	 * The Foreign Keys part
	 * 
	 */
	private ForeignKeysPropertiesEditionPart foreignKeysPart;

	/**
	 * The TableForeignKeysPropertiesEditionComponent sub component
	 * 
	 */
	protected TableForeignKeysPropertiesEditionComponent tableForeignKeysPropertiesEditionComponent;

	/**
	 * The Constraints part
	 * 
	 */
	private ConstraintsPropertiesEditionPart constraintsPart;

	/**
	 * The TableConstraintsPropertiesEditionComponent sub component
	 * 
	 */
	protected TableConstraintsPropertiesEditionComponent tableConstraintsPropertiesEditionComponent;

	/**
	 * The Indexes part
	 * 
	 */
	private IndexesPropertiesEditionPart indexesPart;

	/**
	 * The TableIndexesPropertiesEditionComponent sub component
	 * 
	 */
	protected TableIndexesPropertiesEditionComponent tableIndexesPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param table the EObject to edit
	 * 
	 */
	public TablePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject table, String editing_mode) {
		super(editingContext, editing_mode);
		if (table instanceof Table) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(table, PropertiesEditingProvider.class);
			tableTablePropertiesEditionComponent = (TableTablePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TableTablePropertiesEditionComponent.TABLE_PART, TableTablePropertiesEditionComponent.class);
			addSubComponent(tableTablePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(table, PropertiesEditingProvider.class);
			tablePrimaryKeyPropertiesEditionComponent = (TablePrimaryKeyPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART, TablePrimaryKeyPropertiesEditionComponent.class);
			addSubComponent(tablePrimaryKeyPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(table, PropertiesEditingProvider.class);
			tableForeignKeysPropertiesEditionComponent = (TableForeignKeysPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART, TableForeignKeysPropertiesEditionComponent.class);
			addSubComponent(tableForeignKeysPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(table, PropertiesEditingProvider.class);
			tableConstraintsPropertiesEditionComponent = (TableConstraintsPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART, TableConstraintsPropertiesEditionComponent.class);
			addSubComponent(tableConstraintsPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(table, PropertiesEditingProvider.class);
			tableIndexesPropertiesEditionComponent = (TableIndexesPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TableIndexesPropertiesEditionComponent.INDEXES_PART, TableIndexesPropertiesEditionComponent.class);
			addSubComponent(tableIndexesPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (TableTablePropertiesEditionComponent.TABLE_PART.equals(key)) {
			tablePart = (TablePropertiesEditionPart)tableTablePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)tablePart;
		}
		if (TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART.equals(key)) {
			primaryKeyPart = (PrimaryKeyPropertiesEditionPart)tablePrimaryKeyPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)primaryKeyPart;
		}
		if (TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART.equals(key)) {
			foreignKeysPart = (ForeignKeysPropertiesEditionPart)tableForeignKeysPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)foreignKeysPart;
		}
		if (TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART.equals(key)) {
			constraintsPart = (ConstraintsPropertiesEditionPart)tableConstraintsPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)constraintsPart;
		}
		if (TableIndexesPropertiesEditionComponent.INDEXES_PART.equals(key)) {
			indexesPart = (IndexesPropertiesEditionPart)tableIndexesPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)indexesPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (DatabaseViewsRepository.Table.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			tablePart = (TablePropertiesEditionPart)propertiesEditionPart;
		}
		if (DatabaseViewsRepository.PrimaryKey.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			primaryKeyPart = (PrimaryKeyPropertiesEditionPart)propertiesEditionPart;
		}
		if (DatabaseViewsRepository.ForeignKeys.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			foreignKeysPart = (ForeignKeysPropertiesEditionPart)propertiesEditionPart;
		}
		if (DatabaseViewsRepository.Constraints.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			constraintsPart = (ConstraintsPropertiesEditionPart)propertiesEditionPart;
		}
		if (DatabaseViewsRepository.Indexes.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			indexesPart = (IndexesPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Object key, int kind, EObject element, ResourceSet allResource) {
		if (key == DatabaseViewsRepository.Table.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == DatabaseViewsRepository.PrimaryKey.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == DatabaseViewsRepository.ForeignKeys.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == DatabaseViewsRepository.Constraints.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == DatabaseViewsRepository.Indexes.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
