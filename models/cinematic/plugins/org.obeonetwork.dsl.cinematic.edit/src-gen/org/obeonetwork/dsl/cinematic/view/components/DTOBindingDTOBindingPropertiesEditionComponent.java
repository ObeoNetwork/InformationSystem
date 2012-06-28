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
import org.obeonetwork.dsl.cinematic.view.DTOBinding;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.parts.DTOBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.dsl.soa.SoaFactory;


// End of user code

/**
 * 
 * 
 */
public class DTOBindingDTOBindingPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String DTOBINDING_PART = "DTOBinding"; //$NON-NLS-1$

	
	/**
	 * Settings for dto EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings dtoSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DTOBindingDTOBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dTOBinding, String editing_mode) {
		super(editingContext, dTOBinding, editing_mode);
		parts = new String[] { DTOBINDING_PART };
		repositoryKey = ViewViewsRepository.class;
		partKey = ViewViewsRepository.DTOBinding.class;
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
			final DTOBinding dTOBinding = (DTOBinding)elt;
			final DTOBindingPropertiesEditionPart dTOBindingPart = (DTOBindingPropertiesEditionPart)editingPart;
			// init values
			if (dTOBinding.getDescription() != null && isAccessible(ViewViewsRepository.DTOBinding.Properties.description))
				dTOBindingPart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dTOBinding.getDescription()));
			
			if (isAccessible(ViewViewsRepository.DTOBinding.Properties.dto)) {
				// init part
				dtoSettings = new EObjectFlatComboSettings(dTOBinding, ViewPackage.eINSTANCE.getDTOBinding_Dto());
				dTOBindingPart.initDto(dtoSettings);
				// set the button mode
				dTOBindingPart.setDtoButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			if (isAccessible(ViewViewsRepository.DTOBinding.Properties.dto)) {
				dTOBindingPart.addFilterToDto(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof ServiceDTO);
					}
					
				});
				// Start of user code for additional businessfilters for dto
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
		if (editorKey == ViewViewsRepository.DTOBinding.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == ViewViewsRepository.DTOBinding.Properties.dto) {
			return ViewPackage.eINSTANCE.getDTOBinding_Dto();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DTOBinding dTOBinding = (DTOBinding)semanticObject;
		if (ViewViewsRepository.DTOBinding.Properties.description == event.getAffectedEditor()) {
			dTOBinding.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ViewViewsRepository.DTOBinding.Properties.dto == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dtoSettings.setToReference((ServiceDTO)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				ServiceDTO eObject = SoaFactory.eINSTANCE.createServiceDTO();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				dtoSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			DTOBindingPropertiesEditionPart dTOBindingPart = (DTOBindingPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && dTOBindingPart != null && isAccessible(ViewViewsRepository.DTOBinding.Properties.description)) {
				if (msg.getNewValue() != null) {
					dTOBindingPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					dTOBindingPart.setDescription("");
				}
			}
			if (ViewPackage.eINSTANCE.getDTOBinding_Dto().equals(msg.getFeature()) && dTOBindingPart != null && isAccessible(ViewViewsRepository.DTOBinding.Properties.dto))
				dTOBindingPart.setDto((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ViewViewsRepository.DTOBinding.Properties.dto;
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
				if (ViewViewsRepository.DTOBinding.Properties.description == event.getAffectedEditor()) {
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
