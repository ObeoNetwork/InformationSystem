/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.components;

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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.TransitionKind;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TransitionPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TransitionTransitionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TRANSITION_PART = "Transition"; //$NON-NLS-1$

	
	/**
	 * Settings for source EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sourceSettings;
	
	/**
	 * Settings for target EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings targetSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TransitionTransitionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject transition, String editing_mode) {
		super(editingContext, transition, editing_mode);
		parts = new String[] { TRANSITION_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.Transition.class;
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
			if (isAccessible(GraalViewsRepository.Transition.Properties.description))
				transitionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getDescription()));
			if (isAccessible(GraalViewsRepository.Transition.Properties.guard))
				transitionPart.setGuard(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transition.getGuard()));
			
			if (isAccessible(GraalViewsRepository.Transition.Properties.source)) {
				// init part
				sourceSettings = new EObjectFlatComboSettings(transition, GraalPackage.eINSTANCE.getTransition_Source());
				transitionPart.initSource(sourceSettings);
				// set the button mode
				transitionPart.setSourceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(GraalViewsRepository.Transition.Properties.target)) {
				// init part
				targetSettings = new EObjectFlatComboSettings(transition, GraalPackage.eINSTANCE.getTransition_Target());
				transitionPart.initTarget(targetSettings);
				// set the button mode
				transitionPart.setTargetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(GraalViewsRepository.Transition.Properties.kind)) {
				transitionPart.initKind(EEFUtils.choiceOfValues(transition, GraalPackage.eINSTANCE.getTransition_Kind()), transition.getKind());
			}
			// init filters
			
			
			if (isAccessible(GraalViewsRepository.Transition.Properties.source)) {
				transitionPart.addFilterToSource(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Node);
					}
					
				});
				// Start of user code for additional businessfilters for source
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.Transition.Properties.target)) {
				transitionPart.addFilterToTarget(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Node);
					}
					
				});
				// Start of user code for additional businessfilters for target
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
		if (editorKey == GraalViewsRepository.Transition.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.Transition.Properties.guard) {
			return GraalPackage.eINSTANCE.getTransition_Guard();
		}
		if (editorKey == GraalViewsRepository.Transition.Properties.source) {
			return GraalPackage.eINSTANCE.getTransition_Source();
		}
		if (editorKey == GraalViewsRepository.Transition.Properties.target) {
			return GraalPackage.eINSTANCE.getTransition_Target();
		}
		if (editorKey == GraalViewsRepository.Transition.Properties.kind) {
			return GraalPackage.eINSTANCE.getTransition_Kind();
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
		if (GraalViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
			transition.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
			transition.setGuard((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Transition.Properties.source == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sourceSettings.setToReference((Node)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, sourceSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (GraalViewsRepository.Transition.Properties.target == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				targetSettings.setToReference((Node)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, targetSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (GraalViewsRepository.Transition.Properties.kind == event.getAffectedEditor()) {
			transition.setKind((TransitionKind)event.getNewValue());
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
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(GraalViewsRepository.Transition.Properties.description)){
				if (msg.getNewValue() != null) {
					transitionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getTransition_Guard().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && transitionPart != null && isAccessible(GraalViewsRepository.Transition.Properties.guard)) {
				if (msg.getNewValue() != null) {
					transitionPart.setGuard(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					transitionPart.setGuard("");
				}
			}
			if (GraalPackage.eINSTANCE.getTransition_Source().equals(msg.getFeature()) && transitionPart != null && isAccessible(GraalViewsRepository.Transition.Properties.source))
				transitionPart.setSource((EObject)msg.getNewValue());
			if (GraalPackage.eINSTANCE.getTransition_Target().equals(msg.getFeature()) && transitionPart != null && isAccessible(GraalViewsRepository.Transition.Properties.target))
				transitionPart.setTarget((EObject)msg.getNewValue());
			if (GraalPackage.eINSTANCE.getTransition_Kind().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(GraalViewsRepository.Transition.Properties.kind))
				transitionPart.setKind((TransitionKind)msg.getNewValue());
			
			
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
			GraalPackage.eINSTANCE.getTransition_Guard(),
			GraalPackage.eINSTANCE.getTransition_Source(),
			GraalPackage.eINSTANCE.getTransition_Target(),
			GraalPackage.eINSTANCE.getTransition_Kind()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == GraalViewsRepository.Transition.Properties.source || key == GraalViewsRepository.Transition.Properties.target || key == GraalViewsRepository.Transition.Properties.kind;
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
				if (GraalViewsRepository.Transition.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Transition.Properties.guard == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getTransition_Guard().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getTransition_Guard().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Transition.Properties.kind == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getTransition_Kind().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getTransition_Kind().getEAttributeType(), newValue);
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
