/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.components;

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
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.parts.Interface_PropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>J�r�me Benois</a>
 * 
 */
public class InterfaceInterface_PropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INTERFACE__PART = "Interface"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public InterfaceInterface_PropertiesEditionComponent(PropertiesEditingContext editingContext, EObject interface_, String editing_mode) {
		super(editingContext, interface_, editing_mode);
		parts = new String[] { INTERFACE__PART };
		repositoryKey = SoaViewsRepository.class;
		partKey = SoaViewsRepository.Interface_.class;
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
			
			final Interface interface_ = (Interface)elt;
			final Interface_PropertiesEditionPart interface_Part = (Interface_PropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(SoaViewsRepository.Interface_.Properties.name))
				interface_Part.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interface_.getName()));
			
			if (isAccessible(SoaViewsRepository.Interface_.Properties.description))
				interface_Part.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, interface_.getDescription()));
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
		if (editorKey == SoaViewsRepository.Interface_.Properties.name) {
			return SoaPackage.eINSTANCE.getInterface_Name();
		}
		if (editorKey == SoaViewsRepository.Interface_.Properties.description) {
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
		Interface interface_ = (Interface)semanticObject;
		if (SoaViewsRepository.Interface_.Properties.name == event.getAffectedEditor()) {
			interface_.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.Interface_.Properties.description == event.getAffectedEditor()) {
			interface_.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			Interface_PropertiesEditionPart interface_Part = (Interface_PropertiesEditionPart)editingPart;
			if (SoaPackage.eINSTANCE.getInterface_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interface_Part != null && isAccessible(SoaViewsRepository.Interface_.Properties.name)) {
				if (msg.getNewValue() != null) {
					interface_Part.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interface_Part.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interface_Part != null && isAccessible(SoaViewsRepository.Interface_.Properties.description)){
				if (msg.getNewValue() != null) {
					interface_Part.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interface_Part.setDescription("");
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
			SoaPackage.eINSTANCE.getInterface_Name(),
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
				if (SoaViewsRepository.Interface_.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getInterface_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getInterface_Name().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Interface_.Properties.description == event.getAffectedEditor()) {
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
