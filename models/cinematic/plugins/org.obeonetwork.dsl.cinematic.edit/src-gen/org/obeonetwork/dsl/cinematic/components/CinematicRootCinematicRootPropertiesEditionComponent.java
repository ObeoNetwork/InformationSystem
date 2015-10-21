/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Package;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

// End of user code

/**
 * 
 * 
 */
public class CinematicRootCinematicRootPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String CINEMATICROOT_PART = "CinematicRoot"; //$NON-NLS-1$

	
	/**
	 * Settings for flows ReferencesTable
	 */
	protected ReferencesTableSettings flowsSettings;
	
	/**
	 * Settings for viewContainers ReferencesTable
	 */
	protected ReferencesTableSettings viewContainersSettings;
	
	/**
	 * Settings for subPackages ReferencesTable
	 */
	protected ReferencesTableSettings subPackagesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CinematicRootCinematicRootPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cinematicRoot, String editing_mode) {
		super(editingContext, cinematicRoot, editing_mode);
		parts = new String[] { CINEMATICROOT_PART };
		repositoryKey = CinematicViewsRepository.class;
		partKey = CinematicViewsRepository.CinematicRoot.class;
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
			
			final CinematicRoot cinematicRoot = (CinematicRoot)elt;
			final CinematicRootPropertiesEditionPart cinematicRootPart = (CinematicRootPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.description))
				cinematicRootPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cinematicRoot.getDescription()));
			
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.name))
				cinematicRootPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cinematicRoot.getName()));
			
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.flows)) {
				flowsSettings = new ReferencesTableSettings(cinematicRoot, CinematicPackage.eINSTANCE.getAbstractPackage_Flows());
				cinematicRootPart.initFlows(flowsSettings);
			}
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.viewContainers)) {
				viewContainersSettings = new ReferencesTableSettings(cinematicRoot, CinematicPackage.eINSTANCE.getAbstractPackage_ViewContainers());
				cinematicRootPart.initViewContainers(viewContainersSettings);
			}
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.subPackages)) {
				subPackagesSettings = new ReferencesTableSettings(cinematicRoot, CinematicPackage.eINSTANCE.getAbstractPackage_SubPackages());
				cinematicRootPart.initSubPackages(subPackagesSettings);
			}
			// init filters
			
			
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.flows)) {
				cinematicRootPart.addFilterToFlows(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Flow); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for flows
				// End of user code
			}
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.viewContainers)) {
				cinematicRootPart.addFilterToViewContainers(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ViewContainer); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for viewContainers
				// End of user code
			}
			if (isAccessible(CinematicViewsRepository.CinematicRoot.Properties.subPackages)) {
				cinematicRootPart.addFilterToSubPackages(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Package); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for subPackages
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}








	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == CinematicViewsRepository.CinematicRoot.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == CinematicViewsRepository.CinematicRoot.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == CinematicViewsRepository.CinematicRoot.Properties.flows) {
			return CinematicPackage.eINSTANCE.getAbstractPackage_Flows();
		}
		if (editorKey == CinematicViewsRepository.CinematicRoot.Properties.viewContainers) {
			return CinematicPackage.eINSTANCE.getAbstractPackage_ViewContainers();
		}
		if (editorKey == CinematicViewsRepository.CinematicRoot.Properties.subPackages) {
			return CinematicPackage.eINSTANCE.getAbstractPackage_SubPackages();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CinematicRoot cinematicRoot = (CinematicRoot)semanticObject;
		if (CinematicViewsRepository.CinematicRoot.Properties.description == event.getAffectedEditor()) {
			cinematicRoot.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (CinematicViewsRepository.CinematicRoot.Properties.name == event.getAffectedEditor()) {
			cinematicRoot.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (CinematicViewsRepository.CinematicRoot.Properties.flows == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, flowsSettings, editingContext.getAdapterFactory());
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
				flowsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				flowsSettings.move(event.getNewIndex(), (Flow) event.getNewValue());
			}
		}
		if (CinematicViewsRepository.CinematicRoot.Properties.viewContainers == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, viewContainersSettings, editingContext.getAdapterFactory());
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
				viewContainersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				viewContainersSettings.move(event.getNewIndex(), (ViewContainer) event.getNewValue());
			}
		}
		if (CinematicViewsRepository.CinematicRoot.Properties.subPackages == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, subPackagesSettings, editingContext.getAdapterFactory());
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
				subPackagesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				subPackagesSettings.move(event.getNewIndex(), (Package) event.getNewValue());
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
			CinematicRootPropertiesEditionPart cinematicRootPart = (CinematicRootPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && cinematicRootPart != null && isAccessible(CinematicViewsRepository.CinematicRoot.Properties.description)) {
				if (msg.getNewValue() != null) {
					cinematicRootPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					cinematicRootPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && cinematicRootPart != null && isAccessible(CinematicViewsRepository.CinematicRoot.Properties.name)) {
				if (msg.getNewValue() != null) {
					cinematicRootPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					cinematicRootPart.setName("");
				}
			}
			if (CinematicPackage.eINSTANCE.getAbstractPackage_Flows().equals(msg.getFeature()) && isAccessible(CinematicViewsRepository.CinematicRoot.Properties.flows))
				cinematicRootPart.updateFlows();
			if (CinematicPackage.eINSTANCE.getAbstractPackage_ViewContainers().equals(msg.getFeature()) && isAccessible(CinematicViewsRepository.CinematicRoot.Properties.viewContainers))
				cinematicRootPart.updateViewContainers();
			if (CinematicPackage.eINSTANCE.getAbstractPackage_SubPackages().equals(msg.getFeature()) && isAccessible(CinematicViewsRepository.CinematicRoot.Properties.subPackages))
				cinematicRootPart.updateSubPackages();
			
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			CinematicPackage.eINSTANCE.getNamedElement_Name(),
			CinematicPackage.eINSTANCE.getAbstractPackage_Flows(),
			CinematicPackage.eINSTANCE.getAbstractPackage_ViewContainers(),
			CinematicPackage.eINSTANCE.getAbstractPackage_SubPackages()		);
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
				if (CinematicViewsRepository.CinematicRoot.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (CinematicViewsRepository.CinematicRoot.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
