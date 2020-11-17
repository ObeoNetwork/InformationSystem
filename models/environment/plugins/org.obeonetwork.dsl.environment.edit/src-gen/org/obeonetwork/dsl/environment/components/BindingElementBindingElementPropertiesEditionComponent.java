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
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class BindingElementBindingElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BINDINGELEMENT_PART = "BindingElement"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BindingElementBindingElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject bindingElement, String editing_mode) {
		super(editingContext, bindingElement, editing_mode);
		parts = new String[] { BINDINGELEMENT_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.BindingElement.class;
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
			
			final BindingElement bindingElement = (BindingElement)elt;
			final BindingElementPropertiesEditionPart bindingElementPart = (BindingElementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.BindingElement.Properties.boundElement)) {
				bindingElementPart.initBoundElement(EEFUtils.choiceOfValues(bindingElement, EnvironmentPackage.eINSTANCE.getBindingElement_BoundElement()), bindingElement.getBoundElement());
			}
			if (isAccessible(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression))
				bindingElementPart.setBindingExpression(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, bindingElement.getBindingExpression()));
			
			if (isAccessible(EnvironmentViewsRepository.BindingElement.Properties.description))
				bindingElementPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, bindingElement.getDescription()));
			// init filters
			// Start of user code for additional businessfilters for boundElement
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
		if (editorKey == EnvironmentViewsRepository.BindingElement.Properties.boundElement) {
			return EnvironmentPackage.eINSTANCE.getBindingElement_BoundElement();
		}
		if (editorKey == EnvironmentViewsRepository.BindingElement.Properties.bindingExpression) {
			return EnvironmentPackage.eINSTANCE.getBindingElement_BindingExpression();
		}
		if (editorKey == EnvironmentViewsRepository.BindingElement.Properties.description) {
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
		BindingElement bindingElement = (BindingElement)semanticObject;
		if (EnvironmentViewsRepository.BindingElement.Properties.boundElement == event.getAffectedEditor()) {
			bindingElement.setBoundElement(!"".equals(event.getNewValue()) ? (BoundableElement) event.getNewValue() : null);
		}
		if (EnvironmentViewsRepository.BindingElement.Properties.bindingExpression == event.getAffectedEditor()) {
			bindingElement.setBindingExpression((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.BindingElement.Properties.description == event.getAffectedEditor()) {
			bindingElement.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			BindingElementPropertiesEditionPart bindingElementPart = (BindingElementPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getBindingElement_BoundElement().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingElementPart != null && isAccessible(EnvironmentViewsRepository.BindingElement.Properties.boundElement))
				bindingElementPart.setBoundElement((Object)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getBindingElement_BindingExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingElementPart != null && isAccessible(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression)) {
				if (msg.getNewValue() != null) {
					bindingElementPart.setBindingExpression(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					bindingElementPart.setBindingExpression("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingElementPart != null && isAccessible(EnvironmentViewsRepository.BindingElement.Properties.description)){
				if (msg.getNewValue() != null) {
					bindingElementPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					bindingElementPart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getBindingElement_BoundElement(),
			EnvironmentPackage.eINSTANCE.getBindingElement_BindingExpression(),
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
				if (EnvironmentViewsRepository.BindingElement.Properties.bindingExpression == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getBindingElement_BindingExpression().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getBindingElement_BindingExpression().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.BindingElement.Properties.description == event.getAffectedEditor()) {
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
