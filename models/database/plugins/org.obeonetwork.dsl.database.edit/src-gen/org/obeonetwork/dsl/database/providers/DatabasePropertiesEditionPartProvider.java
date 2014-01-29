/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;

import org.obeonetwork.dsl.database.parts.forms.ColumnPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ConstraintPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ConstraintsPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.DataBasePropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ForeignKeyElementPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ForeignKeyPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ForeignKeysPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.IndexElementPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.IndexPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.IndexesPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.PrimaryKeyPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.SchemaPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.SequencePropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.TablePropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.forms.ViewPropertiesEditionPartForm;

import org.obeonetwork.dsl.database.parts.impl.ColumnPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ConstraintPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ConstraintsPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.DataBasePropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ForeignKeyElementPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ForeignKeyPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ForeignKeysPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.IndexElementPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.IndexPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.IndexesPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.PrimaryKeyPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.SchemaPropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.SequencePropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.TablePropertiesEditionPartImpl;
import org.obeonetwork.dsl.database.parts.impl.ViewPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class DatabasePropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == DatabaseViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == DatabaseViewsRepository.DataBase_.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new DataBasePropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new DataBasePropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Column.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ColumnPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ColumnPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Index.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new IndexPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new IndexPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.View.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ViewPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ViewPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Table.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new TablePropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new TablePropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.ForeignKeys.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ForeignKeysPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ForeignKeysPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Indexes.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new IndexesPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new IndexesPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Constraints.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ConstraintsPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ConstraintsPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.PrimaryKey.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new PrimaryKeyPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new PrimaryKeyPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.ForeignKey.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ForeignKeyPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ForeignKeyPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.ForeignKeyElement.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ForeignKeyElementPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ForeignKeyElementPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.IndexElement.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new IndexElementPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new IndexElementPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Constraint.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new ConstraintPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new ConstraintPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Schema.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new SchemaPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new SchemaPropertiesEditionPartForm(component);
		}
		if (key == DatabaseViewsRepository.Sequence.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new SequencePropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new SequencePropertiesEditionPartForm(component);
		}
		return null;
	}

}
