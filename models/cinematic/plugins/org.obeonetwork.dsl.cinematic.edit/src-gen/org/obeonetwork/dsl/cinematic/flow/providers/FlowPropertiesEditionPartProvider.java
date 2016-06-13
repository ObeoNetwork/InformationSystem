/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;

import org.obeonetwork.dsl.cinematic.flow.parts.forms.AbortStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.ActionStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.AsyncEventStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.DecisionStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.FinalStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.FlowActionPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.FlowEventPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.FlowPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.InitialStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.SubflowStatePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.TransitionPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.flow.parts.forms.ViewStatePropertiesEditionPartForm;

import org.obeonetwork.dsl.cinematic.flow.parts.impl.AbortStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.ActionStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.AsyncEventStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.DecisionStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.FinalStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.FlowActionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.FlowEventPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.FlowPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.InitialStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.SubflowStatePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.TransitionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.flow.parts.impl.ViewStatePropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class FlowPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == FlowViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == FlowViewsRepository.Flow_.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new FlowPropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new FlowPropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.Transition.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new TransitionPropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new TransitionPropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.ActionState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new ActionStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new ActionStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.ViewState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new ViewStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new ViewStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.DecisionState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new DecisionStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new DecisionStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.SubflowState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new SubflowStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new SubflowStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.AsyncEventState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new AsyncEventStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new AsyncEventStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.InitialState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new InitialStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new InitialStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.AbortState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new AbortStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new AbortStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.FinalState.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new FinalStatePropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new FinalStatePropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.FlowAction.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new FlowActionPropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new FlowActionPropertiesEditionPartForm(component);
		}
		if (key == FlowViewsRepository.FlowEvent.class) {
			if (kind == FlowViewsRepository.SWT_KIND)
				return new FlowEventPropertiesEditionPartImpl(component);
			if (kind == FlowViewsRepository.FORM_KIND)
				return new FlowEventPropertiesEditionPartForm(component);
		}
		return null;
	}

}
