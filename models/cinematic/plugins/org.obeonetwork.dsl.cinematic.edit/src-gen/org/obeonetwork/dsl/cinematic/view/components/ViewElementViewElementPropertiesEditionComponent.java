/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.parts.ViewElementPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Type;


// End of user code

/**
 * 
 * 
 */
public class ViewElementViewElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VIEWELEMENT_PART = "ViewElement"; //$NON-NLS-1$

	
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
	 * Settings for type EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings typeSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ViewElementViewElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject viewElement, String editing_mode) {
		super(editingContext, viewElement, editing_mode);
		parts = new String[] { VIEWELEMENT_PART };
		repositoryKey = ViewViewsRepository.class;
		partKey = ViewViewsRepository.ViewElement.class;
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
			
			final ViewElement viewElement = (ViewElement)elt;
			final ViewElementPropertiesEditionPart viewElementPart = (ViewElementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.description))
				viewElementPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, viewElement.getDescription()));
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.name))
				viewElementPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewElement.getName()));
			
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.widget)) {
				// init part
				widgetSettings = new EObjectFlatComboSettings(viewElement, ViewPackage.eINSTANCE.getAbstractViewElement_Widget());
				viewElementPart.initWidget(widgetSettings);
				// set the button mode
				viewElementPart.setWidgetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.actions)) {
				actionsSettings = new ReferencesTableSettings(viewElement, ViewPackage.eINSTANCE.getAbstractViewElement_Actions());
				viewElementPart.initActions(actionsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.events)) {
				eventsSettings = new ReferencesTableSettings(viewElement, ViewPackage.eINSTANCE.getAbstractViewElement_Events());
				viewElementPart.initEvents(eventsSettings);
			}
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.label))
				viewElementPart.setLabel(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewElement.getLabel()));
			
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.required)) {
				viewElementPart.setRequired(viewElement.isRequired());
			}
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.type)) {
				// init part
				typeSettings = new EObjectFlatComboSettings(viewElement, ViewPackage.eINSTANCE.getViewElement_Type());
				viewElementPart.initType(typeSettings);
				// set the button mode
				viewElementPart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.widget)) {
				viewElementPart.addFilterToWidget(new ViewerFilter() {
				
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
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.actions)) {
				viewElementPart.addFilterToActions(new ViewerFilter() {
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
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.events)) {
				viewElementPart.addFilterToEvents(new ViewerFilter() {
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
			
			
			if (isAccessible(ViewViewsRepository.ViewElement.Properties.type)) {
				viewElementPart.addFilterToType(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Type); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for type
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
		if (editorKey == ViewViewsRepository.ViewElement.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.widget) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Widget();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.actions) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Actions();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.events) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Events();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.label) {
			return ViewPackage.eINSTANCE.getAbstractViewElement_Label();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.required) {
			return ViewPackage.eINSTANCE.getViewElement_Required();
		}
		if (editorKey == ViewViewsRepository.ViewElement.Properties.type) {
			return ViewPackage.eINSTANCE.getViewElement_Type();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ViewElement viewElement = (ViewElement)semanticObject;
		if (ViewViewsRepository.ViewElement.Properties.description == event.getAffectedEditor()) {
			viewElement.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewElement.Properties.name == event.getAffectedEditor()) {
			viewElement.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewElement.Properties.widget == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewElement.Properties.actions == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewElement.Properties.events == event.getAffectedEditor()) {
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
		if (ViewViewsRepository.ViewElement.Properties.label == event.getAffectedEditor()) {
			viewElement.setLabel((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.ViewElement.Properties.required == event.getAffectedEditor()) {
			viewElement.setRequired((Boolean)event.getNewValue());
		}
		if (ViewViewsRepository.ViewElement.Properties.type == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				typeSettings.setToReference((Type)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, typeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
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
			ViewElementPropertiesEditionPart viewElementPart = (ViewElementPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.description)){
				if (msg.getNewValue() != null) {
					viewElementPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewElementPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.name)) {
				if (msg.getNewValue() != null) {
					viewElementPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewElementPart.setName("");
				}
			}
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Widget().equals(msg.getFeature()) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.widget))
				viewElementPart.setWidget((EObject)msg.getNewValue());
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Actions().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewElement.Properties.actions))
				viewElementPart.updateActions();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Events().equals(msg.getFeature()) && isAccessible(ViewViewsRepository.ViewElement.Properties.events))
				viewElementPart.updateEvents();
			if (ViewPackage.eINSTANCE.getAbstractViewElement_Label().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.label)) {
				if (msg.getNewValue() != null) {
					viewElementPart.setLabel(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewElementPart.setLabel("");
				}
			}
			if (ViewPackage.eINSTANCE.getViewElement_Required().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.required))
				viewElementPart.setRequired((Boolean)msg.getNewValue());
			
			if (ViewPackage.eINSTANCE.getViewElement_Type().equals(msg.getFeature()) && viewElementPart != null && isAccessible(ViewViewsRepository.ViewElement.Properties.type))
				viewElementPart.setType((EObject)msg.getNewValue());
			
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
			ViewPackage.eINSTANCE.getViewElement_Required(),
			ViewPackage.eINSTANCE.getViewElement_Type()		);
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
				if (ViewViewsRepository.ViewElement.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewElement.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewElement.Properties.label == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ViewPackage.eINSTANCE.getAbstractViewElement_Label().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ViewPackage.eINSTANCE.getAbstractViewElement_Label().getEAttributeType(), newValue);
				}
				if (ViewViewsRepository.ViewElement.Properties.required == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ViewPackage.eINSTANCE.getViewElement_Required().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ViewPackage.eINSTANCE.getViewElement_Required().getEAttributeType(), newValue);
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
