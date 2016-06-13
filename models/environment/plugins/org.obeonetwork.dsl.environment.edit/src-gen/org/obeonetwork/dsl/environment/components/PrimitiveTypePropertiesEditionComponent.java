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
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.PrimitiveTypePropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class PrimitiveTypePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The PrimitiveType part
	 * 
	 */
	private PrimitiveTypePropertiesEditionPart primitiveTypePart;

	/**
	 * The PrimitiveTypePrimitiveTypePropertiesEditionComponent sub component
	 * 
	 */
	protected PrimitiveTypePrimitiveTypePropertiesEditionComponent primitiveTypePrimitiveTypePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param primitiveType the EObject to edit
	 * 
	 */
	public PrimitiveTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject primitiveType, String editing_mode) {
		super(editingContext, editing_mode);
		if (primitiveType instanceof PrimitiveType) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(primitiveType, PropertiesEditingProvider.class);
			primitiveTypePrimitiveTypePropertiesEditionComponent = (PrimitiveTypePrimitiveTypePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, PrimitiveTypePrimitiveTypePropertiesEditionComponent.PRIMITIVETYPE_PART, PrimitiveTypePrimitiveTypePropertiesEditionComponent.class);
			addSubComponent(primitiveTypePrimitiveTypePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(primitiveType, PropertiesEditingProvider.class);
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
		if (PrimitiveTypePrimitiveTypePropertiesEditionComponent.PRIMITIVETYPE_PART.equals(key)) {
			primitiveTypePart = (PrimitiveTypePropertiesEditionPart)primitiveTypePrimitiveTypePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)primitiveTypePart;
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
		if (EnvironmentViewsRepository.PrimitiveType.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			primitiveTypePart = (PrimitiveTypePropertiesEditionPart)propertiesEditionPart;
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
		if (key == EnvironmentViewsRepository.PrimitiveType.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
