/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
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
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


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
	 * Settings for on ReferencesTable
	 */
	private ReferencesTableSettings onSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TransitionTransitionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject transition, String editing_mode) {
		super(editingContext, transition, editing_mode);
		parts = new String[] { TRANSITION_PART };
		repositoryKey = FlowViewsRepository.class;
		partKey = FlowViewsRepository.Transition.class;
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
			if (isAccessible(FlowViewsRepository.Transition.Properties.description))
				transitionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getDescription()));
			if (isAccessible(FlowViewsRepository.Transition.Properties.name))
				transitionPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getName()));
			
			if (isAccessible(FlowViewsRepository.Transition.Properties.guard))
				transitionPart.setGuard(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getGuard()));
			
			if (isAccessible(FlowViewsRepository.Transition.Properties.modal)) {
				transitionPart.setModal(transition.isModal());
			}
			if (isAccessible(FlowViewsRepository.Transition.Properties.from)) {
				// init part
				fromSettings = new EObjectFlatComboSettings(transition, FlowPackage.eINSTANCE.getTransition_From());
				transitionPart.initFrom(fromSettings);
				// set the button mode
				transitionPart.setFromButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(FlowViewsRepository.Transition.Properties.to)) {
				// init part
				toSettings = new EObjectFlatComboSettings(transition, FlowPackage.eINSTANCE.getTransition_To());
				transitionPart.initTo(toSettings);
				// set the button mode
				transitionPart.setToButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(FlowViewsRepository.Transition.Properties.on)) {
				onSettings = new ReferencesTableSettings(transition, FlowPackage.eINSTANCE.getTransition_On());
				transitionPart.initOn(onSettings);
			}
			// init filters
			
			
			
			
			if (isAccessible(FlowViewsRepository.Transition.Properties.from)) {
				transitionPart.addFilterToFrom(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowState); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for from
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.Transition.Properties.to)) {
				transitionPart.addFilterToTo(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowState); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for to
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.Transition.Properties.on)) {
				transitionPart.addFilterToOn(new EObjectFilter(CinematicPackage.Literals.EVENT));
				// Start of user code for additional businessfilters for on
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
		if (editorKey == FlowViewsRepository.Transition.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.guard) {
			return FlowPackage.eINSTANCE.getTransition_Guard();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.modal) {
			return FlowPackage.eINSTANCE.getTransition_Modal();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.from) {
			return FlowPackage.eINSTANCE.getTransition_From();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.to) {
			return FlowPackage.eINSTANCE.getTransition_To();
		}
		if (editorKey == FlowViewsRepository.Transition.Properties.on) {
			return FlowPackage.eINSTANCE.getTransition_On();
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
		if (FlowViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
			transition.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.Transition.Properties.name == event.getAffectedEditor()) {
			transition.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
			transition.setGuard((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.Transition.Properties.modal == event.getAffectedEditor()) {
			transition.setModal((Boolean)event.getNewValue());
		}
		if (FlowViewsRepository.Transition.Properties.from == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				fromSettings.setToReference((FlowState)event.getNewValue());
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
		if (FlowViewsRepository.Transition.Properties.to == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				toSettings.setToReference((FlowState)event.getNewValue());
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
		if (FlowViewsRepository.Transition.Properties.on == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Event) {
					onSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				onSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				onSettings.move(event.getNewIndex(), (Event) event.getNewValue());
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
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.description)){
				if (msg.getNewValue() != null) {
					transitionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.name)) {
				if (msg.getNewValue() != null) {
					transitionPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setName("");
				}
			}
			if (FlowPackage.eINSTANCE.getTransition_Guard().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.guard)) {
				if (msg.getNewValue() != null) {
					transitionPart.setGuard(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setGuard("");
				}
			}
			if (FlowPackage.eINSTANCE.getTransition_Modal().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.modal))
				transitionPart.setModal((Boolean)msg.getNewValue());
			
			if (FlowPackage.eINSTANCE.getTransition_From().equals(msg.getFeature()) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.from))
				transitionPart.setFrom((EObject)msg.getNewValue());
			if (FlowPackage.eINSTANCE.getTransition_To().equals(msg.getFeature()) && transitionPart != null && isAccessible(FlowViewsRepository.Transition.Properties.to))
				transitionPart.setTo((EObject)msg.getNewValue());
			if (FlowPackage.eINSTANCE.getTransition_On().equals(msg.getFeature())  && isAccessible(FlowViewsRepository.Transition.Properties.on))
				transitionPart.updateOn();
			
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
			FlowPackage.eINSTANCE.getTransition_Guard(),
			FlowPackage.eINSTANCE.getTransition_Modal(),
			FlowPackage.eINSTANCE.getTransition_From(),
			FlowPackage.eINSTANCE.getTransition_To(),
			FlowPackage.eINSTANCE.getTransition_On()		);
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
				if (FlowViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.Transition.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CinematicPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(FlowPackage.eINSTANCE.getTransition_Guard().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(FlowPackage.eINSTANCE.getTransition_Guard().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.Transition.Properties.modal == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(FlowPackage.eINSTANCE.getTransition_Modal().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(FlowPackage.eINSTANCE.getTransition_Modal().getEAttributeType(), newValue);
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
