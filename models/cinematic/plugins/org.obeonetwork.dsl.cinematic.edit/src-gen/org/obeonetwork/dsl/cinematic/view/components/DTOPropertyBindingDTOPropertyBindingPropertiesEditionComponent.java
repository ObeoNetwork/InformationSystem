/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.components;

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
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.parts.DTOPropertyBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Property;


// End of user code

/**
 * 
 * 
 */
public class DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String DTOPROPERTYBINDING_PART = "DTOPropertyBinding"; //$NON-NLS-1$

	
	/**
	 * Settings for property EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings propertySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DTOPropertyBindingDTOPropertyBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dTOPropertyBinding, String editing_mode) {
		super(editingContext, dTOPropertyBinding, editing_mode);
		parts = new String[] { DTOPROPERTYBINDING_PART };
		repositoryKey = ViewViewsRepository.class;
		partKey = ViewViewsRepository.DTOPropertyBinding.class;
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
			final DTOPropertyBinding dTOPropertyBinding = (DTOPropertyBinding)elt;
			final DTOPropertyBindingPropertiesEditionPart dTOPropertyBindingPart = (DTOPropertyBindingPropertiesEditionPart)editingPart;
			// init values
			if (dTOPropertyBinding.getDescription() != null && isAccessible(ViewViewsRepository.DTOPropertyBinding.Properties.description))
				dTOPropertyBindingPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dTOPropertyBinding.getDescription()));
			
			if (isAccessible(ViewViewsRepository.DTOPropertyBinding.Properties.property)) {
				// init part
				propertySettings = new EObjectFlatComboSettings(dTOPropertyBinding, ViewPackage.eINSTANCE.getDTOPropertyBinding_Property());
				dTOPropertyBindingPart.initProperty(propertySettings);
				// set the button mode
				dTOPropertyBindingPart.setPropertyButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			if (isAccessible(ViewViewsRepository.DTOPropertyBinding.Properties.property)) {
				dTOPropertyBindingPart.addFilterToProperty(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Property);
					}
					
				});
				// Start of user code for additional businessfilters for property
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
		if (editorKey == ViewViewsRepository.DTOPropertyBinding.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == ViewViewsRepository.DTOPropertyBinding.Properties.property) {
			return ViewPackage.eINSTANCE.getDTOPropertyBinding_Property();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DTOPropertyBinding dTOPropertyBinding = (DTOPropertyBinding)semanticObject;
		if (ViewViewsRepository.DTOPropertyBinding.Properties.description == event.getAffectedEditor()) {
			dTOPropertyBinding.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.DTOPropertyBinding.Properties.property == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				propertySettings.setToReference((Property)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, propertySettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			DTOPropertyBindingPropertiesEditionPart dTOPropertyBindingPart = (DTOPropertyBindingPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && dTOPropertyBindingPart != null && isAccessible(ViewViewsRepository.DTOPropertyBinding.Properties.description)) {
				if (msg.getNewValue() != null) {
					dTOPropertyBindingPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					dTOPropertyBindingPart.setDescription("");
				}
			}
			if (ViewPackage.eINSTANCE.getDTOPropertyBinding_Property().equals(msg.getFeature()) && dTOPropertyBindingPart != null && isAccessible(ViewViewsRepository.DTOPropertyBinding.Properties.property))
				dTOPropertyBindingPart.setProperty((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ViewViewsRepository.DTOPropertyBinding.Properties.property;
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
				if (ViewViewsRepository.DTOPropertyBinding.Properties.description == event.getAffectedEditor()) {
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
