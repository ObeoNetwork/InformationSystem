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
package org.obeonetwork.dsl.cinematic.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.Package;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class PackagePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Package part
	 * 
	 */
	private Package_PropertiesEditionPart package_Part;

	/**
	 * The PackagePackage_PropertiesEditionComponent sub component
	 * 
	 */
	protected PackagePackage_PropertiesEditionComponent packagePackage_PropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param package_ the EObject to edit
	 * 
	 */
	public PackagePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject package_, String editing_mode) {
		super(editingContext, editing_mode);
		if (package_ instanceof Package) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(package_, PropertiesEditingProvider.class);
			packagePackage_PropertiesEditionComponent = (PackagePackage_PropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, PackagePackage_PropertiesEditionComponent.PACKAGE__PART, PackagePackage_PropertiesEditionComponent.class);
			addSubComponent(packagePackage_PropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(package_, PropertiesEditingProvider.class);
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
		if (PackagePackage_PropertiesEditionComponent.PACKAGE__PART.equals(key)) {
			package_Part = (Package_PropertiesEditionPart)packagePackage_PropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)package_Part;
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
		if (CinematicViewsRepository.Package_.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			package_Part = (Package_PropertiesEditionPart)propertiesEditionPart;
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
		if (key == CinematicViewsRepository.Package_.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
