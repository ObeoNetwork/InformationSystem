/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.components;

// Start of user code for imports
import java.text.SimpleDateFormat;

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
import org.obeonetwork.dsl.environment.ObeoDSMObject;

import org.obeonetwork.graalextensions.parts.GraalextensionsViewsRepository;
import org.obeonetwork.graalextensions.parts.VersionPropertiesEditionPart;


// End of user code

/**
 * @author Obeo
 * 
 */
public class VersionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VERSION_PART = "Version"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public VersionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject obeoDSMObject, String editing_mode) {
		super(editingContext, obeoDSMObject, editing_mode);
		parts = new String[] { VERSION_PART };
		repositoryKey = GraalextensionsViewsRepository.class;
		partKey = GraalextensionsViewsRepository.Version.class;
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
			
			final ObeoDSMObject obeoDSMObject = (ObeoDSMObject)elt;
			final VersionPropertiesEditionPart versionPart = (VersionPropertiesEditionPart)editingPart;
			// init values
			// Start of user code  for version command update
			
			if (isAccessible(GraalextensionsViewsRepository.Version.Properties.version_)) {
				versionPart.setVersion(obeoDSMObject.getVersion());
			}
			
			// End of user code
			
			if (isAccessible(GraalextensionsViewsRepository.Version.Properties.createdOn))
				versionPart.setCreatedOn(EEFConverterUtil.convertToString(EcorePackage.Literals.EDATE, obeoDSMObject.getCreatedOn()));
			
			if (isAccessible(GraalextensionsViewsRepository.Version.Properties.modifiedOn))
				versionPart.setModifiedOn(EEFConverterUtil.convertToString(EcorePackage.Literals.EDATE, obeoDSMObject.getModifiedOn()));
			
			// init filters
			// Start of user code  for version filter update
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (obeoDSMObject.getModifiedOn() != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.modifiedOn))
				versionPart.setModifiedOn(simpleDateFormat.format(obeoDSMObject.getModifiedOn()));
			
			if (obeoDSMObject.getCreatedOn() != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.createdOn))
				versionPart.setCreatedOn(simpleDateFormat.format(obeoDSMObject.getCreatedOn()));
			
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
		if (editorKey == GraalextensionsViewsRepository.Version.Properties.version_) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version();
		}
		if (editorKey == GraalextensionsViewsRepository.Version.Properties.createdOn) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn();
		}
		if (editorKey == GraalextensionsViewsRepository.Version.Properties.modifiedOn) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ObeoDSMObject obeoDSMObject = (ObeoDSMObject)semanticObject;
		if (GraalextensionsViewsRepository.Version.Properties.version_ == event.getAffectedEditor()) {
			// Start of user code for updateVersion method body
			
			obeoDSMObject.setVersion(obeoDSMObject.getVersion() + 1);
			
			// End of user code
			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			VersionPropertiesEditionPart versionPart = (VersionPropertiesEditionPart)editingPart;
					// Start of user code for version live update
					
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version().equals(msg.getFeature()) && versionPart != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.version_)) {
				if (msg.getNewValue() != null) {
					versionPart.setVersion((Integer)msg.getNewValue());
				} else {
					versionPart.setVersion(null);
				}
			}
			
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn().equals(msg.getFeature()) && versionPart != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.modifiedOn)) {
				if (msg.getNewValue() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					versionPart.setModifiedOn(simpleDateFormat.format(msg.getNewValue()));
				} else {
					versionPart.setModifiedOn("");
				}
				return;
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn().equals(msg.getFeature()) && versionPart != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.createdOn)) {
				if (msg.getNewValue() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					versionPart.setCreatedOn(simpleDateFormat.format(msg.getNewValue()));
				} else {
					versionPart.setCreatedOn("");
				}
				return;
			}
			
					// End of user code
			
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && versionPart != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.createdOn)) {
				if (msg.getNewValue() != null) {
					versionPart.setCreatedOn(EcoreUtil.convertToString(EcorePackage.Literals.EDATE, msg.getNewValue()));
				} else {
					versionPart.setCreatedOn("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && versionPart != null && isAccessible(GraalextensionsViewsRepository.Version.Properties.modifiedOn)) {
				if (msg.getNewValue() != null) {
					versionPart.setModifiedOn(EcoreUtil.convertToString(EcorePackage.Literals.EDATE, msg.getNewValue()));
				} else {
					versionPart.setModifiedOn("");
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn()		);
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
				if (GraalextensionsViewsRepository.Version.Properties.version_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Version().getEAttributeType(), newValue);
				}
				if (GraalextensionsViewsRepository.Version.Properties.createdOn == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn().getEAttributeType(), newValue);
				}
				if (GraalextensionsViewsRepository.Version.Properties.modifiedOn == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn().getEAttributeType(), newValue);
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
