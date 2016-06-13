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
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.OperationKind;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.parts.OperationPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class OperationOperationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String OPERATION_PART = "Operation"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public OperationOperationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject operation, String editing_mode) {
		super(editingContext, operation, editing_mode);
		parts = new String[] { OPERATION_PART };
		repositoryKey = SoaViewsRepository.class;
		partKey = SoaViewsRepository.Operation.class;
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
			
			final Operation operation = (Operation)elt;
			final OperationPropertiesEditionPart operationPart = (OperationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(SoaViewsRepository.Operation.Properties.name))
				operationPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, operation.getName()));
			
			if (isAccessible(SoaViewsRepository.Operation.Properties.kind)) {
				operationPart.initKind(EEFUtils.choiceOfValues(operation, SoaPackage.eINSTANCE.getOperation_Kind()), operation.getKind());
			}
			if (isAccessible(SoaViewsRepository.Operation.Properties.public_)) {
				operationPart.setPublic_(operation.isPublic());
			}
			if (isAccessible(SoaViewsRepository.Operation.Properties.description))
				operationPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, operation.getDescription()));
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
		if (editorKey == SoaViewsRepository.Operation.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getAction_Name();
		}
		if (editorKey == SoaViewsRepository.Operation.Properties.kind) {
			return SoaPackage.eINSTANCE.getOperation_Kind();
		}
		if (editorKey == SoaViewsRepository.Operation.Properties.public_) {
			return SoaPackage.eINSTANCE.getOperation_Public();
		}
		if (editorKey == SoaViewsRepository.Operation.Properties.description) {
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
		Operation operation = (Operation)semanticObject;
		if (SoaViewsRepository.Operation.Properties.name == event.getAffectedEditor()) {
			operation.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.Operation.Properties.kind == event.getAffectedEditor()) {
			operation.setKind((OperationKind)event.getNewValue());
		}
		if (SoaViewsRepository.Operation.Properties.public_ == event.getAffectedEditor()) {
			operation.setPublic((Boolean)event.getNewValue());
		}
		if (SoaViewsRepository.Operation.Properties.description == event.getAffectedEditor()) {
			operation.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			OperationPropertiesEditionPart operationPart = (OperationPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getAction_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationPart != null && isAccessible(SoaViewsRepository.Operation.Properties.name)) {
				if (msg.getNewValue() != null) {
					operationPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					operationPart.setName("");
				}
			}
			if (SoaPackage.eINSTANCE.getOperation_Kind().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(SoaViewsRepository.Operation.Properties.kind))
				operationPart.setKind((OperationKind)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getOperation_Public().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationPart != null && isAccessible(SoaViewsRepository.Operation.Properties.public_))
				operationPart.setPublic_((Boolean)msg.getNewValue());
			
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationPart != null && isAccessible(SoaViewsRepository.Operation.Properties.description)){
				if (msg.getNewValue() != null) {
					operationPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					operationPart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getAction_Name(),
			SoaPackage.eINSTANCE.getOperation_Kind(),
			SoaPackage.eINSTANCE.getOperation_Public(),
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
		return key == SoaViewsRepository.Operation.Properties.name || key == SoaViewsRepository.Operation.Properties.public_;
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
				if (SoaViewsRepository.Operation.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getAction_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getAction_Name().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Operation.Properties.kind == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getOperation_Kind().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getOperation_Kind().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Operation.Properties.public_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getOperation_Public().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getOperation_Public().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Operation.Properties.description == event.getAffectedEditor()) {
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
