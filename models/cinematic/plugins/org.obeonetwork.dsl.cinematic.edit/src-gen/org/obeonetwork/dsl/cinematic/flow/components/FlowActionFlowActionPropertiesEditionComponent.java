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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class FlowActionFlowActionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FLOWACTION_PART = "FlowAction"; //$NON-NLS-1$

	
	/**
	 * Settings for calls ReferencesTable
	 */
	private ReferencesTableSettings callsSettings;
	
	/**
	 * Settings for operations ReferencesTable
	 */
	private ReferencesTableSettings operationsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public FlowActionFlowActionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject flowAction, String editing_mode) {
		super(editingContext, flowAction, editing_mode);
		parts = new String[] { FLOWACTION_PART };
		repositoryKey = FlowViewsRepository.class;
		partKey = FlowViewsRepository.FlowAction.class;
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
			
			final FlowAction flowAction = (FlowAction)elt;
			final FlowActionPropertiesEditionPart flowActionPart = (FlowActionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.description))
				flowActionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, flowAction.getDescription()));
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.name))
				flowActionPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, flowAction.getName()));
			
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.calls)) {
				callsSettings = new ReferencesTableSettings(flowAction, FlowPackage.eINSTANCE.getFlowAction_Calls());
				flowActionPart.initCalls(callsSettings);
			}
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.operations)) {
				operationsSettings = new ReferencesTableSettings(flowAction, FlowPackage.eINSTANCE.getFlowAction_Operations());
				flowActionPart.initOperations(operationsSettings);
			}
			// init filters
			
			
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.calls)) {
				flowActionPart.addFilterToCalls(new EObjectFilter(ViewPackage.Literals.VIEW_ACTION));
				// Start of user code for additional businessfilters for calls
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.FlowAction.Properties.operations)) {
				flowActionPart.addFilterToOperations(new EObjectFilter(EnvironmentPackage.Literals.ACTION));
				// Start of user code for additional businessfilters for operations
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
		if (editorKey == FlowViewsRepository.FlowAction.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == FlowViewsRepository.FlowAction.Properties.name) {
			return CinematicPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == FlowViewsRepository.FlowAction.Properties.calls) {
			return FlowPackage.eINSTANCE.getFlowAction_Calls();
		}
		if (editorKey == FlowViewsRepository.FlowAction.Properties.operations) {
			return FlowPackage.eINSTANCE.getFlowAction_Operations();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		FlowAction flowAction = (FlowAction)semanticObject;
		if (FlowViewsRepository.FlowAction.Properties.description == event.getAffectedEditor()) {
			flowAction.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.FlowAction.Properties.name == event.getAffectedEditor()) {
			flowAction.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.FlowAction.Properties.calls == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof ViewAction) {
					callsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				callsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				callsSettings.move(event.getNewIndex(), (ViewAction) event.getNewValue());
			}
		}
		if (FlowViewsRepository.FlowAction.Properties.operations == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Action) {
					operationsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				operationsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				operationsSettings.move(event.getNewIndex(), (Action) event.getNewValue());
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
			FlowActionPropertiesEditionPart flowActionPart = (FlowActionPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && flowActionPart != null && isAccessible(FlowViewsRepository.FlowAction.Properties.description)){
				if (msg.getNewValue() != null) {
					flowActionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					flowActionPart.setDescription("");
				}
			}
			if (CinematicPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && flowActionPart != null && isAccessible(FlowViewsRepository.FlowAction.Properties.name)) {
				if (msg.getNewValue() != null) {
					flowActionPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					flowActionPart.setName("");
				}
			}
			if (FlowPackage.eINSTANCE.getFlowAction_Calls().equals(msg.getFeature())  && isAccessible(FlowViewsRepository.FlowAction.Properties.calls))
				flowActionPart.updateCalls();
			if (FlowPackage.eINSTANCE.getFlowAction_Operations().equals(msg.getFeature())  && isAccessible(FlowViewsRepository.FlowAction.Properties.operations))
				flowActionPart.updateOperations();
			
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
			FlowPackage.eINSTANCE.getFlowAction_Calls(),
			FlowPackage.eINSTANCE.getFlowAction_Operations()		);
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
				if (FlowViewsRepository.FlowAction.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (FlowViewsRepository.FlowAction.Properties.name == event.getAffectedEditor()) {
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
