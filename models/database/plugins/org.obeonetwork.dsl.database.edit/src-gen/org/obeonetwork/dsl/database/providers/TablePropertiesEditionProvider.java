/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;

import org.eclipse.jface.viewers.IFilter;

import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;

import org.obeonetwork.dsl.database.components.TableConstraintsPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TableForeignKeysPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TableIndexesPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TablePrimaryKeyPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TablePropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TableTablePropertiesEditionComponent;

/**
 * 
 * 
 */
public class TablePropertiesEditionProvider extends PropertiesEditingProviderImpl {

	/**
	 * Constructor without provider for super types.
	 */
	public TablePropertiesEditionProvider() {
		super();
	}

	/**
	 * Constructor with providers for super types.
	 * @param superProviders providers to use for super types.
	 */
	public TablePropertiesEditionProvider(List<PropertiesEditingProvider> superProviders) {
		super(superProviders);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext) {
		return (editingContext.getEObject() instanceof Table) 
					&& (DatabasePackage.Literals.TABLE == editingContext.getEObject().eClass());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part) {
		return (editingContext.getEObject() instanceof Table) && (TableTablePropertiesEditionComponent.TABLE_PART.equals(part) || TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART.equals(part) || TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART.equals(part) || TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART.equals(part) || TableIndexesPropertiesEditionComponent.INDEXES_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof Table) && (refinement == TableTablePropertiesEditionComponent.class || refinement == TablePrimaryKeyPropertiesEditionComponent.class || refinement == TableForeignKeysPropertiesEditionComponent.class || refinement == TableConstraintsPropertiesEditionComponent.class || refinement == TableIndexesPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, String part, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof Table) && ((TableTablePropertiesEditionComponent.TABLE_PART.equals(part) && refinement == TableTablePropertiesEditionComponent.class) || (TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART.equals(part) && refinement == TablePrimaryKeyPropertiesEditionComponent.class) || (TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART.equals(part) && refinement == TableForeignKeysPropertiesEditionComponent.class) || (TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART.equals(part) && refinement == TableConstraintsPropertiesEditionComponent.class) || (TableIndexesPropertiesEditionComponent.INDEXES_PART.equals(part) && refinement == TableIndexesPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode) {
		if (editingContext.getEObject() instanceof Table) {
			return new TablePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part) {
		if (editingContext.getEObject() instanceof Table) {
			if (TableTablePropertiesEditionComponent.TABLE_PART.equals(part))
				return new TableTablePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART.equals(part))
				return new TablePrimaryKeyPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART.equals(part))
				return new TableForeignKeysPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART.equals(part))
				return new TableConstraintsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableIndexesPropertiesEditionComponent.INDEXES_PART.equals(part))
				return new TableIndexesPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part, java.lang.Class refinement) {
		if (editingContext.getEObject() instanceof Table) {
			if (TableTablePropertiesEditionComponent.TABLE_PART.equals(part)
				&& refinement == TableTablePropertiesEditionComponent.class)
				return new TableTablePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TablePrimaryKeyPropertiesEditionComponent.PRIMARYKEY_PART.equals(part)
				&& refinement == TablePrimaryKeyPropertiesEditionComponent.class)
				return new TablePrimaryKeyPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableForeignKeysPropertiesEditionComponent.FOREIGNKEYS_PART.equals(part)
				&& refinement == TableForeignKeysPropertiesEditionComponent.class)
				return new TableForeignKeysPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableConstraintsPropertiesEditionComponent.CONSTRAINTS_PART.equals(part)
				&& refinement == TableConstraintsPropertiesEditionComponent.class)
				return new TableConstraintsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TableIndexesPropertiesEditionComponent.INDEXES_PART.equals(part)
				&& refinement == TableIndexesPropertiesEditionComponent.class)
				return new TableIndexesPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
	}

	/**
	 * Provides the filter used by the plugin.xml to assign part forms.
	 */
	public static class EditionFilter implements IFilter {
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
		 */
		public boolean select(Object toTest) {
			return toTest instanceof EObject && DatabasePackage.Literals.TABLE == ((EObject)toTest).eClass();
		}
		
	}

}
