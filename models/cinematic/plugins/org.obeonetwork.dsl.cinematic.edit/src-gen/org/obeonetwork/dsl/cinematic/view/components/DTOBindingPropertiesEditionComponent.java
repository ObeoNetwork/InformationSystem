/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.view.DTOBinding;
import org.obeonetwork.dsl.cinematic.view.parts.DTOBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class DTOBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The DTOBinding part
	 * 
	 */
	private DTOBindingPropertiesEditionPart dTOBindingPart;

	/**
	 * The DTOBindingDTOBindingPropertiesEditionComponent sub component
	 * 
	 */
	protected DTOBindingDTOBindingPropertiesEditionComponent dTOBindingDTOBindingPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param dTOBinding the EObject to edit
	 * 
	 */
	public DTOBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dTOBinding, String editing_mode) {
		super(editingContext, editing_mode);
		if (dTOBinding instanceof DTOBinding) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(dTOBinding, PropertiesEditingProvider.class);
			dTOBindingDTOBindingPropertiesEditionComponent = (DTOBindingDTOBindingPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, DTOBindingDTOBindingPropertiesEditionComponent.DTOBINDING_PART, DTOBindingDTOBindingPropertiesEditionComponent.class);
			addSubComponent(dTOBindingDTOBindingPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(dTOBinding, PropertiesEditingProvider.class);
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
		if (DTOBindingDTOBindingPropertiesEditionComponent.DTOBINDING_PART.equals(key)) {
			dTOBindingPart = (DTOBindingPropertiesEditionPart)dTOBindingDTOBindingPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)dTOBindingPart;
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
		if (ViewViewsRepository.DTOBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			dTOBindingPart = (DTOBindingPropertiesEditionPart)propertiesEditionPart;
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
		if (key == ViewViewsRepository.DTOBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
