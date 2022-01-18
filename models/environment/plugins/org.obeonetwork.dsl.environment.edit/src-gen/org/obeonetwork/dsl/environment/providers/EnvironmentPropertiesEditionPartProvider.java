/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
package org.obeonetwork.dsl.environment.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

import org.obeonetwork.dsl.environment.parts.forms.AnnotationPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.AttributePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.BindingElementPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.BindingInfoPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.BindingReferencePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.DtoPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.EnumerationPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.EnvironmentPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.FilterContainerPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.InterDSMLinkPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.LiteralPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.MetadatasPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.NamespacePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.OppositePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.PrimitiveTypePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.PriorityDefinitionPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.PriorityPropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.ReferencePropertiesEditionPartForm;
import org.obeonetwork.dsl.environment.parts.forms.TypesDefinitionPropertiesEditionPartForm;

import org.obeonetwork.dsl.environment.parts.impl.AnnotationPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.AttributePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.BindingElementPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.BindingInfoPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.BindingReferencePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.DtoPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.EnumerationPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.EnvironmentPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.FilterContainerPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.InterDSMLinkPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.LiteralPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.MetadatasPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.NamespacePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.OppositePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.PrimitiveTypePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.PriorityDefinitionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.PriorityPropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.ReferencePropertiesEditionPartImpl;
import org.obeonetwork.dsl.environment.parts.impl.TypesDefinitionPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class EnvironmentPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == EnvironmentViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == EnvironmentViewsRepository.Environment_.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new EnvironmentPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new EnvironmentPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.PrimitiveType.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new PrimitiveTypePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new PrimitiveTypePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Enumeration.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new EnumerationPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new EnumerationPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Literal.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new LiteralPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new LiteralPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.InterDSMLink.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new InterDSMLinkPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new InterDSMLinkPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Annotation.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new AnnotationPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new AnnotationPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.PriorityDefinition.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new PriorityDefinitionPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new PriorityDefinitionPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Priority.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new PriorityPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new PriorityPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.TypesDefinition.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new TypesDefinitionPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new TypesDefinitionPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.FilterContainer.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new FilterContainerPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new FilterContainerPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Namespace.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new NamespacePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new NamespacePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Attribute.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new AttributePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new AttributePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Reference.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new ReferencePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new ReferencePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Opposite.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new OppositePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new OppositePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new MetadatasPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new MetadatasPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.BindingInfo.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new BindingInfoPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new BindingInfoPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.BindingReference.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new BindingReferencePropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new BindingReferencePropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.BindingElement.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new BindingElementPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new BindingElementPropertiesEditionPartForm(component);
		}
		if (key == EnvironmentViewsRepository.Dto.class) {
			if (kind == EnvironmentViewsRepository.SWT_KIND)
				return new DtoPropertiesEditionPartImpl(component);
			if (kind == EnvironmentViewsRepository.FORM_KIND)
				return new DtoPropertiesEditionPartForm(component);
		}
		return null;
	}

}
