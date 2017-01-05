/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.InitialNode;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.InitialNodePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class InitialNodeInitialNodePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INITIALNODE_PART = "InitialNode"; //$NON-NLS-1$

	
	/**
	 * Settings for outgoingTransitions ReferencesTable
	 */
	private ReferencesTableSettings outgoingTransitionsSettings;
	
	/**
	 * Settings for incomingTransitions ReferencesTable
	 */
	private ReferencesTableSettings incomingTransitionsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public InitialNodeInitialNodePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject initialNode, String editing_mode) {
		super(editingContext, initialNode, editing_mode);
		parts = new String[] { INITIALNODE_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.InitialNode.class;
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
			
			final InitialNode initialNode = (InitialNode)elt;
			final InitialNodePropertiesEditionPart initialNodePart = (InitialNodePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.InitialNode.Properties.description))
				initialNodePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, initialNode.getDescription()));
			if (isAccessible(GraalViewsRepository.InitialNode.Properties.outgoingTransitions)) {
				outgoingTransitionsSettings = new ReferencesTableSettings(initialNode, GraalPackage.eINSTANCE.getNode_OutgoingTransitions());
				initialNodePart.initOutgoingTransitions(outgoingTransitionsSettings);
			}
			if (isAccessible(GraalViewsRepository.InitialNode.Properties.incomingTransitions)) {
				incomingTransitionsSettings = new ReferencesTableSettings(initialNode, GraalPackage.eINSTANCE.getNode_IncomingTransitions());
				initialNodePart.initIncomingTransitions(incomingTransitionsSettings);
			}
			// init filters
			
			if (isAccessible(GraalViewsRepository.InitialNode.Properties.outgoingTransitions)) {
				initialNodePart.addFilterToOutgoingTransitions(new EObjectFilter(GraalPackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for outgoingTransitions
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.InitialNode.Properties.incomingTransitions)) {
				initialNodePart.addFilterToIncomingTransitions(new EObjectFilter(GraalPackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for incomingTransitions
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
		if (editorKey == GraalViewsRepository.InitialNode.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.InitialNode.Properties.outgoingTransitions) {
			return GraalPackage.eINSTANCE.getNode_OutgoingTransitions();
		}
		if (editorKey == GraalViewsRepository.InitialNode.Properties.incomingTransitions) {
			return GraalPackage.eINSTANCE.getNode_IncomingTransitions();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		InitialNode initialNode = (InitialNode)semanticObject;
		if (GraalViewsRepository.InitialNode.Properties.description == event.getAffectedEditor()) {
			initialNode.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.InitialNode.Properties.outgoingTransitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Transition) {
					outgoingTransitionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				outgoingTransitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outgoingTransitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
			}
		}
		if (GraalViewsRepository.InitialNode.Properties.incomingTransitions == event.getAffectedEditor()) {
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
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InitialNodePropertiesEditionPart initialNodePart = (InitialNodePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && initialNodePart != null && isAccessible(GraalViewsRepository.InitialNode.Properties.description)){
				if (msg.getNewValue() != null) {
					initialNodePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					initialNodePart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getNode_OutgoingTransitions().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.InitialNode.Properties.outgoingTransitions))
				initialNodePart.updateOutgoingTransitions();
			if (GraalPackage.eINSTANCE.getNode_IncomingTransitions().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.InitialNode.Properties.incomingTransitions))
				initialNodePart.updateIncomingTransitions();
			
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
			GraalPackage.eINSTANCE.getNode_OutgoingTransitions(),
			GraalPackage.eINSTANCE.getNode_IncomingTransitions()		);
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
				if (GraalViewsRepository.InitialNode.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
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
