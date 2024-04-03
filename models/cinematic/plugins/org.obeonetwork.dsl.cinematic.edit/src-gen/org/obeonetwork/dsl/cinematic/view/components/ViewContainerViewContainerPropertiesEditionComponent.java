/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.components;

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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsFactory;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class ViewContainerViewContainerPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VIEWCONTAINER_PART = "ViewContainer"; //$NON-NLS-1$

	
	/**
	 * Settings for widget EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings widgetSettings;
	
	/**
	 * Settings for actions ReferencesTable
	 */
	protected ReferencesTableSettings actionsSettings;
	
	/**
	 * Settings for events ReferencesTable
	 */
	protected ReferencesTableSettings eventsSettings;
	
	/**
	 * Settings for ownedElements ReferencesTable
	 */
	protected ReferencesTableSettings ownedElementsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ViewContainerViewContainerPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject viewContainer, String editing_mode) {
		super(editingContext, viewContainer, editing_mode);
		parts = new String[] { VIEWCONTAINER_PART };
		repositoryKey = ViewViewsRepository.class;
		partKey = ViewViewsRepository.ViewContainer.class;
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
			
			final ViewContainer viewContainer = (ViewContainer)elt;
			final ViewContainerPropertiesEditionPart viewContainerPart = (ViewContainerPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.description))
				viewContainerPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainer.getDescription()));
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.name))
				viewContainerPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainer.getName()));
			
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.widget)) {
				// init part
				widgetSettings = new EObjectFlatComboSettings(viewContainer, ViewPackage.eINSTANCE.getAbstractViewElement_Widget());
				viewContainerPart.initWidget(widgetSettings);
				// set the button mode
				viewContainerPart.setWidgetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.actions)) {
				actionsSettings = new ReferencesTableSettings(viewContainer, ViewPackage.eINSTANCE.getAbstractViewElement_Actions());
				viewContainerPart.initActions(actionsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.events)) {
				eventsSettings = new ReferencesTableSettings(viewContainer, ViewPackage.eINSTANCE.getAbstractViewElement_Events());
				viewContainerPart.initEvents(eventsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.label))
				viewContainerPart.setLabel(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainer.getLabel()));
			
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.ownedElements)) {
				ownedElementsSettings = new ReferencesTableSettings(viewContainer, ViewPackage.eINSTANCE.getViewContainer_OwnedElements());
				viewContainerPart.initOwnedElements(ownedElementsSettings);
			}
			// init filters
			
			
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.widget)) {
				viewContainerPart.addFilterToWidget(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Widget); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for widget
				// End of user code
			}
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.actions)) {
				viewContainerPart.addFilterToActions(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ViewAction); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for actions
				// End of user code
			}
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.events)) {
				viewContainerPart.addFilterToEvents(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ViewEvent); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for events
				// End of user code
			}
			
			if (isAccessible(ViewViewsRepository.ViewContainer.Properties.ownedElements)) {
				viewContainerPart.addFilterToOwnedElements(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof AbstractViewElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for ownedElements
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
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.widget) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Widget();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.actions) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Actions();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.events) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Events();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.label) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Label();
		}
		if (editorKey == ViewViewsRepository.ViewContainer.Properties.ownedElements) {
			return ViewPackage.eINSTANCE.getViewContainer_OwnedElements();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ViewContainer viewContainer = (ViewContainer)semanticObject;
		if (ViewViewsRepository.ViewContainer.Properties.description == event.getAffectedEditor()) {
			viewContainer.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainer.Properties.name == event.getAffectedEditor()) {
			viewContainer.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainer.Properties.widget == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				widgetSettings.setToReference((Widget)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Widget eObject = ToolkitsFactory.eINSTANCE.createWidget();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				widgetSettings.setToReference(eObject);
			}
		}
		if (ViewViewsRepository.ViewContainer.Properties.actions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, actionsSettings, editingContext.getAdapterFactory());
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
				actionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				actionsSettings.move(event.getNewIndex(), (ViewAction) event.getNewValue());
			}
		}
		if (ViewViewsRepository.ViewContainer.Properties.events == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eventsSettings, editingContext.getAdapterFactory());
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
				eventsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eventsSettings.move(event.getNewIndex(), (ViewEvent) event.getNewValue());
			}
		}
		if (ViewViewsRepository.ViewContainer.Properties.label == event.getAffectedEditor()) {
			viewContainer.setLabel((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainer.Properties.ownedElements == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, ownedElementsSettings, editingContext.getAdapterFactory());
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
				ownedElementsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				ownedElementsSettings.move(event.getNewIndex(), (AbstractViewElement) event.getNewValue());
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
			ViewContainerPropertiesEditionPart viewContainerPart = (ViewContainerPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerPart != null && isAccessible(ViewViewsRepository.ViewContainer.Properties.description)){
				if (msg.getNewValue() != null) {
					viewContainerPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerPart != null && isAccessible(ViewViewsRepository.ViewContainer.Properties.name)) {
				if (msg.getNewValue() != null) {
					viewContainerPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerPart.setName("");
				}
			}
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Widget().equals(msg.getFeature()) && viewContainerPart != null && isAccessible(ViewViewsRepository.ViewContainer.Properties.widget))
				viewContainerPart.setWidget((EObject)msg.getNewValue());
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Actions().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewContainer.Properties.actions))
				viewContainerPart.updateActions();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Events().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewContainer.Properties.events))
				viewContainerPart.updateEvents();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Label().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerPart != null && isAccessible(ViewViewsRepository.ViewContainer.Properties.label)) {
				if (msg.getNewValue() != null) {
					viewContainerPart.setLabel(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerPart.setLabel("");
				}
			}
			if (ViewPackage.eINSTANCE.getViewContainer_OwnedElements().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewContainer.Properties.ownedElements))
				viewContainerPart.updateOwnedElements();
			
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
			ViewPackage.eINSTANCE.getAbstractViewElement_Widget(),
			ViewPackage.eINSTANCE.getAbstractViewElement_Actions(),
			ViewPackage.eINSTANCE.getAbstractViewElement_Events(),
			ViewPackage.eINSTANCE.getAbstractViewElement_Label(),
			ViewPackage.eINSTANCE.getViewContainer_OwnedElements()		);
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
				if (ViewViewsRepository.ViewContainer.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewContainer.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewContainer.Properties.label == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ViewPackage.eINSTANCE.getAbstractViewElement_Label().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ViewPackage.eINSTANCE.getAbstractViewElement_Label().getEAttributeType(), newValue);
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
