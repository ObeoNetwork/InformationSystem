/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.components;

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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.SystemPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SystemSystemPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SYSTEM_PART = "System"; //$NON-NLS-1$

	
	/**
	 * Settings for namespaces ReferencesTable
	 */
	private ReferencesTableSettings namespacesSettings;
	
	/**
	 * Settings for types ReferencesTable
	 */
	private ReferencesTableSettings typesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SystemSystemPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject system, String editing_mode) {
		super(editingContext, system, editing_mode);
		parts = new String[] { SYSTEM_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.System.class;
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
			
			final System system = (System)elt;
			final SystemPropertiesEditionPart systemPart = (SystemPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.System.Properties.description))
				systemPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, system.getDescription()));
			if (isAccessible(GraalViewsRepository.System.Properties.name))
				systemPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, system.getName()));
			
			if (isAccessible(GraalViewsRepository.System.Properties.namespaces)) {
				namespacesSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces());
				systemPart.initNamespaces(namespacesSettings);
			}
			if (isAccessible(GraalViewsRepository.System.Properties.types)) {
				typesSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_Types());
				systemPart.initTypes(typesSettings);
			}
			// init filters
			
			
			if (isAccessible(GraalViewsRepository.System.Properties.namespaces)) {
				systemPart.addFilterToNamespaces(new EObjectFilter(EnvironmentPackage.Literals.NAMESPACE));
				// Start of user code for additional businessfilters for namespaces
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.System.Properties.types)) {
				systemPart.addFilterToTypes(new EObjectFilter(EnvironmentPackage.Literals.STRUCTURED_TYPE));
				// Start of user code for additional businessfilters for types
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
		if (editorKey == GraalViewsRepository.System.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.System.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == GraalViewsRepository.System.Properties.namespaces) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces();
		}
		if (editorKey == GraalViewsRepository.System.Properties.types) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Types();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		System system = (System)semanticObject;
		if (GraalViewsRepository.System.Properties.description == event.getAffectedEditor()) {
			system.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.System.Properties.name == event.getAffectedEditor()) {
			system.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.System.Properties.namespaces == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Namespace) {
					namespacesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				namespacesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				namespacesSettings.move(event.getNewIndex(), (Namespace) event.getNewValue());
			}
		}
		if (GraalViewsRepository.System.Properties.types == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof StructuredType) {
					typesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				typesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				typesSettings.move(event.getNewIndex(), (StructuredType) event.getNewValue());
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
			SystemPropertiesEditionPart systemPart = (SystemPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && systemPart != null && isAccessible(GraalViewsRepository.System.Properties.description)){
				if (msg.getNewValue() != null) {
					systemPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					systemPart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && systemPart != null && isAccessible(GraalViewsRepository.System.Properties.name)) {
				if (msg.getNewValue() != null) {
					systemPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					systemPart.setName("");
				}
			}
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.namespaces))
				systemPart.updateNamespaces();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Types().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.types))
				systemPart.updateTypes();
			
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			GraalPackage.eINSTANCE.getNamedElement_Name(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_Types()		);
		return new NotificationFilter[] {filter,};
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
				if (GraalViewsRepository.System.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.System.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
