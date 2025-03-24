/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
package org.obeonetwork.dsl.environment.components;

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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class BindingReferenceBindingReferencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BINDINGREFERENCE_PART = "BindingReference"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BindingReferenceBindingReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject bindingReference, String editing_mode) {
		super(editingContext, bindingReference, editing_mode);
		parts = new String[] { BINDINGREFERENCE_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.BindingReference.class;
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
			
			final BindingReference bindingReference = (BindingReference)elt;
			final BindingReferencePropertiesEditionPart bindingReferencePart = (BindingReferencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.BindingReference.Properties.left)) {
				bindingReferencePart.initLeft(EEFUtils.choiceOfValues(bindingReference, EnvironmentPackage.eINSTANCE.getBindingReference_Left()), bindingReference.getLeft());
			}
			if (isAccessible(EnvironmentViewsRepository.BindingReference.Properties.right)) {
				bindingReferencePart.initRight(EEFUtils.choiceOfValues(bindingReference, EnvironmentPackage.eINSTANCE.getBindingReference_Right()), bindingReference.getRight());
			}
			if (isAccessible(EnvironmentViewsRepository.BindingReference.Properties.description))
				bindingReferencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, bindingReference.getDescription()));
			// init filters
			// Start of user code for additional businessfilters for left
			// End of user code
			
			// Start of user code for additional businessfilters for right
			// End of user code
			
			
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
		if (editorKey == EnvironmentViewsRepository.BindingReference.Properties.left) {
			return EnvironmentPackage.eINSTANCE.getBindingReference_Left();
		}
		if (editorKey == EnvironmentViewsRepository.BindingReference.Properties.right) {
			return EnvironmentPackage.eINSTANCE.getBindingReference_Right();
		}
		if (editorKey == EnvironmentViewsRepository.BindingReference.Properties.description) {
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
		BindingReference bindingReference = (BindingReference)semanticObject;
		if (EnvironmentViewsRepository.BindingReference.Properties.left == event.getAffectedEditor()) {
			bindingReference.setLeft(!"".equals(event.getNewValue()) ? (BindingElement) event.getNewValue() : null);
		}
		if (EnvironmentViewsRepository.BindingReference.Properties.right == event.getAffectedEditor()) {
			bindingReference.setRight(!"".equals(event.getNewValue()) ? (BindingElement) event.getNewValue() : null);
		}
		if (EnvironmentViewsRepository.BindingReference.Properties.description == event.getAffectedEditor()) {
			bindingReference.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			BindingReferencePropertiesEditionPart bindingReferencePart = (BindingReferencePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getBindingReference_Left().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingReferencePart != null && isAccessible(EnvironmentViewsRepository.BindingReference.Properties.left))
				bindingReferencePart.setLeft((Object)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getBindingReference_Right().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingReferencePart != null && isAccessible(EnvironmentViewsRepository.BindingReference.Properties.right))
				bindingReferencePart.setRight((Object)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingReferencePart != null && isAccessible(EnvironmentViewsRepository.BindingReference.Properties.description)){
				if (msg.getNewValue() != null) {
					bindingReferencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					bindingReferencePart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getBindingReference_Left(),
			EnvironmentPackage.eINSTANCE.getBindingReference_Right(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EnvironmentViewsRepository.BindingReference.Properties.left || key == EnvironmentViewsRepository.BindingReference.Properties.right;
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
				if (EnvironmentViewsRepository.BindingReference.Properties.description == event.getAffectedEditor()) {
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
