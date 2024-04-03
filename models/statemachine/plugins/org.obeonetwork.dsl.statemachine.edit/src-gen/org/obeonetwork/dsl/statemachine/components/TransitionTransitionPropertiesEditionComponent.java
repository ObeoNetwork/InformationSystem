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
package org.obeonetwork.dsl.statemachine.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.statemachine.AbstractState;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;
import org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TransitionTransitionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TRANSITION_PART = "Transition"; //$NON-NLS-1$

	
	/**
	 * Settings for from EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings fromSettings;
	
	/**
	 * Settings for to EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings toSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TransitionTransitionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject transition, String editing_mode) {
		super(editingContext, transition, editing_mode);
		parts = new String[] { TRANSITION_PART };
		repositoryKey = StatemachineViewsRepository.class;
		partKey = StatemachineViewsRepository.Transition.class;
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
			
			final Transition transition = (Transition)elt;
			final TransitionPropertiesEditionPart transitionPart = (TransitionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.description))
				transitionPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getDescription()));
			
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.keywords))
				transitionPart.setKeywords(transition.getKeywords());
			
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.guard))
				transitionPart.setGuard(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getGuard()));
			
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.from)) {
				// init part
				fromSettings = new EObjectFlatComboSettings(transition, StateMachinePackage.eINSTANCE.getTransition_From());
				transitionPart.initFrom(fromSettings);
				// set the button mode
				transitionPart.setFromButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.to)) {
				// init part
				toSettings = new EObjectFlatComboSettings(transition, StateMachinePackage.eINSTANCE.getTransition_To());
				transitionPart.initTo(toSettings);
				// set the button mode
				transitionPart.setToButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.from)) {
				transitionPart.addFilterToFrom(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof AbstractState);
					}
					
				});
				// Start of user code for additional businessfilters for from
				// End of user code
			}
			if (isAccessible(StatemachineViewsRepository.Transition.Properties.to)) {
				transitionPart.addFilterToTo(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof AbstractState);
					}
					
				});
				// Start of user code for additional businessfilters for to
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
		if (editorKey == StatemachineViewsRepository.Transition.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == StatemachineViewsRepository.Transition.Properties.keywords) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords();
		}
		if (editorKey == StatemachineViewsRepository.Transition.Properties.guard) {
			return StateMachinePackage.eINSTANCE.getTransition_Guard();
		}
		if (editorKey == StatemachineViewsRepository.Transition.Properties.from) {
			return StateMachinePackage.eINSTANCE.getTransition_From();
		}
		if (editorKey == StatemachineViewsRepository.Transition.Properties.to) {
			return StateMachinePackage.eINSTANCE.getTransition_To();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Transition transition = (Transition)semanticObject;
		if (StatemachineViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
			transition.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (StatemachineViewsRepository.Transition.Properties.keywords == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				transition.getKeywords().clear();
				transition.getKeywords().addAll(((EList) event.getNewValue()));
			}
		}
		if (StatemachineViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
			transition.setGuard((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (StatemachineViewsRepository.Transition.Properties.from == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				fromSettings.setToReference((AbstractState)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, fromSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (StatemachineViewsRepository.Transition.Properties.to == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				toSettings.setToReference((AbstractState)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, toSettings, editingContext.getAdapterFactory());
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
			TransitionPropertiesEditionPart transitionPart = (TransitionPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(StatemachineViewsRepository.Transition.Properties.description)) {
				if (msg.getNewValue() != null) {
					transitionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(StatemachineViewsRepository.Transition.Properties.keywords)) {
				if (msg.getNewValue() instanceof EList<?>) {
					transitionPart.setKeywords((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					transitionPart.setKeywords(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					transitionPart.setKeywords(newValueAsList);
				}
			}
			
			if (StateMachinePackage.eINSTANCE.getTransition_Guard().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(StatemachineViewsRepository.Transition.Properties.guard)) {
				if (msg.getNewValue() != null) {
					transitionPart.setGuard(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setGuard("");
				}
			}
			if (StateMachinePackage.eINSTANCE.getTransition_From().equals(msg.getFeature()) && transitionPart != null && isAccessible(StatemachineViewsRepository.Transition.Properties.from))
				transitionPart.setFrom((EObject)msg.getNewValue());
			if (StateMachinePackage.eINSTANCE.getTransition_To().equals(msg.getFeature()) && transitionPart != null && isAccessible(StatemachineViewsRepository.Transition.Properties.to))
				transitionPart.setTo((EObject)msg.getNewValue());
			
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords(),
			StateMachinePackage.eINSTANCE.getTransition_Guard(),
			StateMachinePackage.eINSTANCE.getTransition_From(),
			StateMachinePackage.eINSTANCE.getTransition_To()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == StatemachineViewsRepository.Transition.Properties.from || key == StatemachineViewsRepository.Transition.Properties.to;
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
				if (StatemachineViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (StatemachineViewsRepository.Transition.Properties.keywords == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (StatemachineViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(StateMachinePackage.eINSTANCE.getTransition_Guard().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(StateMachinePackage.eINSTANCE.getTransition_Guard().getEAttributeType(), newValue);
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
