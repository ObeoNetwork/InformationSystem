/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
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
package org.obeonetwork.dsl.cinematic.flow.components;

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
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class ViewStateViewStatePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VIEWSTATE_PART = "ViewState"; //$NON-NLS-1$

	
	/**
	 * Settings for actions ReferencesTable
	 */
	protected ReferencesTableSettings actionsSettings;
	
	/**
	 * Settings for viewContainers ReferencesTable
	 */
	private ReferencesTableSettings viewContainersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ViewStateViewStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject viewState, String editing_mode) {
		super(editingContext, viewState, editing_mode);
		parts = new String[] { VIEWSTATE_PART };
		repositoryKey = FlowViewsRepository.class;
		partKey = FlowViewsRepository.ViewState.class;
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
			
			final ViewState viewState = (ViewState)elt;
			final ViewStatePropertiesEditionPart viewStatePart = (ViewStatePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(FlowViewsRepository.ViewState.Properties.description))
				viewStatePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, viewState.getDescription()));
			if (isAccessible(FlowViewsRepository.ViewState.Properties.actions)) {
				actionsSettings = new ReferencesTableSettings(viewState, FlowPackage.eINSTANCE.getFlowState_Actions());
				viewStatePart.initActions(actionsSettings);
			}
			if (isAccessible(FlowViewsRepository.ViewState.Properties.name))
				viewStatePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, viewState.getName()));
			
			if (isAccessible(FlowViewsRepository.ViewState.Properties.newInstance)) {
				viewStatePart.setNewInstance(viewState.isNewInstance());
			}
			if (isAccessible(FlowViewsRepository.ViewState.Properties.refresh)) {
				viewStatePart.setRefresh(viewState.isRefresh());
			}
			if (isAccessible(FlowViewsRepository.ViewState.Properties.viewContainers)) {
				viewContainersSettings = new ReferencesTableSettings(viewState, FlowPackage.eINSTANCE.getViewState_ViewContainers());
				viewStatePart.initViewContainers(viewContainersSettings);
			}
			// init filters
			
			if (isAccessible(FlowViewsRepository.ViewState.Properties.actions)) {
				viewStatePart.addFilterToActions(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowAction); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for actions
				// End of user code
			}
			
			
			
			if (isAccessible(FlowViewsRepository.ViewState.Properties.viewContainers)) {
				viewStatePart.addFilterToViewContainers(new EObjectFilter(ViewPackage.Literals.VIEW_CONTAINER));
				// Start of user code for additional businessfilters for viewContainers
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
		if (editorKey == FlowViewsRepository.ViewState.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == FlowViewsRepository.ViewState.Properties.actions) {
			return FlowPackage.eINSTANCE.getFlowState_Actions();
		}
		if (editorKey == FlowViewsRepository.ViewState.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == FlowViewsRepository.ViewState.Properties.newInstance) {
			return FlowPackage.eINSTANCE.getViewState_NewInstance();
		}
		if (editorKey == FlowViewsRepository.ViewState.Properties.refresh) {
			return FlowPackage.eINSTANCE.getViewState_Refresh();
		}
		if (editorKey == FlowViewsRepository.ViewState.Properties.viewContainers) {
			return FlowPackage.eINSTANCE.getViewState_ViewContainers();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ViewState viewState = (ViewState)semanticObject;
		if (FlowViewsRepository.ViewState.Properties.description == event.getAffectedEditor()) {
			viewState.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.ViewState.Properties.actions == event.getAffectedEditor()) {
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
				actionsSettings.move(event.getNewIndex(), (FlowAction) event.getNewValue());
			}
		}
		if (FlowViewsRepository.ViewState.Properties.name == event.getAffectedEditor()) {
			viewState.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.ViewState.Properties.newInstance == event.getAffectedEditor()) {
			viewState.setNewInstance((Boolean)event.getNewValue());
		}
		if (FlowViewsRepository.ViewState.Properties.refresh == event.getAffectedEditor()) {
			viewState.setRefresh((Boolean)event.getNewValue());
		}
		if (FlowViewsRepository.ViewState.Properties.viewContainers == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof ViewContainer) {
					viewContainersSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				viewContainersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				viewContainersSettings.move(event.getNewIndex(), (ViewContainer) event.getNewValue());
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
			ViewStatePropertiesEditionPart viewStatePart = (ViewStatePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewStatePart != null && isAccessible(FlowViewsRepository.ViewState.Properties.description)){
				if (msg.getNewValue() != null) {
					viewStatePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewStatePart.setDescription("");
				}
			}
			if (FlowPackage.eINSTANCE.getFlowState_Actions().equals(msg.getFeature()) && isAccessible(FlowViewsRepository.ViewState.Properties.actions))
				viewStatePart.updateActions();
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewStatePart != null && isAccessible(FlowViewsRepository.ViewState.Properties.name)) {
				if (msg.getNewValue() != null) {
					viewStatePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewStatePart.setName("");
				}
			}
			if (FlowPackage.eINSTANCE.getViewState_NewInstance().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewStatePart != null && isAccessible(FlowViewsRepository.ViewState.Properties.newInstance))
				viewStatePart.setNewInstance((Boolean)msg.getNewValue());
			
			if (FlowPackage.eINSTANCE.getViewState_Refresh().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewStatePart != null && isAccessible(FlowViewsRepository.ViewState.Properties.refresh))
				viewStatePart.setRefresh((Boolean)msg.getNewValue());
			
			if (FlowPackage.eINSTANCE.getViewState_ViewContainers().equals(msg.getFeature())  && isAccessible(FlowViewsRepository.ViewState.Properties.viewContainers))
				viewStatePart.updateViewContainers();
			
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
			FlowPackage.eINSTANCE.getFlowState_Actions(),
			CinematicPackage.eINSTANCE.getNamedElement_Name(),
			FlowPackage.eINSTANCE.getViewState_NewInstance(),
			FlowPackage.eINSTANCE.getViewState_Refresh(),
			FlowPackage.eINSTANCE.getViewState_ViewContainers()		);
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
				if (FlowViewsRepository.ViewState.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.ViewState.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.ViewState.Properties.newInstance == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(FlowPackage.eINSTANCE.getViewState_NewInstance().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(FlowPackage.eINSTANCE.getViewState_NewInstance().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.ViewState.Properties.refresh == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(FlowPackage.eINSTANCE.getViewState_Refresh().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(FlowPackage.eINSTANCE.getViewState_Refresh().getEAttributeType(), newValue);
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
