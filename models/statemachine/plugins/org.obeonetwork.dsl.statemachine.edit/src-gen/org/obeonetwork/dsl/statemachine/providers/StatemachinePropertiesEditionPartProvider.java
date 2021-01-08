/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
package org.obeonetwork.dsl.statemachine.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;

import org.obeonetwork.dsl.statemachine.parts.forms.FinalStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.statemachine.parts.forms.InitialStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.statemachine.parts.forms.RegionPropertiesEditionPartForm;
import org.obeonetwork.dsl.statemachine.parts.forms.StateMachinePropertiesEditionPartForm;
import org.obeonetwork.dsl.statemachine.parts.forms.StatePropertiesEditionPartForm;
import org.obeonetwork.dsl.statemachine.parts.forms.TransitionPropertiesEditionPartForm;

import org.obeonetwork.dsl.statemachine.parts.impl.FinalStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.statemachine.parts.impl.InitialStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.statemachine.parts.impl.RegionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.statemachine.parts.impl.StateMachinePropertiesEditionPartImpl;
import org.obeonetwork.dsl.statemachine.parts.impl.StatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.statemachine.parts.impl.TransitionPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class StatemachinePropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == StatemachineViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == StatemachineViewsRepository.StateMachine_.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new StateMachinePropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new StateMachinePropertiesEditionPartForm(component);
		}
		if (key == StatemachineViewsRepository.State.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new StatePropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new StatePropertiesEditionPartForm(component);
		}
		if (key == StatemachineViewsRepository.Region.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new RegionPropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new RegionPropertiesEditionPartForm(component);
		}
		if (key == StatemachineViewsRepository.Transition.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new TransitionPropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new TransitionPropertiesEditionPartForm(component);
		}
		if (key == StatemachineViewsRepository.InitialState.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new InitialStatePropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new InitialStatePropertiesEditionPartForm(component);
		}
		if (key == StatemachineViewsRepository.FinalState.class) {
			if (kind == StatemachineViewsRepository.SWT_KIND)
				return new FinalStatePropertiesEditionPartImpl(component);
			if (kind == StatemachineViewsRepository.FORM_KIND)
				return new FinalStatePropertiesEditionPartForm(component);
		}
		return null;
	}

}
