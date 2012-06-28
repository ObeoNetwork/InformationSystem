/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;

import org.obeonetwork.dsl.entityrelation.parts.forms.AttributePropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.EntityPropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.IdentifierPropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.IdentifiersPropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.LogicalModelPropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.RelationElementPropertiesEditionPartForm;
import org.obeonetwork.dsl.entityrelation.parts.forms.RelationPropertiesEditionPartForm;

import org.obeonetwork.dsl.entityrelation.parts.impl.AttributePropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.EntityPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.IdentifierPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.IdentifiersPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.LogicalModelPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.RelationElementPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entityrelation.parts.impl.RelationPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class EntityrelationPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == EntityrelationViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == EntityrelationViewsRepository.LogicalModel.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new LogicalModelPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new LogicalModelPropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.Entity.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new EntityPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new EntityPropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.Identifiers.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new IdentifiersPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new IdentifiersPropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.Relation.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new RelationPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new RelationPropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.RelationElement.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new RelationElementPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new RelationElementPropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.Attribute.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new AttributePropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new AttributePropertiesEditionPartForm(component);
		}
		if (key == EntityrelationViewsRepository.Identifier.class) {
			if (kind == EntityrelationViewsRepository.SWT_KIND)
				return new IdentifierPropertiesEditionPartImpl(component);
			if (kind == EntityrelationViewsRepository.FORM_KIND)
				return new IdentifierPropertiesEditionPartForm(component);
		}
		return null;
	}

}
