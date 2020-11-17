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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.interaction.CreateParticipantMessage;
import org.obeonetwork.dsl.interaction.parts.CreateParticipantMessagePropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class CreateParticipantMessagePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The CreateParticipantMessage part
	 * 
	 */
	private CreateParticipantMessagePropertiesEditionPart createParticipantMessagePart;

	/**
	 * The CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent sub component
	 * 
	 */
	protected CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent createParticipantMessageCreateParticipantMessagePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param createParticipantMessage the EObject to edit
	 * 
	 */
	public CreateParticipantMessagePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject createParticipantMessage, String editing_mode) {
		super(editingContext, editing_mode);
		if (createParticipantMessage instanceof CreateParticipantMessage) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(createParticipantMessage, PropertiesEditingProvider.class);
			createParticipantMessageCreateParticipantMessagePropertiesEditionComponent = (CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent.CREATEPARTICIPANTMESSAGE_PART, CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent.class);
			addSubComponent(createParticipantMessageCreateParticipantMessagePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(createParticipantMessage, PropertiesEditingProvider.class);
			metadataCptPropertiesEditionComponent = (MetadataCptPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, MetadataCptPropertiesEditionComponent.METADATAS_PART, MetadataCptPropertiesEditionComponent.class);
			addSubComponent(metadataCptPropertiesEditionComponent);
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
		if (CreateParticipantMessageCreateParticipantMessagePropertiesEditionComponent.CREATEPARTICIPANTMESSAGE_PART.equals(key)) {
			createParticipantMessagePart = (CreateParticipantMessagePropertiesEditionPart)createParticipantMessageCreateParticipantMessagePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)createParticipantMessagePart;
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
		if (InteractionViewsRepository.CreateParticipantMessage.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			createParticipantMessagePart = (CreateParticipantMessagePropertiesEditionPart)propertiesEditionPart;
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
		if (key == InteractionViewsRepository.CreateParticipantMessage.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
