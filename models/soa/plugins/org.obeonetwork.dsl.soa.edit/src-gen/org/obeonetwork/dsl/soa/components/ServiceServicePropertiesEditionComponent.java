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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SynchronizationKind;
import org.obeonetwork.dsl.soa.parts.ServicePropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class ServiceServicePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SERVICE_PART = "Service"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ServiceServicePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject service, String editing_mode) {
		super(editingContext, service, editing_mode);
		parts = new String[] { SERVICE_PART };
		repositoryKey = SoaViewsRepository.class;
		partKey = SoaViewsRepository.Service.class;
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
			
			final Service service = (Service)elt;
			final ServicePropertiesEditionPart servicePart = (ServicePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(SoaViewsRepository.Service.Properties.synchronization)) {
				servicePart.initSynchronization(EEFUtils.choiceOfValues(service, SoaPackage.eINSTANCE.getService_Synchronization()), service.getSynchronization());
			}
			if (isAccessible(SoaViewsRepository.Service.Properties.kind)) {
				servicePart.initKind(EEFUtils.choiceOfValues(service, SoaPackage.eINSTANCE.getService_Kind()), service.getKind());
			}
			if (isAccessible(SoaViewsRepository.Service.Properties.name))
				servicePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, service.getName()));
			
			if (isAccessible(SoaViewsRepository.Service.Properties.description))
				servicePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, service.getDescription()));
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
		if (editorKey == SoaViewsRepository.Service.Properties.synchronization) {
			return SoaPackage.eINSTANCE.getService_Synchronization();
		}
		if (editorKey == SoaViewsRepository.Service.Properties.kind) {
			return SoaPackage.eINSTANCE.getService_Kind();
		}
		if (editorKey == SoaViewsRepository.Service.Properties.name) {
			return SoaPackage.eINSTANCE.getService_Name();
		}
		if (editorKey == SoaViewsRepository.Service.Properties.description) {
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
		Service service = (Service)semanticObject;
		if (SoaViewsRepository.Service.Properties.synchronization == event.getAffectedEditor()) {
			service.setSynchronization((SynchronizationKind)event.getNewValue());
		}
		if (SoaViewsRepository.Service.Properties.kind == event.getAffectedEditor()) {
			service.setKind((InterfaceKind)event.getNewValue());
		}
		if (SoaViewsRepository.Service.Properties.name == event.getAffectedEditor()) {
			service.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.Service.Properties.description == event.getAffectedEditor()) {
			service.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ServicePropertiesEditionPart servicePart = (ServicePropertiesEditionPart)editingPart;
			if (SoaPackage.eINSTANCE.getService_Synchronization().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(SoaViewsRepository.Service.Properties.synchronization))
				servicePart.setSynchronization((SynchronizationKind)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getService_Kind().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(SoaViewsRepository.Service.Properties.kind))
				servicePart.setKind((InterfaceKind)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getService_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && servicePart != null && isAccessible(SoaViewsRepository.Service.Properties.name)) {
				if (msg.getNewValue() != null) {
					servicePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					servicePart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && servicePart != null && isAccessible(SoaViewsRepository.Service.Properties.description)){
				if (msg.getNewValue() != null) {
					servicePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					servicePart.setDescription("");
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
			SoaPackage.eINSTANCE.getService_Synchronization(),
			SoaPackage.eINSTANCE.getService_Kind(),
			SoaPackage.eINSTANCE.getService_Name(),
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
		return key == SoaViewsRepository.Service.Properties.synchronization || key == SoaViewsRepository.Service.Properties.kind;
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
				if (SoaViewsRepository.Service.Properties.synchronization == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getService_Synchronization().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getService_Synchronization().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Service.Properties.kind == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getService_Kind().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getService_Kind().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Service.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getService_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getService_Name().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Service.Properties.description == event.getAffectedEditor()) {
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
