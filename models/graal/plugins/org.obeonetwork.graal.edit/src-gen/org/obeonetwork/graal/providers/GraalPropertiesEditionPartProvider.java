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
package org.obeonetwork.graal.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.forms.AbortNodePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.ActorPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.AppliActionPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.AppliEventPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.DomainClassPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.FinalNodePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.InitialNodePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.LoopPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.OperatorPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.PersistencePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.SystemPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.TaskPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.TaskReferencePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.TasksGroupPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.TransitionPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.UseCasePropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.UserActionPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.UserStoryPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.forms.UserViewPropertiesEditionPartForm;
import org.obeonetwork.graal.parts.impl.AbortNodePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.ActorPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.AppliActionPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.AppliEventPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.DomainClassPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.FinalNodePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.InitialNodePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.LoopPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.OperatorPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.PersistencePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.SystemPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.TaskPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.TaskReferencePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.TasksGroupPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.TransitionPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.UseCasePropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.UserActionPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.UserStoryPropertiesEditionPartImpl;
import org.obeonetwork.graal.parts.impl.UserViewPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class GraalPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == GraalViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == GraalViewsRepository.Task.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new TaskPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new TaskPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.System.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new SystemPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new SystemPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.Operator.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new OperatorPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new OperatorPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.Transition.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new TransitionPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new TransitionPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.TaskReference.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new TaskReferencePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new TaskReferencePropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.UserView.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new UserViewPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new UserViewPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.UserAction.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new UserActionPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new UserActionPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.AppliEvent.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new AppliEventPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new AppliEventPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.AppliAction.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new AppliActionPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new AppliActionPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.InitialNode.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new InitialNodePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new InitialNodePropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.FinalNode.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new FinalNodePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new FinalNodePropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.AbortNode.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new AbortNodePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new AbortNodePropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.Loop.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new LoopPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new LoopPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.Actor.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new ActorPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new ActorPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.TasksGroup.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new TasksGroupPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new TasksGroupPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.UseCase.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new UseCasePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new UseCasePropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.UserStory.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new UserStoryPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new UserStoryPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.DomainClass.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new DomainClassPropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new DomainClassPropertiesEditionPartForm(component);
		}
		if (key == GraalViewsRepository.Persistence.class) {
			if (kind == GraalViewsRepository.SWT_KIND)
				return new PersistencePropertiesEditionPartImpl(component);
			if (kind == GraalViewsRepository.FORM_KIND)
				return new PersistencePropertiesEditionPartForm(component);
		}
		return null;
	}

}
