/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.statemachine.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.statemachine.FinalState;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;
import org.obeonetwork.dsl.statemachine.parts.FinalStatePropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class FinalStateFinalStatePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FINALSTATE_PART = "FinalState"; //$NON-NLS-1$

	
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
	public FinalStateFinalStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject finalState, String editing_mode) {
		super(editingContext, finalState, editing_mode);
		parts = new String[] { FINALSTATE_PART };
		repositoryKey = StatemachineViewsRepository.class;
		partKey = StatemachineViewsRepository.FinalState.class;
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
			
			final FinalState finalState = (FinalState)elt;
			final FinalStatePropertiesEditionPart finalStatePart = (FinalStatePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.description))
				finalStatePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, finalState.getDescription()));
			
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.keywords))
				finalStatePart.setKeywords(finalState.getKeywords());
			
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.incomingTransitions)) {
				incomingTransitionsSettings = new ReferencesTableSettings(finalState, StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions());
				finalStatePart.initIncomingTransitions(incomingTransitionsSettings);
			}
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.outcomingTransitions)) {
				outcomingTransitionsSettings = new ReferencesTableSettings(finalState, StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions());
				finalStatePart.initOutcomingTransitions(outcomingTransitionsSettings);
			}
			// init filters
			
			
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.incomingTransitions)) {
				finalStatePart.addFilterToIncomingTransitions(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!finalStatePart.isContainedInIncomingTransitionsTable((EObject)element));
						return element instanceof Resource;
					}
				
				});
				finalStatePart.addFilterToIncomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for incomingTransitions
				// End of user code
			}
			if (isAccessible(StatemachineViewsRepository.FinalState.Properties.outcomingTransitions)) {
				finalStatePart.addFilterToOutcomingTransitions(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!finalStatePart.isContainedInOutcomingTransitionsTable((EObject)element));
						return element instanceof Resource;
					}
				
				});
				finalStatePart.addFilterToOutcomingTransitions(new EObjectFilter(StateMachinePackage.Literals.TRANSITION));
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
		if (editorKey == StatemachineViewsRepository.FinalState.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == StatemachineViewsRepository.FinalState.Properties.keywords) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords();
		}
		if (editorKey == StatemachineViewsRepository.FinalState.Properties.incomingTransitions) {
			return StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions();
		}
		if (editorKey == StatemachineViewsRepository.FinalState.Properties.outcomingTransitions) {
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
		FinalState finalState = (FinalState)semanticObject;
		if (StatemachineViewsRepository.FinalState.Properties.description == event.getAffectedEditor()) {
			finalState.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (StatemachineViewsRepository.FinalState.Properties.keywords == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				finalState.getKeywords().clear();
				finalState.getKeywords().addAll(((EList) event.getNewValue()));
			}
		}
		if (StatemachineViewsRepository.FinalState.Properties.incomingTransitions == event.getAffectedEditor()) {
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
		if (StatemachineViewsRepository.FinalState.Properties.outcomingTransitions == event.getAffectedEditor()) {
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
			FinalStatePropertiesEditionPart finalStatePart = (FinalStatePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && finalStatePart != null && isAccessible(StatemachineViewsRepository.FinalState.Properties.description)) {
				if (msg.getNewValue() != null) {
					finalStatePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					finalStatePart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && finalStatePart != null && isAccessible(StatemachineViewsRepository.FinalState.Properties.keywords)) {
				finalStatePart.setKeywords((EList<?>)msg.getNewValue());
			}
			
			if (StateMachinePackage.eINSTANCE.getAbstractState_IncomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.FinalState.Properties.incomingTransitions))
				finalStatePart.updateIncomingTransitions();
			if (StateMachinePackage.eINSTANCE.getAbstractState_OutcomingTransitions().equals(msg.getFeature())  && isAccessible(StatemachineViewsRepository.FinalState.Properties.outcomingTransitions))
				finalStatePart.updateOutcomingTransitions();
			
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
				if (StatemachineViewsRepository.FinalState.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (StatemachineViewsRepository.FinalState.Properties.keywords == event.getAffectedEditor()) {
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
