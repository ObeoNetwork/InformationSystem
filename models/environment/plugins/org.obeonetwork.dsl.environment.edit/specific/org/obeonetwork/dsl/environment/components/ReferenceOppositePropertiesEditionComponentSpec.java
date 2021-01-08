/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.components;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart;

/**
 * Specific component for opposite and referencedType.
 * 
 * @author ymortier
 */
public class ReferenceOppositePropertiesEditionComponentSpec extends ReferenceOppositePropertiesEditionComponent {

	public ReferenceOppositePropertiesEditionComponentSpec(PropertiesEditingContext editingContext, EObject reference,
			String editing_mode) {
		super(editingContext, reference, editing_mode);
	}

	@Override
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			if (editingPart instanceof CompositePropertiesEditionPart) {
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeNameSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeReferencedTypeSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeMultiplicitySettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeIsCompositeSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeNavigableSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeIdentifierSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeDescriptionSettings);
			}
			final OppositePropertiesEditionPart oppositePart = (OppositePropertiesEditionPart) editingPart;

			if (elt != null && elt instanceof Reference) {
				// init values
				if (oppositeNameSettings.getValue() != null
						&& isAccessible(EnvironmentViewsRepository.Opposite.Properties.name))
					oppositePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
							oppositeNameSettings.getValue()));

				if (oppositeMultiplicitySettings.getSignificantObject() != null
						&& isAccessible(EnvironmentViewsRepository.Opposite.Properties.multiplicity)) {
					oppositePart.initMultiplicity(
							EEFUtils.choiceOfValues(oppositeMultiplicitySettings.getSignificantObject(),
									EnvironmentPackage.eINSTANCE.getProperty_Multiplicity()),
							(Enumerator) oppositeMultiplicitySettings.getValue());
				}
				if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.isComposite)) {
					oppositePart.setIsComposite((Boolean) oppositeIsCompositeSettings.getValue());
				}
				if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.navigable)) {
					oppositePart.setNavigable((Boolean) oppositeNavigableSettings.getValue());
				}
				if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.identifier)) {
					oppositePart.setIdentifier((Boolean) oppositeIdentifierSettings.getValue());
				}
				if (oppositeDescriptionSettings.getValue() != null
						&& isAccessible(EnvironmentViewsRepository.Opposite.Properties.description))
					oppositePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING,
							oppositeDescriptionSettings.getValue()));
				if (this.oppositeReferencedTypeSettings.getSignificantObject() != null
						&& isAccessible(EnvironmentViewsRepository.Opposite.Properties.referencedType)) {
					oppositePart.setReferencedType((EObject) this.oppositeReferencedTypeSettings.getValue());
				}
			} else {
				// no value
			}
		}
		setInitializing(false);
	}

}
