/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;

import org.obeonetwork.dsl.interaction.parts.forms.CallMessagePropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.CombinedFragmentPropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.CreateParticipantMessagePropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.DestroyParticipantMessagePropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.ExecutionPropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.InteractionPropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.InteractionUsePropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.OperandPropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.ParticipantPropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.ReturnMessagePropertiesEditionPartForm;
import org.obeonetwork.dsl.interaction.parts.forms.StateInvariantPropertiesEditionPartForm;

import org.obeonetwork.dsl.interaction.parts.impl.CallMessagePropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.CombinedFragmentPropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.CreateParticipantMessagePropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.DestroyParticipantMessagePropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.ExecutionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.InteractionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.InteractionUsePropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.OperandPropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.ParticipantPropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.ReturnMessagePropertiesEditionPartImpl;
import org.obeonetwork.dsl.interaction.parts.impl.StateInvariantPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class InteractionPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == InteractionViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == InteractionViewsRepository.Interaction_.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new InteractionPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new InteractionPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.Participant.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new ParticipantPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new ParticipantPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.Execution.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new ExecutionPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new ExecutionPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.CreateParticipantMessage.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new CreateParticipantMessagePropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new CreateParticipantMessagePropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.DestroyParticipantMessage.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new DestroyParticipantMessagePropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new DestroyParticipantMessagePropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.ReturnMessage.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new ReturnMessagePropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new ReturnMessagePropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.StateInvariant.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new StateInvariantPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new StateInvariantPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.InteractionUse.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new InteractionUsePropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new InteractionUsePropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.CombinedFragment.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new CombinedFragmentPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new CombinedFragmentPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.Operand.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new OperandPropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new OperandPropertiesEditionPartForm(component);
		}
		if (key == InteractionViewsRepository.CallMessage.class) {
			if (kind == InteractionViewsRepository.SWT_KIND)
				return new CallMessagePropertiesEditionPartImpl(component);
			if (kind == InteractionViewsRepository.FORM_KIND)
				return new CallMessagePropertiesEditionPartForm(component);
		}
		return null;
	}

}
