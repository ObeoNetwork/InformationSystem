/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.graal.AbortNode;
import org.obeonetwork.graal.parts.AbortNodePropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class AbortNodePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The AbortNode part
	 * 
	 */
	private AbortNodePropertiesEditionPart abortNodePart;

	/**
	 * The AbortNodeAbortNodePropertiesEditionComponent sub component
	 * 
	 */
	protected AbortNodeAbortNodePropertiesEditionComponent abortNodeAbortNodePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param abortNode the EObject to edit
	 * 
	 */
	public AbortNodePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject abortNode, String editing_mode) {
		super(editingContext, editing_mode);
		if (abortNode instanceof AbortNode) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(abortNode, PropertiesEditingProvider.class);
			abortNodeAbortNodePropertiesEditionComponent = (AbortNodeAbortNodePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, AbortNodeAbortNodePropertiesEditionComponent.ABORTNODE_PART, AbortNodeAbortNodePropertiesEditionComponent.class);
			addSubComponent(abortNodeAbortNodePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(abortNode, PropertiesEditingProvider.class);
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
		if (AbortNodeAbortNodePropertiesEditionComponent.ABORTNODE_PART.equals(key)) {
			abortNodePart = (AbortNodePropertiesEditionPart)abortNodeAbortNodePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)abortNodePart;
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
		if (GraalViewsRepository.AbortNode.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			abortNodePart = (AbortNodePropertiesEditionPart)propertiesEditionPart;
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
		if (key == GraalViewsRepository.AbortNode.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
