/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.components;

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
import org.obeonetwork.dsl.typeslibrary.SimpleNamedType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.SimpleNamedTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class SimpleNamedTypePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SIMPLENAMEDTYPE_PART = "SimpleNamedType"; //$NON-NLS-1$

	
	/**
	 * Settings for type EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings typeSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SimpleNamedTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject simpleNamedType, String editing_mode) {
		super(editingContext, simpleNamedType, editing_mode);
		parts = new String[] { SIMPLENAMEDTYPE_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.SimpleNamedType.class;
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
			final SimpleNamedType simpleNamedType = (SimpleNamedType)elt;
			final SimpleNamedTypePropertiesEditionPart simpleNamedTypePart = (SimpleNamedTypePropertiesEditionPart)editingPart;
			// init values
			if (simpleNamedType.getName() != null && isAccessible(TypeslibraryViewsRepository.SimpleNamedType.Properties.name))
				simpleNamedTypePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, simpleNamedType.getName()));
			
			if (isAccessible(TypeslibraryViewsRepository.SimpleNamedType.Properties.type)) {
				// init part
				typeSettings = new EObjectFlatComboSettings(simpleNamedType, TypesLibraryPackage.eINSTANCE.getSimpleNamedType_Type());
				simpleNamedTypePart.initType(typeSettings);
				// set the button mode
				simpleNamedTypePart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			if (isAccessible(TypeslibraryViewsRepository.SimpleNamedType.Properties.type)) {
				simpleNamedTypePart.addFilterToType(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof TypeInstance);
					}
					
				});
				// Start of user code for additional businessfilters for type
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
		if (editorKey == TypeslibraryViewsRepository.SimpleNamedType.Properties.name) {
			return TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name();
		}
		if (editorKey == TypeslibraryViewsRepository.SimpleNamedType.Properties.type) {
			return TypesLibraryPackage.eINSTANCE.getSimpleNamedType_Type();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SimpleNamedType simpleNamedType = (SimpleNamedType)semanticObject;
		if (TypeslibraryViewsRepository.SimpleNamedType.Properties.name == event.getAffectedEditor()) {
			simpleNamedType.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.SimpleNamedType.Properties.type == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				typeSettings.setToReference((TypeInstance)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				TypeInstance eObject = TypesLibraryFactory.eINSTANCE.createTypeInstance();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				typeSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			SimpleNamedTypePropertiesEditionPart simpleNamedTypePart = (SimpleNamedTypePropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().equals(msg.getFeature()) && simpleNamedTypePart != null && isAccessible(TypeslibraryViewsRepository.SimpleNamedType.Properties.name)) {
				if (msg.getNewValue() != null) {
					simpleNamedTypePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					simpleNamedTypePart.setName("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getSimpleNamedType_Type().equals(msg.getFeature()) && simpleNamedTypePart != null && isAccessible(TypeslibraryViewsRepository.SimpleNamedType.Properties.type))
				simpleNamedTypePart.setType((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == TypeslibraryViewsRepository.SimpleNamedType.Properties.type;
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
				if (TypeslibraryViewsRepository.SimpleNamedType.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().getEAttributeType(), newValue);
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
