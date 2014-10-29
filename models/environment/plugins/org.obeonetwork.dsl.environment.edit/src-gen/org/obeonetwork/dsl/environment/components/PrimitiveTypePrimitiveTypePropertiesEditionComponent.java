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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.PrimitiveTypePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class PrimitiveTypePrimitiveTypePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String PRIMITIVETYPE_PART = "PrimitiveType"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public PrimitiveTypePrimitiveTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject primitiveType, String editing_mode) {
		super(editingContext, primitiveType, editing_mode);
		parts = new String[] { PRIMITIVETYPE_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.PrimitiveType.class;
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
			
			final PrimitiveType primitiveType = (PrimitiveType)elt;
			final PrimitiveTypePropertiesEditionPart primitiveTypePart = (PrimitiveTypePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.PrimitiveType.Properties.name))
				primitiveTypePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, primitiveType.getName()));
			
			if (isAccessible(EnvironmentViewsRepository.PrimitiveType.Properties.description))
				primitiveTypePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, primitiveType.getDescription()));
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
		if (editorKey == EnvironmentViewsRepository.PrimitiveType.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == EnvironmentViewsRepository.PrimitiveType.Properties.description) {
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
		PrimitiveType primitiveType = (PrimitiveType)semanticObject;
		if (EnvironmentViewsRepository.PrimitiveType.Properties.name == event.getAffectedEditor()) {
			primitiveType.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.PrimitiveType.Properties.description == event.getAffectedEditor()) {
			primitiveType.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PrimitiveTypePropertiesEditionPart primitiveTypePart = (PrimitiveTypePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && primitiveTypePart != null && isAccessible(EnvironmentViewsRepository.PrimitiveType.Properties.name)) {
				if (msg.getNewValue() != null) {
					primitiveTypePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					primitiveTypePart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && primitiveTypePart != null && isAccessible(EnvironmentViewsRepository.PrimitiveType.Properties.description)){
				if (msg.getNewValue() != null) {
					primitiveTypePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					primitiveTypePart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getType_Name(),
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
		return key == EnvironmentViewsRepository.PrimitiveType.Properties.name;
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
				if (EnvironmentViewsRepository.PrimitiveType.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.PrimitiveType.Properties.description == event.getAffectedEditor()) {
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
