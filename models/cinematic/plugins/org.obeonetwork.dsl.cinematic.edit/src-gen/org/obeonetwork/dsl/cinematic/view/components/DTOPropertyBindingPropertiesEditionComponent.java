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
import org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding;
import org.obeonetwork.dsl.cinematic.view.parts.DTOPropertyBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class DTOPropertyBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The DTOPropertyBinding part
	 * 
	 */
	private DTOPropertyBindingPropertiesEditionPart dTOPropertyBindingPart;

	/**
	 * The DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent sub component
	 * 
	 */
	protected DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent dTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param dTOPropertyBinding the EObject to edit
	 * 
	 */
	public DTOPropertyBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dTOPropertyBinding, String editing_mode) {
		super(editingContext, editing_mode);
		if (dTOPropertyBinding instanceof DTOPropertyBinding) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(dTOPropertyBinding, PropertiesEditingProvider.class);
			dTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent = (DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent.DTOPROPERTYBINDING_PART, DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent.class);
			addSubComponent(dTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(dTOPropertyBinding, PropertiesEditingProvider.class);
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
		if (DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent.DTOPROPERTYBINDING_PART.equals(key)) {
			dTOPropertyBindingPart = (DTOPropertyBindingPropertiesEditionPart)dTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)dTOPropertyBindingPart;
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
		if (ViewViewsRepository.DTOPropertyBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			dTOPropertyBindingPart = (DTOPropertyBindingPropertiesEditionPart)propertiesEditionPart;
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
		if (key == ViewViewsRepository.DTOPropertyBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
