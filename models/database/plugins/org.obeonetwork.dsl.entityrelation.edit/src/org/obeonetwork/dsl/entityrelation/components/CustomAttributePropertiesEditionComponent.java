package org.obeonetwork.dsl.entityrelation.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;

public class CustomAttributePropertiesEditionComponent extends AttributePropertiesEditionComponent {

	protected EEFEditorSettingsImpl typeSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType())
																			.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Type())			
																				.index(0)			
																				.discriminator(TypesLibraryPackage.eINSTANCE.getTypeInstance())
																				.build())
																			.build();
	
	public CustomAttributePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject attribute, String editing_mode) {
		super(editingContext, attribute, editing_mode);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		super.initPart(key, kind, elt, allResource);
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final AttributePropertiesEditionPart basePart = (AttributePropertiesEditionPart)editingPart;
			
			final Attribute columnObject = (Attribute)elt;
			if (columnObject.getType() != null && columnObject.getType() instanceof TypeInstance) {
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.type)) {
					basePart.initType(allResource, typeSettings.getValue());
				}
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.literals)) {
					basePart.setLiterals((EList)literalsSettings.getValue());
				}
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length)) {
					basePart.setLength(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), lengthSettings.getValue()));
				}
				
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision)) {
					basePart.setPrecision(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), precisionSettings.getValue()));
				}
			} else {
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.type)) {
					basePart.initType(allResource, null);
				}
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.literals)) {
					basePart.setLiterals(null);
				}
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length)) {
					basePart.setLength(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), null));
				}
				
				if (isAccessible(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision)) {
					basePart.setPrecision(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), null));
				}
			}
			
			basePart.addFilterToType(new ViewerFilter() {
				
				private TypesLibraryUser getTypesLibraryUserFromParents(EObject object) {
					if (object.eContainer() != null) {
						if (object.eContainer() instanceof TypesLibraryUser) {
							return (TypesLibraryUser)object.eContainer();
						} else {
							return getTypesLibraryUserFromParents(object.eContainer());
						}
					}
					return null;
				}
				
				private Collection<NativeTypesLibrary> getNativeTypesLibraries(TypesLibraryUser librariesUser) {
					Collection<NativeTypesLibrary> nativeTypesLibraries = new ArrayList<NativeTypesLibrary>();
					if (librariesUser != null) {
						for (TypesLibrary typesLibrary : librariesUser.getUsedLibraries()) {
							if (typesLibrary instanceof NativeTypesLibrary) {
								nativeTypesLibraries.add((NativeTypesLibrary)typesLibrary);
							}
						}
					}
						
					return nativeTypesLibraries;
				}
				
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					TypesLibraryUser typesUser = getTypesLibraryUserFromParents(columnObject);
					Collection<NativeTypesLibrary> libraries = getNativeTypesLibraries(typesUser);
					if (libraries.isEmpty() == false) {
						for (NativeTypesLibrary nativeTypesLibrary : libraries) {
							if (nativeTypesLibrary.getNativeTypes().contains(element)) {
								return true;
							}
						}
						return false;
					}
					return true;
				}
			});
			
			updateTypeFieldsVisibility((Attribute)elt, basePart);
		}
		setInitializing(false);
	}
	
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		Attribute attributeObject = (Attribute)semanticObject;
		if (attributeObject.getType() != null && attributeObject.getType() instanceof TypeInstance) {
			if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.type) {
				return (typeSettings.getValue() == null) ? (event.getNewValue() != null) : (!typeSettings.getValue().equals(event.getNewValue()));
			}
			if (event.getAffectedEditor() == EntityrelationViewsRepository.Attribute.Properties.literals) {
				return (literalsSettings.getValue() == null) ? (event.getNewValue() != null) : (!literalsSettings.getValue().equals(event.getNewValue()));
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
		}
		
		return true;
	}	

	@Override
	public void updateSemanticModel(IPropertiesEditionEvent event) {
		Attribute attributeObject = (Attribute)semanticObject;
		
		if (EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier == event.getAffectedEditor()) {
			if (Boolean.TRUE.equals(event.getNewValue())) {
				attributeObject.addToPrimaryIdentifier();
			} else {
				attributeObject.removeFromPrimaryIdentifier();
			}
		}
		if (EntityrelationViewsRepository.Attribute.Properties.type == event.getAffectedEditor()) {
			if (attributeObject.getType() == null) {
				TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
				typeInstance.setNativeType((NativeType)event.getNewValue());
				attributeObject.setType(typeInstance);
			}
			typeSettings.setValue((NativeType)event.getNewValue());
		}
		if (EntityrelationViewsRepository.Attribute.Properties.literals == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				literalsSettings.setValue((List) event.getNewValue());
			}
		}
		
		if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length == event.getAffectedEditor()) {
			if (attributeObject.getType() != null) {
				String newValue = (String)event.getNewValue();
				if (newValue.trim().equals("")) {
					lengthSettings.setValue(0);
				} else {
					lengthSettings.setValue((EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), newValue)));
				}
			}
			return;
		}
		if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
			if (attributeObject.getType() != null) {
				String newValue = (String)event.getNewValue();
				if (newValue.trim().equals("")) {
					precisionSettings.setValue(0);
				} else {
					precisionSettings.setValue((EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), newValue)));
				}
			}
			return;
		}
		super.updateSemanticModel(event);
	}

	@Override
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AttributePropertiesEditionPart basePart = (AttributePropertiesEditionPart)editingPart;
			if (EntityRelationPackage.eINSTANCE.getAttribute_InPrimaryIdentifier().equals(msg.getFeature()) && basePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier))
				if (msg.getNotifier() instanceof Attribute) {
					basePart.setInPrimaryIdentifier(((Attribute)msg.getNotifier()).isInPrimaryIdentifier());		
				}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().equals(msg.getFeature()) && basePart != null && isAccessible(EntityrelationViewsRepository.Attribute.Properties.literals)) {
				basePart.setLiterals((EList)msg.getNewValue());
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType().equals((msg.getFeature()))) {
				updateTypeFieldsVisibility((Attribute)semanticObject, basePart);
			}
		}
	}
	
	private void updateTypeFieldsVisibility(Attribute column, AttributePropertiesEditionPart basePart) {
		if (column.getType() instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance)column.getType();
			if (typeInstance.getNativeType() != null) {
				NativeTypeKind nativeTypeKind = typeInstance.getNativeType().getSpec();
				boolean lengthVisible = (nativeTypeKind == NativeTypeKind.LENGTH || nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
				boolean precisionVisible = (nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
				boolean literalsVisible = (nativeTypeKind == NativeTypeKind.ENUM);
				basePart.updateTypeFields(lengthVisible, precisionVisible, literalsVisible);
			}
		}		
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
				/**
				 * We have to change the behaviour to avoid NumberFormatException when no value has been provided for length or precision fields
				 */
				if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						if (((String) newValue).trim().equals("")) {
							newValue = null;
						} else {
							newValue = EcoreUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), (String)newValue);
						}
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), newValue);
					return ret;
				}
				if (EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						if (((String) newValue).trim().equals("")) {
							newValue = null;
						} else {
							newValue = EcoreUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), (String)newValue);
						}
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), newValue);
					return ret;
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return super.validateValue(event);
	}
}
