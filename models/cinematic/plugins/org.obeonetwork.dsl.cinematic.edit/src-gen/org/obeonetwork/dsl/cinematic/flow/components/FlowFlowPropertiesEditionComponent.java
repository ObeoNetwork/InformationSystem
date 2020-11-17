/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class FlowFlowPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FLOW_PART = "Flow"; //$NON-NLS-1$

	
	/**
	 * Settings for states ReferencesTable
	 */
	protected ReferencesTableSettings statesSettings;
	
	/**
	 * Settings for transitions ReferencesTable
	 */
	protected ReferencesTableSettings transitionsSettings;
	
	/**
	 * Settings for events ReferencesTable
	 */
	protected ReferencesTableSettings eventsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public FlowFlowPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject flow, String editing_mode) {
		super(editingContext, flow, editing_mode);
		parts = new String[] { FLOW_PART };
		repositoryKey = FlowViewsRepository.class;
		partKey = FlowViewsRepository.Flow_.class;
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
			
			final Flow flow = (Flow)elt;
			final FlowPropertiesEditionPart flowPart = (FlowPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(FlowViewsRepository.Flow_.Properties.description))
				flowPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, flow.getDescription()));
			if (isAccessible(FlowViewsRepository.Flow_.Properties.name))
				flowPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, flow.getName()));
			
			if (isAccessible(FlowViewsRepository.Flow_.Properties.states)) {
				statesSettings = new ReferencesTableSettings(flow, FlowPackage.eINSTANCE.getFlow_States());
				flowPart.initStates(statesSettings);
			}
			if (isAccessible(FlowViewsRepository.Flow_.Properties.transitions)) {
				transitionsSettings = new ReferencesTableSettings(flow, FlowPackage.eINSTANCE.getFlow_Transitions());
				flowPart.initTransitions(transitionsSettings);
			}
			if (isAccessible(FlowViewsRepository.Flow_.Properties.events)) {
				eventsSettings = new ReferencesTableSettings(flow, FlowPackage.eINSTANCE.getFlow_Events());
				flowPart.initEvents(eventsSettings);
			}
			// init filters
			
			
			if (isAccessible(FlowViewsRepository.Flow_.Properties.states)) {
				flowPart.addFilterToStates(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowState); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for states
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.Flow_.Properties.transitions)) {
				flowPart.addFilterToTransitions(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Transition); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for transitions
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.Flow_.Properties.events)) {
				flowPart.addFilterToEvents(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowEvent); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for events
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
		if (editorKey == FlowViewsRepository.Flow_.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == FlowViewsRepository.Flow_.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == FlowViewsRepository.Flow_.Properties.states) {
			return FlowPackage.eINSTANCE.getFlow_States();
		}
		if (editorKey == FlowViewsRepository.Flow_.Properties.transitions) {
			return FlowPackage.eINSTANCE.getFlow_Transitions();
		}
		if (editorKey == FlowViewsRepository.Flow_.Properties.events) {
			return FlowPackage.eINSTANCE.getFlow_Events();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Flow flow = (Flow)semanticObject;
		if (FlowViewsRepository.Flow_.Properties.description == event.getAffectedEditor()) {
			flow.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.Flow_.Properties.name == event.getAffectedEditor()) {
			flow.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.Flow_.Properties.states == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, statesSettings, editingContext.getAdapterFactory());
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
				statesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				statesSettings.move(event.getNewIndex(), (FlowState) event.getNewValue());
			}
		}
		if (FlowViewsRepository.Flow_.Properties.transitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, transitionsSettings, editingContext.getAdapterFactory());
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
				transitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				transitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
			}
		}
		if (FlowViewsRepository.Flow_.Properties.events == event.getAffectedEditor()) {
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
				eventsSettings.move(event.getNewIndex(), (FlowEvent) event.getNewValue());
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
			FlowPropertiesEditionPart flowPart = (FlowPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && flowPart != null && isAccessible(FlowViewsRepository.Flow_.Properties.description)){
				if (msg.getNewValue() != null) {
					flowPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					flowPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && flowPart != null && isAccessible(FlowViewsRepository.Flow_.Properties.name)) {
				if (msg.getNewValue() != null) {
					flowPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					flowPart.setName("");
				}
			}
			if (FlowPackage.eINSTANCE.getFlow_States().equals(msg.getFeature()) && isAccessible(FlowViewsRepository.Flow_.Properties.states))
				flowPart.updateStates();
			if (FlowPackage.eINSTANCE.getFlow_Transitions().equals(msg.getFeature()) && isAccessible(FlowViewsRepository.Flow_.Properties.transitions))
				flowPart.updateTransitions();
			if (FlowPackage.eINSTANCE.getFlow_Events().equals(msg.getFeature()) && isAccessible(FlowViewsRepository.Flow_.Properties.events))
				flowPart.updateEvents();
			
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
			FlowPackage.eINSTANCE.getFlow_States(),
			FlowPackage.eINSTANCE.getFlow_Transitions(),
			FlowPackage.eINSTANCE.getFlow_Events()		);
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
				if (FlowViewsRepository.Flow_.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.Flow_.Properties.name == event.getAffectedEditor()) {
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
