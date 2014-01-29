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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class InteractionUseInteractionUsePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INTERACTIONUSE_PART = "InteractionUse"; //$NON-NLS-1$

	
	/**
	 * Settings for interaction EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings interactionSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public InteractionUseInteractionUsePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject interactionUse, String editing_mode) {
		super(editingContext, interactionUse, editing_mode);
		parts = new String[] { INTERACTIONUSE_PART };
		repositoryKey = InteractionViewsRepository.class;
		partKey = InteractionViewsRepository.InteractionUse.class;
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
			
			final InteractionUse interactionUse = (InteractionUse)elt;
			final InteractionUsePropertiesEditionPart interactionUsePart = (InteractionUsePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(InteractionViewsRepository.InteractionUse.Properties.name))
				interactionUsePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interactionUse.getName()));
			
			if (isAccessible(InteractionViewsRepository.InteractionUse.Properties.type))
				interactionUsePart.setType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interactionUse.getType()));
			
			if (isAccessible(InteractionViewsRepository.InteractionUse.Properties.interaction_)) {
				// init part
				interactionSettings = new EObjectFlatComboSettings(interactionUse, InteractionPackage.eINSTANCE.getInteractionUse_Interaction());
				interactionUsePart.initInteraction(interactionSettings);
				// set the button mode
				interactionUsePart.setInteractionButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(InteractionViewsRepository.InteractionUse.Properties.description))
				interactionUsePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interactionUse.getDescription()));
			
			// init filters
			
			
			if (isAccessible(InteractionViewsRepository.InteractionUse.Properties.interaction_)) {
				interactionUsePart.addFilterToInteraction(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Interaction);
					}
					
				});
				// Start of user code for additional businessfilters for interaction
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
		if (editorKey == InteractionViewsRepository.InteractionUse.Properties.name) {
			return InteractionPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == InteractionViewsRepository.InteractionUse.Properties.type) {
			return InteractionPackage.eINSTANCE.getInteractionUse_Type();
		}
		if (editorKey == InteractionViewsRepository.InteractionUse.Properties.interaction_) {
			return InteractionPackage.eINSTANCE.getInteractionUse_Interaction();
		}
		if (editorKey == InteractionViewsRepository.InteractionUse.Properties.description) {
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
		InteractionUse interactionUse = (InteractionUse)semanticObject;
		if (InteractionViewsRepository.InteractionUse.Properties.name == event.getAffectedEditor()) {
			interactionUse.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (InteractionViewsRepository.InteractionUse.Properties.type == event.getAffectedEditor()) {
			interactionUse.setType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (InteractionViewsRepository.InteractionUse.Properties.interaction_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				interactionSettings.setToReference((Interaction)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Interaction eObject = InteractionFactory.eINSTANCE.createInteraction();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				interactionSettings.setToReference(eObject);
			}
		}
		if (InteractionViewsRepository.InteractionUse.Properties.description == event.getAffectedEditor()) {
			interactionUse.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InteractionUsePropertiesEditionPart interactionUsePart = (InteractionUsePropertiesEditionPart)editingPart;
			if (InteractionPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interactionUsePart != null && isAccessible(InteractionViewsRepository.InteractionUse.Properties.name)) {
				if (msg.getNewValue() != null) {
					interactionUsePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interactionUsePart.setName("");
				}
			}
			if (InteractionPackage.eINSTANCE.getInteractionUse_Type().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interactionUsePart != null && isAccessible(InteractionViewsRepository.InteractionUse.Properties.type)) {
				if (msg.getNewValue() != null) {
					interactionUsePart.setType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interactionUsePart.setType("");
				}
			}
			if (InteractionPackage.eINSTANCE.getInteractionUse_Interaction().equals(msg.getFeature()) && interactionUsePart != null && isAccessible(InteractionViewsRepository.InteractionUse.Properties.interaction_))
				interactionUsePart.setInteraction((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interactionUsePart != null && isAccessible(InteractionViewsRepository.InteractionUse.Properties.description)) {
				if (msg.getNewValue() != null) {
					interactionUsePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interactionUsePart.setDescription("");
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
			InteractionPackage.eINSTANCE.getInteractionUse_Type(),
			InteractionPackage.eINSTANCE.getInteractionUse_Interaction(),
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
		return key == InteractionViewsRepository.InteractionUse.Properties.type || key == InteractionViewsRepository.InteractionUse.Properties.interaction_;
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
				if (InteractionViewsRepository.InteractionUse.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(InteractionPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (InteractionViewsRepository.InteractionUse.Properties.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(InteractionPackage.eINSTANCE.getInteractionUse_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(InteractionPackage.eINSTANCE.getInteractionUse_Type().getEAttributeType(), newValue);
				}
				if (InteractionViewsRepository.InteractionUse.Properties.description == event.getAffectedEditor()) {
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
