/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.components;

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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class TypeInstancePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TYPEINSTANCE_PART = "TypeInstance"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public TypeInstancePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject typeInstance, String editing_mode) {
		super(editingContext, typeInstance, editing_mode);
		parts = new String[] { TYPEINSTANCE_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.TypeInstance.class;
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
			
			final TypeInstance typeInstance = (TypeInstance)elt;
			final TypeInstancePropertiesEditionPart typeInstancePart = (TypeInstancePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.type)) {
				typeInstancePart.initType(EEFUtils.choiceOfValues(typeInstance, TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType()), typeInstance.getNativeType());
			}
			if (isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length))
				typeInstancePart.setLength(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, typeInstance.getLength()));
			
			if (isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision))
				typeInstancePart.setPrecision(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, typeInstance.getPrecision()));
			
			if (isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.literals))
				typeInstancePart.setLiterals(typeInstance.getLiterals());
			
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
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == TypeslibraryViewsRepository.TypeInstance.Properties.type) {
			return TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType();
		}
		if (editorKey == TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length) {
			return TypesLibraryPackage.eINSTANCE.getTypeInstance_Length();
		}
		if (editorKey == TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision) {
			return TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision();
		}
		if (editorKey == TypeslibraryViewsRepository.TypeInstance.Properties.literals) {
			return TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		TypeInstance typeInstance = (TypeInstance)semanticObject;
		if (TypeslibraryViewsRepository.TypeInstance.Properties.type == event.getAffectedEditor()) {
			typeInstance.setNativeType(!"".equals(event.getNewValue()) ? (NativeType) event.getNewValue() : null);
		}
		if (TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length == event.getAffectedEditor()) {
			typeInstance.setLength((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
			typeInstance.setPrecision((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.TypeInstance.Properties.literals == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				typeInstance.getLiterals().clear();
				typeInstance.getLiterals().addAll(((EList) event.getNewValue()));
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
			TypeInstancePropertiesEditionPart typeInstancePart = (TypeInstancePropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && typeInstancePart != null && isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.type))
				typeInstancePart.setType((Object)msg.getNewValue());
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && typeInstancePart != null && isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length)) {
				if (msg.getNewValue() != null) {
					typeInstancePart.setLength(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					typeInstancePart.setLength("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && typeInstancePart != null && isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision)) {
				if (msg.getNewValue() != null) {
					typeInstancePart.setPrecision(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					typeInstancePart.setPrecision("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && typeInstancePart != null && isAccessible(TypeslibraryViewsRepository.TypeInstance.Properties.literals)) {
				if (msg.getNewValue() instanceof EList<?>) {
					typeInstancePart.setLiterals((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					typeInstancePart.setLiterals(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					typeInstancePart.setLiterals(newValueAsList);
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
			TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType(),
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Length(),
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision(),
			TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == TypeslibraryViewsRepository.TypeInstance.Properties.type;
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
				if (TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), newValue);
				}
				if (TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), newValue);
				}
				if (TypeslibraryViewsRepository.TypeInstance.Properties.literals == event.getAffectedEditor()) {
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


	

	

}
