/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.flow.AsyncEventState;
import org.obeonetwork.dsl.cinematic.flow.parts.AsyncEventStatePropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class AsyncEventStatePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The AsyncEventState part
	 * 
	 */
	private AsyncEventStatePropertiesEditionPart asyncEventStatePart;

	/**
	 * The AsyncEventStateAsyncEventStatePropertiesEditionComponent sub component
	 * 
	 */
	protected AsyncEventStateAsyncEventStatePropertiesEditionComponent asyncEventStateAsyncEventStatePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param asyncEventState the EObject to edit
	 * 
	 */
	public AsyncEventStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject asyncEventState, String editing_mode) {
		super(editingContext, editing_mode);
		if (asyncEventState instanceof AsyncEventState) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(asyncEventState, PropertiesEditingProvider.class);
			asyncEventStateAsyncEventStatePropertiesEditionComponent = (AsyncEventStateAsyncEventStatePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, AsyncEventStateAsyncEventStatePropertiesEditionComponent.ASYNCEVENTSTATE_PART, AsyncEventStateAsyncEventStatePropertiesEditionComponent.class);
			addSubComponent(asyncEventStateAsyncEventStatePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(asyncEventState, PropertiesEditingProvider.class);
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
		if (AsyncEventStateAsyncEventStatePropertiesEditionComponent.ASYNCEVENTSTATE_PART.equals(key)) {
			asyncEventStatePart = (AsyncEventStatePropertiesEditionPart)asyncEventStateAsyncEventStatePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)asyncEventStatePart;
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
		if (FlowViewsRepository.AsyncEventState.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			asyncEventStatePart = (AsyncEventStatePropertiesEditionPart)propertiesEditionPart;
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
		if (key == FlowViewsRepository.AsyncEventState.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
