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
package org.obeonetwork.dsl.entity.components;

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
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Finder;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class FinderFinderPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FINDER_PART = "Finder"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public FinderFinderPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject finder, String editing_mode) {
		super(editingContext, finder, editing_mode);
		parts = new String[] { FINDER_PART };
		repositoryKey = EntityViewsRepository.class;
		partKey = EntityViewsRepository.Finder.class;
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
			
			final Finder finder = (Finder)elt;
			final FinderPropertiesEditionPart finderPart = (FinderPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EntityViewsRepository.Finder.Properties.customizedName))
				finderPart.setCustomizedName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, finder.getCustomizedName()));
			
			if (isAccessible(EntityViewsRepository.Finder.Properties.multiplicity)) {
				finderPart.initMultiplicity(EEFUtils.choiceOfValues(finder, EntityPackage.eINSTANCE.getProperty_Multiplicity()), finder.getMultiplicity());
			}
			if (isAccessible(EntityViewsRepository.Finder.Properties.description))
				finderPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, finder.getDescription()));
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
		if (editorKey == EntityViewsRepository.Finder.Properties.customizedName) {
			return EntityPackage.eINSTANCE.getFinder_CustomizedName();
		}
		if (editorKey == EntityViewsRepository.Finder.Properties.multiplicity) {
			return EntityPackage.eINSTANCE.getProperty_Multiplicity();
		}
		if (editorKey == EntityViewsRepository.Finder.Properties.description) {
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
		Finder finder = (Finder)semanticObject;
		if (EntityViewsRepository.Finder.Properties.customizedName == event.getAffectedEditor()) {
			finder.setCustomizedName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityViewsRepository.Finder.Properties.multiplicity == event.getAffectedEditor()) {
			finder.setMultiplicity((MultiplicityKind)event.getNewValue());
		}
		if (EntityViewsRepository.Finder.Properties.description == event.getAffectedEditor()) {
			finder.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			FinderPropertiesEditionPart finderPart = (FinderPropertiesEditionPart)editingPart;
			if (EntityPackage.eINSTANCE.getFinder_CustomizedName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && finderPart != null && isAccessible(EntityViewsRepository.Finder.Properties.customizedName)) {
				if (msg.getNewValue() != null) {
					finderPart.setCustomizedName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					finderPart.setCustomizedName("");
				}
			}
			if (EntityPackage.eINSTANCE.getProperty_Multiplicity().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EntityViewsRepository.Finder.Properties.multiplicity))
				finderPart.setMultiplicity((MultiplicityKind)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && finderPart != null && isAccessible(EntityViewsRepository.Finder.Properties.description)){
				if (msg.getNewValue() != null) {
					finderPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					finderPart.setDescription("");
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
			EntityPackage.eINSTANCE.getFinder_CustomizedName(),
			EntityPackage.eINSTANCE.getProperty_Multiplicity(),
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
		return key == EntityViewsRepository.Finder.Properties.multiplicity;
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
				if (EntityViewsRepository.Finder.Properties.customizedName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getFinder_CustomizedName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getFinder_CustomizedName().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Finder.Properties.multiplicity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Finder.Properties.description == event.getAffectedEditor()) {
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
