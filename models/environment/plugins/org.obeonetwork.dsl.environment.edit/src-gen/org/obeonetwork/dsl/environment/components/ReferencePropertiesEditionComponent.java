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
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class ReferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Reference part
	 * 
	 */
	private ReferencePropertiesEditionPart referencePart;

	/**
	 * The ReferenceReferencePropertiesEditionComponent sub component
	 * 
	 */
	protected ReferenceReferencePropertiesEditionComponent referenceReferencePropertiesEditionComponent;

	/**
	 * The Opposite part
	 * 
	 */
	private OppositePropertiesEditionPart oppositePart;

	/**
	 * The ReferenceOppositePropertiesEditionComponent sub component
	 * 
	 */
	protected ReferenceOppositePropertiesEditionComponent referenceOppositePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param reference the EObject to edit
	 * 
	 */
	public ReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject reference, String editing_mode) {
		super(editingContext, editing_mode);
		if (reference instanceof Reference) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(reference, PropertiesEditingProvider.class);
			referenceReferencePropertiesEditionComponent = (ReferenceReferencePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ReferenceReferencePropertiesEditionComponent.REFERENCE_PART, ReferenceReferencePropertiesEditionComponent.class);
			addSubComponent(referenceReferencePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(reference, PropertiesEditingProvider.class);
			referenceOppositePropertiesEditionComponent = (ReferenceOppositePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ReferenceOppositePropertiesEditionComponent.OPPOSITE_PART, ReferenceOppositePropertiesEditionComponent.class);
			addSubComponent(referenceOppositePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(reference, PropertiesEditingProvider.class);
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
		if (ReferenceReferencePropertiesEditionComponent.REFERENCE_PART.equals(key)) {
			referencePart = (ReferencePropertiesEditionPart)referenceReferencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)referencePart;
		}
		if (ReferenceOppositePropertiesEditionComponent.OPPOSITE_PART.equals(key)) {
			oppositePart = (OppositePropertiesEditionPart)referenceOppositePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)oppositePart;
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
		if (EnvironmentViewsRepository.Reference.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			referencePart = (ReferencePropertiesEditionPart)propertiesEditionPart;
		}
		if (EnvironmentViewsRepository.Opposite.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			oppositePart = (OppositePropertiesEditionPart)propertiesEditionPart;
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
		if (key == EnvironmentViewsRepository.Reference.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Opposite.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
