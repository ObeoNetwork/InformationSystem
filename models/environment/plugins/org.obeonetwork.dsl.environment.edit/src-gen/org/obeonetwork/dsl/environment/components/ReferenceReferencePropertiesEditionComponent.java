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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ReferenceReferencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String REFERENCE_PART = "Reference"; //$NON-NLS-1$

	
	/**
	 * Settings for referencedType EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings referencedTypeSettings;
	
	/**
	 * Settings for oppositeOf EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings oppositeOfSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ReferenceReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject reference, String editing_mode) {
		super(editingContext, reference, editing_mode);
		parts = new String[] { REFERENCE_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Reference.class;
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
			
			final Reference reference = (Reference)elt;
			final ReferencePropertiesEditionPart referencePart = (ReferencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.name))
				referencePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, reference.getName()));
			
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.referencedType)) {
				// init part
				referencedTypeSettings = new EObjectFlatComboSettings(reference, EnvironmentPackage.eINSTANCE.getReference_ReferencedType());
				referencePart.initReferencedType(referencedTypeSettings);
				// set the button mode
				referencePart.setReferencedTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.multiplicity)) {
				referencePart.initMultiplicity(EEFUtils.choiceOfValues(reference, EnvironmentPackage.eINSTANCE.getProperty_Multiplicity()), reference.getMultiplicity());
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.isComposite)) {
				referencePart.setIsComposite(reference.isIsComposite());
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.navigable)) {
				referencePart.setNavigable(reference.isNavigable());
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.oppositeOf)) {
				// init part
				oppositeOfSettings = new EObjectFlatComboSettings(reference, EnvironmentPackage.eINSTANCE.getReference_OppositeOf());
				referencePart.initOppositeOf(oppositeOfSettings);
				// set the button mode
				referencePart.setOppositeOfButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.identifier)) {
				referencePart.setIdentifier(reference.isIsIdentifier());
			}
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.description))
				referencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, reference.getDescription()));
			// init filters
			
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.referencedType)) {
				referencePart.addFilterToReferencedType(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof StructuredType);
					}
					
				});
				// Start of user code for additional businessfilters for referencedType
				// End of user code
			}
			
			
			
			if (isAccessible(EnvironmentViewsRepository.Reference.Properties.oppositeOf)) {
				referencePart.addFilterToOppositeOf(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Reference); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for oppositeOf
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
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getProperty_Name();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.referencedType) {
			return EnvironmentPackage.eINSTANCE.getReference_ReferencedType();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.multiplicity) {
			return EnvironmentPackage.eINSTANCE.getProperty_Multiplicity();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.isComposite) {
			return EnvironmentPackage.eINSTANCE.getReference_IsComposite();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.navigable) {
			return EnvironmentPackage.eINSTANCE.getReference_Navigable();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.oppositeOf) {
			return EnvironmentPackage.eINSTANCE.getReference_OppositeOf();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.identifier) {
			return EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier();
		}
		if (editorKey == EnvironmentViewsRepository.Reference.Properties.description) {
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
		Reference reference = (Reference)semanticObject;
		if (EnvironmentViewsRepository.Reference.Properties.name == event.getAffectedEditor()) {
			reference.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Reference.Properties.multiplicity == event.getAffectedEditor()) {
			reference.setMultiplicity((MultiplicityKind)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Reference.Properties.isComposite == event.getAffectedEditor()) {
			reference.setIsComposite((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Reference.Properties.navigable == event.getAffectedEditor()) {
			reference.setNavigable((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Reference.Properties.oppositeOf == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				oppositeOfSettings.setToReference((Reference)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Reference eObject = EnvironmentFactory.eINSTANCE.createReference();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				oppositeOfSettings.setToReference(eObject);
			}
		}
		if (EnvironmentViewsRepository.Reference.Properties.identifier == event.getAffectedEditor()) {
			reference.setIsIdentifier((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Reference.Properties.description == event.getAffectedEditor()) {
			reference.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ReferencePropertiesEditionPart referencePart = (ReferencePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getProperty_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.name)) {
				if (msg.getNewValue() != null) {
					referencePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					referencePart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getReference_ReferencedType().equals(msg.getFeature()) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.referencedType))
				referencePart.setReferencedType((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getProperty_Multiplicity().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EnvironmentViewsRepository.Reference.Properties.multiplicity))
				referencePart.setMultiplicity((MultiplicityKind)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getReference_IsComposite().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.isComposite))
				referencePart.setIsComposite((Boolean)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getReference_Navigable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.navigable))
				referencePart.setNavigable((Boolean)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getReference_OppositeOf().equals(msg.getFeature()) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.oppositeOf))
				referencePart.setOppositeOf((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.identifier))
				referencePart.setIdentifier((Boolean)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && referencePart != null && isAccessible(EnvironmentViewsRepository.Reference.Properties.description)){
				if (msg.getNewValue() != null) {
					referencePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					referencePart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getProperty_Name(),
			EnvironmentPackage.eINSTANCE.getReference_ReferencedType(),
			EnvironmentPackage.eINSTANCE.getProperty_Multiplicity(),
			EnvironmentPackage.eINSTANCE.getReference_IsComposite(),
			EnvironmentPackage.eINSTANCE.getReference_Navigable(),
			EnvironmentPackage.eINSTANCE.getReference_OppositeOf(),
			EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier(),
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
		return key == EnvironmentViewsRepository.Reference.Properties.referencedType || key == EnvironmentViewsRepository.Reference.Properties.isComposite || key == EnvironmentViewsRepository.Reference.Properties.navigable || key == EnvironmentViewsRepository.Opposite.Properties.referencedType || key == EnvironmentViewsRepository.Opposite.Properties.isComposite || key == EnvironmentViewsRepository.Opposite.Properties.navigable;
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
				if (EnvironmentViewsRepository.Reference.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Reference.Properties.multiplicity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Reference.Properties.isComposite == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getReference_IsComposite().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getReference_IsComposite().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Reference.Properties.navigable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getReference_Navigable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getReference_Navigable().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Reference.Properties.identifier == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Reference.Properties.description == event.getAffectedEditor()) {
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
