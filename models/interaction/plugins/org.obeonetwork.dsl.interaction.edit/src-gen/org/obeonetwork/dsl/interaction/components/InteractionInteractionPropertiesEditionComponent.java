/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.components;

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
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.parts.InteractionPropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class InteractionInteractionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INTERACTION_PART = "Interaction"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public InteractionInteractionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject interaction, String editing_mode) {
		super(editingContext, interaction, editing_mode);
		parts = new String[] { INTERACTION_PART };
		repositoryKey = InteractionViewsRepository.class;
		partKey = InteractionViewsRepository.Interaction_.class;
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
			
			final Interaction interaction = (Interaction)elt;
			final InteractionPropertiesEditionPart interactionPart = (InteractionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(InteractionViewsRepository.Interaction_.Properties.name))
				interactionPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interaction.getName()));
			
			if (isAccessible(InteractionViewsRepository.Interaction_.Properties.description))
				interactionPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interaction.getDescription()));
			
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
		if (editorKey == InteractionViewsRepository.Interaction_.Properties.name) {
			return InteractionPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == InteractionViewsRepository.Interaction_.Properties.description) {
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
		Interaction interaction = (Interaction)semanticObject;
		if (InteractionViewsRepository.Interaction_.Properties.name == event.getAffectedEditor()) {
			interaction.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (InteractionViewsRepository.Interaction_.Properties.description == event.getAffectedEditor()) {
			interaction.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InteractionPropertiesEditionPart interactionPart = (InteractionPropertiesEditionPart)editingPart;
			if (InteractionPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interactionPart != null && isAccessible(InteractionViewsRepository.Interaction_.Properties.name)) {
				if (msg.getNewValue() != null) {
					interactionPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interactionPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interactionPart != null && isAccessible(InteractionViewsRepository.Interaction_.Properties.description)) {
				if (msg.getNewValue() != null) {
					interactionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interactionPart.setDescription("");
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
			InteractionPackage.eINSTANCE.getNamedElement_Name(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description()		);
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
				if (InteractionViewsRepository.Interaction_.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (InteractionViewsRepository.Interaction_.Properties.description == event.getAffectedEditor()) {
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
