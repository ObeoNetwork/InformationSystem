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
package org.obeonetwork.dsl.interaction.components;

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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.parts.CombinedFragmentPropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class CombinedFragmentCombinedFragmentPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String COMBINEDFRAGMENT_PART = "CombinedFragment"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public CombinedFragmentCombinedFragmentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject combinedFragment, String editing_mode) {
		super(editingContext, combinedFragment, editing_mode);
		parts = new String[] { COMBINEDFRAGMENT_PART };
		repositoryKey = InteractionViewsRepository.class;
		partKey = InteractionViewsRepository.CombinedFragment.class;
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
			
			final CombinedFragment combinedFragment = (CombinedFragment)elt;
			final CombinedFragmentPropertiesEditionPart combinedFragmentPart = (CombinedFragmentPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(InteractionViewsRepository.CombinedFragment.Properties.name))
				combinedFragmentPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, combinedFragment.getName()));
			
			if (isAccessible(InteractionViewsRepository.CombinedFragment.Properties.operator))
				combinedFragmentPart.setOperator(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, combinedFragment.getOperator()));
			
			if (isAccessible(InteractionViewsRepository.CombinedFragment.Properties.description))
				combinedFragmentPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, combinedFragment.getDescription()));
			
			// init filters
			
			
			
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
		if (editorKey == InteractionViewsRepository.CombinedFragment.Properties.name) {
			return InteractionPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == InteractionViewsRepository.CombinedFragment.Properties.operator) {
			return InteractionPackage.eINSTANCE.getCombinedFragment_Operator();
		}
		if (editorKey == InteractionViewsRepository.CombinedFragment.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CombinedFragment combinedFragment = (CombinedFragment)semanticObject;
		if (InteractionViewsRepository.CombinedFragment.Properties.name == event.getAffectedEditor()) {
			combinedFragment.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (InteractionViewsRepository.CombinedFragment.Properties.operator == event.getAffectedEditor()) {
			combinedFragment.setOperator((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (InteractionViewsRepository.CombinedFragment.Properties.description == event.getAffectedEditor()) {
			combinedFragment.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			CombinedFragmentPropertiesEditionPart combinedFragmentPart = (CombinedFragmentPropertiesEditionPart)editingPart;
			if (InteractionPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && combinedFragmentPart != null && isAccessible(InteractionViewsRepository.CombinedFragment.Properties.name)) {
				if (msg.getNewValue() != null) {
					combinedFragmentPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					combinedFragmentPart.setName("");
				}
			}
			if (InteractionPackage.eINSTANCE.getCombinedFragment_Operator().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && combinedFragmentPart != null && isAccessible(InteractionViewsRepository.CombinedFragment.Properties.operator)) {
				if (msg.getNewValue() != null) {
					combinedFragmentPart.setOperator(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					combinedFragmentPart.setOperator("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && combinedFragmentPart != null && isAccessible(InteractionViewsRepository.CombinedFragment.Properties.description)) {
				if (msg.getNewValue() != null) {
					combinedFragmentPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					combinedFragmentPart.setDescription("");
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
			InteractionPackage.eINSTANCE.getNamedElement_Name(),
			InteractionPackage.eINSTANCE.getCombinedFragment_Operator(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description()		);
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
				if (InteractionViewsRepository.CombinedFragment.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (InteractionViewsRepository.CombinedFragment.Properties.operator == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(InteractionPackage.eINSTANCE.getCombinedFragment_Operator().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(InteractionPackage.eINSTANCE.getCombinedFragment_Operator().getEAttributeType(), newValue);
				}
				if (InteractionViewsRepository.CombinedFragment.Properties.description == event.getAffectedEditor()) {
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
