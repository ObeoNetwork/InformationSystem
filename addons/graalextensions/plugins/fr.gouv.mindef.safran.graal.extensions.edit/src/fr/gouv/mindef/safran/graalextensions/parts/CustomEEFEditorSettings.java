/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

import fr.gouv.mindef.safran.graalextensions.GraalExtensionsFactory;
import fr.gouv.mindef.safran.graalextensions.Risk;


public class CustomEEFEditorSettings {

	private EEFEditorSettingsImpl delegatedSettings;
	private EObject significantObject;
	private EStructuralFeature feature;
	private DomainPropertiesEditionContext context;
	
	public CustomEEFEditorSettings(EEFEditorSettingsImpl delegatedSettings, EStructuralFeature feature, DomainPropertiesEditionContext context) {
		this.delegatedSettings = delegatedSettings;
		this.feature = feature;
		this.context = context;
	}
	
	public EObject getOrCreateSignificantObject() {
		EObject object = getSignificantObject();
		if (object == null) {
			if (getSource() instanceof ObeoDSMObject) {
				ObeoDSMObject source = (ObeoDSMObject)getSource();
				EditingDomain domain = context.getEditingDomain();
				if (source.getMetadatas() == null) {
					// Create MetaDataContainer
					MetaDataContainer mdContainer = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
					domain.getCommandStack().execute(SetCommand.create(domain, source, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas(), mdContainer));
				}
				// Create Risk
				Risk risk = GraalExtensionsFactory.eINSTANCE.createRisk();
				domain.getCommandStack().execute(AddCommand.create(domain, source.getMetadatas(), EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas(), risk));
				significantObject = getSignificantObject();
				return significantObject;
			}
		}
		return object;
	}

	/**
	 * Compute and cache the object to edit following the NavigationStep.
	 * @return object to edit.
	 */
	public EObject getSignificantObject() {
		if (significantObject == null) {
			significantObject = getRiskObject(getSource());
		}
		return significantObject;
	}
	
	private Risk getRiskObject(EObject element) {
		if (element instanceof ObeoDSMObject) {
			ObeoDSMObject obeoDSMObject = (ObeoDSMObject)element;
			if (obeoDSMObject.getMetadatas() != null) {
				for (Object metadata : obeoDSMObject.getMetadatas().getMetadatas()) {
					if (metadata instanceof Risk) {
						return (Risk)metadata;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#getValue()
	 */
	public Object getValue() {
		return getSignificantObject().eGet(feature);
	}
	
	public void setValue(Object newValue) {
		getSignificantObject().eSet(feature, newValue);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#choiceOfValues(org.eclipse.emf.common.notify.AdapterFactory)
	 */
	public Object choiceOfValues(AdapterFactory adapterFactory) {
		return delegatedSettings.choiceOfValues(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#isAffectingFeature(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public boolean isAffectingFeature(EStructuralFeature feature) {
		return delegatedSettings.isAffectingFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#getSource()
	 */
	public EObject getSource() {
		return delegatedSettings.getSource();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#getEType()
	 */
	public EClassifier getEType() {
		return delegatedSettings.getEType();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings#getLastReference()
	 */
	public EReference getLastReference() {
		return delegatedSettings.getLastReference();
	}
}
