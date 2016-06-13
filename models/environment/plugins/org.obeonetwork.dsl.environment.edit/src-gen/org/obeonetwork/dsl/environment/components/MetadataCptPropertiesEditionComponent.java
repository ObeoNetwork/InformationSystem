/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.TypedEReferencePropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class MetadataCptPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String METADATAS_PART = "Metadatas"; //$NON-NLS-1$

	
	/**
	 * Settings for metadata ReferencesTable
	 */
	protected ReferencesTableSettings metadataSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public MetadataCptPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject obeoDSMObject, String editing_mode) {
		super(editingContext, obeoDSMObject, editing_mode);
		parts = new String[] { METADATAS_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Metadatas.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			if (editingPart instanceof CompositePropertiesEditionPart) {
				((CompositePropertiesEditionPart) editingPart).getSettings().add(metadataSettings);
			}
			final ObeoDSMObject obeoDSMObject = (ObeoDSMObject)elt;
			final MetadatasPropertiesEditionPart metadatasPart = (MetadatasPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.Metadatas.Properties.metadata)) {
				metadataSettings = new ReferencesTableSettings(obeoDSMObject, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas(), EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas());
				metadatasPart.initMetadata(metadataSettings);
			}
			// init filters
			if (isAccessible(EnvironmentViewsRepository.Metadatas.Properties.metadata)) {
				metadatasPart.addFilterToMetadata(new ViewerFilter() {
			
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof String)
							return element.equals(""); //$NON-NLS-1$ 
						if (element instanceof MetaData)
							return true;
						return element instanceof Resource;
					}
			
				});
				
				// Start of user code for additional businessfilters for metadata
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}



	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Metadatas.Properties.metadata) {
			return (metadataSettings.getValue() == null) ? (event.getNewValue() != null) : (!metadataSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ObeoDSMObject obeoDSMObject = (ObeoDSMObject)semanticObject;
		if (EnvironmentViewsRepository.Metadatas.Properties.metadata == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new TypedEReferencePropertiesEditingContext(editingContext, this, metadataSettings, EnvironmentPackage.Literals.ANNOTATION, editingContext.getAdapterFactory());
				/*
				 * Generated code below, but it leads to NPE when clickong on the add button
				 * 
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, metadataSettings, editingContext.getAdapterFactory());
				context.addInstanciableTypeFilter(new InstanciableTypeFilter() {
					public boolean select(EClass instanciableType) {
						return EnvironmentPackage.Literals.ANNOTATION == instanciableType;
					}
				});
				*/
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				metadataSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				metadataSettings.move(event.getNewIndex(), (MetaData) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MetadatasPropertiesEditionPart metadatasPart = (MetadatasPropertiesEditionPart)editingPart;
			if (metadataSettings.isAffectingFeature((EStructuralFeature)msg.getFeature()) && isAccessible(EnvironmentViewsRepository.Metadatas.Properties.metadata))
				metadatasPart.updateMetadata();
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
