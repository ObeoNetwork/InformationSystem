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
package org.obeonetwork.dsl.requirement.components;

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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.RequirementType;
import org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class RequirementRequirementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String REQUIREMENT_PART = "Requirement"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public RequirementRequirementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject requirement, String editing_mode) {
		super(editingContext, requirement, editing_mode);
		parts = new String[] { REQUIREMENT_PART };
		repositoryKey = RequirementViewsRepository.class;
		partKey = RequirementViewsRepository.Requirement_.class;
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
			
			final Requirement requirement = (Requirement)elt;
			final RequirementPropertiesEditionPart requirementPart = (RequirementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(RequirementViewsRepository.Requirement_.id))
				requirementPart.setId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, requirement.getId()));
			
			// Start of user code  for version command update
			
			if (isAccessible(RequirementViewsRepository.Requirement_.version)) {
				requirementPart.setVersion(requirement.getVersion());
			}
			
			// End of user code
			
			if (isAccessible(RequirementViewsRepository.Requirement_.name))
				requirementPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, requirement.getName()));
			
			if (isAccessible(RequirementViewsRepository.Requirement_.statement))
				requirementPart.setStatement(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, requirement.getStatement()));
			if (isAccessible(RequirementViewsRepository.Requirement_.type)) {
				requirementPart.initType(EEFUtils.choiceOfValues(requirement, RequirementPackage.eINSTANCE.getRequirement_Type()), requirement.getType());
			}
			if (isAccessible(RequirementViewsRepository.Requirement_.status))
				requirementPart.setStatus(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, requirement.getStatus()));
			
			if (isAccessible(RequirementViewsRepository.Requirement_.subtype))
				requirementPart.setSubtype(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, requirement.getSubtype()));
			
			if (isAccessible(RequirementViewsRepository.Requirement_.modifiedOn))
				requirementPart.setModifiedOn(EEFConverterUtil.convertToString(EcorePackage.Literals.EDATE, requirement.getModifiedOn()));
			
			if (isAccessible(RequirementViewsRepository.Requirement_.createdOn))
				requirementPart.setCreatedOn(EEFConverterUtil.convertToString(EcorePackage.Literals.EDATE, requirement.getCreatedOn()));
			
			// init filters
			
			// Start of user code  for version filter update
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (requirement.getModifiedOn() != null && isAccessible(RequirementViewsRepository.Requirement_.modifiedOn))
				requirementPart.setModifiedOn(simpleDateFormat.format(requirement.getModifiedOn()));
			
			if (requirement.getCreatedOn() != null && isAccessible(RequirementViewsRepository.Requirement_.createdOn))
				requirementPart.setCreatedOn(simpleDateFormat.format(requirement.getCreatedOn()));
			
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
		if (editorKey == RequirementViewsRepository.Requirement_.id) {
			return RequirementPackage.eINSTANCE.getRequirement_Id();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.version) {
			return RequirementPackage.eINSTANCE.getRequirement_Version();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.name) {
			return RequirementPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.statement) {
			return RequirementPackage.eINSTANCE.getRequirement_Statement();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.type) {
			return RequirementPackage.eINSTANCE.getRequirement_Type();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.status) {
			return RequirementPackage.eINSTANCE.getRequirement_Status();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.subtype) {
			return RequirementPackage.eINSTANCE.getRequirement_Subtype();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.modifiedOn) {
			return RequirementPackage.eINSTANCE.getRequirement_ModifiedOn();
		}
		if (editorKey == RequirementViewsRepository.Requirement_.createdOn) {
			return RequirementPackage.eINSTANCE.getRequirement_CreatedOn();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Requirement requirement = (Requirement)semanticObject;
		if (RequirementViewsRepository.Requirement_.id == event.getAffectedEditor()) {
			requirement.setId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Requirement_.version == event.getAffectedEditor()) {
			// Start of user code for updateVersion method body
			requirement.setVersion(requirement.getVersion() + 1);
			
			// End of user code
			
		}
		if (RequirementViewsRepository.Requirement_.name == event.getAffectedEditor()) {
			requirement.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Requirement_.statement == event.getAffectedEditor()) {
			requirement.setStatement((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Requirement_.type == event.getAffectedEditor()) {
			requirement.setType((RequirementType)event.getNewValue());
		}
		if (RequirementViewsRepository.Requirement_.status == event.getAffectedEditor()) {
			requirement.setStatus((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Requirement_.subtype == event.getAffectedEditor()) {
			requirement.setSubtype((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RequirementPropertiesEditionPart requirementPart = (RequirementPropertiesEditionPart)editingPart;
			if (RequirementPackage.eINSTANCE.getRequirement_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.id)) {
				if (msg.getNewValue() != null) {
					requirementPart.setId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					requirementPart.setId("");
				}
			}
					// Start of user code for version live update
					
			if (RequirementPackage.eINSTANCE.getRequirement_Version().equals(msg.getFeature()) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.version)) {
				if (msg.getNewValue() != null) {
					requirementPart.setVersion((Integer)msg.getNewValue());
				} else {
					requirementPart.setVersion(null);
				}
			}
			
			if (RequirementPackage.eINSTANCE.getRequirement_ModifiedOn().equals(msg.getFeature()) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.modifiedOn)) {
				if (msg.getNewValue() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					requirementPart.setModifiedOn(simpleDateFormat.format(msg.getNewValue()));
				} else {
					requirementPart.setModifiedOn("");
				}
				return;
			}
			if (RequirementPackage.eINSTANCE.getRequirement_CreatedOn().equals(msg.getFeature()) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.createdOn)) {
				if (msg.getNewValue() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					requirementPart.setCreatedOn(simpleDateFormat.format(msg.getNewValue()));
				} else {
					requirementPart.setCreatedOn("");
				}
				return;
			}
			
					// End of user code
			
			if (RequirementPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.name)) {
				if (msg.getNewValue() != null) {
					requirementPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					requirementPart.setName("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRequirement_Statement().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.statement)){
				if (msg.getNewValue() != null) {
					requirementPart.setStatement(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					requirementPart.setStatement("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRequirement_Type().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(RequirementViewsRepository.Requirement_.type))
				requirementPart.setType((RequirementType)msg.getNewValue());
			
			if (RequirementPackage.eINSTANCE.getRequirement_Status().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.status)) {
				if (msg.getNewValue() != null) {
					requirementPart.setStatus(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					requirementPart.setStatus("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRequirement_Subtype().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.subtype)) {
				if (msg.getNewValue() != null) {
					requirementPart.setSubtype(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					requirementPart.setSubtype("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRequirement_ModifiedOn().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.modifiedOn)) {
				if (msg.getNewValue() != null) {
					requirementPart.setModifiedOn(EcoreUtil.convertToString(EcorePackage.Literals.EDATE, msg.getNewValue()));
				} else {
					requirementPart.setModifiedOn("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRequirement_CreatedOn().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && requirementPart != null && isAccessible(RequirementViewsRepository.Requirement_.createdOn)) {
				if (msg.getNewValue() != null) {
					requirementPart.setCreatedOn(EcoreUtil.convertToString(EcorePackage.Literals.EDATE, msg.getNewValue()));
				} else {
					requirementPart.setCreatedOn("");
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
			RequirementPackage.eINSTANCE.getRequirement_Id(),
			RequirementPackage.eINSTANCE.getRequirement_Version(),
			RequirementPackage.eINSTANCE.getNamedElement_Name(),
			RequirementPackage.eINSTANCE.getRequirement_Statement(),
			RequirementPackage.eINSTANCE.getRequirement_Type(),
			RequirementPackage.eINSTANCE.getRequirement_Status(),
			RequirementPackage.eINSTANCE.getRequirement_Subtype(),
			RequirementPackage.eINSTANCE.getRequirement_ModifiedOn(),
			RequirementPackage.eINSTANCE.getRequirement_CreatedOn()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == RequirementViewsRepository.Requirement_.statement)
			return "Statement of what the requirement is, including a definition of whether the requirement shall be met, should be met, or may be met."; //$NON-NLS-1$
		if (key == RequirementViewsRepository.Advanced.rationale)
			return "Statement of why the requirement exists."; //$NON-NLS-1$
		if (key == RequirementViewsRepository.Advanced.acceptanceCriteria)
			return "Acceptance criteria Statement of what tests will be carried out to ensure that the requirement will be met."; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (RequirementViewsRepository.Requirement_.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Id().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.version == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Version().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Version().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.statement == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Statement().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Statement().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Type().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.status == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Status().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Status().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.subtype == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_Subtype().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_Subtype().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.modifiedOn == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_ModifiedOn().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_ModifiedOn().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Requirement_.createdOn == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getRequirement_CreatedOn().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getRequirement_CreatedOn().getEAttributeType(), newValue);
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
