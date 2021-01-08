/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.statemachine.State;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;
import org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class StateStatePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String STATE_PART = "State"; //$NON-NLS-1$

	
	/**
	 * Settings for incomingTransitions ReferencesTable
	 */
	private ReferencesTableSettings incomingTransitionsSettings;
	
	/**
	 * Settings for outcomingTransitions ReferencesTable
	 */
	private ReferencesTableSettings outcomingTransitionsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public StateStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject state, String editing_mode) {
		super(editingContext, state, editing_mode);
		parts = new String[] { STATE_PART };
		repositoryKey = StatemachineViewsRepository.class;
		partKey = StatemachineViewsRepository.State.class;
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
			
			final State state = (State)elt;
			final StatePropertiesEditionPart statePart = (StatePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(StatemachineViewsRepository.State.Properties.description))
				statePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, state.getDescription()));
			
			if (isAccessible(StatemachineViewsRepository.State.Properties.keywords))
				statePart.setKeywords(state.getKeywords());
			
			if (isAccessible(StatemachineViewsRepository.State.Properties.incomingTransitions)) {
				incomingTransitionsSettings = new ReferencesTableSettings(state, StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions());
				statePart.initIncomingTransitions(incomingTransitionsSettings);
			}
			if (isAccessible(StatemachineViewsRepository.State.Properties.outcomingTransitions)) {
				outcomingTransitionsSettings = new ReferencesTableSettings(state, StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions());
				statePart.initOutcomingTransitions(outcomingTransitionsSettings);
			}
			if (isAccessible(StatemachineViewsRepository.State.Properties.name))
				statePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, state.getName()));
			
			// init filters
			
			
			if (isAccessible(StatemachineViewsRepository.State.Properties.incomingTransitions)) {
				statePart.addFilterToIncomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for incomingTransitions
				// End of user code
			}
			if (isAccessible(StatemachineViewsRepository.State.Properties.outcomingTransitions)) {
				statePart.addFilterToOutcomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for outcomingTransitions
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
		if (editorKey == StatemachineViewsRepository.State.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == StatemachineViewsRepository.State.Properties.keywords) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords();
		}
		if (editorKey == StatemachineViewsRepository.State.Properties.incomingTransitions) {
			return StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions();
		}
		if (editorKey == StatemachineViewsRepository.State.Properties.outcomingTransitions) {
			return StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions();
		}
		if (editorKey == StatemachineViewsRepository.State.Properties.name) {
			return StateMachinePackage.eINSTANCE.getNamedElement_Name();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		State state = (State)semanticObject;
		if (StatemachineViewsRepository.State.Properties.description == event.getAffectedEditor()) {
			state.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (StatemachineViewsRepository.State.Properties.keywords == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				state.getKeywords().clear();
				state.getKeywords().addAll(((EList) event.getNewValue()));
			}
		}
		if (StatemachineViewsRepository.State.Properties.incomingTransitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Transition) {
					incomingTransitionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				incomingTransitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				incomingTransitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
			}
		}
		if (StatemachineViewsRepository.State.Properties.outcomingTransitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Transition) {
					outcomingTransitionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				outcomingTransitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outcomingTransitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
			}
		}
		if (StatemachineViewsRepository.State.Properties.name == event.getAffectedEditor()) {
			state.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			StatePropertiesEditionPart statePart = (StatePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && statePart != null && isAccessible(StatemachineViewsRepository.State.Properties.description)) {
				if (msg.getNewValue() != null) {
					statePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					statePart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && statePart != null && isAccessible(StatemachineViewsRepository.State.Properties.keywords)) {
				if (msg.getNewValue() instanceof EList<?>) {
					statePart.setKeywords((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					statePart.setKeywords(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					statePart.setKeywords(newValueAsList);
				}
			}
			
			if (StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.State.Properties.incomingTransitions))
				statePart.updateIncomingTransitions();
			if (StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.State.Properties.outcomingTransitions))
				statePart.updateOutcomingTransitions();
			if (StateMachinePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && statePart != null && isAccessible(StatemachineViewsRepository.State.Properties.name)) {
				if (msg.getNewValue() != null) {
					statePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					statePart.setName("");
				}
			}
			
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
			StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions(),
			StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions(),
			StateMachinePackage.eINSTANCE.getNamedElement_Name()		);
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
				if (StatemachineViewsRepository.State.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (StatemachineViewsRepository.State.Properties.keywords == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (StatemachineViewsRepository.State.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(StateMachinePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(StateMachinePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
