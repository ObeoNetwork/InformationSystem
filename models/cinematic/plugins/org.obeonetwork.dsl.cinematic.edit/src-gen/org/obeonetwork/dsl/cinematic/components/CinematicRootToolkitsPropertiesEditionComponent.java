/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.cinematic.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart;

import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;


// End of user code

/**
 * 
 * 
 */
public class CinematicRootToolkitsPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TOOLKITS_PART = "Toolkits"; //$NON-NLS-1$

	
	/**
	 * Settings for toolkits ReferencesTable
	 */
	private ReferencesTableSettings toolkitsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CinematicRootToolkitsPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cinematicRoot, String editing_mode) {
		super(editingContext, cinematicRoot, editing_mode);
		parts = new String[] { TOOLKITS_PART };
		repositoryKey = CinematicViewsRepository.class;
		partKey = CinematicViewsRepository.Toolkits.class;
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
			
			final CinematicRoot cinematicRoot = (CinematicRoot)elt;
			final ToolkitsPropertiesEditionPart toolkitsPart = (ToolkitsPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(CinematicViewsRepository.Toolkits.Properties.toolkits_)) {
				toolkitsSettings = new ReferencesTableSettings(cinematicRoot, CinematicPackage.eINSTANCE.getCinematicRoot_Toolkits());
				toolkitsPart.initToolkits(toolkitsSettings);
			}
			// init filters
			if (isAccessible(CinematicViewsRepository.Toolkits.Properties.toolkits_)) {
				toolkitsPart.addFilterToToolkits(new EObjectFilter(ToolkitsPackage.Literals.TOOLKIT));
				// Start of user code for additional businessfilters for toolkits
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
		if (editorKey == CinematicViewsRepository.Toolkits.Properties.toolkits_) {
			return CinematicPackage.eINSTANCE.getCinematicRoot_Toolkits();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CinematicRoot cinematicRoot = (CinematicRoot)semanticObject;
		if (CinematicViewsRepository.Toolkits.Properties.toolkits_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Toolkit) {
					toolkitsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				toolkitsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				toolkitsSettings.move(event.getNewIndex(), (Toolkit) event.getNewValue());
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
			ToolkitsPropertiesEditionPart toolkitsPart = (ToolkitsPropertiesEditionPart)editingPart;
			if (CinematicPackage.eINSTANCE.getCinematicRoot_Toolkits().equals(msg.getFeature())  && isAccessible(CinematicViewsRepository.Toolkits.Properties.toolkits_))
				toolkitsPart.updateToolkits();
			
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
			CinematicPackage.eINSTANCE.getCinematicRoot_Toolkits()		);
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
