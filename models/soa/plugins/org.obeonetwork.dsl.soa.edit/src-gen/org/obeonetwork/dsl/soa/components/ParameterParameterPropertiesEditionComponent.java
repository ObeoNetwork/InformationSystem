/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;


// End of user code

/**
 * @author Obeo
 * 
 */
public class ParameterParameterPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String PARAMETER_PART = "Parameter"; //$NON-NLS-1$

	
	/**
	 * Settings for type EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings typeSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ParameterParameterPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject parameter, String editing_mode) {
		super(editingContext, parameter, editing_mode);
		parts = new String[] { PARAMETER_PART };
		repositoryKey = SoaViewsRepository.class;
		partKey = SoaViewsRepository.Parameter.class;
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
			
			final Parameter parameter = (Parameter)elt;
			final ParameterPropertiesEditionPart parameterPart = (ParameterPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(SoaViewsRepository.Parameter.Properties.name))
				parameterPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, parameter.getName()));
			
			if (isAccessible(SoaViewsRepository.Parameter.Properties.multiplicity)) {
				parameterPart.initMultiplicity(EEFUtils.choiceOfValues(parameter, SoaPackage.eINSTANCE.getParameter_Multiplicity()), parameter.getMultiplicity());
			}
			if (isAccessible(SoaViewsRepository.Parameter.Properties.isUnique)) {
				parameterPart.setIsUnique(parameter.isIsUnique());
			}
			if (isAccessible(SoaViewsRepository.Parameter.Properties.isOrdered)) {
				parameterPart.setIsOrdered(parameter.isIsOrdered());
			}
			if (isAccessible(SoaViewsRepository.Parameter.Properties.type)) {
				// init part
				typeSettings = new EObjectFlatComboSettings(parameter, SoaPackage.eINSTANCE.getParameter_Type());
				parameterPart.initType(typeSettings);
				// set the button mode
				parameterPart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(SoaViewsRepository.Parameter.Properties.description))
				parameterPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, parameter.getDescription()));
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
		if (editorKey == SoaViewsRepository.Parameter.Properties.name) {
			return SoaPackage.eINSTANCE.getParameter_Name();
		}
		if (editorKey == SoaViewsRepository.Parameter.Properties.multiplicity) {
			return SoaPackage.eINSTANCE.getParameter_Multiplicity();
		}
		if (editorKey == SoaViewsRepository.Parameter.Properties.isUnique) {
			return SoaPackage.eINSTANCE.getParameter_IsUnique();
		}
		if (editorKey == SoaViewsRepository.Parameter.Properties.isOrdered) {
			return SoaPackage.eINSTANCE.getParameter_IsOrdered();
		}
		if (editorKey == SoaViewsRepository.Parameter.Properties.type) {
			return SoaPackage.eINSTANCE.getParameter_Type();
		}
		if (editorKey == SoaViewsRepository.Parameter.Properties.description) {
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
		Parameter parameter = (Parameter)semanticObject;
		if (SoaViewsRepository.Parameter.Properties.name == event.getAffectedEditor()) {
			parameter.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.Parameter.Properties.multiplicity == event.getAffectedEditor()) {
			parameter.setMultiplicity((MultiplicityKind)event.getNewValue());
		}
		if (SoaViewsRepository.Parameter.Properties.isUnique == event.getAffectedEditor()) {
			parameter.setIsUnique((Boolean)event.getNewValue());
		}
		if (SoaViewsRepository.Parameter.Properties.isOrdered == event.getAffectedEditor()) {
			parameter.setIsOrdered((Boolean)event.getNewValue());
		}
		if (SoaViewsRepository.Parameter.Properties.type == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				typeSettings.setToReference((Type)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, typeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (SoaViewsRepository.Parameter.Properties.description == event.getAffectedEditor()) {
			parameter.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ParameterPropertiesEditionPart parameterPart = (ParameterPropertiesEditionPart)editingPart;
			if (SoaPackage.eINSTANCE.getParameter_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && parameterPart != null && isAccessible(SoaViewsRepository.Parameter.Properties.name)) {
				if (msg.getNewValue() != null) {
					parameterPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					parameterPart.setName("");
				}
			}
			if (SoaPackage.eINSTANCE.getParameter_Multiplicity().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(SoaViewsRepository.Parameter.Properties.multiplicity))
				parameterPart.setMultiplicity((MultiplicityKind)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getParameter_IsUnique().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && parameterPart != null && isAccessible(SoaViewsRepository.Parameter.Properties.isUnique))
				parameterPart.setIsUnique((Boolean)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getParameter_IsOrdered().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && parameterPart != null && isAccessible(SoaViewsRepository.Parameter.Properties.isOrdered))
				parameterPart.setIsOrdered((Boolean)msg.getNewValue());
			
			if (SoaPackage.eINSTANCE.getParameter_Type().equals(msg.getFeature()) && parameterPart != null && isAccessible(SoaViewsRepository.Parameter.Properties.type))
				parameterPart.setType((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && parameterPart != null && isAccessible(SoaViewsRepository.Parameter.Properties.description)){
				if (msg.getNewValue() != null) {
					parameterPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					parameterPart.setDescription("");
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
			SoaPackage.eINSTANCE.getParameter_Name(),
			SoaPackage.eINSTANCE.getParameter_Multiplicity(),
			SoaPackage.eINSTANCE.getParameter_IsUnique(),
			SoaPackage.eINSTANCE.getParameter_IsOrdered(),
			SoaPackage.eINSTANCE.getParameter_Type(),
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
		return key == SoaViewsRepository.Parameter.Properties.multiplicity;
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
				if (SoaViewsRepository.Parameter.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getParameter_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getParameter_Name().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Parameter.Properties.multiplicity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getParameter_Multiplicity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getParameter_Multiplicity().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Parameter.Properties.isUnique == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getParameter_IsUnique().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getParameter_IsUnique().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Parameter.Properties.isOrdered == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(SoaPackage.eINSTANCE.getParameter_IsOrdered().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(SoaPackage.eINSTANCE.getParameter_IsOrdered().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.Parameter.Properties.description == event.getAffectedEditor()) {
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
