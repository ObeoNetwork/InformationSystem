/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.parts.ViewContainerReferencePropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class ViewContainerReferenceViewContainerReferencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VIEWCONTAINERREFERENCE_PART = "ViewContainerReference"; //$NON-NLS-1$

	
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
	 * Settings for viewContainer EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings viewContainerSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ViewContainerReferenceViewContainerReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject viewContainerReference, String editing_mode) {
		super(editingContext, viewContainerReference, editing_mode);
		parts = new String[] { VIEWCONTAINERREFERENCE_PART };
		repositoryKey = ViewViewsRepository.class;
		partKey = ViewViewsRepository.ViewContainerReference.class;
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
			
			final ViewContainerReference viewContainerReference = (ViewContainerReference)elt;
			final ViewContainerReferencePropertiesEditionPart viewContainerReferencePart = (ViewContainerReferencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.description))
				viewContainerReferencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainerReference.getDescription()));
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.name))
				viewContainerReferencePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainerReference.getName()));
			
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.widget)) {
				// init part
				widgetSettings = new EObjectFlatComboSettings(viewContainerReference, ViewPackage.eINSTANCE.getAbstractViewElement_Widget());
				viewContainerReferencePart.initWidget(widgetSettings);
				// set the button mode
				viewContainerReferencePart.setWidgetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.actions)) {
				actionsSettings = new ReferencesTableSettings(viewContainerReference, ViewPackage.eINSTANCE.getAbstractViewElement_Actions());
				viewContainerReferencePart.initActions(actionsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.events)) {
				eventsSettings = new ReferencesTableSettings(viewContainerReference, ViewPackage.eINSTANCE.getAbstractViewElement_Events());
				viewContainerReferencePart.initEvents(eventsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.label))
				viewContainerReferencePart.setLabel(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewContainerReference.getLabel()));
			
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.viewContainer)) {
				// init part
				viewContainerSettings = new EObjectFlatComboSettings(viewContainerReference, ViewPackage.eINSTANCE.getViewContainerReference_ViewContainer());
				viewContainerReferencePart.initViewContainer(viewContainerSettings);
				// set the button mode
				viewContainerReferencePart.setViewContainerButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.widget)) {
				viewContainerReferencePart.addFilterToWidget(new ViewerFilter() {
				
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
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.actions)) {
				viewContainerReferencePart.addFilterToActions(new ViewerFilter() {
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
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.events)) {
				viewContainerReferencePart.addFilterToEvents(new ViewerFilter() {
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
			
			if (isAccessible(ViewViewsRepository.ViewContainerReference.Properties.viewContainer)) {
				viewContainerReferencePart.addFilterToViewContainer(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof ViewContainer);
					}
					
				});
				// Start of user code for additional businessfilters for viewContainer
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
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.widget) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Widget();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.actions) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Actions();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.events) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Events();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.label) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Label();
		}
		if (editorKey == ViewViewsRepository.ViewContainerReference.Properties.viewContainer) {
			return ViewPackage.eINSTANCE.getViewContainerReference_ViewContainer();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ViewContainerReference viewContainerReference = (ViewContainerReference)semanticObject;
		if (ViewViewsRepository.ViewContainerReference.Properties.description == event.getAffectedEditor()) {
			viewContainerReference.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainerReference.Properties.name == event.getAffectedEditor()) {
			viewContainerReference.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainerReference.Properties.widget == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewContainerReference.Properties.actions == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewContainerReference.Properties.events == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewContainerReference.Properties.label == event.getAffectedEditor()) {
			viewContainerReference.setLabel((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewContainerReference.Properties.viewContainer == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				viewContainerSettings.setToReference((ViewContainer)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				ViewContainer eObject = ViewFactory.eINSTANCE.createViewContainer();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				viewContainerSettings.setToReference(eObject);
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
			ViewContainerReferencePropertiesEditionPart viewContainerReferencePart = (ViewContainerReferencePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerReferencePart != null && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.description)){
				if (msg.getNewValue() != null) {
					viewContainerReferencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerReferencePart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerReferencePart != null && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.name)) {
				if (msg.getNewValue() != null) {
					viewContainerReferencePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerReferencePart.setName("");
				}
			}
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Widget().equals(msg.getFeature()) && viewContainerReferencePart != null && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.widget))
				viewContainerReferencePart.setWidget((EObject)msg.getNewValue());
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Actions().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.actions))
				viewContainerReferencePart.updateActions();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Events().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.events))
				viewContainerReferencePart.updateEvents();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Label().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewContainerReferencePart != null && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.label)) {
				if (msg.getNewValue() != null) {
					viewContainerReferencePart.setLabel(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewContainerReferencePart.setLabel("");
				}
			}
			if (ViewPackage.eINSTANCE.getViewContainerReference_ViewContainer().equals(msg.getFeature()) && viewContainerReferencePart != null && isAccessible(ViewViewsRepository.ViewContainerReference.Properties.viewContainer))
				viewContainerReferencePart.setViewContainer((EObject)msg.getNewValue());
			
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
			ViewPackage.eINSTANCE.getViewContainerReference_ViewContainer()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ViewViewsRepository.ViewContainerReference.Properties.viewContainer;
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
				if (ViewViewsRepository.ViewContainerReference.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewContainerReference.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewContainerReference.Properties.label == event.getAffectedEditor()) {
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
