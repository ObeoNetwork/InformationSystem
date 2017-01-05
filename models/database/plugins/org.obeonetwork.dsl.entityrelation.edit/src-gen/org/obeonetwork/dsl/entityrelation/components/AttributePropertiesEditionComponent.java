/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
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
package org.obeonetwork.dsl.entityrelation.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;


// End of user code

/**
 * 
 * 
 */
public class AttributePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String ATTRIBUTE_PART = "Attribute"; //$NON-NLS-1$

	
	
	/**
	 * Settings for type editor
	 */
	protected EEFEditorSettingsImpl typeSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for length editor
	 */
	protected EEFEditorSettingsImpl lengthSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Length())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for precision editor
	 */
	protected EEFEditorSettingsImpl precisionSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for literals editor
	 */
	protected EEFEditorSettingsImpl literalsSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public AttributePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject attribute, String editing_mode) {
		super(editingContext, attribute, editing_mode);
		parts = new String[] { ATTRIBUTE_PART };
		repositoryKey = EntityrelationViewsRepository.class;
		partKey = EntityrelationViewsRepository.Attribute.class;
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
			if (editingPart instanceof CompositePropertiesEditionPart) {
				((CompositePropertiesEditionPart) editingPart).getSettings().add(typeSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(lengthSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(precisionSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(literalsSettings);
			}
			final Attribute attribute = (Attribute)elt;
			final AttributePropertiesEditionPart attributePart = (AttributePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.name))
				attributePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, attribute.getName()));
			
			if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required)) {
				attributePart.setRequired(attribute.isRequired());
			}
			if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier)) {
				attributePart.setInPrimaryIdentifier(attribute.isInPrimaryIdentifier());
			}
			if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.comments))
				attributePart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, attribute.getComments()));
			if (typeSettings.getSignificantObject() != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.type)) {
				attributePart.initType(EEFUtils.choiceOfValues(typeSettings.getSignificantObject(), TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType()), typeSettings.getValue());
			}
			if (lengthSettings.getValue() != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length))
				attributePart.setLength(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, lengthSettings.getValue()));
			
			if (precisionSettings.getValue() != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision))
				attributePart.setPrecision(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, precisionSettings.getValue()));
			
			if (literalsSettings.getSignificantObject() != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.literals)) {
				attributePart.setLiterals((EList<?>)literalsSettings.getValue());
			}
			// init filters
			
			
			
			
			// Start of user code for additional businessfilters for type
			// End of user code
			
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}










	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.type) {
			return (typeSettings.getValue() == null) ? (event.getNewValue() != null) : (!typeSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length) {
			return (lengthSettings.getValue() == null) ? (event.getNewValue() != null) : (!lengthSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision) {
			return (precisionSettings.getValue() == null) ? (event.getNewValue() != null) : (!precisionSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.literals) {
			return (literalsSettings.getValue() == null) ? (event.getNewValue() != null) : (!literalsSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EntityrelationViewsRepository.Attribute.Properties.name) {
			return EntityRelationPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required) {
			return EntityRelationPackage.eINSTANCE.getAttribute_Required();
		}
		if (editorKey == EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier) {
			return EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier();
		}
		if (editorKey == EntityrelationViewsRepository.Attribute.Properties.comments) {
			return EntityRelationPackage.eINSTANCE.getLogicalElement_Comments();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Attribute attribute = (Attribute)semanticObject;
		if (EntityrelationViewsRepository.Attribute.Properties.name == event.getAffectedEditor()) {
			attribute.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required == event.getAffectedEditor()) {
			attribute.setRequired((Boolean)event.getNewValue());
		}
		if (EntityrelationViewsRepository.Attribute.Properties.comments == event.getAffectedEditor()) {
			attribute.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityrelationViewsRepository.Attribute.Properties.type == event.getAffectedEditor()) {
			typeSettings.setValue(!"".equals(event.getNewValue()) ? (NativeType) event.getNewValue() : null);
		}
		if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length == event.getAffectedEditor()) {
			lengthSettings.setValue((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
			precisionSettings.setValue((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (EntityrelationViewsRepository.Attribute.Properties.literals == event.getAffectedEditor()) {
			literalsSettings.setValue((List<?>)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AttributePropertiesEditionPart attributePart = (AttributePropertiesEditionPart)editingPart;
			if (EntityRelationPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.name)) {
				if (msg.getNewValue() != null) {
					attributePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					attributePart.setName("");
				}
			}
			if (EntityRelationPackage.eINSTANCE.getAttribute_Required().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required))
				attributePart.setRequired((Boolean)msg.getNewValue());
			
			if (EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier))
				attributePart.setInPrimaryIdentifier((Boolean)msg.getNewValue());
			
			if (EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.comments)){
				if (msg.getNewValue() != null) {
					attributePart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					attributePart.setComments("");
				}
			}
			if (typeSettings.isAffectingEvent(msg) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.type))
				attributePart.setType((Object)msg.getNewValue());
			if (!(msg.getNewValue() instanceof EObject) && lengthSettings.isAffectingEvent(msg) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length)) {
				if (msg.getNewValue() != null) {
					attributePart.setLength(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					attributePart.setLength("");
				}
			}
			if (!(msg.getNewValue() instanceof EObject) && precisionSettings.isAffectingEvent(msg) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision)) {
				if (msg.getNewValue() != null) {
					attributePart.setPrecision(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					attributePart.setPrecision("");
				}
			}
			if (literalsSettings.isAffectingEvent(msg) && attributePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.literals)) {
				if (msg.getNewValue() instanceof EList<?>) {
					attributePart.setLiterals((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					attributePart.setLiterals(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					attributePart.setLiterals(newValueAsList);
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
			EntityRelationPackage.eINSTANCE.getNamedElement_Name(),
			EntityRelationPackage.eINSTANCE.getAttribute_Required(),
			EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier(),
			EntityRelationPackage.eINSTANCE.getLogicalElement_Comments(),
			TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType()
			,
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Length()
			,
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision()
			,
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals()
					);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EntityrelationViewsRepository.Attribute.Properties.type;
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
				if (EntityrelationViewsRepository.Attribute.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getAttribute_Required().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getAttribute_Required().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Attribute.Properties.literals == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	
	/**
	 * @ return settings for type editor
	 */
	public EEFEditorSettingsImpl getTypeSettings() {
			return typeSettings;
	}
	/**
	 * @ return settings for length editor
	 */
	public EEFEditorSettingsImpl getLengthSettings() {
			return lengthSettings;
	}
	/**
	 * @ return settings for precision editor
	 */
	public EEFEditorSettingsImpl getPrecisionSettings() {
			return precisionSettings;
	}
	/**
	 * @ return settings for literals editor
	 */
	public EEFEditorSettingsImpl getLiteralsSettings() {
			return literalsSettings;
	}

	

}
