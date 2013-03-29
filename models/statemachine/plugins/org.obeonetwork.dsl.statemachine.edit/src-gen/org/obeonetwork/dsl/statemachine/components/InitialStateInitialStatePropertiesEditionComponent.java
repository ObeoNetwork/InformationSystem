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
import org.obeonetwork.dsl.statemachine.InitialState;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;
import org.obeonetwork.dsl.statemachine.parts.InitialStatePropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class InitialStateInitialStatePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INITIALSTATE_PART = "InitialState"; //$NON-NLS-1$

	
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
	public InitialStateInitialStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject initialState, String editing_mode) {
		super(editingContext, initialState, editing_mode);
		parts = new String[] { INITIALSTATE_PART };
		repositoryKey = StatemachineViewsRepository.class;
		partKey = StatemachineViewsRepository.InitialState.class;
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
			
			final InitialState initialState = (InitialState)elt;
			final InitialStatePropertiesEditionPart initialStatePart = (InitialStatePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.description))
				initialStatePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, initialState.getDescription()));
			
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.keywords))
				initialStatePart.setKeywords(initialState.getKeywords());
			
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.incomingTransitions)) {
				incomingTransitionsSettings = new ReferencesTableSettings(initialState, StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions());
				initialStatePart.initIncomingTransitions(incomingTransitionsSettings);
			}
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.outcomingTransitions)) {
				outcomingTransitionsSettings = new ReferencesTableSettings(initialState, StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions());
				initialStatePart.initOutcomingTransitions(outcomingTransitionsSettings);
			}
			// init filters
			
			
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.incomingTransitions)) {
				initialStatePart.addFilterToIncomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for incomingTransitions
				// End of user code
			}
			if (isAccessible(StatemachineViewsRepository.InitialState.Properties.outcomingTransitions)) {
				initialStatePart.addFilterToOutcomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
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
		if (editorKey == StatemachineViewsRepository.InitialState.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == StatemachineViewsRepository.InitialState.Properties.keywords) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords();
		}
		if (editorKey == StatemachineViewsRepository.InitialState.Properties.incomingTransitions) {
			return StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions();
		}
		if (editorKey == StatemachineViewsRepository.InitialState.Properties.outcomingTransitions) {
			return StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		InitialState initialState = (InitialState)semanticObject;
		if (StatemachineViewsRepository.InitialState.Properties.description == event.getAffectedEditor()) {
			initialState.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (StatemachineViewsRepository.InitialState.Properties.keywords == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				initialState.getKeywords().clear();
				initialState.getKeywords().addAll(((EList) event.getNewValue()));
			}
		}
		if (StatemachineViewsRepository.InitialState.Properties.incomingTransitions == event.getAffectedEditor()) {
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
		if (StatemachineViewsRepository.InitialState.Properties.outcomingTransitions == event.getAffectedEditor()) {
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
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InitialStatePropertiesEditionPart initialStatePart = (InitialStatePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && initialStatePart != null && isAccessible(StatemachineViewsRepository.InitialState.Properties.description)) {
				if (msg.getNewValue() != null) {
					initialStatePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					initialStatePart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && initialStatePart != null && isAccessible(StatemachineViewsRepository.InitialState.Properties.keywords)) {
				if (msg.getNewValue() instanceof EList<?>) {
					initialStatePart.setKeywords((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					initialStatePart.setKeywords(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					initialStatePart.setKeywords(newValueAsList);
				}
			}
			
			if (StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.InitialState.Properties.incomingTransitions))
				initialStatePart.updateIncomingTransitions();
			if (StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.InitialState.Properties.outcomingTransitions))
				initialStatePart.updateOutcomingTransitions();
			
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
			StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions()		);
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
				if (StatemachineViewsRepository.InitialState.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (StatemachineViewsRepository.InitialState.Properties.keywords == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEAttributeType(), iterator.next()));
					}
					ret = chain;
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
