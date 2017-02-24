/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
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
package org.obeonetwork.dsl.environment.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.TypesDefinitionPropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class TypesDefinitionPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The TypesDefinition part
	 * 
	 */
	private TypesDefinitionPropertiesEditionPart typesDefinitionPart;

	/**
	 * The TypesDefinitionTypesDefinitionPropertiesEditionComponent sub component
	 * 
	 */
	protected TypesDefinitionTypesDefinitionPropertiesEditionComponent typesDefinitionTypesDefinitionPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param typesDefinition the EObject to edit
	 * 
	 */
	public TypesDefinitionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject typesDefinition, String editing_mode) {
		super(editingContext, editing_mode);
		if (typesDefinition instanceof TypesDefinition) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(typesDefinition, PropertiesEditingProvider.class);
			typesDefinitionTypesDefinitionPropertiesEditionComponent = (TypesDefinitionTypesDefinitionPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, TypesDefinitionTypesDefinitionPropertiesEditionComponent.TYPESDEFINITION_PART, TypesDefinitionTypesDefinitionPropertiesEditionComponent.class);
			addSubComponent(typesDefinitionTypesDefinitionPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(typesDefinition, PropertiesEditingProvider.class);
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
		if (TypesDefinitionTypesDefinitionPropertiesEditionComponent.TYPESDEFINITION_PART.equals(key)) {
			typesDefinitionPart = (TypesDefinitionPropertiesEditionPart)typesDefinitionTypesDefinitionPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)typesDefinitionPart;
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
		if (EnvironmentViewsRepository.TypesDefinition.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			typesDefinitionPart = (TypesDefinitionPropertiesEditionPart)propertiesEditionPart;
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
		if (key == EnvironmentViewsRepository.TypesDefinition.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
