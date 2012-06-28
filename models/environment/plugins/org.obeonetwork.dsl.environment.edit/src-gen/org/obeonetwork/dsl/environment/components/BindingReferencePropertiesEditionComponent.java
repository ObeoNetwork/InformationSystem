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

import org.obeonetwork.dsl.environment.BindingReference;

import org.obeonetwork.dsl.environment.components.BindingReferenceBindingReferencePropertiesEditionComponent;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;

import org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class BindingReferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The BindingReference part
	 * 
	 */
	private BindingReferencePropertiesEditionPart bindingReferencePart;

	/**
	 * The BindingReferenceBindingReferencePropertiesEditionComponent sub component
	 * 
	 */
	protected BindingReferenceBindingReferencePropertiesEditionComponent bindingReferenceBindingReferencePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param bindingReference the EObject to edit
	 * 
	 */
	public BindingReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject bindingReference, String editing_mode) {
		super(editingContext, editing_mode);
		if (bindingReference instanceof BindingReference) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(bindingReference, PropertiesEditingProvider.class);
			bindingReferenceBindingReferencePropertiesEditionComponent = (BindingReferenceBindingReferencePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, BindingReferenceBindingReferencePropertiesEditionComponent.BINDINGREFERENCE_PART, BindingReferenceBindingReferencePropertiesEditionComponent.class);
			addSubComponent(bindingReferenceBindingReferencePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(bindingReference, PropertiesEditingProvider.class);
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
		if (BindingReferenceBindingReferencePropertiesEditionComponent.BINDINGREFERENCE_PART.equals(key)) {
			bindingReferencePart = (BindingReferencePropertiesEditionPart)bindingReferenceBindingReferencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)bindingReferencePart;
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
		if (EnvironmentViewsRepository.BindingReference.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			bindingReferencePart = (BindingReferencePropertiesEditionPart)propertiesEditionPart;
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
		if (key == EnvironmentViewsRepository.BindingReference.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
