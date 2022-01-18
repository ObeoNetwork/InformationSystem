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
import org.obeonetwork.dsl.interaction.DestroyParticipantMessage;
import org.obeonetwork.dsl.interaction.parts.DestroyParticipantMessagePropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class DestroyParticipantMessagePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The DestroyParticipantMessage part
	 * 
	 */
	private DestroyParticipantMessagePropertiesEditionPart destroyParticipantMessagePart;

	/**
	 * The DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent sub component
	 * 
	 */
	protected DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent destroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param destroyParticipantMessage the EObject to edit
	 * 
	 */
	public DestroyParticipantMessagePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject destroyParticipantMessage, String editing_mode) {
		super(editingContext, editing_mode);
		if (destroyParticipantMessage instanceof DestroyParticipantMessage) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(destroyParticipantMessage, PropertiesEditingProvider.class);
			destroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent = (DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent.DESTROYPARTICIPANTMESSAGE_PART, DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent.class);
			addSubComponent(destroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(destroyParticipantMessage, PropertiesEditingProvider.class);
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
		if (DestroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent.DESTROYPARTICIPANTMESSAGE_PART.equals(key)) {
			destroyParticipantMessagePart = (DestroyParticipantMessagePropertiesEditionPart)destroyParticipantMessageDestroyParticipantMessagePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)destroyParticipantMessagePart;
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
		if (InteractionViewsRepository.DestroyParticipantMessage.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			destroyParticipantMessagePart = (DestroyParticipantMessagePropertiesEditionPart)propertiesEditionPart;
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
		if (key == InteractionViewsRepository.DestroyParticipantMessage.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
