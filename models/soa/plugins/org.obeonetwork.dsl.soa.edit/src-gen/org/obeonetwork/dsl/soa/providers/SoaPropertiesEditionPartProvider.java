/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;

import org.obeonetwork.dsl.soa.parts.forms.BindingPropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.ComponentPropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.Interface_PropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.OperationPropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.ParameterPropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.ServicePropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.SystemPropertiesEditionPartForm;
import org.obeonetwork.dsl.soa.parts.forms.WirePropertiesEditionPartForm;

import org.obeonetwork.dsl.soa.parts.impl.BindingPropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.ComponentPropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.Interface_PropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.OperationPropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.ParameterPropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.ServicePropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.SystemPropertiesEditionPartImpl;
import org.obeonetwork.dsl.soa.parts.impl.WirePropertiesEditionPartImpl;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class SoaPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == SoaViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == SoaViewsRepository.System.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new SystemPropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new SystemPropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Component.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new ComponentPropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new ComponentPropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Service.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new ServicePropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new ServicePropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Wire.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new WirePropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new WirePropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Binding.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new BindingPropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new BindingPropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Interface_.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new Interface_PropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new Interface_PropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Operation.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new OperationPropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new OperationPropertiesEditionPartForm(component);
		}
		if (key == SoaViewsRepository.Parameter.class) {
			if (kind == SoaViewsRepository.SWT_KIND)
				return new ParameterPropertiesEditionPartImpl(component);
			if (kind == SoaViewsRepository.FORM_KIND)
				return new ParameterPropertiesEditionPartForm(component);
		}
		return null;
	}

}
