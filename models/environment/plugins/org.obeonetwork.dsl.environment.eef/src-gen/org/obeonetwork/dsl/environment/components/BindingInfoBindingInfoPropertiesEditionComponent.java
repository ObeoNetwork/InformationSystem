/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
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
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class BindingInfoBindingInfoPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BINDINGINFO_PART = "BindingInfo"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BindingInfoBindingInfoPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject bindingInfo, String editing_mode) {
		super(editingContext, bindingInfo, editing_mode);
		parts = new String[] { BINDINGINFO_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.BindingInfo.class;
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
			
			final BindingInfo bindingInfo = (BindingInfo)elt;
			final BindingInfoPropertiesEditionPart bindingInfoPart = (BindingInfoPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.left)) {
				bindingInfoPart.initLeft(EEFUtils.choiceOfValues(bindingInfo, EnvironmentPackage.eINSTANCE.getBindingInfo_Left()), bindingInfo.getLeft());
			}
			if (isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.right)) {
				bindingInfoPart.initRight(EEFUtils.choiceOfValues(bindingInfo, EnvironmentPackage.eINSTANCE.getBindingInfo_Right()), bindingInfo.getRight());
			}
			if (isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.description))
				bindingInfoPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, bindingInfo.getDescription()));
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
		if (editorKey == EnvironmentViewsRepository.BindingInfo.Properties.left) {
			return EnvironmentPackage.eINSTANCE.getBindingInfo_Left();
		}
		if (editorKey == EnvironmentViewsRepository.BindingInfo.Properties.right) {
			return EnvironmentPackage.eINSTANCE.getBindingInfo_Right();
		}
		if (editorKey == EnvironmentViewsRepository.BindingInfo.Properties.description) {
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
		BindingInfo bindingInfo = (BindingInfo)semanticObject;
		if (EnvironmentViewsRepository.BindingInfo.Properties.left == event.getAffectedEditor()) {
			bindingInfo.setLeft(!"".equals(event.getNewValue()) ? (BoundableElement) event.getNewValue() : null);
		}
		if (EnvironmentViewsRepository.BindingInfo.Properties.right == event.getAffectedEditor()) {
			bindingInfo.setRight(!"".equals(event.getNewValue()) ? (BoundableElement) event.getNewValue() : null);
		}
		if (EnvironmentViewsRepository.BindingInfo.Properties.description == event.getAffectedEditor()) {
			bindingInfo.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			BindingInfoPropertiesEditionPart bindingInfoPart = (BindingInfoPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getBindingInfo_Left().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingInfoPart != null && isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.left))
				bindingInfoPart.setLeft((Object)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getBindingInfo_Right().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingInfoPart != null && isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.right))
				bindingInfoPart.setRight((Object)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && bindingInfoPart != null && isAccessible(EnvironmentViewsRepository.BindingInfo.Properties.description)){
				if (msg.getNewValue() != null) {
					bindingInfoPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					bindingInfoPart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getBindingInfo_Left(),
			EnvironmentPackage.eINSTANCE.getBindingInfo_Right(),
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
				if (EnvironmentViewsRepository.BindingInfo.Properties.description == event.getAffectedEditor()) {
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
