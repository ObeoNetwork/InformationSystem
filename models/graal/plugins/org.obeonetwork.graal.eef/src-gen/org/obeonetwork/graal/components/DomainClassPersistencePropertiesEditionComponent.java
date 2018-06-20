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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.PersistencePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class DomainClassPersistencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String PERSISTENCE_PART = "Persistence"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public DomainClassPersistencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject domainClass, String editing_mode) {
		super(editingContext, domainClass, editing_mode);
		parts = new String[] { PERSISTENCE_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.Persistence.class;
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
			
			final DomainClass domainClass = (DomainClass)elt;
			final PersistencePropertiesEditionPart persistencePart = (PersistencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.Persistence.Properties.estimatedVolumetry)) {
				persistencePart.setEstimatedVolumetry(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, domainClass.getEstimatedVolumetry()));
			}
			
			if (isAccessible(GraalViewsRepository.Persistence.Properties.historized)) {
				persistencePart.setHistorized(domainClass.isHistorized());
			}
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
		if (editorKey == GraalViewsRepository.Persistence.Properties.estimatedVolumetry) {
			return GraalPackage.eINSTANCE.getDomainClass_EstimatedVolumetry();
		}
		if (editorKey == GraalViewsRepository.Persistence.Properties.historized) {
			return GraalPackage.eINSTANCE.getDomainClass_Historized();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DomainClass domainClass = (DomainClass)semanticObject;
		if (GraalViewsRepository.Persistence.Properties.estimatedVolumetry == event.getAffectedEditor()) {
			domainClass.setEstimatedVolumetry((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (GraalViewsRepository.Persistence.Properties.historized == event.getAffectedEditor()) {
			domainClass.setHistorized((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PersistencePropertiesEditionPart persistencePart = (PersistencePropertiesEditionPart)editingPart;
			if (GraalPackage.eINSTANCE.getDomainClass_EstimatedVolumetry().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && persistencePart != null && isAccessible(GraalViewsRepository.Persistence.Properties.estimatedVolumetry)) {
				if (msg.getNewValue() != null) {
					persistencePart.setEstimatedVolumetry(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					persistencePart.setEstimatedVolumetry("");
				}
			}
			if (GraalPackage.eINSTANCE.getDomainClass_Historized().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && persistencePart != null && isAccessible(GraalViewsRepository.Persistence.Properties.historized))
				persistencePart.setHistorized((Boolean)msg.getNewValue());
			
			
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
			GraalPackage.eINSTANCE.getDomainClass_EstimatedVolumetry(),
			GraalPackage.eINSTANCE.getDomainClass_Historized()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == GraalViewsRepository.DomainClass.Properties.name || key == GraalViewsRepository.Persistence.Properties.historized;
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
				if (GraalViewsRepository.Persistence.Properties.estimatedVolumetry == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getDomainClass_EstimatedVolumetry().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getDomainClass_EstimatedVolumetry().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Persistence.Properties.historized == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getDomainClass_Historized().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getDomainClass_Historized().getEAttributeType(), newValue);
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
